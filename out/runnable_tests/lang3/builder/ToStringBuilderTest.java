@Test 
 public void testLongArray76() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testCharArray92() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testIntArray129() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionHierarchy149() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@Test 
 public void testBoolean254() { 
     assertEquals(baseStr + "[true]", new ToStringBuilder(base).append(true).toString()); 
     assertEquals(baseStr + "[a=true]", new ToStringBuilder(base).append("a", true).toString()); 
     assertEquals(baseStr + "[a=true,b=false]", new ToStringBuilder(base).append("a", true).append("b", false).toString()); 
 } 
@Test 
 public void testShortArray275() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testBooleanArray302() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testIntArray365() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testBooleanArray375() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble377() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testCharArray412() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testLong421() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 } 
@Test 
 public void testCharArray474() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloat475() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray534() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid571() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testBoolean623() { 
     assertEquals(baseStr + "[true]", new ToStringBuilder(base).append(true).toString()); 
     assertEquals(baseStr + "[a=true]", new ToStringBuilder(base).append("a", true).toString()); 
     assertEquals(baseStr + "[a=true,b=false]", new ToStringBuilder(base).append("a", true).append("b", false).toString()); 
 } 
@Test 
 public void testReflectionCharArrayArray630() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid634() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testInt744() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((int) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (int) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (int) 3).append("b", (int) 4).toString()); 
 } 
@Test 
 public void testChar757() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testCharArray806() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testAppendToStringUsingMultiLineStyle825() { 
     final MultiLineTestObject obj = new MultiLineTestObject(); 
     final ToStringBuilder testBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendToString(obj.toString()); 
     assertEquals(testBuilder.toString().indexOf("testInt=31337"), -1); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble925() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testReflectionBooleanArray949() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testReflectionBooleanArray1061() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testByteArray1064() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloat1074() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testChar1078() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testAppendSuper1131() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).appendSuper("Integer@8888[]").toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[<null>,a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble1149() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testReflectionBooleanArray1166() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testIntArray1243() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloat1276() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testByteArrayArray1278() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray1354() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testReflectionHierarchy1381() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@Test 
 public void testByteArrayArray1437() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testIntArray1470() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid1548() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testByteArray1556() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics1560() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble1597() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testSetDefaultEx1602() { 
     ToStringBuilder.setDefaultStyle(null); 
 } 
@Test 
 public void testObjectCycle1714() { 
     final ObjectCycle a = new ObjectCycle(); 
     final ObjectCycle b = new ObjectCycle(); 
     a.obj = b; 
     b.obj = a; 
     final String expected = toBaseString(a) + "[" + toBaseString(b) + "[" + toBaseString(a) + "]]"; 
     assertEquals(expected, a.toString()); 
 } 
@Test 
 public void testBooleanArray1756() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testChar1808() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testReflectionCharArrayArray1819() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testShortArray1867() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid1894() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid1978() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testDoubleArray2005() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testAppendToStringUsingMultiLineStyle2027() { 
     final MultiLineTestObject obj = new MultiLineTestObject(); 
     final ToStringBuilder testBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendToString(obj.toString()); 
     assertEquals(testBuilder.toString().indexOf("testInt=31337"), -1); 
 } 
@Test 
 public void testReflectionCharArrayArray2041() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testDoubleArray2147() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testDoubleArray2164() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testShortArray2168() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testByteArray2187() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble2195() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testLongArray2253() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testDoubleArray2337() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testLong2383() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 } 
@Test 
 public void testReflectionHierarchy2409() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@Test 
 public void testReflectionCharArrayArray2481() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testObjectBuild2499() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).build()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).build()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).build()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).build()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).build()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).build()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).build()); 
 } 
@Test 
 public void testFloat2551() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testByteArrayArray2590() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testLong2645() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 } 
@Test 
 public void testObjectCycle2673() { 
     final ObjectCycle a = new ObjectCycle(); 
     final ObjectCycle b = new ObjectCycle(); 
     a.obj = b; 
     b.obj = a; 
     final String expected = toBaseString(a) + "[" + toBaseString(b) + "[" + toBaseString(a) + "]]"; 
     assertEquals(expected, a.toString()); 
 } 
@Test 
 public void testBooleanArray2719() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testCharArray2741() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testBooleanArray2835() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionBooleanArray2888() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid2946() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testBooleanArray2963() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionBooleanArray2994() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testAppendSuper2998() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).appendSuper("Integer@8888[]").toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[<null>,a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 } 
@Test 
 public void testReflectionStatics3015() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid3037() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testFloat3072() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid3082() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testInt3180() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((int) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (int) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (int) 3).append("b", (int) 4).toString()); 
 } 
@Test 
 public void testChar3219() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testFloatArray3222() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testBooleanArray3244() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics3252() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testLong3254() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 } 
@Test 
 public void testShortArray3278() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testByteArrayArray3341() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testBooleanArray3419() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloatArray3463() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics3473() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testObjectBuild3532() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).build()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).build()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).build()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).build()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).build()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).build()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).build()); 
 } 
@Test 
 public void testReflectionStatics3538() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testShort3598() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testChar3639() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testBooleanArray3674() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloatArray3693() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testObjectCycle3697() { 
     final ObjectCycle a = new ObjectCycle(); 
     final ObjectCycle b = new ObjectCycle(); 
     a.obj = b; 
     b.obj = a; 
     final String expected = toBaseString(a) + "[" + toBaseString(b) + "[" + toBaseString(a) + "]]"; 
     assertEquals(expected, a.toString()); 
 } 
@Test 
 public void testShortArray3805() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloatArray3898() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid3905() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testDoubleArray3917() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testShort3930() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testReflectionHierarchy3978() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@Test 
 public void testReflectionStatics4036() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testSetDefaultEx4115() { 
     ToStringBuilder.setDefaultStyle(null); 
 } 
@Test 
 public void testShortArray4128() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testChar4199() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble4210() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testByteArrayArray4218() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testAppendToStringUsingMultiLineStyle4227() { 
     final MultiLineTestObject obj = new MultiLineTestObject(); 
     final ToStringBuilder testBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendToString(obj.toString()); 
     assertEquals(testBuilder.toString().indexOf("testInt=31337"), -1); 
 } 
@Test 
 public void testFloatArray4334() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray4417() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testGetSetDefault4488() { 
     try { 
         ToStringBuilder.setDefaultStyle(ToStringStyle.NO_FIELD_NAMES_STYLE); 
         assertSame(ToStringStyle.NO_FIELD_NAMES_STYLE, ToStringBuilder.getDefaultStyle()); 
     } finally { 
         ToStringBuilder.setDefaultStyle(ToStringStyle.DEFAULT_STYLE); 
     } 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid4492() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid4500() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testInt4520() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((int) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (int) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (int) 3).append("b", (int) 4).toString()); 
 } 
@Test 
 public void testShortArray4586() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testByteArrayArray4732() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionBooleanArray4819() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testFloatArray4853() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloatArray4902() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid4919() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testByteArray4938() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics4950() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testChar4971() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testShort4988() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testReflectionBooleanArray5048() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid5049() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testAppendSuper5120() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).appendSuper("Integer@8888[]").toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[<null>,a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 } 
@Test 
 public void testReflectionStatics5123() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble5145() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testShortArray5185() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics5211() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testReflectionStatics5248() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid5266() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble5280() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid5348() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testReflectionBooleanArray5409() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testIntArray5419() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testShort5451() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid5467() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testCharArray5495() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testIntArray5499() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionCharArrayArray5541() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testReflectionCharArrayArray5596() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testInt5638() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((int) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (int) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (int) 3).append("b", (int) 4).toString()); 
 } 
@Test 
 public void testByteArrayArray5641() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics5643() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testReflectionStatics5652() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testReflectionBooleanArray5701() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testDoubleArray5702() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testLong5714() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 } 
@Test 
 public void testBooleanArray5787() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testDoubleArray5804() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionHierarchy5853() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@Test 
 public void testFloat5982() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testLongArray5994() { 
     long[] array = new long[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testShortArray6013() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics6027() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testShort6082() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testObjectCycle6104() { 
     final ObjectCycle a = new ObjectCycle(); 
     final ObjectCycle b = new ObjectCycle(); 
     a.obj = b; 
     b.obj = a; 
     final String expected = toBaseString(a) + "[" + toBaseString(b) + "[" + toBaseString(a) + "]]"; 
     assertEquals(expected, a.toString()); 
 } 
@Test 
 public void testShort6141() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testReflectionCharArrayArray6151() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testReflectionBooleanArray6153() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testReflectionCharArrayArray6197() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid6223() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testIntArray6240() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testCharArray6257() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray6266() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid6267() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testChar6313() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray6329() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testReflectionBooleanArray6345() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testConstructorEx36441() { 
     assertEquals("<null>", new ToStringBuilder(null, null, null).toString()); 
     new ToStringBuilder(this.base, null, null).toString(); 
     new ToStringBuilder(this.base, ToStringStyle.DEFAULT_STYLE, null).toString(); 
 } 
@Test 
 public void testReflectionCharArrayArray6446() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testBooleanArray6482() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloat6483() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testChar6507() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testShort6542() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testBoolean6579() { 
     assertEquals(baseStr + "[true]", new ToStringBuilder(base).append(true).toString()); 
     assertEquals(baseStr + "[a=true]", new ToStringBuilder(base).append("a", true).toString()); 
     assertEquals(baseStr + "[a=true,b=false]", new ToStringBuilder(base).append("a", true).append("b", false).toString()); 
 } 
@Test 
 public void testFloatArray6606() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray6612() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid6749() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testSetDefaultEx6801() { 
     ToStringBuilder.setDefaultStyle(null); 
 } 
@Test 
 public void testCharArray6831() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid6910() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testInt7040() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((int) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (int) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (int) 3).append("b", (int) 4).toString()); 
 } 
@Test 
 public void testIntArray7119() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid7145() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testReflectionDoubleArrayArray7184() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testByteArray7258() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionStatics7260() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test 
 public void testReflectionStatics7275() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid7356() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid7372() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble7390() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testBooleanArray7521() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray7531() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testObjectBuild7542() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).build()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).build()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).build()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).build()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).build()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).build()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).build()); 
 } 
@Test 
 public void testBooleanArray7553() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionHierarchy7567() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testInt7603() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((int) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (int) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (int) 3).append("b", (int) 4).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid7685() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testShort7750() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testBooleanArray7797() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray7858() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testByteArrayArray7902() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloatArray7942() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testDoubleArray7966() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testCharArray8006() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testChar8016() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 } 
@Test 
 public void testAppendSuper8056() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).appendSuper("Integer@8888[]").toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[<null>,a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 } 
@Test 
 public void testByteArray8066() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionNull8082() { 
     assertEquals("<null>", ReflectionToStringBuilder.toString(null)); 
 } 
@Test 
 public void testReflectionBooleanArray8098() { 
     boolean[] array = new boolean[] { true, false, false }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{true,false,false}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testAppendToStringUsingMultiLineStyle8135() { 
     final MultiLineTestObject obj = new MultiLineTestObject(); 
     final ToStringBuilder testBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendToString(obj.toString()); 
     assertEquals(testBuilder.toString().indexOf("testInt=31337"), -1); 
 } 
@Test 
 public void testByteArrayArray8166() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testObjectBuild8174() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).build()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).build()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).build()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).build()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).build()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).build()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).build()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid8183() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testReflectionDoubleArrayArray8189() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid8243() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testReflectionCharArrayArray8291() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testByteArray8293() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionHierarchy8315() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@Test 
 public void testBooleanArray8353() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testReflectionDoubleArrayArray8512() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
@Test 
 public void testAppendToStringUsingMultiLineStyle8518() { 
     final MultiLineTestObject obj = new MultiLineTestObject(); 
     final ToStringBuilder testBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendToString(obj.toString()); 
     assertEquals(testBuilder.toString().indexOf("testInt=31337"), -1); 
 } 
@Test 
 public void testShortArray8528() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testCharArray8583() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloat8590() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid8596() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testBoolean8605() { 
     assertEquals(baseStr + "[true]", new ToStringBuilder(base).append(true).toString()); 
     assertEquals(baseStr + "[a=true]", new ToStringBuilder(base).append("a", true).toString()); 
     assertEquals(baseStr + "[a=true,b=false]", new ToStringBuilder(base).append("a", true).append("b", false).toString()); 
 } 
@Test 
 public void testFloat8631() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testDoubleArray8636() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloat8723() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 } 
@Test 
 public void testReflectionHierarchy8730() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 } 
@Test 
 public void testShort8759() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testByteArray8776() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testAppendToStringUsingMultiLineStyle8802() { 
     final MultiLineTestObject obj = new MultiLineTestObject(); 
     final ToStringBuilder testBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendToString(obj.toString()); 
     assertEquals(testBuilder.toString().indexOf("testInt=31337"), -1); 
 } 
@Test 
 public void testLong8877() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(3L).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", 3L).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", 3L).append("b", 4L).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid8913() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testBooleanArray8946() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid8953() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testIntArray8963() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testObjectBuild8989() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).build()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).build()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).build()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).build()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).build()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).build()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).build()); 
 } 
@Test 
 public void testIntArray9006() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testByteArray9051() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testBoolean9175() { 
     assertEquals(baseStr + "[true]", new ToStringBuilder(base).append(true).toString()); 
     assertEquals(baseStr + "[a=true]", new ToStringBuilder(base).append("a", true).toString()); 
     assertEquals(baseStr + "[a=true,b=false]", new ToStringBuilder(base).append("a", true).append("b", false).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid9233() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testDoubleArray9276() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testByteArray9319() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testBooleanArray9387() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid9407() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testDouble9456() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 } 
@Test 
 public void testBoolean9483() { 
     assertEquals(baseStr + "[true]", new ToStringBuilder(base).append(true).toString()); 
     assertEquals(baseStr + "[a=true]", new ToStringBuilder(base).append("a", true).toString()); 
     assertEquals(baseStr + "[a=true,b=false]", new ToStringBuilder(base).append("a", true).append("b", false).toString()); 
 } 
@Test 
 public void testBooleanArray9505() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testFloatArray9510() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid9511() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 } 
@Test 
 public void testBooleanArray9517() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@Test 
 public void testShort9532() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 } 
@Test 
 public void testReflectionCharArrayArray9567() { 
     char[][] array = new char[][] { { 'A', 'B' }, null, { 'p' } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{A,B},<null>,{p}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 } 
