# 预期风格问题

对应 [java-style-check 固定规则版本](https://github.com/divergentD/java-style-check/tree/989b18625732825130f7903c4e6fd247aa4d8760)。

以下 34 项覆盖全部 13 个规则 ID，是人工核对的最小预期集合。其他文件也有刻意保留的 Javadoc 缺失，因此不能用这份清单宣称所有问题已经穷举。

| 编号 | 规则 | 位置 | 预期发现 |
| --- | --- | --- | --- |
| F001 | `javadoc` | [JavadocViolations.java:4](../src/main/java/com/example/fixtures/JavadocViolations.java#L4) | 类型只有普通行注释，没有类型 Javadoc。 |
| F002 | `javadoc` | [JavadocViolations.java:7](../src/main/java/com/example/fixtures/JavadocViolations.java#L7) | 公开构造方法缺少用途及参数 Javadoc。 |
| F003 | `javadoc` | [JavadocViolations.java:12](../src/main/java/com/example/fixtures/JavadocViolations.java#L12) | Javadoc 正文为英文；参数说明只重复标识符，且遗漏返回值和主动抛出异常的说明。 |
| F004 | `javadoc` | [JavadocViolations.java:23](../src/main/java/com/example/fixtures/JavadocViolations.java#L23) | 公开重写方法只有 @Override，没有 Javadoc。 |
| F005 | `javadoc` | [JavadocViolations.java:28](../src/main/java/com/example/fixtures/JavadocViolations.java#L28) | record 类型注释缺少作者、创建日期和组件 @param。 |
| F006 | `javadoc` | [JavadocViolations.java:31](../src/main/java/com/example/fixtures/JavadocViolations.java#L31) | 接口的隐式 public 方法缺少 Javadoc、参数和返回值说明。 |
| F007 | `javadoc` | [JavadocViolations.java:34](../src/main/java/com/example/fixtures/JavadocViolations.java#L34) | 嵌套 enum 缺少类型 Javadoc。 |
| F008 | `spring-injection` | [InjectionAndLoggingViolations.java:18](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L18) | Spring 服务已用 Lombok @Getter；该构造仅赋值 final 依赖，没有初始化或校验，应提出可简化建议。 |
| F009 | `configuration-injection` | [InjectionAndLoggingViolations.java:24](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L24) | Spring 管理的服务通过 Environment 读取固定布尔键，应使用 @Value 并保留 false 默认值。 |
| F010 | `configuration-injection` | [InjectionAndLoggingViolations.java:29](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L29) | Spring 组件直接读取固定环境变量，绕开统一属性源注入。 |
| F011 | `slf4j-logging` | [InjectionAndLoggingViolations.java:14](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L14) | 已使用 Lombok 的服务手写 LoggerFactory，按规则应使用 @Slf4j。 |
| F012 | `slf4j-logging` | [InjectionAndLoggingViolations.java:35](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L35) | 普通业务消息直接写标准输出；紧接着还有标准错误输出反例。 |
| F013 | `string-format` | [InjectionAndLoggingViolations.java:34](../src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java#L34) | 日志消息通过 + 拼接，应使用 SLF4J {} 参数占位符。 |
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
| F024 | `cyclomatic-complexity` | [ComplexityViolations.java:6](../src/main/java/com/example/fixtures/ComplexityViolations.java#L6) | classify 有 21 个 if 与 84 个 &&，CC=106，超过单函数最大值 20。 |
| F025 | `cyclomatic-complexity` | [ComplexityViolations.java:75](../src/main/java/com/example/fixtures/ComplexityViolations.java#L75) | 本文件两个方法 CC 为 106 和 6，平均 56；全仓 24 个函数总 CC=135，平均 5.625，也超过 5。不能仅凭 adjust 的 CC=6 判定其单函数超限。 |
| F026 | `explicit-imports` | [ImportViolations.java:9](../src/main/java/com/example/fixtures/ImportViolations.java#L9) | 普通 import 使用通配符。 |
| F027 | `explicit-imports` | [ImportViolations.java:10](../src/main/java/com/example/fixtures/ImportViolations.java#L10) | 静态 import 使用通配符。 |
| F028 | `import-order` | [ImportViolations.java:3](../src/main/java/com/example/fixtures/ImportViolations.java#L3) | java 组排在 org/com.example 组之前，组内 Map 在 List 之前；静态 import 后还出现普通 import。 |
| F029 | `import-spacing` | [ImportViolations.java:6](../src/main/java/com/example/fixtures/ImportViolations.java#L6) | List/Set 同组中间多空行；Set/org 跨组缺空行，普通与静态 import 之间也缺空行。 |
| F030 | `line-length` | [FormattingViolations.java:8](../src/main/java/com/example/fixtures/FormattingViolations.java#L8) | 方法声明长度为 177 字符，可在形参边界拆分，不属于字符串或 URL 例外。 |
| F031 | `continuation-format` | [FormattingViolations.java:16](../src/main/java/com/example/fixtures/FormattingViolations.java#L16) | summary 的续行缩进逐层加深，而不是相对首行增加 4 空格后对齐。 |
| F032 | `continuation-format` | [FormattingViolations.java:22](../src/main/java/com/example/fixtures/FormattingViolations.java#L22) | 链式调用点号留在上一行末尾，应与下一行方法名放在一起。 |
| F033 | `avoid-excessive-wrapping` | [FormattingViolations.java:28](../src/main/java/com/example/fixtures/FormattingViolations.java#L28) | 整句 String normalized = value.trim().toLowerCase(Locale.ROOT); 不超过 120 字符，却逐层拆开。 |
| F034 | `javadoc` | [StyleViolationsTest.java:10](../src/test/java/com/example/fixtures/StyleViolationsTest.java#L10) | 测试代码的公开方法也缺少 Javadoc，不应按测试代码豁免。 |

## 圈复杂度证据

使用 OpenJDK javac 21.0.12 的 AST 解析与 TreeScanner 计数，只调用 parse，不进行依赖解析或编译。当前语料只有 if 与短路 && 决策点；不使用关键字正则估算。无 lambda、局部/匿名类、初始化块或 switch 等需另行约定的计数结构。

统计全部 src 下 Java 文件的手写方法、显式构造与接口 default 实现；排除隐式构造及 Lombok 生成方法。

- 范围内 24 个函数，CC 总和 135，平均 5.625，最大 106；平均值与最大值均超标。
- 仅 ComplexityViolations.java：两个函数 CC=106、6，平均 56，最大 106。
- classify：基础值 1 + 21 个 if + 84 个 && = 106。
- adjust：基础值 1 + 5 个 if = 6；它未超过单函数上限 20。

各函数指标见 [validation.json](validation.json)。语法解析成功不代表项目可编译、可运行或风格检查通过。
