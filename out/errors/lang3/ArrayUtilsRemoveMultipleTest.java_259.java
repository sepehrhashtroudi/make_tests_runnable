@Test
public void testAddObjectArrayToObjectArray11599() { 
         assertNull(ArrayUtils.addAll((Object[]) null, (Object[]) null)); 
         Object[] newArray; 
         final String[] stringArray1 = new String[]{"a", "b", "c"}; 
         final String[] stringArray2 = new String[]{"1", "2", "3"}; 
         newArray = ArrayUtils.addAll(stringArray1, (String[]) null); 
         assertNotSame(stringArray1, newArray); 
         assertTrue(Arrays.equals(stringArray1, newArray)); 
         assertTrue(Arrays.equals(new String[]{"a", "b", "c"}, newArray)); 
         assertEquals(String.class, newArray.getClass().getComponentType()); 
         newArray = ArrayUtils.addAll(null, stringArray2); 
         assertNotSame(stringArray2, newArray); 
         assertTrue(Arrays.equals(stringArray2, newArray)); 
         assertTrue(Arrays.equals(new String[]{"1", "2", "3"}, newArray)); 
         assertEquals(String.class, newArray.getClass().getComponentType()); 
         newArray = ArrayUtils.addAll(stringArray1, stringArray2); 
         assertTrue(Arrays.equals(new String[]{"a", "b", "c", "1", "2", "3"}, newArray)); 
         assertEquals(String.class, newArray.getClass().getComponentType()); 
         newArray = ArrayUtils.addAll(ArrayUtils.EMPTY_STRING_ARRAY, (String[]) null); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_STRING_ARRAY, (String[]) null); 
         assertTrue(Arrays.equals(new String[]{}, (String[]) null)); 
         assertEquals(String.class, newArray.getClass().getComponentType()); 
         newArray = ArrayUtils.addAll(null, ArrayUtils.EMPTY_STRING_ARRAY); 
         assertTrue(Arrays.equals(ArrayUtils.EMPTY_STRING_ARRAY,