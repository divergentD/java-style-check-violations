package com.example.fixtures;

import java.util.Map;
import java.util.List;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.example.fixtures.MappingViolations.Source;
import java.util.*;
import static java.util.Collections.*;
import java.nio.charset.StandardCharsets;

/** 提供普通和静态 import 的通配符、排序及空行反例。 */
@Service
public class ImportViolations {
    /** 使用导入类型，导入声明故意保持乱序。 */
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
