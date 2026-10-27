package com.example.fixtures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

/** 提供已修正配置注入、仍保留日志反例的虚构服务。 */
@Getter
@Service
public class InjectionAndLoggingViolations {
    private static final Logger LOG = LoggerFactory.getLogger(InjectionAndLoggingViolations.class);
    @Value("${demo.feature.enabled:false}")
    private boolean featureEnabled;

    @Value("${demo.display.label:#{null}}")
    private String displayLabel;

    /** 读取 Spring 注入的功能开关，缺省关闭。 */
    public boolean enabled() {
        return featureEnabled;
    }

    /** 读取 Spring 属性源中的展示名，缺省保持 null。 */
    public String label() {
        return displayLabel;
    }

    /** 用手写 LoggerFactory 和标准输出记录普通业务消息。 */
    public void completed(String taskId) {
        LOG.info("Task completed: " + taskId);
        System.out.println("Task completed");
        System.err.println("Task summary unavailable");
    }
}
