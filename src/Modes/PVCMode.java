package Modes;

import Battle.Battle;
import Main.CharacterSelector;
import Main.MusicPlayerInterface;


public class PVCMode extends Mode {

    public PVCMode(MusicPlayerInterface music) {
        super(music);
    }
        @Override
        public void start() {
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

            displayGameOver();
            
            scan.close();
        }
}
