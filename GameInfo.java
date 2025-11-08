import java.util.Scanner;


public class GameInfo {
     private static Scanner scan = new Scanner(System.in);

    public void displayGameInfo() {
        while (true) {
            try {
                System.out.println("\n=== GAME INFORMATION ===");
                System.out.println("1. Main Story");
                System.out.println("2. Character Stories");
                System.out.println("3. Back to Game");
                System.out.print("Choose an option: ");

                String choice = scan.nextLine().trim();

                if (choice.isEmpty()) {
                    throw new Exception("Input cannot be empty!");
                }

                switch (choice) {
                    case "1" -> showMainStory();
                    case "2" -> showCharacterStories();
                    case "3" -> {
                        System.out.println("\nReturning to Game Menu...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showMainStory() {
        System.out.println("\n--- MAIN STORY ---");
        System.out.println("""
        In a world where mascots fight for their schools,
        peace was shattered when a mysterious force corrupted some of them.
        Brave students must summon their champions to restore balance!
        """);
    }

    private void showCharacterStories() {
        while (true) {
            try {
                System.out.println("\n--- CHARACTER STORIES ---");
                        System.out.println("=================================================*");
                        System.out.println("*  1. Jollibee - Crispy Joy Bringer              *");
                        System.out.println("*  2. McDo - Big Mac Basher                      *");
                        System.out.println("*  3. KFC - Colonel's Drumstick Duelist          *");
                        System.out.println("*  4. Burger King - Flame Griller                *");
                        System.out.println("*  5. Wendy's - Sassy Red Fighter                *");
                        System.out.println("*  6. Jack in the Box - Trickster Clown          *");
                        System.out.println("*  7. Little Caesars - Pizza Gladiator           *");
                        System.out.println("*  8. Chief Khai - Whistle Warrior               *");
                        System.out.println("*  9. Back                                       *");
                        System.out.println("==================================================");

                System.out.print("Choose a character to view story: ");
                String choice = scan.nextLine().trim();

                if (choice.isEmpty()) {
                    throw new Exception("Input cannot be empty!");
                }

                switch (choice) {
                    case "1" -> System.out.println("""
                        
                    
                        Jollibee - The Crispy Joy Bringer

                        A cheerful and energetic mascot who spreads joy and happiness.
                        With his crispy moves and infectious enthusiasm, he uplifts
                        everyone around him in battle.

                        WHO (THE HERO): 

                        The cheerful little bee who discovered the true power of joy. 
                        After being adopted, he realized that a smile could be stronger 
                        than any sword. With a heart full of happiness, he proudly chants, 
                        “Bida ang saya! ” Joy is the star, and he is here to make sure it 
                        shines everywhere.


                        WHERE (THE ORIGIN):

                        In 1975, he was adopted into a small family-run Magnolia ice cream 
                        parlor founded by Tony Tan Caktiong. But ice cream was only the 
                        beginning. Soon, the little shop grew, fueled by crispy chicken, 
                        sweet spaghetti, and the laughter of families. From a single hive 
                        of joy, Jollibee spread his wings across the nation.


                        WHY (THE MOTIVATION):

                        Dark forces now threaten to steal the joy from every meal. Hungry 
                        rivals, spoiled burgers, and sad spaghetti lurk in the shadows. 
                        Armed with Chickenjoy, unstoppable smiles, and spaghetti-powered 
                        punches, Jollibee embarks on his quest: to spread joy, defend families, 
                        and ensure that happiness reigns supreme at every table!


                        """);

                    case "2" -> System.out.println("""

                        McDonalds - The Big Mac Basher 

                        A strong and determined mascot who fights for greatness.
                        With his powerful punches and iconic moves, he aims to be the best 
                        in every battle. 


                        WHO (THE HERO): 

                        The Clown with a big heart—always smiling, even when it hurts. One 
                        half of the Clown Brothers, he learned to laugh through loneliness, 
                        turning tears into tricks and sorrow into smiles. Beneath his painted 
                        grin lies a heart that beats for family, with his brother by his side, 
                        he vowed to turn sorrow into smiles and loneliness into laughter for 
                        the world to see.


                        WHERE (THE ORIGIN):

                        After Jollibee was adopted from the orphanage, McDonalds and his brother 
                        stayed behind. But instead of letting despair consume them, they dreamed 
                        bigger. Together, they built a small circus—bright lights, painted faces, 
                        and the sound of children’s laughter filling every corner. Their circus 
                        became a place where broken hearts could heal and forgotten souls could 
                        smile again. Side by side, the Clown Brothers spread happiness across 
                        towns, believing that joy was the greatest gift they could give.


                        WHY (THE MOTIVATION):

                        His brother vanished—kidnapped by shadowy forces that feed on greed and 
                        sorrow. Now, McDonalds must enter the Game, a twisted challenge where 
                        smiles are tested and hearts are broken. To win is to bring his brother 
                        back; to lose is to let joy disappear forever. Armed with golden fries, 
                        hope in his heart, and courage beneath the greasepaint, McDonalds fights 
                        not just for victory—but for family, and for the belief that even in 
                        darkness, a smile can save the world.


                        """);

                    case "3" -> System.out.println("""

                        KFC - The Colonel's Drumstick Duelist

                        A master tactician who leads with wisdom and precision.
                        His strategic mind makes him a challenging adversary in battle.


                        WHO (THE HERO): 

                        


                        WHERE (THE ORIGIN):

                        


                        WHY (THE MOTIVATION):

                                    


                        """);

                    case "4" -> System.out.println("""

                        Burger King - The Flame Griller

                        A noble fighter who commands respect on the battlefield.
                        His royal presence and combat skills make him a formidable foe.


                        WHO (THE HERO): 

                        


                        WHERE (THE ORIGIN):

                        


                        WHY (THE MOTIVATION):

                                    


                        """);

                    case "5" -> System.out.println("""

                        Wendy's - The Sassy Red Fighter

                        A spirited combatant known for her fierce determination.
                        Her fiery attacks and quick reflexes make her a tough opponent.


                        WHO (THE HERO): 

                        


                        WHERE (THE ORIGIN):

                        


                        WHY (THE MOTIVATION):

                                    
                       
                        """);

                    case "6" -> System.out.println("""

                        Jack in the Box - The Trickster Clown

                        A mischievous character who uses clever tactics to outwit opponents.
                        His unpredictable moves keep enemies on their toes.

                        WHO (THE HERO): 

                        The quiet kid from the orphanage—the one who spoke little but dreamed 
                        loud. Behind his calm gaze was a mind full of wild ideas, recipes, and 
                        tricks waiting to burst free. While others chased laughter, Jack chased 
                        invention—always tinkering, always planning, always thinking outside 
                        the box.


                        WHERE (THE ORIGIN):

                        When the McDo Brothers left the orphanage to bring laughter to the world, 
                        Jack followed. He wasn’t born for the spotlight, but his hands built the 
                        magic that made the crowd cheer. But as the circus grew brighter, Jack’s 
                        ambitions grew sharper. He eventually left to start something of his own—a 
                        breakfast franchise where every meal was a masterpiece, every morning a new 
                        beginning. For a while, it was perfect. The world loved Jack’s creations. 
                        He had finally stepped out of the box.


                        WHY (THE MOTIVATION):

                        Everything changed when a contamination scandal struck. The burgers—his 
                        pride—turned poisonous, and all fingers pointed to him. Branded a villain, 
                        Jack vanished into the shadows, clutching the only clue: the burger wasn’t 
                        his failure, but someone’s sabotage. Now, he’s on a mission to find the 
                        antidote, clear his name, and uncover the truth behind the corruption. 
                        Beneath the mask of calm lies a storm—a man fighting not just for redemption, 
                        but for the trust he lost and the taste of justice he deserves.
            
                        
                        """);           
                    
                    case "7" -> System.out.println("""
                        
                        Little Caesars - The Pizza Gladiator 

                        A brave warrior who fights with the spirit of a gladiator.
                        His pizza-themed attacks are both delicious and deadly.

                        WHO (THE HERO): 

                        


                        WHERE (THE ORIGIN):

                        


                        WHY (THE MOTIVATION):

                        """);

                    case "8" -> System.out.println("""

                        Chief Khai - The Whistle Warrior

                        A disciplined fighter who leads with honor and integrity.
                        His whistle commands respect and his combat skills are unmatched.

                        WHO (THE HERO): 

                        Kuya Guard, the ever-watchful protector at the entrance of every fast 
                        food chain. To the world, he looks like a simple security guard with 
                        a whistle and flashlight. But in truth, he is no ordinary man. He was 
                        placed there by unseen hands, disguised to watch, control, and report 
                        to his hidden masters.


                        WHERE (THE ORIGIN):

                        He wandered from chain to chain—McDo, KFC, Jollibee, Wendy’s, always the 
                        same uniform, always the same whistle. Nobody questioned why every branch 
                        had the same face guarding its doors. He was everywhere, yet belonged nowhere, 
                        like a shadow hired to keep order but also to keep secrets.


                        WHY (THE MOTIVATION):

                        What people don’t know is that Kuya Guard is deep in debt. Someone offered him 
                        money he couldn’t refuse. In exchange, he follows their orders, keeping the 
                        players in line, blocking their joy, and maintaining control. He tells himself 
                        it’s only for survival… but behind every whistle, there is guilt. And the players 
                        must never discover who he truly serves—at least, not yet.


                        """);


                    case "9" -> {
                        return;
                    }

                    default -> System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
