package com.abryant;

import java.util.Random;

public enum Dice {
    D100(100),
    D20(20),
    D12(12),
    D10(10),
    D8(8),
    D6(6),
    D4(4);

    private final int value;

    Dice(final int value) {
        this.value = value;
    }

    static int dieRoll() {
        return dieRoll(1, D20);
    }

    static int dieRoll(int numberOfDice, Dice sizeOfDice) {
        int result = 0;
        for (int i = 1; i <= numberOfDice; i++) {
            Random random = new Random();
            result += random.nextInt(sizeOfDice.value) + 1;
        }

        return result;
    }
}
