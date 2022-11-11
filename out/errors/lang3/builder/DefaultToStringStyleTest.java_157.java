@Test
public void testObject10124() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(