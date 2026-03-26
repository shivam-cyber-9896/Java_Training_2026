package com.shivam.monocept.game.model1.vaildator;

import com.shivam.monocept.game.model1.board.Board;

public class SudokuValidator {

    RowAndColumnChecker Checker = new  RowAndColumnChecker();
    
    BoxChecker boxChecker = new BoxChecker();

    public boolean isValidMove(Board board,int row,int col,int num) {

        return Checker.checkRow(board,row,num) &&
               Checker.checkColumn(board,col,num) &&
               boxChecker.checkBox(board,row,col,num);
    }
}