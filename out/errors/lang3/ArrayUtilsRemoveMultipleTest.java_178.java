@Test
public void testRemoveElementObjectArray10936() { 
         Object[] array; 
         array = ArrayUtils.removeElements((Object[]) null, "a"); 
         assertNull(array); 
         array = ArrayUtils.removeElements(ArrayUtils.EMPTY_OBJECT_ARRAY, "a"); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
         assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new Object[] { "a" }, "a"); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
         assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new Object[] { "a", "b" }, "a"); 
         assertTrue(Arrays.equals(new Object[] { "b" }, array)); 
         assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new Object[] { "a", "b", "a" }, "a"); 
         assertTrue(Arrays.equals(new Object[] { "b", "a" }, array)); 
         assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeElements((Object[]) null, "a", "b"); 
         assertNull(array); 
         array = ArrayUtils.removeElements(ArrayUtils.EMPTY_OBJECT_ARRAY, "a", "b"); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
         assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new Object[] { "a" }, "a", "b"); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_OBJECT_ARRAY, array)); 
         assertEquals(Integer.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new Object[] { "