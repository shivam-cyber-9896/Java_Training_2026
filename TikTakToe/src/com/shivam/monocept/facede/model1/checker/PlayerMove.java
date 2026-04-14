package com.shivam.monocept.facede.model1.checker;

import com.shivam.monocept.facede.model1.board.Board;
import com.shivam.monocept.facede.model1.exception.InvalidMoveException;
import com.shivam.monocept.facede.model1.move.User;

public class PlayerMove {

    public boolean playerMove(Board board, int position, User user) {

        if (position < 1 || position > 9)
                    throw new InvalidMoveException("Position must be between 1 and 9");
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (board.getCells()[row][col] != 0)
            return false;

        board.getCells()[row][col] = user.getValue();
        return true;
    }
}