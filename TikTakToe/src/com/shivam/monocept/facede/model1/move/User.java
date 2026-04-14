package com.shivam.monocept.facede.model1.move;


public enum User {

    PLAYER_X(1),
    PLAYER_O(2);

    private final int value;

    User(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public User next() {
        return this == PLAYER_X ? PLAYER_O : PLAYER_X;
    }
}
