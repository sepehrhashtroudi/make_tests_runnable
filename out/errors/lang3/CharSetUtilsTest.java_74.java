@Test
public void testSqueeze_StringStringarray12116() { 
         assertEquals(null, CharSetUtils.squeeze(null, (String[]) null)); 
         assertEquals(null, CharSetUtils.squeeze(null, new String[0])); 
         assertEquals(null, CharSetUtils.squeeze(null, new String[] {null})); 
         assertEquals(null, CharSetUtils.squeeze(null, new String[] {"el"})); 
          
         assertEquals("", CharSetUtils.squeeze("", (String[]) null)); 
         assertEquals("", CharSetUtils.squeeze("", new String[0])); 
         assertEquals("", CharSetUtils.squeeze("", new String[] {null})); 
         assertEquals("", CharSetUtils.squeeze("", new String[] {"a-e"})); 
          
         assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null)); 
         assertEquals("hello", CharSetUtils.squeeze("hello", new String[0])); 
         assertEquals("hello", CharSetUtils.squeeze("hello", new String[] {null})); 
         assertEquals("hello", CharSetUtils.squeeze("hello", new String[] {"xyz"})); 
  
         assertEquals("ho", CharSetUtils.squeeze("hello", new String[] { "el" })); 
         assertEquals("", CharSetUtils.squeeze("hello", new String[] { "elho" })); 
         assertEquals("hello", CharSetUtils.squeeze("hello", new String[] { "" })); 
         assertEquals("hello", CharSetUtils.squeeze("hello", "")); 
         assertEquals("", CharSetUtils.squeeze("hello", new String[] { "a-z" })); 
         assertEquals("", CharSetUtils.squeeze("----", new String[] { "-" })); 
         assertEquals("heo", CharSetUtils.squeeze("hello", new String[] { "l" }