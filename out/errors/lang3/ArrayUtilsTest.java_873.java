@Test
public void testSubarrayInt11871() { 
         final int[] nullArray = null; 
         final int[] array = { 10, 11, 12, 13, 14, 15 }; 
         final int[] leftSubarray  = { 10, 11, 12, 13 }; 
         final int[] midSubarray   = { 11, 12, 13, 14 }; 
         final int[] rightSubarray = { 12, 13, 14, 15 }; 
  
  
         assertTrue("0 start, mid end", 
             ArrayUtils.isEquals(leftSubarray, 
                 ArrayUtils.subarray(array, 0, 4))); 
  
         assertTrue("0 start, length end", 
             ArrayUtils.isEquals(array, 
                 ArrayUtils.subarray(array, 0, array.length))); 
  
         assertTrue("mid start, mid end", 
             ArrayUtils.isEquals(midSubarray, 
                 ArrayUtils.subarray(array, 1, 5))); 
  
         assertTrue("mid start, length end", 
             ArrayUtils.isEquals(rightSubarray, 
                 ArrayUtils.subarray(array, 2, array.length))); 
  
  
         assertNull("null input", ArrayUtils.subarray(nullArray, 0, 3)); 
  
         assertEquals("empty array", ArrayUtils.EMPTY_INT_ARRAY, 
             ArrayUtils.subarray(ArrayUtils.EMPTY_INT_ARRAY, 1, 2)); 
  
         assertEquals("start > end", ArrayUtils.EMPTY_INT_ARRAY, 
             ArrayUtils.subarray(array, 4, 2)); 
  
         assertEquals("start == end", ArrayUtils.EMPTY_INT_ARRAY, 
             ArrayUtils.subarray(array, 3, 3)); 
  
         assertTrue("start undershoot, normal end", 
             ArrayUtils.isEquals(leftSubarray, 
                 ArrayUtils.subarray(array,