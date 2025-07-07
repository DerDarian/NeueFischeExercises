package org.example.OOP.collections;

public class BeutelItem<T> {
    T content;
    BeutelItem<T> next;

    public BeutelItem(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public BeutelItem<T> getNext() {
        return next;
    }

    public void setNext(BeutelItem<T> next) {
        this.next = next;
    }
}
