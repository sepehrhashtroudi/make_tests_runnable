@Test
public void testGetContent9907() { 
         final String input = "a   b c \"d e\" f "; 
         StrTokenizer tok = new StrTokenizer(input); 
         assertEquals(input, tok.getContent()); 
  
         tok = new StrTokenizer(input.toCharArray()); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(null, tok.getContent()); 
          
         tok = new StrTokenizer(); 
         assertEquals(input, tok.getContent()); 
          
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
          
         tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
          
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
          
         try { 
             tok = new StrTokenizer(); 
             fail("Expected NoSuchElementException"); 
         } catch (final NoSuchElementException ex) {} 
     } 
  
     //-----------------------------------------------------------------------