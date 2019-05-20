import java.util.Arrays;

public class ArraysExercises {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(numbers);
        Person[] personList = {new Person("Jon"),new Person("Arya"),new Person("Tyrion")};
        for (Person person : personList) {
            System.out.println(person.getName());
        }
        System.out.println("\n\n\n");
        personList = addPerson(personList,new Person("Bob"));
        for (Person person : personList) {
            System.out.println(person.getName());
        }
    }
    public static Person[] addPerson(Person[] personList, Person toAdd){
        Person[] tempList = Arrays.copyOf(personList,personList.length+1);
        tempList[tempList.length-1]=toAdd;
        return tempList;
    }
}
