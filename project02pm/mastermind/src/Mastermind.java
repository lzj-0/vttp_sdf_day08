package project02pm.mastermind.src;

public class Mastermind {
    private Integer tries;
    private Integer[][] board;
    private Integer[] cp;
    private Integer[] c;

    public Mastermind(Integer tries) {
        this.tries = tries;
        this.board = new Integer[tries][4];
        this.cp = new Integer[tries];
        this.c = new Integer[tries];
        System.out.println("===================");
        System.out.println("= Mastermind Game =");
        System.out.println("===================\n");
        System.out.println("Board");
        System.out.println("-----------------------------------------");
        this.printBoard();
    }

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

    public Integer[] getCp() {
        return cp;
    }

    public void setCp(Integer[] cp) {
        this.cp = cp;
    }

    public Integer[] getC() {
        return c;
    }

    public void setC(Integer[] c) {
        this.c = c;
    }

    public void printBoard() {
        System.out.printf("%-4s |\t    %s\t|   %s  |   %s\t|\n", "Try", "Board", "CP", "C");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("%-4d |\t ".formatted(i+1));
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == null) {
                    sb.append(" . ");
                } else {
                    sb.append(" %d ".formatted(board[i][j]));
                }

            }
            sb.append("\t|  ");
            if (this.cp[i] == null) {
                sb.append(" . ");
            } else {
                sb.append(" %d ".formatted(this.cp[i]));
            }
            sb.append("  |  ");
            if (this.c[i] == null) {
                sb.append(" . ");
            } else {
                sb.append(" %d ".formatted(this.c[i]));
            }
            sb.append("  |");
            System.out.println(sb.toString());
        }
        System.out.println("-----------------------------------------");
    }
    
}
