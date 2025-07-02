package org.example.OOP.einfuehrung.Bonusaufgaben.Animal;

public class AnimalListItem {
    Animal value;
    AnimalListItem next;
    public AnimalListItem(Animal value){
        this.value = value;
    }

    public void setNext(AnimalListItem next){
        this.next = next;
    }

    public Animal getValue() {
        return value;
    }

    public AnimalListItem getNext() {
        return next;
    }

    @Override
    public String toString() {
        String returnValue = value.toString();
        if(next != null){
            returnValue += " -> ";
            returnValue += next.toString();
        }
        return returnValue;
    }
}
