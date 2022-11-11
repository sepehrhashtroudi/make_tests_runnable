@Test
public void testGetImplicitUpperBounds12130() { 
         final WildcardType wildcardType = EasyMock.createMock(WildcardType.class); 
         final Type[] expected = new Type[] {String.class}; 
         Assert.assertArrayEquals(expected, TypeUtils.getImplicitUpperBounds(wildcardType)); 
         Assert.assertArrayEquals(expected, TypeUtils.getImplicitUpperBounds(new WildcardType())); 
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
  
     public static <T extends Comparable<? extends T>> T stub4() { 
         return null; 
     } 
 }