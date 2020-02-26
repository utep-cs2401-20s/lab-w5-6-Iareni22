import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {
    
    //Test cases - findTailExhaustive~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    /*
    * findTailExhaustive:
    * Test case 1
    * findTailExhaustive() → B

    *    Test case ensures proper function of the method, making sure the basic functions work well and all requirements
    * are met by the test. This is a simple test that will set the precedents for further testing.
    */
    @Test //Passed
    public void findTailExhaustive1(){

        boolean[][] A = {{false, false, false, true},
                {false, false, false, true},
                {false, false, true, true},
                {false, false, true, false}};
        int x = 0;
        int y = 3;
        int[] B = {3, 2, 5};

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(B, SG.findTailExhaustive());
    }

    /*
     * findTailExhaustive:
     * Test case 2
     * findTailExhaustive() → B

     *    Test case ensures counters work properly, assuring the exhaustive counter stops at its correct value and does
     * not count excessive cells.
     */
    @Test  //Passed
    public void findTailExhaustive2(){

        boolean[][] A = {{false, false, false, true},
                {true, false, false, true},
                {true, false, true, true},
                {true, true, true, false}};
        int x = 1;
        int y = 0;
        int count = 4;

        SnakeGame SG = new SnakeGame(A, x, y);
        SG.findTailExhaustive();
        assertEquals(4, SG.getExhaustiveChecks());
    }

    /*
     * findTailExhaustive:
     * Test case 3
     * findTailExhaustive() → B

     *      Test created to make sure the method reads properly on 2-D arrays of differing length of rows and columns.
     * For loops should still work properly with no issues, collecting the length properly and returning the correct
     * value within the 3rd element of the array.
     */
    @Test  //Passed
    public void findTailExhaustive3(){

        boolean[][] A = {{true, true, false, false, false, false},
                {false, true, false, false, false, false},
                {false, true, true, false, false, false},
                {false, false, true, true, false, false},
                {false, false, false, false, false, false}};
        int x = 0;
        int y = 0;
        int[] B = {3, 3, 7};

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(B, SG.findTailExhaustive());
    }

    /*
     * findTailExhaustive:
     * Test case 4
     * findTailExhaustive() → B

     *      Test created to make sure the method reads properly on 2-D arrays of smaller sizes. Should serve basic
     * functions and work with no issues, code should be working properly for 2-D arrays of all sizes.
     */
    @Test  //Passed
    public void findTailExhaustive4(){

        boolean[][] A = {{true, true},
                    {true, false}};
        int x = 1;
        int y = 0;
        int[] B = {0, 1, 3};

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(B, SG.findTailExhaustive());
    }

    /*
     * findTailExhaustive:   EDGE CASE
     * Test case 5
     * findTailExhaustive() → B

     *      Test created to display what would occur if the 2-D array was of size 1x1. The x and y positions returned
     * should be those which I had placed as presets, which would be [-1,-1]. All else should work as intended.
     */
    @Test  //Passed
    public void findTailExhaustive5(){

        boolean[][] A = {{true}};
        int x = 0;
        int y = 0;
        int[] B = {-1, -1, 1};

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(B, SG.findTailExhaustive());
    }

    //Test cases - findTailRecursive~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


}