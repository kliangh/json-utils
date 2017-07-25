package code.kliangh.commons.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by kliangh on 21/06/2017.
 *
 * <p>
 *     NOTE: Extract Map from nested Map by given keys(List)
 * </p>
 */
public class MapUtils extends org.apache.commons.collections.MapUtils {

    public static Map getMap(Map map, List keys) {
        Map answer = map;

        for(Object key : keys) {
            answer = MapUtils.getMap(answer, key);
        }

        return answer;
    }

    public static Map getMap(Map map, List keys, Map defaultValues) {
        Map answer = MapUtils.getMap(map, keys);

        //if one property is null, the given default values returned.
        if(answer == null || answer.containsValue(null)) {
            answer = defaultValues;
        }

        //find blank property
        Iterator<Map.Entry> it = answer.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = it.next();
            if(StringUtils.isBlank(pair.getValue().toString())) {
                answer = defaultValues;
            }
        }

        return answer;
    }
}
