package code.kliangh.commons.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ListUtilsTest {

    List<Object> testList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        testList.add(new TestObject());
    }

    @Test
    public void getObject() throws Exception {
        assertTrue(ListUtils.getObject(testList,0) instanceof TestObject);
    }

    public class TestObject {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}