package org.example.OOP.collections;

public class Beutel<T> {
    BeutelItem<T> head;
    int size = 0;

    public Beutel(T ... items) {
        for (T item : items) {
            add(item);
        }
    }

    public Beutel(){

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item){
        if(head == null){
            head = new BeutelItem<>(item);
        }else {
            BeutelItem<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new BeutelItem<>(item);
        }
        ++size;
    }

    public void removeLast(){
        BeutelItem<T> current = head;
        for(int i = 0; i < size; ++i){
            if(i == size - 2){
                current.next = null;
                --size;
                return;
            }
            current = current.next;
        }
    }

    public void remove(int index){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }

        if(index == 0){
            head = head.next;
        }

        BeutelItem<T> current = head;

        for (int i = 0; i < size; ++i){
            if(i == index - 1){
                current.next = current.next.next;
                --size;
                return;
            }
            current = current.next;
        }
    }

    public int size(){
        return size;
    }

    public T get(int index){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        BeutelItem<T> current = head;
        for(int i = 0; i < index; ++i){
            current = current.next;
        }
        return current.content;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("[");
        BeutelItem<T> current = head;
        while(current != null){
            sb.append(current.content);
            if(current.next != null){
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
