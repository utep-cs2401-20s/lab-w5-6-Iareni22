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

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){ //recursiveChecks is being tracked inside of the lengthRec() method along with length
        if(neighbors(currentPosition[0], currentPosition[1]) == 1 && !isSameCell(currentPosition, previousPosition)){
            return new int[]{currentPosition[0], currentPosition[1], lengthRec(game)};
        }
        int[] futureCell = neighborsRec(currentPosition[0], currentPosition[1], previousPosition[0], previousPosition[1]);
        previousPosition[0] = currentPosition[0];
        previousPosition[1] = currentPosition[1];
        return findTailRecursive(futureCell, previousPosition);
    }

    private int lengthRec(boolean[][] board){ //keeps track of recursiveChecks as well as length
        int length = 0;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]){
                    length++;
                    recursiveChecks++;
                }
            }
        }
        return length;
    }

    private boolean isSameCell(int[] currentPosition, int[] previousPosition){
        return currentPosition[0] == previousPosition[0] && currentPosition[1] == previousPosition[1];
    }

    private int[] neighborsRec(int row, int col, int prevRow, int prevCol){
        int[] A = new int[2];
        if(row - 1 >= 0 && game[row - 1][col]) { //checks top
            if(!(row - 1 == prevRow && col == prevCol)) {
                A[0] = row - 1;
                A[1] = col;
            }
        }
        if(col - 1 >= 0 && game[row][col - 1]) { //checks left
            if(!(col - 1 == prevCol && row == prevRow)) {
                A[0] = row;
                A[1] = col - 1;
            }
        }
        if(col + 1 < game[0].length && game[row][col + 1]) { //checks right
            if(!(col + 1 == prevCol && row == prevRow)) {
                A[0] = row;
                A[1] = col + 1;
            }
        }
        if(row + 1 < game.length && game[row + 1][col]) { //checks bottom
            if(!(row + 1 == prevRow && col == prevCol)) {
                A[0] = row + 1;
                A[1] = col;
            }
        }
        return A;

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
