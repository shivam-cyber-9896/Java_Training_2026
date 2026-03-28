package com.shivam.monocept.game.model1.generator;



import java.util.Random;
import java.util.Scanner;

import com.shivam.monocept.game.model1.board.Board;
import com.shivam.monocept.game.model1.vaildator.SudokuValidator;

public class ComputerSudokuGenerator {

	public void generateBoard(Board board) {
	int choice=	chooseDifficulty();

	    Random random = new Random();
	    int[][] grid = board.getGrid();
	    SudokuValidator validator = new SudokuValidator();

	    int count = 0;

	    while (count < choice) {

	        int row = random.nextInt(9);
	        int col = random.nextInt(9);
	        int num = random.nextInt(9) + 1;

	        if (grid[row][col] == 0 && validator.isValidMove(board, row, col, num)) {

	            grid[row][col] = num;
	            count++;
	        }
	    }
	}

	private int chooseDifficulty() {

	    Scanner scanner = new Scanner(System.in);

	    System.out.println("What difficulty do you want?");
	    System.out.println("1. Easy");
	    System.out.println("2. Medium");
	    System.out.println("3. Hard");

	    String type = scanner.nextLine();

	    while(type.trim().isEmpty() || !type.matches("^[1-3]$")) {
	        System.out.println("Enter Valid Difficulty");
	        System.out.println("1. Easy");
	        System.out.println("2. Medium");
	        System.out.println("3. Hard");

	        type = scanner.nextLine();
	    }
	    type="40";
         if(type.equals("1"))
         {
        	 type="80";
         }
         if(type.equals("2"))
         {
        	 type="60";
         }
         
	    return Integer.parseInt(type);
	}
    }
