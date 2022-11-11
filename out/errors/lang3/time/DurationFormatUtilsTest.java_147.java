@Test
public void testLexx_String9800() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("