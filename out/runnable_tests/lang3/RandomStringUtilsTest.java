@Test 
 public void testExceptions242() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils320() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils496() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions506() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testExceptions836() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils852() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions1228() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils1514() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils1633() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions1705() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testLANG8072121() { 
     try { 
         RandomStringUtils.random(3, 5, 5, false, false); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         final String msg = ex.getMessage(); 
         assertTrue("Message (" + msg + ") must contain 'start'", msg.contains("start")); 
         assertTrue("Message (" + msg + ") must contain 'end'", msg.contains("end")); 
     } 
 } 
@Test 
 public void testExceptions2176() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils2198() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils2365() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils2464() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils2735() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions2844() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils2941() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils3092() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions3247() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testExceptions3503() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils3514() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions3607() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils3740() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils4143() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils4206() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils4320() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils4403() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils4762() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils4859() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testConstructor4985() { 
     assertNotNull(new RandomStringUtils()); 
     final Constructor<?>[] cons = RandomStringUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(RandomStringUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(RandomStringUtils.class.getModifiers())); 
 } 
@Test 
 public void testRandomStringUtils5102() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions5164() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testLang1005259() throws Exception { 
     final int size = 5000; 
     final String encoding = "UTF-8"; 
     final String orig = RandomStringUtils.random(size); 
     final byte[] bytes = orig.getBytes(encoding); 
     final String copy = new String(bytes, encoding); 
     for (int i = 0; i < orig.length() && i < copy.length(); i++) { 
         final char o = orig.charAt(i); 
         final char c = copy.charAt(i); 
         assertEquals("differs at " + i + "(" + Integer.toHexString(new Character(o).hashCode()) + "," + Integer.toHexString(new Character(c).hashCode()) + ")", o, c); 
     } 
     assertEquals(orig.length(), copy.length()); 
     assertEquals(orig, copy); 
 } 
@Test 
 public void testExceptions5288() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils5584() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils5611() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions5723() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils5820() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils6146() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions6149() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils6251() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils6320() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils6424() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions6451() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testExceptions6481() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils6730() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testConstructor7352() { 
     assertNotNull(new RandomStringUtils()); 
     final Constructor<?>[] cons = RandomStringUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(RandomStringUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(RandomStringUtils.class.getModifiers())); 
 } 
@Test 
 public void testLANG8077379() { 
     try { 
         RandomStringUtils.random(3, 5, 5, false, false); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         final String msg = ex.getMessage(); 
         assertTrue("Message (" + msg + ") must contain 'start'", msg.contains("start")); 
         assertTrue("Message (" + msg + ") must contain 'end'", msg.contains("end")); 
     } 
 } 
@Test 
 public void testExceptions7428() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils7446() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils7480() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions7608() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils7688() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils7813() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils7860() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testLANG8078010() { 
     try { 
         RandomStringUtils.random(3, 5, 5, false, false); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
         final String msg = ex.getMessage(); 
         assertTrue("Message (" + msg + ") must contain 'start'", msg.contains("start")); 
         assertTrue("Message (" + msg + ") must contain 'end'", msg.contains("end")); 
     } 
 } 
@Test 
 public void testRandomStringUtils8031() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils8112() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testLANG8058378() { 
     final long seed = System.currentTimeMillis(); 
     assertEquals("aaa", RandomStringUtils.random(3, 0, 0, false, false, new char[] { 'a' }, new Random(seed))); 
 } 
@Test 
 public void testExceptions8476() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testExceptions8705() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testRandomStringUtils8830() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testRandomStringUtils9207() { 
     String r1 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r1.length()); 
     String r2 = RandomStringUtils.random(50); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAscii(50); 
     assertEquals("randomAscii(50) length", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("char between 32 and 127", r1.charAt(i) >= 32 && r1.charAt(i) <= 127); 
     } 
     r2 = RandomStringUtils.randomAscii(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphabetic(50); 
     assertEquals("randomAlphabetic(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphabetic", Character.isLetter(r1.charAt(i)) && !Character.isDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomAlphanumeric(50); 
     assertEquals("randomAlphanumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains alphanumeric", Character.isLetterOrDigit(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomAlphabetic(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.randomNumeric(50); 
     assertEquals("randomNumeric(50)", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("r1 contains numeric", Character.isDigit(r1.charAt(i)) && !Character.isLetter(r1.charAt(i))); 
     } 
     r2 = RandomStringUtils.randomNumeric(50); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     String set = "abcdefg"; 
     r1 = RandomStringUtils.random(50, set); 
     assertEquals("random(50, \"abcdefg\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (String) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     set = "stuvwxyz"; 
     r1 = RandomStringUtils.random(50, set.toCharArray()); 
     assertEquals("random(50, \"stuvwxyz\")", 50, r1.length()); 
     for (int i = 0; i < r1.length(); i++) { 
         assertTrue("random char in set", set.indexOf(r1.charAt(i)) > -1); 
     } 
     r2 = RandomStringUtils.random(50, set); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     r1 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r1.length()); 
     r2 = RandomStringUtils.random(50, (char[]) null); 
     assertEquals("random(50) length", 50, r2.length()); 
     assertTrue("!r1.equals(r2)", !r1.equals(r2)); 
     final long seed = System.currentTimeMillis(); 
     r1 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     r2 = RandomStringUtils.random(50, 0, 0, true, true, null, new Random(seed)); 
     assertEquals("r1.equals(r2)", r1, r2); 
     r1 = RandomStringUtils.random(0); 
     assertEquals("random(0).equals(\"\")", "", r1); 
 } 
@Test 
 public void testExceptions9282() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY, new Random()); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
