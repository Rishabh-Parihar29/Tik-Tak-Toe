// THIS CODE FOR TIK TAK TOE GAME
import java.util.*;
class rishabh {
    public static String username;
    public static String password;

    public static void printhelp(){
        System.out.println("this is for help ");
        System.out.println("(0,0),(0,1),(0,2)");
        System.out.println("(1,0),(1,1),(1,2)");
        System.out.println("(2,0),(2,1),(2,2)");
        System.out.println();
    }
    public static void printBoard(char[][] board){
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board [i][j]+"|");

            }
            System.out.println();
        }
    }
    public static boolean isValidmove (int row,int col,char [][] board){
        return (row>=0 && row<3 && col >= 0 && col<3 && board[row][col] == ' ');
    }
    public static boolean hasWon(char [][] board,char player){
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(board [i][0] == player && board [i][1] == player && board[i][2] == player ) {
                    return true;
                }
                if(board [0][0] == player && board [1][1] == player && board[2][2] == player ) {
                    return true;
                }
                if(board [0][2] == player && board [1][1] == player && board[2][0] == player ) {
                    return true;
                }
                if(board [0][j] == player && board [1][j] == player && board[2][j] == player ) {
                    return true;

                }}}
        return false;
    }

    public static void usernamerec( int i) {
        // RECURSION ON USERNAME RETRY
        if (username.length() >= 10) {
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("username must contain 10 digit ");
        System.out.print("USERNAME :");
        username = sc.next();
        usernamerec( i + 1);
    }

    public static void passwordrec( int i) {
        // RECURSION ON PASSWORD RETRY
        if (password.length() >= 8) {
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("password must contain 8 digit ");
        System.out.print("PASSWORD :");
        password = sc.next();
        passwordrec( i + 1);
    }

    public static void IDrec(String id, int i) {
        // RECURSION ON ID RETRY
        if (Objects.equals(id, username)) {
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("your ID is incorrect please retry again ");
        System.out.print("ID :");
        id = sc.next();
        IDrec(id, i + 1);
    }

    public static void passrec(String idpassword, int i) {
        // RECURSION ON IDPASSWORD RETRY
        if (Objects.equals(idpassword, password)) {
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("your password is incorrect please retry again ");
        System.out.print("PASSWORD :");
        idpassword = sc.next();
        passrec(idpassword, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE KIOSKE ");
        System.out.print("IF YOU WANT TO CONTINUE PRESS '1' :");
        // TAKE INPUT FROM USER
        int input = sc.nextInt();
        if (input == 1) {
            System.out.println("TO CREATE ACCOUNT PLEASE ENTER YOUR USERNAME & PASSWORD");
            // USERNAME INPUT
            System.out.print("USERNAME :");
            username = sc.next();
            if (username.length() < 10) {
                usernamerec(0);
            }
            // PASSWORD INPUT
            System.out.print("PASSWORD :");
            password = sc.next();
            if (password.length() < 8) {
                passwordrec(0);
            }

            System.out.println("YOUR ACCOUNT WAS CREATED");
            System.out.println();
            // ID INPUT
            System.out.print("enter your ID :");
            String id = sc.next();
            // IF ID IS WRONG
            if (!Objects.equals(id, username)) {
                IDrec(id, 0);
            }
            // IDPASSWORD INPUT
            System.out.print("enter your PASSWORD :");
            String idpassword = sc.next();
            // IF IDPASSWORD IS WRONG
            if (!Objects.equals(idpassword, password)) {
                passrec(idpassword, 0);
            }
            // LAST MESSAGE FROM DOVELOPER
            System.out.println("YOUR ALL ID & PASSWORD IS RIGHT SO  KIOSKE PERMIT YOU TO PLAY " +
                    "TIK TAK TOE LETS START ----->");

            char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            char currentplayer = 'X';
            int i = 0;
            while (i < 9) {
                printBoard(board);
                System.out.println();
                printhelp();
                System.out.println("player " + currentplayer + " enter your move(row)(coulumn): ");
                int row = sc.nextInt();
                int col = sc.nextInt();
                System.out.println();

                if (isValidmove(row, col, board)) {
                    board[row][col] = currentplayer;
                    if (hasWon(board, currentplayer)) {
                        printBoard(board);
                        System.out.println("player " + currentplayer + " Wins!");
                        System.out.println("NOW REVIND THE TIME AND REMIND CAREFULLY --> THIS IS THE GAME OF RISHABH");
                        i = 9;
                    } else {
                        currentplayer = (currentplayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("invalid move try again");
                }
                i++;
                if (i == 9) {
                    printBoard(board);
                    System.out.println();
                    System.out.println("ITS A TIE NOBODY WINS THIS GAME ");
                }
            }
        }
        else{
            System.out.println("THANKS FOR VISITING :)");
        }
    }
}
