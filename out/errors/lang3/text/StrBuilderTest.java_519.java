@Test
public void testGetCharsInt_charArray10368() { 
         final StrBuilder sb = new StrBuilder(); 
         char[] a = new char[10]; 
         sb.getChars(0, 0, a, 0); 
         assertEquals(0, a.length); 
          
         sb.append("junit"); 
         a = sb.getChars(0, 1, a, 0); 
         assertEquals(3, a.length); 
         assertEquals("junit", new String(a, 0, 3)); 
          
         a = sb.getChars(0, 4, a, 0); 
         assertEquals(4, a.length); 
         assertEquals("junit", new String(a, 0, 3)); 
          
         a = sb.getChars(0, 1, a, 0); 
         assertEquals(1, a.length); 
         assertEquals("junit", new String(a, 0, 3)); 
          
         try { 
             sb.getChars(-1, 5, a, -1); 
             fail("no string index out of bound on -1"); 
         } catch (final IndexOutOfBoundsException e) {} 
         try { 
             sb.getChars(6, a, a, -1); 
             fail("no string index out of bound on -1"); 
         } catch (final IndexOutOfBoundsException e) {} 
          
         try { 
             sb.getChars(3, 5, a, 0); 
             fail("no string index out of bound on -1"); 
         } catch (final IndexOutOfBoundsException e) {} 
          
         try { 
             sb.getChars(-1, 5, a, 0); 
             fail("no string index out of bound on -1"); 
         } catch (final IndexOutOfBoundsException e) {} 
          
         try { 
             sb.getChars(6, a, -1); 
             fail