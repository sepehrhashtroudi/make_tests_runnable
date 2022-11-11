@Test 
 public void testUsage364() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testCompositeFormat468() { 
     final Format parser = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             return null; 
         } 
     }; 
     final Format formatter = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             return null; 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
     }; 
     final CompositeFormat composite = new CompositeFormat(parser, formatter); 
     composite.parseObject("", null); 
     composite.format(new Object(), new StringBuffer(), null); 
     assertEquals("Parser get method incorrectly implemented", parser, composite.getParser()); 
     assertEquals("Formatter get method incorrectly implemented", formatter, composite.getFormatter()); 
 } 
@Test 
 public void testCompositeFormat1718() { 
     final Format parser = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             return null; 
         } 
     }; 
     final Format formatter = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             return null; 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
     }; 
     final CompositeFormat composite = new CompositeFormat(parser, formatter); 
     composite.parseObject("", null); 
     composite.format(new Object(), new StringBuffer(), null); 
     assertEquals("Parser get method incorrectly implemented", parser, composite.getParser()); 
     assertEquals("Formatter get method incorrectly implemented", formatter, composite.getFormatter()); 
 } 
@Test 
 public void testUsage2234() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testUsage2926() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testUsage6317() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testUsage6328() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testUsage6680() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testCompositeFormat6857() { 
     final Format parser = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             return null; 
         } 
     }; 
     final Format formatter = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             return null; 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
     }; 
     final CompositeFormat composite = new CompositeFormat(parser, formatter); 
     composite.parseObject("", null); 
     composite.format(new Object(), new StringBuffer(), null); 
     assertEquals("Parser get method incorrectly implemented", parser, composite.getParser()); 
     assertEquals("Formatter get method incorrectly implemented", formatter, composite.getFormatter()); 
 } 
@Test 
 public void testUsage7640() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testCompositeFormat8600() { 
     final Format parser = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             return null; 
         } 
     }; 
     final Format formatter = new Format() { 
  
         @Override 
         public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { 
             return null; 
         } 
  
         @Override 
         public Object parseObject(final String source, final ParsePosition pos) { 
             throw new UnsupportedOperationException("Not implemented"); 
         } 
     }; 
     final CompositeFormat composite = new CompositeFormat(parser, formatter); 
     composite.parseObject("", null); 
     composite.format(new Object(), new StringBuffer(), null); 
     assertEquals("Parser get method incorrectly implemented", parser, composite.getParser()); 
     assertEquals("Formatter get method incorrectly implemented", formatter, composite.getFormatter()); 
 } 
@Test 
 public void testUsage8911() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
@Test 
 public void testUsage9494() throws Exception { 
     final Format f1 = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH); 
     final Format f2 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH); 
     final CompositeFormat c = new CompositeFormat(f1, f2); 
     final String testString = "January 3, 2005"; 
     assertEquals(testString, c.format(c.parseObject("01032005"))); 
     assertEquals(testString, c.reformat("01032005")); 
 } 
