package com.shivam.monocept.game.model1.generator;

public enum Difficulty {
    EASY(40),
    MEDIUM(30),
    HARD(20);

    private final int filledCells;

    Difficulty(int filledCells) {
        this.filledCells = filledCells;
    }

    public int getFilledCells() {
        return filledCells;
    }
}