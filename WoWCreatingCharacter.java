package WoWCreatingCharacter;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * My program is a character creator on the very popular game World of Warcraft.
 * You will be choosing your faction, race, class, and gender.
 * Each faction has a specific set of races, and each race has a specific set of classes.
 * @author Jenna
 */
public class WoWCreatingCharacter {

    private static final Scanner scanner = new Scanner(System.in);
    private static String userSelection;

    // These are the selectable races for each faction.
    private static final String[] allianceRaces = new String[]{"Human", "Dwarf", "Night Elf", "Gnome", "Draenei", "Worgen", "Pandaren (Alliance)"};
    private static final String[] hordeRaces = new String[]{"Orc", "Undead", "Tauren", "Troll", "Blood Elf", "Goblin", "Pandaren (Horde)"};

    public static void main(String[] args) {

        System.out.println("Hello, this program will guide us through creating a World of Warcraft character!");
        System.out.println("You will be choosing your faction, race, class, and gender.");
        System.out.println("Type in the number that corresponds with your answer.\n");

        String[] selectedRaces = SetUserFaction();

        Race race = SetUserRace(selectedRaces);

        String selectedClass = SetUserClass(race);

        String selectedGender = SetUserGender();

        System.out.println("Your " + selectedGender + " " + race.getRaceName() + " " + selectedClass + " is ready to fight for the " + race.getFaction() + "!");
    }

    // Makes user choose between two factions. Each faction has a different set of races.
    private static String[] SetUserFaction() {
        String selectedFaction;
        String[] selectableRaces = null;
        boolean validResponse = false;
        do {
            System.out.println("What faction would you like to be part of?\n(1) The Alliance \n(2) The Horde");
            userSelection = scanner.nextLine();
            if (userSelection.equals("1")) {
                selectedFaction = "Alliance";
                validResponse = true;
                selectableRaces = allianceRaces;
            } else if (userSelection.equals("2")) {
                selectedFaction = "Horde";
                validResponse = true;
                selectableRaces = hordeRaces;
            } else {
                System.out.println("Error: User entered an invalid response. Please try again.");
            }
        } while (!validResponse);
        return selectableRaces;
    }
    
    // Makes user choose between seven races. Each race has a different set of classes.
    private static Race SetUserRace(String[] selectedRaces) {
        String selectedRace = "";
        Race race;
        boolean validResponse = false;
        System.out.print("Fantastic! Now... ");
        do {
            int counter = 1;
            System.out.println("What race would you like to be?");
            for (String specifiedRace : selectedRaces) {
                System.out.println("(" + String.valueOf(counter) + ") " + specifiedRace);
                ++counter;
            }
            userSelection = scanner.nextLine();
            try {

                selectedRace = (String) Array.get(selectedRaces, Integer.parseInt(userSelection) - 1);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Error: User entered an invalid response. Please try again.");
            }
            switch (selectedRace) {
                case "Human":
                    race = Human();
                    validResponse = true;
                    break;
                case "Dwarf":
                    race = Dwarf();
                    validResponse = true;
                    break;
                case "Night Elf":
                    race = NightElf();
                    validResponse = true;
                    break;
                case "Gnome":
                    race = Gnome();
                    validResponse = true;
                    break;
                case "Draenei":
                    race = Draenei();
                    validResponse = true;
                    break;
                case "Worgen":
                    race = Worgen();
                    validResponse = true;
                    break;
                case "Pandaren (Alliance)":
                    race = AlliancePandaren();
                    validResponse = true;
                    break;
                case "Orc":
                    race = Orc();
                    validResponse = true;
                    break;
                case "Undead":
                    race = Undead();
                    validResponse = true;
                    break;
                case "Tauren":
                    race = Tauren();
                    validResponse = true;
                    break;
                case "Troll":
                    race = Troll();
                    validResponse = true;
                    break;
                case "Blood Elf":
                    race = BloodElf();
                    validResponse = true;
                    break;
                case "Goblin":
                    race = Goblin();
                    validResponse = true;
                    break;
                case "Pandaren (Horde)":
                    race = HordePandaren();
                    validResponse = true;
                    break;
                default:
                    race = null;
            }
        } while (!validResponse);
        return race;
    }

    // Makes user choose between a set of classes for their selected race.
    private static String SetUserClass(Race race) {
        String selectedClass = "";
        boolean validResponse = false;
        System.out.print("Awesome! ");
        do {
            System.out.println("What class would you like to be?");
            int counter = 1;
            for (String wowClass : race.getClasses()) {
                System.out.println("(" + String.valueOf(counter) + ") " + wowClass);
                ++counter;
            }
            userSelection = scanner.nextLine();
            try {
                selectedClass = (String) Array.get(race.getClasses(), Integer.parseInt(userSelection) - 1);
                validResponse = true;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Error: User entered an invalid response. Please try again.");
            }
        } while (!validResponse);
        return selectedClass;

    }

    // Makes user choose between male or female.
    private static String SetUserGender() {
        String selectedGender = "";
        boolean validResponse = false;
        do {
            System.out.println("What gender would you like your character to be? \n(1) Male \n(2) Female");
            userSelection = scanner.nextLine();
            if (userSelection.equals("1")) {
                selectedGender = "Male";
                validResponse = true;
            } else if (userSelection.equals("2")) {
                selectedGender = "Female";
                validResponse = true;
            } else {
                System.out.println("Error: User entered an invalid response. Please try again.");
            }
        } while (!validResponse);
        return selectedGender;
    }

    // Preloaded Race objects that contain each race's selectable classes.
    private static Race Human() {
        String[] humanClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Paladin", "Monk", "Death Knight"};
        return new Race("Human", humanClasses, "Alliance");
    }

    private static Race Dwarf() {
        String[] dwarfClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Paladin", "Shaman", "Monk", "Death Knight"};
        return new Race("Dwarf", dwarfClasses, "Alliance");
    }

    private static Race NightElf() {
        String[] nightElfClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Druid", "Monk", "Demon Hunter", "Death Knight"};
        return new Race("Night Elf", nightElfClasses, "Alliance");
    }

    private static Race Gnome() {
        String[] gnomeClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Monk", "Death Knight"};
        return new Race("Gnome", gnomeClasses, "Alliance");
    }

    private static Race Draenei() {
        String[] draeneiClasses = new String[]{"Warrior", "Hunter", "Mage", "Priest", "Paladin", "Shaman", "Monk", "Death Knight"};
        return new Race("Draenei", draeneiClasses, "Alliance");
    }

    private static Race Worgen() {
        String[] worgenClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Druid", "Death Knight"};
        return new Race("Worgen", worgenClasses, "Alliance");
    }

    private static Race AlliancePandaren() {
        String[] alliancePandarenClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Shaman", "Monk", "Death Knight"};
        return new Race("Pandaren", alliancePandarenClasses, "Alliance");
    }

    private static Race Orc() {
        String[] orcClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Warlock", "Shaman", "Monk", "Death Knight"};
        return new Race("Orc", orcClasses, "Horde");
    }

    private static Race Undead() {
        String[] undeadClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Monk", "Death Knight"};
        return new Race("Undead", undeadClasses, "Horde");
    }

    private static Race Tauren() {
        String[] taurenClasses = new String[]{"Warrior", "Hunter", "Priest", "Paladin", "Druid", "Shaman", "Monk", "Death Knight"};
        return new Race("Tauren", taurenClasses, "Horde");
    }

    private static Race Troll() {
        String[] trollClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Druid", "Shaman", "Monk", "Death Knight"};
        return new Race("Troll", trollClasses, "Horde");
    }

    private static Race BloodElf() {
        String[] bloodElfClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Paladin", "Monk", "Demon Hunter", "Death Knight"};
        return new Race("Blood Elf", bloodElfClasses, "Horde");
    }

    private static Race Goblin() {
        String[] goblinClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Warlock", "Shaman", "Death Knight"};
        return new Race("Goblin", goblinClasses, "Horde");
    }

    private static Race HordePandaren() {
        String[] hordePandarenClasses = new String[]{"Warrior", "Hunter", "Mage", "Rogue", "Priest", "Shaman", "Monk", "Death Knight"};
        return new Race("Pandaren", hordePandarenClasses, "Horde");
    }
}

// Race object that will contain the race's name, faction, and list of selectable classes.
class Race {

    private final String raceName;
    private final String[] selectableClasses;
    private final String faction;

    public Race(String raceName, String[] selectableClasses, String faction) {
        this.raceName = raceName;
        this.selectableClasses = selectableClasses;
        this.faction = faction;
    }

    public String getRaceName() {
        return raceName;
    }

    public String[] getClasses() {
        return selectableClasses;
    }

    public String getFaction() {
        return faction;
    }

}
