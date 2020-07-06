package EightQueens;

public class EightQueens {
    public static void main(String[] args) {
        int chessBoard[][] = new int[8][8];
        randomizeQueen(chessBoard);
        print(chessBoard);
    }

    public static void randomizeQueen(int[][] chessBoard) {
        for (int row = 0; row < chessBoard.length; row++) {
            int randomQueen = (int) (Math.random() * chessBoard.length);
            chessBoard[row][randomQueen] = 1;
        }
    }

    public static void print(int[][] chessBoard){
        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard.length; col++) {
                System.out.print(" " + chessBoard[col][row] + " ");
            }
            System.out.println();
        }
    }

    public static int rowCheck(int[][] chessBoard){
        //Checks if there are any queen attacking horizontally.
        int counter = 0;
        int found = 0;

        for(int row = 0; row<chessBoard.length; row++) {
            for(int col = 0; col<chessBoard.length; col++) {
                counter = 0;
                if (chessBoard[row][col] == 1) {
                    counter++;
                }
            }
            if (counter > 1) {
                found+= counter - 1;
            }
        }
        return found;
    }

    public static int colCheck(int[][] chessBoard){
        //Checks if there are any queen attacking vertically.
        int counter = 0;
        int found = 0;

        for(int row = 0; row<chessBoard.length; row++) {
            for(int col = 0; col<chessBoard.length; col++) {
                counter = 0;
                if (chessBoard[col][row] == 1) {
                    counter++;
                }
            }
            if (counter > 1) {
                found+= counter - 1;
            }
        }
        return found;
    }

    public static int diagonalCheck(int[][] chessBoard){
        int found = 0;

        for (int col = 0; col < chessBoard.length; col++){
            found += getHeuristicDown(0, col, chessBoard);
        }
        for (int row = 0; row < chessBoard.length; row++){
            found += getHeuristicDown(row, 0, chessBoard);
        }
        for (int col = 0; col < chessBoard.length; col++){
            found += getHeuristicUp(0, col, chessBoard);
        }
        for (int row = 0; row < chessBoard.length; row++){
            found += getHeuristicUp(row, 7, chessBoard);
        }
        return found;
    }

    public static int getHeuristicDown(int row, int col, int[][] chessBoard){
        int heuristic = 0;

        while (row < 8 && col < 8){
            if (chessBoard[row][col] == 1){
                heuristic ++;
            }
            row ++;
            col ++;
        }
        return heuristic-1;
    }

    public static int getHeuristicUp(int row, int col, int[][] chessBoard){
        int heuristic = 0;

        while (row < 8 && col < 8){
            if (chessBoard[row][col] == 1){
                heuristic ++;
            }
            row ++;
            col --;
        }
        return heuristic-1;
    }
}