@Test 
 public void testPrimitiveValues59() { 
     final MutableDouble mutNum = new MutableDouble(1.7); 
     assertEquals(1.7F, mutNum.floatValue(), 0); 
     assertEquals(1.7, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testNanInfinite126() { 
     MutableDouble mutNum = new MutableDouble(Double.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableDouble(Double.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableDouble(Double.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testSetNull202() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     mutNum.setValue(null); 
 } 
@Test 
 public void testEquals995() { 
     final MutableDouble mutNumA = new MutableDouble(0d); 
     final MutableDouble mutNumB = new MutableDouble(0d); 
     final MutableDouble mutNumC = new MutableDouble(1d); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Double.valueOf(0d))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull1008() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     mutNum.compareTo(null); 
 } 
@Test 
 public void testGetSet1017() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(0), new MutableDouble().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(1d), mutNum.getValue()); 
     mutNum.setValue(Double.valueOf(2d)); 
     assertEquals(2d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(2d), mutNum.getValue()); 
     mutNum.setValue(new MutableDouble(3d)); 
     assertEquals(3d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(3d), mutNum.getValue()); 
 } 
@Test 
 public void testPrimitiveValues1735() { 
     final MutableDouble mutNum = new MutableDouble(1.7); 
     assertEquals(1.7F, mutNum.floatValue(), 0); 
     assertEquals(1.7, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testNanInfinite1838() { 
     MutableDouble mutNum = new MutableDouble(Double.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableDouble(Double.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableDouble(Double.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test 
 public void testToString2714() { 
     assertEquals("0.0", new MutableDouble(0d).toString()); 
     assertEquals("10.0", new MutableDouble(10d).toString()); 
     assertEquals("-123.0", new MutableDouble(-123d).toString()); 
 } 
@Test 
 public void testDecrement2873() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testToString3053() { 
     assertEquals("0.0", new MutableDouble(0d).toString()); 
     assertEquals("10.0", new MutableDouble(10d).toString()); 
     assertEquals("-123.0", new MutableDouble(-123d).toString()); 
 } 
@Test 
 public void testGetSet3073() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(0), new MutableDouble().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(1d), mutNum.getValue()); 
     mutNum.setValue(Double.valueOf(2d)); 
     assertEquals(2d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(2d), mutNum.getValue()); 
     mutNum.setValue(new MutableDouble(3d)); 
     assertEquals(3d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(3d), mutNum.getValue()); 
 } 
@Test 
 public void testToDouble3168() { 
     assertEquals(Double.valueOf(0d), new MutableDouble(0d).toDouble()); 
     assertEquals(Double.valueOf(12.3d), new MutableDouble(12.3d).toDouble()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull3271() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     mutNum.compareTo(null); 
 } 
@Test 
 public void testPrimitiveValues4232() { 
     final MutableDouble mutNum = new MutableDouble(1.7); 
     assertEquals(1.7F, mutNum.floatValue(), 0); 
     assertEquals(1.7, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testAddValuePrimitive4563() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.add(1.1d); 
     assertEquals(2.1d, mutNum.doubleValue(), 0.01d); 
 } 
@Test 
 public void testHashCode5007() { 
     final MutableDouble mutNumA = new MutableDouble(0d); 
     final MutableDouble mutNumB = new MutableDouble(0d); 
     final MutableDouble mutNumC = new MutableDouble(1d); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Double.valueOf(0d).hashCode()); 
 } 
@Test 
 public void testHashCode5168() { 
     final MutableDouble mutNumA = new MutableDouble(0d); 
     final MutableDouble mutNumB = new MutableDouble(0d); 
     final MutableDouble mutNumC = new MutableDouble(1d); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Double.valueOf(0d).hashCode()); 
 } 
@Test 
 public void testPrimitiveValues5231() { 
     final MutableDouble mutNum = new MutableDouble(1.7); 
     assertEquals(1.7F, mutNum.floatValue(), 0); 
     assertEquals(1.7, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testGetSet5552() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(0), new MutableDouble().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(1d), mutNum.getValue()); 
     mutNum.setValue(Double.valueOf(2d)); 
     assertEquals(2d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(2d), mutNum.getValue()); 
     mutNum.setValue(new MutableDouble(3d)); 
     assertEquals(3d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(3d), mutNum.getValue()); 
 } 
@Test 
 public void testCompareTo5621() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0, mutNum.compareTo(new MutableDouble(0d))); 
     assertEquals(+1, mutNum.compareTo(new MutableDouble(-1d))); 
     assertEquals(-1, mutNum.compareTo(new MutableDouble(1d))); 
 } 
@Test 
 public void testDecrement6057() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testSubtractValuePrimitive6453() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(0.9d); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 } 
@Test 
 public void testIncrement6489() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testNanInfinite7073() { 
     MutableDouble mutNum = new MutableDouble(Double.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableDouble(Double.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableDouble(Double.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test 
 public void testIncrement7164() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testEquals7526() { 
     final MutableDouble mutNumA = new MutableDouble(0d); 
     final MutableDouble mutNumB = new MutableDouble(0d); 
     final MutableDouble mutNumC = new MutableDouble(1d); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Double.valueOf(0d))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testHashCode7594() { 
     final MutableDouble mutNumA = new MutableDouble(0d); 
     final MutableDouble mutNumB = new MutableDouble(0d); 
     final MutableDouble mutNumC = new MutableDouble(1d); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Double.valueOf(0d).hashCode()); 
 } 
@Test 
 public void testSubtractValueObject7730() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(Double.valueOf(0.9d)); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 } 
@Test 
 public void testPrimitiveValues8302() { 
     final MutableDouble mutNum = new MutableDouble(1.7); 
     assertEquals(1.7F, mutNum.floatValue(), 0); 
     assertEquals(1.7, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testSubtractValueObject8426() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(Double.valueOf(0.9d)); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 } 
@Test(expected = NullPointerException.class) 
 public void testSetNull8480() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     mutNum.setValue(null); 
 } 
@Test 
 public void testNanInfinite8602() { 
     MutableDouble mutNum = new MutableDouble(Double.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableDouble(Double.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableDouble(Double.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test 
 public void testPrimitiveValues8618() { 
     final MutableDouble mutNum = new MutableDouble(1.7); 
     assertEquals(1.7F, mutNum.floatValue(), 0); 
     assertEquals(1.7, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testGetSet8736() { 
     final MutableDouble mutNum = new MutableDouble(0d); 
     assertEquals(0d, new MutableDouble().doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(0), new MutableDouble().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(1d), mutNum.getValue()); 
     mutNum.setValue(Double.valueOf(2d)); 
     assertEquals(2d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(2d), mutNum.getValue()); 
     mutNum.setValue(new MutableDouble(3d)); 
     assertEquals(3d, mutNum.doubleValue(), 0.0001d); 
     assertEquals(Double.valueOf(3d), mutNum.getValue()); 
 } 
@Test 
 public void testAddValuePrimitive8938() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.add(1.1d); 
     assertEquals(2.1d, mutNum.doubleValue(), 0.01d); 
 } 
@Test 
 public void testToDouble9331() { 
     assertEquals(Double.valueOf(0d), new MutableDouble(0d).toDouble()); 
     assertEquals(Double.valueOf(12.3d), new MutableDouble(12.3d).toDouble()); 
 } 
@Test 
 public void testSubtractValuePrimitive9404() { 
     final MutableDouble mutNum = new MutableDouble(1); 
     mutNum.subtract(0.9d); 
     assertEquals(0.1d, mutNum.doubleValue(), 0.01d); 
 } 
