import org.junit.experimental.results.PrintableResult;
import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Started Boii   😎😎😎😎😎😎");
    
    char[][] board = new char[3][3];

    for(int row=0; row<board.length; row++){
      for(int col=0; col<board[row].length; col++){
        board[row][col] = ' ';
      }
    }

    char player = 'X';

    boolean gameOver = false;

    Scanner sc = new Scanner(System.in);
    
    while(!gameOver) {
      printBoard(board);
      System.out.println("Player "+ player+" Turn:-  ");
      System.out.print("Enter Row: ");
      int row = sc.nextInt()-1;
      System.out.print("Enter Col: ");
      int col = sc.nextInt()-1;
      if(row>2 || row<0 || col>2 || col<0){
        System.out.println("Give input in range of 1 to 3");
      }

      else if(board[row][col] == ' '){
        //place elements
        board[row][col] = player;
        gameOver = hasWon(board, player);
        if(gameOver){
          System.out.println("Player "+player+" has WON🎯😘😘!!!!!");
        }
         
        else if(gameOverCheck(board)){
          System.out.print("Match Tie, Play Again.......😐😐");
          gameOver = true;
        }
        else{
          player = (player == 'X') ? 'O' : 'X';
        }
        
      }else{
        System.out.println("Already added, give new co-ordinates");
      }
    }
    // printBoard(board);
    
  }

  public static boolean gameOverCheck(char[][] board){
    for(int row=0; row<board.length; row++){
      for(int col=0; col<board[row].length; col++){
        if(board[row][col] == ' ') return false;
      }
    }
    return true;
  }

  public static boolean hasWon(char[][] board, char player){
    //checking rows
    for(int row=0; row<board.length; row++){
      if(board[row][0]==board[row][1] && board[row][1] == board[row][2] && board[row][2] == player) return true;
    }

    // for col
    for(int col=0; col<board.length; col++){
      if(board[0][col]==player && board[1][col]==player && board[2][col]==player) return true;
    }
    
    //for diagonal
    if(board[0][0]==player && board[1][1]==player && board[2][2]==player) return true;
    if(board[0][2]==player && board[1][1]==player && board[2][0]==player) return true;

    

    return false;
    
  }

  

  public static void printBoard(char[][] board){
    System.out.println("Board------------");
    System.out.print("\t\t\t\t\t\t+");
    for(int col=0; col<board[0].length; col++){
        System.out.print("---+");        
    }
    System.out.println("");
    for(int row=0; row<board.length; row++){
      System.out.print("\t\t\t\t\t\t| ");
      for(int col=0; col<board[row].length; col++){
        System.out.print(board[row][col]+" | ");
      }
      System.out.println(" ");
      System.out.print("\t\t\t\t\t\t+");

      for(int col=0; col<board[row].length; col++){
        System.out.print("---+");
        
      }
      
      System.out.println("");
    }
    return;
  }
}