import org.example.PlayerCharacter;
import org.junit.Test;

public class TDDTests {

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
}
