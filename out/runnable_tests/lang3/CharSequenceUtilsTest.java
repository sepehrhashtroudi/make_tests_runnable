@Test 
 public void testConstructor296() { 
     assertNotNull(new CharSequenceUtils()); 
     final Constructor<?>[] cons = CharSequenceUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(CharSequenceUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(CharSequenceUtils.class.getModifiers())); 
 } 
@Test 
 public void testSubSequence3205() { 
     Assert.assertEquals(null, CharSequenceUtils.subSequence(null, -1)); 
     Assert.assertEquals(null, CharSequenceUtils.subSequence(null, 0)); 
     Assert.assertEquals(null, CharSequenceUtils.subSequence(null, 1)); 
     Assert.assertEquals(StringUtils.EMPTY, CharSequenceUtils.subSequence(StringUtils.EMPTY, 0)); 
     Assert.assertEquals("012", CharSequenceUtils.subSequence("012", 0)); 
     Assert.assertEquals("12", CharSequenceUtils.subSequence("012", 1)); 
     Assert.assertEquals("2", CharSequenceUtils.subSequence("012", 2)); 
     Assert.assertEquals(StringUtils.EMPTY, CharSequenceUtils.subSequence("012", 3)); 
     try { 
         Assert.assertEquals(null, CharSequenceUtils.subSequence(StringUtils.EMPTY, -1)); 
         Assert.fail("Expected " + IndexOutOfBoundsException.class.getName()); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         Assert.assertEquals(null, CharSequenceUtils.subSequence(StringUtils.EMPTY, 1)); 
         Assert.fail("Expected " + IndexOutOfBoundsException.class.getName()); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
@Test 
 public void testConstructor3895() { 
     assertNotNull(new CharSequenceUtils()); 
     final Constructor<?>[] cons = CharSequenceUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(CharSequenceUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(CharSequenceUtils.class.getModifiers())); 
 } 
@Test 
 public void testSubSequence5273() { 
     Assert.assertEquals(null, CharSequenceUtils.subSequence(null, -1)); 
     Assert.assertEquals(null, CharSequenceUtils.subSequence(null, 0)); 
     Assert.assertEquals(null, CharSequenceUtils.subSequence(null, 1)); 
     Assert.assertEquals(StringUtils.EMPTY, CharSequenceUtils.subSequence(StringUtils.EMPTY, 0)); 
     Assert.assertEquals("012", CharSequenceUtils.subSequence("012", 0)); 
     Assert.assertEquals("12", CharSequenceUtils.subSequence("012", 1)); 
     Assert.assertEquals("2", CharSequenceUtils.subSequence("012", 2)); 
     Assert.assertEquals(StringUtils.EMPTY, CharSequenceUtils.subSequence("012", 3)); 
     try { 
         Assert.assertEquals(null, CharSequenceUtils.subSequence(StringUtils.EMPTY, -1)); 
         Assert.fail("Expected " + IndexOutOfBoundsException.class.getName()); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         Assert.assertEquals(null, CharSequenceUtils.subSequence(StringUtils.EMPTY, 1)); 
         Assert.fail("Expected " + IndexOutOfBoundsException.class.getName()); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 } 
