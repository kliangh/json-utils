package code.kliangh.commons.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author kliangh
 * Test case for JsonUtils
 *
 * test json data:
 * <code>
 *     {
 *         "firstLayer":{
 *             "string":"example string",
 *             "nestedMap":{
 *                 "nullObject":null,
 *                 "list":[
 *                     "item1",
 *                     "item2"]
 *             }
 *         }
 *     }
 * </code>
 */
public class JsonUtilsTest {

    Map<Object, Object> testJson;

    @Before
    public void setUp() {
        testJson = new HashMap<>();

        List<Object> testList = ImmutableList.of("itme1", "item2");
        Object nullObject = null;

        Map<Object, Object> nestedMap = new HashMap<>();
        nestedMap.put("nullObject", nullObject);
        nestedMap.put("list", testList);

        Map<Object, Object> firstLayer = ImmutableMap.of("string", "example string", "nestedMap", nestedMap);

        testJson.put("firstLayer", firstLayer);
    }

    @Test
    public void retieveString() throws Exception {
        //Test for retrieving string
        List<Object> retrievingString = ImmutableList.of("firstLayer", "string");
        assertTrue(JsonUtils.getObject(testJson, retrievingString) instanceof String);

    }

    @Test
    public void retrieveItemOfList() throws Exception {
        //Test for retrieving item2 of list
        List<Object> retrievingItem = ImmutableList.of("firstLayer", "nestedMap", "list", 1);
        assertTrue("item2".equals(JsonUtils.getObject(testJson, retrievingItem)));
    }

    @Test
    public void retrieveNullObject() throws Exception {
        //Test for retrieving null object
        List<Object> retrievingNullObject = ImmutableList.of("firstLayer", "nestedMap", "nullObject");
        assertNull(JsonUtils.getObject(testJson, retrievingNullObject));
    }

}