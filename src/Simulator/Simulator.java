package Simulator;

import java.util.*;
import Main.CharacterSelector;
import Characters.Character;

public class Simulator {

    private static final int SIM_ROUNDS = 100;

    public static void main(String[] args) {
        runSimulations();
    }

    public static void runSimulations() {
        CharacterSelector selector = new CharacterSelector();
        Character[] baseList = selector.getAllCharacters();
        int n = baseList.length;

        Random rnd = new Random();
        String[] devBosses = { "Dev Kishanta", "Dev Rothesa", "Dev Wengie", "Dev Kunihiko", "Dev Diane" };

        // Win counters per mode
        int[] pvpWins = new int[n];
        int[] pvcWins = new int[n];
        int[] endlessWins = new int[n];
        int[] arcadeWins = new int[n];
        int[] bossWins = new int[n];

        // Run simulations for each character
        for (int i = 0; i < n; i++) {
            for (int sim = 0; sim < SIM_ROUNDS; sim++) {

                // --- PvP ---
                Character[] fresh = selector.getAllCharacters();
                Character player = fresh[i];
                int oppIndex;
                do { oppIndex = rnd.nextInt(n); } while (oppIndex == i);
                Character opponent = fresh[oppIndex];
                if (simulateMatch(player, opponent, rnd)) pvpWins[i]++;

                // --- PVC ---
                fresh = selector.getAllCharacters();
                player = fresh[i];
                do { oppIndex = rnd.nextInt(n); } while (oppIndex == i);
                opponent = fresh[oppIndex];
                if (simulateMatch(player, opponent, rnd)) pvcWins[i]++;

                // --- Endless ---
                fresh = selector.getAllCharacters();
                player = fresh[i];
                if (simulateEndless(player, fresh, rnd)) endlessWins[i]++;

                // --- Arcade ---
                fresh = selector.getAllCharacters();
                player = fresh[i];
                if (simulateArcade(player, fresh, devBosses, selector, rnd)) arcadeWins[i]++;

                // --- Vs Dev Boss ---
                fresh = selector.getAllCharacters();
                player = fresh[i];
                String bossName = devBosses[rnd.nextInt(devBosses.length)];
                Character boss = selector.getDevBoss(bossName);
                player.restoreHP(); player.restoreMana();
                boss.restoreHP(); boss.restoreMana();
                if (simulateMatch(player, boss, rnd)) bossWins[i]++;
            }
        }

        // Display leaderboards
        displayLeaderboard("PvP Win Rate", baseList, pvpWins);
        displayLeaderboard("PVC Win Rate", baseList, pvcWins);
        displayLeaderboard("Endless Mode Win Rate", baseList, endlessWins);
        displayLeaderboard("Arcade Mode Win Rate", baseList, arcadeWins);
        displayLeaderboard("Vs Dev Boss Win Rate", baseList, bossWins);
    }

    // ------------------ Simulation helpers ------------------

    private static boolean simulateMatch(Character player, Character opponent, Random rnd) {
        int playerMatchWins = 0;
        int oppMatchWins = 0;
        int[] cdsA = new int[]{0, 0};
        int[] cdsB = new int[]{0, 0};

        while (playerMatchWins < 2 && oppMatchWins < 2) {
            player.restoreHP(); player.restoreMana();
            opponent.restoreHP(); opponent.restoreMana();

            boolean playerStarts = rnd.nextBoolean();

            while (player.isAlive() && opponent.isAlive()) {
                Character current = playerStarts ? player : opponent;
                Character other = playerStarts ? opponent : player;
                int[] currentCDs = playerStarts ? cdsA : cdsB;

                int move = chooseAIMove(current, currentCDs, rnd);

                switch (move) {
                    case 1 -> current.basicAttack(other);
                    case 2 -> current.secondarySkill(other);
                    case 3 -> current.ultimateSkill(other);
                    default -> current.basicAttack(other);
                }

                if (move == 2) currentCDs[0] = 3;
                if (move == 3) currentCDs[1] = 5;

                current.addMana(current.getRegenMana());
                other.addMana(other.getRegenMana());

                if (cdsA[0] > 0) cdsA[0]--; if (cdsA[1] > 0) cdsA[1]--;
                if (cdsB[0] > 0) cdsB[0]--; if (cdsB[1] > 0) cdsB[1]--;

                playerStarts = !playerStarts;
            }

            if (player.isAlive()) playerMatchWins++; else oppMatchWins++;
        }

        return playerMatchWins > oppMatchWins;
    }

    private static int chooseAIMove(Character c, int[] cds, Random rnd) {
        List<Integer> valid = new ArrayList<>();
        valid.add(1);
        if (cds[0] == 0 && c.getCurrentMana() >= c.getSecondaryManaCost()) valid.add(2);
        if (cds[1] == 0 && c.getCurrentMana() >= c.getUltimateManaCost()) valid.add(3);
        return valid.get(rnd.nextInt(valid.size()));
    }

    private static boolean simulateEndless(Character player, Character[] opponents, Random rnd) {
        for (Character opp : opponents) {
            if (opp == player) continue;
            player.restoreHP(); player.restoreMana();
            opp.restoreHP(); opp.restoreMana();
            if (!simulateMatch(player, opp, rnd)) return false;
        }
        return true;
    }

    private static boolean simulateArcade(Character player, Character[] opponents, String[] devBosses, CharacterSelector selector, Random rnd) {
        for (Character opp : opponents) {
            if (opp == player) continue;
            player.restoreHP(); player.restoreMana();
            opp.restoreHP(); opp.restoreMana();
            if (!simulateMatch(player, opp, rnd)) return false;
        }
        String bossName = devBosses[rnd.nextInt(devBosses.length)];
        Character boss = selector.getDevBoss(bossName);
        player.restoreHP(); player.restoreMana();
        boss.restoreHP(); boss.restoreMana();
        return simulateMatch(player, boss, rnd);
    }

    // ------------------ Display ------------------

    private static void displayLeaderboard(String title, Character[] baseList, int[] wins) {
        int maxNameLen = "Character".length();
        for (Character c : baseList) if (c.getName().length() > maxNameLen) maxNameLen = c.getName().length();

        List<Result> results = new ArrayList<>();
        for (int i = 0; i < baseList.length; i++) {
            double winRate = (wins[i] * 100.0) / SIM_ROUNDS;
            results.add(new Result(baseList[i].getName(), winRate, wins[i]));
        }
        results.sort((a, b) -> Double.compare(b.winRate, a.winRate));

        System.out.println("\n=============== " + title + " ===============\n");
        System.out.println("# Character" + spaces(maxNameLen - "Character".length() + 1) + "Win%   Wins");

        int rank = 1;
        for (Result r : results) {
            double v = Math.round(r.winRate * 10.0) / 10.0;
            String winStr = v + "%";
            String winsStr = r.wins + "/" + SIM_ROUNDS;
            int gap = maxNameLen - r.name.length() + 1;
            String pad = spaces(gap);
            System.out.println(rank + " " + r.name + pad + winStr + "   " + winsStr);
            rank++;
        }
    }

    private static String spaces(int n) {
        if (n <= 0) return "";
        char[] arr = new char[n]; Arrays.fill(arr, ' ');
        return new String(arr);
    }

    private static class Result {
        String name;
        double winRate;
        int wins;
        Result(String name, double winRate, int wins) {
            this.name = name;
            this.winRate = winRate;
            this.wins = wins;
        }
    }
}
