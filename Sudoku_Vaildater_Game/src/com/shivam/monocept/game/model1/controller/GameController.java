package com.shivam.monocept.game.model1.controller;

import java.util.Scanner;

import com.shivam.monocept.game.model1.board.Board;
import com.shivam.monocept.game.model1.board.BoardPrinter;
import com.shivam.monocept.game.model1.generator.*;
import com.shivam.monocept.game.model1.input.InputChecker;
import com.shivam.monocept.game.model1.input.InputHandler;
import com.shivam.monocept.game.model1.vaildator.SudokuValidator;

public class GameController {

    private Board board = new Board();
    private BoardPrinter printer = new BoardPrinter();
    private InputHandler input = new InputHandler();
    private InputChecker inputChecker = new InputChecker();
    private SudokuValidator validator = new SudokuValidator();

    private Scanner scanner = new Scanner(System.in);

    public void startGame() {

        while (true) {

            int choice = chooseGameType();

            if (choice == 3) {
                Rules.showRules();
                continue;
            }

            SudokuGenerator generator;

            if (choice == 1) {
                generator = new EmptySudokuGenerator();
            } else {
                int difficulty = chooseDifficulty();
                generator = new ComputerSudokuGenerator(difficulty, validator);
            }

            generator.generate(board);
            playGame();
            break;
        }
    }

    private int chooseGameType() {

        System.out.println("Choose Game Type");
        System.out.println("1. Empty Sudoku");
        System.out.println("2. Computer Generated Sudoku");
        System.out.println("3. Rules Showing ");

        String type = scanner.nextLine();

        while (type == null || type.trim().isEmpty() || !type.matches("^[123]$")) {
            System.out.println("Choose Valid Game Type");
            type = scanner.nextLine();
        }

        return Integer.parseInt(type);
    }

    private int chooseDifficulty() {

        System.out.println("1. Easy (40 cells)");
        System.out.println("2. Medium (30 cells)");
        System.out.println("3. Hard (20 cells)");

        String type = scanner.nextLine();

        while (!type.matches("^[123]$")) {
            System.out.println("Enter valid difficulty");
            type = scanner.nextLine();
        }

        switch (type) {
            case "1": return 40;
            case "2": return 30;
            case "3": return 20;
            default: return 30;
        }
    }

    private void playGame() {

        while (!board.isFull()) {

            printer.printBoard(board);

            int row = input.getRow() - 1;
            int col = input.getColumn() - 1;
            int num = input.getNumber();

            try {
                inputChecker.isValidNumber(num);
            } catch (Exception e) {
                System.out.println("Invalid Number!");
                continue;
            }

            if (board.isFixed(row, col)) {
                System.out.println("Cannot modify fixed cell!");
                continue;
            }

            if (!board.isEmpty(row, col)) {
                System.out.println("Cell already filled!");
                continue;
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