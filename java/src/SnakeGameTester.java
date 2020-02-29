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

    /*
     * findTailRecursive:
     * Test case 1
     * findTailRecursive() → B

     *    Test case ensures proper function of the method, making sure the basic functions work well and all requirements
     * are met by the test. The test will make sure the tail is found with no problems and the coordinates are placed
     * correctly.
     */
    @Test //Passed
    public void findTailRecursive1(){

        boolean[][] A = {{false, false, false, true},
                {false, false, false, true},
                {false, false, true, true},
                {false, false, true, false}};
        int x = 0;
        int y = 3;
        int[] B = {3, 2, 5};

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(B, SG.findTailRecursive());
    }

    /*
     * findTailRecursive:
     * Test case 2
     * findTailRecursive() → B

     *    Test case accounts for proper tracking of recursiveChecks, making sure the number is well kept and there is no
     * overflow or shortage of cells counted.
     */
    @Test //Passed
    public void findTailRecursive2(){

        boolean[][] A = {{false, false, true, true},
                {false, false, false, true},
                {false, false, true, true},
                {true, true, true, false}};
        int x = 0;
        int y = 2;
        int[] B = {3, 0, 8};
        int count = 8;

        SnakeGame SG = new SnakeGame(A, x, y);
        SG.findTailRecursive();
        assertEquals(count, SG.getRecursiveChecks());
    }

    /*
     * findTailRecursive:
     * Test case 3
     * findTailRecursive() → B

     *    Test case accounts for the correct length count while running through the method. Ensures the snake is being
     * managed properly and no excess or under counting is being done.
     */
    @Test //Passed
    public void findTailRecursive3(){

        boolean[][] A = {{false, false, true, false},
                {true, false, true, false},
                {true, true, true, false},
                {false, false, false, false}};
        int x = 1;
        int y = 0;
        int[] B = {0, 2, 6};

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(B, SG.findTailRecursive());
    }

    /*
     * findTailRecursive:
     * Test case 4
     * findTailRecursive() → B

     *    Test case passes instance in which the snake is of a larger length that borders around the board, testing all
     * directions in which the neighbors could possibly appear.
     */
    @Test //Passed
    public void findTailRecursive4(){

        boolean[][] A = {{true, false, true, true},
                {true, false, false, true},
                {true, false, false, true},
                {true, true, true, true}};
        int x = 0;
        int y = 0;
        int[] B = {0, 2, 11};

        SnakeGame SG = new SnakeGame(A, x, y);
        assertArrayEquals(B, SG.findTailRecursive());
    }

    /*
     * findTailRecursive:
     * Test case 5
     * findTailRecursive() → B

     *    Test case checks for the recursiveChecks to solidify the function of the recursiveCheck counter with no issues.
     */
    @Test //Passed
    public void findTailRecursive5(){

        boolean[][] A = {{true, false, true, true},
                {true, false, false, true},
                {true, false, false, true},
                {true, true, true, true}};
        int x = 0;
        int y = 0;
        int[] B = {0, 2, 11};
        int count = 11;

        SnakeGame SG = new SnakeGame(A, x, y);
        SG.findTailRecursive();
        assertEquals(count, SG.getRecursiveChecks());
    }

}