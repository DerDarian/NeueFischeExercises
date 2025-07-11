package org.example.Ecosystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        personRepository.put(new Person(0, "A", DaysOfWeek.MONDAY, Gender.M));
        personRepository.put(new Person(1, "B", DaysOfWeek.SATURDAY, Gender.M));
        personRepository.put(new Person(2, "C", DaysOfWeek.SATURDAY, Gender.F));
        personRepository.put(new Person(3, "D", DaysOfWeek.WEDNESDAY, Gender.F));
        personRepository.put(new Person(4, "E", DaysOfWeek.FRIDAY, Gender.D));

        System.out.println(personRepository.getPersonByGender());
        System.out.println(personRepository.getByFavoriteDay(DaysOfWeek.SATURDAY));

        Optional<Person> p = personRepository.getById(0);
        p.ifPresent(System.out::println);
        Optional<Person> p2 = personRepository.getById(7);
        p2.ifPresent(System.out::println);
        Optional<Person> p3 = personRepository.getByName("E");
        p3.ifPresent(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().filter(i -> i % 2 == 0).toList());
        System.out.println(list.stream().map(i -> i * 2).toList());
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println(list.stream().sorted().toList());
        System.out.println(list.stream().reduce(0, Integer::sum));
        list.forEach(System.out::println);
        List<Integer> list2 = list.stream().map(i -> i * 2).toList();
        System.out.println(list2);
        try {
            InputStream inputStream = Main.class.getResourceAsStream("/students.csv");
            assert inputStream != null;
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                br.lines().skip(1).filter(line -> !line.isEmpty()).distinct().map(
                        line -> {
                            String[] params = line.split(",");
                            return new Student(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]));
                }).forEach(System.out::println);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
