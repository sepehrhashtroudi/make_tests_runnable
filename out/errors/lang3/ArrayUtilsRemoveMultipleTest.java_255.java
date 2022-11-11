@Test
public void testRemoveAllLongArray11595() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, new BitSet(0)); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, new BitSet(1)); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, new BitSet(1)); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, new BitSet(1)); 
         assertTrue(Arrays.equals(new long[] { 2, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, new BitSet(1)); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, new BitSet(1)); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 1 }, new BitSet(1)); 
         assertTrue(Arrays.equals(new long[] { 3, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll