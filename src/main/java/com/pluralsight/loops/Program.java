package com.pluralsight.loops;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    static void main() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("James", "Carter", 34));
        people.add(new Person("Sofia", "Martinez", 27));
        people.add(new Person("Liam", "Johnson", 45));
        people.add(new Person("Aisha", "Williams", 19));
        people.add(new Person("Noah", "Carter", 52));
        people.add(new Person("Emma", "Brown", 31));
        people.add(new Person("Marcus", "Davis", 40));
        people.add(new Person("Olivia", "Wilson", 23));
        people.add(new Person("Ethan", "Martinez", 60));
        people.add(new Person("Zoe", "Thompson", 17));
        people.add(new Person("Lucas", "Anderson", 38));
        people.add(new Person("Amara", "Johnson", 29));

        Scanner scanner = new Scanner(System.in);
        String continueSearch;
        do {
            System.out.print("Enter a first or last name to search: ");
            String search = scanner.nextLine().trim();
            List<Person> matches = new ArrayList<>();

            for (Person p : people) {
                if (p.getFirstName().equalsIgnoreCase(search) ||
                        p.getLastName().equalsIgnoreCase(search)) {
                    matches.add(p);
                }
            }
            System.out.println("\n---- Search Results for \"" + search + "\" ----");
            if (matches.isEmpty()) {
                System.out.println("No people found matching that name.");
            } else {
                for (Person p : matches) {
                    System.out.println(p);
                }
            }
            System.out.print("\nWould you like to search for another name? (yes/no): ");
            continueSearch = scanner.nextLine().trim();

        } while (continueSearch.equalsIgnoreCase("yes") || continueSearch.equalsIgnoreCase("y"));

        System.out.println("Goodbye!");


        int totalAge = 0;
        int oldest = people.getFirst().getAge();
        int youngest = people.getFirst().getAge();
        Person oldestPerson = people.getFirst();
        Person youngestPerson = people.getFirst();

        for (Person p : people) {
            totalAge += p.getAge();

            if (p.getAge() > oldest) {
                oldest = p.getAge();
                oldestPerson = p;
            }
            if (p.getAge() < youngest) {
                youngest = p.getAge();
                youngestPerson = p;
            }
        }

        double averageAge = (double) totalAge / people.size();

        System.out.println("\n---- Age Statistics ----");
        System.out.printf("Average Age:    %.1f%n", averageAge);
        System.out.println("Oldest Person:  " + oldestPerson);
        System.out.println("Youngest Person: " + youngestPerson);
    }
}

