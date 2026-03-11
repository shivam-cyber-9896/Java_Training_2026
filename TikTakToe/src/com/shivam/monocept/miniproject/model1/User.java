package com.shivam.monocept.miniproject.model1;

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
        if (this == PLAYER_X)
            return PLAYER_O;

        return PLAYER_X;
    }
}