public class Person {
    private String name;

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("John");
        person1.sayHello();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void sayHello(){
        System.out.println("Hello, "+this.getName()+"!");
    }
}
