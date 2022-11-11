@Test 
 public void testAppendSuper1748() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).appendSuper("Integer@8888[]").toString()); 
     assertEquals(baseStr + "[%NULL%]", new ToStringBuilder(base).appendSuper("Integer@8888[%NULL%]").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[%NULL%,a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[%NULL%]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 } 
@Test 
 public void testAppendSuper5939() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).appendSuper("Integer@8888[]").toString()); 
     assertEquals(baseStr + "[%NULL%]", new ToStringBuilder(base).appendSuper("Integer@8888[%NULL%]").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[%NULL%,a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[%NULL%]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 } 
