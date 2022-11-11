@Test 
 public void testContains_Char123() { 
     CharRange range = CharRange.is('c'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertFalse(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isIn('c', 'd'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertTrue(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isIn('d', 'c'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertTrue(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isNotIn('c', 'd'); 
     assertTrue(range.contains('b')); 
     assertFalse(range.contains('c')); 
     assertFalse(range.contains('d')); 
     assertTrue(range.contains('e')); 
     assertTrue(range.contains((char) 0)); 
     assertTrue(range.contains(Character.MAX_VALUE)); 
 } 
@Test 
 public void testContains_Charrange131() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testContains_Charrange132() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed147() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator359() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testContains_Charrange467() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed492() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator530() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator594() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator657() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed739() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testSerialization1288() { 
     CharRange range = CharRange.is('a'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isNotIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed1443() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed1477() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator1564() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator1608() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator1865() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testContains_Char1973() { 
     CharRange range = CharRange.is('c'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertFalse(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isIn('c', 'd'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertTrue(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isIn('d', 'c'); 
     assertFalse(range.contains('b')); 
     assertTrue(range.contains('c')); 
     assertTrue(range.contains('d')); 
     assertFalse(range.contains('e')); 
     range = CharRange.isNotIn('c', 'd'); 
     assertTrue(range.contains('b')); 
     assertFalse(range.contains('c')); 
     assertFalse(range.contains('d')); 
     assertTrue(range.contains('e')); 
     assertTrue(range.contains((char) 0)); 
     assertTrue(range.contains(Character.MAX_VALUE)); 
 } 
@Test 
 public void testIterator2002() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator2061() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator2116() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed2117() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator2282() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator2510() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator2553() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed2628() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed2646() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testSerialization2756() { 
     CharRange range = CharRange.is('a'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isNotIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed2827() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator2898() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator3047() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testContainsNullArg3274() { 
     final CharRange range = CharRange.is('a'); 
     try { 
         @SuppressWarnings("unused") 
         final boolean contains = range.contains(null); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("The Range must not be null", e.getMessage()); 
     } 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed3668() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator3731() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testHashCode3959() { 
     final CharRange rangea = CharRange.is('a'); 
     final CharRange rangeae = CharRange.isIn('a', 'e'); 
     final CharRange rangenotbf = CharRange.isIn('b', 'f'); 
     assertTrue(rangea.hashCode() == rangea.hashCode()); 
     assertTrue(rangea.hashCode() == CharRange.is('a').hashCode()); 
     assertTrue(rangeae.hashCode() == rangeae.hashCode()); 
     assertTrue(rangeae.hashCode() == CharRange.isIn('a', 'e').hashCode()); 
     assertTrue(rangenotbf.hashCode() == rangenotbf.hashCode()); 
     assertTrue(rangenotbf.hashCode() == CharRange.isIn('b', 'f').hashCode()); 
     assertFalse(rangea.hashCode() == rangeae.hashCode()); 
     assertFalse(rangea.hashCode() == rangenotbf.hashCode()); 
     assertFalse(rangeae.hashCode() == rangea.hashCode()); 
     assertFalse(rangeae.hashCode() == rangenotbf.hashCode()); 
     assertFalse(rangenotbf.hashCode() == rangea.hashCode()); 
     assertFalse(rangenotbf.hashCode() == rangeae.hashCode()); 
 } 
@Test 
 public void testIterator4031() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator4233() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testContains_Charrange4469() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testContains_Charrange4618() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed4815() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testContains_Charrange4876() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed5170() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testSerialization5203() { 
     CharRange range = CharRange.is('a'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isNotIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
 } 
@Test 
 public void testIterator5227() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator5337() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator5360() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator5365() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed5477() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testEquals_Object5581() { 
     final CharRange rangea = CharRange.is('a'); 
     final CharRange rangeae = CharRange.isIn('a', 'e'); 
     final CharRange rangenotbf = CharRange.isIn('b', 'f'); 
     assertFalse(rangea.equals(null)); 
     assertTrue(rangea.equals(rangea)); 
     assertTrue(rangea.equals(CharRange.is('a'))); 
     assertTrue(rangeae.equals(rangeae)); 
     assertTrue(rangeae.equals(CharRange.isIn('a', 'e'))); 
     assertTrue(rangenotbf.equals(rangenotbf)); 
     assertTrue(rangenotbf.equals(CharRange.isIn('b', 'f'))); 
     assertFalse(rangea.equals(rangeae)); 
     assertFalse(rangea.equals(rangenotbf)); 
     assertFalse(rangeae.equals(rangea)); 
     assertFalse(rangeae.equals(rangenotbf)); 
     assertFalse(rangenotbf.equals(rangea)); 
     assertFalse(rangenotbf.equals(rangeae)); 
 } 
@Test 
 public void testContains_Charrange5588() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testIterator5750() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator5818() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed6047() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed6198() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testContains_Charrange6553() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testIterator6706() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator6709() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator6903() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testContains_Charrange7115() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed7150() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed7181() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed7347() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator7360() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testContains_Charrange7368() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed7460() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed7462() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator7607() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testIterator7713() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed7787() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed7896() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testContains_Charrange7900() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testContains_Charrange8105() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testContains_Charrange8241() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testEquals_Object8261() { 
     final CharRange rangea = CharRange.is('a'); 
     final CharRange rangeae = CharRange.isIn('a', 'e'); 
     final CharRange rangenotbf = CharRange.isIn('b', 'f'); 
     assertFalse(rangea.equals(null)); 
     assertTrue(rangea.equals(rangea)); 
     assertTrue(rangea.equals(CharRange.is('a'))); 
     assertTrue(rangeae.equals(rangeae)); 
     assertTrue(rangeae.equals(CharRange.isIn('a', 'e'))); 
     assertTrue(rangenotbf.equals(rangenotbf)); 
     assertTrue(rangenotbf.equals(CharRange.isIn('b', 'f'))); 
     assertFalse(rangea.equals(rangeae)); 
     assertFalse(rangea.equals(rangenotbf)); 
     assertFalse(rangeae.equals(rangea)); 
     assertFalse(rangeae.equals(rangenotbf)); 
     assertFalse(rangenotbf.equals(rangea)); 
     assertFalse(rangenotbf.equals(rangeae)); 
 } 
@Test 
 public void testContains_Charrange8285() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testContains_Charrange8471() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.contains(b)); 
     assertTrue(c.contains(c)); 
     assertTrue(c.contains(c2)); 
     assertFalse(c.contains(d)); 
     assertFalse(c.contains(cd)); 
     assertFalse(c.contains(bd)); 
     assertFalse(c.contains(bc)); 
     assertFalse(c.contains(ab)); 
     assertFalse(c.contains(de)); 
     assertTrue(cd.contains(c)); 
     assertTrue(bd.contains(c)); 
     assertTrue(bc.contains(c)); 
     assertFalse(ab.contains(c)); 
     assertFalse(de.contains(c)); 
     assertTrue(ae.contains(b)); 
     assertTrue(ae.contains(ab)); 
     assertTrue(ae.contains(bc)); 
     assertTrue(ae.contains(cd)); 
     assertTrue(ae.contains(de)); 
     final CharRange notb = CharRange.isNot('b'); 
     final CharRange notc = CharRange.isNot('c'); 
     final CharRange notd = CharRange.isNot('d'); 
     final CharRange notab = CharRange.isNotIn('a', 'b'); 
     final CharRange notbc = CharRange.isNotIn('b', 'c'); 
     final CharRange notbd = CharRange.isNotIn('b', 'd'); 
     final CharRange notcd = CharRange.isNotIn('c', 'd'); 
     final CharRange notde = CharRange.isNotIn('d', 'e'); 
     final CharRange notae = CharRange.isNotIn('a', 'e'); 
     final CharRange all = CharRange.isIn((char) 0, Character.MAX_VALUE); 
     final CharRange allbutfirst = CharRange.isIn((char) 1, Character.MAX_VALUE); 
     assertFalse(c.contains(notc)); 
     assertFalse(c.contains(notbd)); 
     assertTrue(all.contains(notc)); 
     assertTrue(all.contains(notbd)); 
     assertFalse(allbutfirst.contains(notc)); 
     assertFalse(allbutfirst.contains(notbd)); 
     assertTrue(notc.contains(a)); 
     assertTrue(notc.contains(b)); 
     assertFalse(notc.contains(c)); 
     assertTrue(notc.contains(d)); 
     assertTrue(notc.contains(e)); 
     assertTrue(notc.contains(ab)); 
     assertFalse(notc.contains(bc)); 
     assertFalse(notc.contains(bd)); 
     assertFalse(notc.contains(cd)); 
     assertTrue(notc.contains(de)); 
     assertFalse(notc.contains(ae)); 
     assertFalse(notc.contains(all)); 
     assertFalse(notc.contains(allbutfirst)); 
     assertTrue(notbd.contains(a)); 
     assertFalse(notbd.contains(b)); 
     assertFalse(notbd.contains(c)); 
     assertFalse(notbd.contains(d)); 
     assertTrue(notbd.contains(e)); 
     assertTrue(notcd.contains(ab)); 
     assertFalse(notcd.contains(bc)); 
     assertFalse(notcd.contains(bd)); 
     assertFalse(notcd.contains(cd)); 
     assertFalse(notcd.contains(de)); 
     assertFalse(notcd.contains(ae)); 
     assertTrue(notcd.contains(ef)); 
     assertFalse(notcd.contains(all)); 
     assertFalse(notcd.contains(allbutfirst)); 
     assertFalse(notc.contains(notb)); 
     assertTrue(notc.contains(notc)); 
     assertFalse(notc.contains(notd)); 
     assertFalse(notc.contains(notab)); 
     assertTrue(notc.contains(notbc)); 
     assertTrue(notc.contains(notbd)); 
     assertTrue(notc.contains(notcd)); 
     assertFalse(notc.contains(notde)); 
     assertFalse(notbd.contains(notb)); 
     assertFalse(notbd.contains(notc)); 
     assertFalse(notbd.contains(notd)); 
     assertFalse(notbd.contains(notab)); 
     assertFalse(notbd.contains(notbc)); 
     assertTrue(notbd.contains(notbd)); 
     assertFalse(notbd.contains(notcd)); 
     assertFalse(notbd.contains(notde)); 
     assertTrue(notbd.contains(notae)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed8577() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator8842() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testSerialization8861() { 
     CharRange range = CharRange.is('a'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isNotIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed9033() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed9098() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testIterator9164() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange ad = CharRange.isIn('a', 'd'); 
     final CharRange nota = CharRange.isNot('a'); 
     final CharRange emptySet = CharRange.isNotIn((char) 0, Character.MAX_VALUE); 
     final CharRange notFirst = CharRange.isNotIn((char) 1, Character.MAX_VALUE); 
     final CharRange notLast = CharRange.isNotIn((char) 0, (char) (Character.MAX_VALUE - 1)); 
     final Iterator<Character> aIt = a.iterator(); 
     assertNotNull(aIt); 
     assertTrue(aIt.hasNext()); 
     assertEquals(Character.valueOf('a'), aIt.next()); 
     assertFalse(aIt.hasNext()); 
     final Iterator<Character> adIt = ad.iterator(); 
     assertNotNull(adIt); 
     assertTrue(adIt.hasNext()); 
     assertEquals(Character.valueOf('a'), adIt.next()); 
     assertEquals(Character.valueOf('b'), adIt.next()); 
     assertEquals(Character.valueOf('c'), adIt.next()); 
     assertEquals(Character.valueOf('d'), adIt.next()); 
     assertFalse(adIt.hasNext()); 
     final Iterator<Character> notaIt = nota.iterator(); 
     assertNotNull(notaIt); 
     assertTrue(notaIt.hasNext()); 
     while (notaIt.hasNext()) { 
         final Character c = notaIt.next(); 
         assertFalse('a' == c.charValue()); 
     } 
     final Iterator<Character> emptySetIt = emptySet.iterator(); 
     assertNotNull(emptySetIt); 
     assertFalse(emptySetIt.hasNext()); 
     try { 
         emptySetIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notFirstIt = notFirst.iterator(); 
     assertNotNull(notFirstIt); 
     assertTrue(notFirstIt.hasNext()); 
     assertEquals(Character.valueOf((char) 0), notFirstIt.next()); 
     assertFalse(notFirstIt.hasNext()); 
     try { 
         notFirstIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
     final Iterator<Character> notLastIt = notLast.iterator(); 
     assertNotNull(notLastIt); 
     assertTrue(notLastIt.hasNext()); 
     assertEquals(Character.valueOf(Character.MAX_VALUE), notLastIt.next()); 
     assertFalse(notLastIt.hasNext()); 
     try { 
         notLastIt.next(); 
         fail("Should throw NoSuchElementException"); 
     } catch (final NoSuchElementException e) { 
         assertTrue(true); 
     } 
 } 
@Test 
 public void testSerialization9225() { 
     CharRange range = CharRange.is('a'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
     range = CharRange.isNotIn('a', 'e'); 
     assertEquals(range, SerializationUtils.clone(range)); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed9333() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed9339() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testConstructorAccessors_isNotIn_Reversed9390() { 
     final CharRange rangea = CharRange.isNotIn('e', 'a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('e', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a-e", rangea.toString()); 
 } 
@Test 
 public void testHashCode9443() { 
     final CharRange rangea = CharRange.is('a'); 
     final CharRange rangeae = CharRange.isIn('a', 'e'); 
     final CharRange rangenotbf = CharRange.isIn('b', 'f'); 
     assertTrue(rangea.hashCode() == rangea.hashCode()); 
     assertTrue(rangea.hashCode() == CharRange.is('a').hashCode()); 
     assertTrue(rangeae.hashCode() == rangeae.hashCode()); 
     assertTrue(rangeae.hashCode() == CharRange.isIn('a', 'e').hashCode()); 
     assertTrue(rangenotbf.hashCode() == rangenotbf.hashCode()); 
     assertTrue(rangenotbf.hashCode() == CharRange.isIn('b', 'f').hashCode()); 
     assertFalse(rangea.hashCode() == rangeae.hashCode()); 
     assertFalse(rangea.hashCode() == rangenotbf.hashCode()); 
     assertFalse(rangeae.hashCode() == rangea.hashCode()); 
     assertFalse(rangeae.hashCode() == rangenotbf.hashCode()); 
     assertFalse(rangenotbf.hashCode() == rangea.hashCode()); 
     assertFalse(rangenotbf.hashCode() == rangeae.hashCode()); 
 } 
