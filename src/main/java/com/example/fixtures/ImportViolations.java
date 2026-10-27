package com.example.fixtures;

import com.example.fixtures.MappingViolations.Source;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.sort;

/** 提供已修正普通和静态 import 的示例。 */
@Service
public class ImportViolations {
    /** 使用显式导入的类型和排序方法。 */
    public List<String> names(Map<String, String> values, Set<String> selected, Source source) {
        List<String> names = new ArrayList<>(selected);
        names.add(values.get(source.id()));
        sort(names);
        return names;
    }

    /** 字符集显式指定，仅用于给 import 提供实际调用点。 */
    public byte[] encode(String value) {
        return value.getBytes(StandardCharsets.UTF_8);
    }
}
