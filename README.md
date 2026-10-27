# Java Style Check Review Fixtures

用于检验 [java-style-check](https://github.com/divergentD/java-style-check) 的 Java 静态审查语料。全部代码为新写的虚构示例。

最初版本覆盖 13 条规则。当前版本按用户要求修复 Qodo 的 11 条反馈，保留其余反例，现有 23 项最小预期发现、6 类仍故意违反的规则。已修正的代码也保留在源码中，便于对照审查。

包含 8 个 Java 文件，源码使用 Java 21 语法，没有应用启动入口或构建工程要求。Spring、SLF4J、Lombok、MapStruct 与 JUnit 的导入用于表达静态审查语境。

规则基线固定为 [`989b186`](https://github.com/divergentD/java-style-check/tree/989b18625732825130f7903c4e6fd247aa4d8760)。

## 当前保留的违规

| 规则 ID | 示例文件 |
| --- | --- |
| `javadoc` | [JavadocViolations.java](src/main/java/com/example/fixtures/JavadocViolations.java) |
| `slf4j-logging` | [InjectionAndLoggingViolations.java](src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java) |
| `string-format` | [InjectionAndLoggingViolations.java](src/main/java/com/example/fixtures/InjectionAndLoggingViolations.java) |
| `mapstruct-conversion` | [MappingViolations.java](src/main/java/com/example/fixtures/MappingViolations.java) |
| `line-length` | [FormattingViolations.java](src/main/java/com/example/fixtures/FormattingViolations.java) |
| `explicit-imports` | [StyleViolationsTest.java](src/test/java/com/example/fixtures/StyleViolationsTest.java) |

## 本轮已修正

- 固定配置使用 @Value；保留开关缺省 false、展示名缺省 null，允许 Spring 属性源覆盖。非法布尔配置在容器装配时失败。
- 将重复整除判断改为同一边界校验加循环，保持计分结果；圈复杂度平均值和最大值都已满足规则。
- 修正 ImportViolations.java 的普通/静态通配符、分组、字典序和空行。测试目录的通配符反例仍保留。
- 修正 FormattingViolations.java 的续行缩进、点号位置和过度换行，保留超长声明反例。

详见 [Qodo 修复映射](docs/qodo-remediation.md)。原始问题可从提交历史查看；JSON 的 resolved_findings 仅记录历史，不计作当前问题。

## 如何检查

```text
$java-style-check 检查 src 下全部 Java 文件，只报告问题，保留剩余的故意违规反例。
```

建议先独立审查，再查看 [当前预期问题](docs/expected-findings.md) 与 [机器可读清单](expected-findings.json)。

## 本地校验

8 个源文件通过 Java 21 语法解析与本地 javac 编译。23 个手写函数总 CC=35，平均 35/23，最大 7。

定点回归通过：5 个真实 Spring 上下文配置场景、14,003 个输入的原版/新版计分等价检查、7 个换行修改等价场景。使用本地已缓存的依赖完成验证，未把依赖、编译产物或临时验证程序加入仓库。

未启动完整应用、未运行示例 JUnit 方法。局部校验通过不代表所有风格规则通过，也不代表 Qodo 已复审通过。详见 [校验记录](docs/validation.json)。
