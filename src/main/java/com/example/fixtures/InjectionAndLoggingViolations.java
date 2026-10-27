package com.example.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.Getter;

/** 提供刻意违反注入与日志规范的虚构服务。 */
@Getter
@Service
public class InjectionAndLoggingViolations {
    private static final Logger LOG = LoggerFactory.getLogger(InjectionAndLoggingViolations.class);
    private final Environment environment;

    /** 仅做依赖字段赋值，故意保留可简化的构造方法。 */
    public InjectionAndLoggingViolations(Environment environment) {
        this.environment = environment;
    }

    /** 在 Spring 组件中通过通用环境对象读取固定标量配置。 */
    public boolean enabled() {
        return environment.getProperty("demo.feature.enabled", Boolean.class, false);
    }

    /** 在 Spring 组件中直接读取固定环境变量。 */
    public String label() {
        return System.getenv("DEMO_DISPLAY_LABEL");
    }

    /** 用手写 LoggerFactory 和标准输出记录普通业务消息。 */
    public void completed(String taskId) {
        LOG.info("Task completed: " + taskId);
        System.out.println("Task completed");
        System.err.println("Task summary unavailable");
    }
}
