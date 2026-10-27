# 当前预期风格问题

对应 [java-style-check 固定规则版本](https://github.com/divergentD/java-style-check/tree/989b18625732825130f7903c4e6fd247aa4d8760)。

本轮按用户要求修复 Qodo 的 11 条反馈。原始清单中 12 项随代码修复失效，包括移除 Environment 构造依赖后一并消失的 spring-injection 反例；这些记录保存在 JSON 的 resolved_findings 中。当前有 23 项最小预期发现，覆盖 6 个规则 ID，包含新增标注的测试目录静态通配符反例。

这份清单不是全部违规的穷举；未列出的 Javadoc 缺失等仍可报告。

| 编号 | 规则 | 位置 | 当前预期发现 |
| --- | --- | --- | --- |
| F001 | `javadoc` | [JavadocViolations.java:4](../src/main/java/com/example/fixtures/JavadocViolations.java#L4) | 类型只有普通行注释，没有类型 Javadoc。 |
| F002 | `javadoc` | [JavadocViolations.java:7](../src/main/java/com/example/fixtures/JavadocViolations.java#L7) | 公开构造方法缺少用途及参数 Javadoc。 |
| F003 | `javadoc` | [JavadocViolations.java:12](../src/main/java/com/example/fixtures/JavadocViolations.java#L12) | Javadoc 正文为英文；参数说明只重复标识符，且遗漏返回值和主动抛出异常的说明。 |
| F004 | `javadoc` | [JavadocViolations.java:23](../src/main/java/com/example/fixtures/JavadocViolations.java#L23) | 公开重写方法只有 @Override，没有 Javadoc。 |
| F005 | `javadoc` | [JavadocViolations.java:28](../src/main/java/com/example/fixtures/JavadocViolations.java#L28) | record 类型注释缺少作者、创建日期和组件 @param。 |
| F006 | `javadoc` | [JavadocViolations.java:31](../src/main/java/com/example/fixtures/JavadocViolations.java#L31) | 接口的隐式 public 方法缺少 Javadoc、参数和返回值说明。 |
| F007 | `javadoc` | [JavadocViolations.java:34](../src/main/java/com/example/fixtures/JavadocViolations.java#L34) | 嵌套 enum 缺少类型 Javadoc。 |
| F011 | `slf4j-logging` | [InjectionAndLoggingViolations.java:14](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L14) | 已使用 Lombok 的服务手写 LoggerFactory，按规则应使用 @Slf4j。 |
| F012 | `slf4j-logging` | [InjectionAndLoggingViolations.java:34](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L34) | 普通业务消息直接写标准输出；紧接着还有标准错误输出反例。 |
| F013 | `string-format` | [InjectionAndLoggingViolations.java:33](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L33) | 日志消息通过 + 拼接，应使用 SLF4J {} 参数占位符。 |
| F014 | `string-format` | [StringAndEncodingViolations.java:9](../src/main/java/com/example/fixtures/StringAndEncodingViolations.java#L9) | 使用 + 拼接字符串；本方法还包含 +=、concat、join、StringBuilder 的反例。 |
| F015 | `string-format` | [StringAndEncodingViolations.java:19](../src/main/java/com/example/fixtures/StringAndEncodingViolations.java#L19) | 调用未指定 Locale 的 String.format。 |
| F016 | `string-format` | [StringAndEncodingViolations.java:20](../src/main/java/com/example/fixtures/StringAndEncodingViolations.java#L20) | 使用 Locale.getDefault()，没有固定目标 Locale。 |
| F017 | `string-format` | [StringAndEncodingViolations.java:21](../src/main/java/com/example/fixtures/StringAndEncodingViolations.java#L21) | 显式传入 null Locale，仍不满足非空 Locale 要求。 |
| F018 | `string-format` | [StringAndEncodingViolations.java:22](../src/main/java/com/example/fixtures/StringAndEncodingViolations.java#L22) | 使用规则禁止的 String.formatted。 |
| F019 | `string-format` | [StringAndEncodingViolations.java:28](../src/main/java/com/example/fixtures/StringAndEncodingViolations.java#L28) | 编码未显式指定 UTF-8。 |
| F020 | `string-format` | [StringAndEncodingViolations.java:33](../src/main/java/com/example/fixtures/StringAndEncodingViolations.java#L33) | 解码未显式指定 UTF-8。 |
| F021 | `mapstruct-conversion` | [MappingViolations.java:11](../src/main/java/com/example/fixtures/MappingViolations.java#L11) | 该方法紧接着逐字段 new Target，属于实体转换，而非业务新建。 |
| F022 | `mapstruct-conversion` | [MappingViolations.java:18](../src/main/java/com/example/fixtures/MappingViolations.java#L18) | 两个不同实体通过反射复制属性，违反 MapStruct 统一映射规则。 |
| F023 | `mapstruct-conversion` | [MappingViolations.java:28](../src/main/java/com/example/fixtures/MappingViolations.java#L28) | 映射接口嵌在实体转换服务中，且 default 方法隐藏完整手工映射；外层 convert 方法实际调用该接口。 |
| F030 | `line-length` | [FormattingViolations.java:8](../src/main/java/com/example/fixtures/FormattingViolations.java#L8) | 方法声明长度为 177 字符，可在形参边界拆分，不属于字符串或 URL 例外。 |
| F034 | `javadoc` | [StyleViolationsTest.java:10](../src/test/java/com/example/fixtures/StyleViolationsTest.java#L10) | 测试代码的公开方法也缺少 Javadoc，不应按测试代码豁免。 |
| F035 | `explicit-imports` | [StyleViolationsTest.java:5](../src/test/java/com/example/fixtures/StyleViolationsTest.java#L5) | 测试目录中的静态通配符反例继续保留；Qodo 本轮反馈定位于 ImportViolations.java，其普通和静态通配符已经修正。 |

## 当前圈复杂度

使用 javac AST 计数。当前语料只有 if、for 和短路 || 决策点，不用关键字正则估算。统计全部 8 个源文件的 23 个手写函数，排除隐式构造与 Lombok 生成方法。

- CC 总和 35，平均值为 35/23（约 1.521739），最大为 7；满足平均 ≤ 5、单函数 ≤ 20。
- classify：基础 1 + 一个边界 if + 三个 || + 一个 for + 一个循环内 if = 7。
- adjust：CC=6，未超过单函数上限；不能因其大于 5 就判定为单函数违规。

完整函数指标与本地定点回归见 [validation.json](validation.json)。Qodo 各条反馈的修改映射见 [qodo-remediation.md](qodo-remediation.md)。
