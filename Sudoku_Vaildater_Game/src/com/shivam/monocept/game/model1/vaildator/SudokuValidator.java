package com.shivam.monocept.game.model1.vaildator;

import java.util.List;

import com.shivam.monocept.game.model1.board.Board;

public class SudokuValidator {

    private List<Validator> validators;

    public SudokuValidator() {
        validators = List.of(
            new RowValidator(),
            new ColumnValidator(),
            new BoxValidator()
        );
    }

    public boolean isValidMove(Board board, int row, int col, int number) {

        for (Validator validator : validators) {
            if (!validator.isValid(board, row, col, number)) {
                return false;
            }
        }

        return true;
    }
}
