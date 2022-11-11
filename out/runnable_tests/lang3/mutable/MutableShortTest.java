@Test 
 public void testConstructors284() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testGetSet799() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testSubtractValuePrimitive845() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.subtract((short) 1); 
     assertEquals((short) 0, mutNum.shortValue()); 
 } 
@Test 
 public void testToString1227() { 
     assertEquals("0", new MutableShort((short) 0).toString()); 
     assertEquals("10", new MutableShort((short) 10).toString()); 
     assertEquals("-123", new MutableShort((short) -123).toString()); 
 } 
@Test 
 public void testPrimitiveValues1673() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testIncrement1789() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testCompareTo2004() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0))); 
     assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1))); 
     assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1))); 
     try { 
         mutNum.compareTo(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testAddValuePrimitive2023() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.add((short) 1); 
     assertEquals((short) 2, mutNum.shortValue()); 
 } 
@Test 
 public void testConstructors2184() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testDecrement2357() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testDecrement2508() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.decrement(); 
     assertEquals(0, mutNum.intValue()); 
     assertEquals(0L, mutNum.longValue()); 
 } 
@Test 
 public void testConstructors2576() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testConstructors3012() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testCompareTo3182() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0))); 
     assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1))); 
     assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1))); 
     try { 
         mutNum.compareTo(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testAddValuePrimitive3557() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.add((short) 1); 
     assertEquals((short) 2, mutNum.shortValue()); 
 } 
@Test 
 public void testSubtractValuePrimitive3587() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.subtract((short) 1); 
     assertEquals((short) 0, mutNum.shortValue()); 
 } 
@Test 
 public void testIncrement3746() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testHashCode3867() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Short.valueOf((short) 0).hashCode()); 
 } 
@Test 
 public void testIncrement3974() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testCompareTo4439() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0))); 
     assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1))); 
     assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1))); 
     try { 
         mutNum.compareTo(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testConstructors4517() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testEquals4524() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Short.valueOf((short) 0))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testPrimitiveValues4713() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testIncrement4738() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testHashCode5446() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Short.valueOf((short) 0).hashCode()); 
 } 
@Test 
 public void testConstructors5579() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testIncrement5956() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testGetSet6074() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testEquals6207() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Short.valueOf((short) 0))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testAddValueObject6289() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.add(Short.valueOf((short) 1)); 
     assertEquals((short) 2, mutNum.shortValue()); 
 } 
@Test 
 public void testCompareTo6517() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0))); 
     assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1))); 
     assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1))); 
     try { 
         mutNum.compareTo(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testEquals6605() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Short.valueOf((short) 0))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testPrimitiveValues6675() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testConstructors6864() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testCompareTo7029() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0))); 
     assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1))); 
     assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1))); 
     try { 
         mutNum.compareTo(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testGetSet7122() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testConstructors7149() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testEquals7157() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(Short.valueOf((short) 0))); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testSubtractValueObject7171() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.subtract(Short.valueOf((short) 1)); 
     assertEquals((short) 0, mutNum.shortValue()); 
 } 
@Test 
 public void testIncrement7248() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.increment(); 
     assertEquals(2, mutNum.intValue()); 
     assertEquals(2L, mutNum.longValue()); 
 } 
@Test 
 public void testGetSet7642() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testGetSet7777() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testConstructors8195() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testToShort8613() { 
     assertEquals(Short.valueOf((short) 0), new MutableShort((short) 0).toShort()); 
     assertEquals(Short.valueOf((short) 123), new MutableShort((short) 123).toShort()); 
 } 
@Test 
 public void testToString8662() { 
     assertEquals("0", new MutableShort((short) 0).toString()); 
     assertEquals("10", new MutableShort((short) 10).toString()); 
     assertEquals("-123", new MutableShort((short) -123).toString()); 
 } 
@Test 
 public void testGetSet8750() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
     try { 
         mutNum.setValue(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testAddValueObject8954() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.add(Short.valueOf((short) 1)); 
     assertEquals((short) 2, mutNum.shortValue()); 
 } 
@Test 
 public void testPrimitiveValues9000() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     assertEquals(1.0F, mutNum.floatValue(), 0); 
     assertEquals(1.0, mutNum.doubleValue(), 0); 
     assertEquals((byte) 1, mutNum.byteValue()); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(1, mutNum.intValue()); 
     assertEquals(1L, mutNum.longValue()); 
 } 
@Test 
 public void testSubtractValueObject9247() { 
     final MutableShort mutNum = new MutableShort((short) 1); 
     mutNum.subtract(Short.valueOf((short) 1)); 
     assertEquals((short) 0, mutNum.shortValue()); 
 } 
@Test 
 public void testCompareTo9270() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0))); 
     assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1))); 
     assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1))); 
     try { 
         mutNum.compareTo(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testConstructors9363() { 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals((short) 1, new MutableShort((short) 1).shortValue()); 
     assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue()); 
     assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue()); 
     assertEquals((short) 2, new MutableShort("2").shortValue()); 
     try { 
         new MutableShort((Number) null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testToShort9409() { 
     assertEquals(Short.valueOf((short) 0), new MutableShort((short) 0).toShort()); 
     assertEquals(Short.valueOf((short) 123), new MutableShort((short) 123).toShort()); 
 } 
