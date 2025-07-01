package org.example.basics;

public class PlayerCharacter {
    int positionX = 0;
    int positionY = 0;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void move(String direction) {
        direction = direction.toUpperCase();
        switch (direction) {
            case "W": ++positionY; break;
            case "S": --positionY; break;
            case "A": --positionX; break;
            case "D": ++positionX; break;
        }
    }

}
