@Test
public void testAppendIfMissingIgnoreCase11420() { 
         assertEquals("appendIfMissingIgnoreCase(null,null)", null, StringUtils.appendIfMissingIgnoreCase(null,null)); 
         assertEquals("appendIfMissingIgnoreCase(abc,null)", "abc", StringUtils.appendIfMissingIgnoreCase("abc",null)); 
         assertEquals("appendIfMissingIgnoreCase(\"\",xyz)", "xyz", StringUtils.appendIfMissingIgnoreCase("","xyz")); 
         assertEquals("appendIfMissingIgnoreCase(abc,xyz)", "xyzabc", StringUtils.appendIfMissingIgnoreCase("abc","xyz")); 
         assertEquals("appendIfMissingIgnoreCase(xyzabc,xyz)", "xyzabc", StringUtils.appendIfMissingIgnoreCase("xyzabc","xyz")); 
         assertEquals("appendIfMissingIgnoreCase(XYZabc,xyz)", "XYZabc", StringUtils.appendIfMissingIgnoreCase("XYZabc","xyz")); 
  
         assertEquals("appendIfMissingIgnoreCase(null,null null)", null, StringUtils.appendIfMissingIgnoreCase(null,null,(CharSequence[]) null)); 
         assertEquals("appendIfMissingIgnoreCase(\"\",xyz,null)", "xyz", StringUtils.appendIfMissingIgnoreCase("","xyz",(CharSequence[]) null)); 
         assertEquals("appendIfMissingIgnoreCase(abc,xyz,{null})","xyzabc", StringUtils.appendIfMissingIgnoreCase("abc","xyz",new CharSequence[]{null})); 
         assertEquals("appendIfMissingIgnoreCase(abc,xyz,\"\")","abc", StringUtils.appendIfMissingIgnoreCase("abc","xyz","")); 
         assertEquals("appendIfMissingIgnoreCase(abc,xyz,mno)","xyzabc", StringUtils.appendIfMissingIgnoreCase("abc","xyz","mno")); 
         assertEquals("appendIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.appendIfMissingIgnoreCase("mnoabc","xyz","mno")); 
         assertEquals("appendIfMissingIgnoreCase(mnoabc,xyz,mno)", "mnoabc", StringUtils.appendIfMissingIgnoreCase("mnoabc","xyz","mno")); 
         assertEquals("