@Test
public void testDelete_StringStringarray12258() { 
         assertEquals(null, CharSetUtils.delete(null, (String[]) null)); 
         assertEquals(null, CharSetUtils.delete(null, new String[0])); 
         assertEquals(null, CharSetUtils.delete(null, new String[] {null})); 
         assertEquals(null, CharSetUtils.delete(null, new String[] {"el"})); 
          
         assertEquals("", CharSetUtils.delete("", (String[]) null)); 
         assertEquals("", CharSetUtils.delete("", new String[0])); 
         assertEquals("", CharSetUtils.delete("", new String[] {null})); 
         assertEquals("", CharSetUtils.delete("", new String[] {"a-e"})); 
          
         assertEquals("hello", CharSetUtils.delete("hello", (String[]) null)); 
         assertEquals("hello", CharSetUtils.delete("hello", new String[0])); 
         assertEquals("hello", CharSetUtils.delete("hello", new String[] {null})); 
         assertEquals("hello", CharSetUtils.delete("hello", new String[] {"xyz"})); 
  
         assertEquals("ho", CharSetUtils.delete("hello", new String[] { "el" })); 
         assertEquals("", CharSetUtils.delete("hello", new String[] { "elho" })); 
         assertEquals("hello", CharSetUtils.delete("hello", new String[] { "" })); 
         assertEquals("hello", CharSetUtils.delete("hello", "")); 
         assertEquals("", CharSetUtils.delete("hello", new String[] { "a-z" })); 
         assertEquals("", CharSetUtils.delete("----", new String[] { "-" })); 
         assertEquals("heo", CharSetUtils.delete("hello", new String[] { "l" })); 
     } 
      
 }