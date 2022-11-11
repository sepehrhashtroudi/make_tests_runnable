@Test 
 public void testPerson93() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testObject433() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject658() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject756() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject851() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject1570() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testPerson1783() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testObject2067() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject2364() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testPerson3220() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testObject3268() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject3454() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject3507() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject3702() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testPerson4050() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testObject4250() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject4325() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject4764() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testPerson4967() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testObject5208() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject5466() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject5539() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testPerson5580() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testPerson5637() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testObject6024() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject7096() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject7117() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject7420() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testPerson7470() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testObject7756() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject8168() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject8321() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject8633() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject9117() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testObject9203() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 } 
@Test 
 public void testPerson9214() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
 public void testPerson9500() { 
     final Person p = new Person(); 
     p.name = "John Doe"; 
     p.age = 33; 
     p.smoker = false; 
     final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
     assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
 } 
@Test 
     public void testIntArray9578() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10005() { 
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
@Test 
     public void testObject10006() { 
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
@Test 
     public void testObject10007() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10008() { 
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
@Test 
     public void testObject10009() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10010() { 
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
@Test 
     public void testObject10011() { 
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
@Test 
     public void testObject10012() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10013() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10014() { 
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
@Test 
     public void testObject10015() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testIntArray10016() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10017() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10018() { 
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
@Test 
     public void testObject10019() { 
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
@Test 
     public void testOneArgNull10020() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     } 
  

@Test 
     public void testObject10021() { 
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
@Test 
     public void testObject10022() { 
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
@Test 
     public void testObject10023() { 
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
@Test 
     public void testObject10024() { 
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
@Test 
     public void testObject10025() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10026() { 
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
@Test 
     public void testObject10027() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testOneArgNull10028() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     } 
  

@Test 
     public void testObject10029() { 
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
@Test 
     public void testObject10030() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10031() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10032() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10033() { 
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
@Test 
     public void testOneArgNull10034() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     } 
  

@Test 
     public void testLongArray10035() { 
         long[] array = new long[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10036() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10037() { 
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
@Test 
     public void testBooleanArray10038() { 
         boolean[] array = new boolean[] { true, false, false }; 
         assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10039() { 
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
@Test 
     public void testPerson10040() { 
         final Person p = new Person(); 
         p.name = "John Doe"; 
         p.age = 33; 
         p.smoker = false; 
         final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
         assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
     } 
  

@Test 
     public void testObject10041() { 
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
@Test 
     public void testObject10042() { 
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
@Test 
     public void testObject10043() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10044() { 
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
@Test 
     public void testIntArray10045() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10046() { 
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
@Test 
     public void testObject10047() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testDoubleArray10048() { 
         double[] array = new double[] {1.0, 2.9876, -3.00001, 4.3}; 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10049() { 
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
@Test 
     public void testObject10050() { 
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
@Test 
     public void testObject10051() { 
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
@Test 
     public void testObject10052() { 
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
@Test 
     public void testObject10053() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10054() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10055() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10056() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10057() { 
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
@Test 
     public void testObject10058() { 
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
@Test 
     public void testObject10059() { 
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
@Test 
     public void testObject10060() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10061() { 
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
@Test 
     public void testObject10062() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10063() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10064() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10065() { 
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
@Test 
     public void testObject10066() { 
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
@Test 
     public void testObject10067() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10068() { 
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
@Test 
     public void testPerson10069() { 
         final Person p = new Person(); 
         p.name = "John Doe"; 
         p.age = 33; 
         p.smoker = false; 
         final String pBaseStr = p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p)); 
         assertEquals(pBaseStr + "[name=John Doe,age=33,smoker=false]", new ToStringBuilder(p).append("name", p.name).append("age", p.age).append("smoker", p.smoker).toString()); 
     } 
  

@Test 
     public void testObject10070() { 
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
@Test 
     public void testObject10071() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10072() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10073() { 
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
@Test 
     public void testObject10074() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10075() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testIntArray10076() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10077() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10078() { 
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
@Test 
     public void testObject10079() { 
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
@Test 
     public void testObject10080() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10081() { 
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
@Test 
     public void testObject10082() { 
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
@Test 
     public void testObject10083() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10084() { 
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
@Test 
     public void testObject10085() { 
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
@Test 
     public void testObject10086() { 
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
@Test 
     public void testObject10087() { 
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
@Test 
     public void testObject10088() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10089() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10090() { 
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
@Test 
     public void testObject10091() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10092() { 
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
@Test 
     public void testIntArray10093() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10094() { 
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
@Test 
     public void testObject10095() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10096() { 
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
@Test 
     public void testObject10097() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10098() { 
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
@Test 
     public void testObject10099() { 
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
@Test 
     public void testObject10100() { 
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
@Test 
     public void testObject10101() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10102() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testIntArray10103() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10104() { 
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
@Test 
     public void testObject10105() { 
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
@Test 
     public void testObject10106() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testIntArray10107() { 
         int[] array = new int[] {1, 2, -3, 4}; 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testFloatArray10108() { 
         float[] array = new float[] {1.0f, 2.9876f, -3.00001f, 4.3f}; 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
         array = null; 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
     } 
  

@Test 
     public void testObject10109() { 
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
@Test 
     public void testObject10110() { 
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
@Test 
     public void testObject10111() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10112() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10113() { 
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
@Test 
     public void testObject10114() { 
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
@Test 
     public void testObject10115() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10116() { 
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
@Test 
     public void testOneArgNull10117() { 
         assertFalse(AnnotationUtils.equals(field1.getAnnotation(TestAnnotation.class), null)); 
         assertFalse(AnnotationUtils.equals(null, field1.getAnnotation(TestAnnotation.class))); 
     } 
  

@Test 
     public void testObject10118() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10119() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10120() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10121() { 
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
@Test 
     public void testObject10122() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
@Test 
     public void testObject10123() { 
         final Integer i3 = Integer.valueOf(3); 
         final Integer i4 = Integer.valueOf(4); 
         assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
         assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
         assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
         assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
         assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
         assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
         assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
         assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
         assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a",
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
