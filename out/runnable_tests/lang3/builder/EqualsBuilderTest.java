@Test 
 public void testSuper53() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 } 
@Test 
 public void testSuper170() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray175() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArray206() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray250() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiShortArray279() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testShortArray326() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionHierarchyEquals328() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 } 
@Test 
 public void testReflectionEquals401() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 } 
@Test 
 public void testCharArrayHiddenByObject420() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiBooleanArray491() { 
     final boolean[][] array1 = new boolean[2][2]; 
     final boolean[][] array2 = new boolean[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i == 1 || j == 1; 
             array2[i][j] = i == 1 || j == 1; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = false; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
     final boolean[] array3 = new boolean[] { true, true }; 
     assertFalse(new EqualsBuilder().append(array1, array3).isEquals()); 
     assertFalse(new EqualsBuilder().append(array3, array1).isEquals()); 
     assertFalse(new EqualsBuilder().append(array2, array3).isEquals()); 
     assertFalse(new EqualsBuilder().append(array3, array2).isEquals()); 
 } 
@Test 
 public void testByteArray569() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject575() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray619() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray691() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray754() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray780() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCyclicalObjectReferences791() { 
     final TestObjectReference refX1 = new TestObjectReference(1); 
     final TestObjectReference x1 = new TestObjectReference(1); 
     x1.setObjectReference(refX1); 
     refX1.setObjectReference(x1); 
     final TestObjectReference refX2 = new TestObjectReference(1); 
     final TestObjectReference x2 = new TestObjectReference(1); 
     x2.setObjectReference(refX2); 
     refX2.setObjectReference(x2); 
     final TestObjectReference refX3 = new TestObjectReference(2); 
     final TestObjectReference x3 = new TestObjectReference(2); 
     x3.setObjectReference(refX3); 
     refX3.setObjectReference(x3); 
     assertTrue(x1.equals(x2)); 
     assertNull(EqualsBuilder.getRegistry()); 
     assertFalse(x1.equals(x3)); 
     assertNull(EqualsBuilder.getRegistry()); 
     assertFalse(x2.equals(x3)); 
     assertNull(EqualsBuilder.getRegistry()); 
 } 
@Test 
 public void testByteArray847() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray978() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionHierarchyEquals1007() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 } 
@Test 
 public void testShortArray1069() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray1129() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testDoubleArray1171() { 
     double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testObjectArray1205() { 
     TestObject[] obj1 = new TestObject[3]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     obj1[2] = null; 
     TestObject[] obj2 = new TestObject[3]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     obj2[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj2, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(6); 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(5); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = obj1[1]; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testObjectArray1282() { 
     TestObject[] obj1 = new TestObject[3]; 
     obj1[0] = new TestObject(4); 
     obj1[1] = new TestObject(5); 
     obj1[2] = null; 
     TestObject[] obj2 = new TestObject[3]; 
     obj2[0] = new TestObject(4); 
     obj2[1] = new TestObject(5); 
     obj2[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj2, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(6); 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1].setA(5); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = obj1[1]; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[2] = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray1417() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray1509() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testLongArray1590() { 
     long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray1606() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject1612() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArray1645() { 
     char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray1697() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionEquals1777() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 } 
@Test 
 public void testCharArray1791() { 
     char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionEquals1834() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 } 
@Test 
 public void testByteArray1850() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray1882() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject1981() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray1992() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionEquals2024() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 } 
@Test 
 public void testReflectionEquals2062() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 } 
@Test 
 public void testMultiDoubleArray2070() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArrayHiddenByObject2091() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray2118() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject2266() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray2424() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testByteArray2457() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject2621() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiShortArray2631() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testFloatArray2663() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray2668() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject2678() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray2686() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray2801() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray2848() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testShortArray2870() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray2937() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testLongArray2949() { 
     long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray2954() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray3036() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionHierarchyEquals3058() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 } 
@Test 
 public void testBooleanArray3132() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray3234() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionHierarchyEquals3338() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 } 
@Test 
 public void testReset3389() { 
     final EqualsBuilder equalsBuilder = new EqualsBuilder(); 
     assertTrue(equalsBuilder.isEquals()); 
     equalsBuilder.setEquals(false); 
     assertFalse(equalsBuilder.isEquals()); 
     equalsBuilder.reset(); 
     assertTrue(equalsBuilder.isEquals()); 
 } 
@Test 
 public void testShortArray3464() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray3614() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testObjectBuild3629() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o1).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, o2).build()); 
     o2.setA(4); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o2).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, this).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, null).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(null, o2).build()); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append((Object) null, (Object) null).build()); 
 } 
@Test 
 public void testBooleanArray3736() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray3823() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray3854() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReset3865() { 
     final EqualsBuilder equalsBuilder = new EqualsBuilder(); 
     assertTrue(equalsBuilder.isEquals()); 
     equalsBuilder.setEquals(false); 
     assertFalse(equalsBuilder.isEquals()); 
     equalsBuilder.reset(); 
     assertTrue(equalsBuilder.isEquals()); 
 } 
@Test 
 public void testFloatArray3890() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray3894() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray3963() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testShortArray3964() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray4012() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray4133() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testIntArrayHiddenByObject4172() { 
     final int[] array1 = new int[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final int[] array2 = new int[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray4183() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testSuper4224() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 } 
@Test 
 public void testCharArray4231() { 
     char[] obj1 = new char[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     char[] obj2 = new char[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray4347() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray4435() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testDoubleArray4465() { 
     double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray4533() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testShortArray4655() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiShortArray4660() { 
     final short[][] array1 = new short[2][2]; 
     final short[][] array2 = new short[2][2]; 
     for (short i = 0; i < array1.length; ++i) { 
         for (short j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArray4773() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray4775() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray4855() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testDoubleArray4909() { 
     double[] obj1 = new double[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     double[] obj2 = new double[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray5031() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray5085() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray5101() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray5124() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray5128() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArrayHiddenByObject5160() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray5176() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testUnrelatedClasses5285() { 
     final Object[] x = new Object[] { new TestACanEqualB(1) }; 
     final Object[] y = new Object[] { new TestBCanEqualA(1) }; 
     assertTrue(Arrays.equals(x, x)); 
     assertTrue(Arrays.equals(y, y)); 
     assertTrue(Arrays.equals(x, y)); 
     assertTrue(Arrays.equals(y, x)); 
     assertTrue(x[0].equals(x[0])); 
     assertTrue(y[0].equals(y[0])); 
     assertTrue(x[0].equals(y[0])); 
     assertTrue(y[0].equals(x[0])); 
     assertTrue(new EqualsBuilder().append(x, x).isEquals()); 
     assertTrue(new EqualsBuilder().append(y, y).isEquals()); 
     assertTrue(new EqualsBuilder().append(x, y).isEquals()); 
     assertTrue(new EqualsBuilder().append(y, x).isEquals()); 
 } 
@Test 
 public void testByteArray5312() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray5381() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiFloatArray5453() { 
     final float[][] array1 = new float[2][2]; 
     final float[][] array2 = new float[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArray5505() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject5800() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray5914() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray5979() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArray5995() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray6192() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiByteArray6310() { 
     final byte[][] array1 = new byte[2][2]; 
     final byte[][] array2 = new byte[2][2]; 
     for (byte i = 0; i < array1.length; ++i) { 
         for (byte j = 0; j < array1[0].length; j++) { 
             array1[i][j] = i; 
             array2[i][j] = i; 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray6314() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray6479() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray6518() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArray6555() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArrayHiddenByObject6607() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray6644() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray6775() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArray6908() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testLongArray6958() { 
     long[] obj1 = new long[2]; 
     obj1[0] = 5L; 
     obj1[1] = 6L; 
     long[] obj2 = new long[2]; 
     obj2[0] = 5L; 
     obj2[1] = 6L; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testSuper7076() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 } 
@Test 
 public void testBooleanArrayHiddenByObject7079() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray7113() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testSuper7132() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(new EqualsBuilder().appendSuper(true).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o1).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(true).append(o1, o2).isEquals()); 
     assertFalse(new EqualsBuilder().appendSuper(false).append(o1, o2).isEquals()); 
 } 
@Test 
 public void testBooleanArrayHiddenByObject7163() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionEquals7178() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o1)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, o2)); 
     o2.setA(4); 
     assertTrue(EqualsBuilder.reflectionEquals(o1, o2)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, this)); 
     assertTrue(!EqualsBuilder.reflectionEquals(o1, null)); 
     assertTrue(!EqualsBuilder.reflectionEquals(null, o2)); 
     assertTrue(EqualsBuilder.reflectionEquals((Object) null, (Object) null)); 
 } 
@Test 
 public void testCharArrayHiddenByObject7249() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testReflectionHierarchyEquals7254() { 
     testReflectionHierarchyEquals(false); 
     testReflectionHierarchyEquals(true); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), false)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 0, 0, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(1, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 0), true)); 
     assertTrue(!EqualsBuilder.reflectionEquals(new TestTTLeafObject(0, 2, 3, 4), new TestTTLeafObject(1, 2, 3, 4), true)); 
 } 
@Test 
 public void testShortArray7319() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray7327() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject7400() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray7629() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray7681() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testByteArray7861() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject7912() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray7949() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray8051() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testBooleanArray8054() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray8096() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testShortArray8100() { 
     short[] obj1 = new short[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     short[] obj2 = new short[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray8161() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testObjectArrayHiddenByObject8395() { 
     final TestObject[] array1 = new TestObject[2]; 
     array1[0] = new TestObject(4); 
     array1[1] = new TestObject(5); 
     final TestObject[] array2 = new TestObject[2]; 
     array2[0] = new TestObject(4); 
     array2[1] = new TestObject(5); 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1].setA(6); 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testByteArray8436() { 
     byte[] obj1 = new byte[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     byte[] obj2 = new byte[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray8670() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testObjectBuild8846() { 
     final TestObject o1 = new TestObject(4); 
     final TestObject o2 = new TestObject(5); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o1).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, o2).build()); 
     o2.setA(4); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append(o1, o2).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, this).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(o1, null).build()); 
     assertEquals(Boolean.FALSE, new EqualsBuilder().append(null, o2).build()); 
     assertEquals(Boolean.TRUE, new EqualsBuilder().append((Object) null, (Object) null).build()); 
 } 
@Test 
 public void testCharArrayHiddenByObject8934() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArrayHiddenByObject8935() { 
     final boolean[] array1 = new boolean[2]; 
     array1[0] = true; 
     array1[1] = false; 
     final boolean[] array2 = new boolean[2]; 
     array2[0] = true; 
     array2[1] = false; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray9010() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray9087() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testMultiDoubleArray9113() { 
     final double[][] array1 = new double[2][2]; 
     final double[][] array2 = new double[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testFloatArray9120() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testBooleanArray9190() { 
     boolean[] obj1 = new boolean[2]; 
     obj1[0] = true; 
     obj1[1] = false; 
     boolean[] obj2 = new boolean[2]; 
     obj2[0] = true; 
     obj2[1] = false; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = true; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testFloatArray9467() { 
     float[] obj1 = new float[2]; 
     obj1[0] = 5; 
     obj1[1] = 6; 
     float[] obj2 = new float[2]; 
     obj2[0] = 5; 
     obj2[1] = 6; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj2 = null; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
     obj1 = null; 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
@Test 
 public void testMultiLongArray9485() { 
     final long[][] array1 = new long[2][2]; 
     final long[][] array2 = new long[2][2]; 
     for (int i = 0; i < array1.length; ++i) { 
         for (int j = 0; j < array1[0].length; j++) { 
             array1[i][j] = (i + 1) * (j + 1); 
             array2[i][j] = (i + 1) * (j + 1); 
         } 
     } 
     assertTrue(new EqualsBuilder().append(array1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(array1, array2).isEquals()); 
     array1[1][1] = 0; 
     assertTrue(!new EqualsBuilder().append(array1, array2).isEquals()); 
 } 
@Test 
 public void testCharArrayHiddenByObject9561() { 
     final char[] array1 = new char[2]; 
     array1[0] = 5; 
     array1[1] = 6; 
     final char[] array2 = new char[2]; 
     array2[0] = 5; 
     array2[1] = 6; 
     final Object obj1 = array1; 
     final Object obj2 = array2; 
     assertTrue(new EqualsBuilder().append(obj1, obj1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array1).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, obj2).isEquals()); 
     assertTrue(new EqualsBuilder().append(obj1, array2).isEquals()); 
     array1[1] = 7; 
     assertTrue(!new EqualsBuilder().append(obj1, obj2).isEquals()); 
 } 
