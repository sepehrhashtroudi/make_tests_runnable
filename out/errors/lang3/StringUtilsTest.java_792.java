@Test
public void testJoin_ArrayString9601() { 
         assertEquals(null, StringUtils.join((Object[]) null, null, 0, 0)); 
         assertEquals(TEXT_LIST_NOSEP, StringUtils.join(ARRAY_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(EMPTY_ARRAY_LIST, null, 0, 0)); 
         assertEquals(";;foo", StringUtils.join(MIXED_ARRAY_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("foo;2", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
  
         assertEquals("/", StringUtils.join(MIXED_ARRAY_LIST, null, 0, MIXED_ARRAY_LIST.length-1)); 
         assertEquals("foo", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1)); 
         assertEquals("null", StringUtils.join(NULL_TO_STRING_LIST,'/', 0, 1)); 
         assertEquals("foo/2", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 2)); 
         assertEquals("2", StringUtils.join(MIXED_TYPE_LIST, "/", 1, 2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, 2, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 2, 2)); 
          
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, 0, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, -1, -2)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, "/", 0, 1)); 
         assertEquals("", StringUtils.join(MIXED_TYPE_LIST, null, 0, 2)); 
         assertEquals("",