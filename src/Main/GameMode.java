package Main;
import java.io.PrintStream;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;
import Battle.*;
//import Characters.*; 
import Characters.ChiefKhai;
    
    public class GameMode {
        private MusicPlayer musicPlayer;
        private static final String DEFAULT_BGM = "bgm.wav";

        public GameMode(MusicPlayer music) {
            this.musicPlayer = music;
        }

        private Scanner scan = new Scanner(System.in);

        private void s(long ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                // ignore
            }
        }


        public void startPVP(){
                CharacterSelector selector = new CharacterSelector();

                System.out.print("\nEnter name for Player 1: ");
                String player1Name = scan.nextLine().trim();
                if (player1Name.isEmpty()) player1Name = "Player 1";

                System.out.println("\n" + player1Name + ", choose your character:");
                Characters.Character player1 = selector.chooseCharacter();

                System.out.print("\nEnter name for Player 2: ");
                String player2Name = scan.nextLine().trim();
                if (player2Name.isEmpty()) player2Name = "Player 2";

                System.out.println("\n" + player2Name + ", choose your character:");
                System.out.println();
                Characters.Character player2 = selector.chooseCharacter();

                System.out.println();
                System.out.println("                         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("                                " + player1Name + ": " + player1.getName() + " VS " + player2Name + ": " + player2.getName());
                System.out.println("                         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                Battle battle = new Battle(player1, player2, player1Name, player2Name);
                battle.start();
                System.out.println("""
                    
                     ██████╗   █████╗  ███╗   ███╗ ███████╗    ██████╗  ██╗   ██╗ ███████╗ ██████╗
                    ██╔════╝  ██╔══██╗ ████╗ ████║ ██╔════╝   ██╔═══██╗ ██║   ██║ ██╔════╝ ██╔══██╗
                    ██║  ███╗ ███████║ ██╔████╔██║ █████╗     ██║   ██║ ██║   ██║ █████╗   ██████╦╝
                    ██║   ██║ ██╔══██║ ██║╚██╔╝██║ ██╔══╝     ██║   ██║ ╚██╗ ██╔╝ ██╔══╝   ██║══██║
                    ╚██████╔╝ ██║  ██║ ██║ ╚═╝ ██║ ███████╗   ╚██████╔╝  ╚████╔╝  ███████╗ ██║  ██║
                     ╚═════╝  ╚═╝  ╚═╝ ╚═╝     ╚═╝ ╚══════╝    ╚═════╝    ╚═══╝   ╚══════╝ ╚═╝  ╚═╝

                    """);
        }

        public void startPVC() {
            System.out.println();
            CharacterSelector selector = new CharacterSelector();

            System.out.print("\nEnter your name: ");
            String playerName = scan.nextLine().trim();
            if (playerName.isEmpty()) playerName = "Player 1";

            System.out.println();
            System.out.println(playerName + ", choose your character:");
            System.out.println();
            Characters.Character player1 = selector.chooseCharacter();
            Characters.Character enemy = selector.chooseRandomCharacter();

            System.out.println("                         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("                                    " + playerName + ": " + player1.getName() + " VS Computer: " + enemy.getName());
            System.out.println("                         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            Battle battle = new Battle(player1, enemy, true, playerName, "Computer"); 
            battle.start();
            System.out.println("""
                    
                     ██████╗   █████╗  ███╗   ███╗ ███████╗    ██████╗  ██╗   ██╗ ███████╗ ██████╗
                    ██╔════╝  ██╔══██╗ ████╗ ████║ ██╔════╝   ██╔═══██╗ ██║   ██║ ██╔════╝ ██╔══██╗
                    ██║  ███╗ ███████║ ██╔████╔██║ █████╗     ██║   ██║ ██║   ██║ █████╗   ██████╦╝
                    ██║   ██║ ██╔══██║ ██║╚██╔╝██║ ██╔══╝     ██║   ██║ ╚██╗ ██╔╝ ██╔══╝   ██║══██║
                    ╚██████╔╝ ██║  ██║ ██║ ╚═╝ ██║ ███████╗   ╚██████╔╝  ╚████╔╝  ███████╗ ██║  ██║
                     ╚═════╝  ╚═╝  ╚═╝ ╚═╝     ╚═╝ ╚══════╝    ╚═════╝    ╚═══╝   ╚══════╝ ╚═╝  ╚═╝

                    """);
        }

        public void startEndless() {
            System.out.println();
            System.out.println("Deathmatch against random characters until you lose!");
            System.out.println("Defeat as many as you can!");
            System.out.println();

            CharacterSelector selector = new CharacterSelector();

            System.out.print("\nEnter your name for Endless Mode: ");
            String playerName = scan.nextLine().trim();
            if (playerName.isEmpty()) playerName = "Player";

            System.out.println("Choose your champion for Endless Mode, " + playerName + ":");
            Characters.Character player = selector.chooseCharacter();

            int streak = 0;
            while (true) {
                System.out.println();
                System.out.println("===== ENDLESS ROUND " + (streak + 1) + " =====");
                Characters.Character enemy = selector.chooseRandomCharacter();

                System.out.println("Matchup: " + playerName + ": " + player.getName() + " VS " + enemy.getName());
                System.out.println("Get ready...");

                // Use PVC-style Battle so enemy acts automatically
                Battle battle = new Battle(player, enemy, true, playerName, "Computer");
                battle.start();

                // After battle, Battle.start() leaves the Character objects with their final HP state.
                if (player.isAlive()) {
                    // Player won the match
                    streak++;
                    // Heal player to full HP after each battle
                    player.restoreHP();

                    System.out.println("\nYou defeated " + enemy.getName() + "!");
                    System.out.println("Current streak: " + streak);
                    System.out.println("Your HP: " + player.getHealth() + " / " + player.getMaxHealth());

                    // Prompt: ENTER to continue, or 's' to surrender
                    while (true) {
                        System.out.print("\nPress ENTER to face the next challenger, or type 's' then ENTER to surrender: ");
                        String next = scan.nextLine();

                        if (next == null || next.trim().isEmpty()) {
                            // continue to next challenger
                            break; // break prompt loop and continue outer while
                        }

                        if (next.trim().equalsIgnoreCase("s")) {
                            // Confirm surrender
                            while (true) {
                                System.out.print("Are you sure you want to surrender? (y/n): ");
                                String confirm = scan.nextLine().trim();
                                if (confirm.equalsIgnoreCase("y")) {
                                    System.out.println("\nYou surrendered!");
                                    System.out.println("FINAL STREAK: " + streak + " enemies defeated.");
                                    return;
                                } else if (confirm.equalsIgnoreCase("n")) {
                                    // Don't surrender, go back to the prompt to continue or surrender
                                    break;
                                } else {
                                    System.out.println("Please answer 'y' or 'n'.");
                                }
                            }
                        } else {
                            // any other input treated as continue
                            break;
                        }
                    }
                    // proceed to next challenger
                    continue;
                } else {
                    // Player lost
                    System.out.println("\n" + playerName + " was defeated by " + enemy.getName() + "!");
                    System.out.println("FINAL STREAK: " + streak + " enemies defeated.");
                    break;
                }
            }
            System.out.println("""
                    
                     ██████╗   █████╗  ███╗   ███╗ ███████╗    ██████╗  ██╗   ██╗ ███████╗ ██████╗
                    ██╔════╝  ██╔══██╗ ████╗ ████║ ██╔════╝   ██╔═══██╗ ██║   ██║ ██╔════╝ ██╔══██╗
                    ██║  ███╗ ███████║ ██╔████╔██║ █████╗     ██║   ██║ ██║   ██║ █████╗   ██████╦╝
                    ██║   ██║ ██╔══██║ ██║╚██╔╝██║ ██╔══╝     ██║   ██║ ╚██╗ ██╔╝ ██╔══╝   ██║══██║
                    ╚██████╔╝ ██║  ██║ ██║ ╚═╝ ██║ ███████╗   ╚██████╔╝  ╚████╔╝  ███████╗ ██║  ██║
                     ╚═════╝  ╚═╝  ╚═╝ ╚═╝     ╚═╝ ╚══════╝    ╚═════╝    ╚═══╝   ╚══════╝ ╚═╝  ╚═╝

                    """);
        }

        private String getDisplayWithCharacterName(Characters.Character c, String playerLabel) {
            return playerLabel + " (" + c.getName() + ")";
        }


        // Placeholder for expanded Arcade Mode (option 4 in menu)
        public void startArcadeMode() {
                System.out.println();
                System.out.println("Beat all characters and face the FINAL BOSS!");
                System.out.println("But beware... some characters hide secrets.\n");

                CharacterSelector selector = new CharacterSelector();
                System.out.print("\nEnter your name for Arcade Mode: ");
                String playerName = scan.nextLine().trim();
                if (playerName.isEmpty()) playerName = "Player";

                System.out.println("Choose your champion for Arcade Mode, " + playerName + ":");
                Characters.Character chosenPlayer = selector.chooseCharacter();
                boolean playerIsChiefKhai = chosenPlayer.getName().startsWith("Chief Khai");

                // Make Chief Khai OP if chosen
                Characters.Character player = playerIsChiefKhai ? new ChiefKhai(true) : chosenPlayer;

                // All character names
                final String[] allNames = {
                    "Jollibee - Crispy Joy Bringer",
                    "McDonald's - Big Mac Basher",
                    "KFC - Colonel's Drumstick Duelist",
                    "Burger King - Flame Griller",
                    "Wendy's - Sassy Red Fighter",
                    "Jack in the Box - Trickster Clown",
                    "Little Caesars - Pizza Gladiator",
                    "Chief Khai - Whistle Warrior"
                };


                // Build enemy list safely
                List<String> enemyOrder = new ArrayList<>();
                for (String name : allNames) {
                    if (name.equalsIgnoreCase(chosenPlayer.getName())) continue; // skip player
                    if (!playerIsChiefKhai && name.startsWith("Chief Khai")) continue; // skip Chief Khai for others
                    enemyOrder.add(name);
                }
                Collections.shuffle(enemyOrder); // randomize order

                int stage = 1;
                int wins = 0;
                Random r = new Random();

                // ====== FIGHT NORMAL ENEMIES ======
                for (String enemyName : enemyOrder) {
                    System.out.println("\n");
                    System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
                    System.out.println("                                      █                                                                          █");
                    System.out.println("                                      █                       A R C A D E   S T A G E   " + String.format("%-2d", stage) + "                       █");
                    System.out.println("                                      █                                                                          █");
                    System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
                    System.out.println();

                    Characters.Character enemy = selector.getCharacterByName(enemyName.trim()); // declare once
                    if (enemy == null) {
                        System.out.println("ERROR: Enemy " + enemyName + " not found! Skipping stage.");
                        stage++;
                        continue; // skip this enemy
                    }   

                    System.out.println("Matchup: " + getDisplayWithCharacterName(player, playerName) 
                                    + " VS " + getDisplayWithCharacterName(enemy, "Enemy"));

                    Battle battle = new Battle(player, enemy, true, playerName, "Enemy");
                    battle.start();

                    if (!player.isAlive()) {
                        System.out.println("\nYou were defeated by " + enemy.getName() + "!");
                        System.out.println("Stages cleared: " + wins);
                        return;
                    }

                    wins++;
                    stage++;
                    player.restoreHP();
                    System.out.println("\nYou defeated " + enemy.getName() + "!");
                    System.out.println("HP restored. Press ENTER to continue...");
                    scan.nextLine();
                }

            // ====== FINAL TWIST: Player is Chief Khai ======
            if (playerIsChiefKhai) {

                musicPlayer.stop();
                musicPlayer.play("chief_khai_theme.wav");

                System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
                System.out.println("                                      █                                                                          █");
                System.out.println("                                      █                         F I N A L   E N C O U N T E R                    █");
                System.out.println("                                      █                                                                          █");
                System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
                System.out.println("As you approach the final arena, the background flickers");
                System.out.println("like someone just opened a window inside the code.");

                s(1200);
                System.out.println("Your controls tighten. Not broken... but restrained. Guided.");
                s(900);

                System.out.println("\nCHIEF KHAI: \"...Stop.\"");
                s(1000);

                System.out.println("Chief Khai freezes mid-step. His model twitches, as if pulled by an invisible cursor.");
                s(1300);

                System.out.println("\nA cold presence settles over the screen.");
                System.out.println("You feel it. Someone else is here. Someone watching.");
                s(1400);

                // subtle dev interference
                System.out.println(">> A faint line of text appears for half a second: [dev_eye_connected]");
                s(900);

                // ASCII WARNING GLITCH – DEV PRESENCE
                System.out.println();
                System.out.println("""
                                        .%%%%%%..%%%%%...%%%%%....%%%%...%%%%%..
                                        .%%......%%..%%..%%..%%..%%..%%..%%..%%.
                                        .%%%%....%%%%%...%%%%%...%%..%%..%%%%%..
                                        .%%......%%..%%..%%..%%..%%..%%..%%..%%.
                                        .%%%%%%..%%..%%..%%..%%...%%%%...%%..%%.
                                        ........................................
                                        """);
                s(1200);

                System.out.println("The symbol flashes aggressively before vanishing");
                System.out.println("like the system tried to warn you, or warn HIM.");
                s(1500);

                System.out.println("\nCHIEF KHAI slowly turns, not toward the boss, but toward YOU." );
                s(1600);

                System.out.println("\nCHIEF KHAI: \"You brought me too close... They're aware now.\"");
                s(1500);

                System.out.println("The arena lights dim. Footstep echoes... but not from anyone present.");
                System.out.println("It sounds like someone pacing on the other side of the screen.");
                s(1500);

                System.out.println("\nCHIEF KHAI: \"They're watching us. Every frame. Every move.\"");
                s(1500);

                System.out.println("\nCHIEF KHAI: \"I was assigned to them, the hands behind the code.");
                System.out.println("              My path... locked. My choices... overwritten.\"");
                s(1700);

                // dev warning glitch
                System.out.println("\n>> WARNING: unauthorized_behavior_detected");
                s(900);

                System.out.println("Chief Khai's body jerks sharply, like an unseen hand grabbed his shoulder.");
                s(1500);

                System.out.println("\nCHIEF KHAI: \"I'm sorry... I can't fight their creators. I'm not allowed to.\"");
                s(1300);

                System.out.println("Your inputs stop working completely. A soft static crackles in your headphones.");
                System.out.println("It almost sounds like... whispering.");
                s(1500);

                


                System.out.println("""
                        
                              ░░░░░░░░░░░░░░░░░░░░░░                       
                          ░░░░                      ░░░░                    ███████████ 
                      ░░░░░░                          ░░░░░░                  ███     ███ 
                    ░░░░                                  ░░░░                ███     ███  
                  ░░                                          ▒▒              ██████████  
                ░░                                              ░░            ███     ███   
              ░░░░                                              ░░░░          ███     ███ 
              ░░                                                  ░░        ███████████ 
            ░░░░                                                  ░░░░     
            ░░                                                      ░░░░  
            ░░        ██████                          ██████        ░░░░     █████   █████       
          ░░░░      ▓▓██  ░░                          ░░░░██▓▓      ░░░░      ███     ███   
          ░░      ▓▓██░░                                  ░░██▓▓      ░░░░      ███████  
          ░░    ████  ████████████              ████████████  ████    ░░░░        ███  
          ░░    ██  ████▒▒██████████        ░░██████████▒▒████  ██    ░░          ███  
          ░░        ▒▒▒▒▒▒        ██        ░░██        ▒▒▒▒▒▒        ░░         █████ 
         ░░    ▒▒▒▒  ▒▒▒▒                              ▒▒▒▒  ▒▒▒▒    ░░░░         
         ░░  ▒▒▒▒    ▒▒                                  ▒▒    ▒▒▒▒  ░░░░
         ░░▒▒▒▒▒▒    ▒▒██████████████████████████████████▒▒    ▒▒▒▒▒▒░░░░     ███████████    
         ▒▒▒▒▒▒      ▒▒                                  ▒▒      ▒▒▒▒▒▒░░      ███      █                                             
         ▒▒▒▒▒▒    ▒▒▒▒                                  ▒▒▒▒    ▒▒▒▒▒▒░░      ███   █
         ▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒        ███████   
         ▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░      ███   █                                                 
           ▒▒▒▒▒▒▒▒▒▒    ██████████████████████████████    ▒▒▒▒▒▒▒▒▒▒░░        ███      █
            ▒▒▒▒▒▒        ██████████████████████████        ▒▒▒▒▒▒            ███████████
                  ░░            ██████████████████            ░░          
                    ░░░░            ████████▓▓            ░░░░            
                        ░░░░                          ░░░░                -GAME DEVELOPERS ;)
                           ░░░░                  ░░░░                    
                               ░░░░░░░░░░░░░░░░░░                                    
                        """);

                    System.out.println("""
                    
                     ██████╗   █████╗  ███╗   ███╗ ███████╗    ██████╗  ██╗   ██╗ ███████╗ ██████╗
                    ██╔════╝  ██╔══██╗ ████╗ ████║ ██╔════╝   ██╔═══██╗ ██║   ██║ ██╔════╝ ██╔══██╗
                    ██║  ███╗ ███████║ ██╔████╔██║ █████╗     ██║   ██║ ██║   ██║ █████╗   ██████╦╝
                    ██║   ██║ ██╔══██║ ██║╚██╔╝██║ ██╔══╝     ██║   ██║ ╚██╗ ██╔╝ ██╔══╝   ██║══██║
                    ╚██████╔╝ ██║  ██║ ██║ ╚═╝ ██║ ███████╗   ╚██████╔╝  ╚████╔╝  ███████╗ ██║  ██║
                     ╚═════╝  ╚═╝  ╚═╝ ╚═╝     ╚═╝ ╚══════╝    ╚═════╝    ╚═══╝   ╚══════╝ ╚═╝  ╚═╝

                    """);

                s(2000);

                
                
                System.out.println("\n============================================ YOU LOSE ============================================");
                System.out.println("Secret Ending Unlocked: ");
                s(1800);

                System.out.println("\nThe screen darkens. Only the static remains.");
                s(1500);

                System.out.println("\nCHIEF KHAI (whisper): \"They're still watching. Don't react.\"");
                s(1600);

                System.out.println("CHIEF KHAI (whisper): \"If you want to free me... choices matter more than you know.\"");
                s(1600);

                System.out.println("A faint distortion ripples across the screen, almost like a suggestion...");
                s(1800);

                System.out.println("\nThe static cuts mid-breath, as if someone yanked the cable.");


                return;
            }


            // ====== FIGHT CHIEF KHAI (if player did NOT choose him) ======
            System.out.println("\n");
            System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
            System.out.println("                                      █                                                                          █");
            System.out.println("                                      █                  A R C A D E   S T A G E   " + String.format("%-2d", stage) + "  -  THE GUARD              █");
            System.out.println("                                      █                                                                          █");
            System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
            System.out.println();

            Characters.Character chief = selector.getCharacterByName("Chief Khai");
            System.out.println("Chief Khai blocks your way to the final boss!");
            // Label guards/bosses as generic enemies in Arcade mode
            Battle vsKhai = new Battle(player, chief, true, playerName, "Enemy");
            vsKhai.start();

            if (!player.isAlive()) {
                System.out.println("\nYou were defeated by Chief Khai...");
                System.out.println("He whispers: \"You were never worthy to meet the devs.\"");
                musicPlayer.stop();
                musicPlayer.play(DEFAULT_BGM);
                return;
            }

            System.out.println("\nYou defeated Chief Khai!");
            player.restoreHP();
            stage++;

            // ====== RANDOM FINAL BOSS ======
            String[] devBosses = { "Dev Kishanta", "Dev Rothesa", "Dev Wengie", "Dev Kunihiko", "Dev Diane" };
            String finalBossName = devBosses[r.nextInt(devBosses.length)];
            Characters.Character finalBoss = selector.getDevBoss(finalBossName);

            System.out.println("\n");
            System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
            System.out.println("                                      █                                                                          █");
            System.out.println("                                      █                       F I N A L   B O S S   B A T T L E                  █");
            System.out.println("                                      █                                                                          █");
            System.out.println("                                      ████████████████████████████████████████████████████████████████████████████");
            System.out.println("  >>> CHALLENGER: " + finalBossName + " <<<");
            System.out.println();
            
            // Final boss shown as an enemy label in arcade mode UI
            Battle finalBattle = new Battle(player, finalBoss, true, playerName, "Enemy");
            finalBattle.start();

            if (!player.isAlive()) {
                System.out.println("\nYou lost to " + finalBossName + "!");
                System.out.println("The developers laugh: \"Back to the start!\"");
                

                System.out.println("""
                        
                              ░░░░░░░░░░░░░░░░░░░░░░                       
                          ░░░░                      ░░░░                    ███████████ 
                      ░░░░░░                          ░░░░░░                  ███     ███ 
                    ░░░░                                  ░░░░                ███     ███  
                  ░░                                          ▒▒              ██████████  
                ░░                                              ░░            ███     ███   
              ░░░░                                              ░░░░          ███     ███ 
              ░░                                                  ░░        ███████████ 
            ░░░░                                                  ░░░░     
            ░░                                                      ░░░░  
            ░░        ██████                          ██████        ░░░░     █████   █████       
          ░░░░      ▓▓██  ░░                          ░░░░██▓▓      ░░░░      ███     ███   
          ░░      ▓▓██░░                                  ░░██▓▓      ░░░░      ███████  
          ░░    ████  ████████████              ████████████  ████    ░░░░        ███  
          ░░    ██  ████▒▒██████████        ░░██████████▒▒████  ██    ░░          ███  
          ░░        ▒▒▒▒▒▒        ██        ░░██        ▒▒▒▒▒▒        ░░         █████ 
         ░░    ▒▒▒▒  ▒▒▒▒                              ▒▒▒▒  ▒▒▒▒    ░░░░         
         ░░  ▒▒▒▒    ▒▒                                  ▒▒    ▒▒▒▒  ░░░░
         ░░▒▒▒▒▒▒    ▒▒██████████████████████████████████▒▒    ▒▒▒▒▒▒░░░░     ███████████    
         ▒▒▒▒▒▒      ▒▒                                  ▒▒      ▒▒▒▒▒▒░░      ███      █                                             
         ▒▒▒▒▒▒    ▒▒▒▒                                  ▒▒▒▒    ▒▒▒▒▒▒░░      ███   █
         ▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒        ███████   
         ▒▒▒▒▒▒▒▒▒▒▒▒▒▒██████████████████████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░      ███   █                                                 
           ▒▒▒▒▒▒▒▒▒▒    ██████████████████████████████    ▒▒▒▒▒▒▒▒▒▒░░        ███      █
            ▒▒▒▒▒▒        ██████████████████████████        ▒▒▒▒▒▒            ███████████
                  ░░            ██████████████████            ░░          
                    ░░░░            ████████▓▓            ░░░░            
                        ░░░░                          ░░░░                -GAME DEVELOPERS ;)
                           ░░░░                  ░░░░                    
                               ░░░░░░░░░░░░░░░░░░                                    
                        """);

                    System.out.println("""
                    
                     ██████╗   █████╗  ███╗   ███╗ ███████╗    ██████╗  ██╗   ██╗ ███████╗ ██████╗
                    ██╔════╝  ██╔══██╗ ████╗ ████║ ██╔════╝   ██╔═══██╗ ██║   ██║ ██╔════╝ ██╔══██╗
                    ██║  ███╗ ███████║ ██╔████╔██║ █████╗     ██║   ██║ ██║   ██║ █████╗   ██████╦╝
                    ██║   ██║ ██╔══██║ ██║╚██╔╝██║ ██╔══╝     ██║   ██║ ╚██╗ ██╔╝ ██╔══╝   ██║══██║
                    ╚██████╔╝ ██║  ██║ ██║ ╚═╝ ██║ ███████╗   ╚██████╔╝  ╚████╔╝  ███████╗ ██║  ██║
                     ╚═════╝  ╚═╝  ╚═╝ ╚═╝     ╚═╝ ╚══════╝    ╚═════╝    ╚═══╝   ╚══════╝ ╚═╝  ╚═╝

                    """);
                return;
            }

            System.out.println("""
                █████   █████ █████   █████████  ███████████    ███████    ███████████   █████ █████    ███
               ░░███   ░░███ ░░███   ███░░░░░███░█░░░███░░░█  ███░░░░░███ ░░███░░░░░███ ░░███ ░░███    ░███
                ░███    ░███  ░███  ███     ░░░ ░   ░███  ░  ███     ░░███ ░███    ░███  ░░███ ███     ░███
                ░███    ░███  ░███ ░███             ░███    ░███      ░███ ░██████████    ░░█████      ░███
                ░░███   ███   ░███ ░███             ░███    ░███      ░███ ░███░░░░░███    ░░███       ░███
                 ░░░█████░    ░███ ░░███     ███    ░███    ░░███     ███  ░███    ░███     ░███       ░░░ 
                   ░░███      █████ ░░█████████     █████    ░░░███████░   █████   █████    █████       ███
                    ░░░      ░░░░░   ░░░░░░░░░     ░░░░░       ░░░░░░░    ░░░░░   ░░░░░    ░░░░░       ░░░ 
                                                                                            

                    """);

            System.out.println("\nCONGRATULATIONS!!!");
            System.out.println("You defeated ALL characters and the FINAL BOSS!");
            s(1200);

            System.out.println("\nBut as the dust settles, a silence fills the arenas...");
            s(1000);

            System.out.println("Each character, though victorious or defeated, looks exhausted, wary, almost relieved.");
            s(1200);

            System.out.println("You realize... none of them truly wanted to fight.");
            s(1000);

            System.out.println("Something was taken from them, joy, freedom, choice, and it forced them into battles they never asked for.");
            s(1400);

            System.out.println("\nCHIEF KHAI (weakly): \"You've won... but remember... victory isn't always freedom.\"");
            s(1300);

            System.out.println("The screen flickers gently. You sense a quiet understanding pass between you and the characters.");
            s(1200);

            System.out.println("\nA feeling of closure... and the faint hope that one day, they'll reclaim what was taken.");
            s(1500);

            System.out.println("\nTHE END (Secret Resolution Unlocked)");
            musicPlayer.stop();
            musicPlayer.play(DEFAULT_BGM);
        }

    }
