public class ControlFlowExercises {
    public static void main(String[] args) {
        long i = 0;
        do{
            System.out.println(i);
            i+=2;
        }while(i<=100);
        i=100;
        do{
            System.out.println(i);
            i-=5;
        } while(i>=-10);
        i=2;
        do{
            System.out.println(i);
            i=i*i;
        }while(i<1000000);
    }
}
