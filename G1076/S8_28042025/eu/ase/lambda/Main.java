package eu.ase.lambda;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Case 1: Classs implements our functional interface
class CheckPersonEligibleForService implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return p.getSex() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice Smith", Sex.FEMALE, 28, "alice.smith@example.com"));
        people.add(new Person("Bob Johnson", Sex.MALE, 45, "bob.j@example.org"));
        people.add(new Person("Clara Liu", Sex.FEMALE, 19, "clara.liu@university.edu"));
        people.add(new Person("David Müller", Sex.MALE, 33, "david.m@example.de"));
        people.add(new Person("Elena García", Sex.FEMALE, 52, "elena.garcia@correo.es"));
        people.add(new Person("Frank O’Connor", Sex.MALE, 23, "foconnor@retired.net"));
        people.add(new Person("Grace Chen", Sex.FEMALE, 12, "gracechen@school.edu"));


        System.out.println("I.");
        printPersonsOlderThan(people, 18);
        System.out.println("----------------------------");

        System.out.println("II.");
        printPersonsWithinAgeRange(people, 18, 25);
        System.out.println("----------------------------");

        System.out.println("III.");
        printPersons(people, new CheckPersonEligibleForService());
        System.out.println("----------------------------");

        // Case 2: Anonymous class
        System.out.println("IV.");
        printPersons(people, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getSex() == Sex.FEMALE && p.getAge() >= 18 && p.getAge() <= 25;
            }
        });
        System.out.println("----------------------------");

        // Case 3: Lambda expressions
        System.out.println("V.");
        printPersons(people, p -> p.getSex() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        System.out.println("----------------------------");

        // Using standard funcitonal interfaces
        System.out.println("VI.");
        printPersonsWithStandardFunctionalInterfaces(people,
                p -> p.getSex() == Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                p -> p.getEmail(),
                data -> System.out.println(data));

        // Java Streams

        System.out.println("----------------------------");
        System.out.println("----------------------------");

        long count = people.stream().count();
        System.out.println(count);

        // mapToInt to get max age
        int maxAge = people.stream().mapToInt(p -> p.getAge()).max().getAsInt();
        System.out.println(maxAge);

        // One liner to print all persons based on a filter
        people.stream().filter(p -> p.getAge() >= 18 && p.getAge() <= 25).forEach(p -> p.printPerson());

        // match, returns true or false
        System.out.println(people.stream().anyMatch(person -> person.getAge() >= 18 && person.getAge() <= 25));

        // Reference: https://www.baeldung.com/java-8-streams
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Using standard functional interfaces from Java
    // !!! Iterable is not one of them
    public static void printPersonsWithStandardFunctionalInterfaces(Iterable<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}

