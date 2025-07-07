package org.example.OOP.collections;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sack<T> {
    private T[] content;
    private int length = 0;
    Class<T> clazz;

    public Sack(Class<T> c){
        this.clazz = c;
        @SuppressWarnings("unchecked")
        final T[] a = (T[]) Array.newInstance(c, 10);
        this.content = a;
    }

    public void add(T t){
        if(length == content.length){
            @SuppressWarnings("unchecked")
            final T[] a = (T[]) Array.newInstance(clazz, content.length + 10);
            System.arraycopy(content,0,a,0,content.length);
            content = a;
        }
        content[length] = t;
        ++length;
    }

    public T get(int index){
        if(index >= length){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return content[index];
    }

    public int size(){
        return length;
    }

    public void removeLast(){
        content[length - 1] = null;
        --length;
    }

    public void remove(int index){
        if(index >= length){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        @SuppressWarnings("unchecked")
        final T[] a = (T[]) Array.newInstance(clazz, content.length);
        int reached = 0;
        for (int i = 0; i < length; ++i){
            if(i == index){
                ++reached;
                continue;
            }
            a[i - reached] = content[i];
        }
        content = a;
        --length;
    }

    public void print(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; ++i){
            sb.append(content[i]);
            if(i != length-1)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

}
