import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTest {
    /*
    Test cases - findTailExhaustive

     */
    @Test
    public static void findTailExhaustive(){
        boolean[][] A = {{false, false, false, true},
                {false, false, false, true},
                {false, false, true, true},
                {false, false, true, false}};
        int x = 0;
        int y = 3;

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(new int[]{3, 2, 5}, SG.findTailExhaustive());

    }

}