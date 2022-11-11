@Test
public void testRemoveElementByteArray11580() { 
         byte[] array; 
         array = ArrayUtils.removeElements((byte[]) null, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElements(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new byte[] { 1 }, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new byte[] { 1, 2 }, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] { 2 }, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new byte[] { 1, 2, 1 }, (byte) 1); 
         assertTrue(Arrays.equals(new byte[] { 2, 1 }, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
  
         array = ArrayUtils.removeElements((byte[]) null, (byte) 1, (byte) 1); 
         assertNull(array); 
         array = ArrayUtils.removeElements(ArrayUtils.EMPTY_BYTE_ARRAY, (byte) 1, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements(new byte[] { 1 }, (byte) 1, (byte) 1); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_BYTE_ARRAY, array)); 
         assertEquals(Byte.TYPE, array.getClass().getComponentType()); 
         array = ArrayUtils.removeElements