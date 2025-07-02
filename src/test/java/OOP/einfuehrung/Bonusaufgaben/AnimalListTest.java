package OOP.einfuehrung.Bonusaufgaben;

import org.example.OOP.einfuehrung.Bonusaufgaben.Animal.Animal;
import org.example.OOP.einfuehrung.Bonusaufgaben.Animal.AnimalList;
import org.example.OOP.einfuehrung.Bonusaufgaben.Animal.AnimalListItem;
import org.junit.Test;

public class AnimalListTest {

    @Test
    public void testAnimal(){
        Animal a = new Animal("Elephant");
        assert(a.getName().equals("Elephant"));
    }

    @Test
    public void testAnimalListItem(){
        AnimalListItem a = new AnimalListItem(new Animal("Elephant"));
        a.setNext(new AnimalListItem(new Animal("Peter")));

        assert(a.getValue().getName().equals("Elephant"));
        assert(a.getNext().getValue().getName().equals("Peter"));
    }

    @Test
    public void testBuildList(){
        Animal[] animals = {new Animal("Elephant"), new Animal("Tiger"), new Animal("Fuchs")};
        AnimalList list = new AnimalList(animals);
        assert(list.toString().equals("Elephant -> Tiger -> Fuchs"));
    }

    @Test
    public void testAddBuildList(){
        Animal[] animals = {new Animal("Elephant"), new Animal("Tiger"), new Animal("Fuchs")};
        AnimalList list = new AnimalList(animals);
        list.add(new Animal("Peter"));
        assert(list.toString().equals("Elephant -> Tiger -> Fuchs -> Peter"));
    }

    @Test
    public void testRemove(){
        Animal[] animals = {new Animal("Elephant"), new Animal("Tiger"), new Animal("Fuchs")};
        AnimalList list = new AnimalList(animals);
        list.remove(new Animal("Elephant"));

        assert(list.toString().equals("Tiger -> Fuchs"));
    }

    @Test
    public void testRemove2(){
        Animal[] animals = {new Animal("Elephant"), new Animal("Tiger"), new Animal("Fuchs")};
        AnimalList list = new AnimalList(animals);
        list.remove(new Animal("Tiger"));

        assert(list.toString().equals("Elephant -> Fuchs"));
    }

    @Test
    public void testRemove3(){
        Animal[] animals = {new Animal("Elephant"), new Animal("Tiger"), new Animal("Fuchs")};
        AnimalList list = new AnimalList(animals);
        list.remove(new Animal("Fuchs"));

        assert(list.toString().equals("Elephant -> Tiger"));
    }

    @Test
    public void testRemove4(){
        Animal[] animals = {new Animal("Elephant"), new Animal("Elephant"), new Animal("Elephant")};
        AnimalList list = new AnimalList(animals);
        list.remove(new Animal("Elephant"));

        assert(list.toString().isEmpty());
    }

    @Test
    public void testRemove5(){
        Animal[] animals = {new Animal("Fuchs"), new Animal("Tiger"), new Animal("Fuchs")};
        AnimalList list = new AnimalList(animals);
        list.remove(new Animal("Fuchs"));

        assert(list.toString().equals("Tiger"));
    }
}
