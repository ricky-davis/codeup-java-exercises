import java.util.Scanner;
import java.util.*;

public class ConsoleAdventure {
    private static Scanner in = new Scanner(System.in);
    private String Name;
    private Hashtable<String, Integer> Traits = new Hashtable<String, Integer>();
    private static Hashtable<String, Integer> FGcolors = new Hashtable<String, Integer>();
    public static void main(String[] args) {
        FGcolors.put("black",30);
        FGcolors.put("red",31);
        FGcolors.put("green",32);
        FGcolors.put("yellow",33);
        FGcolors.put("blue",34);
        FGcolors.put("magenta",35);
        FGcolors.put("cyan",36);
        FGcolors.put("white",37);
        FGcolors.put("default",39);



        in.useDelimiter("\n");
        ConsoleAdventure player = new ConsoleAdventure();
        ConsoleAdventure enemy = new ConsoleAdventure();

        enemy.Name="AlarmClock";
        enemy.Traits.put("ap", 20);
        enemy.Traits.put("def",5);
        enemy.Traits.put("int", 0);
        enemy.Traits.put("health", 100);


        player.Name = PromptUser("Welcome Adventurer! What is your name?\n",true);
        player.Traits.put("ap", 10);
        player.Traits.put("def", 10);
        player.Traits.put("int", 10);
        player.Traits.put("health", 100);
        String ready = PromptUser("Nice to meet you "+player.Name+
                "! Your stats are:\n"+formatTraits(player,"green")
                +"\nAre you ready to start?\n",true);
        if(!ready.toLowerCase().equals("yes") && !ready.toLowerCase().equals("y") && !ready.toLowerCase().equals("ye")){
            return;
        }

        PromptUser("Enemy "+enemy.Name+" has appeared! Their stats are: \n"+formatTraits(enemy,"red"),false);



    }
    private static String getColor(String color){
        return (char)27 + "["+FGcolors.get(color)+"m";
    }
    private static String formatTraits(ConsoleAdventure member, String color){
        String leftAlignFormat = "| %-15s | %-5d |%n";
        String buffer=getColor(color);
        buffer += String.format("+-----------------+-------+%n");
        buffer += String.format("| Trait           | Value |%n");
        buffer += String.format("+-----------------+-------+%n");
        buffer += String.format(leftAlignFormat, "Health", member.Traits.get("health"));
        buffer += String.format(leftAlignFormat, "Attack Points", member.Traits.get("ap"));
        buffer += String.format(leftAlignFormat, "Defense Points", member.Traits.get("def"));
        buffer += String.format(leftAlignFormat, "Intelligence", member.Traits.get("int"));
        buffer += String.format("+-----------------+-------+%n"+getColor("default"));
        return buffer;
    }
    private static String PromptUser(String promptMessage,boolean ask){
        System.out.print(promptMessage);
        String result;
        if(ask) {
            System.out.print("> ");
            result  = in.nextLine();
        }else{
            result="";
        }
        return result;
    }
}
