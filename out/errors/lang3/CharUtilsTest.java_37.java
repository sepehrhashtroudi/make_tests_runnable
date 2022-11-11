@Test
public void testToUnicodeEscaped_Character5535() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@SuppressWarnings("deprecation")