package com.shivam.monocept.facede.model1.move;

import com.shivam.monocept.facede.model1.board.Board;
import com.shivam.monocept.facede.model1.checker.PlayerMove;

public  class AiMoveStrategy implements MoveStrategy {

    private final User ai;
    private final User player;

    public AiMoveStrategy(User ai, User player) {
        this.ai = ai;
        this.player = player;
    }

    @Override
    public int makeMove(Board board) {
        return new AiMove().makeMove(board, new PlayerMove(), ai, player);
    }
}