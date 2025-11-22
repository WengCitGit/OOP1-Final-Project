package Main;
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

         ────────────────────────────────────────────────────────────────────────────────────────────────────────────
    ()==(                                  O R I G I N S    O F    T H E    F E U D                                 (@==()
         '__________________________________________________________________________________________________________'|
            |                                                                                                        |
            |                                                                                                        |
            |                                                                                                        |
            |    In a world where fast food mascots are more than mere icons, an invisible storm brews.              |
            |    Rivalries spark, alliances form, and battles erupt across cities, kitchens, and                     |
            |    abandoned amusement parks. Once symbols of joy and comfort, the mascots are now drawn               |
            |    into a mysterious competition—where the stakes are higher than fries, chicken, or pizza.            |
            |                                                                                                        |       
            |    The orphanage, once a sanctuary of warmth and discipline under Colonel KFC and his wife,            |
            |    has become a central beacon for these heroes. Each mascot has a connection—whether as a             |
            |    former child, caretaker, or wandering ally—tying them together in a fragile network of              |
            |    trust. Yet even as they fight, something unseen watches from the shadows, twisting events           |
            |    and bending the rules.                                                                              |
            |                                                                                                        |
            |    Rumors whisper through arenas and kitchens: strange glitches, masked figures, and vanishing         |
            |    messages. The heroes sense it—a presence orchestrating chaos, rewarding victory one moment,         |
            |    punishing mercy the next. No one knows who controls the strings, but every battle seems to          |
            |    serve a hidden purpose.                                                                             |
            |                                                                                                        |
            |    As mascots sharpen their skills, form friendships, and test their strength, the game world          |
            |    grows stranger. Alliances crumble, betrayals sting, and even the most loyal heroes begin to         |
            |    doubt: is the rival across from them the true enemy, or something far more sinister hiding          |
            |    behind the screen?                                                                                  |
            |                                                                                                        |
            |    The battle has begun—but the real war is still unseen. Only the strongest, cleverest, and           |
            |    most determined will survive the coming storm… and perhaps uncover the truth behind the             |
            |    invisible hand controlling it all.                                                                  |
            |                                                                                                        |
         ___________________________________________________________________________________________________________ |
    ()==(                                                                                                          (@==()
         '----------------------------------------------------------------------------------------------------------'

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

                        Harland “Colonel” Sanders became more than a man—he became a father 
                        figure. Having struggled through hardship himself, he saw the value of 
                        discipline, patience, and care. Strict but loving, he raised a family 
                        of lost children in his roadside restaurant, turning fried chicken into 
                        lessons of perseverance and life skills. His wife, Claudia Price, was 
                        the heart of the home, nurturing the children, while he was the shield, 
                        defending them from the storms of life. Honored as “Colonel of Kentucky” 
                        in 1935 for his contributions to the state, Sanders carried that same 
                        protective spirit into every kitchen and battlefield.


                        WHERE (THE ORIGIN):

                        Long before the golden buckets and famous slogans, Colonel Sanders 
                        was just a simple man with an iron skillet and a stubborn dream.
                        During the Great Depression, he ran a small roadside restaurant in 
                        Kentucky, serving fried chicken made from his secret recipe. When 
                        he saw abandoned children roaming the roads, he took them in—teaching 
                        them not only to cook, but to live with discipline, hard work, and love. 
                        The diner became a home… and the home became an orphanage, protected 
                        under his care.

                        WHY (THE MOTIVATION):

                        Now, a new storm brews. Rival mascots, greedy corporations, and twisted 
                        chefs threaten to consume the world in chaos and gluttony. The Colonel 
                        enters the Fast Feuds not for glory—but for his family. He fights to 
                        protect his wife, who now stands as the orphanage’s beating heart, and 
                        to test his children, ensuring they are strong enough to face whatever 
                        darkness comes next.            


                        """);

                    case "4" -> System.out.println("""

                        Burger King - The Flame Griller

                        A noble fighter who commands respect on the battlefield.
                        His royal presence and combat skills make him a formidable foe.


                        WHO (THE HERO): 

                        The Crowned Prince of the Whopper Empire. A royal born with flame in his
                        blood and pride in his crown. Though raised in golden halls, he never forgot
                        the taste of the streets. Beneath his regal charm lies a warrior’s heart, 
                        fueled by flame-grilled honor and a thirst for challenge. Known for his 
                        confident grin and fiery wit, Burger King believes that true royalty is not 
                        inherited, it is earned, one victory at a time.

                        
                        WHERE (THE ORIGIN):

                        As a child, the young prince was sent to an orphanage in secret after assassins 
                        threatened his family’s throne. Hidden among ordinary children, he learned 
                        humility, hunger, and the simple joy of a freshly grilled burger. Years later, 
                        when the truth of his lineage was revealed, he reclaimed his title not with 
                        armies, but with ambition, rebuilding the Whopper Empire from the ashes. Now, 
                        his flame burns across kingdoms, his banners flying wherever the scent of smoky 
                        beef fills the air.


                        WHY (THE MOTIVATION):

                        Tired of the silence of the throne and drawn by the thrill of combat, Burger King 
                        joins the grand fighting competition, not out of vengeance or despair, but for pure 
                        enjoyment. To him, every battle is a feast, every rival a new flavor to savor. Yet 
                        beneath the laughter and bravado, the prince seeks something deeper, proof that even 
                        a king must fight for his crown, that greatness is not given, it is grilled, forged, 
                        and earned through fire.
                            

                        """);

                    case "5" -> System.out.println("""

                        Wendy's - The Sassy Red Fighter

                        A spirited combatant known for her fierce determination.
                        Her fiery attacks and quick reflexes make her a tough opponent.


                        WHO (THE HERO): 

                        Wendy is the only girl in the orphanage, known for her fiery spirit and quick wit. 
                        She became the favorite of Colonel KFC’s wife, who treated her like a daughter. 
                        Though young, she carries the weight of loss and responsibility on her shoulders. 
                        Her charm hides a fierce determination to survive and protect those she loves.


                        WHERE (THE ORIGIN):

                        


                        WHY (THE MOTIVATION):

                        Though she smiles and plays like the other children, she harbors a deep secret.
                        she recently discovered that the one responsible for her father’s death is somewhere 
                        in this chaotic game world. She doesn’t yet know who, only that the answer lies within 
                        the arena of the game. Her journey is fueled by the desire for justice and closure, 
                        tempered by the love she received from KFC’s wife—a reminder of what she is fighting 
                        to protect, and why she cannot afford to lose.            

                       
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

                        A wealthy philanthropist known for spreading food and hope, he became a 
                        legend among the orphanage kids. Despite his fortune, he is humble and 
                        hands-on, always serving alongside those he helps. His presence brings a 
                        sense of security and warmth to those around him. Even in the chaos of battle, 
                        he carries the aura of generosity like armor.
                        

                        WHERE (THE ORIGIN):

                        While traveling the world delivering charity, he stumbled upon KFC’s orphanage 
                        and was moved by its mission. Inspired, he began donating and personally aiding 
                        the children, leaving traces of his kindness in every corner. In 1985, his Love 
                        Kitchen initiative started providing free pizza to the hungry and homeless 
                        nationwide. Every journey strengthened his resolve to protect the innocent from 
                        the world’s harshness.
                        

                        WHY (THE MOTIVATION):
                        During his charitable travels, he uncovered the dark plans of the mysterious forces 
                        controlling the game world. Attempting to intervene, his memory was tampered with, 
                        making him forget his true purpose. Now, he fights alongside—or against—anyone, 
                        driven by fragmented visions and flashes of the truth. Every encounter is a puzzle, 
                        and every ally could be an enemy in disguise.


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
