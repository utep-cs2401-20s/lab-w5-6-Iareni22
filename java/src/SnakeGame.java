public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //constructors------------------------------------------------------------------------------------------------------
    public SnakeGame(){
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] array, int x, int y){
        game = new boolean[array.length][array[0].length];
        headPosition = new int[2];

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                game[i][j] = array[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }
    //methods-----------------------------------------------------------------------------------------------------------
    public int[] findTailExhaustive(){
        int length = 0;
        int x = -1;
        int y = -1;
        boolean tailFound = false;
        resetCounters();

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){

                if(!tailFound)
                    exhaustiveChecks++;
                else if(tailFound){}

                if(game[i][j]){
                    length++;
                    if(neighbors(i, j) == 1){
                        if(headPosition[0] == i && headPosition[1] == j)
                            continue;
                        else{
                            x = i;
                            y = j;
                            tailFound = true;
                        }
                    }
                    else if(neighbors(i, j) > 1){
                        continue;
                    }
                }
            }
        }
        return new int[]{x, y, length};
    }

    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        if(neighbors(currentPosition[0], currentPosition[1]) == 1){
            if(previousPosition == headPosition){
            }
        }
    }

    private int neighbors(int row, int col){
        int count = 0;

        if(row - 1 >= 0 && game[row - 1][col]) //checks top
            count++;
        if(col - 1 >= 0 && game[row][col - 1]) //checks left
            count++;
        if(col + 1 < game[0].length && game[row][col + 1]) //checks right
            count++;
        if(row + 1 < game.length && game[row + 1][col]) //checks bottom
            count++;

        return count;
    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }

    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }
}
