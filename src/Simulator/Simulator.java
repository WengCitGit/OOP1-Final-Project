package Simulator;

import java.util.*;
import Main.CharacterSelector;

public class Simulator {

    private static final int SIM_ROUNDS = 100;

    public static void main(String[] args) {
        runSimulations();
    }

    public static void runSimulations() {
        CharacterSelector selector = new CharacterSelector();

        // We'll use getAllCharacters() as the canonical list (Jollibee -> Chief Khai)
        Characters.Character[] baseList = selector.getAllCharacters();
        int n = baseList.length;

        int[] wins = new int[n];            // wins vs random opponents
        int[] bossWins = new int[n];        // wins vs random final boss

        Random rnd = new Random();

        String[] devBosses = { "Dev Kishanta", "Dev Rothesa", "Dev Wengie", "Dev Kunihiko", "Dev Diane" };

        // For each character, run SIM_ROUNDS matches versus random opponents
        for (int i = 0; i < n; i++) {
            for (int sim = 0; sim < SIM_ROUNDS; sim++) {
                // fresh instances each match
                Characters.Character[] fresh = selector.getAllCharacters();
                Characters.Character player = fresh[i];

                // pick a random opponent different from i
                int oppIndex;
                do { oppIndex = rnd.nextInt(n); } while (oppIndex == i);
                Characters.Character opponent = fresh[oppIndex];

                boolean playerWon = simulateMatch(player, opponent, rnd);
                if (playerWon) wins[i]++;
            }

            // Now simulate SIM_ROUNDS matches vs random final boss choices
            for (int sim = 0; sim < SIM_ROUNDS; sim++) {
                Characters.Character[] fresh = selector.getAllCharacters();
                Characters.Character player = fresh[i];

                // choose a random dev boss
                String bossName = devBosses[rnd.nextInt(devBosses.length)];
                Characters.Character boss = selector.getDevBoss(bossName);

                boolean playerWon = simulateMatch(player, boss, rnd);
                if (playerWon) bossWins[i]++;
            }
        }

        // Build result objects
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = baseList[i].getName();
            double winRate = (wins[i] * 100.0) / SIM_ROUNDS;
            results.add(new Result(name, winRate, wins[i], bossWins[i]));
        }

        // Sort leaderboard by winRate desc
        results.sort((a, b) -> Double.compare(b.winRate, a.winRate));


        // Print leaderboard (simple space-separated columns)
        System.out.println("\n=============== SIMULATOR LEADERBOARD (Win Rate) ================\n");

        // Align stats into their own columns using minimal spaces based on the longest name
        int maxNameLen = "Character".length();
        for (Result r : results) {
            if (r.name != null && r.name.length() > maxNameLen) maxNameLen = r.name.length();
        }

        // First leaderboard: includes boss wins column
        System.out.println("# Character" + spaces(maxNameLen - "Character".length() + 1) + "Win%   Wins   BossWins");

        int rank = 1;
        for (Result r : results) {
            double v = Math.round(r.winRate * 10.0) / 10.0; // one decimal
            String winStr = v + "%";
            String winsStr = r.wins + "/" + SIM_ROUNDS;
            String bossStr = r.bossWins + "/" + SIM_ROUNDS;

            int gap = maxNameLen - (r.name == null ? 0 : r.name.length()) + 1;
            String pad = spaces(gap);
            String row = rank + " " + r.name + pad + winStr + "   " + winsStr + "   " + bossStr;
            System.out.println(row);
            rank++;
        }

        // Second leaderboard: opponent-only (without dev bosses)
        System.out.println();
        System.out.println("=============== SIMULATOR LEADERBOARD (Vs Random Opponents Only) ===============");
        System.out.println("# Character" + spaces(maxNameLen - "Character".length() + 1) + "Win%   Wins");

        rank = 1;
        for (Result r : results) {
            double v = Math.round(r.winRate * 10.0) / 10.0;
            String winStr = v + "%";
            String winsStr = r.wins + "/" + SIM_ROUNDS;

            int gap = maxNameLen - (r.name == null ? 0 : r.name.length()) + 1;
            String pad = spaces(gap);
            String row = rank + " " + r.name + pad + winStr + "   " + winsStr;
            System.out.println(row);
            rank++;
        }

        System.out.println("\nSimulation complete.");
    }

    // Simulate a best-of-3 match between two characters with fully automated decisions.
    // Returns true if player (first argument) wins the match.
    private static boolean simulateMatch(Characters.Character player, Characters.Character opponent, Random rnd) {
        int playerMatchWins = 0;
        int oppMatchWins = 0;

        // We'll reuse simple cooldown arrays: [secondaryCD, ultimateCD]
        while (playerMatchWins < 2 && oppMatchWins < 2) {
            // reset per-round state
            player.restoreHP(); player.restoreMana();
            opponent.restoreHP(); opponent.restoreMana();
            int[] cdsA = new int[]{0, 0};
            int[] cdsB = new int[]{0, 0};

            boolean playerStarts = rnd.nextBoolean();

            while (player.isAlive() && opponent.isAlive()) {
                Characters.Character current = playerStarts ? player : opponent;
                Characters.Character other = playerStarts ? opponent : player;
                int[] currentCDs = playerStarts ? cdsA : cdsB;

                // choose AI move
                int move = chooseAIMove(current, currentCDs, rnd);

                // perform move
                switch (move) {
                    case 1 -> current.basicAttack(other);
                    case 2 -> current.secondarySkill(other);
                    case 3 -> current.ultimateSkill(other);
                    default -> current.basicAttack(other);
                }

                // apply cooldown for the performer
                if (move == 2) currentCDs[0] = 3; // secondary cooldown
                if (move == 3) currentCDs[1] = 5; // ultimate cooldown

                // After each action, both characters gain mana equal to their regen amount
                current.addMana(current.getRegenMana());
                other.addMana(other.getRegenMana());

                // decrement cooldowns for both
                if (cdsA[0] > 0) cdsA[0]--; if (cdsA[1] > 0) cdsA[1]--;
                if (cdsB[0] > 0) cdsB[0]--; if (cdsB[1] > 0) cdsB[1]--;

                // swap turn
                playerStarts = !playerStarts;
            }

            if (player.isAlive()) playerMatchWins++; else oppMatchWins++;
        }

        return playerMatchWins > oppMatchWins;
    }

    // Choose an AI move based on available mana and cooldowns
    private static int chooseAIMove(Characters.Character c, int[] cds, Random rnd) {
        List<Integer> valid = new ArrayList<>();
        valid.add(1); // basic
        if (cds[0] == 0 && c.getCurrentMana() >= c.getSecondaryManaCost()) valid.add(2);
        if (cds[1] == 0 && c.getCurrentMana() >= c.getUltimateManaCost()) valid.add(3);
        return valid.get(rnd.nextInt(valid.size()));
    }

    // Minimal helper to produce spaces for simple alignment
    private static String spaces(int n) {
        if (n <= 0) return "";
        char[] arr = new char[n];
        Arrays.fill(arr, ' ');
        return new String(arr);
    }

    private static class Result {
        String name;
        double winRate;
        int wins;
        int bossWins;

        Result(String name, double winRate, int wins, int bossWins) {
            this.name = name;
            this.winRate = winRate;
            this.wins = wins;
            this.bossWins = bossWins;
        }
    }
}
