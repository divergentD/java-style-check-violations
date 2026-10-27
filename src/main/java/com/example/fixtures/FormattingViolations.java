package com.example.fixtures;

import java.util.Locale;

/** 保留超长声明反例，其余换行已按审查意见修正。 */
public class FormattingViolations {
    /** 方法形参可以按语法边界换行，故意超出行宽。 */
    public String chooseReference(String primaryCustomerReference, String secondaryCustomerReference, String fallbackCustomerReference, boolean preferPrimaryCustomerReference) {
        return primaryCustomerReference;
    }

    /** 完整调用需要断行，续行在必要边界对齐。 */
    public String summary(String firstReference, String secondReference, String thirdReference,
        String fourthReference, String fifthReference, String sixthReference) {
        return String.format(Locale.ROOT, "%s:%s:%s:%s:%s:%s", firstReference, secondReference,
            thirdReference, fourthReference, fifthReference, sixthReference);
    }

    /** 在一行内完成规范化调用。 */
    public String normalize(String value) {
        return value.trim().toLowerCase(Locale.ROOT);
    }

    /** 完整语句在 120 字符内，保持一行。 */
    public String overWrapped(String value) {
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        return normalized;
    }
}
