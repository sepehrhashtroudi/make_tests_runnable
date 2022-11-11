@Test
public void testRemoveAllLongArray9637() { 
         long[] array; 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 2); 
         assertTrue(Arrays.equals(new long[] { 2 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 1 }, 2); 
         assertTrue(Arrays.equals(new long[] { 1, 1 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeAll(new long[] { 1, 2 }, 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_LONG_ARRAY, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3 }, 1); 
         assertTrue(Arrays.equals(new long[] { 3 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 4 }, 1); 
         assertTrue(Arrays.equals(new long[] { 4, 5 }, array)); 
         assertEquals(Long.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeAll(new long[] { 1, 2, 3, 4 }, 2); 
         assertTrue(Arrays.equals(