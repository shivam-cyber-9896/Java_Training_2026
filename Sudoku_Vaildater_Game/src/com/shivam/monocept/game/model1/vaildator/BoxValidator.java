package com.shivam.monocept.game.model1.vaildator;

import com.shivam.monocept.game.model1.board.Board;

public class BoxValidator implements Validator {

    private static final int BOX_SIZE = 3;

    @Override
    public boolean isValid(Board board, int row, int col, int number) {

        int startRow = row - row % BOX_SIZE;
        int startCol = col - col % BOX_SIZE;

        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {

                if (board.getValue(startRow + i, startCol + j) == number) {
                    return false;
                }
            }
        }

        return true;
    }
}