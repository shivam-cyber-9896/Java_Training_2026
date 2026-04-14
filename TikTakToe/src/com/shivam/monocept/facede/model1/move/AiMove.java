package com.shivam.monocept.facede.model1.move;

import com.shivam.monocept.facede.model1.board.Board;
import com.shivam.monocept.facede.model1.checker.CheckWinner;
import com.shivam.monocept.facede.model1.checker.PlayerMove;

public class AiMove {

    public int makeMove(Board board, PlayerMove mover, User computer, User player) {

        int[][] cells = board.getCells();

        int winMove = findWinningMove(board, computer);
        if (winMove != -1) return winMove;

        int blockMove = findWinningMove(board, player);
        if (blockMove != -1) return blockMove;

        if (cells[1][1] == 0) return 5;

        int[] corners = {1,3,7,9};
        for (int pos : corners) {
            int r = (pos-1)/3, c = (pos-1)%3;
            if (cells[r][c] == 0) return pos;
        }

        for (int pos = 1; pos <= 9; pos++) {
            int r = (pos-1)/3, c = (pos-1)%3;
            if (cells[r][c] == 0) return pos;
        }

        return -1;
    }

    private int findWinningMove(Board board, User user) {

        int[][] cells = board.getCells();

        for (int pos = 1; pos <= 9; pos++) {

            int r = (pos-1)/3, c = (pos-1)%3;

            if (cells[r][c] == 0) {

                cells[r][c] = user.getValue();

                if (new CheckWinner().checkWinner(board, user)) {
                    cells[r][c] = 0;
                    return pos;
                }

                cells[r][c] = 0;
            }
        }
        return -1;
    }
}