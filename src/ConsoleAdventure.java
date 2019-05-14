import java.util.Scanner;
import java.util.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ConsoleAdventure {
    private static Scanner in = new Scanner(System.in);
    private String Name;
    private Hashtable<String, Float> Traits = new Hashtable<String, Float>();
    private static Hashtable<String, Integer> Colors = new Hashtable<String, Integer>();
    public static void main(String[] args) {
        Colors.put("black",0);
        Colors.put("red",1);
        Colors.put("green",2);
        Colors.put("yellow",3);
        Colors.put("blue",4);
        Colors.put("magenta",5);
        Colors.put("cyan",6);
        Colors.put("white",7);
        Colors.put("default",9);



        in.useDelimiter("\n");
        ConsoleAdventure player = new ConsoleAdventure();
        ConsoleAdventure enemy = new ConsoleAdventure();

        enemy.Name="AlarmClock";


        player.Name = PromptUser("Welcome Adventurer! What is your name?\n",true);
        player.Traits.put("ap", 10F);
        player.Traits.put("def", 10F);
        player.Traits.put("int", 11F);
        player.Traits.put("health", 100F);
        player.Traits.put("tempHealth", player.Traits.get("health"));
        String ready = PromptUser("Nice to meet you "+player.Name+
                "! Your stats are:\n"+formatTraits(player,"green")
                +"\nAre you ready to start?\n",true);
        if(!ready.toLowerCase().equals("yes") && !ready.toLowerCase().equals("y") && !ready.toLowerCase().equals("ye")){
            return;
        }
        clear();


        int winCount=0;
        int loseCount=0;
        int maxFights=20;
        for(int i=0;i<maxFights;i++) {
            clear();
            float mult=i/2;
            enemy.Name = "AlarmClock"+(i+1);
            Random rand = new Random();
            int n;
            n = Math.round(3+mult);
            enemy.Traits.put("ap", 6F+n);
            n = Math.round(3+mult);
            enemy.Traits.put("def",5F+n);
            n = Math.round(3+mult);
            enemy.Traits.put("int", 5F+n);
            n = Math.round(2+mult)*10;
            enemy.Traits.put("health", 80F+n);
            enemy.Traits.put("tempHealth", enemy.Traits.get("health"));
            PromptUser("Enemy "+enemy.Name+" has appeared! Their stats are: \n"+formatTraits(enemy,"red"),false);

            PromptUser("Your stats are:\n"+formatTraits(player,"green"),false);
            wait(1);
            byte winner = fightLoop(player, enemy);
            player.Traits.put("tempHealth", player.Traits.get("health"));
            enemy.Traits.put("tempHealth", enemy.Traits.get("health"));
            if (winner == 1) {
                winCount++;
                PromptUser(getColor(true,"green")+"You won!%n"+getColor(true,"default"), false);
                levelUp(player);
            } else if(winner == 0) {
                loseCount++;
                PromptUser(getColor(true,"red")+"You lose!%n"+getColor(true,"default"), false);

            }
            if(i<maxFights-1) {
                PromptUser(getColor(true, "yellow") + "Searching for new enemies...\n" + getColor(true, "default"), false);
                wait(5);
            }
        }
        System.out.println("Win/Loss: " + winCount+"/"+loseCount);


    }
    private static void levelUp(ConsoleAdventure member){
        member.Traits.put("ap", member.Traits.get("ap")*1.05F);
        member.Traits.put("def", member.Traits.get("def")*1.05F);
        member.Traits.put("int", member.Traits.get("int")*1.05F);
        member.Traits.put("health", member.Traits.get("health")*1.1F);
        member.Traits.put("tempHealth", member.Traits.get("health"));
    }
    private static void wait(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException e){}
    }
    private static void clear(){
        System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print('\u000C');
    }
    private static byte fightLoop(ConsoleAdventure member1, ConsoleAdventure member2){
        int loopCount=0;
        boolean ranAway=false;
        do{
            String fightBuffer = "a. Attack (decreases enemyHealth)\n" +
                    "b. Drink potion (adds to heroHealth)\n" +
                    "c. Run? (ends the game)\n";
            String roundOption = PromptUser("What would you like to do?\n"+fightBuffer,true);
            clear();
            if(roundOption.equals("a") || roundOption.equals("b")) {
                int damage;
                if(roundOption.equals("a")) {
                    loopCount++;
                    damage = calculateDamage(member1, member2);
                    member2.Traits.put("tempHealth", member2.Traits.get("tempHealth") - damage);
                    PromptUser(getColor(true, "green") + member1.Name + " attacked " + member2.Name + " for " + damage + " damage.%n", false);
                    PromptUser(formatTraits(member2, "red"), false);
                    if (member2.Traits.get("tempHealth") <= 0) break;
                }else {
                    member1.Traits.put("tempHealth", member1.Traits.get("tempHealth") + 30);
                    PromptUser(getColor(true, "green") + member1.Name + " healed 30 HP to "+member1.Traits.get("tempHealth")+".%n", false);
                    if (member1.Traits.get("tempHealth") > member1.Traits.get("health")) {
                        member1.Traits.put("tempHealth", member1.Traits.get("health"));
                    }
                }

                //wait(1);
                damage = calculateDamage(member2, member1);
                member1.Traits.put("tempHealth", member1.Traits.get("tempHealth") - damage);
                PromptUser(getColor(true,"red")+member2.Name + " attacked " + member1.Name + " for " + damage + " damage.%n", false);
                PromptUser(formatTraits(member1, "green"), false);
                //wait(3);
            }else{
                ranAway=true;
                break;
            }
        }while(member2.Traits.get("tempHealth") > 1 && member1.Traits.get("tempHealth") > 1);
        if(ranAway) {
            System.out.println("Ran away after " + loopCount + " rounds!");
            return -1;
        }else{
            System.out.println("Match finished after " + loopCount + " rounds!");
            return (byte)(member2.Traits.get("tempHealth")<=0?1:0);
        }
    }
    private static int calculateDamage(ConsoleAdventure attacker, ConsoleAdventure defender){
        float damageDone;
        Random rand = new Random();
        int rounded = Math.round(defender.Traits.get("int"));
        int n = rand.nextInt(rounded-5)+4;
        float enemyDef = (defender.Traits.get("def")*(n));
//        System.out.println(n);
//        System.out.println(enemyDef);
        rounded = Math.round(attacker.Traits.get("int"));
        n = rand.nextInt(rounded-5)+5;
        float enemyAtt = (attacker.Traits.get("ap")*(n));
//        System.out.println(n);
//        System.out.println(enemyAtt);

        damageDone = enemyAtt-enemyDef;
        if(damageDone < 1) damageDone=1;
        if(damageDone > defender.Traits.get("tempHealth")) damageDone = defender.Traits.get("tempHealth");
        return (int) damageDone;
    }
    private static String getColor(boolean fg, String color){
        int mod;
        if(fg){
            mod=30;
        }else{
            mod=40;
        }
        return (char)27 + "["+(mod+Colors.get(color))+"m";
    }
    private static String formatTraits(ConsoleAdventure member, String color){
        String leftAlignFormat = getColor(true,color)+"|"+getColor(true,"default")
                +" %-15s "+getColor(true,color)+"|"+getColor(true,"default")
                +" %-5.1f "+getColor(true,color)+"|%n";

        String buffer="";
        buffer += String.format(getColor(true,color)+"+-----------------+-------+%n");
        buffer += String.format("| Trait           | Value |%n");
        buffer += String.format("+-----------------+-------+%n");
        buffer += String.format(leftAlignFormat, "Health", member.Traits.get("tempHealth"));
        buffer += String.format(leftAlignFormat, "Attack Points", member.Traits.get("ap"));
        buffer += String.format(leftAlignFormat, "Defense Points", member.Traits.get("def"));
        buffer += String.format(leftAlignFormat, "Intelligence", member.Traits.get("int"));
        buffer += String.format("+-----------------+-------+%n"+getColor(true,"default"));
        return buffer;
    }
    private static String PromptUser(String promptMessage,boolean ask){
        System.out.printf(promptMessage);
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
