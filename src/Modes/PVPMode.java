package Modes;

import Battle.Battle;
import Main.CharacterSelector;
import Main.MusicPlayerInterface;

public class PVPMode extends Mode {

    public PVPMode(MusicPlayerInterface music) {
        super(music);
    }

    public void start(){
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
                
                displayGameOver();


        }
}
