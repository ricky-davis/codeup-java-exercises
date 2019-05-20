import java.util.Random;
public class ServerNameGenerator {
    public static void main(String[] args) {
        String[] adjectives={
            "lumpy",
            "rampant",
            "lame",
            "annoying",
            "zealous",
            "sparkling",
            "soggy",
            "malicious",
            "voracious",
            "alcoholic",
            "spicy",
        };
        String[] nouns={
            "dog",
            "box",
            "battle",
            "monkey",
            "truck",
            "brick",
            "man",
            "thumb",
            "oatmeal",
            "worm",
            "ladybug",
        };
        System.out.println(randElement(adjectives)+"-"+randElement(nouns));
    }
    public static String randElement(String[] array){
        Random rand = new Random();
        return array[rand.nextInt(array.length)];
    }
}
