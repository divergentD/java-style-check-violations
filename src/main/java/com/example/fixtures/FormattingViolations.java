package com.example.fixtures;

import java.util.Locale;

/** 提供超长行、续行缩进和过度换行反例。 */
public class FormattingViolations {
    /** 方法形参可以按语法边界换行，故意超出行宽。 */
    public String chooseReference(String primaryCustomerReference, String secondaryCustomerReference, String fallbackCustomerReference, boolean preferPrimaryCustomerReference) {
        return primaryCustomerReference;
    }

    /** 完整调用需要断行，但续行故意逐层加深缩进。 */
    public String summary(String firstReference, String secondReference, String thirdReference,
        String fourthReference, String fifthReference, String sixthReference) {
        return String.format(Locale.ROOT, "%s:%s:%s:%s:%s:%s", firstReference, secondReference,
                    thirdReference,
                            fourthReference, fifthReference, sixthReference);
    }

    /** 点号故意放在上一行末尾，且调用本可写成一行。 */
    public String normalize(String value) {
        return value.trim().
            toLowerCase(Locale.ROOT);
    }

    /** 完整语句在 120 字符内，故意把每层调用拆开。 */
    public String overWrapped(String value) {
        String normalized =
            value
                .trim()
                    .toLowerCase(
                        Locale.ROOT);
        return normalized;
    }
}
