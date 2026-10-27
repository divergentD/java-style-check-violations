package com.example.fixtures;

/** 提供修正圈复杂度后的等价计分示例。 */
public class ComplexityViolations {
    /** 汇总同一边界条件下的整除得分。 */
    public int classify(int value) {
        if (value <= 0 || value >= 10000 || value == 100 || value == 200) {
            return 0;
        }
        int score = 0;
        for (int divisor = 2; divisor <= 22; divisor++) {
            if (value % divisor == 0) {
                score++;
            }
        }
        return score;
    }

    /** 5 个独立 if，圈复杂度为 6，未超过单函数上限。 */
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
