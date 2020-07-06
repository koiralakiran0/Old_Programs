package EightQueens;

public class EightQueens {
    public static void main(String[] args) {
        int chessBoard[][] = new int[8][8];
        print(chessBoard);
        System.out.println("****************************************************");
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
}