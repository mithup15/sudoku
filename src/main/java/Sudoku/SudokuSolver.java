package Sudoku;
import java.util.*;

public class SudokuSolver {
	  
	  private static final int GRID_SIZE = 9;
	  
	  public static void main(String[] args) {
		  int a,b,c,d,e,f,g,h,i;
		  Random random = new Random();
		  a = random.nextInt(10);
		  b = random.nextInt(10);
		  c = random.nextInt(10);
		  d = random.nextInt(10);
		  e = random.nextInt(10);
		  f = random.nextInt(10);
		  g = random.nextInt(10);
		  h = random.nextInt(10);
		  i = random.nextInt(10);
		  
	    int[][] board = {
	        {a, 0, 0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, b, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0, 0, c},
	        {0, d, 0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, f, 0, 0},
	        {0, 0, 0, 0, 0, e, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0, i, 0},
	        {0, 0, g, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, h, 0, 0, 0, 0, 0} 
	      };
	    
	    printBoard(board);
	    
	    if (solveBoard(board)) {
	      System.out.println("\nSolved successfully!\n");
	    }
	    else {
	      System.out.println("Unsolvable board :(");
	    }
	    
	    printBoard(board);
	    
	  }
	  
	  
	  private static void printBoard(int[][] board) {
	    for (int row = 0; row < GRID_SIZE; row++) {
	      if (row % 3 == 0 && row != 0) {
	        System.out.println("-----------");
	      
	      }
	      for (int column = 0; column < GRID_SIZE; column++) {
	        if (column % 3 == 0 && column != 0) {
	          System.out.print("|");
	        }
	        System.out.print(board[row][column]);
	      }
	      System.out.println();
	    }
	  }


	  private static boolean isNumberInRow(int[][] board, int number, int row) {
	    for (int i = 0; i < GRID_SIZE; i++) {
	      if (board[row][i] == number) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  private static boolean isNumberInColumn(int[][] board, int number, int column) {
	    for (int i = 0; i < GRID_SIZE; i++) {
	      if (board[i][column] == number) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
	    int localBoxRow = row - row % 3;
	    int localBoxColumn = column - column % 3;
	    
	    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
	      for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
	        if (board[i][j] == number) {
	          return true;
	        }
	      }
	    }
	    return false;
	  }
	  
	  private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
	    return !isNumberInRow(board, number, row) &&
	        !isNumberInColumn(board, number, column) &&
	        !isNumberInBox(board, number, row, column);
	  }
	  
	  private static boolean solveBoard(int[][] board) {
	    for (int row = 0; row < GRID_SIZE; row++) {
	      for (int column = 0; column < GRID_SIZE; column++) {
	        if (board[row][column] == 0) {
	          for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
	            if (isValidPlacement(board, numberToTry, row, column)) {
	              board[row][column] = numberToTry;
	              
	              if (solveBoard(board)) {
	                return true;
	              }
	              else {
	                board[row][column] = 0;
	              }
	            }
	          }
	          return false;
	        }
	      }
	    }
	    return true;
	  }
	  
	  
	  
	}


