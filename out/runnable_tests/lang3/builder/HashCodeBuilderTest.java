@Test 
 public void testDoubleArray9() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject166() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testShort277() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short) 0).toHashCode()); 
     assertEquals(17 * 37 + 12345, new HashCodeBuilder(17, 37).append((short) 12345).toHashCode()); 
 } 
@Test 
 public void testReflectionObjectCycle441() { 
     final ReflectionTestCycleA a = new ReflectionTestCycleA(); 
     final ReflectionTestCycleB b = new ReflectionTestCycleB(); 
     a.b = b; 
     b.a = a; 
     a.hashCode(); 
     assertNull(HashCodeBuilder.getRegistry()); 
     b.hashCode(); 
     assertNull(HashCodeBuilder.getRegistry()); 
 } 
@Test 
 public void testFloatArrayAsObject531() { 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testReflectionHashCodeEx2776() { 
     HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
 } 
@Test 
 public void testFloatArrayAsObject970() { 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testToHashCodeEqualsHashCode986() { 
     final HashCodeBuilder hcb = new HashCodeBuilder(17, 37).append(new Object()).append('a'); 
     assertEquals("hashCode() is no longer returning the same value as toHashCode() - see LANG-520", hcb.toHashCode(), hcb.hashCode()); 
 } 
@Test 
 public void testDoubleArray1082() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testReflectionHashCodeEx31085() { 
     HashCodeBuilder.reflectionHashCode(13, 19, null, true); 
 } 
@Test 
 public void testByteArray1097() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray1452() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testCharArray1934() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((char[]) null).toHashCode()); 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject2089() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray2480() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject2485() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testByte2635() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte) 0).toHashCode()); 
     assertEquals(17 * 37 + 123, new HashCodeBuilder(17, 37).append((byte) 123).toHashCode()); 
 } 
@Test 
 public void testShortArray2966() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short[]) null).toHashCode()); 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testFloatArrayAsObject3358() { 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray3414() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray3566() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray3710() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testShortArray3763() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short[]) null).toHashCode()); 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject3822() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testReflectionHashCodeEx23987() { 
     HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
 } 
@Test 
 public void testObjectBuild4121() { 
     Object obj = null; 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
     obj = new Object(); 
     assertEquals(17 * 37 + obj.hashCode(), new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
 } 
@Test 
 public void testDoubleArray4147() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testByte4217() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte) 0).toHashCode()); 
     assertEquals(17 * 37 + 123, new HashCodeBuilder(17, 37).append((byte) 123).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject4220() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testObjectBuild4535() { 
     Object obj = null; 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
     obj = new Object(); 
     assertEquals(17 * 37 + obj.hashCode(), new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
 } 
@Test 
 public void testCharArrayAsObject4771() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject4784() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 @SuppressWarnings("cast") 
 public void testFloat4794() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((float) 0f).toHashCode()); 
     final float f = 1234.89f; 
     final int i = Float.floatToIntBits(f); 
     assertEquals(17 * 37 + i, new HashCodeBuilder(17, 37).append(f).toHashCode()); 
 } 
@Test 
 public void testDoubleArrayAsObject5151() { 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject5401() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray5601() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testFloatArray5793() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((float[]) null).toHashCode()); 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testObjectArrayAsObject5801() { 
     final Object[] obj = new Object[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37 + obj[1].hashCode(), new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testReflectionHashCodeEx25811() { 
     HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
 } 
@Test 
 public void testByte5816() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte) 0).toHashCode()); 
     assertEquals(17 * 37 + 123, new HashCodeBuilder(17, 37).append((byte) 123).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject5943() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testShortArrayAsObject5962() { 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 @SuppressWarnings("cast") 
 public void testFloat5970() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((float) 0f).toHashCode()); 
     final float f = 1234.89f; 
     final int i = Float.floatToIntBits(f); 
     assertEquals(17 * 37 + i, new HashCodeBuilder(17, 37).append(f).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject6034() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testShortArray6049() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short[]) null).toHashCode()); 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject6066() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject6326() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray6337() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testByteArray6530() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testSuper6624() { 
     final Object obj = new Object(); 
     assertEquals(17 * 37 + 19 * 41 + obj.hashCode(), new HashCodeBuilder(17, 37).appendSuper(new HashCodeBuilder(19, 41).append(obj).toHashCode()).toHashCode()); 
 } 
@Test 
 public void testFloatArrayAsObject6665() { 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 @SuppressWarnings("cast") 
 public void testFloat6674() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((float) 0f).toHashCode()); 
     final float f = 1234.89f; 
     final int i = Float.floatToIntBits(f); 
     assertEquals(17 * 37 + i, new HashCodeBuilder(17, 37).append(f).toHashCode()); 
 } 
@Test 
 public void testObjectArray6872() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((Object[]) null).toHashCode()); 
     final Object[] obj = new Object[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = new Object(); 
     assertEquals((17 * 37 + obj[0].hashCode()) * 37 + obj[1].hashCode(), new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testDoubleArray7078() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
     final double[] obj = new double[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = 5.4d; 
     final long l1 = Double.doubleToLongBits(5.4d); 
     final int h1 = (int) (l1 ^ l1 >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = 6.3d; 
     final long l2 = Double.doubleToLongBits(6.3d); 
     final int h2 = (int) (l2 ^ l2 >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testShortArray7086() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short[]) null).toHashCode()); 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testObjectBuild7144() { 
     Object obj = null; 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
     obj = new Object(); 
     assertEquals(17 * 37 + obj.hashCode(), new HashCodeBuilder(17, 37).append(obj).build().intValue()); 
 } 
@Test 
 public void testByteArrayAsObject7432() { 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testSuper7454() { 
     final Object obj = new Object(); 
     assertEquals(17 * 37 + 19 * 41 + obj.hashCode(), new HashCodeBuilder(17, 37).appendSuper(new HashCodeBuilder(19, 41).append(obj).toHashCode()).toHashCode()); 
 } 
@Test 
 public void testShort7585() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short) 0).toHashCode()); 
     assertEquals(17 * 37 + 12345, new HashCodeBuilder(17, 37).append((short) 12345).toHashCode()); 
 } 
@Test 
 public void testByteArray7600() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testSuper7637() { 
     final Object obj = new Object(); 
     assertEquals(17 * 37 + 19 * 41 + obj.hashCode(), new HashCodeBuilder(17, 37).appendSuper(new HashCodeBuilder(19, 41).append(obj).toHashCode()).toHashCode()); 
 } 
@Test 
 public void testShort7646() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short) 0).toHashCode()); 
     assertEquals(17 * 37 + 12345, new HashCodeBuilder(17, 37).append((short) 12345).toHashCode()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testReflectionHierarchyHashCodeEx17782() { 
     HashCodeBuilder.reflectionHashCode(0, 0, new TestSubObject(0, 0, 0), true); 
 } 
@Test 
 public void testShortArray7805() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short[]) null).toHashCode()); 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testFloatArrayAsObject8078() { 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testBooleanArray8145() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((boolean[]) null).toHashCode()); 
     final boolean[] obj = new boolean[2]; 
     assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = true; 
     assertEquals((17 * 37 + 0) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = false; 
     assertEquals((17 * 37 + 0) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testByteArray8214() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testFloatArrayAsObject8362() { 
     final float[] obj = new float[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5.4f; 
     final int h1 = Float.floatToIntBits(5.4f); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6.3f; 
     final int h2 = Float.floatToIntBits(6.3f); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testByteArray8566() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testCharArrayAsObject8579() { 
     final char[] obj = new char[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = (char) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = (char) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testShortArray8641() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((short[]) null).toHashCode()); 
     final short[] obj = new short[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (short) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (short) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testToHashCodeEqualsHashCode8724() { 
     final HashCodeBuilder hcb = new HashCodeBuilder(17, 37).append(new Object()).append('a'); 
     assertEquals("hashCode() is no longer returning the same value as toHashCode() - see LANG-520", hcb.toHashCode(), hcb.hashCode()); 
 } 
@Test 
 public void testByteArray8860() { 
     assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
     final byte[] obj = new byte[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[0] = (byte) 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     obj[1] = (byte) 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
 } 
@Test 
 public void testLongArrayAsObject9149() { 
     final long[] obj = new long[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5L; 
     final int h1 = (int) (5L ^ 5L >> 32); 
     assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6L; 
     final int h2 = (int) (6L ^ 6L >> 32); 
     assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
 public void testIntArrayAsObject9501() { 
     final int[] obj = new int[2]; 
     assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[0] = 5; 
     assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     obj[1] = 6; 
     assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
 } 
@Test 
     public void testLongArray9605() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((long[]) null).toHashCode()); 
         final long[] obj = new long[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5L; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6L; 
         assertEquals((17 * 37 + 5) * 37 + 6L, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testIntArray9634() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int[]) null).toHashCode()); 
         final int[] obj = new int[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testBooleanArrayAsObject9644() { 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     public void testIsRegistered9666() { 
         assertFalse(HashCodeBuilder.isRegistered(null)); 
         assertTrue(HashCodeBuilder.isRegistered(new Object())); 
         assertFalse(HashCodeBuilder.isRegistered(new String(""))); 
         assertFalse(HashCodeBuilder.isRegistered(new int[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new long[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new short[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new char[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new char[] { 'f', 'o', 'o' })); 
         assertFalse(HashCodeBuilder.isRegistered(new float[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new double[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new float[] { 'f', 'O', 'O' })); 
     } 
  

@Test 
     public void testLongArray11022() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((long[]) null).toHashCode()); 
         final long[] obj = new long[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5L; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6L; 
         assertEquals((17 * 37 + 5) * 37 + 6L, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testLongArray11023() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((long[]) null).toHashCode()); 
         final long[] obj = new long[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5L; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6L; 
         assertEquals((17 * 37 + 5) * 37 + 6L, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testLongArray11024() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((long[]) null).toHashCode()); 
         final long[] obj = new long[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5L; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6L; 
         assertEquals((17 * 37 + 5) * 37 + 6L, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testLongArray11025() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((long[]) null).toHashCode()); 
         final long[] obj = new long[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5L; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6L; 
         assertEquals((17 * 37 + 5) * 37 + 6L, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testLongArray11026() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((long[]) null).toHashCode()); 
         final long[] obj = new long[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5L; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6L; 
         assertEquals((17 * 37 + 5) * 37 + 6L, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testIntArray11532() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int[]) null).toHashCode()); 
         final int[] obj = new int[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testInt11533() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int) 0).toHashCode()); 
         assertEquals(17 * 37 + 123, new HashCodeBuilder(17, 37).append((int) 123).toHashCode()); 
     } 
  

@Test 
     public void testIntArray11534() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int[]) null).toHashCode()); 
         final int[] obj = new int[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testInt11535() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append(0).toHashCode()); 
         assertEquals(17 * 37 + 123, new HashCodeBuilder(17, 37).append(123).toHashCode()); 
     } 
  

@Test 
     public void testIntArray11536() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int[]) null).toHashCode()); 
         final int[] obj = new int[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testInt11537() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int) 0).toHashCode()); 
         assertEquals(17 * 37 + 123, new HashCodeBuilder(17, 37).append((int) 123).toHashCode()); 
     } 
  

@Test 
     public void testIntArray11538() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int[]) null).toHashCode()); 
         final int[] obj = new int[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testIntArray11539() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((int[]) null).toHashCode()); 
         final int[] obj = new int[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     @SuppressWarnings("cast") // cast is not really needed, keep for consistency 
     public void testBoolean11717() { 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testFloatArrayAsObject11718() { 
         final float[] obj = new float[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = 5.4f; 
         final int h1 = Float.floatToIntBits(5.4f); 
         assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = 6.3f; 
         final int h2 = Float.floatToIntBits(6.3f); 
         assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     @SuppressWarnings("cast") // cast is not really needed, keep for consistency 
     public void testBoolean11719() { 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testBooleanArray11720() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((boolean[]) null).toHashCode()); 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testByteArray11721() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((byte[]) null).toHashCode()); 
         final byte[] obj = new byte[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = (byte) 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = (byte) 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testBooleanArray11722() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((boolean[]) null).toHashCode()); 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testDoubleArray11723() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
         final double[] obj = new double[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5.4d; 
         final long l1 = Double.doubleToLongBits(5.4d); 
         final int h1 = (int) (l1 ^ l1 >> 32); 
         assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6.3d; 
         final long l2 = Double.doubleToLongBits(6.3d); 
         final int h2 = (int) (l2 ^ l2 >> 32); 
         assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testDoubleArray11724() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
         final double[] obj = new double[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5.4d; 
         final long l1 = Double.doubleToLongBits(5.4d); 
         final int h1 = (int) (l1 ^ l1 >> 32); 
         assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6.3d; 
         final long l2 = Double.doubleToLongBits(6.3d); 
         final int h2 = (int) (l2 ^ l2 >> 32); 
         assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testDoubleArrayAsObject11725() { 
         final double[] obj = new double[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = 5.4d; 
         final long l1 = Double.doubleToLongBits(5.4d); 
         final int h1 = (int) (l1 ^ l1 >> 32); 
         assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = 6.3d; 
         final long l2 = Double.doubleToLongBits(6.3d); 
         final int h2 = (int) (l2 ^ l2 >> 32); 
         assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     public void testDoubleArray11726() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
         final double[] obj = new double[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5.4d; 
         final long l1 = Double.doubleToLongBits(5.4d); 
         final int h1 = (int) (l1 ^ l1 >> 32); 
         assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6.3d; 
         final long l2 = Double.doubleToLongBits(6.3d); 
         final int h2 = (int) (l2 ^ l2 >> 32); 
         assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testBooleanArrayAsObject11727() { 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     public void testBooleanArray11728() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((boolean[]) null).toHashCode()); 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testBooleanArray11729() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((boolean[]) null).toHashCode()); 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testDoubleArray11730() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
         final double[] obj = new double[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5.4d; 
         final long l1 = Double.doubleToLongBits(5.4d); 
         final int h1 = (int) (l1 ^ l1 >> 32); 
         assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6.3d; 
         final long l2 = Double.doubleToLongBits(6.3d); 
         final int h2 = (int) (l2 ^ l2 >> 32); 
         assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     @SuppressWarnings("cast") // cast is not really needed, keep for consistency 
     public void testBoolean11731() { 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testBooleanArray11732() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((boolean[]) null).toHashCode()); 
         final boolean[] obj = new boolean[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = true; 
         assertEquals((17 * 37 + 1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = false; 
         assertEquals((17 * 37 + 1) * 37 + 1, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test 
     public void testDoubleArray11733() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).append((double[]) null).toHashCode()); 
         final double[] obj = new double[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[0] = 5.4d; 
         final long l1 = Double.doubleToLongBits(5.4d); 
         final int h1 = (int) (l1 ^ l1 >> 32); 
         assertEquals((17 * 37 + h1) * 37, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
         obj[1] = 6.3d; 
         final long l2 = Double.doubleToLongBits(6.3d); 
         final int h2 = (int) (l2 ^ l2 >> 32); 
         assertEquals((17 * 37 + h1) * 37 + h2, new HashCodeBuilder(17, 37).append(obj).toHashCode()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112191() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testCharArrayAsObject12192() { 
         final char[] obj = new char[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = (char) 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = (char) 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     public void testEqualsHashcode12193() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertEquals(key1, key2); 
         assertEquals(key1.hashCode(), key2.hashCode()); 
         assertFalse(key1.equals(null)); 
     } 
  

@Test 
     public void testEquals12194() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertTrue(key1.equals(key1)); 
         assertTrue(key1.equals(new Object())); 
         assertTrue(key2.equals(key2)); 
         assertFalse(key1.equals(null)); 
         assertFalse(key1.equals("Ni!")); 
     } 
  

@Test 
     public void testReflectionAppend12195() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
         final TestObject to14 = new TestObject(17); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to1.hashCode(), to5.hashCode()); 
          
         assertEquals(to1, to1); 
         assertEquals(to1, to2); 
         assertEquals(to1, to3); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to1.hashCode(), to5.hashCode()); 
     } 
  

@Test 
     public void testEquals12196() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertTrue(key1.equals(key1)); 
         assertTrue(key1.equals(new Object())); 
         assertTrue(key2.equals(key2)); 
         assertFalse(key1.equals(null)); 
         assertFalse(key1.equals("abc")); 
     } 
  

@Test 
     public void testEqualsHashcode12197() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertEquals(key1, key2); 
         assertEquals(key1.hashCode(), key2.hashCode()); 
         assertFalse(key1.equals(null)); 
     } 
  

@Test 
     public void testToHashCode12198() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).toHashCode()); 
     } 
  

@Test 
     public void testCharArrayAsObject12199() { 
         final char[] obj = new char[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = (char) 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = (char) 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     public void testReflectionAppend12200() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
         final TestObject to14 = new TestObject(17); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to1.hashCode(), to5.hashCode()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112201() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testIsRegistered12202() { 
         assertFalse(HashCodeBuilder.isRegistered(null)); 
         assertTrue(HashCodeBuilder.isRegistered(new Object())); 
         assertFalse(HashCodeBuilder.isRegistered(new String(""))); 
         assertFalse(HashCodeBuilder.isRegistered(new int[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new long[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new short[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new char[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new char[] { 'f', 'o', 'o' })); 
         assertFalse(HashCodeBuilder.isRegistered(new float[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new double[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new double[] { 'f', 'O', 'O' })); 
     } 
  

@Test 
     public void testEqualsHashcode12203() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertEquals(key1, key2); 
         assertEquals(key1.hashCode(), key2.hashCode()); 
         assertFalse(key1.equals(null)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112204() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212205() { 
         HashCodeBuilder.reflectionHashCode(2, 2, null, true); 
     } 
  

@Test 
     public void testIntegerWithTransients12206() { 
         assertEquals(17 * 37, HashCodeBuilder.getRegistry().size()); 
         final int[] obj = new int[2]; 
         assertEquals(17 * 37, HashCodeBuilder.getRegistry().add(new IDKey(17, 37))); 
         assertEquals(17 * 37, HashCodeBuilder.getRegistry().add(new IDKey(17, 37 + 1))); 
         assertEquals(17 * 37 + 1, HashCodeBuilder.getRegistry().add(new IDKey(17, 37 + 2))); 
         obj[0] = (byte) 5; 
         assertEquals((byte) 5, HashCodeBuilder.getRegistry().add(new IDKey(17, 37 + 1))); 
         assertEquals((byte) 6, HashCodeBuilder.getRegistry().add(new IDKey(17, 37 + 2))); 
         obj[1] = (byte) 6; 
         assertEquals((byte) 6, HashCodeBuilder.getRegistry().add(new IDKey(17, 37 + 3))); 
     } 
  

@Test 
     public void testReflectionAppend12207() { 
         final TestObject to1 = new TestObject(5); 
         final TestObject to2 = new TestObject(6); 
         final TestObject to3 = new TestObject(7); 
         final TestObject to4 = new TestObject(8); 
         final TestObject to5 = new TestObject(9); 
         final TestObject to6 = new TestObject(10); 
         final TestObject to7 = new TestObject(11); 
         final TestObject to8 = new TestObject(12); 
         final TestObject to9 = new TestObject(13); 
         final TestObject to10 = new TestObject(14); 
         final TestObject to11 = new TestObject(15); 
         final TestObject to12 = new TestObject(16); 
         final TestObject to13 = new TestObject(17); 
         final TestObject to14 = new TestObject(15); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to1.hashCode(), to5.hashCode()); 
     } 
  

@Test 
     public void testUnregister12208() { 
         final Object obj = new Object(); 
         assertEquals(17 * 37, HashCodeBuilder.getRegistry().size()); 
         HashCodeBuilder.unregister(obj); 
         assertEquals(0, HashCodeBuilder.getRegistry().size()); 
     } 
  

@Test 
     public void testIntegerWithTransients12209() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test 
     public void testReflectionAppend12210() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212211() { 
         HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212212() { 
         HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
     } 
  

@Test 
     public void testSetRegistry12213() { 
         final Set<IDKey> registry = HashCodeBuilder.getRegistry(); 
         assertEquals(17 * 37, registry.size()); 
         assertTrue(registry.contains(new IDKey(17 * 37))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 1))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 2))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 3))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 4))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 5))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 6))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 7))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 8))); 
         assertTrue(registry.contains(new IDKey(17 * 37 + 9))); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212214() { 
         HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
     } 
  

@Test 
     public void testIntegerWithTransients12215() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test 
     public void testIntegerWithTransients12216() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112217() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testIntegerWithTransients12218() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test 
     public void testCharArrayAsObject12219() { 
         final char[] obj = new char[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = (char) 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = (char) 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212220() { 
         HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
     } 
  

@Test 
     public void testReflectionAppend12221() { 
         final TestObject to1 = new TestObject(5); 
         final TestObject to2 = new TestObject(6); 
         final TestObject to3 = new TestObject(7); 
         final TestObject to4 = new TestObject(8); 
         final TestObject to5 = new TestObject(9); 
         final TestObject to6 = new TestObject(10); 
         final TestObject to7 = new TestObject(11); 
         final TestObject to8 = new TestObject(12); 
         final TestObject to9 = new TestObject(13); 
         final TestObject to10 = new TestObject(14); 
         final TestObject to11 = new TestObject(15); 
         final TestObject to12 = new TestObject(16); 
         final TestObject to13 = new TestObject(17); 
         final TestObject to14 = new TestObject(15); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to1.hashCode(), to5.hashCode()); 
     } 
  

@Test 
     public void testCharArrayAsObject12222() { 
         final char[] obj = new char[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = (char) 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = (char) 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     public void testUnregister12223() { 
         final Object obj = new Object(); 
         assertEquals(17 * 37, HashCodeBuilder.getRegistry().size()); 
         HashCodeBuilder.unregister(obj); 
         assertEquals(0, HashCodeBuilder.getRegistry().size()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112224() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testUnregister12225() { 
         final Object obj = new Object(); 
         assertEquals(17 * 37, HashCodeBuilder.getRegistry().size()); 
         HashCodeBuilder.unregister(obj); 
         assertEquals(0, HashCodeBuilder.getRegistry().size()); 
     } 
  

@Test 
     public void testEquals12226() { 
         final IDKey k1 = new IDKey(VALUE); 
         final IDKey k2 = new IDKey(VALUE); 
         assertTrue(k1.equals(k1)); 
         assertTrue(k1.equals(k2)); 
         assertTrue(k2.equals(k2)); 
         assertFalse(k1.equals(null)); 
     } 
  

@Test 
     public void testReflectionAppend12227() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test 
     public void testEqualsHashcode12228() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertEquals(key1, key2); 
         assertEquals(key1.hashCode(), key2.hashCode()); 
         assertFalse(key1.equals(null)); 
     } 
  

@Test 
     public void testCharArrayAsObject12229() { 
         final char[] obj = new char[2]; 
         assertEquals(17 * 37 * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[0] = (char) 5; 
         assertEquals((17 * 37 + 5) * 37, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
         obj[1] = (char) 6; 
         assertEquals((17 * 37 + 5) * 37 + 6, new HashCodeBuilder(17, 37).append((Object) obj).toHashCode()); 
     } 
  

@Test 
     public void testReflectionAppend12230() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212231() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testIntegerWithTransients12232() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test 
     public void testEquals12233() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertTrue(key1.equals(key1)); 
         assertTrue(key1.equals(new Object())); 
         assertTrue(key2.equals(key2)); 
         assertFalse(key1.equals(null)); 
         assertFalse(key1.equals("Ni!")); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212234() { 
         HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112235() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112236() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testReflectionAppend12237() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test 
     public void testIsRegistered12238() { 
         assertFalse(HashCodeBuilder.isRegistered(null)); 
         assertTrue(HashCodeBuilder.isRegistered(new Object())); 
         assertFalse(HashCodeBuilder.isRegistered(new String(""))); 
         assertFalse(HashCodeBuilder.isRegistered(new int[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new long[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new short[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new char[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new char[] { 'f', 'o', 'o' })); 
         assertFalse(HashCodeBuilder.isRegistered(new float[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new double[0])); 
         assertFalse(HashCodeBuilder.isRegistered(new float[] { 'f', 'O', 'O' })); 
     } 
  

@Test 
     public void testReflectionAppend12239() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test 
     public void testReflectionAppend12240() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx212241() { 
         HashCodeBuilder.reflectionHashCode(2, 2, new TestObject(0), true); 
     } 
  

@Test 
     public void testEqualsHashcode12242() { 
         final IDKey key1 = new IDKey(new Object()); 
         final IDKey key2 = new IDKey(new Object()); 
         assertTrue(key1.equals(key1)); 
         assertTrue(key1.equals(new Object())); 
         assertTrue(key2.equals(key2)); 
         assertEquals(key1.hashCode(), key2.hashCode()); 
     } 
  

@Test 
     public void testIntegerWithTransients12243() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112244() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testIntegerWithTransients12245() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test 
     public void testToHashCode12246() { 
         assertEquals(17 * 37, new HashCodeBuilder(17, 37).toHashCode()); 
     } 
  

@Test 
     public void testIntegerWithTransients12247() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test 
     public void testIntegerWithTransients12248() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test 
     public void testReflectionAppend12249() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112250() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112251() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112252() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

@Test 
     public void testEquals12253() { 
         final IDKey key1 = new IDKey(VALUE); 
         final IDKey key2 = new IDKey(VALUE); 
         assertTrue(key1.equals(key1)); 
         assertTrue(key1.equals(new Object())); 
         assertTrue(key2.equals(key2)); 
         assertFalse(key1.equals(null)); 
         assertFalse(key1.equals("Ni!")); 
     } 
  

@Test 
     public void testReflectionAppend12254() { 
         final TestObject to1 = new TestObject(4); 
         final TestObject to2 = new TestObject(5); 
         final TestObject to3 = new TestObject(6); 
         final TestObject to4 = new TestObject(7); 
         final TestObject to5 = new TestObject(8); 
         final TestObject to6 = new TestObject(9); 
         final TestObject to7 = new TestObject(10); 
         final TestObject to8 = new TestObject(11); 
         final TestObject to9 = new TestObject(12); 
         final TestObject to10 = new TestObject(13); 
         final TestObject to11 = new TestObject(14); 
         final TestObject to12 = new TestObject(15); 
         final TestObject to13 = new TestObject(16); 
          
         assertEquals(to1.hashCode(), to1.hashCode()); 
         assertEquals(to1.hashCode(), to2.hashCode()); 
         assertEquals(to1.hashCode(), to3.hashCode()); 
         assertEquals(to1.hashCode(), to4.hashCode()); 
         assertEquals(to4.hashCode(), to5.hashCode()); 
     } 
  

@Test 
     public void testIntegerWithTransients12255() { 
         final int[][] array1 = new int[2][2]; 
         final int[][] array2 = new int[2][2]; 
         for (int i = 0; i < array1.length; ++i) { 
             for (int j = 0; j < array1[0].length; j++) { 
                 array1[i][j] = (i + 1) * (j + 1); 
                 array2[i][j] = (i + 1) * (j + 1); 
             } 
         } 
         assertEquals(17 * 37 * 37, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array1, true)); 
         assertEquals(17 * 37 + 19, HashCodeBuilder.reflectionHashCode(17, 37, array2, true)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void testReflectionHashCodeEx112256() { 
         HashCodeBuilder.reflectionHashCode(17, 37, null, true); 
     } 
  

