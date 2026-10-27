# Java Style Check Violations

用于检验 [java-style-check](https://github.com/divergentD/java-style-check) 的故意违规 Java 示例仓库。全部代码为新写的虚构示例。

本仓库包含 8 个 Java 文件，覆盖规则集中的全部 13 条规则，包含生产目录和测试目录。源码按 Java 21 语法编写；没有启动入口、构建配置或依赖安装流程，不要求运行。Spring、SLF4J、Lombok、MapStruct 与 JUnit 的导入用于表达静态审查语境。Lombok 已通过 @Getter/@Data 在示例中使用，注入与日志规则应按这一前提判断。

规则基线固定为 [`989b186`](https://github.com/divergentD/java-style-check/tree/989b18625732825130f7903c4e6fd247aa4d8760)。

## 规则覆盖

| 规则 ID | 示例文件 |
| --- | --- |
| `javadoc` | [JavadocViolations.java](src/main/java/com/example/fixtures/JavadocViolations.java) |
| `spring-injection` | [InjectionAndLoggingViolations.java](src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java) |
| `configuration-injection` | [InjectionAndLoggingViolations.java](src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java) |
| `slf4j-logging` | [InjectionAndLoggingViolations.java](src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java) |
| `string-format` | [InjectionAndLoggingViolations.java](src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java) |
| `mapstruct-conversion` | [MappingViolations.java](src/main/java/com/example/fixtures/MappingViolations.java) |
| `cyclomatic-complexity` | [ComplexityViolations.java](src/main/java/com/example/fixtures/ComplexityViolations.java) |
| `explicit-imports` | [ImportViolations.java](src/main/java/com/example/fixtures/ImportViolations.java) |
| `import-order` | [ImportViolations.java](src/main/java/com/example/fixtures/ImportViolations.java) |
| `import-spacing` | [ImportViolations.java](src/main/java/com/example/fixtures/ImportViolations.java) |
| `line-length` | [FormattingViolations.java](src/main/java/com/example/fixtures/FormattingViolations.java) |
| `continuation-format` | [FormattingViolations.java](src/main/java/com/example/fixtures/FormattingViolations.java) |
| `avoid-excessive-wrapping` | [FormattingViolations.java](src/main/java/com/example/fixtures/FormattingViolations.java) |

## 如何检查

将本仓库交给已安装 java-style-check 的 Agent，并明确指定全量范围：

```text
$java-style-check 检查 src 下全部 Java 文件，只报告问题，保留这些故意违规的反例。
```

建议先独立审查，再查看 [预期问题对照](docs/expected-findings.md)；机器可读清单见 [expected-findings.json](expected-findings.json)。清单给出 34 项最小预期发现，不限制 Agent 发现其他真实违规。

## 已做的校验

8 个源文件通过 javac AST 语法解析。24 个函数的平均 CC 为 5.625，最大为 106，两项都故意超标。完整计量范围与各函数指标见 [校验记录](docs/validation.json)。

未执行依赖解析、完整编译、测试或运行。风格检查的预期结果为发现违规；所有反例按仓库用途保留。
