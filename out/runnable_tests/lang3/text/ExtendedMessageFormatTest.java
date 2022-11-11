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
@Test 
     public void testEscapedQuote_LANG_4779579() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode9688() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710125() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10126() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710127() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10128() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710129() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10130() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10131() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10132() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710133() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10134() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10135() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10136() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710137() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710138() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710139() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10140() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10141() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10142() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10143() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710144() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10145() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10146() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710147() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710148() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710149() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10150() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710151() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710152() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710153() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710154() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710155() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710156() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710157() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10158() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710159() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710160() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710161() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710162() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710163() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710164() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10165() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710166() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710167() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10168() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710169() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710170() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710171() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10172() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710173() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710174() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710175() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710176() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710177() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710178() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710179() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710180() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710181() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710182() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710183() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710184() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10185() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710186() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710187() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10188() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10189() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710190() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710191() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10192() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10193() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different Class 
         other = new OtherExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("class, equals()",   emf.equals(other)); 
         assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.
@Test 
     public void testEqualsHashcode10194() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10195() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10196() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEqualsHashcode10197() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710198() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710199() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710200() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710201() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710202() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710203() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710204() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710205() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10206() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710207() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710208() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710209() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710210() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710211() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710212() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710213() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710214() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710215() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710216() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10217() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710218() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710219() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710220() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710221() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10222() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710223() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710224() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710225() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710226() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710227() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710228() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710229() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710230() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710231() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710232() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710233() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710234() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710235() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710236() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10237() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710238() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10239() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710240() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710241() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10242() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710243() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710244() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710245() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEqualsHashcode10246() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, registry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertTrue("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 

@Test 
     public void testEscapedQuote_LANG_47710247() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

@Test 
     public void testEscapedQuote_LANG_47710248() { 
         final String pattern = "it''s a {0,lower} 'test'!"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, registry); 
         assertEquals("it's a dummy test!", emf.format(new Object[] {"DUMMY"})); 
     } 
  
     /** 
      * Test extended and built in formats. 
      */ 

