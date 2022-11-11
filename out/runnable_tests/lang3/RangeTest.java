@Test 
 public void testIsStartedBy80() { 
     assertFalse(intRange.isStartedBy(null)); 
     assertFalse(intRange.isStartedBy(5)); 
     assertTrue(intRange.isStartedBy(10)); 
     assertFalse(intRange.isStartedBy(15)); 
     assertFalse(intRange.isStartedBy(20)); 
     assertFalse(intRange.isStartedBy(25)); 
 } 
@SuppressWarnings({ "rawtypes", "unchecked" }) 
 @Test 
 public void testComparableConstructors101() { 
     final Comparable c = new Comparable() { 
  
         @Override 
         public int compareTo(final Object other) { 
             return 1; 
         } 
     }; 
     final Range r1 = Range.is(c); 
     final Range r2 = Range.between(c, c); 
     assertEquals(true, r1.isNaturalOrdering()); 
     assertEquals(true, r2.isNaturalOrdering()); 
 } 
@Test 
 public void testIsWithCompare304() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testEqualsObject438() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 } 
@Test 
 public void testIsEndedBy527() { 
     assertFalse(intRange.isEndedBy(null)); 
     assertFalse(intRange.isEndedBy(5)); 
     assertFalse(intRange.isEndedBy(10)); 
     assertFalse(intRange.isEndedBy(15)); 
     assertTrue(intRange.isEndedBy(20)); 
     assertFalse(intRange.isEndedBy(25)); 
 } 
@Test 
 public void testGetMinimum613() { 
     assertEquals(10, (int) intRange.getMinimum()); 
     assertEquals(10L, (long) longRange.getMinimum()); 
     assertEquals(10f, floatRange.getMinimum(), 0.00001f); 
     assertEquals(10d, doubleRange.getMinimum(), 0.00001d); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNull660() { 
     intRange.intersectionWith(null); 
 } 
@Test 
 public void testToString728() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testEqualsObject774() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 } 
@Test 
 public void testIsWithCompare830() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testIsStartedBy886() { 
     assertFalse(intRange.isStartedBy(null)); 
     assertFalse(intRange.isStartedBy(5)); 
     assertTrue(intRange.isStartedBy(10)); 
     assertFalse(intRange.isStartedBy(15)); 
     assertFalse(intRange.isStartedBy(20)); 
     assertFalse(intRange.isStartedBy(25)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNonOverlapping902() { 
     intRange.intersectionWith(Range.between(0, 9)); 
 } 
@Test 
 public void testIsEndedBy1042() { 
     assertFalse(intRange.isEndedBy(null)); 
     assertFalse(intRange.isEndedBy(5)); 
     assertFalse(intRange.isEndedBy(10)); 
     assertFalse(intRange.isEndedBy(15)); 
     assertTrue(intRange.isEndedBy(20)); 
     assertFalse(intRange.isEndedBy(25)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNull1432() { 
     intRange.intersectionWith(null); 
 } 
@Test 
 public void testToString1686() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testToString1732() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testEqualsObject1924() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 } 
@Test 
 public void testContainsRange1928() { 
     assertFalse(intRange.containsRange(null)); 
     assertTrue(intRange.containsRange(Range.between(12, 18))); 
     assertFalse(intRange.containsRange(Range.between(32, 45))); 
     assertFalse(intRange.containsRange(Range.between(2, 8))); 
     assertTrue(intRange.containsRange(Range.between(10, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 14))); 
     assertFalse(intRange.containsRange(Range.between(16, 21))); 
     assertTrue(intRange.containsRange(Range.between(10, 19))); 
     assertFalse(intRange.containsRange(Range.between(10, 21))); 
     assertTrue(intRange.containsRange(Range.between(11, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 20))); 
     assertFalse(intRange.containsRange(Range.between(-11, -18))); 
 } 
@Test 
 public void testIsEndedBy2146() { 
     assertFalse(intRange.isEndedBy(null)); 
     assertFalse(intRange.isEndedBy(5)); 
     assertFalse(intRange.isEndedBy(10)); 
     assertFalse(intRange.isEndedBy(15)); 
     assertTrue(intRange.isEndedBy(20)); 
     assertFalse(intRange.isEndedBy(25)); 
 } 
@Test 
 public void testIsStartedBy2177() { 
     assertFalse(intRange.isStartedBy(null)); 
     assertFalse(intRange.isStartedBy(5)); 
     assertTrue(intRange.isStartedBy(10)); 
     assertFalse(intRange.isStartedBy(15)); 
     assertFalse(intRange.isStartedBy(20)); 
     assertFalse(intRange.isStartedBy(25)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNull2229() { 
     intRange.intersectionWith(null); 
 } 
@SuppressWarnings({ "rawtypes", "unchecked" }) 
 @Test 
 public void testComparableConstructors2271() { 
     final Comparable c = new Comparable() { 
  
         @Override 
         public int compareTo(final Object other) { 
             return 1; 
         } 
     }; 
     final Range r1 = Range.is(c); 
     final Range r2 = Range.between(c, c); 
     assertEquals(true, r1.isNaturalOrdering()); 
     assertEquals(true, r2.isNaturalOrdering()); 
 } 
@SuppressWarnings({ "rawtypes", "unchecked" }) 
 @Test 
 public void testComparableConstructors2287() { 
     final Comparable c = new Comparable() { 
  
         @Override 
         public int compareTo(final Object other) { 
             return 1; 
         } 
     }; 
     final Range r1 = Range.is(c); 
     final Range r2 = Range.between(c, c); 
     assertEquals(true, r1.isNaturalOrdering()); 
     assertEquals(true, r2.isNaturalOrdering()); 
 } 
@Test 
 public void testIntersectionWith2329() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 } 
@Test 
 public void testIsWithCompare2397() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testIsWithCompare2935() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testContainsRange2967() { 
     assertFalse(intRange.containsRange(null)); 
     assertTrue(intRange.containsRange(Range.between(12, 18))); 
     assertFalse(intRange.containsRange(Range.between(32, 45))); 
     assertFalse(intRange.containsRange(Range.between(2, 8))); 
     assertTrue(intRange.containsRange(Range.between(10, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 14))); 
     assertFalse(intRange.containsRange(Range.between(16, 21))); 
     assertTrue(intRange.containsRange(Range.between(10, 19))); 
     assertFalse(intRange.containsRange(Range.between(10, 21))); 
     assertTrue(intRange.containsRange(Range.between(11, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 20))); 
     assertFalse(intRange.containsRange(Range.between(-11, -18))); 
 } 
@Test 
 public void testIsAfterRange3075() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@Test 
 public void testIntersectionWith3147() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 } 
@Test 
 public void testIsAfterRange3150() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@Test 
 public void testToString3207() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testIntersectionWith3381() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 } 
@Test 
 public void testElementCompareTo3521() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
 public void testIsStartedBy4353() { 
     assertFalse(intRange.isStartedBy(null)); 
     assertFalse(intRange.isStartedBy(5)); 
     assertTrue(intRange.isStartedBy(10)); 
     assertFalse(intRange.isStartedBy(15)); 
     assertFalse(intRange.isStartedBy(20)); 
     assertFalse(intRange.isStartedBy(25)); 
 } 
@Test 
 public void testIsAfter4571() { 
     assertFalse(intRange.isAfter(null)); 
     assertTrue(intRange.isAfter(5)); 
     assertFalse(intRange.isAfter(10)); 
     assertFalse(intRange.isAfter(15)); 
     assertFalse(intRange.isAfter(20)); 
     assertFalse(intRange.isAfter(25)); 
 } 
@Test 
 public void testElementCompareTo4656() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
 public void testToStringFormat4672() { 
     final String str = intRange.toString("From %1$s to %2$s"); 
     assertEquals("From 10 to 20", str); 
 } 
@Test 
 public void testElementCompareTo4693() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
 public void testIntersectionWith4741() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNull4863() { 
     intRange.intersectionWith(null); 
 } 
@Test 
 public void testEqualsObject4906() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 } 
@Test 
 public void testGetMinimum4954() { 
     assertEquals(10, (int) intRange.getMinimum()); 
     assertEquals(10L, (long) longRange.getMinimum()); 
     assertEquals(10f, floatRange.getMinimum(), 0.00001f); 
     assertEquals(10d, doubleRange.getMinimum(), 0.00001d); 
 } 
@Test 
 public void testIsWithCompare5033() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testGetMaximum5042() { 
     assertEquals(20, (int) intRange.getMaximum()); 
     assertEquals(20L, (long) longRange.getMaximum()); 
     assertEquals(20f, floatRange.getMaximum(), 0.00001f); 
     assertEquals(20d, doubleRange.getMaximum(), 0.00001d); 
 } 
@Test 
 public void testEqualsObject5046() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 } 
@Test 
 public void testToString5555() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testIsAfterRange5609() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@SuppressWarnings({ "rawtypes", "unchecked" }) 
 @Test 
 public void testComparableConstructors5748() { 
     final Comparable c = new Comparable() { 
  
         @Override 
         public int compareTo(final Object other) { 
             return 1; 
         } 
     }; 
     final Range r1 = Range.is(c); 
     final Range r2 = Range.between(c, c); 
     assertEquals(true, r1.isNaturalOrdering()); 
     assertEquals(true, r2.isNaturalOrdering()); 
 } 
@Test 
 public void testIsBefore5923() { 
     assertFalse(intRange.isBefore(null)); 
     assertFalse(intRange.isBefore(5)); 
     assertFalse(intRange.isBefore(10)); 
     assertFalse(intRange.isBefore(15)); 
     assertFalse(intRange.isBefore(20)); 
     assertTrue(intRange.isBefore(25)); 
 } 
@Test 
 public void testToString5947() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testElementCompareTo5978() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
 public void testToString5996() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testEqualsObject6386() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNull6389() { 
     intRange.intersectionWith(null); 
 } 
@Test 
 public void testIntersectionWith6515() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 } 
@Test 
 public void testElementCompareTo6880() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
 public void testToString6934() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testIntersectionWithNull7180() { 
     intRange.intersectionWith(null); 
 } 
@Test 
 public void testToString7211() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testEqualsObject7315() { 
     assertEquals(byteRange, byteRange); 
     assertEquals(byteRange, byteRange2); 
     assertEquals(byteRange2, byteRange2); 
     assertTrue(byteRange.equals(byteRange)); 
     assertTrue(byteRange2.equals(byteRange2)); 
     assertTrue(byteRange3.equals(byteRange3)); 
     assertFalse(byteRange2.equals(byteRange3)); 
     assertFalse(byteRange2.equals(null)); 
     assertFalse(byteRange2.equals("Ni!")); 
 } 
@Test 
 public void testIntersectionWith7427() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 } 
@Test 
 public void testElementCompareTo7457() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
 public void testIntersectionWith7562() { 
     assertSame(intRange, intRange.intersectionWith(intRange)); 
     assertSame(byteRange, byteRange.intersectionWith(byteRange)); 
     assertSame(longRange, longRange.intersectionWith(longRange)); 
     assertSame(floatRange, floatRange.intersectionWith(floatRange)); 
     assertSame(doubleRange, doubleRange.intersectionWith(doubleRange)); 
     assertEquals(Range.between(10, 15), intRange.intersectionWith(Range.between(5, 15))); 
 } 
@Test 
 public void testGetMaximum7596() { 
     assertEquals(20, (int) intRange.getMaximum()); 
     assertEquals(20L, (long) longRange.getMaximum()); 
     assertEquals(20f, floatRange.getMaximum(), 0.00001f); 
     assertEquals(20d, doubleRange.getMaximum(), 0.00001d); 
 } 
@Test 
 public void testIsAfterRange7828() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@Test 
 public void testToString7833() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testToString7884() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testIsEndedBy8012() { 
     assertFalse(intRange.isEndedBy(null)); 
     assertFalse(intRange.isEndedBy(5)); 
     assertFalse(intRange.isEndedBy(10)); 
     assertFalse(intRange.isEndedBy(15)); 
     assertTrue(intRange.isEndedBy(20)); 
     assertFalse(intRange.isEndedBy(25)); 
 } 
@Test 
 public void testIsAfterRange8157() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@Test 
 public void testIsWithCompare8264() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testElementCompareTo8410() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
 public void testIsAfterRange8439() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@Test 
 public void testContainsRange8573() { 
     assertFalse(intRange.containsRange(null)); 
     assertTrue(intRange.containsRange(Range.between(12, 18))); 
     assertFalse(intRange.containsRange(Range.between(32, 45))); 
     assertFalse(intRange.containsRange(Range.between(2, 8))); 
     assertTrue(intRange.containsRange(Range.between(10, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 14))); 
     assertFalse(intRange.containsRange(Range.between(16, 21))); 
     assertTrue(intRange.containsRange(Range.between(10, 19))); 
     assertFalse(intRange.containsRange(Range.between(10, 21))); 
     assertTrue(intRange.containsRange(Range.between(11, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 20))); 
     assertFalse(intRange.containsRange(Range.between(-11, -18))); 
 } 
@Test 
 public void testIsWithCompare8780() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testContainsRange8785() { 
     assertFalse(intRange.containsRange(null)); 
     assertTrue(intRange.containsRange(Range.between(12, 18))); 
     assertFalse(intRange.containsRange(Range.between(32, 45))); 
     assertFalse(intRange.containsRange(Range.between(2, 8))); 
     assertTrue(intRange.containsRange(Range.between(10, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 14))); 
     assertFalse(intRange.containsRange(Range.between(16, 21))); 
     assertTrue(intRange.containsRange(Range.between(10, 19))); 
     assertFalse(intRange.containsRange(Range.between(10, 21))); 
     assertTrue(intRange.containsRange(Range.between(11, 20))); 
     assertFalse(intRange.containsRange(Range.between(9, 20))); 
     assertFalse(intRange.containsRange(Range.between(-11, -18))); 
 } 
@Test 
 public void testToStringFormat9026() { 
     final String str = intRange.toString("From %1$s to %2$s"); 
     assertEquals("From 10 to 20", str); 
 } 
@Test 
 public void testToString9358() { 
     assertNotNull(byteRange.toString()); 
     final String str = intRange.toString(); 
     assertEquals("[10..20]", str); 
     assertEquals("[-20..-10]", Range.between(-20, -10).toString()); 
 } 
@Test 
 public void testIsAfterRange9364() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@Test 
 public void testIsWithCompare9393() { 
     final Comparator<Integer> c = new Comparator<Integer>() { 
  
         @Override 
         public int compare(final Integer o1, final Integer o2) { 
             return 0; 
         } 
     }; 
     Range<Integer> ri = Range.is(10); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertFalse("should not contain 11", ri.contains(11)); 
     ri = Range.is(10, c); 
     assertFalse("should not contain null", ri.contains(null)); 
     assertTrue("should contain 10", ri.contains(10)); 
     assertTrue("should contain 11", ri.contains(11)); 
 } 
@Test 
 public void testElementCompareTo9451() { 
     try { 
         intRange.elementCompareTo(null); 
         fail("NullPointerException should have been thrown"); 
     } catch (final NullPointerException npe) { 
     } 
     assertEquals(-1, intRange.elementCompareTo(5)); 
     assertEquals(0, intRange.elementCompareTo(10)); 
     assertEquals(0, intRange.elementCompareTo(15)); 
     assertEquals(0, intRange.elementCompareTo(20)); 
     assertEquals(1, intRange.elementCompareTo(25)); 
 } 
@Test 
     public void testEqualsHashcode9574() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
     } 
  

@Test 
     public void testIsWithCompare9610() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testEqualsHashcode9933() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     } 
  

@Test 
     public void testEqualsHashcode9934() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
     } 
  

@Test 
     public void testHashCode9935() { 
         final Range<Integer> ri = Range.is(10); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
          
         ri = Range.is(5); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
     } 
  

@Test 
     public void testEqualsHashcode9936() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     } 
  

@Test 
     public void testEqualsHashcode9937() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     } 
  

@Test 
     public void testHashCode9938() { 
         final Range<Integer> ri = Range.is(10); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
          
         ri = Range.is(5); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
     } 
  

@Test 
     public void testEqualsHashcode9939() { 
         final Range<Integer> ri1 = Range.is(10); 
         final Range<Integer> ri2 = Range.is(10); 
         assertEquals(ri1, ri2); 
         assertEquals(ri1.hashCode(), ri2.hashCode()); 
         ri1.hashCode(); 
         ri2.hashCode(); 
         assertFalse(ri1.equals(ri2)); 
     } 
  

@Test 
     public void testHashCode9940() { 
         final Range<Integer> ri = Range.is(10); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
          
         ri = Range.is(5); 
         assertEquals(ri.hashCode(), ri.hashCode()); 
     } 
  

@Test 
     public void testIsBeforeRange11131() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     } 
  

@Test 
     public void testIsWithCompare11132() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsWithCompare11133(){ 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsBeforeRange11134() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     } 
  

@Test 
     public void testIsWithCompare11135() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsBeforeRange11136() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     } 
  

@Test 
     public void testIsWithCompare11137() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsBeforeRange11138() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     } 
  

@Test 
     public void testIsWithCompare11139() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsWithCompare11140(){ 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsWithCompare11141() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testCompareObject11142() { 
         final Object o1 = new Object(); 
         final Object o2 = new Object(); 
         final Comparator<Object> c = new Comparator<Object>(){ 
             @Override 
             public int compare(final Object o1, final Object o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Object> ri = Range.is(o1); 
         assertEquals(-1, ri.compare(o1, o1)); 
         assertEquals(0, ri.compare(o1, o2)); 
          
         ri = Range.is(null); 
         assertEquals(-1, ri.compare(null, o1)); 
         assertEquals(-1, ri.compare(null, o2)); 
     } 
  

@Test 
     public void testCompare11143() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertEquals(-1, ri.compare(null, null)); 
         assertEquals(-1, ri.compare(null, "Ni!")); 
          
         ri = Range.is(10,c); 
         assertEquals(0, ri.compare(null, "Ni!")); 
         assertEquals(+1, ri.compare("Ni!")); 
     } 
  

@Test 
     public void testIsBeforeRange11144() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     } 
  

@Test 
     public void testBetween11145() { 
         final Integer low = Integer.valueOf(10); 
         final Integer mid = Integer.valueOf(11); 
         final Integer high = Integer.valueOf(12); 
         final Range<Integer> ri = Range.between(low, mid); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 0",ri.contains(0)); 
         assertTrue("should contain 1",ri.contains(1)); 
         assertTrue("should contain 2",ri.contains(2)); 
          
         ri = Range.between(low, mid); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 0",ri.contains(0)); 
         assertTrue("should contain 1",ri.contains(1)); 
     } 
  

@Test 
     public void testIsWithCompare11146() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsBeforeRange11147() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     } 
  

@Test 
     public void testIsWithCompare11148() { 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsWithCompare11149(){ 
         final Comparator<Integer> c = new Comparator<Integer>(){ 
             @Override 
             public int compare(final Integer o1, final Integer o2) { 
                 return 0; // all integers are equal 
             } 
         }; 
         Range<Integer> ri = Range.is(10); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
         ri = Range.is(10,c); 
         assertFalse("should not contain null",ri.contains(null)); 
         assertTrue("should contain 10",ri.contains(10)); 
     } 
  

@Test 
     public void testIsBeforeRange11150() { 
         assertFalse(intRange.isBeforeRange(null)); 
          
         assertTrue(intRange.isBeforeRange(Range.between(5, 9))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 10))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 20))); 
         assertFalse(intRange.isBeforeRange(Range.between(5, 25))); 
     } 
  

