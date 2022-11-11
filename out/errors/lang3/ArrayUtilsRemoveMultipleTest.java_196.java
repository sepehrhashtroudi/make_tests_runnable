@Test
@SuppressWarnings("cast") 
     public void testRemoveElementFloatArray11477() { 
         float[] array; 
         array = ArrayUtils.removeElements((float[]) null, (float) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElements(ArrayUtils.EMPTY_FLOAT_ARRAY, (float) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
         assertEquals(Float.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new float[] { 1 }, (float) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
         assertEquals(Float.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new float[] { 1, 2 }, (float) 1); 
         assertTrue(Arrays.equals(new float[] { 2 }, array)); 
         assertEquals(Float.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new float[] { 1, 2, 1 }, (float) 1); 
         assertTrue(Arrays.equals(new float[] { 2, 1 }, array)); 
         assertEquals(Float.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeElements((float[]) null, (float) 1, (float) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElements(ArrayUtils.EMPTY_FLOAT_ARRAY, (float) 1, (float) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
         assertEquals(Float.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new float[] { 1 }, (float) 1, (float) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_FLOAT_ARRAY, array)); 
         assertEquals(Float.TYPE, array.getClass().getComponentType());