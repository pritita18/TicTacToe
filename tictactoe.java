package tictactoe;

import java.util.Scanner;

public class tictactoe {

    public static void main(String[] args) {

        char[][] Board = new char[3][3];

        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[row].length; col++) {
                Board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameover = false;
        Scanner sc = new Scanner(System.in);

        while (!gameover) {
            BoardDisplay(Board);
            System.out.println("Player " + player + " Turn :");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.print("");
            if (Board[row][col] == ' ') {
                Board[row][col] = player;
                gameover = haveWon(Board, player);
                if (gameover) {
                    System.out.println(player + " won the game");
                }
                if (player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }

            } else {
                System.out.println("Invalid move plz come again");
            }

        }
        BoardDisplay(Board);
    }

    public static boolean haveWon(char[][] Board, char player) {
        for (int row = 0; row < Board.length; row++) {
            if (Board[row][0] == player && Board[row][0] == player && Board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < Board.length; col++) {
            if (Board[0][col] == player && Board[1][col] == player && Board[2][col] == player) {
                return true;
            }
        }

        if (Board[0][0] == player && Board[1][1] == player && Board[2][2] == player) {
            return true;
        }

        if (Board[0][2] == player && Board[1][1] == player && Board[2][0] == player) {
            return true;
        }

        return false;

    }

    public static void BoardDisplay(char[][] Board) {
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[row].length; col++) {
                System.out.print(Board[row][col] + "|");
            }
            System.out.println();
        }
    }
}