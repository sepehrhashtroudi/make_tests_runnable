@Test 
 public void testReflectionCompare1() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testFloatArray58() { 
     final float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final float[] obj3 = new float[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((float[]) null, (float[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test(expected = NullPointerException.class) 
 public void testReflectionCompareEx186() { 
     final TestObject o1 = new TestObject(4); 
     CompareToBuilder.reflectionCompare(o1, null); 
 } 
@Test 
 public void testMultiFloatArray268() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator272() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testFloat481() { 
     final float o1 = 1; 
     final float o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.MIN_VALUE, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.NaN).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.POSITIVE_INFINITY, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.NEGATIVE_INFINITY, Float.MIN_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.NaN).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(-0.0, 0.0).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(0.0, -0.0).toComparison() > 0); 
 } 
@Test 
 public void testBooleanArray540() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray602() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray636() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testInt644() { 
     final int o1 = 1; 
     final int o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Integer.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Integer.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray672() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testFloatArray726() { 
     final float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final float[] obj3 = new float[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((float[]) null, (float[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx2755() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testObjectArrayHiddenByObject759() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray853() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare910() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testMultiDoubleArray1003() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testObjectBuild1070() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append(o1, o1).build()); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append(o1, o2).build()); 
     o2.setA(5); 
     assertTrue(new CompareToBuilder().append(o1, o2).build().intValue() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).build().intValue() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).build().intValue() > 0); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append((Object) null, (Object) null).build()); 
     assertTrue(new CompareToBuilder().append(null, o1).build().intValue() < 0); 
 } 
@Test 
 public void testBooleanArray1217() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testAppendSuper1229() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o2).toComparison() > 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx21232() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testBoolean1240() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray1287() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray1379() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiBooleanArray1380() { 
     final boolean[][] array1 = new boolean[2][2]; 
     final boolean[][] array2 = new boolean[2][2]; 
     final boolean[][] array3 = new boolean[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i == 1 ^ j == 1; 
             array2[i][j] = i == 1 ^ j == 1; 
             array3[i][j] = i == 1 ^ j == 1; 
         } 
     } 
     array3[1][2] = false; 
     array3[1][2] = false; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = true; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare1407() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testByteArray1413() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray1425() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray1441() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testAppendSuper1463() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o2).toComparison() > 0); 
 } 
@Test 
 public void testAppendSuper1474() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o2).toComparison() > 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject1494() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject1526() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray1615() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx21699() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testBooleanArray1898() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testInt1919() { 
     final int o1 = 1; 
     final int o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Integer.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Integer.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray1936() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray1977() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray1985() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray2151() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray2201() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray2247() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray2354() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testDoubleArray2395() { 
     final double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final double[] obj3 = new double[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((double[]) null, (double[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator2407() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray2419() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray2436() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testDoubleArray2456() { 
     final double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final double[] obj3 = new double[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((double[]) null, (double[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray2468() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray2534() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray2587() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testLongArray2596() { 
     final long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     final long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     final long[] obj3 = new long[3]; 
     obj3[0] = 5L; 
     obj3[1] = 6L; 
     obj3[2] = 7L; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((long[]) null, (long[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testShort2711() { 
     final short o1 = 1; 
     final short o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Short.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Short.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray2780() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArrayHiddenByObject2821() { 
     final byte[] array1 = new byte[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final byte[] array2 = new byte[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final byte[] array3 = new byte[3]; 
     array3[0] = 5; 
     array3[1] = 6; 
     array3[2] = 7; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray2834() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray2901() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray2976() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray3017() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray3045() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator3059() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare3085() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testReflectionCompare3105() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testMultiDoubleArray3107() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testFloatArray3237() { 
     final float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final float[] obj3 = new float[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((float[]) null, (float[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray3291() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray3295() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testDoubleArray3344() { 
     final double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final double[] obj3 = new double[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((double[]) null, (double[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionHierarchyCompare3352() { 
     testReflectionHierarchyCompare(false, null); 
 } 
@Test 
 public void testMultiDoubleArray3370() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testIntArray3378() { 
     final int[] obj1 = new int[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final int[] obj2 = new int[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final int[] obj3 = new int[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((int[]) null, (int[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testInt3485() { 
     final int o1 = 1; 
     final int o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Integer.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Integer.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray3593() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray3615() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray3619() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray3773() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray3789() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray3802() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject3889() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testShort3942() { 
     final short o1 = 1; 
     final short o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Short.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Short.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray3971() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray3982() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testBoolean4037() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray4130() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray4131() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare4181() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testBooleanArray4222() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray4254() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare4258() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testLongArray4326() { 
     final long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     final long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     final long[] obj3 = new long[3]; 
     obj3[0] = 5L; 
     obj3[1] = 6L; 
     obj3[2] = 7L; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((long[]) null, (long[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare4341() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testMultiDoubleArray4398() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator4405() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testObjectArray4471() { 
     final TestObject[] obj1 = new TestObject[2]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     final TestObject[] obj2 = new TestObject[2]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     final TestObject[] obj3 = new TestObject[3]; 
     obj3[0] = new TestObject(4); 
     obj3[1] = new TestObject(5); 
     obj3[2] = new TestObject(6); 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray4490() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray4508() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray4557() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testFloat4594() { 
     final float o1 = 1; 
     final float o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.MIN_VALUE, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.NaN).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.POSITIVE_INFINITY, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.NEGATIVE_INFINITY, Float.MIN_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.NaN).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(-0.0, 0.0).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(0.0, -0.0).toComparison() > 0); 
 } 
@Test 
 public void testShort4623() { 
     final short o1 = 1; 
     final short o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Short.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Short.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testAppendSuper4661() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o2).toComparison() > 0); 
 } 
@Test 
 public void testReflectionCompare4728() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testLongArray4742() { 
     final long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     final long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     final long[] obj3 = new long[3]; 
     obj3[0] = 5L; 
     obj3[1] = 6L; 
     obj3[2] = 7L; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((long[]) null, (long[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray4758() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray4768() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray4832() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray4848() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray4852() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArray4907() { 
     final TestObject[] obj1 = new TestObject[2]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     final TestObject[] obj2 = new TestObject[2]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     final TestObject[] obj3 = new TestObject[3]; 
     obj3[0] = new TestObject(4); 
     obj3[1] = new TestObject(5); 
     obj3[2] = new TestObject(6); 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray4943() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare4973() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testCharArray5016() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject5041() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject5081() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray5122() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray5298() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray5452() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare5485() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testReflectionCompare5567() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testCharArray5575() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testIntArray5614() { 
     final int[] obj1 = new int[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final int[] obj2 = new int[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final int[] obj3 = new int[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((int[]) null, (int[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testFloat5618() { 
     final float o1 = 1; 
     final float o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.MIN_VALUE, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.NaN).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.POSITIVE_INFINITY, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.NEGATIVE_INFINITY, Float.MIN_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.NaN).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(-0.0, 0.0).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(0.0, -0.0).toComparison() > 0); 
 } 
@Test 
 public void testMultiFloatArray5631() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx25703() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testByteArray5774() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testIntArray5812() { 
     final int[] obj1 = new int[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final int[] obj2 = new int[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final int[] obj3 = new int[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((int[]) null, (int[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray5888() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testIntArray5898() { 
     final int[] obj1 = new int[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final int[] obj2 = new int[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final int[] obj3 = new int[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((int[]) null, (int[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator5932() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray5933() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray5944() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray6000() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject6090() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator6114() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testObjectArray6118() { 
     final TestObject[] obj1 = new TestObject[2]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     final TestObject[] obj2 = new TestObject[2]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     final TestObject[] obj3 = new TestObject[3]; 
     obj3[0] = new TestObject(4); 
     obj3[1] = new TestObject(5); 
     obj3[2] = new TestObject(6); 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testLongArray6122() { 
     final long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     final long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     final long[] obj3 = new long[3]; 
     obj3[0] = 5L; 
     obj3[1] = 6L; 
     obj3[2] = 7L; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((long[]) null, (long[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject6179() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray6211() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray6236() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray6246() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testFloat6331() { 
     final float o1 = 1; 
     final float o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.MIN_VALUE, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.NaN).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.POSITIVE_INFINITY, Float.MAX_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Float.NEGATIVE_INFINITY, Float.MIN_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o1, Float.NaN).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Float.NaN, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(-0.0, 0.0).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(0.0, -0.0).toComparison() > 0); 
 } 
@Test 
 public void testBooleanArray6346() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionHierarchyCompare6455() { 
     testReflectionHierarchyCompare(false, null); 
 } 
@Test 
 public void testDoubleArray6457() { 
     final double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final double[] obj3 = new double[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((double[]) null, (double[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray6469() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testBoolean6585() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray6597() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testBoolean6628() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray6677() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray6682() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray6694() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionHierarchyCompare6698() { 
     testReflectionHierarchyCompare(false, null); 
 } 
@Test 
 public void testBooleanArray6736() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testIntArray6761() { 
     final int[] obj1 = new int[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final int[] obj2 = new int[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final int[] obj3 = new int[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((int[]) null, (int[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray6792() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testDoubleArray6820() { 
     final double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final double[] obj3 = new double[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((double[]) null, (double[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray6847() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray6853() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray6876() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray6886() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testBoolean6933() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray7030() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray7059() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray7061() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray7089() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArrayHiddenByObject7134() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final TestObject[] array3 = new TestObject[3]; 
     array3[0] = new TestObject(4); 
     array3[1] = new TestObject(5); 
     array3[2] = new TestObject(6); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     final Object obj3 = array3; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     array1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray7137() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray7141() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray7197() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testLongArray7269() { 
     final long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     final long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     final long[] obj3 = new long[3]; 
     obj3[0] = 5L; 
     obj3[1] = 6L; 
     obj3[2] = 7L; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((long[]) null, (long[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator7434() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testByteArray7664() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray7720() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testFloatArray7724() { 
     final float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final float[] obj3 = new float[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((float[]) null, (float[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx27812() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testMultiDoubleArray7865() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray7869() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare7877() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testBoolean7947() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray7958() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray7987() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx28032() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testMultiIntArray8041() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testInt8108() { 
     final int o1 = 1; 
     final int o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Integer.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Integer.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Integer.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testBoolean8119() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray8160() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare8193() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testByteArray8194() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiShortArray8266() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     final short[][] array3 = new short[2][3]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (short) ((i + 1) * (j + 1)); 
             array2[i][j] = (short) ((i + 1) * (j + 1)); 
             array3[i][j] = (short) ((i + 1) * (j + 1)); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray8360() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiIntArray8375() { 
     final int[][] array1 = new int[2][2]; 
     final int[][] array2 = new int[2][2]; 
     final int[][] array3 = new int[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 200; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testFloatArray8386() { 
     final float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final float[] obj3 = new float[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((float[]) null, (float[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectArray8501() { 
     final TestObject[] obj1 = new TestObject[2]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     final TestObject[] obj2 = new TestObject[2]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     final TestObject[] obj3 = new TestObject[3]; 
     obj3[0] = new TestObject(4); 
     obj3[1] = new TestObject(5); 
     obj3[2] = new TestObject(6); 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = new TestObject(7); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray8542() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testBooleanArray8543() { 
     final boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     final boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     final boolean[] obj3 = new boolean[3]; 
     obj3[0] = true; 
     obj3[1] = false; 
     obj3[2] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = true; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((boolean[]) null, (boolean[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testReflectionCompare8814() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o1) == 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) == 0); 
     o2.setA(5); 
     assertTrue(CompareToBuilder.reflectionCompare(o1, o2) < 0); 
     assertTrue(CompareToBuilder.reflectionCompare(o2, o1) > 0); 
 } 
@Test 
 public void testByteArray8857() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testObjectBuild8959() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(4); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append(o1, o1).build()); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append(o1, o2).build()); 
     o2.setA(5); 
     assertTrue(new CompareToBuilder().append(o1, o2).build().intValue() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).build().intValue() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null).build().intValue() > 0); 
     assertEquals(Integer.valueOf(0), new CompareToBuilder().append((Object) null, (Object) null).build()); 
     assertTrue(new CompareToBuilder().append(null, o1).build().intValue() < 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx29012() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testByteArray9118() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testShort9178() { 
     final short o1 = 1; 
     final short o2 = 2; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MAX_VALUE).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(Short.MAX_VALUE, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, Short.MIN_VALUE).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(Short.MIN_VALUE, o1).toComparison() < 0); 
 } 
@Test 
 public void testMultiDoubleArray9220() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     final double[][] array3 = new double[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testBoolean9340() { 
     final boolean o1 = true; 
     final boolean o2 = false; 
     assertTrue(new CompareToBuilder().append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o2, o1).toComparison() < 0); 
 } 
@Test 
 public void testObjectComparator9345() { 
     final String o1 = "Fred"; 
     String o2 = "Fred"; 
     assertTrue(new CompareToBuilder().append(o1, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FRED"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     o2 = "FREDA"; 
     assertTrue(new CompareToBuilder().append(o1, o2, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(o2, o1, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(o1, null, String.CASE_INSENSITIVE_ORDER).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((Object) null, (Object) null, String.CASE_INSENSITIVE_ORDER).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, o1, String.CASE_INSENSITIVE_ORDER).toComparison() < 0); 
 } 
@Test 
 public void testMultiFloatArray9412() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     final float[][] array3 = new float[2][3]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
             array3[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     array3[1][2] = 100; 
     array3[1][2] = 100; 
     assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
     array1[1][1] = 127; 
     assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
 } 
@Test 
 public void testByteArray9441() { 
     final byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final byte[] obj3 = new byte[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((byte[]) null, (byte[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testCharArray9447() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
 public void testAppendSuper9481() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(0).append(o2, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(-1).append(o1, o2).toComparison() < 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o1).toComparison() > 0); 
     assertTrue(new CompareToBuilder().appendSuper(1).append(o1, o2).toComparison() > 0); 
 } 
@Test(expected = ClassCastException.class) 
 public void testReflectionCompareEx29518() { 
     final TestObject o1 = new TestObject(4); 
     final Object o2 = new Object(); 
     CompareToBuilder.reflectionCompare(o1, o2); 
 } 
@Test 
 public void testCharArray9521() { 
     final char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     final char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     final char[] obj3 = new char[3]; 
     obj3[0] = 5; 
     obj3[1] = 6; 
     obj3[2] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
     obj1[1] = 7; 
     assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
     assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
     assertTrue(new CompareToBuilder().append((char[]) null, (char[]) null).toComparison() == 0); 
     assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
 } 
@Test 
     public void testMultiShortArray9591() { 
         final short[][] array1 = new short[2][2]; 
         final short[][] array2 = new short[2][2]; 
         final short[][] array3 = new short[2][3]; 
         for (short i = 0; i < array1.length; ++i) { 
             for (short j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (short)((i + 1) * (j + 1)); 
                 array2[i][j] = (short)((i + 1) * (j + 1)); 
                 array3[i][j] = (short)((i + 1) * (j + 1)); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiDoubleArray9682() { 
         final double[][] array1 = new double[2][2]; 
         final double[][] array2 = new double[2][2]; 
         final double[][] array3 = new double[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiShortArray10551() { 
         final short[][] array1 = new short[2][2]; 
         final short[][] array2 = new short[2][2]; 
         final short[][] array3 = new short[2][3]; 
         for (short i = 0; i < array1.length; ++i) { 
             for (short j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (short)((i + 1) * (j + 1)); 
                 array2[i][j] = (short)((i + 1) * (j + 1)); 
                 array3[i][j] = (short)((i + 1) * (j + 1)); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiShortArray10552() { 
         final short[][] array1 = new short[2][2]; 
         final short[][] array2 = new short[2][2]; 
         final short[][] array3 = new short[2][3]; 
         for (short i = 0; i < array1.length; ++i) { 
             for (short j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (short)((i + 1) * (j + 1)); 
                 array2[i][j] = (short)((i + 1) * (j + 1)); 
                 array3[i][j] = (short)((i + 1) * (j + 1)); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiShortArray10553() { 
         final short[][] array1 = new short[2][2]; 
         final short[][] array2 = new short[2][2]; 
         final short[][] array3 = new short[2][3]; 
         for (short i = 0; i < array1.length; ++i) { 
             for (short j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (short)((i + 1) * (j + 1)); 
                 array2[i][j] = (short)((i + 1) * (j + 1)); 
                 array3[i][j] = (short)((i + 1) * (j + 1)); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiShortArray10554() { 
         final short[][] array1 = new short[2][2]; 
         final short[][] array2 = new short[2][2]; 
         final short[][] array3 = new short[2][3]; 
         for (short i = 0; i < array1.length; ++i) { 
             for (short j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (short)((i + 1) * (j + 1)); 
                 array2[i][j] = (short)((i + 1) * (j + 1)); 
                 array3[i][j] = (short)((i + 1) * (j + 1)); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiDoubleArray12482() { 
         final double[][] array1 = new double[2][2]; 
         final double[][] array2 = new double[2][2]; 
         final double[][] array3 = new double[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12483() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12484() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testConstructor12485() { 
         assertNotNull(new CompareToBuilder()); 
         final Constructor<?>[] cons = CompareToBuilder.class.getDeclaredConstructors(); 
         assertEquals(1, cons.length); 
         assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
         assertTrue(Modifier.isPublic(CompareToBuilder.class.getModifiers())); 
         assertFalse(Modifier.isFinal(CompareToBuilder.class.getModifiers())); 
     } 
      

@Test 
     public void testMultiLongArray12486() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testConstructor12487() { 
         assertNotNull(new CompareToBuilder()); 
         final Constructor<?>[] cons = CompareToBuilder.class.getDeclaredConstructors(); 
         assertEquals(1, cons.length); 
         assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
         assertTrue(Modifier.isPublic(CompareToBuilder.class.getModifiers())); 
         assertFalse(Modifier.isFinal(CompareToBuilder.class.getModifiers())); 
     } 
      

@Test 
     public void testMultiLongArray12488() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12489() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12490() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12491() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12492() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12493() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiDoubleArray12494() { 
         final double[][] array1 = new double[2][2]; 
         final double[][] array2 = new double[2][2]; 
         final double[][] array3 = new double[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12495() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12496() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testConstructor12497() { 
         assertNotNull(new CompareToBuilder()); 
         final Constructor<?>[] cons = CompareToBuilder.class.getDeclaredConstructors(); 
         assertEquals(1, cons.length); 
         assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
         assertTrue(Modifier.isPublic(CompareToBuilder.class.getModifiers())); 
         assertFalse(Modifier.isFinal(CompareToBuilder.class.getModifiers())); 
     } 
      

@Test 
     public void testMultiLongArray12498() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12499() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12500() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testToComparison12501() { 
         final TestObject o1 = new TestObject(4); 
         final TestObject o2 = new TestObject(5); 
         assertTrue(new CompareToBuilder().toComparison() == 0); 
         assertTrue(new CompareToBuilder().toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(o1, o1).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
          
         assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object) null, (Object) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, o2).toComparison() < 0); 
          
         assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12502() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12503() { 
         final TestObject[] array1 = new TestObject[2]; 
         array1[0] = new TestObject(4); 
         array1[1] = new TestObject(5); 
         final TestObject[] array2 = new TestObject[2]; 
         array2[0] = new TestObject(4); 
         array2[1] = new TestObject(5); 
         final TestObject[] array3 = new TestObject[3]; 
         array3[0] = new TestObject(4); 
         array3[1] = new TestObject(5); 
         array3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() > 0); 
         array1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(array1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12504() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12505() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12506() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiDoubleArray12507() { 
         final double[][] array1 = new double[2][2]; 
         final double[][] array2 = new double[2][2]; 
         final double[][] array3 = new double[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12508() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12509() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() > 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
     } 
  

@Test 
     public void testToComparison12510() { 
         final TestObject o1 = new TestObject(4); 
         final TestObject o2 = new TestObject(5); 
         assertTrue(new CompareToBuilder().toComparison() == 0); 
         assertTrue(new CompareToBuilder().toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(o1, o1).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
          
         assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object) null, (Object) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, o2).toComparison() < 0); 
          
         assertTrue(new CompareToBuilder().append(o1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(o1, o2).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiDoubleArray12511() { 
         final double[][] array1 = new double[2][2]; 
         final double[][] array2 = new double[2][2]; 
         final double[][] array3 = new double[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12512() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12513() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiDoubleArray12514() { 
         final double[][] array1 = new double[2][2]; 
         final double[][] array2 = new double[2][2]; 
         final double[][] array3 = new double[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12515() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12516() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12517() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12518() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testObjectArrayHiddenByObject12519() { 
         final TestObject[] obj1 = new TestObject[2]; 
         obj1[0] = new TestObject(4); 
         obj1[1] = new TestObject(5); 
         final TestObject[] obj2 = new TestObject[2]; 
         obj2[0] = new TestObject(4); 
         obj2[1] = new TestObject(5); 
         final TestObject[] obj3 = new TestObject[3]; 
         obj3[0] = new TestObject(4); 
         obj3[1] = new TestObject(5); 
         obj3[2] = new TestObject(6); 
          
         assertTrue(new CompareToBuilder().append(obj1, obj1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(obj1, obj3).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj3, obj1).toComparison() < 0); 
  
         obj1[1] = new TestObject(7); 
         assertTrue(new CompareToBuilder().append(obj1, obj2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(obj2, obj1).toComparison() < 0); 
  
         assertTrue(new CompareToBuilder().append(obj1, null).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append((Object[]) null, (Object[]) null).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(null, obj1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiLongArray12520() { 
         final long[][] array1 = new long[2][2]; 
         final long[][] array2 = new long[2][2]; 
         final long[][] array3 = new long[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

@Test 
     public void testMultiDoubleArray12521() { 
         final double[][] array1 = new double[2][2]; 
         final double[][] array2 = new double[2][2]; 
         final double[][] array3 = new double[2][3]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
                 array3[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         array3[1][2] = 100; 
         array3[1][2] = 100; 
          
         assertTrue(new CompareToBuilder().append(array1, array1).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() == 0); 
         assertTrue(new CompareToBuilder().append(array1, array3).toComparison() < 0); 
         assertTrue(new CompareToBuilder().append(array3, array1).toComparison() > 0); 
         array1[1][1] = 127; 
         assertTrue(new CompareToBuilder().append(array1, array2).toComparison() > 0); 
         assertTrue(new CompareToBuilder().append(array2, array1).toComparison() < 0); 
     } 
  

