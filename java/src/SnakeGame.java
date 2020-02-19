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
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                game[i][j] = array[i][j];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){
        int length = 0;
        int checks = 0;
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[0].length; j++){
                if(game[i][j]){
                    length++;
                    if(neighbors(i, j) == 1){
                        if(headPosition[0] == i && headPosition[1] == j)
                        continue;
                    }
                }
                checks++;
            }
        }
    }

    public int neighbors(int row, int col){
        int count = 0;

        if(game[row - 1][col]) //checks top
            count++;
        if(game[row][col - 1]) //checks left
            count++;
        if(game[row][col + 1]) //checks right
            count++;
        if(game[row + 1][col]) //checks bottom
            count++;

        return count;
    }
}
