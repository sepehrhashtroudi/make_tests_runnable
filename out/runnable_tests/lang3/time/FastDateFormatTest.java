@Test 
 public void testParseSync56() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testTimeDateDefaults323() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testCheckDefaults536() { 
     final FastDateFormat format = FastDateFormat.getInstance(); 
     final FastDateFormat medium = FastDateFormat.getDateTimeInstance(FastDateFormat.SHORT, FastDateFormat.SHORT); 
     assertEquals(medium, format); 
     final SimpleDateFormat sdf = new SimpleDateFormat(); 
     assertEquals(sdf.toPattern(), format.getPattern()); 
     assertEquals(Locale.getDefault(), format.getLocale()); 
     assertEquals(TimeZone.getDefault(), format.getTimeZone()); 
 } 
@Test 
 public void test_getInstance_String656() { 
     final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy"); 
     final FastDateFormat format2 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     final FastDateFormat format3 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     assertTrue(format1 != format2); 
     assertSame(format2, format3); 
     assertEquals("MM/DD/yyyy", format1.getPattern()); 
     assertEquals(TimeZone.getDefault(), format1.getTimeZone()); 
     assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
 } 
@Test 
 public void test_getInstance_String775() { 
     final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy"); 
     final FastDateFormat format2 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     final FastDateFormat format3 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     assertTrue(format1 != format2); 
     assertSame(format2, format3); 
     assertEquals("MM/DD/yyyy", format1.getPattern()); 
     assertEquals(TimeZone.getDefault(), format1.getTimeZone()); 
     assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
 } 
@Test 
 public void testDateDefaults932() { 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync1006() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testParseSync1319() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void test_getInstance_String1347() { 
     final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy"); 
     final FastDateFormat format2 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     final FastDateFormat format3 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     assertTrue(format1 != format2); 
     assertSame(format2, format3); 
     assertEquals("MM/DD/yyyy", format1.getPattern()); 
     assertEquals(TimeZone.getDefault(), format1.getTimeZone()); 
     assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
 } 
@Test 
 public void test_getInstance_String_TimeZone_Locale1426() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(TimeZone.getTimeZone("America/New_York")); 
         final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getTimeZone("Atlantic/Reykjavik"), Locale.GERMANY); 
         final FastDateFormat format2 = FastDateFormat.getInstance("MM/DD/yyyy", Locale.GERMANY); 
         final FastDateFormat format3 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault(), Locale.GERMANY); 
         assertTrue(format1 != format2); 
         assertEquals(TimeZone.getTimeZone("Atlantic/Reykjavik"), format1.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format3.getTimeZone()); 
         assertEquals(Locale.GERMANY, format1.getLocale()); 
         assertEquals(Locale.GERMANY, format2.getLocale()); 
         assertEquals(Locale.GERMANY, format3.getLocale()); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void test_getInstance_String_TimeZone1428() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(TimeZone.getTimeZone("America/New_York")); 
         final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getTimeZone("Atlantic/Reykjavik")); 
         final FastDateFormat format2 = FastDateFormat.getInstance("MM/DD/yyyy"); 
         final FastDateFormat format3 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault()); 
         final FastDateFormat format4 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault()); 
         final FastDateFormat format5 = FastDateFormat.getInstance("MM-DD-yyyy", TimeZone.getDefault()); 
         final FastDateFormat format6 = FastDateFormat.getInstance("MM-DD-yyyy"); 
         assertTrue(format1 != format2); 
         assertEquals(TimeZone.getTimeZone("Atlantic/Reykjavik"), format1.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
         assertSame(format3, format4); 
         assertTrue(format3 != format5); 
         assertTrue(format4 != format6); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testTimeDefaults1688() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDefaults2255() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync2408() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testParseSync2474() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testDateDefaults2861() { 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync3054() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void test_getInstance_String_TimeZone_Locale3739() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(TimeZone.getTimeZone("America/New_York")); 
         final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getTimeZone("Atlantic/Reykjavik"), Locale.GERMANY); 
         final FastDateFormat format2 = FastDateFormat.getInstance("MM/DD/yyyy", Locale.GERMANY); 
         final FastDateFormat format3 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault(), Locale.GERMANY); 
         assertTrue(format1 != format2); 
         assertEquals(TimeZone.getTimeZone("Atlantic/Reykjavik"), format1.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format3.getTimeZone()); 
         assertEquals(Locale.GERMANY, format1.getLocale()); 
         assertEquals(Locale.GERMANY, format2.getLocale()); 
         assertEquals(Locale.GERMANY, format3.getLocale()); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testParseSync3752() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testParseSync3954() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testTimeDateDefaults4052() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDefaults4102() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults4142() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testDateDefaults4154() { 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults4743() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults4795() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults5009() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void test_getInstance_String_TimeZone_Locale5035() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(TimeZone.getTimeZone("America/New_York")); 
         final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getTimeZone("Atlantic/Reykjavik"), Locale.GERMANY); 
         final FastDateFormat format2 = FastDateFormat.getInstance("MM/DD/yyyy", Locale.GERMANY); 
         final FastDateFormat format3 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault(), Locale.GERMANY); 
         assertTrue(format1 != format2); 
         assertEquals(TimeZone.getTimeZone("Atlantic/Reykjavik"), format1.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format3.getTimeZone()); 
         assertEquals(Locale.GERMANY, format1.getLocale()); 
         assertEquals(Locale.GERMANY, format2.getLocale()); 
         assertEquals(Locale.GERMANY, format3.getLocale()); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testTimeDateDefaults5153() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void test_getInstance_String_TimeZone5223() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(TimeZone.getTimeZone("America/New_York")); 
         final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getTimeZone("Atlantic/Reykjavik")); 
         final FastDateFormat format2 = FastDateFormat.getInstance("MM/DD/yyyy"); 
         final FastDateFormat format3 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault()); 
         final FastDateFormat format4 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault()); 
         final FastDateFormat format5 = FastDateFormat.getInstance("MM-DD-yyyy", TimeZone.getDefault()); 
         final FastDateFormat format6 = FastDateFormat.getInstance("MM-DD-yyyy"); 
         assertTrue(format1 != format2); 
         assertEquals(TimeZone.getTimeZone("Atlantic/Reykjavik"), format1.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
         assertSame(format3, format4); 
         assertTrue(format3 != format5); 
         assertTrue(format4 != format6); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testTimeDefaults5314() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDefaults5369() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults5392() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync5785() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testTimeDefaults5863() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDefaults6072() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults6154() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testCheckDefaults6269() { 
     final FastDateFormat format = FastDateFormat.getInstance(); 
     final FastDateFormat medium = FastDateFormat.getDateTimeInstance(FastDateFormat.SHORT, FastDateFormat.SHORT); 
     assertEquals(medium, format); 
     final SimpleDateFormat sdf = new SimpleDateFormat(); 
     assertEquals(sdf.toPattern(), format.getPattern()); 
     assertEquals(Locale.getDefault(), format.getLocale()); 
     assertEquals(TimeZone.getDefault(), format.getTimeZone()); 
 } 
@Test 
 public void testParseSync6298() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testTimeDateDefaults6390() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults6444() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults6572() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void test_getInstance_String_TimeZone_Locale6632() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(TimeZone.getTimeZone("America/New_York")); 
         final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getTimeZone("Atlantic/Reykjavik"), Locale.GERMANY); 
         final FastDateFormat format2 = FastDateFormat.getInstance("MM/DD/yyyy", Locale.GERMANY); 
         final FastDateFormat format3 = FastDateFormat.getInstance("MM/DD/yyyy", TimeZone.getDefault(), Locale.GERMANY); 
         assertTrue(format1 != format2); 
         assertEquals(TimeZone.getTimeZone("Atlantic/Reykjavik"), format1.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
         assertEquals(TimeZone.getDefault(), format3.getTimeZone()); 
         assertEquals(Locale.GERMANY, format1.getLocale()); 
         assertEquals(Locale.GERMANY, format2.getLocale()); 
         assertEquals(Locale.GERMANY, format3.getLocale()); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testCheckDefaults6645() { 
     final FastDateFormat format = FastDateFormat.getInstance(); 
     final FastDateFormat medium = FastDateFormat.getDateTimeInstance(FastDateFormat.SHORT, FastDateFormat.SHORT); 
     assertEquals(medium, format); 
     final SimpleDateFormat sdf = new SimpleDateFormat(); 
     assertEquals(sdf.toPattern(), format.getPattern()); 
     assertEquals(Locale.getDefault(), format.getLocale()); 
     assertEquals(TimeZone.getDefault(), format.getTimeZone()); 
 } 
@Test 
 public void test_getInstance_String6797() { 
     final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy"); 
     final FastDateFormat format2 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     final FastDateFormat format3 = FastDateFormat.getInstance("MM-DD-yyyy"); 
     assertTrue(format1 != format2); 
     assertSame(format2, format3); 
     assertEquals("MM/DD/yyyy", format1.getPattern()); 
     assertEquals(TimeZone.getDefault(), format1.getTimeZone()); 
     assertEquals(TimeZone.getDefault(), format2.getTimeZone()); 
 } 
@Test 
 public void testTimeDefaults6984() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testDateDefaults7208() { 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateInstance(FastDateFormat.LONG), FastDateFormat.getDateInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDateDefaults7245() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync7382() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testTimeDefaults7572() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync8134() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testCheckDefaults8714() { 
     final FastDateFormat format = FastDateFormat.getInstance(); 
     final FastDateFormat medium = FastDateFormat.getDateTimeInstance(FastDateFormat.SHORT, FastDateFormat.SHORT); 
     assertEquals(medium, format); 
     final SimpleDateFormat sdf = new SimpleDateFormat(); 
     assertEquals(sdf.toPattern(), format.getPattern()); 
     assertEquals(Locale.getDefault(), format.getLocale()); 
     assertEquals(TimeZone.getDefault(), format.getTimeZone()); 
 } 
@Test 
 public void testTimeDateDefaults8754() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testTimeDefaults9277() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync9357() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testTimeDateDefaults9380() { 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, Locale.CANADA), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM), FastDateFormat.getDateTimeInstance(FastDateFormat.LONG, FastDateFormat.MEDIUM, TimeZone.getDefault(), Locale.getDefault())); 
 } 
@Test 
 public void testParseSync9386() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testParseSync9474() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 } 
@Test 
 public void testTimeDefaults9539() { 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, Locale.CANADA), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.CANADA)); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York")), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getTimeZone("America/New_York"), Locale.getDefault())); 
     assertEquals(FastDateFormat.getTimeInstance(FastDateFormat.LONG), FastDateFormat.getTimeInstance(FastDateFormat.LONG, TimeZone.getDefault(), Locale.getDefault())); 
 } 
