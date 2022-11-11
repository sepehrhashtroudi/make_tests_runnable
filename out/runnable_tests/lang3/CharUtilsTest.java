@Test 
 public void testToChar_Character_char215() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A, 'X')); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B, 'X')); 
     assertEquals('X', CharUtils.toChar((Character) null, 'X')); 
 } 
@Test 
 public void testToIntValue_Character_int222() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testIsAsciiAlphanumeric_char271() { 
     assertTrue(CharUtils.isAsciiAlphanumeric('a')); 
     assertTrue(CharUtils.isAsciiAlphanumeric('A')); 
     assertTrue(CharUtils.isAsciiAlphanumeric('3')); 
     assertFalse(CharUtils.isAsciiAlphanumeric('-')); 
     assertFalse(CharUtils.isAsciiAlphanumeric('\n')); 
     assertFalse(CharUtils.isAsciiAlphanumeric(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiAlphanumeric((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphanumeric((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToIntValue_Character499() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToChar_String_char614() { 
     assertEquals('A', CharUtils.toChar("A", 'X')); 
     assertEquals('B', CharUtils.toChar("BA", 'X')); 
     assertEquals('X', CharUtils.toChar("", 'X')); 
     assertEquals('X', CharUtils.toChar((String) null, 'X')); 
 } 
@Test 
 public void testToCharacterObject_String1167() { 
     assertEquals(null, CharUtils.toCharacterObject(null)); 
     assertEquals(null, CharUtils.toCharacterObject("")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("a")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("abc")); 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject("a")); 
 } 
@Test 
 public void testToIntValue_Character_int1190() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testToUnicodeEscaped_char1230() { 
     assertEquals("\\u0041", CharUtils.unicodeEscaped('A')); 
     for (int i = 0; i < 196; i++) { 
         final String str = CharUtils.unicodeEscaped((char) i); 
         assertEquals(6, str.length()); 
         final int val = Integer.parseInt(str.substring(2), 16); 
         assertEquals(i, val); 
     } 
     assertEquals("\\u0999", CharUtils.unicodeEscaped((char) 0x999)); 
     assertEquals("\\u1001", CharUtils.unicodeEscaped((char) 0x1001)); 
 } 
@Test 
 public void testToIntValue_Character_int1311() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testToIntValue_Character1424() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_char1646() { 
     assertEquals("\\u0041", CharUtils.unicodeEscaped('A')); 
     for (int i = 0; i < 196; i++) { 
         final String str = CharUtils.unicodeEscaped((char) i); 
         assertEquals(6, str.length()); 
         final int val = Integer.parseInt(str.substring(2), 16); 
         assertEquals(i, val); 
     } 
     assertEquals("\\u0999", CharUtils.unicodeEscaped((char) 0x999)); 
     assertEquals("\\u1001", CharUtils.unicodeEscaped((char) 0x1001)); 
 } 
@Test 
 public void testToCharacterObject_String1760() { 
     assertEquals(null, CharUtils.toCharacterObject(null)); 
     assertEquals(null, CharUtils.toCharacterObject("")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("a")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("abc")); 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject("a")); 
 } 
@Test 
 public void testToString_char1800() { 
     assertEquals("a", CharUtils.toString('a')); 
     assertSame(CharUtils.toString('a'), CharUtils.toString('a')); 
     for (int i = 0; i < 128; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertSame(str, str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
     } 
     for (int i = 128; i < 196; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertEquals(str, str2); 
         assertTrue(str != str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
         assertEquals(1, str2.length()); 
         assertEquals(i, str2.charAt(0)); 
     } 
 } 
@Test 
 public void testToChar_String1980() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     try { 
         CharUtils.toChar((String) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toChar(""); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToChar_String2105() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     try { 
         CharUtils.toChar((String) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toChar(""); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToIntValue_Character2186() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_char2358() { 
     assertEquals("\\u0041", CharUtils.unicodeEscaped('A')); 
     for (int i = 0; i < 196; i++) { 
         final String str = CharUtils.unicodeEscaped((char) i); 
         assertEquals(6, str.length()); 
         final int val = Integer.parseInt(str.substring(2), 16); 
         assertEquals(i, val); 
     } 
     assertEquals("\\u0999", CharUtils.unicodeEscaped((char) 0x999)); 
     assertEquals("\\u1001", CharUtils.unicodeEscaped((char) 0x1001)); 
 } 
@Test 
 public void testToString_Character2382() { 
     assertEquals(null, CharUtils.toString(null)); 
     assertEquals("A", CharUtils.toString(CHARACTER_A)); 
     assertSame(CharUtils.toString(CHARACTER_A), CharUtils.toString(CHARACTER_A)); 
 } 
@Test 
 public void testIsAsciiPrintable_char2486() { 
     assertTrue(CharUtils.isAsciiPrintable('a')); 
     assertTrue(CharUtils.isAsciiPrintable('A')); 
     assertTrue(CharUtils.isAsciiPrintable('3')); 
     assertTrue(CharUtils.isAsciiPrintable('-')); 
     assertFalse(CharUtils.isAsciiPrintable('\n')); 
     assertFalse(CharUtils.isAscii(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i >= 32 && i <= 126) { 
             assertTrue(CharUtils.isAsciiPrintable((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiPrintable((char) i)); 
         } 
     } 
 } 
@Test 
 public void testIsAsciiAlphaUpper_char2860() { 
     assertFalse(CharUtils.isAsciiAlphaUpper('a')); 
     assertTrue(CharUtils.isAsciiAlphaUpper('A')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('3')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('-')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('\n')); 
     assertFalse(CharUtils.isAsciiAlphaUpper(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i >= 'A' && i <= 'Z') { 
             assertTrue(CharUtils.isAsciiAlphaUpper((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphaUpper((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToString_char2945() { 
     assertEquals("a", CharUtils.toString('a')); 
     assertSame(CharUtils.toString('a'), CharUtils.toString('a')); 
     for (int i = 0; i < 128; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertSame(str, str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
     } 
     for (int i = 128; i < 196; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertEquals(str, str2); 
         assertTrue(str != str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
         assertEquals(1, str2.length()); 
         assertEquals(i, str2.charAt(0)); 
     } 
 } 
@Test 
 public void testIsAsciiAlphanumeric_char3195() { 
     assertTrue(CharUtils.isAsciiAlphanumeric('a')); 
     assertTrue(CharUtils.isAsciiAlphanumeric('A')); 
     assertTrue(CharUtils.isAsciiAlphanumeric('3')); 
     assertFalse(CharUtils.isAsciiAlphanumeric('-')); 
     assertFalse(CharUtils.isAsciiAlphanumeric('\n')); 
     assertFalse(CharUtils.isAsciiAlphanumeric(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) { 
             assertTrue(CharUtils.isAsciiAlphanumeric((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphanumeric((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToString_Character3556() { 
     assertEquals(null, CharUtils.toString(null)); 
     assertEquals("A", CharUtils.toString(CHARACTER_A)); 
     assertSame(CharUtils.toString(CHARACTER_A), CharUtils.toString(CHARACTER_A)); 
 } 
@Test 
 public void testToIntValue_Character3694() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_Character3847() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@Test 
 public void testToCharacterObject_String4035() { 
     assertEquals(null, CharUtils.toCharacterObject(null)); 
     assertEquals(null, CharUtils.toCharacterObject("")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("a")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("abc")); 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject("a")); 
 } 
@Test 
 public void testConstructor4051() { 
     assertNotNull(new CharUtils()); 
     final Constructor<?>[] cons = CharUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(BooleanUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(BooleanUtils.class.getModifiers())); 
 } 
@Test 
 public void testIsAsciiAlphaUpper_char4098() { 
     assertFalse(CharUtils.isAsciiAlphaUpper('a')); 
     assertTrue(CharUtils.isAsciiAlphaUpper('A')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('3')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('-')); 
     assertFalse(CharUtils.isAsciiAlphaUpper('\n')); 
     assertFalse(CharUtils.isAsciiAlphaUpper(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i >= 'A' && i <= 'Z') { 
             assertTrue(CharUtils.isAsciiAlphaUpper((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphaUpper((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_Character4129() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@Test 
 public void testToChar_Character_char4826() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A, 'X')); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B, 'X')); 
     assertEquals('X', CharUtils.toChar((Character) null, 'X')); 
 } 
@Test 
 public void testToChar_Character4829() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A)); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B)); 
     try { 
         CharUtils.toChar((Character) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToIntValue_Character4984() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToIntValue_Character_int5018() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testToIntValue_Character_int5138() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testIsAsciiAlphaLower_char5209() { 
     assertTrue(CharUtils.isAsciiAlphaLower('a')); 
     assertFalse(CharUtils.isAsciiAlphaLower('A')); 
     assertFalse(CharUtils.isAsciiAlphaLower('3')); 
     assertFalse(CharUtils.isAsciiAlphaLower('-')); 
     assertFalse(CharUtils.isAsciiAlphaLower('\n')); 
     assertFalse(CharUtils.isAsciiAlphaLower(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i >= 'a' && i <= 'z') { 
             assertTrue(CharUtils.isAsciiAlphaLower((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphaLower((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToChar_Character_char5316() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A, 'X')); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B, 'X')); 
     assertEquals('X', CharUtils.toChar((Character) null, 'X')); 
 } 
@Test 
 public void testToChar_Character5496() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A)); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B)); 
     try { 
         CharUtils.toChar((Character) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_Character5535() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@SuppressWarnings("deprecation") 
 @Test 
 public void testToCharacterObject_char5560() { 
     assertEquals(new Character('a'), CharUtils.toCharacterObject('a')); 
     assertSame(CharUtils.toCharacterObject('a'), CharUtils.toCharacterObject('a')); 
     for (int i = 0; i < 128; i++) { 
         final Character ch = CharUtils.toCharacterObject((char) i); 
         final Character ch2 = CharUtils.toCharacterObject((char) i); 
         assertSame(ch, ch2); 
         assertEquals(i, ch.charValue()); 
     } 
     for (int i = 128; i < 196; i++) { 
         final Character ch = CharUtils.toCharacterObject((char) i); 
         final Character ch2 = CharUtils.toCharacterObject((char) i); 
         assertEquals(ch, ch2); 
         assertTrue(ch != ch2); 
         assertEquals(i, ch.charValue()); 
         assertEquals(i, ch2.charValue()); 
     } 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject('a')); 
 } 
@Test 
 public void testIsAsciiControl_char5666() { 
     assertFalse(CharUtils.isAsciiControl('a')); 
     assertFalse(CharUtils.isAsciiControl('A')); 
     assertFalse(CharUtils.isAsciiControl('3')); 
     assertFalse(CharUtils.isAsciiControl('-')); 
     assertTrue(CharUtils.isAsciiControl('\n')); 
     assertFalse(CharUtils.isAsciiControl(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i < 32 || i == 127) { 
             assertTrue(CharUtils.isAsciiControl((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiControl((char) i)); 
         } 
     } 
 } 
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
 @Test 
 public void testToCharacterObject_char5726() { 
     assertEquals(new Character('a'), CharUtils.toCharacterObject('a')); 
     assertSame(CharUtils.toCharacterObject('a'), CharUtils.toCharacterObject('a')); 
     for (int i = 0; i < 128; i++) { 
         final Character ch = CharUtils.toCharacterObject((char) i); 
         final Character ch2 = CharUtils.toCharacterObject((char) i); 
         assertSame(ch, ch2); 
         assertEquals(i, ch.charValue()); 
     } 
     for (int i = 128; i < 196; i++) { 
         final Character ch = CharUtils.toCharacterObject((char) i); 
         final Character ch2 = CharUtils.toCharacterObject((char) i); 
         assertEquals(ch, ch2); 
         assertTrue(ch != ch2); 
         assertEquals(i, ch.charValue()); 
         assertEquals(i, ch2.charValue()); 
     } 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject('a')); 
 } 
@Test 
 public void testToChar_Character5913() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A)); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B)); 
     try { 
         CharUtils.toChar((Character) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_char6005() { 
     assertEquals("\\u0041", CharUtils.unicodeEscaped('A')); 
     for (int i = 0; i < 196; i++) { 
         final String str = CharUtils.unicodeEscaped((char) i); 
         assertEquals(6, str.length()); 
         final int val = Integer.parseInt(str.substring(2), 16); 
         assertEquals(i, val); 
     } 
     assertEquals("\\u0999", CharUtils.unicodeEscaped((char) 0x999)); 
     assertEquals("\\u1001", CharUtils.unicodeEscaped((char) 0x1001)); 
 } 
@Test 
 public void testConstructor6271() { 
     assertNotNull(new CharUtils()); 
     final Constructor<?>[] cons = CharUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(BooleanUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(BooleanUtils.class.getModifiers())); 
 } 
@Test 
 public void testToUnicodeEscaped_Character6468() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@Test 
 public void testToIntValue_Character6509() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testIsAscii_char6642() { 
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
@Test 
 public void testIsAsciiAlpha_char6960() { 
     assertTrue(CharUtils.isAsciiAlpha('a')); 
     assertTrue(CharUtils.isAsciiAlpha('A')); 
     assertFalse(CharUtils.isAsciiAlpha('3')); 
     assertFalse(CharUtils.isAsciiAlpha('-')); 
     assertFalse(CharUtils.isAsciiAlpha('\n')); 
     assertFalse(CharUtils.isAsciiAlpha(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z')) { 
             assertTrue(CharUtils.isAsciiAlpha((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlpha((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToCharacterObject_String7054() { 
     assertEquals(null, CharUtils.toCharacterObject(null)); 
     assertEquals(null, CharUtils.toCharacterObject("")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("a")); 
     assertEquals(new Character('a'), CharUtils.toCharacterObject("abc")); 
     assertSame(CharUtils.toCharacterObject("a"), CharUtils.toCharacterObject("a")); 
 } 
@Test 
 public void testToIntValue_Character_int7123() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testToString_char7129() { 
     assertEquals("a", CharUtils.toString('a')); 
     assertSame(CharUtils.toString('a'), CharUtils.toString('a')); 
     for (int i = 0; i < 128; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertSame(str, str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
     } 
     for (int i = 128; i < 196; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertEquals(str, str2); 
         assertTrue(str != str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
         assertEquals(1, str2.length()); 
         assertEquals(i, str2.charAt(0)); 
     } 
 } 
@Test 
 public void testToIntValue_Character_int7151() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testToString_Character7199() { 
     assertEquals(null, CharUtils.toString(null)); 
     assertEquals("A", CharUtils.toString(CHARACTER_A)); 
     assertSame(CharUtils.toString(CHARACTER_A), CharUtils.toString(CHARACTER_A)); 
 } 
@Test 
 public void testToUnicodeEscaped_Character7215() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@Test 
 public void testIsAsciiAlpha_char7279() { 
     assertTrue(CharUtils.isAsciiAlpha('a')); 
     assertTrue(CharUtils.isAsciiAlpha('A')); 
     assertFalse(CharUtils.isAsciiAlpha('3')); 
     assertFalse(CharUtils.isAsciiAlpha('-')); 
     assertFalse(CharUtils.isAsciiAlpha('\n')); 
     assertFalse(CharUtils.isAsciiAlpha(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z')) { 
             assertTrue(CharUtils.isAsciiAlpha((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlpha((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToChar_Character_char7980() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A, 'X')); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B, 'X')); 
     assertEquals('X', CharUtils.toChar((Character) null, 'X')); 
 } 
@Test 
 public void testToIntValue_Character8036() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToChar_String_char8040() { 
     assertEquals('A', CharUtils.toChar("A", 'X')); 
     assertEquals('B', CharUtils.toChar("BA", 'X')); 
     assertEquals('X', CharUtils.toChar("", 'X')); 
     assertEquals('X', CharUtils.toChar((String) null, 'X')); 
 } 
@Test 
 public void testToIntValue_Character8101() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'))); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'))); 
     try { 
         CharUtils.toIntValue(null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toIntValue(CHARACTER_A); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testIsAsciiControl_char8231() { 
     assertFalse(CharUtils.isAsciiControl('a')); 
     assertFalse(CharUtils.isAsciiControl('A')); 
     assertFalse(CharUtils.isAsciiControl('3')); 
     assertFalse(CharUtils.isAsciiControl('-')); 
     assertTrue(CharUtils.isAsciiControl('\n')); 
     assertFalse(CharUtils.isAsciiControl(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i < 32 || i == 127) { 
             assertTrue(CharUtils.isAsciiControl((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiControl((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToChar_Character8307() { 
     assertEquals('A', CharUtils.toChar(CHARACTER_A)); 
     assertEquals('B', CharUtils.toChar(CHARACTER_B)); 
     try { 
         CharUtils.toChar((Character) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToIntValue_Character_int8456() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testIsAsciiAlphaLower_char8484() { 
     assertTrue(CharUtils.isAsciiAlphaLower('a')); 
     assertFalse(CharUtils.isAsciiAlphaLower('A')); 
     assertFalse(CharUtils.isAsciiAlphaLower('3')); 
     assertFalse(CharUtils.isAsciiAlphaLower('-')); 
     assertFalse(CharUtils.isAsciiAlphaLower('\n')); 
     assertFalse(CharUtils.isAsciiAlphaLower(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i >= 'a' && i <= 'z') { 
             assertTrue(CharUtils.isAsciiAlphaLower((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiAlphaLower((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_Character8489() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@Test 
 public void testToChar_String8673() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     try { 
         CharUtils.toChar((String) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toChar(""); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToChar_String_char8744() { 
     assertEquals('A', CharUtils.toChar("A", 'X')); 
     assertEquals('B', CharUtils.toChar("BA", 'X')); 
     assertEquals('X', CharUtils.toChar("", 'X')); 
     assertEquals('X', CharUtils.toChar((String) null, 'X')); 
 } 
@Test 
 public void testToUnicodeEscaped_Character8811() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@Test 
 public void testToIntValue_Character_int8834() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testIsAsciiPrintable_char8917() { 
     assertTrue(CharUtils.isAsciiPrintable('a')); 
     assertTrue(CharUtils.isAsciiPrintable('A')); 
     assertTrue(CharUtils.isAsciiPrintable('3')); 
     assertTrue(CharUtils.isAsciiPrintable('-')); 
     assertFalse(CharUtils.isAsciiPrintable('\n')); 
     assertFalse(CharUtils.isAscii(CHAR_COPY)); 
     for (int i = 0; i < 196; i++) { 
         if (i >= 32 && i <= 126) { 
             assertTrue(CharUtils.isAsciiPrintable((char) i)); 
         } else { 
             assertFalse(CharUtils.isAsciiPrintable((char) i)); 
         } 
     } 
 } 
@Test 
 public void testToUnicodeEscaped_Character9162() { 
     assertEquals(null, CharUtils.unicodeEscaped(null)); 
     assertEquals("\\u0041", CharUtils.unicodeEscaped(CHARACTER_A)); 
 } 
@Test 
 public void testToString_Character9271() { 
     assertEquals(null, CharUtils.toString(null)); 
     assertEquals("A", CharUtils.toString(CHARACTER_A)); 
     assertSame(CharUtils.toString(CHARACTER_A), CharUtils.toString(CHARACTER_A)); 
 } 
@Test 
 public void testToIntValue_Character_int9342() { 
     assertEquals(0, CharUtils.toIntValue(new Character('0'), -1)); 
     assertEquals(3, CharUtils.toIntValue(new Character('3'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(new Character('A'), -1)); 
     assertEquals(-1, CharUtils.toIntValue(null, -1)); 
 } 
@Test 
 public void testToChar_String9431() { 
     assertEquals('A', CharUtils.toChar("A")); 
     assertEquals('B', CharUtils.toChar("BA")); 
     try { 
         CharUtils.toChar((String) null); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         CharUtils.toChar(""); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testToChar_String_char9528() { 
     assertEquals('A', CharUtils.toChar("A", 'X')); 
     assertEquals('B', CharUtils.toChar("BA", 'X')); 
     assertEquals('X', CharUtils.toChar("", 'X')); 
     assertEquals('X', CharUtils.toChar((String) null, 'X')); 
 } 
@Test 
 public void testToString_char9529() { 
     assertEquals("a", CharUtils.toString('a')); 
     assertSame(CharUtils.toString('a'), CharUtils.toString('a')); 
     for (int i = 0; i < 128; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertSame(str, str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
     } 
     for (int i = 128; i < 196; i++) { 
         final String str = CharUtils.toString((char) i); 
         final String str2 = CharUtils.toString((char) i); 
         assertEquals(str, str2); 
         assertTrue(str != str2); 
         assertEquals(1, str.length()); 
         assertEquals(i, str.charAt(0)); 
         assertEquals(1, str2.length()); 
         assertEquals(i, str2.charAt(0)); 
     } 
 } 
