package com.example.fixtures;

import java.util.Locale;

/** 提供字符串格式化和字符集反例。 */
public class StringAndEncodingViolations {
    /** 混用被规则禁止的拼接方式。 */
    public String message(String name, int count) {
        String text = "Hello " + name;
        text += "!";
        String path = name.concat("/summary");
        String joined = String.join("/", name, "summary");
        String built = new StringBuilder().append(name).append(count).toString();
        return text + path + joined + built;
    }

    /** 故意使用隐式、默认和空 Locale，以及 formatted。 */
    public String amount(double value) {
        String implicit = String.format("%.2f", value);
        String defaultLocale = String.format(Locale.getDefault(), "%.2f", value);
        String nullLocale = String.format((Locale) null, "%.2f", value);
        String formatted = "%.2f".formatted(value);
        return implicit + defaultLocale + nullLocale + formatted;
    }

    /** 编码时省略字符集。 */
    public byte[] encode(String value) {
        return value.getBytes();
    }

    /** 解码时省略字符集。 */
    public String decode(byte[] value) {
        return new String(value);
    }
}
