package basics;

import org.example.basics.Fibonacci;
import org.example.basics.PlayerCharacter;
import org.junit.Test;

public class BasicsTests {

    @Test
    public void testGetXStart(){

        PlayerCharacter playerCharacter = new PlayerCharacter();

        assert(0 == playerCharacter.getPositionX());
    }

    @Test
    public void testGetYStart(){

        PlayerCharacter playerCharacter = new PlayerCharacter();

        assert(0 == playerCharacter.getPositionY());
    }

    @Test
    public void testMoveW(){
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.move("W");
        assert(0 == playerCharacter.getPositionX());
        assert(1 == playerCharacter.getPositionY());

        playerCharacter.move("w");
        assert(0 == playerCharacter.getPositionX());
        assert(2 == playerCharacter.getPositionY());
    }

    @Test
    public void testMoveS(){
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.move("S");
        assert(0 == playerCharacter.getPositionX());
        assert(-1 == playerCharacter.getPositionY());

        playerCharacter.move("s");
        assert(0 == playerCharacter.getPositionX());
        assert(-2 == playerCharacter.getPositionY());
    }

    @Test
    public void testMoveD(){
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.move("D");
        assert(1 == playerCharacter.getPositionX());
        assert(0 == playerCharacter.getPositionY());

        playerCharacter.move("d");
        assert(2 == playerCharacter.getPositionX());
        assert(0 == playerCharacter.getPositionY());
    }

    @Test
    public void testMoveA(){
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.move("A");
        assert(-1 == playerCharacter.getPositionX());
        assert(0 == playerCharacter.getPositionY());

        playerCharacter.move("a");
        assert(-2 == playerCharacter.getPositionX());
        assert(0 == playerCharacter.getPositionY());
    }

    @Test
    public void testFibonacci(){
        assert(Fibonacci.getFibonacci(-30) == 0);
        assert(Fibonacci.getFibonacci(0) == 0);
        assert(Fibonacci.getFibonacci(1) == 1);
        assert(Fibonacci.getFibonacci(9) == 34);
    }

    @Test
    public void testFibonacciCustomStart(){
        assert(Fibonacci.getFibonacciCustomStart(-30, 1.5) == 1.5);
        assert(Fibonacci.getFibonacciCustomStart(0, -3.6) == -3.6);
        assert(Fibonacci.getFibonacciCustomStart(1, 18) == 36);
        assert(Fibonacci.getFibonacciCustomStart(5, -2) == -26);
        assert(Fibonacci.getFibonacciCustomStart(9, 0.7) == 62.3);
    }
}
