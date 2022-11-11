@Test
public void testLexx_String9779() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         final String str = "a b c"; 
         final Token[] tokens = lexx(str); 
         assertEquals(3, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("a", tokens[0].getValue()); 
         assertEquals("b", tokens[1].getClass()); 
         assertEquals("c", tokens[2].getClass()); 
  
         tokens = lexx(str); 
         assertEquals(3, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("a", tokens[1].getClass()); 
         assertEquals("b", tokens[2].getClass()); 
  
         tokens = lexx(str); 
         assertEquals(4, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("c", tokens[1].getClass()); 
         assertEquals("a", tokens[2].getClass()); 
  
         tokens = lexx(str + "b"); 
         assertEquals(6, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("b", tokens[1].getClass()); 
         assertEquals("c", tokens[2].getClass()); 
  
         tokens = lexx(str); 
         assertEquals(7, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("a", tokens[1].getClass()); 
         assertEquals("b", tokens[2].getClass()); 
         assertEquals("c", tokens[3].getClass()); 
  
         tokens = lexx(