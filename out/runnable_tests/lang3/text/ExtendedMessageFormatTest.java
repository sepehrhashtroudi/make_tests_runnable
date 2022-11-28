@Test 
 public void testExtendedAndBuiltInFormats16() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 } 
@Test 
 public void testEqualsHashcode391() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEqualsHashcode854() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEqualsHashcode1057() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testExtendedAndBuiltInFormats1138() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 } 
@Test 
 public void testEqualsHashcode1956() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEscapedQuote_LANG_4772529() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEqualsHashcode2712() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEscapedQuote_LANG_4773138() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4773208() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEqualsHashcode3286() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEqualsHashcode3590() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEqualsHashcode3748() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testExtendedAndBuiltInFormats4109() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 } 
@Test 
 public void testEscapedQuote_LANG_4774322() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4774456() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4774497() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testExtendedAndBuiltInFormats4549() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 } 
@Test 
 public void testEscapedQuote_LANG_4774595() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4775003() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4775498() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEqualsHashcode5627() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEqualsHashcode6030() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEscapedQuote_LANG_4776571() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4776804() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4777010() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testExtendedAndBuiltInFormats7118() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 } 
@Test 
 public void testEqualsHashcode7308() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testExtendedAndBuiltInFormats7635() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2007, Calendar.JANUARY, 23, 18, 33, 05); 
     final Object[] args = new Object[] { "John Doe", cal.getTime(), Double.valueOf("12345.67") }; 
     final String builtinsPattern = "DOB: {1,date,short} Salary: {2,number,currency}"; 
     final String extendedPattern = "Name: {0,upper} "; 
     final String pattern = extendedPattern + builtinsPattern; 
     final HashSet<Locale> testLocales = new HashSet<Locale>(); 
     testLocales.addAll(Arrays.asList(DateFormat.getAvailableLocales())); 
     testLocales.retainAll(Arrays.asList(NumberFormat.getAvailableLocales())); 
     testLocales.add(null); 
     for (final Locale locale : testLocales) { 
         final MessageFormat builtins = createMessageFormat(builtinsPattern, locale); 
         final String expectedPattern = extendedPattern + builtins.toPattern(); 
         DateFormat df = null; 
         NumberFormat nf = null; 
         ExtendedMessageFormat emf = null; 
         if (locale == null) { 
             df = DateFormat.getDateInstance(DateFormat.SHORT); 
             nf = NumberFormat.getCurrencyInstance(); 
             emf = new ExtendedMessageFormat(pattern, registry); 
         } else { 
             df = DateFormat.getDateInstance(DateFormat.SHORT, locale); 
             nf = NumberFormat.getCurrencyInstance(locale); 
             emf = new ExtendedMessageFormat(pattern, locale, registry); 
         } 
         final StringBuilder expected = new StringBuilder(); 
         expected.append("Name: "); 
         expected.append(args[0].toString().toUpperCase()); 
         expected.append(" DOB: "); 
         expected.append(df.format(args[1])); 
         expected.append(" Salary: "); 
         expected.append(nf.format(args[2])); 
         assertPatternsEqual("pattern comparison for locale " + locale, expectedPattern, emf.toPattern()); 
         assertEquals(String.valueOf(locale), expected.toString(), emf.format(args)); 
     } 
 } 
@Test 
 public void testEqualsHashcode7866() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEscapedQuote_LANG_4778088() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4778133() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEqualsHashcode8169() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEscapedQuote_LANG_4778346() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEqualsHashcode8539() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEqualsHashcode8686() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEscapedQuote_LANG_4778775() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4779095() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEqualsHashcode9185() { 
     final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
     final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
     final String pattern = "Pattern: {0,testfmt}"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     ExtendedMessageFormat other = null; 
     assertTrue("same, equals()", emf.equals(emf)); 
     assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
     assertTrue("equal, equals()", emf.equals(other)); 
     assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new OtherExtendedMessageFormat(pattern, Locale.US, registry); 
     assertFalse("class, equals()", emf.equals(other)); 
     assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
     assertFalse("pattern, equals()", emf.equals(other)); 
     assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
     assertFalse("registry, equals()", emf.equals(other)); 
     assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
     other = new ExtendedMessageFormat(pattern, Locale.FRANCE, registry); 
     assertFalse("locale, equals()", emf.equals(other)); 
     assertTrue("locale, hashcode()", emf.hashCode() == other.hashCode()); 
 } 
@Test 
 public void testEscapedQuote_LANG_4779230() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
@Test 
 public void testEscapedQuote_LANG_4779411() { 
     final String pattern = "it''s a {0,lower} 'test'!"; 
     final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
     assertEquals("it's a dummy test!", emf.format(new Object[] { "DUMMY" })); 
 } 
