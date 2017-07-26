package code.kliangh.commons.utils;

import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static Object getObject(Map nestedMap, List keys) {
        Object answer = nestedMap;

        for(Object key : keys) {
            if(key instanceof String) {
                answer = MapUtils.getObject((Map) answer, key);
            }

            if(key instanceof Integer) {
                answer = ListUtils.getObject((List) answer, (Integer) key);
            }
        }

        return answer;
    }
}