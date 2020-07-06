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
}