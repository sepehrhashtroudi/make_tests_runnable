@Test
public void testAppendIfMissing11425() { 
         assertEquals("appendIfMissing(null,null)", null, StringUtils.appendIfMissing(null,null)); 
         assertEquals("appendIfMissing(abc,null)", "abc", StringUtils.appendIfMissing("abc",null)); 
         assertEquals("appendIfMissing(\"\",xyz)", "xyz", StringUtils.appendIfMissing("","xyz")); 
         assertEquals("appendIfMissing(abc,xyz)", "abcxyz", StringUtils.appendIfMissing("abc","xyz")); 
  
         assertEquals("appendIfMissing(abc,xyz)", "abcxyz", StringUtils.appendIfMissing("abc","xyz")); 
         assertEquals("appendIfMissing(abc,xyz,null)", "abcxyz", StringUtils.appendIfMissing("abc","xyz",(CharSequence[]) null)); 
         assertEquals("appendIfMissing(abc,xyz,{null})","abcxyz", StringUtils.appendIfMissing("abc","xyz",new CharSequence[0])); 
         assertEquals("appendIfMissing(abc,xyz,\"\")","abcxyz", StringUtils.appendIfMissing("abc","xyz","")); 
         assertEquals("appendIfMissing(abc,xyz,mno)","xyzmno", StringUtils.appendIfMissing("abc","xyz","mno")); 
  
         assertEquals("appendIfMissing(mno,xyz,mno)", "mno", StringUtils.appendIfMissing("mno","xyz","mno")); 
         assertEquals("appendIfMissing(mno,xyz,mno)", "mno", StringUtils.appendIfMissing("mno","xyz","mno")); 
         assertEquals("appendIfMissing(mno,xyz,mno)", "mno", StringUtils.appendIfMissing("mno","xyz","mno")); 
  
         assertEquals("appendIfMissing(mno,xyz,mno)", "mno", StringUtils.appendIfMissing("mno","xyz","mno")); 
         assertEquals("appendIfMissing(mno,xyz,mno)", "