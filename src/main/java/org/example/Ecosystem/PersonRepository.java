package org.example.Ecosystem;

import java.util.*;

public class PersonRepository {
    Map<Integer, Person> personMap = new HashMap<>();

    public Optional<Person> getById(int id) {
        return Optional.ofNullable(personMap.get(id));
    }

    public void put(Person person) {
        personMap.put(person.id(), person);
    }

    public Map<Gender, List<Person>> getPersonByGender() {
        Map<Gender, List<Person>> map = new HashMap<>();
        map.put(Gender.M, new ArrayList<>());
        map.put(Gender.F, new ArrayList<>());
        map.put(Gender.D, new ArrayList<>());
        for (Person p : personMap.values()) {
            switch (p.gender()) {
                case M:
                    map.get(Gender.M).add(p);
                    break;
                case F:
                    map.get(Gender.F).add(p);
                    break;
                case D:
                    map.get(Gender.D).add(p);
                    break;
            }
        }

        System.out.println("Anzahl M: " + map.get(Gender.M).size());
        System.out.println("Anzahl F: " + map.get(Gender.F).size());
        System.out.println("Anzahl D: " + map.get(Gender.D).size());

        return map;
    }

    public List<Person> getByFavoriteDay(DaysOfWeek day) {
        List<Person> personList = new ArrayList<>();
        for (Person p : personMap.values()) {
            if (p.favoriteDay().equals(day)) {
                personList.add(p);
            }
        }
        return personList;
    }

    public Optional<Person> getByName(String name) {
        for (Person p : personMap.values()) {
            if (p.name().equals(name)) {
                return Optional.of(p);
            }
        }

        return Optional.empty();
    }
}
