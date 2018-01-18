package cz.cuni.mff;

import cz.cuni.mff.game.Board;
import cz.cuni.mff.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by David Riha on 4.7.2017.
 * Project: Simplified HearthStone java implementation
 */
// Launching the application via "Main" build configuration is only a temporary
// solution as we'll configure maven later on.
@SpringBootApplication
public class Main {

    @Autowired
    private CardFactory factory;

    @Autowired
    private Board board;

    public static void main(String[] args)
    {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        final Main mainObj = ctx.getBean(Main.class);

        System.out.println("Let's pretend we are launching the game.");
        mainObj.launchGame();

        System.out.println("The game has ended or something");
    }

    private void launchGame()
    {
        // Prepare cards that will be used
        prepareGameCards();     // TODO: Handle this in other place, differently (less statics)

        // Test card accessibility
        // This implies that our static implementation works as expected
        // System.out.println("Size of generated pack afterwards: " + CardFactory.getInstance().getAllCards().size());

        // Create two heroes
        Hero player = new Hero("FlexoCZ", true);
        Hero computer = new Hero("Anihilat0r", false);

        // Place heroes in the game
        board.putHero(player);
        board.putHero(computer);

        // Generate decks for players.
        board.prepareDecks();

        // Game loop
        // -- While both heroes health are greater than 0, loop
        int round = 0;
        while (!board.isGameOver())
        {
            System.out.println("Entering round: #" + round);

            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                System.out.println("Unable to sleep, so we're just gonna skip to another round.");
            }

            System.out.println("Leaving round: #" + round);

            round++;
            //player.decreaseHealthBy(1);
            board.drawCard(player);
            board.drawCard(computer);

            /*
            System.out.println("Press enter to proceed to another round.");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("Something went south.");
            }
            */
        }

        // Retrieve game result
        // -- Winner
        // -- Number of rounds
        // -- What else?
        String winner = (player.isDefeated()) ? computer.getName() : player.getName();
        printGameResults(winner, round);

        // Place both cards somewhere on the board
        //board.placeCard(0, BoardSides.LEFT, minion1);
        //board.placeCard(0, BoardSides.RIGHT, spell1);

    }

    private void printGameResults(String winner, int roundsTotal)
    {
        System.out.println(" === THE GAME HAS ENDED ===");
        System.out.println(" And the winner is... ");
        System.out.println(" " + winner);
        System.out.println(" Rounds played: " + roundsTotal);
        System.out.println(" === SEE YOU NEXT TIME  ===");

    }

    // In real world, this would have been stored in some sort of a database
    // and cards and their stats would be pulled from it. This is not a real
    // world, but school projects, so we stick to loading them before game
    // is launched.
    private void prepareGameCards()
    {
        // TODO: Handle SpecialEffect creation here as well so we can link them to cards
        // -- This logic will be possibly relocated to GameHelper before release.

        // Minion Cards
        factory.createMinionCard("Ogre Magi", "Intelect based troll with two heads.", 4, new SpecialEffect(), 4, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Bloodfen raptor", "", 2, new SpecialEffect(), 3, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Abomination", "", 5, new SpecialEffect(), 4, 4, MinionTypes.TAUNT);
        factory.createMinionCard("Bluegill Warrior", "", 2, new SpecialEffect(), 2, 1, MinionTypes.CHARGE);
        factory.createMinionCard("Wisp", "", 0, new SpecialEffect(), 1, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Elven Archer", "Battlecry: Deal 1 damage.", 1, new SpecialEffect(), 1, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Abusive Sergeant", "Battlecry: Give a minion +2 attack this turn.", 1, new SpecialEffect(), 1, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Emerald Reaver", "Battlecry: Deal 1 damage to each hero.", 1, new SpecialEffect(), 2, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Fire Fly", "Battlecry: Add a 1/2 minion to your hand.", 1, new SpecialEffect(), 1, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Goldshire Footman", "Taunt", 1, new SpecialEffect(), 1, 2, MinionTypes.TAUNT);
        factory.createMinionCard("Mistress of Mixtures", "Deathrattle: Restore 4 health to each hero.", 1, new SpecialEffect(), 2, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Leper Gnome", "Deathrattle: Deal 2 damage to the enemy hero.", 1, new SpecialEffect(), 1, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Stonetusk Boar", "Charge", 1, new SpecialEffect(), 1, 2, MinionTypes.CHARGE);
        factory.createMinionCard("Crazed Alchemist", "Battlecry: Swap attack and health of a minion.", 2, new SpecialEffect(), 2, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Duskboar", "", 2, new SpecialEffect(), 4, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Frostwolf grunt", "Taunt", 2, new SpecialEffect(), 2, 2, MinionTypes.TAUNT);
        factory.createMinionCard("Loot Hoarder", "Deathrattle: Draw a card.", 2, new SpecialEffect(), 2, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Mana Wraith", "ALL minions cost 1 more.", 2, new SpecialEffect(), 2, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Novice Engineer", "Battlecry: Draw a card.", 2, new SpecialEffect(), 1, 1, MinionTypes.REGULAR);
        factory.createMinionCard("River Crocolisk", "", 2, new SpecialEffect(), 2, 3, MinionTypes.REGULAR);
        factory.createMinionCard("Sunfury Protector", "Battlecry: Give adjacent \n minions Taunt.", 2, new SpecialEffect(), 2, 3, MinionTypes.REGULAR);
        factory.createMinionCard("Stonetusk Boar", "Charge", 1, new SpecialEffect(), 1, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Arcane Golem", "Battlecry: Give your  \n opponent a Mana crystal", 2, new SpecialEffect(), 4, 4, MinionTypes.REGULAR);
        factory.createMinionCard("Am'gam Rager", "", 2, new SpecialEffect(), 1, 5, MinionTypes.REGULAR);
        factory.createMinionCard("Coldlight Oracle", "Battlecry: Each player \n draws 2 cards.", 3, new SpecialEffect(), 2, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Hired Gun", "Taunt", 3, new SpecialEffect(), 4, 3, MinionTypes.TAUNT);
        factory.createMinionCard("Magma Rager", "", 3, new SpecialEffect(), 5, 1, MinionTypes.REGULAR);
        factory.createMinionCard("Raid Leader", "Your other minions have \n +1 attack.", 3, new SpecialEffect(), 2, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Shattered Sun Cleric", "Battlecry: Give a friendly minion +1/+1.", 3, new SpecialEffect(), 3, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Wolfrider", "Charge", 3, new SpecialEffect(), 3, 1, MinionTypes.CHARGE);
        factory.createMinionCard("Chillwind Yeti", "", 4, new SpecialEffect(), 4, 5, MinionTypes.REGULAR);
        factory.createMinionCard("Fire Plume Phoenix", "Battlecry: Deal 2 damage.", 4, new SpecialEffect(), 3, 3, MinionTypes.REGULAR);
        factory.createMinionCard("Gnomish Inventor", "Battlecry: Draw a card.", 4, new SpecialEffect(), 2, 4, MinionTypes.REGULAR);
        factory.createMinionCard("Oasis Snapjaw", "", 4, new SpecialEffect(), 2, 7, MinionTypes.REGULAR);
        factory.createMinionCard("Sen'jin Shieldmasta", "Taunt", 4, new SpecialEffect(), 3, 5, MinionTypes.TAUNT);
        factory.createMinionCard("Stormwind Knight", "Charge", 4, new SpecialEffect(), 2, 5, MinionTypes.CHARGE);
        factory.createMinionCard("Darkscale Healer", "Battlecry: Restore 2 health to all friendly characters.", 5, new SpecialEffect(), 4, 5, MinionTypes.REGULAR);
        factory.createMinionCard("Stormpike Commando", "Battlecry: Deal 2 damage.", 5, new SpecialEffect(), 4, 2, MinionTypes.REGULAR);
        factory.createMinionCard("Ancient of Blossoms", "Taunt", 6, new SpecialEffect(), 3, 8, MinionTypes.TAUNT);
        factory.createMinionCard("Boulderfist Ogre", "", 6, new SpecialEffect(), 6, 7, MinionTypes.REGULAR);
        factory.createMinionCard("Reckless Rocketeer", "Charge", 6, new SpecialEffect(), 5, 2, MinionTypes.CHARGE);
        factory.createMinionCard("Bog Creeper", "Taunt", 7, new SpecialEffect(), 6, 8, MinionTypes.REGULAR);
        factory.createMinionCard("War Golem", "", 7, new SpecialEffect(), 7, 7, MinionTypes.REGULAR);
        factory.createMinionCard("Alexstraza", "Battlecry: Set a hero's remaining health to 15.", 8, new SpecialEffect(), 8, 8, MinionTypes.REGULAR);
        factory.createMinionCard("Sea Giant", "Cost 1 less for each other minion on the battlefield", 10, new SpecialEffect(), 8, 8, MinionTypes.REGULAR);

        // Spell Cards
        factory.createSpellCard("Flamestrike", "Deal 4 damage to all \n enemy minions.", 7, new SpecialEffect());
        factory.createSpellCard("Hellfire", "Deal 3 damage to everyone.", 4, new SpecialEffect());
        factory.createSpellCard("Flare", "All minions \nlose Stealth. Destroy all\nenemy Secrets. Draw a\ncard.", 2, new SpecialEffect());
        factory.createSpellCard("Arcane Explosion", "Deal 1 damage to all \n enemy minions.", 2, new SpecialEffect());
        factory.createSpellCard("Arcane Intellect", "Draw 2 cards.", 3, new SpecialEffect());
        factory.createSpellCard("Fireball", "Deal 6 damage.", 4, new SpecialEffect());
        factory.createSpellCard("Power Word: Shield", "Give a minion \n +2 health. \n Draw a card.", 1, new SpecialEffect());
        factory.createSpellCard("Shadow Word: Pain", "Destroy a minion with 3 or less attack.", 2, new SpecialEffect());
        factory.createSpellCard("Shadow Word: Death", "Destroy a minion with 5 or more attack.", 3, new SpecialEffect());
        factory.createSpellCard("Bloodlust", "Give your minions +3 attack this turn", 5, new SpecialEffect());
        factory.createSpellCard("Assassinate", "Destroy an enemy minion.", 5, new SpecialEffect());
        factory.createSpellCard("Hunter's Mark", "Change a minion's \n health to 1.", 1, new SpecialEffect());

        System.out.println("Size of generated card pack is: " + factory.getAllCards().size());
    }
}
