# json-utils
[![Build Status](https://img.shields.io/travis/kliangh/json-utils.svg)](https://travis-ci.org/kliangh/json-utils) [![codecov](https://img.shields.io/codecov/c/github/kliangh/json-utils.svg)](https://codecov.io/gh/kliangh/json-utils)  
A json utility to help developer to extract object from json(Map) by extending apche MapUtils and ListUtils.

### Input data
```
     {
         "firstLayer":{
             "string":"example string",
             "nestedMap":{
                 "nullObject":null,
                 "list":[
                     "item1",
                     "item2"]
             }
         }
    }
```

If you are looking for `item2` of list, you can declare a list of path as below.
```
List<Object> retrievingItem = ImmutableList.of("firstLayer", "nestedMap", "list", 2);
```