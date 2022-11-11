@Test
public void testLexx11867() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
         assertEquals(newToken("a"), lexx("a")); 
         assertEquals(newToken("b"), lexx("b")); 
         assertEquals(newToken("c"), lexx("c")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f"), lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("k")); 
         assertEquals(newToken("l"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m")); 
         assertEquals(newToken("n"), lexx("n")); 
         assertEquals(newToken("o"), lexx("o")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f", lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m"));