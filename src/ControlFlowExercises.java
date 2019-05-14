public class ControlFlowExercises {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            String buffer="";
            if(i%3==0)buffer+="Fizz";
            if(i%5==0)buffer+="Buzz";
            System.out.println(buffer==""?i:buffer);
        }
    }
}
