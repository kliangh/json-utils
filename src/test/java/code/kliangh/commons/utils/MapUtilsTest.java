package code.kliangh.commons.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by kliangh on 22/06/2017.
 *
 * Test input Map in JSON format
 *
 *     {
 *         "character":
 *         {
 *             "foo": 26,
 *             "greeting":
 *             {
 *                 "ello": 1,
 *                 "hello": 2,
 *                 "salut": 3
 *             },
 *             "blankProperty":
 *             {
 *                 "blank": ""
 *             },
 *             "nullProperty":
 *             {
 *                 "null": null
 *             }
 *         }
 *     }
 * You can extract specific map by given List of keys.
 */
public class MapUtilsTest {

    Map<String, Object> testMap;
    Map<String, Object> defaultValues;

    @Before
    public void setUp() throws Exception {
        Map<String, Object> nullPropertyMap = new HashMap<>();
        nullPropertyMap.put("null", null);

        Map<String, Object> blankPropertyMap = ImmutableMap.of("blank", "");
        Map<String, Integer> greetingMap = ImmutableMap.of("ello", 1, "hello", 2, "salut", 3);

        Map<String, Object> characterMap = ImmutableMap.of("foo", 26, "greeting", greetingMap, "blankProperty", blankPropertyMap, "nullProperty", nullPropertyMap);

        testMap = ImmutableMap.of("character", characterMap);
        defaultValues = ImmutableMap.of("default", 0);
    }

    @Test
    public void getMapWithoutDefaultValues() throws Exception {
        int expectValue = 1;
        List<String> keys = ImmutableList.of("character", "greeting");

        Assert.assertEquals(expectValue, MapUtils.getMap(testMap, keys).get("ello"));
    }

    @Test
    public void getMapWithDefaultValues() throws Exception {
        int expectValue = 0;
        List<String> keys = ImmutableList.of("character", "foo");

        Assert.assertEquals(expectValue, MapUtils.getMap(testMap, keys, defaultValues).get("default"));
    }

    @Test
    public void getMapWithDefaultValuesAndBlankValueReturned() throws Exception {
        int expectValue = 0;
        List<String> keys = ImmutableList.of("character", "blankProperty");

        Assert.assertEquals(expectValue, MapUtils.getMap(testMap, keys, defaultValues).get("default"));
    }

    @Test
    public void getMapWithDefaultValuesAndNullPropertyMapReturned() throws Exception {
        int expectValue = 0;
        List<String> keys = ImmutableList.of("character", "nullProperty");

        Assert.assertEquals(expectValue, MapUtils.getMap(testMap, keys, defaultValues).get("default"));
    }

}