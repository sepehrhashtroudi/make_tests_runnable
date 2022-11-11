@Test
public void testObjectBuild11529() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).build()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).build()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).build()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).build()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).build()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, null).build()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).build()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).build()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).build()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).build()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).build()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).build()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a