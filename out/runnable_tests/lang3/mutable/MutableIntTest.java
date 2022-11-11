@Test 
 public void testGetSet181() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(Integer.valueOf(0), new MutableInt().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(Integer.valueOf(1), mutNum.getValue()); 
     mutNum.setValue(Integer.valueOf(2)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(Integer.valueOf(2), mutNum.getValue()); 
     mutNum.setValue(new MutableLong(3)); 
     assertEquals(3, mutNum.intValue()); 
     assertEquals(Integer.valueOf(3), mutNum.getValue()); 
 } 
@Test 
 public void testPrimitiveValues261() { 
     final MutableInt mutNum = new MutableInt(1); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testIncrement341() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testSetNull344() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.setValue(null); 
 } 
@Test 
 public void testPrimitiveValues432() { 
     final MutableInt mutNum = new MutableInt(1); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testGetSet628() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(Integer.valueOf(0), new MutableInt().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(Integer.valueOf(1), mutNum.getValue()); 
     mutNum.setValue(Integer.valueOf(2)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(Integer.valueOf(2), mutNum.getValue()); 
     mutNum.setValue(new MutableLong(3)); 
     assertEquals(3, mutNum.intValue()); 
     assertEquals(Integer.valueOf(3), mutNum.getValue()); 
 } 
@Test 
 public void testToString766() { 
     assertEquals("0", new MutableInt(0).toString()); 
     assertEquals("10", new MutableInt(10).toString()); 
     assertEquals("-123", new MutableInt(-123).toString()); 
 } 
@Test 
 public void testDecrement1001() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testDecrement1053() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testDecrement1107() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testSubtractValueObject1248() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.subtract(Integer.valueOf(1)); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testToInteger1372() { 
     assertEquals(Integer.valueOf(0), new MutableInt(0).toInteger()); 
     assertEquals(Integer.valueOf(123), new MutableInt(123).toInteger()); 
 } 
@Test 
 public void testAddValueObject1434() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.add(Integer.valueOf(1)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull1696() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.compareTo(null); 
 } 
@Test 
 public void testGetSet1749() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(Integer.valueOf(0), new MutableInt().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(Integer.valueOf(1), mutNum.getValue()); 
     mutNum.setValue(Integer.valueOf(2)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(Integer.valueOf(2), mutNum.getValue()); 
     mutNum.setValue(new MutableLong(3)); 
     assertEquals(3, mutNum.intValue()); 
     assertEquals(Integer.valueOf(3), mutNum.getValue()); 
 } 
@Test 
 public void testIncrement1757() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull1843() { 
     new MutableInt((Number) null); 
 } 
@Test 
 public void testAddValuePrimitive2016() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.add(1); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testDecrement2183() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testToInteger2338() { 
     assertEquals(Integer.valueOf(0), new MutableInt(0).toInteger()); 
     assertEquals(Integer.valueOf(123), new MutableInt(123).toInteger()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull2620() { 
     new MutableInt((Number) null); 
 } 
@Test 
 public void testEquals2657() { 
     this.testEquals(new MutableInt(0), new MutableInt(0), new MutableInt(1)); 
 } 
@Test 
 public void testGetSet2742() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(Integer.valueOf(0), new MutableInt().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(Integer.valueOf(1), mutNum.getValue()); 
     mutNum.setValue(Integer.valueOf(2)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(Integer.valueOf(2), mutNum.getValue()); 
     mutNum.setValue(new MutableLong(3)); 
     assertEquals(3, mutNum.intValue()); 
     assertEquals(Integer.valueOf(3), mutNum.getValue()); 
 } 
@Test 
 public void testAddValueObject2828() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.add(Integer.valueOf(1)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testEquals2975() { 
     this.testEquals(new MutableInt(0), new MutableInt(0), new MutableInt(1)); 
 } 
@Test 
 public void testEquals3799() { 
     this.testEquals(new MutableInt(0), new MutableInt(0), new MutableInt(1)); 
 } 
@Test 
 public void testDecrement3803() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testToString3965() { 
     assertEquals("0", new MutableInt(0).toString()); 
     assertEquals("10", new MutableInt(10).toString()); 
     assertEquals("-123", new MutableInt(-123).toString()); 
 } 
@Test 
 public void testGetSet4834() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(Integer.valueOf(0), new MutableInt().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(Integer.valueOf(1), mutNum.getValue()); 
     mutNum.setValue(Integer.valueOf(2)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(Integer.valueOf(2), mutNum.getValue()); 
     mutNum.setValue(new MutableLong(3)); 
     assertEquals(3, mutNum.intValue()); 
     assertEquals(Integer.valueOf(3), mutNum.getValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull5097() { 
     new MutableInt((Number) null); 
 } 
@Test 
 public void testHashCode5181() { 
     final MutableInt mutNumA = new MutableInt(0); 
     final MutableInt mutNumB = new MutableInt(0); 
     final MutableInt mutNumC = new MutableInt(1); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Integer.valueOf(0).hashCode()); 
 } 
@Test 
 public void testCompareTo5326() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, mutNum.compareTo(new MutableInt(0))); 
     assertEquals(+1, mutNum.compareTo(new MutableInt(-1))); 
     assertEquals(-1, mutNum.compareTo(new MutableInt(1))); 
 } 
@Test 
 public void testPrimitiveValues5350() { 
     final MutableInt mutNum = new MutableInt(1); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testSubtractValuePrimitive6056() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.subtract(1); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull6238() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.compareTo(null); 
 } 
@Test 
 public void testConstructors6397() { 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(1, new MutableInt(1).intValue()); 
     assertEquals(2, new MutableInt(Integer.valueOf(2)).intValue()); 
     assertEquals(3, new MutableInt(new MutableLong(3)).intValue()); 
     assertEquals(2, new MutableInt("2").intValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull6421() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.compareTo(null); 
 } 
@Test(expected = NullPointerException.class) 
 public void testSetNull6529() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.setValue(null); 
 } 
@Test 
 public void testSubtractValueObject6599() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.subtract(Integer.valueOf(1)); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testAddValuePrimitive6829() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.add(1); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testHashCode6887() { 
     final MutableInt mutNumA = new MutableInt(0); 
     final MutableInt mutNumB = new MutableInt(0); 
     final MutableInt mutNumC = new MutableInt(1); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Integer.valueOf(0).hashCode()); 
 } 
@Test 
 public void testSubtractValuePrimitive7783() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.subtract(1); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testDecrement7917() { 
     final MutableInt mutNum = new MutableInt(1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testConstructors8340() { 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(1, new MutableInt(1).intValue()); 
     assertEquals(2, new MutableInt(Integer.valueOf(2)).intValue()); 
     assertEquals(3, new MutableInt(new MutableLong(3)).intValue()); 
     assertEquals(2, new MutableInt("2").intValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull8526() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.compareTo(null); 
 } 
@Test 
 public void testEquals8575() { 
     this.testEquals(new MutableInt(0), new MutableInt(0), new MutableInt(1)); 
 } 
@Test 
 public void testGetSet9131() { 
     final MutableInt mutNum = new MutableInt(0); 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(Integer.valueOf(0), new MutableInt().getValue()); 
     mutNum.setValue(1); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(Integer.valueOf(1), mutNum.getValue()); 
     mutNum.setValue(Integer.valueOf(2)); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(Integer.valueOf(2), mutNum.getValue()); 
     mutNum.setValue(new MutableLong(3)); 
     assertEquals(3, mutNum.intValue()); 
     assertEquals(Integer.valueOf(3), mutNum.getValue()); 
 } 
@Test 
 public void testConstructors9383() { 
     assertEquals(0, new MutableInt().intValue()); 
     assertEquals(1, new MutableInt(1).intValue()); 
     assertEquals(2, new MutableInt(Integer.valueOf(2)).intValue()); 
     assertEquals(3, new MutableInt(new MutableLong(3)).intValue()); 
     assertEquals(2, new MutableInt("2").intValue()); 
 } 
@Test 
 public void testPrimitiveValues9418() { 
     final MutableInt mutNum = new MutableInt(1); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull9560() { 
     final MutableInt mutNum = new MutableInt(0); 
     mutNum.compareTo(null); 
 } 
