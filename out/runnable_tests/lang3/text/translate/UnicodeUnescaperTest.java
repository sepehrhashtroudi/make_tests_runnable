@Test 
 public void testLessThanFour407() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testUPlus443() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\u+0047"; 
     assertEquals("Failed to unescape Unicode characters with 'u+' notation", "G", uu.translate(input)); 
 } 
@Test 
 public void testUPlus455() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\u+0047"; 
     assertEquals("Failed to unescape Unicode characters with 'u+' notation", "G", uu.translate(input)); 
 } 
@Test 
 public void testUPlus495() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\u+0047"; 
     assertEquals("Failed to unescape Unicode characters with 'u+' notation", "G", uu.translate(input)); 
 } 
@Test 
 public void testUPlus547() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\u+0047"; 
     assertEquals("Failed to unescape Unicode characters with 'u+' notation", "G", uu.translate(input)); 
 } 
@Test 
 public void testLessThanFour2458() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testLessThanFour3928() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testUPlus4441() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\u+0047"; 
     assertEquals("Failed to unescape Unicode characters with 'u+' notation", "G", uu.translate(input)); 
 } 
@Test 
 public void testLessThanFour4684() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testLessThanFour6366() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testLessThanFour6550() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testLessThanFour6824() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testUPlus8606() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\u+0047"; 
     assertEquals("Failed to unescape Unicode characters with 'u+' notation", "G", uu.translate(input)); 
 } 
@Test 
 public void testUuuuu8682() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\uuuuuuuu0047"; 
     final String result = uu.translate(input); 
     assertEquals("Failed to unescape Unicode characters with many 'u' characters", "G", result); 
 } 
@Test 
 public void testLessThanFour9480() { 
     final UnicodeUnescaper uu = new UnicodeUnescaper(); 
     final String input = "\\0047\\u006"; 
     try { 
         uu.translate(input); 
         fail("A lack of digits in a Unicode escape sequence failed to throw an exception"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
