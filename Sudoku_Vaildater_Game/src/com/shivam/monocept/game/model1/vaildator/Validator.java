package com.shivam.monocept.game.model1.vaildator;


import com.shivam.monocept.game.model1.board.Board;

public interface Validator {

    boolean isValid(Board board, int row, int col, int number);
}