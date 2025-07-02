package org.example.OOP.einfuehrung.Bonusaufgaben.Animal;

public class AnimalList {
    AnimalListItem head;

    public AnimalList(Animal ... animals){

        if(animals==null || animals.length==0) return;

        head = new AnimalListItem(animals[0]);

        AnimalListItem current = head;
        for(int i = 1; i < animals.length; i++){
            current.next = new AnimalListItem(animals[i]);
            current = current.next;
        }
    }

    public void add(Animal animal){
        AnimalListItem current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new AnimalListItem(animal);
    }

    public void remove(Animal animal){
        AnimalList newList =  new AnimalList();
        AnimalListItem current = head;
        while(current != null){
            if(!current.getValue().equals(animal)){
                if(newList.head == null)
                    newList.head = new AnimalListItem(current.getValue());
                else
                    newList.add(current.getValue());
            }
            current = current.next;
        }
        this.head = newList.head;
    }

    @Override
    public String toString() {
        if(head == null){
            return "";
        }
        return head.toString();
    }
}
