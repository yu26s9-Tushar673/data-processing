package com.pluralsight.streams;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    static void main() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("James",   "Carter",   34));
        people.add(new Person("Sofia",   "Martinez", 27));
        people.add(new Person("Liam",    "Johnson",  45));
        people.add(new Person("Aisha",   "Williams", 19));
        people.add(new Person("Noah",    "Carter",   52));
        people.add(new Person("Emma",    "Brown",    31));
        people.add(new Person("Marcus",  "Davis",    40));
        people.add(new Person("Olivia",  "Wilson",   23));
        people.add(new Person("Ethan",   "Martinez", 60));
        people.add(new Person("Zoe",     "Thompson", 17));
        people.add(new Person("Lucas",   "Anderson", 38));
        people.add(new Person("Amara",   "Johnson",  29));

        Scanner scanner = new Scanner(System.in);
        String continueSearch = "yes";

        do {
            System.out.print("Enter a first or last name to search: ");
            String search = scanner.nextLine().trim();

            List<Person> matches = people.stream()
                            .filter(p -> p.getFirstName().equalsIgnoreCase(search) || p.getLastName().equalsIgnoreCase(search))
                                    .toList();

            System.out.println("\n---- Search Results for \"" + search + "\" ----");
            if (matches.isEmpty()) {
                System.out.println("No people found matching that name.");
            } else {
                matches.forEach(System.out::println);
            }

            System.out.print("\nWould you like to search for another name? (yes/no): ");
            continueSearch = scanner.nextLine().trim();
        } while (continueSearch.equalsIgnoreCase("yes") || continueSearch.equalsIgnoreCase("y"));


        double averageAge = people.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum) / (double) people.size();

        Person oldest = people.stream()
                .sorted((p1, p2) -> p2.getAge() - p1.getAge()) // sort descending
                .findFirst()
                .orElse(null);

        Person youngest = people.stream()
                .sorted((p1, p2) -> p1.getAge() - p2.getAge()) // sort ascending
                .findFirst()
                .orElse(null);

        System.out.println("\n---- Age Statistics ----");
        System.out.printf("Average Age:     %.1f%n", averageAge);
        System.out.println("Oldest Person:   " + oldest);
        System.out.println("Youngest Person: " + youngest);

    }
}
