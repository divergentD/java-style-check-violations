package com.example.fixtures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 测试代码也故意缺少类型和方法 Javadoc。
public class StyleViolationsTest {
    @Test
    public void formatsMessage() {
        String message = "hello" + " " + "fixture";
        assertEquals("hello fixture", message);
        System.out.println(message);
    }
}
