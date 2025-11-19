package battle;

import java.util.*;
//import java.util.Scanner;
import characters.Character;

public class Battle {
    private Character player1;
    private Character player2;
    private boolean isPVC;
    private Random random = new Random();

    //store cooldowns
    private Map<Character, int[]> cooldowns = new HashMap<>();

    public Battle(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.isPVC = false;

        cooldowns.put(player1, new int[]{0,0});
        cooldowns.put(player2, new int[]{0, 0});
    }

    public Battle(Character player1, Character enemy, boolean isPVC) {
        this.player1 = player1;
        this.player2 = enemy;
        this.isPVC = isPVC;

        cooldowns.put(player1, new int[]{0,0});
        cooldowns.put(player2, new int[]{0, 0});
    }

    //player label
    private String getPlayerLabel(Character c) {
        if (c == player1) {
            return "PLAYER 1";
        } else {
            return isPVC ? "COMPUTER" : "PLAYER 2";
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        int player1Wins = 0;
        int player2Wins = 0;

        while (round <= 3 && player1Wins < 2 && player2Wins < 2) {

            // Reset HP and Mana at the start of each round
            player1.restoreHP();
            player2.restoreHP();
            player1.restoreMana();
            player2.restoreMana();

            System.out.println("\n                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ROUND " + round + " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");

            int turn = 1;
            boolean player1Starts = random.nextBoolean();

            //announce who starts
            Character starter = player1Starts ? player1 : player2;
            System.out.println("First Turn: " + getPlayerLabel(starter) + " (" + starter.getName() + ")");

            // Single round battle
            while (player1.isAlive() && player2.isAlive()) {
                Character current, opponent;

                if ((turn % 2 != 0 && player1Starts) || (turn % 2 == 0 && !player1Starts)) {
                    current = player1;
                    opponent = player2;
                } else {
                    current = player2;
                    opponent = player1;
                }

                decrementCooldowns(current);

                System.out.println("\n══════════ ROUND " + round + " - TURN " + turn + " ══════════");
                System.out.println(">>> " + getPlayerLabel(current) + ": " + current.getName() + "'s Turn! <<<");
                showStats();

                // 2. Get Move (Respecting Cooldowns)
                    int move;
                    if (isPVC && current == player2) {
                        move = getComputerMove(current); // AI Logic
                    } else {
                        move = chooseMove(scanner, current); // Player Logic
                    }

                    // 3. Perform Move
                    performMoveWithBanner(current, opponent, move);
                    
                    applyCooldown(current, move);

                // Random mana regen every after turns for each player
                if (turn % 2 == 0) {
                    
                    int p1Regen = 5 + random.nextInt(6); // 5 to 10
                    int p2Regen = 5 + random.nextInt(6); // 5 to 10

                    
                    player1.addMana(p1Regen);
                    player2.addMana(p2Regen);

                    System.out.println("\n> Mana Regen: " + player1.getName() + " +" + p1Regen + " | " + player2.getName() + " +" + p2Regen);
                }

                turn++;
            }


            // Round end
            if (player1.isAlive()) {
                player1Wins++;
                System.out.println("\nROUND " + round + " WINNER: " + player1.getName());
            } else if (player2.isAlive()) {
                player2Wins++;
                System.out.println("\nROUND " + round + " WINNER: " + player2.getName());
            } else {
                System.out.println("\nROUND " + round + " IS A DRAW!");
            }

            System.out.println("Score: " + player1.getName() + " " + player1Wins + " - " + player2Wins + " " + player2.getName());
            
            // Only go to next round if no one has 2 wins yet
            if (player1Wins == 2 || player2Wins == 2) break;

            round++;
        }

    // Match winner
    System.out.println("\n──────────────────────── MATCH END ────────────────────────");
    if (player1Wins > player2Wins) {
        System.out.println("OVERALL WINNER: " + player1.getName() + "!");
    } else {
        System.out.println("OVERALL WINNER: " + player2.getName() + "!");
    }
}

    // --- COOLDOWN HELPERS ---

    private void decrementCooldowns(Character c) {
        int[] cds = cooldowns.get(c);
        if (cds[0] > 0) cds[0]--; // Decrease Secondary CD
        if (cds[1] > 0) cds[1]--; // Decrease Ultimate CD
    }

    private void applyCooldown(Character c, int move) {
        int[] cds = cooldowns.get(c);
        if (move == 2) {
            cds[0] = 3; // Secondary Skill: 3 Turns
        } else if (move == 3) {
            cds[1] = 5; // Ultimate Skill: 5 Turns
        }
    }

    private int getComputerMove(Character computer) {
        int[] cds = cooldowns.get(computer);
        List<Integer> validMoves = new ArrayList<>();
        
        // Basic attack is always available
        validMoves.add(1);

        // Check Secondary (Index 0)
        if (cds[0] == 0 && computer.getCurrentMana() >= computer.getSecondaryManaCost()) {
            validMoves.add(2);
        }
        // Check Ultimate (Index 1)
        if (cds[1] == 0 && computer.getCurrentMana() >= computer.getUltimateManaCost()) {
            validMoves.add(3);
        }

        // Pick a random valid move
        return validMoves.get(random.nextInt(validMoves.size()));
    }

    private int chooseMove(Scanner scanner, Character player) {
        int[] cds = cooldowns.get(player);
        boolean validChoice = false;
        int choice = 1;

        while (!validChoice) {
            System.out.println("Choose a move:");
            System.out.println();

            // Basic Attack (Always Ready)
            System.out.println("[1] Basic Attack - " + player.getBasicSkillName());
            System.out.println("     Mana Cost: " + player.getBasicManaCost() +
                            " | Damage: " + player.getBasicMinDmg() + "-" + player.getBasicMaxDmg());

            // Secondary Skill
            String secStatus = (cds[0] > 0) ? " (COOLDOWN: " + cds[0] + " turns)" : " (READY)";
            System.out.println("[2] Secondary Skill - " + player.getSecondarySkillName() + secStatus);
            System.out.println("     Mana Cost: " + player.getSecondaryManaCost() +
                            " | Damage: " + player.getSecondaryMinDmg() + "-" + player.getSecondaryMaxDmg());

            // Ultimate Skill
            String ultStatus = (cds[1] > 0) ? " (COOLDOWN: " + cds[1] + " turns)" : " (READY)";
            System.out.println("[3] Ultimate Skill - " + player.getUltimateSkillName() + ultStatus);
            System.out.println("     Mana Cost: " + player.getUltimateManaCost() +
                            " | Damage: " + player.getUltimateMinDmg() + "-" + player.getUltimateMaxDmg());

            System.out.println();
            System.out.print("Enter your choice: ");

            try {
                String input = scanner.next();
                choice = Integer.parseInt(input);

                // VALIDATION LOGIC
                if (choice == 1) {
                    validChoice = true;
                } 
                else if (choice == 2) {
                    if (cds[0] > 0) {
                        System.out.println("\n>>> That skill is on cooldown! Wait " + cds[0] + " more turns. <<<\n");
                    } else if (player.getCurrentMana() < player.getSecondaryManaCost()) {
                        System.out.println("\n>>> Not enough Mana! <<<\n");
                    } else {
                        validChoice = true;
                    }
                } 
                else if (choice == 3) {
                    if (cds[1] > 0) {
                        System.out.println("\n>>> That skill is on cooldown! Wait " + cds[1] + " more turns. <<<\n");
                    } else if (player.getCurrentMana() < player.getUltimateManaCost()) {
                        System.out.println("\n>>> Not enough Mana! <<<\n");
                    } else {
                        validChoice = true;
                    }
                } else {
                    System.out.println("\nInvalid input. Please choose 1, 2, or 3.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Numbers only.\n");
            }
        }
        System.out.println();
        return choice;
    }

    private void performMoveWithBanner(Character attacker, Character defender, int move) {
        int beforeHP = defender.getHealth();
        String moveBannerName;

        switch (move) {
            case 1:
                moveBannerName = attacker.getBasicSkillName();
                attacker.basicAttack(defender);
                break;
            case 2:
                moveBannerName = attacker.getSecondarySkillName();
                attacker.secondarySkill(defender);
                break;
            case 3:
                moveBannerName = attacker.getUltimateSkillName();
                attacker.ultimateSkill(defender);
                break;
            default:
                moveBannerName = attacker.getBasicSkillName();;
                attacker.basicAttack(defender);
                break;
        }

        int damage = Math.max(0, beforeHP - defender.getHealth());

        System.out.println();
        System.out.println("^ " + attacker.getName() + " used " + moveBannerName + "!");
        if (damage > 0) {
            System.out.println("^ " + defender.getName() + " took " + damage + " damage!");
        } else {
            System.out.println("^ " + defender.getName() + " dodged the attack!");
        }
        System.out.println("");
    }

    private void showStats() {
        System.out.println("\n******************--- STATUS ---*********************");

        System.out.println(getPlayerLabel(player1) + ": " + player1.getName() + 
                ": HP " + player1.getHealth() + "/" + player1.getMaxHealth() +
                " | Mana " + player1.getCurrentMana() + "/" + player1.getMaxMana());

        System.out.println(getPlayerLabel(player2) + ": " + player2.getName() + 
                ": HP " + player2.getHealth() + "/" + player2.getMaxHealth() +
                " | Mana " + player2.getCurrentMana() + "/" + player2.getMaxMana());
                
        System.out.println("*****************************************************");
    }
}
