@Test 
 public void testDefaultAppend2362() { 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1).toString()); 
     assertEquals("fo", FormattableUtils.append("foo", new Formatter(), 0, -1, 2).toString()); 
     assertEquals(" foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1).toString()); 
     assertEquals("   foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1).toString()); 
     assertEquals(" fo", FormattableUtils.append("foo", new Formatter(), 0, 3, 2).toString()); 
     assertEquals("   fo", FormattableUtils.append("foo", new Formatter(), 0, 5, 2).toString()); 
     assertEquals("foo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1).toString()); 
     assertEquals("foo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1).toString()); 
     assertEquals("fo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2).toString()); 
     assertEquals("fo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2).toString()); 
 } 
@Test 
 public void testEllipsis2622() { 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, "*").toString()); 
     assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, 2, "*").toString()); 
     assertEquals(" foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1, "*").toString()); 
     assertEquals("   foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1, "*").toString()); 
     assertEquals(" f*", FormattableUtils.append("foo", new Formatter(), 0, 3, 2, "*").toString()); 
     assertEquals("   f*", FormattableUtils.append("foo", new Formatter(), 0, 5, 2, "*").toString()); 
     assertEquals("foo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1, "*").toString()); 
     assertEquals("foo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1, "*").toString()); 
     assertEquals("f* ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2, "*").toString()); 
     assertEquals("f*   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2, "*").toString()); 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, "+*").toString()); 
     assertEquals("+*", FormattableUtils.append("foo", new Formatter(), 0, -1, 2, "+*").toString()); 
     assertEquals(" foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1, "+*").toString()); 
     assertEquals("   foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1, "+*").toString()); 
     assertEquals(" +*", FormattableUtils.append("foo", new Formatter(), 0, 3, 2, "+*").toString()); 
     assertEquals("   +*", FormattableUtils.append("foo", new Formatter(), 0, 5, 2, "+*").toString()); 
     assertEquals("foo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1, "+*").toString()); 
     assertEquals("foo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1, "+*").toString()); 
     assertEquals("+* ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2, "+*").toString()); 
     assertEquals("+*   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2, "+*").toString()); 
 } 
@Test 
 public void testDefaultAppend2984() { 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1).toString()); 
     assertEquals("fo", FormattableUtils.append("foo", new Formatter(), 0, -1, 2).toString()); 
     assertEquals(" foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1).toString()); 
     assertEquals("   foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1).toString()); 
     assertEquals(" fo", FormattableUtils.append("foo", new Formatter(), 0, 3, 2).toString()); 
     assertEquals("   fo", FormattableUtils.append("foo", new Formatter(), 0, 5, 2).toString()); 
     assertEquals("foo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1).toString()); 
     assertEquals("foo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1).toString()); 
     assertEquals("fo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2).toString()); 
     assertEquals("fo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2).toString()); 
 } 
@Test 
 public void testAlternatePadCharacter3096() { 
     final char pad = '_'; 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, pad).toString()); 
     assertEquals("fo", FormattableUtils.append("foo", new Formatter(), 0, -1, 2, pad).toString()); 
     assertEquals("_foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1, pad).toString()); 
     assertEquals("___foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1, pad).toString()); 
     assertEquals("_fo", FormattableUtils.append("foo", new Formatter(), 0, 3, 2, pad).toString()); 
     assertEquals("___fo", FormattableUtils.append("foo", new Formatter(), 0, 5, 2, pad).toString()); 
     assertEquals("foo_", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1, pad).toString()); 
     assertEquals("foo___", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1, pad).toString()); 
     assertEquals("fo_", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2, pad).toString()); 
     assertEquals("fo___", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2, pad).toString()); 
 } 
@Test 
 public void testEllipsis7182() { 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, "*").toString()); 
     assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, 2, "*").toString()); 
     assertEquals(" foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1, "*").toString()); 
     assertEquals("   foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1, "*").toString()); 
     assertEquals(" f*", FormattableUtils.append("foo", new Formatter(), 0, 3, 2, "*").toString()); 
     assertEquals("   f*", FormattableUtils.append("foo", new Formatter(), 0, 5, 2, "*").toString()); 
     assertEquals("foo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1, "*").toString()); 
     assertEquals("foo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1, "*").toString()); 
     assertEquals("f* ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2, "*").toString()); 
     assertEquals("f*   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2, "*").toString()); 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, "+*").toString()); 
     assertEquals("+*", FormattableUtils.append("foo", new Formatter(), 0, -1, 2, "+*").toString()); 
     assertEquals(" foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1, "+*").toString()); 
     assertEquals("   foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1, "+*").toString()); 
     assertEquals(" +*", FormattableUtils.append("foo", new Formatter(), 0, 3, 2, "+*").toString()); 
     assertEquals("   +*", FormattableUtils.append("foo", new Formatter(), 0, 5, 2, "+*").toString()); 
     assertEquals("foo ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1, "+*").toString()); 
     assertEquals("foo   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1, "+*").toString()); 
     assertEquals("+* ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2, "+*").toString()); 
     assertEquals("+*   ", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2, "+*").toString()); 
 } 
@Test 
 public void testAlternatePadCharacter8597() { 
     final char pad = '_'; 
     assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, pad).toString()); 
     assertEquals("fo", FormattableUtils.append("foo", new Formatter(), 0, -1, 2, pad).toString()); 
     assertEquals("_foo", FormattableUtils.append("foo", new Formatter(), 0, 4, -1, pad).toString()); 
     assertEquals("___foo", FormattableUtils.append("foo", new Formatter(), 0, 6, -1, pad).toString()); 
     assertEquals("_fo", FormattableUtils.append("foo", new Formatter(), 0, 3, 2, pad).toString()); 
     assertEquals("___fo", FormattableUtils.append("foo", new Formatter(), 0, 5, 2, pad).toString()); 
     assertEquals("foo_", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 4, -1, pad).toString()); 
     assertEquals("foo___", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 6, -1, pad).toString()); 
     assertEquals("fo_", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 3, 2, pad).toString()); 
     assertEquals("fo___", FormattableUtils.append("foo", new Formatter(), LEFT_JUSTIFY, 5, 2, pad).toString()); 
 } 
