package com.example.fixtures;

// 提供虚构的用户查询示例，故意以普通注释替代类型 Javadoc。
public class JavadocViolations {
    private final String prefix;

    public JavadocViolations(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Find a display name.
     * @param userId userId
     */
    public String find(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("用户标识不能为空");
        }
        return userId;
    }

    @Override
    public String toString() {
        return prefix;
    }

    /** 保存查询结果。 */
    public record UserView(String id) {}

    public interface UserLookup {
        String find(String userId);
    }

    public enum Status {
        READY, DONE
    }
}
