package com.shivam.monocept.game.model1.generator;

import java.util.Random;

import com.shivam.monocept.game.model1.board.Board;
import com.shivam.monocept.game.model1.vaildator.SudokuValidator;

public class ComputerSudokuGenerator implements SudokuGenerator {

    private static final int SIZE = 9;

    private int filledCells;
    private SudokuValidator validator;

    public ComputerSudokuGenerator(int filledCells, SudokuValidator validator) {
        this.filledCells = filledCells;
        this.validator = validator;
    }

    @Override
    public void generate(Board board) {

        Random random = new Random();

        int count = 0;
        int attempts = 0;
        int maxAttempts = 1000;

        while (count < filledCells && attempts < maxAttempts) {

            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            int num = random.nextInt(SIZE) + 1;

            if (board.isEmpty(row, col) &&
                validator.isValidMove(board, row, col, num)) {

                board.setFixedValue(row, col, num);
                count++;
            }

            attempts++;
        }
    }
}