package group3;

public class Smurf {
    private String name;
    private String gender;
    private String[] clothes;
    private String[] traits;

    public Smurf(String name, String gender, String[] clothes, String[] traits) {
        this.name = name;
        this.gender = gender;
        this.clothes = clothes;
        this.traits = traits;
    }

    public void displayTraits() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Clothes: " + String.join(", ", clothes));
        System.out.println("Traits: " + String.join(", ", traits));
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        // Create instances of Smurf
        Smurf papaSmurf = new Smurf("Papa Smurf", "Male",
                new String[]{"red clothes", "White hair/beard"},
                new String[]{"Old", "Smart", "Brave", "Problem solver", "Leadership", "Easily irritated", "Magician"});

        Smurf smurfette = new Smurf("Smurfette", "Female",
                new String[]{"Skirt", "Blonde hair"},
                new String[]{"Beautiful", "Smart", "Curious", "Brave", "Jokey", "Helpful", "Ambitious", "Independent", "Leadership"});

        Smurf brainySmurf = new Smurf("Brainy Smurf", "Male",
                new String[]{"Glasses", "Book"},
                new String[]{"Smart", "Self-centered", "Arrogant", "Boastful", "Leadership", "Confident"});

        Smurf heftySmurf = new Smurf("Hefty Smurf", "Male",
                new String[]{"Tattoo", "muscles"},
                new String[]{"Strong", "Helpful", "Brave", "Boastful", "Easily irritated", "Athletic", "Confident", "Stupid"});

        Smurf vanitySmurf = new Smurf("Vanity Smurf", "Male",
                new String[]{"Beautiful", "Mirror", "Flower"},
                new String[]{"Self-centered", "Creative", "Uncertain", "Thoughtful", "Tailor"});

        Smurf grouchySmurf = new Smurf("Grouchy Smurf", "Male",
                new String[]{"Sour", "Stoic", "No humor"},
                new String[]{"Brave", "Humble"});

        Smurf sassette = new Smurf("Sassette", "Female",
                new String[]{"Children", "Brown hair", "Freckles"},
                new String[]{"Sweet", "Happy expression", "Curious", "Talkative", "Tomboy"});

        Smurf clumsySmurf = new Smurf("Clumsy Smurf", "Male",
                new String[]{"Hanging hat", "Clumsy", "Daydreamer"},
                new String[]{"Helpful", "Kind", "Brave", "Stupid"});

        Smurf handySmurf = new Smurf("Handy Smurf", "Male",
                new String[]{"Work clothes", "Pen"},
                new String[]{"Creative", "Problem solver", "Ambitious", "Helpful", "Easily irritated", "Builder"});

        Smurf babySmurf = new Smurf("Baby Smurf", "Male",
                new String[]{"Children"},
                new String[]{"Sweet", "Happy expression", "Independent", "Smart", "Mischievous", "Playful", "Curious", "Easily irritated", "Magical powers"});

        Smurf jokeySmurf = new Smurf("Jokey Smurf", "Male",
                new String[]{"Carry on joker gift"},
                new String[]{"Happy", "Jokey", "Mischievous", "Playful"});

        // Display traits of the Smurfs
        papaSmurf.displayTraits();
        smurfette.displayTraits();
        brainySmurf.displayTraits();
        heftySmurf.displayTraits();
        vanitySmurf.displayTraits();
        grouchySmurf.displayTraits();
        sassette.displayTraits();
        clumsySmurf.displayTraits();
        handySmurf.displayTraits();
        babySmurf.displayTraits();
        jokeySmurf.displayTraits();
    }
}