# Qodo 本轮反馈修复

反馈来源为 [PR #1](https://github.com/divergentD/java-style-check-violations/pull/1) 中针对 `7bc0488` 的 11 条行内意见。下表记录当前代码修复及本地验证，未将 Qodo 的复审状态标记为通过。

| 反馈 | 修复 |
| --- | --- |
| [1. Spring settings bypass property injection 📘 Rule violation ⌂ Architecture](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173176) | 固定布尔配置使用 @Value，缺省 false。 |
| [2. Settings bypass spring property sources 📘 Rule violation ≡ Correctness](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173186) | 展示名通过 Spring 属性源注入，缺省 null；大写环境变量和高优先级配置均有真实上下文验证。 |
| [3. One function exceeds the complexity limit 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173203) | classify 从 CC=106 改为 CC=7，14,003 个输入与原版结果一致。 |
| [4. The codebase exceeds average complexity 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173211) | 23 个手写函数总 CC=35，平均 35/23，满足平均值上限；同步重新生成指标。 |
| [5. Wildcard imports hide referenced types 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173223) | ImportViolations.java 改为 ArrayList/List/Map/Set 和静态 sort 的显式导入。 |
| [6. Short calls are split across lines 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173166) | overWrapped 中的赋值语句合并为一行。 |
| [7. Continuation lines lose alignment 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173192) | summary 的参数续行相对首行增加 4 空格并对齐。 |
| [8. Dots remain on the previous line 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173194) | normalize 的完整调用保持一行。 |
| [9. Imports appear in the wrong order 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173235) | 普通 import 按 com.example、org、java 分组并按完整名称排序，静态 import 置于最后。 |
| [10. Import groups have incorrect spacing 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173242) | 不同普通 import 组、普通与静态 import 之间使用一个空行。 |
| [11. Same-group imports are split by blanks 📘 Rule violation ⚙ Maintainability](https://github.com/divergentD/java-style-check-violations/pull/1#discussion_r4389173246) | 移除同一 java 组内的空行。 |

修复移除了固定配置读取所需的 Environment 依赖与手写构造，因此原始 spring-injection 反例随之消失。其余 Javadoc、日志、字符串、MapStruct、行宽与测试目录通配符反例继续保留。

本地验证：全部 8 个 Java 源文件通过语法解析及 javac 编译；5 个真实 Spring 上下文配置场景、14,003 个计分等价输入和 7 个排版等价场景通过。未启动完整应用，未执行示例 JUnit 方法。

具体指标及范围见 [validation.json](validation.json)。原始问题与当前问题分别保存在 [expected-findings.json](../expected-findings.json) 的 resolved_findings 和 findings 中。

