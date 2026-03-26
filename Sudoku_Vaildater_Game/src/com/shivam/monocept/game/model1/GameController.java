package com.shivam.monocept.game.model1;

import java.util.Scanner;

import com.shivam.monocept.game.model1.board.Board;
import com.shivam.monocept.game.model1.board.BoardFullChecker;
import com.shivam.monocept.game.model1.board.BoardPrinter;
import com.shivam.monocept.game.model1.exception.InvaildSudokuExcption;
import com.shivam.monocept.game.model1.input.InputChecker;
import com.shivam.monocept.game.model1.input.InputHandler;
import com.shivam.monocept.game.model1.typeChoser.ComputerSudokuGenerator;
import com.shivam.monocept.game.model1.typeChoser.EmptySudokuGenerator;
import com.shivam.monocept.game.model1.vaildator.SudokuValidator;

public class GameController {

    Board board = new Board();
    BoardPrinter printer = new BoardPrinter();
    InputHandler input = new InputHandler();
    InputChecker inputChecker = new InputChecker();
    SudokuValidator validator = new SudokuValidator();
    BoardFullChecker fullChecker = new BoardFullChecker();
    
    private int chooseGameType() {

        Scanner scanner = new Scanner(System.in);
			System.out.println("Choose Game Type");
			System.out.println("1. Empty Sudoku");
			System.out.println("2. Computer Generated Sudoku");
			System.out.println("3. Rules Showing ");
      String type= scanner.nextLine();
			while(type==null||type.trim().isEmpty()||!type.matches("^[123]$")) 
			{
				System.out.println("Choose Vaild Game Type");
			    System.out.println("1. Empty Sudoku");
			    System.out.println("2. Computer Generated Sudoku");
			    System.out.println("3. Rules Showing ");
			   type= scanner.nextLine();
			}	
			int choice = Integer.parseInt(type);
			return choice ;
		} 
       
		
    public void startGame() {

            
    	int choice = chooseGameType();

        
    	EmptySudokuGenerator empty = new EmptySudokuGenerator();
        empty.generateEmptyBoard(board);
            
            if (choice == 2) {
            	ComputerSudokuGenerator generator = new ComputerSudokuGenerator();
                generator.generateBoard(board);
            } 
             if(choice==3)
             {
            	 Rules.showrules();
            	 startGame();
             }
        playGame();
    }

    private void playGame() {

        while (!fullChecker.isBoardFull(board)) {

            printer.printBoard(board);

            int row = input.getRow() - 1;
            int col = input.getColumn() - 1;
            int num = input.getNumber();

            try {
				if (!inputChecker.isValidNumber(num)) {
				    System.out.println("Invalid Number! Enter 1-9");
				    continue;
				}
			} catch (InvaildSudokuExcption e) {
				e.printStackTrace();
			}

            if (validator.isValidMove(board, row, col, num)) {

                board.setValue(row, col, num);

            } else {

                System.out.println("Invalid Move!");

            }
        }

        System.out.println("Sudoku Completed!");
        printer.printBoard(board);
    }
}
