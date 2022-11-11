@Test
public void testIsAscii_char5669() { 
     assertTrue(CharUtils.isAscii('a')); 
     assertTrue(CharUtils.isAscii('A')); 
     assertTrue(CharUtils.isAscii('3')); 
     assertTrue(CharUtils.isAscii('-')); 
     assertTrue(CharUtils.isAscii('\n')); 
     assertFalse(CharUtils.isAscii(CHAR_COPY)); 
     for (int i = 0; i < 128; i++) { 
         if (i < 128) { 
             assertTrue(CharUtils.isAscii((char) i)); 
         } else { 
             assertFalse(CharUtils.isAscii((char) i)); 
         } 
     } 
 } 
@SuppressWarnings("deprecation")