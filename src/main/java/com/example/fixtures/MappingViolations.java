package com.example.fixtures;

import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import lombok.Data;

/** 提供手工实体映射和嵌套映射接口的反例。 */
public class MappingViolations {
    /** 手工逐字段构造 DTO。 */
    public Target toTarget(Source source) {
        return new Target(source.id(), source.name());
    }

    /** 使用反射复制两个不同实体的同名属性。 */
    public MutableTarget copy(MutableSource source) {
        MutableTarget target = new MutableTarget();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /** 调用实际存在的嵌套映射接口，避免仅有未使用声明。 */
    public Target convert(Source source, NestedMapper mapper) {
        return mapper.toTarget(source);
    }

    @Mapper
    public interface NestedMapper {
        default Target toTarget(Source source) {
            return new Target(source.id(), source.name());
        }
    }

    public record Source(String id, String name) {}

    public record Target(String id, String name) {}

    @Data
    public static class MutableSource {
        private String id;
        private String name;
    }

    @Data
    public static class MutableTarget {
        private String id;
        private String name;
    }
}
