@Test 
 public void testAddValueObject141() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.add(Float.valueOf(1.1f)); 
     assertEquals(2.1f, mutNum.floatValue(), 0.01f); 
 } 
@Test 
 public void testSubtractValuePrimitive258() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.subtract(0.9f); 
     assertEquals(0.1f, mutNum.floatValue(), 0.01f); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull521() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     mutNum.compareTo(null); 
 } 
@Test 
 public void testDecrement611() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testHashCode1103() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Float.valueOf(0f).hashCode()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testSetNull1457() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     mutNum.setValue(null); 
 } 
@Test 
 public void testHashCode1473() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Float.valueOf(0f).hashCode()); 
 } 
@Test 
 public void testNanInfinite1531() { 
     MutableFloat mutNum = new MutableFloat(Float.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableFloat(Float.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableFloat(Float.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test 
 public void testPrimitiveValues1583() { 
     final MutableFloat mutNum = new MutableFloat(1.7F); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1.7, mutNum.doubleValue(), 0.00001); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testConstructors1845() { 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(1f, new MutableFloat(1f).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat(Float.valueOf(2f)).floatValue(), 0.0001f); 
     assertEquals(3f, new MutableFloat(new MutableFloat(3f)).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat("2.0").floatValue(), 0.0001f); 
 } 
@Test 
 public void testEquals2381() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Float.valueOf(0f))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testSubtractValueObject2403() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.subtract(Float.valueOf(0.9f)); 
     assertEquals(0.1f, mutNum.floatValue(), 0.01f); 
 } 
@Test 
 public void testToFloat3188() { 
     assertEquals(Float.valueOf(0f), new MutableFloat(0f).toFloat()); 
     assertEquals(Float.valueOf(12.3f), new MutableFloat(12.3f).toFloat()); 
 } 
@Test 
 public void testGetSet3269() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test 
 public void testToString3617() { 
     assertEquals("0.0", new MutableFloat(0f).toString()); 
     assertEquals("10.0", new MutableFloat(10f).toString()); 
     assertEquals("-123.0", new MutableFloat(-123f).toString()); 
 } 
@Test 
 public void testIncrement3626() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testNanInfinite4278() { 
     MutableFloat mutNum = new MutableFloat(Float.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableFloat(Float.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableFloat(Float.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test 
 public void testPrimitiveValues4601() { 
     final MutableFloat mutNum = new MutableFloat(1.7F); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1.7, mutNum.doubleValue(), 0.00001); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testIncrement4730() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testGetSet5001() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull5261() { 
     new MutableFloat((Number) null); 
 } 
@Test 
 public void testHashCode5318() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Float.valueOf(0f).hashCode()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull5721() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     mutNum.compareTo(null); 
 } 
@Test 
 public void testDecrement5860() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testSubtractValueObject5986() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.subtract(Float.valueOf(0.9f)); 
     assertEquals(0.1f, mutNum.floatValue(), 0.01f); 
 } 
@Test 
 public void testDecrement6015() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testHashCode6167() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Float.valueOf(0f).hashCode()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testSetNull6206() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     mutNum.setValue(null); 
 } 
@Test 
 public void testGetSet6430() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test 
 public void testGetSet6739() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test 
 public void testConstructors6787() { 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(1f, new MutableFloat(1f).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat(Float.valueOf(2f)).floatValue(), 0.0001f); 
     assertEquals(3f, new MutableFloat(new MutableFloat(3f)).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat("2.0").floatValue(), 0.0001f); 
 } 
@Test 
 public void testSubtractValuePrimitive6836() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.subtract(0.9f); 
     assertEquals(0.1f, mutNum.floatValue(), 0.01f); 
 } 
@Test 
 public void testNanInfinite6842() { 
     MutableFloat mutNum = new MutableFloat(Float.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableFloat(Float.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableFloat(Float.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull6963() { 
     new MutableFloat((Number) null); 
 } 
@Test 
 public void testHashCode7034() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Float.valueOf(0f).hashCode()); 
 } 
@Test 
 public void testAddValueObject7231() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.add(Float.valueOf(1.1f)); 
     assertEquals(2.1f, mutNum.floatValue(), 0.01f); 
 } 
@Test 
 public void testCompareTo7389() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0, mutNum.compareTo(new MutableFloat(0f))); 
     assertEquals(+1, mutNum.compareTo(new MutableFloat(-1f))); 
     assertEquals(-1, mutNum.compareTo(new MutableFloat(1f))); 
 } 
@Test 
 public void testGetSet7524() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test 
 public void testGetSet7796() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test 
 public void testEquals7821() { 
     final MutableFloat mutNumA = new MutableFloat(0f); 
     final MutableFloat mutNumB = new MutableFloat(0f); 
     final MutableFloat mutNumC = new MutableFloat(1f); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Float.valueOf(0f))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testDecrement8254() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testToString8733() { 
     assertEquals("0.0", new MutableFloat(0f).toString()); 
     assertEquals("10.0", new MutableFloat(10f).toString()); 
     assertEquals("-123.0", new MutableFloat(-123f).toString()); 
 } 
@Test 
 public void testDecrement8821() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testToFloat8904() { 
     assertEquals(Float.valueOf(0f), new MutableFloat(0f).toFloat()); 
     assertEquals(Float.valueOf(12.3f), new MutableFloat(12.3f).toFloat()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull8964() { 
     new MutableFloat((Number) null); 
 } 
@Test 
 public void testConstructors9080() { 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(1f, new MutableFloat(1f).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat(Float.valueOf(2f)).floatValue(), 0.0001f); 
     assertEquals(3f, new MutableFloat(new MutableFloat(3f)).floatValue(), 0.0001f); 
     assertEquals(2f, new MutableFloat("2.0").floatValue(), 0.0001f); 
 } 
@Test 
 public void testGetSet9105() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test 
 public void testDecrement9250() { 
     final MutableFloat mutNum = new MutableFloat(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testGetSet9370() { 
     final MutableFloat mutNum = new MutableFloat(0f); 
     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(1f), mutNum.getValue()); 
     mutNum.setValue(Float.valueOf(2f)); 
     assertEquals(2f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(2f), mutNum.getValue()); 
     mutNum.setValue(new MutableFloat(3f)); 
     assertEquals(3f, mutNum.floatValue(), 0.0001f); 
     assertEquals(Float.valueOf(3f), mutNum.getValue()); 
 } 
@Test 
 public void testNanInfinite9455() { 
     MutableFloat mutNum = new MutableFloat(Float.NaN); 
     assertTrue(mutNum.isNaN()); 
     mutNum = new MutableFloat(Float.POSITIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
     mutNum = new MutableFloat(Float.NEGATIVE_INFINITY); 
     assertTrue(mutNum.isInfinite()); 
 } 
@Test 
     public void testAddValuePrimitive9640() { 
         final MutableFloat mutNum = new MutableFloat(1); 
         mutNum.add(1); 
          
         assertEquals(2.0f, mutNum.floatValue(), 0.01f); 
     } 
  

@Test 
     public void testAddValuePrimitive11604() { 
         final MutableFloat mutNum = new MutableFloat(1); 
         mutNum.add(1); 
          
         assertEquals(2.0f, mutNum.floatValue(), 0.01f); 
     } 
  

