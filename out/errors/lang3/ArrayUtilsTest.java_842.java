@Test
public void testToObject_object11019() { 
         final Object[] b = null; 
         assertEquals(null, ArrayUtils.toMap(b)); 
          
         assertSame(null, ArrayUtils.toMap(new Object[0])); 
          
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {new String(new char[] { 'f', 'o', 'o' }))); 
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {new char[] { 'f', 'O', 'O' }))); 
          
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {new char[] { 'f', 'O', 'O' }))); 
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {new char[] { 'f', 'O', 'O' }))); 
          
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {new boolean[] { true, false }))); 
         assertTrue(Arrays.equals( 
             new HashMap<Object, Object>(), 
             ArrayUtils.toMap(new Object[] {new boolean[] { true, false }))); 
     }