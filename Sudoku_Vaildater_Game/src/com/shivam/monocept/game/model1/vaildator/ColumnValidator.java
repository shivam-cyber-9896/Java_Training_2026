package com.shivam.monocept.game.model1.vaildator;

import com.shivam.monocept.game.model1.board.Board;

public class ColumnValidator implements Validator {

    private static final int SIZE = 9;

    @Override
    public boolean isValid(Board board, int row, int col, int number) {

        for (int i = 0; i < SIZE; i++) {

            if (board.getValue(i, col) == number) {
                return false;
            }
        }

        return true;
    }
}