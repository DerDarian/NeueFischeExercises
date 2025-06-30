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
    }
}
