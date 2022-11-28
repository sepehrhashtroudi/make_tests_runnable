@Test 
 public void testReverse4() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 } 
@Test 
 public void testStartsWith6() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testTrim39() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testAsTokenizer64() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testReplace_int_int_String99() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace(0, 1, "d"); 
     assertEquals("dbc", sb.toString()); 
     sb.replace(0, 1, "aaa"); 
     assertEquals("aaabc", sb.toString()); 
     sb.replace(0, 3, ""); 
     assertEquals("bc", sb.toString()); 
     sb.replace(1, 2, (String) null); 
     assertEquals("b", sb.toString()); 
     sb.replace(1, 1000, "text"); 
     assertEquals("btext", sb.toString()); 
     sb.replace(0, 1000, "text"); 
     assertEquals("text", sb.toString()); 
     sb = new StrBuilder("atext"); 
     sb.replace(1, 1, "ny"); 
     assertEquals("anytext", sb.toString()); 
     try { 
         sb.replace(2, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder(); 
     try { 
         sb.replace(1, 2, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.replace(-1, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testAsWriter108() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_char_char197() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 } 
@Test 
 public void testAsReader199() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testRightString224() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 } 
@Test 
 public void testContains_char230() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains('a')); 
     assertTrue(sb.contains('o')); 
     assertTrue(sb.contains('z')); 
     assertFalse(sb.contains('1')); 
 } 
@Test 
 public void testToCharArray235() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     char[] a = sb.toCharArray(); 
     assertNotNull("toCharArray() result is null", a); 
     assertEquals("toCharArray() result is too large", 0, a.length); 
     sb.append("junit"); 
     a = sb.toCharArray(); 
     assertEquals("toCharArray() result incorrect length", 5, a.length); 
     assertTrue("toCharArray() result does not match", Arrays.equals("junit".toCharArray(), a)); 
 } 
@Test 
 public void testAsTokenizer241() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testEquals257() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testLastIndexOf_String_int306() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(-1, sb.lastIndexOf("a", -1)); 
     assertEquals(0, sb.lastIndexOf("a", 0)); 
     assertEquals(0, sb.lastIndexOf("a", 1)); 
     assertEquals(2, sb.lastIndexOf("a", 2)); 
     assertEquals(2, sb.lastIndexOf("a", 3)); 
     assertEquals(2, sb.lastIndexOf("a", 4)); 
     assertEquals(2, sb.lastIndexOf("a", 5)); 
     assertEquals(-1, sb.lastIndexOf("abcdef", 3)); 
     assertEquals("abab".lastIndexOf("", 3), sb.lastIndexOf("", 3)); 
     assertEquals("abab".lastIndexOf("", 1), sb.lastIndexOf("", 1)); 
     assertEquals("abab".lastIndexOf("a", 1), sb.lastIndexOf("a", 1)); 
     assertEquals(0, sb.lastIndexOf("ab", 1)); 
     assertEquals("abab".lastIndexOf("ab", 1), sb.lastIndexOf("ab", 1)); 
     assertEquals(1, sb.lastIndexOf("b", 2)); 
     assertEquals("abab".lastIndexOf("b", 2), sb.lastIndexOf("b", 2)); 
     assertEquals(1, sb.lastIndexOf("ba", 2)); 
     assertEquals("abab".lastIndexOf("ba", 2), sb.lastIndexOf("ba", 2)); 
     assertEquals(-1, sb.lastIndexOf("z", 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.lastIndexOf("za", sb.length())); 
     assertEquals(-1, sb.lastIndexOf("za", 1)); 
     assertEquals(-1, sb.lastIndexOf((String) null, 2)); 
 } 
@Test 
 public void testAsWriter307() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReverse332() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 } 
@Test 
 public void testReverse343() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String366() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testGetChars372() { 
     final StrBuilder sb = new StrBuilder(); 
     char[] input = new char[10]; 
     char[] a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[10], a)); 
     sb.append("junit"); 
     a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't', 0, 0, 0, 0, 0 }, a)); 
     a = sb.getChars(null); 
     assertNotSame(input, a); 
     assertEquals(5, a.length); 
     assertTrue(Arrays.equals("junit".toCharArray(), a)); 
     input = new char[5]; 
     a = sb.getChars(input); 
     assertSame(input, a); 
     input = new char[4]; 
     a = sb.getChars(input); 
     assertNotSame(input, a); 
 } 
@Test 
 public void testGetChars374() { 
     final StrBuilder sb = new StrBuilder(); 
     char[] input = new char[10]; 
     char[] a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[10], a)); 
     sb.append("junit"); 
     a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't', 0, 0, 0, 0, 0 }, a)); 
     a = sb.getChars(null); 
     assertNotSame(input, a); 
     assertEquals(5, a.length); 
     assertTrue(Arrays.equals("junit".toCharArray(), a)); 
     input = new char[5]; 
     a = sb.getChars(input); 
     assertSame(input, a); 
     input = new char[4]; 
     a = sb.getChars(input); 
     assertNotSame(input, a); 
 } 
@Test 
 public void testGetChars385() { 
     final StrBuilder sb = new StrBuilder(); 
     char[] input = new char[10]; 
     char[] a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[10], a)); 
     sb.append("junit"); 
     a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't', 0, 0, 0, 0, 0 }, a)); 
     a = sb.getChars(null); 
     assertNotSame(input, a); 
     assertEquals(5, a.length); 
     assertTrue(Arrays.equals("junit".toCharArray(), a)); 
     input = new char[5]; 
     a = sb.getChars(input); 
     assertSame(input, a); 
     input = new char[4]; 
     a = sb.getChars(input); 
     assertNotSame(input, a); 
 } 
@Test 
 public void testContains_char408() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains('a')); 
     assertTrue(sb.contains('o')); 
     assertTrue(sb.contains('z')); 
     assertFalse(sb.contains('1')); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String415() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testStartsWith442() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testLastIndexOf_String444() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testLastIndexOf_String453() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testSubstringInt514() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testTrim516() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testLang412Right538() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testToCharArrayIntInt542() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceFirst_char_char553() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 } 
@Test 
 public void testIndexOf_StrMatcher559() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testTrim588() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testRightString661() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher678() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testContains_StrMatcher710() { 
     StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains(StrMatcher.charMatcher('a'))); 
     assertTrue(sb.contains(StrMatcher.stringMatcher("pq"))); 
     assertTrue(sb.contains(StrMatcher.charMatcher('z'))); 
     assertFalse(sb.contains(StrMatcher.stringMatcher("zy"))); 
     assertFalse(sb.contains((StrMatcher) null)); 
     sb = new StrBuilder(); 
     assertFalse(sb.contains(A_NUMBER_MATCHER)); 
     sb.append("B A1 C"); 
     assertTrue(sb.contains(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testChaining742() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testDeleteFirst_String749() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("X"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("a"); 
     assertEquals("bcbccba", sb.toString()); 
     sb.deleteFirst("c"); 
     assertEquals("bbccba", sb.toString()); 
     sb.deleteFirst("b"); 
     assertEquals("bccba", sb.toString()); 
     sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst("bc"); 
     assertEquals("abccba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("bc"); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsWriter767() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testAsReader795() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testChaining796() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testChaining800() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testLang412Right803() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testStartsWith872() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testIsEmpty890() { 
     final StrBuilder sb = new StrBuilder(); 
     assertTrue(sb.isEmpty()); 
     sb.append("Hello"); 
     assertFalse(sb.isEmpty()); 
     sb.clear(); 
     assertTrue(sb.isEmpty()); 
 } 
@Test 
 public void testChaining893() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testStartsWith904() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testLang412Left908() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadLeft(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadLeft correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testLang294916() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String943() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testTrim968() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testMidString1005() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String1027() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLeftString1037() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left", sb.leftString(4)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher1086() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testIndexOf_StrMatcher1108() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testAsWriter1120() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testEndsWith1126() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testDeleteAll_char1142() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsTokenizer1151() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testLastIndexOf_String1183() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testSubSequenceIntInt1211() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String1231() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String_int1236() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(-1, sb.lastIndexOf("a", -1)); 
     assertEquals(0, sb.lastIndexOf("a", 0)); 
     assertEquals(0, sb.lastIndexOf("a", 1)); 
     assertEquals(2, sb.lastIndexOf("a", 2)); 
     assertEquals(2, sb.lastIndexOf("a", 3)); 
     assertEquals(2, sb.lastIndexOf("a", 4)); 
     assertEquals(2, sb.lastIndexOf("a", 5)); 
     assertEquals(-1, sb.lastIndexOf("abcdef", 3)); 
     assertEquals("abab".lastIndexOf("", 3), sb.lastIndexOf("", 3)); 
     assertEquals("abab".lastIndexOf("", 1), sb.lastIndexOf("", 1)); 
     assertEquals("abab".lastIndexOf("a", 1), sb.lastIndexOf("a", 1)); 
     assertEquals(0, sb.lastIndexOf("ab", 1)); 
     assertEquals("abab".lastIndexOf("ab", 1), sb.lastIndexOf("ab", 1)); 
     assertEquals(1, sb.lastIndexOf("b", 2)); 
     assertEquals("abab".lastIndexOf("b", 2), sb.lastIndexOf("b", 2)); 
     assertEquals(1, sb.lastIndexOf("ba", 2)); 
     assertEquals("abab".lastIndexOf("ba", 2), sb.lastIndexOf("ba", 2)); 
     assertEquals(-1, sb.lastIndexOf("z", 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.lastIndexOf("za", sb.length())); 
     assertEquals(-1, sb.lastIndexOf("za", 1)); 
     assertEquals(-1, sb.lastIndexOf((String) null, 2)); 
 } 
@Test 
 public void testAsTokenizer1297() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testEndsWith1307() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testLastIndexOf_String1316() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testDeleteAll_char1349() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testChaining1360() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testAsReader1362() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testRightString1364() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 } 
@Test 
 public void testReverse1368() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 } 
@Test 
 public void testToCharArray1409() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     char[] a = sb.toCharArray(); 
     assertNotNull("toCharArray() result is null", a); 
     assertEquals("toCharArray() result is too large", 0, a.length); 
     sb.append("junit"); 
     a = sb.toCharArray(); 
     assertEquals("toCharArray() result incorrect length", 5, a.length); 
     assertTrue("toCharArray() result does not match", Arrays.equals("junit".toCharArray(), a)); 
 } 
@Test 
 public void testContains_char1411() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains('a')); 
     assertTrue(sb.contains('o')); 
     assertTrue(sb.contains('z')); 
     assertFalse(sb.contains('1')); 
 } 
@Test 
 public void testDeleteAll_char1429() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testTrim1440() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testDeleteAll_char1446() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testDeleteAll_StrMatcher1451() { 
     StrBuilder sb = new StrBuilder("A0xA1A2yA3"); 
     sb.deleteAll((StrMatcher) null); 
     assertEquals("A0xA1A2yA3", sb.toString()); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("xy", sb.toString()); 
     sb = new StrBuilder("Ax1"); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("Ax1", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testLang2941453() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String1479() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testAsTokenizer1501() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testReplace_StrMatcher_String_int_int_int_VaryEndIndex1507() { 
     StrBuilder sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 0, -1); 
     assertEquals("aaxaaaayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 2, -1); 
     assertEquals("-xaaaayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 3, -1); 
     assertEquals("-xaaaayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 4, -1); 
     assertEquals("-xaaaayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 5, -1); 
     assertEquals("-x-aayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 6, -1); 
     assertEquals("-x-aayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 7, -1); 
     assertEquals("-x--yaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 8, -1); 
     assertEquals("-x--yaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 9, -1); 
     assertEquals("-x--yaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, -1); 
     assertEquals("-x--y-", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 1000, -1); 
     assertEquals("-x--y-", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     try { 
         sb.replace(StrMatcher.stringMatcher("aa"), "-", 2, 1, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals("aaxaaaayaa", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher1508() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testAsWriter1523() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_String_String1557() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String1566() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testIndexOf_String_int1568() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf("a", -1)); 
     assertEquals(0, sb.indexOf("a", 0)); 
     assertEquals(2, sb.indexOf("a", 1)); 
     assertEquals(2, sb.indexOf("a", 2)); 
     assertEquals(-1, sb.indexOf("a", 3)); 
     assertEquals(-1, sb.indexOf("a", 4)); 
     assertEquals(-1, sb.indexOf("a", 5)); 
     assertEquals(-1, sb.indexOf("abcdef", 0)); 
     assertEquals(0, sb.indexOf("", 0)); 
     assertEquals(1, sb.indexOf("", 1)); 
     assertEquals("abab".indexOf("a", 1), sb.indexOf("a", 1)); 
     assertEquals(2, sb.indexOf("ab", 1)); 
     assertEquals("abab".indexOf("ab", 1), sb.indexOf("ab", 1)); 
     assertEquals(3, sb.indexOf("b", 2)); 
     assertEquals("abab".indexOf("b", 2), sb.indexOf("b", 2)); 
     assertEquals(1, sb.indexOf("ba", 1)); 
     assertEquals("abab".indexOf("ba", 2), sb.indexOf("ba", 2)); 
     assertEquals(-1, sb.indexOf("z", 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.indexOf("za", 0)); 
     assertEquals(-1, sb.indexOf("za", 3)); 
     assertEquals(-1, sb.indexOf((String) null, 2)); 
 } 
@Test 
 public void testAsWriter1572() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testDeleteCharAt1573() { 
     final StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.deleteCharAt(1000); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testStartsWith1576() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String1592() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testLang412Right1607() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testToStringBuffer1634() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(new StringBuffer().toString(), sb.toStringBuffer().toString()); 
     sb.append("junit"); 
     assertEquals(new StringBuffer("junit").toString(), sb.toStringBuffer().toString()); 
 } 
@Test 
 public void testChaining1653() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testChaining1671() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String1690() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testTrim1716() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String1724() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_String_String1775() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testChaining1786() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher1809() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String1823() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testAsReader1831() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testEqualsIgnoreCase1855() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testChaining1884() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testMinimizeCapacity1887() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     sb.append("HelloWorld"); 
     sb.minimizeCapacity(); 
     assertEquals(10, sb.capacity()); 
 } 
@Test 
 public void testToCharArrayIntInt1903() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testChaining1918() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testLastIndexOf_char1946() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf('a')); 
     assertEquals("abab".lastIndexOf('a'), sb.lastIndexOf('a')); 
     assertEquals(3, sb.lastIndexOf('b')); 
     assertEquals("abab".lastIndexOf('b'), sb.lastIndexOf('b')); 
     assertEquals(-1, sb.lastIndexOf('z')); 
 } 
@Test 
 public void testDeleteFirst_String1953() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("X"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("a"); 
     assertEquals("bcbccba", sb.toString()); 
     sb.deleteFirst("c"); 
     assertEquals("bbccba", sb.toString()); 
     sb.deleteFirst("b"); 
     assertEquals("bccba", sb.toString()); 
     sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst("bc"); 
     assertEquals("abccba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("bc"); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testIndexOf_StrMatcher1963() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testEqualsIgnoreCase1988() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testDeleteFirst_char2008() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst('X'); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst('a'); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst('c'); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst('b'); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_char_char2012() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String2033() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testAsReader2036() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String2042() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testAsTokenizer2068() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String2112() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLeftString2127() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left", sb.leftString(4)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher2143() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testAsReader2150() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testSubstringInt2152() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testChaining2159() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testEquals2180() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher2209() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testReverse2217() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 } 
@Test 
 public void testAsReader2223() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testLang412Right2228() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testLang412Right2242() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testTrim2256() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testReplaceFirst_String_String2273() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testAsWriter2274() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testSubSequenceIntInt2278() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testEndsWith2310() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testSubstringInt2319() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceAll_char_char2372() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("dececced", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defeffed", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defeffed", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String2387() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLang412Right2402() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testLang2942421() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String2435() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testAsReader2440() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testLang412Right2445() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testChaining2475() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testStartsWith2494() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testEndsWith2516() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testChaining2519() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testLeftString2536() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left", sb.leftString(4)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 } 
@Test 
 public void testGetChars2543() { 
     final StrBuilder sb = new StrBuilder(); 
     char[] input = new char[10]; 
     char[] a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[10], a)); 
     sb.append("junit"); 
     a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't', 0, 0, 0, 0, 0 }, a)); 
     a = sb.getChars(null); 
     assertNotSame(input, a); 
     assertEquals(5, a.length); 
     assertTrue(Arrays.equals("junit".toCharArray(), a)); 
     input = new char[5]; 
     a = sb.getChars(input); 
     assertSame(input, a); 
     input = new char[4]; 
     a = sb.getChars(input); 
     assertNotSame(input, a); 
 } 
@Test 
 public void testLastIndexOf_String2584() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testAsWriter2594() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testChaining2632() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testReplaceAll_char_char2643() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("dececced", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defeffed", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defeffed", sb.toString()); 
 } 
@Test 
 public void testEquals2659() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testSubstringInt2666() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testAsReader2672() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testChaining2677() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testIndexOf_StrMatcher2690() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testLang412Right2722() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testIndexOf_StrMatcher2726() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testConstructors2727() { 
     final StrBuilder sb0 = new StrBuilder(); 
     assertEquals(32, sb0.capacity()); 
     assertEquals(0, sb0.length()); 
     assertEquals(0, sb0.size()); 
     final StrBuilder sb1 = new StrBuilder(32); 
     assertEquals(32, sb1.capacity()); 
     assertEquals(0, sb1.length()); 
     assertEquals(0, sb1.size()); 
     final StrBuilder sb2 = new StrBuilder(0); 
     assertEquals(32, sb2.capacity()); 
     assertEquals(0, sb2.length()); 
     assertEquals(0, sb2.size()); 
     final StrBuilder sb3 = new StrBuilder(-1); 
     assertEquals(32, sb3.capacity()); 
     assertEquals(0, sb3.length()); 
     assertEquals(0, sb3.size()); 
     final StrBuilder sb4 = new StrBuilder(1); 
     assertEquals(1, sb4.capacity()); 
     assertEquals(0, sb4.length()); 
     assertEquals(0, sb4.size()); 
     final StrBuilder sb5 = new StrBuilder((String) null); 
     assertEquals(32, sb5.capacity()); 
     assertEquals(0, sb5.length()); 
     assertEquals(0, sb5.size()); 
     final StrBuilder sb6 = new StrBuilder(""); 
     assertEquals(32, sb6.capacity()); 
     assertEquals(0, sb6.length()); 
     assertEquals(0, sb6.size()); 
     final StrBuilder sb7 = new StrBuilder("foo"); 
     assertEquals(35, sb7.capacity()); 
     assertEquals(3, sb7.length()); 
     assertEquals(3, sb7.size()); 
 } 
@Test 
 public void testEquals2749() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testAsWriter2767() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testIndexOf_char_int2776() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf('a', -1)); 
     assertEquals(0, sb.indexOf('a', 0)); 
     assertEquals(2, sb.indexOf('a', 1)); 
     assertEquals(-1, sb.indexOf('a', 4)); 
     assertEquals(-1, sb.indexOf('a', 5)); 
     assertEquals("abab".indexOf('a', 1), sb.indexOf('a', 1)); 
     assertEquals(3, sb.indexOf('b', 2)); 
     assertEquals("abab".indexOf('b', 2), sb.indexOf('b', 2)); 
     assertEquals(-1, sb.indexOf('z', 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.indexOf('z', 0)); 
     assertEquals(-1, sb.indexOf('z', 3)); 
 } 
@Test 
 public void testAsWriter2794() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testDeleteFirst_char2797() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst('X'); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst('a'); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst('c'); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst('b'); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testChaining2803() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testReplaceFirst_String_String2887() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testEquals2905() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testAsWriter2917() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testGetSetNewLineText2918() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(null, sb.getNewLineText()); 
     sb.setNewLineText("#"); 
     assertEquals("#", sb.getNewLineText()); 
     sb.setNewLineText(""); 
     assertEquals("", sb.getNewLineText()); 
     sb.setNewLineText((String) null); 
     assertEquals(null, sb.getNewLineText()); 
 } 
@Test 
 public void testReplaceFirst_char_char2933() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher2957() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testChaining3018() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testGetSetNullText3039() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(null, sb.getNullText()); 
     sb.setNullText("null"); 
     assertEquals("null", sb.getNullText()); 
     sb.setNullText(""); 
     assertEquals(null, sb.getNullText()); 
     sb.setNullText("NULL"); 
     assertEquals("NULL", sb.getNullText()); 
     sb.setNullText((String) null); 
     assertEquals(null, sb.getNullText()); 
 } 
@Test 
 public void testMidString3083() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testAsBuilder3091() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 } 
@Test 
 public void testAsWriter3098() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testAsWriter3124() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String3128() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testAsWriter3170() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testSubstringInt3196() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String3223() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLeftString3230() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left", sb.leftString(4)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 } 
@Test 
 public void testLeftString3257() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left", sb.leftString(4)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String3259() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String3330() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLang2943345() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String3372() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testChaining3394() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testReplaceAll_char_char3434() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("dececced", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defeffed", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defeffed", sb.toString()); 
 } 
@Test 
 public void testDeleteAll_char3442() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testChaining3457() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testIsEmpty3470() { 
     final StrBuilder sb = new StrBuilder(); 
     assertTrue(sb.isEmpty()); 
     sb.append("Hello"); 
     assertFalse(sb.isEmpty()); 
     sb.clear(); 
     assertTrue(sb.isEmpty()); 
 } 
@Test 
 public void testSubstringInt3478() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testAsWriter3496() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testIndexOf_char3497() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf('a')); 
     assertEquals("abab".indexOf('a'), sb.indexOf('a')); 
     assertEquals(1, sb.indexOf('b')); 
     assertEquals("abab".indexOf('b'), sb.indexOf('b')); 
     assertEquals(-1, sb.indexOf('z')); 
 } 
@Test 
 public void testAsWriter3513() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String3542() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String3547() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLang412Right3567() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testAsReader3659() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testCharAt3677() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.charAt(0); 
         fail("charAt(0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     assertEquals('f', sb.charAt(0)); 
     assertEquals('o', sb.charAt(1)); 
     assertEquals('o', sb.charAt(2)); 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(3); 
         fail("charAt(3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testAsReader3690() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testAsReader3701() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testAsReader3716() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testDeleteFirst_String3721() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("X"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("a"); 
     assertEquals("bcbccba", sb.toString()); 
     sb.deleteFirst("c"); 
     assertEquals("bbccba", sb.toString()); 
     sb.deleteFirst("b"); 
     assertEquals("bccba", sb.toString()); 
     sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst("bc"); 
     assertEquals("abccba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("bc"); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsBuilder3732() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 } 
@Test 
 public void testEndsWith3754() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testIndexOf_StrMatcher3783() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testDeleteFirst_String3796() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("X"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("a"); 
     assertEquals("bcbccba", sb.toString()); 
     sb.deleteFirst("c"); 
     assertEquals("bbccba", sb.toString()); 
     sb.deleteFirst("b"); 
     assertEquals("bccba", sb.toString()); 
     sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst("bc"); 
     assertEquals("abccba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("bc"); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String3830() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testStartsWith3849() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testToCharArrayIntInt3856() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testLang412Right3893() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testContains_char3915() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains('a')); 
     assertTrue(sb.contains('o')); 
     assertTrue(sb.contains('z')); 
     assertFalse(sb.contains('1')); 
 } 
@Test 
 public void testMidString3935() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testTrim3960() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String3991() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLang412Right3995() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testAsWriter4009() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String4017() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testReplace_StrMatcher_String_int_int_int_VaryCount4034() { 
     StrBuilder sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, -1); 
     assertEquals("-x--y-", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, 0); 
     assertEquals("aaxaaaayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, 1); 
     assertEquals("-xaaaayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, 2); 
     assertEquals("-x-aayaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, 3); 
     assertEquals("-x--yaa", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, 4); 
     assertEquals("-x--y-", sb.toString()); 
     sb = new StrBuilder("aaxaaaayaa"); 
     sb.replace(StrMatcher.stringMatcher("aa"), "-", 0, 10, 5); 
     assertEquals("-x--y-", sb.toString()); 
 } 
@Test 
 public void testEqualsIgnoreCase4045() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testAsTokenizer4068() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testSubstringInt4070() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String4100() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testEqualsIgnoreCase4106() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testToStringBuffer4112() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(new StringBuffer().toString(), sb.toStringBuffer().toString()); 
     sb.append("junit"); 
     assertEquals(new StringBuffer("junit").toString(), sb.toStringBuffer().toString()); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher4149() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testAsWriter4159() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String4174() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testAsWriter4182() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String4186() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testAsTokenizer4194() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testDeleteAll_char4201() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsReader4249() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testSubstringInt4293() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testIndexOf_StrMatcher4374() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testAsReader4399() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testChaining4404() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testEqualsIgnoreCase4406() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testIndexOf_String_int4407() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf("a", -1)); 
     assertEquals(0, sb.indexOf("a", 0)); 
     assertEquals(2, sb.indexOf("a", 1)); 
     assertEquals(2, sb.indexOf("a", 2)); 
     assertEquals(-1, sb.indexOf("a", 3)); 
     assertEquals(-1, sb.indexOf("a", 4)); 
     assertEquals(-1, sb.indexOf("a", 5)); 
     assertEquals(-1, sb.indexOf("abcdef", 0)); 
     assertEquals(0, sb.indexOf("", 0)); 
     assertEquals(1, sb.indexOf("", 1)); 
     assertEquals("abab".indexOf("a", 1), sb.indexOf("a", 1)); 
     assertEquals(2, sb.indexOf("ab", 1)); 
     assertEquals("abab".indexOf("ab", 1), sb.indexOf("ab", 1)); 
     assertEquals(3, sb.indexOf("b", 2)); 
     assertEquals("abab".indexOf("b", 2), sb.indexOf("b", 2)); 
     assertEquals(1, sb.indexOf("ba", 1)); 
     assertEquals("abab".indexOf("ba", 2), sb.indexOf("ba", 2)); 
     assertEquals(-1, sb.indexOf("z", 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.indexOf("za", 0)); 
     assertEquals(-1, sb.indexOf("za", 3)); 
     assertEquals(-1, sb.indexOf((String) null, 2)); 
 } 
@Test 
 public void testAsWriter4409() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testAsReader4440() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testStartsWith4442() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testAsReader4445() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testSubSequenceIntInt4450() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testChaining4470() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testMinimizeCapacity4473() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     sb.append("HelloWorld"); 
     sb.minimizeCapacity(); 
     assertEquals(10, sb.capacity()); 
 } 
@Test 
 public void testRightString4478() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 } 
@Test 
 public void testChaining4483() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testLastIndexOf_String4486() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testIndexOf_StrMatcher4506() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testLang412Right4510() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testRightString4515() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 } 
@Test 
 public void testDeleteFirst_String4562() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("X"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("a"); 
     assertEquals("bcbccba", sb.toString()); 
     sb.deleteFirst("c"); 
     assertEquals("bbccba", sb.toString()); 
     sb.deleteFirst("b"); 
     assertEquals("bccba", sb.toString()); 
     sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst("bc"); 
     assertEquals("abccba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("bc"); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsReader4567() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testEqualsIgnoreCase4578() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testEquals4592() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testToCharArrayIntInt4613() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testLastIndexOf_StrMatcher4648() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testAsReader4665() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testChaining4675() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testContains_char4750() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains('a')); 
     assertTrue(sb.contains('o')); 
     assertTrue(sb.contains('z')); 
     assertFalse(sb.contains('1')); 
 } 
@Test 
 public void testEquals4776() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testLastIndexOf_String4780() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testConstructors4788() { 
     final StrBuilder sb0 = new StrBuilder(); 
     assertEquals(32, sb0.capacity()); 
     assertEquals(0, sb0.length()); 
     assertEquals(0, sb0.size()); 
     final StrBuilder sb1 = new StrBuilder(32); 
     assertEquals(32, sb1.capacity()); 
     assertEquals(0, sb1.length()); 
     assertEquals(0, sb1.size()); 
     final StrBuilder sb2 = new StrBuilder(0); 
     assertEquals(32, sb2.capacity()); 
     assertEquals(0, sb2.length()); 
     assertEquals(0, sb2.size()); 
     final StrBuilder sb3 = new StrBuilder(-1); 
     assertEquals(32, sb3.capacity()); 
     assertEquals(0, sb3.length()); 
     assertEquals(0, sb3.size()); 
     final StrBuilder sb4 = new StrBuilder(1); 
     assertEquals(1, sb4.capacity()); 
     assertEquals(0, sb4.length()); 
     assertEquals(0, sb4.size()); 
     final StrBuilder sb5 = new StrBuilder((String) null); 
     assertEquals(32, sb5.capacity()); 
     assertEquals(0, sb5.length()); 
     assertEquals(0, sb5.size()); 
     final StrBuilder sb6 = new StrBuilder(""); 
     assertEquals(32, sb6.capacity()); 
     assertEquals(0, sb6.length()); 
     assertEquals(0, sb6.size()); 
     final StrBuilder sb7 = new StrBuilder("foo"); 
     assertEquals(35, sb7.capacity()); 
     assertEquals(3, sb7.length()); 
     assertEquals(3, sb7.size()); 
 } 
@Test 
 public void testIndexOf_StrMatcher4835() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testChaining4850() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testDeleteCharAt4851() { 
     final StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.deleteCharAt(1000); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testEqualsIgnoreCase4879() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testEquals4918() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testMidString4928() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testAsReader4939() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testSubstringInt4986() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplace_int_int_String4991() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace(0, 1, "d"); 
     assertEquals("dbc", sb.toString()); 
     sb.replace(0, 1, "aaa"); 
     assertEquals("aaabc", sb.toString()); 
     sb.replace(0, 3, ""); 
     assertEquals("bc", sb.toString()); 
     sb.replace(1, 2, (String) null); 
     assertEquals("b", sb.toString()); 
     sb.replace(1, 1000, "text"); 
     assertEquals("btext", sb.toString()); 
     sb.replace(0, 1000, "text"); 
     assertEquals("text", sb.toString()); 
     sb = new StrBuilder("atext"); 
     sb.replace(1, 1, "ny"); 
     assertEquals("anytext", sb.toString()); 
     try { 
         sb.replace(2, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder(); 
     try { 
         sb.replace(1, 2, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.replace(-1, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testEquals5066() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testLang412Right5088() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testDeleteAll_char5094() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsWriter5100() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testLang412Right5119() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testDeleteAll_StrMatcher5139() { 
     StrBuilder sb = new StrBuilder("A0xA1A2yA3"); 
     sb.deleteAll((StrMatcher) null); 
     assertEquals("A0xA1A2yA3", sb.toString()); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("xy", sb.toString()); 
     sb = new StrBuilder("Ax1"); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("Ax1", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll(A_NUMBER_MATCHER); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testStartsWith5147() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testAsBuilder5157() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 } 
@Test 
 public void testMinimizeCapacity5162() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     sb.append("HelloWorld"); 
     sb.minimizeCapacity(); 
     assertEquals(10, sb.capacity()); 
 } 
@Test 
 public void testChaining5171() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testToCharArray5172() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     char[] a = sb.toCharArray(); 
     assertNotNull("toCharArray() result is null", a); 
     assertEquals("toCharArray() result is too large", 0, a.length); 
     sb.append("junit"); 
     a = sb.toCharArray(); 
     assertEquals("toCharArray() result incorrect length", 5, a.length); 
     assertTrue("toCharArray() result does not match", Arrays.equals("junit".toCharArray(), a)); 
 } 
@Test 
 public void testHashCode5189() { 
     final StrBuilder sb = new StrBuilder(); 
     final int hc1a = sb.hashCode(); 
     final int hc1b = sb.hashCode(); 
     assertEquals(0, hc1a); 
     assertEquals(hc1a, hc1b); 
     sb.append("abc"); 
     final int hc2a = sb.hashCode(); 
     final int hc2b = sb.hashCode(); 
     assertTrue(hc2a != 0); 
     assertEquals(hc2a, hc2b); 
 } 
@Test 
 public void testAsWriter5217() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testIndexOf_StrMatcher5236() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testLang412Right5281() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testDeleteFirst_char5297() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst('X'); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst('a'); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst('c'); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst('b'); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testSubstringInt5334() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testIndexOf_String5356() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf("a")); 
     assertEquals("abab".indexOf("a"), sb.indexOf("a")); 
     assertEquals(0, sb.indexOf("ab")); 
     assertEquals("abab".indexOf("ab"), sb.indexOf("ab")); 
     assertEquals(1, sb.indexOf("b")); 
     assertEquals("abab".indexOf("b"), sb.indexOf("b")); 
     assertEquals(1, sb.indexOf("ba")); 
     assertEquals("abab".indexOf("ba"), sb.indexOf("ba")); 
     assertEquals(-1, sb.indexOf("z")); 
     assertEquals(-1, sb.indexOf((String) null)); 
 } 
@Test 
 public void testDeleteAll_char5373() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String5377() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testContains_String5391() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains("a")); 
     assertTrue(sb.contains("pq")); 
     assertTrue(sb.contains("z")); 
     assertFalse(sb.contains("zyx")); 
     assertFalse(sb.contains((String) null)); 
 } 
@Test 
 public void testIndexOf_StrMatcher5397() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testDeleteFirst_char5424() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst('X'); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst('a'); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst('c'); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst('b'); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testConstructors5434() { 
     final StrBuilder sb0 = new StrBuilder(); 
     assertEquals(32, sb0.capacity()); 
     assertEquals(0, sb0.length()); 
     assertEquals(0, sb0.size()); 
     final StrBuilder sb1 = new StrBuilder(32); 
     assertEquals(32, sb1.capacity()); 
     assertEquals(0, sb1.length()); 
     assertEquals(0, sb1.size()); 
     final StrBuilder sb2 = new StrBuilder(0); 
     assertEquals(32, sb2.capacity()); 
     assertEquals(0, sb2.length()); 
     assertEquals(0, sb2.size()); 
     final StrBuilder sb3 = new StrBuilder(-1); 
     assertEquals(32, sb3.capacity()); 
     assertEquals(0, sb3.length()); 
     assertEquals(0, sb3.size()); 
     final StrBuilder sb4 = new StrBuilder(1); 
     assertEquals(1, sb4.capacity()); 
     assertEquals(0, sb4.length()); 
     assertEquals(0, sb4.size()); 
     final StrBuilder sb5 = new StrBuilder((String) null); 
     assertEquals(32, sb5.capacity()); 
     assertEquals(0, sb5.length()); 
     assertEquals(0, sb5.size()); 
     final StrBuilder sb6 = new StrBuilder(""); 
     assertEquals(32, sb6.capacity()); 
     assertEquals(0, sb6.length()); 
     assertEquals(0, sb6.size()); 
     final StrBuilder sb7 = new StrBuilder("foo"); 
     assertEquals(35, sb7.capacity()); 
     assertEquals(3, sb7.length()); 
     assertEquals(3, sb7.size()); 
 } 
@Test 
 public void testEndsWith5435() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testMidString5438() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testSubstringInt5450() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testLang412Right5465() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testChaining5517() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testTrim5527() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testIndexOf_StrMatcher5533() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testAsWriter5556() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testSubSequenceIntInt5594() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String5597() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testSubstringInt5607() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceAll_char_char5623() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("dececced", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defeffed", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defeffed", sb.toString()); 
 } 
@Test 
 public void testAsReader5624() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String5644() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testGetChars5664() { 
     final StrBuilder sb = new StrBuilder(); 
     char[] input = new char[10]; 
     char[] a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[10], a)); 
     sb.append("junit"); 
     a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't', 0, 0, 0, 0, 0 }, a)); 
     a = sb.getChars(null); 
     assertNotSame(input, a); 
     assertEquals(5, a.length); 
     assertTrue(Arrays.equals("junit".toCharArray(), a)); 
     input = new char[5]; 
     a = sb.getChars(input); 
     assertSame(input, a); 
     input = new char[4]; 
     a = sb.getChars(input); 
     assertNotSame(input, a); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String5665() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testReplaceAll_char_char5670() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("dececced", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defeffed", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defeffed", sb.toString()); 
 } 
@Test 
 public void testAsWriter5710() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testTrim5712() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String5740() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String5797() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testAsWriter5802() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testDeleteAll_char5814() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testReplaceAll_char_char5835() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll('a', 'd'); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll('b', 'e'); 
     assertEquals("dececced", sb.toString()); 
     sb.replaceAll('c', 'f'); 
     assertEquals("defeffed", sb.toString()); 
     sb.replaceAll('d', 'd'); 
     assertEquals("defeffed", sb.toString()); 
 } 
@Test 
 public void testHashCode5870() { 
     final StrBuilder sb = new StrBuilder(); 
     final int hc1a = sb.hashCode(); 
     final int hc1b = sb.hashCode(); 
     assertEquals(0, hc1a); 
     assertEquals(hc1a, hc1b); 
     sb.append("abc"); 
     final int hc2a = sb.hashCode(); 
     final int hc2b = sb.hashCode(); 
     assertTrue(hc2a != 0); 
     assertEquals(hc2a, hc2b); 
 } 
@Test 
 public void testSubstringInt5902() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testIndexOf_String5925() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf("a")); 
     assertEquals("abab".indexOf("a"), sb.indexOf("a")); 
     assertEquals(0, sb.indexOf("ab")); 
     assertEquals("abab".indexOf("ab"), sb.indexOf("ab")); 
     assertEquals(1, sb.indexOf("b")); 
     assertEquals("abab".indexOf("b"), sb.indexOf("b")); 
     assertEquals(1, sb.indexOf("ba")); 
     assertEquals("abab".indexOf("ba"), sb.indexOf("ba")); 
     assertEquals(-1, sb.indexOf("z")); 
     assertEquals(-1, sb.indexOf((String) null)); 
 } 
@Test 
 public void testTrim5926() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testLang412Right5931() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testAsReader5955() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String5960() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testAsWriter6002() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testAsTokenizer6010() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testChaining6059() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String6089() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String6102() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testToCharArray6120() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     char[] a = sb.toCharArray(); 
     assertNotNull("toCharArray() result is null", a); 
     assertEquals("toCharArray() result is too large", 0, a.length); 
     sb.append("junit"); 
     a = sb.toCharArray(); 
     assertEquals("toCharArray() result incorrect length", 5, a.length); 
     assertTrue("toCharArray() result does not match", Arrays.equals("junit".toCharArray(), a)); 
 } 
@Test 
 public void testSubSequenceIntInt6126() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testGetSetNewLineText6137() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(null, sb.getNewLineText()); 
     sb.setNewLineText("#"); 
     assertEquals("#", sb.getNewLineText()); 
     sb.setNewLineText(""); 
     assertEquals("", sb.getNewLineText()); 
     sb.setNewLineText((String) null); 
     assertEquals(null, sb.getNewLineText()); 
 } 
@Test 
 public void testToCharArray6157() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray()); 
     char[] a = sb.toCharArray(); 
     assertNotNull("toCharArray() result is null", a); 
     assertEquals("toCharArray() result is too large", 0, a.length); 
     sb.append("junit"); 
     a = sb.toCharArray(); 
     assertEquals("toCharArray() result incorrect length", 5, a.length); 
     assertTrue("toCharArray() result does not match", Arrays.equals("junit".toCharArray(), a)); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher6171() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testEquals6187() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testLang412Right6193() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testAsReader6213() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testSubSequenceIntInt6231() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testLang412Right6252() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testAsWriter6279() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testDeleteFirst_String6283() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("X"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("a"); 
     assertEquals("bcbccba", sb.toString()); 
     sb.deleteFirst("c"); 
     assertEquals("bbccba", sb.toString()); 
     sb.deleteFirst("b"); 
     assertEquals("bccba", sb.toString()); 
     sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst("bc"); 
     assertEquals("abccba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("bc"); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsWriter6307() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testIndexOf_StrMatcher6321() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testLastIndexOf_StrMatcher6333() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testChaining6338() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testIndexOf_StrMatcher6365() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     assertEquals(-1, sb.indexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.indexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(1, sb.indexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.indexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.indexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.indexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.indexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.indexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testLastIndexOf_String6367() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testAsTokenizer6396() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testAsReader6428() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testLastIndexOf_String6434() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testAsBuilder6447() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 } 
@Test 
 public void testSubstringInt6470() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testTrim6496() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testReplaceFirst_String_String6505() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testConstructors6525() { 
     final StrBuilder sb0 = new StrBuilder(); 
     assertEquals(32, sb0.capacity()); 
     assertEquals(0, sb0.length()); 
     assertEquals(0, sb0.size()); 
     final StrBuilder sb1 = new StrBuilder(32); 
     assertEquals(32, sb1.capacity()); 
     assertEquals(0, sb1.length()); 
     assertEquals(0, sb1.size()); 
     final StrBuilder sb2 = new StrBuilder(0); 
     assertEquals(32, sb2.capacity()); 
     assertEquals(0, sb2.length()); 
     assertEquals(0, sb2.size()); 
     final StrBuilder sb3 = new StrBuilder(-1); 
     assertEquals(32, sb3.capacity()); 
     assertEquals(0, sb3.length()); 
     assertEquals(0, sb3.size()); 
     final StrBuilder sb4 = new StrBuilder(1); 
     assertEquals(1, sb4.capacity()); 
     assertEquals(0, sb4.length()); 
     assertEquals(0, sb4.size()); 
     final StrBuilder sb5 = new StrBuilder((String) null); 
     assertEquals(32, sb5.capacity()); 
     assertEquals(0, sb5.length()); 
     assertEquals(0, sb5.size()); 
     final StrBuilder sb6 = new StrBuilder(""); 
     assertEquals(32, sb6.capacity()); 
     assertEquals(0, sb6.length()); 
     assertEquals(0, sb6.size()); 
     final StrBuilder sb7 = new StrBuilder("foo"); 
     assertEquals(35, sb7.capacity()); 
     assertEquals(3, sb7.length()); 
     assertEquals(3, sb7.size()); 
 } 
@Test 
 public void testEqualsIgnoreCase6536() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testLastIndexOf_String6544() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String6570() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testContains_char6620() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains('a')); 
     assertTrue(sb.contains('o')); 
     assertTrue(sb.contains('z')); 
     assertFalse(sb.contains('1')); 
 } 
@Test 
 public void testMinimizeCapacity6622() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     sb.append("HelloWorld"); 
     sb.minimizeCapacity(); 
     assertEquals(10, sb.capacity()); 
 } 
@Test 
 public void testChaining6633() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testChaining6648() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testAsBuilder6720() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 } 
@Test 
 public void testReverse6731() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 } 
@Test 
 public void testLang2946744() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testTrim6753() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testReplaceFirst_char_char6760() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 } 
@Test 
 public void testLang412Right6855() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testAsWriter6884() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testLang412Right6889() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_char6901() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf('a')); 
     assertEquals("abab".lastIndexOf('a'), sb.lastIndexOf('a')); 
     assertEquals(3, sb.lastIndexOf('b')); 
     assertEquals("abab".lastIndexOf('b'), sb.lastIndexOf('b')); 
     assertEquals(-1, sb.lastIndexOf('z')); 
 } 
@Test 
 public void testToCharArrayIntInt6914() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testLastIndexOf_StrMatcher6924() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     sb.append("ab bd"); 
     assertEquals(0, sb.lastIndexOf(StrMatcher.charMatcher('a'))); 
     assertEquals(3, sb.lastIndexOf(StrMatcher.charMatcher('b'))); 
     assertEquals(2, sb.lastIndexOf(StrMatcher.spaceMatcher())); 
     assertEquals(4, sb.lastIndexOf(StrMatcher.charMatcher('d'))); 
     assertEquals(-1, sb.lastIndexOf(StrMatcher.noneMatcher())); 
     assertEquals(-1, sb.lastIndexOf((StrMatcher) null)); 
     sb.append(" A1 junction"); 
     assertEquals(6, sb.lastIndexOf(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String6930() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testAsWriter6982() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String6995() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testEndsWith7022() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testToCharArrayIntInt7044() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testHashCode7063() { 
     final StrBuilder sb = new StrBuilder(); 
     final int hc1a = sb.hashCode(); 
     final int hc1b = sb.hashCode(); 
     assertEquals(0, hc1a); 
     assertEquals(hc1a, hc1b); 
     sb.append("abc"); 
     final int hc2a = sb.hashCode(); 
     final int hc2b = sb.hashCode(); 
     assertTrue(hc2a != 0); 
     assertEquals(hc2a, hc2b); 
 } 
@Test 
 public void testChaining7087() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testDeleteAll_char7088() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testDeleteCharAt7091() { 
     final StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.deleteCharAt(1000); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String7098() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String7127() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testHashCode7146() { 
     final StrBuilder sb = new StrBuilder(); 
     final int hc1a = sb.hashCode(); 
     final int hc1b = sb.hashCode(); 
     assertEquals(0, hc1a); 
     assertEquals(hc1a, hc1b); 
     sb.append("abc"); 
     final int hc2a = sb.hashCode(); 
     final int hc2b = sb.hashCode(); 
     assertTrue(hc2a != 0); 
     assertEquals(hc2a, hc2b); 
 } 
@Test 
 public void testEndsWith7172() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testAsReader7176() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testLang412Right7239() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testReplace_int_int_String7243() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace(0, 1, "d"); 
     assertEquals("dbc", sb.toString()); 
     sb.replace(0, 1, "aaa"); 
     assertEquals("aaabc", sb.toString()); 
     sb.replace(0, 3, ""); 
     assertEquals("bc", sb.toString()); 
     sb.replace(1, 2, (String) null); 
     assertEquals("b", sb.toString()); 
     sb.replace(1, 1000, "text"); 
     assertEquals("btext", sb.toString()); 
     sb.replace(0, 1000, "text"); 
     assertEquals("text", sb.toString()); 
     sb = new StrBuilder("atext"); 
     sb.replace(1, 1, "ny"); 
     assertEquals("anytext", sb.toString()); 
     try { 
         sb.replace(2, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder(); 
     try { 
         sb.replace(1, 2, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.replace(-1, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testAsWriter7244() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testMidString7268() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testAsWriter7280() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testHashCode7303() { 
     final StrBuilder sb = new StrBuilder(); 
     final int hc1a = sb.hashCode(); 
     final int hc1b = sb.hashCode(); 
     assertEquals(0, hc1a); 
     assertEquals(hc1a, hc1b); 
     sb.append("abc"); 
     final int hc2a = sb.hashCode(); 
     final int hc2b = sb.hashCode(); 
     assertTrue(hc2a != 0); 
     assertEquals(hc2a, hc2b); 
 } 
@Test 
 public void testLastIndexOf_String7305() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testGetChars7334() { 
     final StrBuilder sb = new StrBuilder(); 
     char[] input = new char[10]; 
     char[] a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[10], a)); 
     sb.append("junit"); 
     a = sb.getChars(input); 
     assertSame(input, a); 
     assertTrue(Arrays.equals(new char[] { 'j', 'u', 'n', 'i', 't', 0, 0, 0, 0, 0 }, a)); 
     a = sb.getChars(null); 
     assertNotSame(input, a); 
     assertEquals(5, a.length); 
     assertTrue(Arrays.equals("junit".toCharArray(), a)); 
     input = new char[5]; 
     a = sb.getChars(input); 
     assertSame(input, a); 
     input = new char[4]; 
     a = sb.getChars(input); 
     assertNotSame(input, a); 
 } 
@Test 
 public void testLastIndexOf_char_int7376() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(-1, sb.lastIndexOf('a', -1)); 
     assertEquals(0, sb.lastIndexOf('a', 0)); 
     assertEquals(0, sb.lastIndexOf('a', 1)); 
     assertEquals("abab".lastIndexOf('a', 1), sb.lastIndexOf('a', 1)); 
     assertEquals(1, sb.lastIndexOf('b', 2)); 
     assertEquals("abab".lastIndexOf('b', 2), sb.lastIndexOf('b', 2)); 
     assertEquals(-1, sb.lastIndexOf('z', 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.lastIndexOf('z', sb.length())); 
     assertEquals(-1, sb.lastIndexOf('z', 1)); 
 } 
@Test 
 public void testChaining7384() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testReplaceFirst_String_String7406() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testAsWriter7440() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testDeleteCharAt7455() { 
     final StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.deleteCharAt(1000); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testDeleteFirst_char7458() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst('X'); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst('a'); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst('c'); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst('b'); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testEquals7472() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testAsWriter7500() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testLastIndexOf_String7503() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testChaining7504() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testAsWriter7509() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testCharAt7554() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.charAt(0); 
         fail("charAt(0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     assertEquals('f', sb.charAt(0)); 
     assertEquals('o', sb.charAt(1)); 
     assertEquals('o', sb.charAt(2)); 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(3); 
         fail("charAt(3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testEqualsIgnoreCase7564() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testEquals7568() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testRightString7576() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("right", sb.rightString(5)); 
     assertEquals("", sb.rightString(0)); 
     assertEquals("", sb.rightString(-5)); 
     assertEquals("left right", sb.rightString(15)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String7577() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testChaining7591() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testTrim7622() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testDeleteFirst_String7645() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst((String) null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst(""); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("X"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteFirst("a"); 
     assertEquals("bcbccba", sb.toString()); 
     sb.deleteFirst("c"); 
     assertEquals("bbccba", sb.toString()); 
     sb.deleteFirst("b"); 
     assertEquals("bccba", sb.toString()); 
     sb = new StrBuilder("abcbccba"); 
     sb.deleteFirst("bc"); 
     assertEquals("abccba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst("bc"); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String7670() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testSubstringInt7683() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testDeleteAll_char7692() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testLang412Right7745() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testEndsWith7747() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testMidString7754() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testMidString7758() { 
     final StrBuilder sb = new StrBuilder("hello goodbye hello"); 
     assertEquals("goodbye", sb.midString(6, 7)); 
     assertEquals("hello", sb.midString(0, 5)); 
     assertEquals("hello", sb.midString(-5, 5)); 
     assertEquals("", sb.midString(0, -1)); 
     assertEquals("", sb.midString(20, 2)); 
     assertEquals("hello", sb.midString(14, 22)); 
 } 
@Test 
 public void testEndsWith7789() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testReplaceFirst_char_char7791() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 } 
@Test 
 public void testEndsWith7815() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testStartsWith7831() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testDeleteAll_char7844() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testDeleteFirst_char7890() { 
     StrBuilder sb = new StrBuilder("abcba"); 
     sb.deleteFirst('X'); 
     assertEquals("abcba", sb.toString()); 
     sb.deleteFirst('a'); 
     assertEquals("bcba", sb.toString()); 
     sb.deleteFirst('c'); 
     assertEquals("bba", sb.toString()); 
     sb.deleteFirst('b'); 
     assertEquals("ba", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testDeleteCharAt8008() { 
     final StrBuilder sb = new StrBuilder("abc"); 
     sb.deleteCharAt(0); 
     assertEquals("bc", sb.toString()); 
     try { 
         sb.deleteCharAt(1000); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testLang2948048() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testDeleteAll_char8085() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testCharAt8086() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.charAt(0); 
         fail("charAt(0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     assertEquals('f', sb.charAt(0)); 
     assertEquals('o', sb.charAt(1)); 
     assertEquals('o', sb.charAt(2)); 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(3); 
         fail("charAt(3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String8102() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testChaining8111() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testToCharArrayIntInt8122() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(ArrayUtils.EMPTY_CHAR_ARRAY, sb.toCharArray(0, 0)); 
     sb.append("junit"); 
     char[] a = sb.toCharArray(0, 20); 
     assertEquals("toCharArray(int,int) result incorrect length", 5, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("junit".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 4); 
     assertEquals("toCharArray(int,int) result incorrect length", 4, a.length); 
     assertTrue("toCharArray(int,int) result does not match", Arrays.equals("juni".toCharArray(), a)); 
     a = sb.toCharArray(0, 1); 
     assertNotNull("toCharArray(int,int) result is null", a); 
     try { 
         sb.toCharArray(-1, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.toCharArray(6, 5); 
         fail("no string index out of bound on -1"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testAsReader8128() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testSubstringInt8158() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String8209() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testDeleteAll_char8218() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.deleteAll('X'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.deleteAll('a'); 
     assertEquals("bcbccb", sb.toString()); 
     sb.deleteAll('c'); 
     assertEquals("bbb", sb.toString()); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteAll('b'); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testDeleteFirst_StrMatcher8232() { 
     StrBuilder sb = new StrBuilder("A0xA1A2yA3"); 
     sb.deleteFirst((StrMatcher) null); 
     assertEquals("A0xA1A2yA3", sb.toString()); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("xA1A2yA3", sb.toString()); 
     sb = new StrBuilder("Ax1"); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("Ax1", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_char_char8247() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 } 
@Test 
 public void testAsReader8251() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testTrim8259() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testLastIndexOf_String8262() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testDeleteFirst_StrMatcher8267() { 
     StrBuilder sb = new StrBuilder("A0xA1A2yA3"); 
     sb.deleteFirst((StrMatcher) null); 
     assertEquals("A0xA1A2yA3", sb.toString()); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("xA1A2yA3", sb.toString()); 
     sb = new StrBuilder("Ax1"); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("Ax1", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("", sb.toString()); 
 } 
@Test 
 public void testAsBuilder8276() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 } 
@Test 
 public void testReplace_int_int_String8277() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace(0, 1, "d"); 
     assertEquals("dbc", sb.toString()); 
     sb.replace(0, 1, "aaa"); 
     assertEquals("aaabc", sb.toString()); 
     sb.replace(0, 3, ""); 
     assertEquals("bc", sb.toString()); 
     sb.replace(1, 2, (String) null); 
     assertEquals("b", sb.toString()); 
     sb.replace(1, 1000, "text"); 
     assertEquals("btext", sb.toString()); 
     sb.replace(0, 1000, "text"); 
     assertEquals("text", sb.toString()); 
     sb = new StrBuilder("atext"); 
     sb.replace(1, 1, "ny"); 
     assertEquals("anytext", sb.toString()); 
     try { 
         sb.replace(2, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder(); 
     try { 
         sb.replace(1, 2, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.replace(-1, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testSetCharAt8304() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.setCharAt(0, 'f'); 
         fail("setCharAt(0,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.setCharAt(-1, 'f'); 
         fail("setCharAt(-1,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     sb.setCharAt(0, 'b'); 
     sb.setCharAt(1, 'a'); 
     sb.setCharAt(2, 'r'); 
     try { 
         sb.setCharAt(3, '!'); 
         fail("setCharAt(3,) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("bar", sb.toString()); 
 } 
@Test 
 public void testTrim8313() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testLang412Right8317() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testLang412Right8326() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testAsWriter8337() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testAsBuilder8373() { 
     final StrBuilder sb = new StrBuilder().appendAll("Lorem", " ", "ipsum", " ", "dolor"); 
     assertEquals(sb.toString(), sb.build()); 
 } 
@Test 
 public void testReplaceFirst_String_String8384() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testReplaceFirst_String_String8408() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((String) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((String) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("", "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("x", "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst("a", "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst("d", null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst("cb", "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst("b", "xbx"); 
     assertEquals("xbxb", sb.toString()); 
 } 
@Test 
 public void testTrim8431() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testAsReader8446() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testIndexOf_char8493() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(0, sb.indexOf('a')); 
     assertEquals("abab".indexOf('a'), sb.indexOf('a')); 
     assertEquals(1, sb.indexOf('b')); 
     assertEquals("abab".indexOf('b'), sb.indexOf('b')); 
     assertEquals(-1, sb.indexOf('z')); 
 } 
@Test 
 public void testLastIndexOf_String8499() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testLang2948500() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testContains_String8534() { 
     final StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains("a")); 
     assertTrue(sb.contains("pq")); 
     assertTrue(sb.contains("z")); 
     assertFalse(sb.contains("zyx")); 
     assertFalse(sb.contains((String) null)); 
 } 
@Test 
 public void testAsReader8570() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testStartsWith8572() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testAsReader8585() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String8599() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testAsReader8608() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String8640() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testAsWriter8648() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testSubstringInt8651() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6)); 
     assertEquals("hello goodbye".substring(6), sb.substring(6)); 
     assertEquals("hello goodbye", sb.substring(0)); 
     assertEquals("hello goodbye".substring(0), sb.substring(0)); 
     try { 
         sb.substring(-1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testLang2948654() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testEquals8665() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals(sb1)); 
     assertTrue(sb2.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.append("ABC"); 
     assertFalse(sb1.equals(sb2)); 
     assertFalse(sb1.equals((Object) sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equals(sb2)); 
     assertTrue(sb1.equals((Object) sb2)); 
     assertFalse(sb1.equals(Integer.valueOf(1))); 
     assertFalse(sb1.equals("abc")); 
 } 
@Test 
 public void testAsReader8691() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testEqualsIgnoreCase8721() { 
     final StrBuilder sb1 = new StrBuilder(); 
     final StrBuilder sb2 = new StrBuilder(); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb1.append("abc"); 
     assertFalse(sb1.equalsIgnoreCase(sb2)); 
     sb2.append("ABC"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     sb2.clear().append("abc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
     assertTrue(sb1.equalsIgnoreCase(sb1)); 
     assertTrue(sb2.equalsIgnoreCase(sb2)); 
     sb2.clear().append("aBc"); 
     assertTrue(sb1.equalsIgnoreCase(sb2)); 
 } 
@Test 
 public void testLang412Right8725() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testChaining8749() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testLastIndexOf_String8772() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testTrim8789() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 } 
@Test 
 public void testLastIndexOf_String8843() { 
     final StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(2, sb.lastIndexOf("a")); 
     assertEquals("abab".lastIndexOf("a"), sb.lastIndexOf("a")); 
     assertEquals(2, sb.lastIndexOf("ab")); 
     assertEquals("abab".lastIndexOf("ab"), sb.lastIndexOf("ab")); 
     assertEquals(3, sb.lastIndexOf("b")); 
     assertEquals("abab".lastIndexOf("b"), sb.lastIndexOf("b")); 
     assertEquals(1, sb.lastIndexOf("ba")); 
     assertEquals("abab".lastIndexOf("ba"), sb.lastIndexOf("ba")); 
     assertEquals(-1, sb.lastIndexOf("z")); 
     assertEquals(-1, sb.lastIndexOf((String) null)); 
 } 
@Test 
 public void testReplace_int_int_String8845() { 
     StrBuilder sb = new StrBuilder("abc"); 
     sb.replace(0, 1, "d"); 
     assertEquals("dbc", sb.toString()); 
     sb.replace(0, 1, "aaa"); 
     assertEquals("aaabc", sb.toString()); 
     sb.replace(0, 3, ""); 
     assertEquals("bc", sb.toString()); 
     sb.replace(1, 2, (String) null); 
     assertEquals("b", sb.toString()); 
     sb.replace(1, 1000, "text"); 
     assertEquals("btext", sb.toString()); 
     sb.replace(0, 1000, "text"); 
     assertEquals("text", sb.toString()); 
     sb = new StrBuilder("atext"); 
     sb.replace(1, 1, "ny"); 
     assertEquals("anytext", sb.toString()); 
     try { 
         sb.replace(2, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb = new StrBuilder(); 
     try { 
         sb.replace(1, 2, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.replace(-1, 1, "anything"); 
         fail("Expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testChaining8858() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testMinimizeCapacity8870() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     sb.append("HelloWorld"); 
     sb.minimizeCapacity(); 
     assertEquals(10, sb.capacity()); 
 } 
@Test 
 public void testAsWriter8932() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testAsReader8985() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String8986() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testAsTokenizer9041() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 } 
@Test 
 public void testContains_StrMatcher9050() { 
     StrBuilder sb = new StrBuilder("abcdefghijklmnopqrstuvwxyz"); 
     assertTrue(sb.contains(StrMatcher.charMatcher('a'))); 
     assertTrue(sb.contains(StrMatcher.stringMatcher("pq"))); 
     assertTrue(sb.contains(StrMatcher.charMatcher('z'))); 
     assertFalse(sb.contains(StrMatcher.stringMatcher("zy"))); 
     assertFalse(sb.contains((StrMatcher) null)); 
     sb = new StrBuilder(); 
     assertFalse(sb.contains(A_NUMBER_MATCHER)); 
     sb.append("B A1 C"); 
     assertTrue(sb.contains(A_NUMBER_MATCHER)); 
 } 
@Test 
 public void testSubSequenceIntInt9082() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testSubSequenceIntInt9106() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     try { 
         sb.subSequence(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(2, sb.length() + 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.subSequence(3, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     assertEquals("hello", sb.subSequence(0, 5)); 
     assertEquals("hello goodbye".subSequence(0, 6), sb.subSequence(0, 6)); 
     assertEquals("goodbye", sb.subSequence(6, 13)); 
     assertEquals("hello goodbye".subSequence(6, 13), sb.subSequence(6, 13)); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String9142() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
@Test 
 public void testEndsWith9154() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testStartsWith9166() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.startsWith("a")); 
     assertFalse(sb.startsWith(null)); 
     assertTrue(sb.startsWith("")); 
     sb.append("abc"); 
     assertTrue(sb.startsWith("a")); 
     assertTrue(sb.startsWith("ab")); 
     assertTrue(sb.startsWith("abc")); 
     assertFalse(sb.startsWith("cba")); 
 } 
@Test 
 public void testChaining9194() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testEndsWith9222() { 
     final StrBuilder sb = new StrBuilder(); 
     assertFalse(sb.endsWith("a")); 
     assertFalse(sb.endsWith("c")); 
     assertTrue(sb.endsWith("")); 
     assertFalse(sb.endsWith(null)); 
     sb.append("abc"); 
     assertTrue(sb.endsWith("c")); 
     assertTrue(sb.endsWith("bc")); 
     assertTrue(sb.endsWith("abc")); 
     assertFalse(sb.endsWith("cba")); 
     assertFalse(sb.endsWith("abcd")); 
     assertFalse(sb.endsWith(" abc")); 
     assertFalse(sb.endsWith("abc ")); 
 } 
@Test 
 public void testLang2949242() { 
     final StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n"); 
     sb.deleteAll("\n%BLAH%"); 
     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString()); 
 } 
@Test 
 public void testAsWriter9265() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testCapacityAndLength9266() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(32, sb.capacity()); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.ensureCapacity(32); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.append("foo"); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(3, sb.length()); 
     assertEquals(3, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.clear(); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.append("123456789012345678901234567890123"); 
     assertTrue(sb.capacity() > 32); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.ensureCapacity(16); 
     assertTrue(sb.capacity() > 16); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.minimizeCapacity(); 
     assertEquals(33, sb.capacity()); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     try { 
         sb.setLength(-1); 
         fail("setLength(-1) expected StringIndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.setLength(33); 
     assertEquals(33, sb.capacity()); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.setLength(16); 
     assertTrue(sb.capacity() >= 16); 
     assertEquals(16, sb.length()); 
     assertEquals(16, sb.size()); 
     assertEquals("1234567890123456", sb.toString()); 
     assertTrue(sb.isEmpty() == false); 
     sb.setLength(32); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(32, sb.length()); 
     assertEquals(32, sb.size()); 
     assertEquals("1234567890123456\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0", sb.toString()); 
     assertTrue(sb.isEmpty() == false); 
     sb.setLength(0); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
 } 
@Test 
 public void testReplaceFirst_StrMatcher_String9307() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccba", sb.toString()); 
     sb.replaceFirst(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-ccba", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcba", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceFirst(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxb", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceFirst(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-A2A3-A4", sb.toString()); 
 } 
@Test 
 public void testLang412Right9338() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadRight(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadRight correctly", "**********", sb.toString()); 
 } 
@Test 
 public void testLeftString9373() { 
     final StrBuilder sb = new StrBuilder("left right"); 
     assertEquals("left", sb.leftString(4)); 
     assertEquals("", sb.leftString(0)); 
     assertEquals("", sb.leftString(-5)); 
     assertEquals("left right", sb.leftString(15)); 
 } 
@Test 
 public void testCharAt9379() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.charAt(0); 
         fail("charAt(0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     sb.append("foo"); 
     assertEquals('f', sb.charAt(0)); 
     assertEquals('o', sb.charAt(1)); 
     assertEquals('o', sb.charAt(2)); 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(3); 
         fail("charAt(3) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testAsWriter9416() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testAsReader9435() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testAsWriter9476() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReverse9479() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(true); 
     assertEquals("eurt", sb.reverse().toString()); 
     assertEquals("true", sb.reverse().toString()); 
 } 
@Test 
 public void testAsReader9488() throws Exception { 
     final StrBuilder sb = new StrBuilder("some text"); 
     Reader reader = sb.asReader(); 
     assertTrue(reader.ready()); 
     final char[] buf = new char[40]; 
     assertEquals(9, reader.read(buf)); 
     assertEquals("some text", new String(buf, 0, 9)); 
     assertEquals(-1, reader.read()); 
     assertFalse(reader.ready()); 
     assertEquals(0, reader.skip(2)); 
     assertEquals(0, reader.skip(-1)); 
     assertTrue(reader.markSupported()); 
     reader = sb.asReader(); 
     assertEquals('s', reader.read()); 
     reader.mark(-1); 
     char[] array = new char[3]; 
     assertEquals(3, reader.read(array, 0, 3)); 
     assertEquals('o', array[0]); 
     assertEquals('m', array[1]); 
     assertEquals('e', array[2]); 
     reader.reset(); 
     assertEquals(1, reader.read(array, 1, 1)); 
     assertEquals('o', array[0]); 
     assertEquals('o', array[1]); 
     assertEquals('e', array[2]); 
     assertEquals(2, reader.skip(2)); 
     assertEquals(' ', reader.read()); 
     assertTrue(reader.ready()); 
     reader.close(); 
     assertTrue(reader.ready()); 
     reader = sb.asReader(); 
     array = new char[3]; 
     try { 
         reader.read(array, -1, 0); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, -1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 100, 1); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, 0, 100); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     try { 
         reader.read(array, Integer.MAX_VALUE, Integer.MAX_VALUE); 
         fail(); 
     } catch (final IndexOutOfBoundsException ex) { 
     } 
     assertEquals(0, reader.read(array, 0, 0)); 
     assertEquals(0, array[0]); 
     assertEquals(0, array[1]); 
     assertEquals(0, array[2]); 
     reader.skip(9); 
     assertEquals(-1, reader.read(array, 0, 1)); 
     reader.reset(); 
     array = new char[30]; 
     assertEquals(9, reader.read(array, 0, 30)); 
 } 
@Test 
 public void testLastIndexOf_String_int9526() { 
     StrBuilder sb = new StrBuilder("abab"); 
     assertEquals(-1, sb.lastIndexOf("a", -1)); 
     assertEquals(0, sb.lastIndexOf("a", 0)); 
     assertEquals(0, sb.lastIndexOf("a", 1)); 
     assertEquals(2, sb.lastIndexOf("a", 2)); 
     assertEquals(2, sb.lastIndexOf("a", 3)); 
     assertEquals(2, sb.lastIndexOf("a", 4)); 
     assertEquals(2, sb.lastIndexOf("a", 5)); 
     assertEquals(-1, sb.lastIndexOf("abcdef", 3)); 
     assertEquals("abab".lastIndexOf("", 3), sb.lastIndexOf("", 3)); 
     assertEquals("abab".lastIndexOf("", 1), sb.lastIndexOf("", 1)); 
     assertEquals("abab".lastIndexOf("a", 1), sb.lastIndexOf("a", 1)); 
     assertEquals(0, sb.lastIndexOf("ab", 1)); 
     assertEquals("abab".lastIndexOf("ab", 1), sb.lastIndexOf("ab", 1)); 
     assertEquals(1, sb.lastIndexOf("b", 2)); 
     assertEquals("abab".lastIndexOf("b", 2), sb.lastIndexOf("b", 2)); 
     assertEquals(1, sb.lastIndexOf("ba", 2)); 
     assertEquals("abab".lastIndexOf("ba", 2), sb.lastIndexOf("ba", 2)); 
     assertEquals(-1, sb.lastIndexOf("z", 2)); 
     sb = new StrBuilder("xyzabc"); 
     assertEquals(2, sb.lastIndexOf("za", sb.length())); 
     assertEquals(-1, sb.lastIndexOf("za", 1)); 
     assertEquals(-1, sb.lastIndexOf((String) null, 2)); 
 } 
@Test 
 public void testChaining9536() { 
     final StrBuilder sb = new StrBuilder(); 
     assertSame(sb, sb.setNewLineText(null)); 
     assertSame(sb, sb.setNullText(null)); 
     assertSame(sb, sb.setLength(1)); 
     assertSame(sb, sb.setCharAt(0, 'a')); 
     assertSame(sb, sb.ensureCapacity(0)); 
     assertSame(sb, sb.minimizeCapacity()); 
     assertSame(sb, sb.clear()); 
     assertSame(sb, sb.reverse()); 
     assertSame(sb, sb.trim()); 
 } 
@Test 
 public void testAsWriter9538() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 } 
@Test 
 public void testReplaceAll_StrMatcher_String9552() { 
     StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceAll((StrMatcher) null, null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll((StrMatcher) null, "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), null); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.noneMatcher(), "anything"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('x'), "y"); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('a'), "d"); 
     assertEquals("dbcbccbd", sb.toString()); 
     sb.replaceAll(StrMatcher.charMatcher('d'), null); 
     assertEquals("bcbccb", sb.toString()); 
     sb.replaceAll(StrMatcher.stringMatcher("cb"), "-"); 
     assertEquals("b-c-", sb.toString()); 
     sb = new StrBuilder("abcba"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("axbxcxbxa", sb.toString()); 
     sb = new StrBuilder("bb"); 
     sb.replaceAll(StrMatcher.charMatcher('b'), "xbx"); 
     assertEquals("xbxxbx", sb.toString()); 
     sb = new StrBuilder("A1-A2A3-A4"); 
     sb.replaceAll(A_NUMBER_MATCHER, "***"); 
     assertEquals("***-******-***", sb.toString()); 
 } 
