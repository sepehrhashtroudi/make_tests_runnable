@Test
public void testGetCharsInt_charArray10371() { 
         final StrBuilder sb = new StrBuilder(); 
         char[] a = new char[10]; 
         sb.getChars(0, 0, a, 0); 
         assertEquals(0, a.length); 
         sb.getChars(0, 1, a, 0); 
         assertEquals(0, a.length); 
         sb.getChars(0, -1, a, 0); 
         try { 
             sb.getChars(0, -1, a, 0); 
             fail("getChars(int, int, char[], -1) expected IndexOutOfBoundsException"); 
         } catch (final IndexOutOfBoundsException e) { 
             // expected 
         } 
          
         try { 
             sb.getChars(0, 1, a, -1); 
             fail("getChars(int, int, char[], -1) expected IndexOutOfBoundsException"); 
         } catch (final IndexOutOfBoundsException e) { 
             // expected 
         } 
          
         try { 
             sb.getChars(1, -1, a, 0); 
             fail("getChars(int, int, char[], -1) expected IndexOutOfBoundsException"); 
         } catch (final IndexOutOfBoundsException e) { 
             // expected 
         } 
          
         try { 
             sb.getChars(-1, 1, a, 0); 
             fail("getChars(int, int, char[], 0) expected IndexOutOfBoundsException"); 
         } catch (final IndexOutOfBoundsException e) { 
             // expected 
         } 
          
         try { 
             sb.getChars(1, -1, a, -1); 
             fail("getChars(int, int, char[], -1) expected IndexOutOfBoundsException"); 
         } catch (final IndexOutOfBoundsException e) { 
             // expected 
         } 
          
         try { 
             sb.get