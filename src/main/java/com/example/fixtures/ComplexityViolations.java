package com.example.fixtures;

/** 提供圈复杂度最大值和平均值超标反例。 */
public class ComplexityViolations {
    /** 21 个 if 各含 4 个短路条件，圈复杂度为 106。 */
    public int classify(int value) {
        int score = 0;
        if (value % 2 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 3 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 4 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 5 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 6 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 7 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 8 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 9 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 10 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 11 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 12 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 13 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 14 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 15 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 16 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 17 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 18 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 19 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 20 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 21 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        if (value % 22 == 0 && value > 0 && value < 10000 && value != 100 && value != 200) {
            score++;
        }
        return score;
    }

    /** 5 个独立 if，圈复杂度为 6。 */
    public int adjust(int value) {
        int score = value;
        if (value > 0) {
            score++;
        }
        if (value > 10) {
            score++;
        }
        if (value > 20) {
            score++;
        }
        if (value > 30) {
            score++;
        }
        if (value > 40) {
            score++;
        }
        return score;
    }
}
