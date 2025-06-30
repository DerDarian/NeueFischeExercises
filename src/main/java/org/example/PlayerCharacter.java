package org.example;

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
        ++positionY;
    }
}
