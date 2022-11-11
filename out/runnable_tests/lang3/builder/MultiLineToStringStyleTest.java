@Test 
 public void testAppendSuper2483() { 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).appendSuper("Integer@8888[" + SystemUtils.LINE_SEPARATOR + "]").toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  <null>" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).appendSuper("Integer@8888[" + SystemUtils.LINE_SEPARATOR + "  <null>" + SystemUtils.LINE_SEPARATOR + "]").toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=hello" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).appendSuper("Integer@8888[" + SystemUtils.LINE_SEPARATOR + "]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  <null>" + SystemUtils.LINE_SEPARATOR + "  a=hello" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).appendSuper("Integer@8888[" + SystemUtils.LINE_SEPARATOR + "  <null>" + SystemUtils.LINE_SEPARATOR + "]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=hello" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 } 
@Test 
 public void testObject4185() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  <null>" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  3" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=<null>" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=3" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=3" + SystemUtils.LINE_SEPARATOR + "  b=4" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=<Integer>" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=<size=0>" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=[]" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=<size=0>" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a={}" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a=<size=0>" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[" + SystemUtils.LINE_SEPARATOR + "  a={}" + SystemUtils.LINE_SEPARATOR + "]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
