@Test
public void testMode9835() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah