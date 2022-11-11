@Test
public void testGetImplicitLowerBounds9665() throws Exception { 
         final WildcardType wildcardType = (WildcardType) getClass().getField("hello").getGenericType(); 
         final Type[] expected = new Type[] {String.class}; 
         Assert.assertArrayEquals(expected, TypeUtils.getImplicitLowerBounds(wildcardType)); 
         Assert.assertArrayEquals(expected, TypeUtils.getImplicitLowerBounds(null)); 
     } 
  
     public Iterable<? extends Map<Integer, ? extends Collection<?>>> iterable; 
  
     public static <G extends Comparable<G>> G stub() { 
         return null; 
     } 
  
     public static <T extends Comparable<? extends T>> T stub2() { 
         return null; 
     } 
  
     public static <T extends Comparable<? extends T>> T stub3() { 
         return null; 
     } 
 }