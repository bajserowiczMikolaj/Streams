public class Person {

    private final String name;
    private final int age;
    private final Gender gander;

    public Person(String name, int age, Gender gander) {
        this.name = name;
        this.age = age;
        this.gander = gander;
    }

    public String getName(){return name;}

    public int getAge(){return age;}

    public Gender getGander(){return gander;}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gander=" + gander +
                '}';
    }
}
