import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();


        // FILTER
        List<Person> females = people.stream().filter(person -> person.getGander().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        // FILTER
        List<Person> Male = people.stream().filter(person -> person.getGander().equals(Gender.MALE)).collect(Collectors.toList());
        Male.forEach(System.out::println);

        //   SORT
        List<Person> Sorted = people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                .collect(Collectors.toList());
        Sorted.forEach(System.out::println);

        //   All match or anymatch

        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 30);
        System.out.println(anyMatch);

        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("Antionio"));
        System.out.println(noneMatch);


        //      max
        people.stream().max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //      mini
        people.stream().min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //    grup

        Map<Gender, List<Person>> grupByGemder = people.stream()
                .collect(Collectors.groupingBy(Person::getGander));

        grupByGemder.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();

        });

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond ", 40, Gender.MALE),
                new Person("Lukas Podolski ", 21, Gender.MALE),
                new Person("Tailor Switch ", 33, Gender.FEMALE),
                new Person("Harry Potter ", 55, Gender.MALE),
                new Person("Hermiona Grender ", 69, Gender.FEMALE),
                new Person("Ginger Guy ", 66, Gender.MALE),
                new Person("Blond Girl ", 33, Gender.FEMALE),
                new Person("Ginger Girl ", 88, Gender.FEMALE),
                new Person("Tony Howk ", 54, Gender.MALE)
        );
    }
}
