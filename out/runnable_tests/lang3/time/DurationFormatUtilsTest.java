@Test 
 public void testLexx84() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testFormatPeriodISO168() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLANG815288() { 
     final Calendar calendar = Calendar.getInstance(); 
     calendar.set(2012, 6, 30, 0, 0, 0); 
     final long startMillis = calendar.getTimeInMillis(); 
     calendar.set(2012, 8, 8); 
     final long endMillis = calendar.getTimeInMillis(); 
     assertEquals("1 9", DurationFormatUtils.formatPeriod(startMillis, endMillis, "M d")); 
 } 
@Test 
 public void testLexx339() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testLexx361() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testFormatPeriodISO483() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLexx649() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testFormatPeriodISO689() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLexx952() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testFormatDuration1102() { 
     long duration = 0; 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "y")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "M")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "d")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "H")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "m")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "s")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "S")); 
     assertEquals("0000", DurationFormatUtils.formatDuration(duration, "SSSS")); 
     assertEquals("0000", DurationFormatUtils.formatDuration(duration, "yyyy")); 
     assertEquals("0000", DurationFormatUtils.formatDuration(duration, "yyMM")); 
     duration = 60 * 1000; 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "y")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "M")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "d")); 
     assertEquals("0", DurationFormatUtils.formatDuration(duration, "H")); 
     assertEquals("1", DurationFormatUtils.formatDuration(duration, "m")); 
     assertEquals("60", DurationFormatUtils.formatDuration(duration, "s")); 
     assertEquals("60000", DurationFormatUtils.formatDuration(duration, "S")); 
     assertEquals("01:00", DurationFormatUtils.formatDuration(duration, "mm:ss")); 
     final Calendar base = Calendar.getInstance(); 
     base.set(2000, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2003, 1, 1, 0, 0, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     duration = cal.getTime().getTime() - base.getTime().getTime(); 
     final int days = 366 + 365 + 365 + 31; 
     assertEquals("0 0 " + days, DurationFormatUtils.formatDuration(duration, "y M d")); 
 } 
@Test 
 public void testLexx1448() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testLexx1836() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testFormatPeriodISO2214() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLexx2428() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testLANG8152650() { 
     final Calendar calendar = Calendar.getInstance(); 
     calendar.set(2012, 6, 30, 0, 0, 0); 
     final long startMillis = calendar.getTimeInMillis(); 
     calendar.set(2012, 8, 8); 
     final long endMillis = calendar.getTimeInMillis(); 
     assertEquals("1 9", DurationFormatUtils.formatPeriod(startMillis, endMillis, "M d")); 
 } 
@Test 
 public void testFormatDurationHMS3181() { 
     long time = 0; 
     assertEquals("0:00:00.000", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1; 
     assertEquals("0:00:00.001", DurationFormatUtils.formatDurationHMS(time)); 
     time = 15; 
     assertEquals("0:00:00.015", DurationFormatUtils.formatDurationHMS(time)); 
     time = 165; 
     assertEquals("0:00:00.165", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1675; 
     assertEquals("0:00:01.675", DurationFormatUtils.formatDurationHMS(time)); 
     time = 13465; 
     assertEquals("0:00:13.465", DurationFormatUtils.formatDurationHMS(time)); 
     time = 72789; 
     assertEquals("0:01:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 32 * 60000; 
     assertEquals("0:32:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 62 * 60000; 
     assertEquals("1:02:12.789", DurationFormatUtils.formatDurationHMS(time)); 
 } 
@Test 
 public void testFormatDurationHMS3298() { 
     long time = 0; 
     assertEquals("0:00:00.000", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1; 
     assertEquals("0:00:00.001", DurationFormatUtils.formatDurationHMS(time)); 
     time = 15; 
     assertEquals("0:00:00.015", DurationFormatUtils.formatDurationHMS(time)); 
     time = 165; 
     assertEquals("0:00:00.165", DurationFormatUtils.formatDurationHMS(time)); 
     time = 1675; 
     assertEquals("0:00:01.675", DurationFormatUtils.formatDurationHMS(time)); 
     time = 13465; 
     assertEquals("0:00:13.465", DurationFormatUtils.formatDurationHMS(time)); 
     time = 72789; 
     assertEquals("0:01:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 32 * 60000; 
     assertEquals("0:32:12.789", DurationFormatUtils.formatDurationHMS(time)); 
     time = 12789 + 62 * 60000; 
     assertEquals("1:02:12.789", DurationFormatUtils.formatDurationHMS(time)); 
 } 
@Test 
 public void testLexx3304() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testConstructor3477() { 
     assertNotNull(new DurationFormatUtils()); 
     final Constructor<?>[] cons = DurationFormatUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DurationFormatUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DurationFormatUtils.class.getModifiers())); 
 } 
@Test 
 public void testFormatPeriodISO3642() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testConstructor4056() { 
     assertNotNull(new DurationFormatUtils()); 
     final Constructor<?>[] cons = DurationFormatUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DurationFormatUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DurationFormatUtils.class.getModifiers())); 
 } 
@Test 
 public void testFormatPeriodISO4295() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testFormatPeriodISO4372() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLexx5824() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testFormatPeriodISO6185() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLexx6700() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testFormatPeriodISO6759() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLexx6850() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testBugzilla384017121() { 
     assertEqualDuration("0000/00/30 16:00:00 000", new int[] { 2006, 0, 26, 18, 47, 34 }, new int[] { 2006, 1, 26, 10, 47, 34 }, "yyyy/MM/dd HH:mm:ss SSS"); 
 } 
@Test 
 public void testLexx7236() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testLANG8157246() { 
     final Calendar calendar = Calendar.getInstance(); 
     calendar.set(2012, 6, 30, 0, 0, 0); 
     final long startMillis = calendar.getTimeInMillis(); 
     calendar.set(2012, 8, 8); 
     final long endMillis = calendar.getTimeInMillis(); 
     assertEquals("1 9", DurationFormatUtils.formatPeriod(startMillis, endMillis, "M d")); 
 } 
@Test 
 public void testFormatPeriodISO7407() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar base = Calendar.getInstance(timeZone); 
     base.set(1970, 0, 1, 0, 0, 0); 
     base.set(Calendar.MILLISECOND, 0); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     cal.set(Calendar.MILLISECOND, 1); 
     String text; 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.formatPeriod(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 } 
@Test 
 public void testLexx7927() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testLexx8138() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testLexx8361() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testBugzilla384018604() { 
     assertEqualDuration("0000/00/30 16:00:00 000", new int[] { 2006, 0, 26, 18, 47, 34 }, new int[] { 2006, 1, 26, 10, 47, 34 }, "yyyy/MM/dd HH:mm:ss SSS"); 
 } 
@Test 
 public void testLexx9056() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
 public void testLexx9199() { 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.y, 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1) }, DurationFormatUtils.lexx("yMdHmsS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 2), new DurationFormatUtils.Token(new StringBuilder(":"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 2), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 3) }, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
     assertArrayEquals(new DurationFormatUtils.Token[] { new DurationFormatUtils.Token(new StringBuilder("P"), 1), new DurationFormatUtils.Token(DurationFormatUtils.y, 4), new DurationFormatUtils.Token(new StringBuilder("Y"), 1), new DurationFormatUtils.Token(DurationFormatUtils.M, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.d, 1), new DurationFormatUtils.Token(new StringBuilder("DT"), 1), new DurationFormatUtils.Token(DurationFormatUtils.H, 1), new DurationFormatUtils.Token(new StringBuilder("H"), 1), new DurationFormatUtils.Token(DurationFormatUtils.m, 1), new DurationFormatUtils.Token(new StringBuilder("M"), 1), new DurationFormatUtils.Token(DurationFormatUtils.s, 1), new DurationFormatUtils.Token(new StringBuilder("."), 1), new DurationFormatUtils.Token(DurationFormatUtils.S, 1), new DurationFormatUtils.Token(new StringBuilder("S"), 1) }, DurationFormatUtils.lexx(DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN)); 
     final DurationFormatUtils.Token token = new DurationFormatUtils.Token(DurationFormatUtils.y, 4); 
     assertFalse("Token equal to non-Token class. ", token.equals(new Object())); 
     assertFalse("Token equal to Token with wrong value class. ", token.equals(new DurationFormatUtils.Token(new Object()))); 
     assertFalse("Token equal to Token with different count. ", token.equals(new DurationFormatUtils.Token(DurationFormatUtils.y, 1))); 
     final DurationFormatUtils.Token numToken = new DurationFormatUtils.Token(Integer.valueOf(1), 4); 
     assertTrue("Token with Number value not equal to itself. ", numToken.equals(numToken)); 
 } 
@Test 
     public void testFormat9568() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testLexx9619() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx_String9652() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     } 
  

@Test 
     public void testLexx_String9694() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormat9695() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final String formattedDate = DateFormatUtils.format(d, DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",  
                         DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",  
                         DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",  
                         DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", false, false, false); 
  
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",  
                       DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",  
                       DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",  
                       DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.
@Test 
     public void testFormatDurationWords9696() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx9697() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:12.14")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.15")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.16")); 
         assertEquals("0", DurationFormatUtils.formatDuration(time,
@Test 
     public void testLexx9698() { 
         assertEquals("0:00:00.000", DurationFormatUtils.lexx("0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.lexx("0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.lexx("0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.lexx("0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.lexx("0:00:00.4")); 
          
         assertEquals("0:00:00.5", DurationFormatUtils.lexx("0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.lexx("0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.lexx("0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.lexx("0:00:00.8")); 
         assertEquals("0:00:00.9", DurationFormatUtils.lexx("0:00:00.9")); 
          
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.10")); 
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.11")); 
         assertEquals("0:00:12", DurationFormatUtils.lexx("0:12:13.4")); 
         assertEquals("0:13:14", DurationFormatUtils.lexx("0:14:15.6")); 
     } 
  

@Test 
     public void testFormat9699() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testLexx9700() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14", DurationFormatUtils.formatDuration(time, "0:14", false)); 
         assertEquals("0:15", DurationFormatUtils.formatDuration(
@Test 
     public void testFormatDurationWords9701() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testLexx_String9702() { 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three"), new Token("four") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("x"), new Token("y"), new Token("z") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
     } 
  

@Test 
     public void testLexx9703() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx_String9704() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testFormatDurationWords9705() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx_String9706() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormat9707() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
          
         assertEquals("2004-02-23T09:00:00.000Z", fdf.format(d)); 
          
         assertEquals("2004-02-23T09:00:00.000Z", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf
@Test 
     public void testLexx9708() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormatDurationWords9709() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatPeriodISO9710() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testFormatPeriodISO9711() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testLexx_String9712() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9713() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormatDurationWords9714() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9715() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testFormatPeriodISO9716() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(timeZone); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(timeZone); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 

@Test 
     public void testFormat9717() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS Z", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
     } 
  

@Test 
     public void testLexx_String9718() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9719() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(0, "00:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(0, "00:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(0, "00:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(0, "00:00:00.3", true)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(0, "00:00:00.4", false)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(0, "00:00:00.5", true)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(0, "00:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(0, "00:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(8, "00:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(8, "00:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(10, "00:00:00.5", false)); 
         assertEquals("0:00:00.11", DurationFormatUtils.formatDuration(11, "00:00:12", false)); 
         assertEquals("12:00:13", DurationFormatUtils.formatDuration(12, "00:13", false)); 
         assertEquals("14:00:14.15", DurationFormatUtils.formatDuration(14, "00:15", false)); 
         assertEquals("
@Test 
     public void testFormatDurationWords9720() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx9721() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx9722() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx9723() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:12.14")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.15")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.16")); 
         assertEquals("0", DurationFormatUtils.formatDuration(time,
@Test 
     public void testLexx_String9724() { 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three"), new Token("four") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("x"), new Token("y"), new Token("z") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
     } 
  

@Test 
     public void testFormatDurationWords9725() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testLexx9726() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:12.14")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.15")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.16")); 
         assertEquals("0", DurationFormatUtils.formatDuration(time,
@Test 
     public void testFormatDurationWords9727() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9728() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9729() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormat9730() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testFormatDurationWords9731() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9732() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx_String9733() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9734() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(0, "00:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(0, "00:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(0, "00:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(0, "00:00:00.3", true)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(0, "00:00:00.4", false)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(0, "00:00:00.5", true)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(0, "00:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(0, "00:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(8, "00:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(8, "00:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(10, "00:00:00.5", false)); 
         assertEquals("0:00:00.11", DurationFormatUtils.formatDuration(11, "00:00:12", false)); 
         assertEquals("12:00:13", DurationFormatUtils.formatDuration(12, "00:13", false)); 
         assertEquals("14:00:14.15", DurationFormatUtils.formatDuration(14, "00:15", false)); 
         assertEquals("
@Test 
     public void testFormatPeriodISO9735() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(timeZone); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final String formattedDate = 
             DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(d); 
             assertEquals("1970-01-01T12:00:00", formattedDate); 
         cal.set(2010, 0, 1, 12, 0, 0); 
             final long millis2 = System.currentTimeMillis(); 
             final String formattedDate3 = 
             DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
             assertEquals("1971-01-01T12:00:00", formattedDate3); 
             assertEquals("1971-01-01T12:00:00", formattedDate4); 
             assertEquals("1971-01-01T12:00:00", formattedDate5); 
             assertEquals("1971-01-01T12:00:00", formattedDate6); 
             assertEquals("1971-01-01T12:00:00", formattedDate7); 
  
             formattedDate = 
             DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(d); 
             assertEquals("1971-01-01T12:00:00", formattedDate7); 
             assertEquals("1971-01-01T12:00:00", formattedDate8); 
             assertEquals("1971-01-01T12:00:00", formattedDate9); 
  
             formattedDate = 
             DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
             assertEquals("1971-01-01T12:00:00", formatted
@Test 
     public void testLexx_String9736() { 
         assertArrayEquals(null, TokenUtils.lexx(null)); 
         assertEquals(0, TokenUtils.lexx("").length); 
  
         assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, TokenUtils.lexx("ab de fg"))); 
  
         assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, TokenUtils.lexx("ab   de fg"))); 
  
         assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, TokenUtils.lexx("ab:cd:ef"))); 
          
         assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, TokenUtils.lexx("number5"))); 
          
         assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, TokenUtils.lexx("fooBar"))); 
         assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, TokenUtils.lexx("foo200Bar"))); 
          
         assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, TokenUtils.lexx("ASFRules"))); 
         assertTrue(ArrayUtils.isEquals(new String[] { "ASFRules" }, TokenUtils.lexx("ASFRules"))); 
     } 
  

@Test 
     public void testLexx_String9737() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9738() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:12.14")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.15")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.16")); 
         assertEquals("0", DurationFormatUtils.formatDuration(time,
@Test 
     public void testLexx_String9739() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     } 
  

@Test 
     public void testLexx_String9740() { 
         assertArrayEquals(new Token[0], lexx("")); 
         assertArrayEquals(new Token[]{Token.valueOf("a")}, lexx("a")); 
         assertArrayEquals(new Token[]{Token.valueOf("b")}, lexx("b")); 
         assertArrayEquals(new Token[]{Token.valueOf("c")}, lexx("c")); 
         assertArrayEquals(new Token[]{Token.valueOf("d"), Token.valueOf("e")}, lexx("d e")); 
         assertArrayEquals(new Token[]{Token.valueOf("1"), Token.valueOf("2")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("3")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("4"), Token.valueOf("5")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("6"), Token.valueOf("7")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("8"), Token.valueOf("9")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("10"), Token.valueOf("11")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("-14"), Token.valueOf("-15")}, lexx("-16")); 
     } 
  

@Test 
     public void testLexx_String9741() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     } 
  

@Test 
     public void testLexx9742() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx9743() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(time, "0:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:00:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14
@Test 
     public void testLexx_String9744() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String9745() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testFormatPeriodISO9746() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(timeZone); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(timeZone); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 

@Test 
     public void testLexx_String9747() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9748() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:00:00.12", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:00:12.14", DurationFormatUtils.formatDuration(time, "0:0:14.15")); 
     } 
  

@Test 
     public void testFormatDurationWords9749() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testFormat9750() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testFormatDurationWords9751() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testLexx_String9752() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormat9753() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testFormat9754() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testLexx9755() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(time, "0:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:00:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14
@Test 
     public void testLexx9756() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormatDurationWords9757() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx9758() { 
         assertEquals("0:00:00.000", DurationFormatUtils.lexx("0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.lexx("0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.lexx("0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.lexx("0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.lexx("0:00:00.4")); 
          
         assertEquals("0:00:00.5", DurationFormatUtils.lexx("0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.lexx("0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.lexx("0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.lexx("0:00:00.8")); 
         assertEquals("0:00:00.9", DurationFormatUtils.lexx("0:00:00.9")); 
          
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.10")); 
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.11")); 
         assertEquals("0:00:12", DurationFormatUtils.lexx("0:12:13.4")); 
         assertEquals("0:13:14", DurationFormatUtils.lexx("0:14:15.6")); 
     } 
  

@Test 
     public void testLexx_String9759() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx_String9760() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormatPeriodISO9761() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testFormatDurationWords9762() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9763() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormat19764() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, 11, 31); 
  
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final String formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2005-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2005-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2005-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmss
@Test 
     public void testLexx_String9765() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormatDurationWords9766() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormat19767() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, 11, 31); 
  
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final String formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2005-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2005-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2005-11-31T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmss
@Test 
     public void testFormatDurationWords9768() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9769() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx9770() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:14:15.6")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:14:15.21")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:14:15.32")); 
         assertEquals("0
@Test 
     public void testLexx9771() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(time, "0:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:00:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14
@Test 
     public void testLexx_String9772() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String9773() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9774() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormat9775() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testLexx_String9776() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     } 
  

@Test 
     public void testLexx_String9777() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9778() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx_String9779() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         final String str = "a b c"; 
         final Token[] tokens = lexx(str); 
         assertEquals(3, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("a", tokens[0].getValue()); 
         assertEquals("b", tokens[1].getClass()); 
         assertEquals("c", tokens[2].getClass()); 
  
         tokens = lexx(str); 
         assertEquals(3, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("a", tokens[1].getClass()); 
         assertEquals("b", tokens[2].getClass()); 
  
         tokens = lexx(str); 
         assertEquals(4, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("c", tokens[1].getClass()); 
         assertEquals("a", tokens[2].getClass()); 
  
         tokens = lexx(str + "b"); 
         assertEquals(6, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("b", tokens[1].getClass()); 
         assertEquals("c", tokens[2].getClass()); 
  
         tokens = lexx(str); 
         assertEquals(7, tokens.length); 
         assertEquals(Token.class, tokens[0].getClass()); 
         assertEquals("a", tokens[1].getClass()); 
         assertEquals("b", tokens[2].getClass()); 
         assertEquals("c", tokens[3].getClass()); 
  
         tokens = lexx(
@Test 
     public void testLexx9780() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormat9781() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testLexx_String9782() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormatDurationWords9783() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatPeriodISO9784() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testLexx_String9785() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String9786() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx_String9787() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testFormatDurationWords9788() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testLexx_String9789() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormatDurationWords9790() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9791() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx9792() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14", DurationFormatUtils.formatDuration(time, "0:14", true)); 
         assertEquals("0:15", DurationFormatUtils.formatDuration(
@Test 
     public void testLexx_String9793() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormat9794() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final String formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(m, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); [EOL
@Test 
     public void testLexx_String9795() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx_String9796() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testFormat9797() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testFormat9798() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
          
         assertEquals("2004-02-23T09:00:00.000Z", fdf.format(d)); 
          
         assertEquals("2004-02-23T09:00:00.000Z", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf.format(new Date(d.getTime()))); 
          
         fdf = getInstance("-0500"); 
         assertEquals("-0500", fdf
@Test 
     public void testLexx_String9799() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String9800() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testFormatDurationWords9801() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testLexx_String9802() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormatPeriodISO9803() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testFormatDurationWords9804() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx_String9805() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx9806() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(time, "0:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:00:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14
@Test 
     public void testFormatDurationWords9807() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testFormatDurationWords9808() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx_String9809() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9810() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx9811() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx9812() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10", false)); 
         assertEquals("0:00:00.11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14", DurationFormatUtils.formatDuration(time, "0:14", false)); 
         assertEquals("0:15", DurationFormatUtils.format
@Test 
     public void testLexx_String9813() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx9814() { 
         assertEquals("0:00:00.000", DurationFormatUtils.lexx("0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.lexx("0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.lexx("0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.lexx("0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.lexx("0:00:00.4")); 
          
         assertEquals("0:00:00.5", DurationFormatUtils.lexx("0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.lexx("0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.lexx("0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.lexx("0:00:00.8")); 
         assertEquals("0:00:00.9", DurationFormatUtils.lexx("0:00:00.9")); 
          
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.10")); 
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.11")); 
         assertEquals("0:12:12", DurationFormatUtils.lexx("0:12:12.13")); 
         assertEquals("0:13:14", DurationFormatUtils.lexx("0:13:14.15")); 
     } 
  

@Test 
     public void testLexx9815() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(0, "00:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(0, "00:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(0, "00:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(0, "00:00:00.3", true)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(0, "00:00:00.4", false)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(0, "00:00:00.5", true)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(0, "00:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(0, "00:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(8, "00:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(8, "00:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(10, "00:00:00.5", false)); 
         assertEquals("0:00:00.11", DurationFormatUtils.formatDuration(11, "00:00:12", false)); 
         assertEquals("12:00:13", DurationFormatUtils.formatDuration(12, "00:13", false)); 
         assertEquals("14:00:14.15", DurationFormatUtils.formatDuration(14, "00:15", false)); 
         assertEquals("
@Test 
     public void testLexx_String9816() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx9817() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(time, "0:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:00:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14
@Test 
     public void testLexx9818() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormatDurationWords9819() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     } 
      

@Test 
     public void testLexx_String9820() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx9821() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx9822() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(time, "0:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:00:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14
@Test 
     public void testFormatDurationWords_Long9823() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     } 
      

@Test 
     public void testFormatPeriodISO9824() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(timeZone); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(timeZone); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 

@Test 
     public void testLexx9825() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx11308() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7.clear(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 
  
         cal7.set(Calendar.MILLISECOND, 989); 
  [
@Test 
     public void testLexx11309() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testFormatPeriod11310() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(0, 1, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(0, 2, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(0, 3, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(0, 4, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(0, 5, "0:00:00.5", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(0, 6, "0:00:00.6", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(0, 7, "0:00:00.7", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.8", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.9", false, TimeZone.getDefault())); 
          
         assertEquals("0:00:00.999", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.999", false, TimeZone.getDefault())); 
         assertEquals("0
@Test 
     public void testLexx11311() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11312() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11313() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -
@Test 
     public void testLexx11314() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11315() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11316() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11317() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11318() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11319() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11320() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(); 
         cal5.clear(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
  
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1,
@Test 
     public void testLexx11321() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11322() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testLexx11323() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11324() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11325() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11326() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11327() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11328() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11329() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7.clear(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 
  
         cal7.set(Calendar.MILLISECOND, 989); 
  [
@Test 
     public void testLexx11330() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11331() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11332() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11333() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11334() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11335() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11336() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11337() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -
@Test 
     public void testFormatPeriod11338() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(time, 0, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(time, 1, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(time, 2, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(time, 3, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(time, 4, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(time, 5, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(time, 6, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(time, 7, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(time, 8, "0:00:00.8")); 
     } 
      

@Test 
     public void testLexx11339() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11340() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11341() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11342() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11343() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11344() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(Calendar.MILLISECOND, 989); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 
  
         cal7.set
@Test 
     public void testLexx11345() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(0, 1, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(0, 2, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(0, 3, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(0, 4, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(0, 5, "0:00:00.5", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(0, 6, "0:00:00.6", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(0, 7, "0:00:00.7", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(12, 14, "0:00:00.8", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.9", false, TimeZone.getDefault())); 
     } 
  

@Test 
     public void testLexx11346() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11347() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11348() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7
@Test 
     public void testLexx11349() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11350() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11351() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11352() { 
         final Calendar calendar = Calendar.getInstance(NEW_YORK, Locale.US); 
         calendar.clear(); 
         calendar.set(2003, 1, 10, 15, 33, 20); 
         calendar.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 9, 00, 00); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final long startMillis = calendar.getTimeInMillis(); 
         final long endMillis = calendar.getTimeInMillis(); 
  
         assertEquals("2/10/15", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_YORK)); 
  
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_YORK)); 
  
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_YORK)); 
          
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, startMillis, "yyyyMdH", false, NEW_YORK)); 
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_
@Test 
     public void testLexx11353() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11354() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11355() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7.clear(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 
  
         final long startMillis = cal.getTime().getTime(); 
  [
@Test 
     public void testLexx11356() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
  
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11357() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11358() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -1, -1, -1, -1); [EOL
@Test 
     public void testLexx11359() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 0); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 0); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 0); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 0); 
  
         final Calendar cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(Calendar.MILLISECOND, 0); 
  
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 0); 
  
         cal7.set(Calendar.MILLISECOND, 0
@Test 
     public void testLexx11360() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
          
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 

@Test 
     public void testLexx11361() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989); 

@Test 
     public void testLexx11362() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(0, 1, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(0, 2, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(0, 3, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(0, 4, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(0, 5, "0:00:00.5", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(0, 6, "0:00:00.6", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(0, 7, "0:00:00.7", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(12, 14, "0:00:00.8", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.9", false, TimeZone.getDefault())); 
     } 
  

@Test 
     public void testLexx11363() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(); 
         cal5.clear(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(); 
         cal6.clear(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal6.set(Calendar.MILLISECOND, 989); 
  
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00,
@Test 
     public void testLexx_String11840() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String11841() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx_String11842() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String11843() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String11844() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testFormatDurationISO11845() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.1", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDurationISO(time)); 
  
         try { 
             DurationFormatUtils.formatDurationISO(time); 
             fail("Expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
         try { 
             DurationFormatUtils.formatDurationISO(time); 
             fail("Expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } [
@Test 
     public void testFormat11846() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testLexx11847() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
         assertEquals(newToken("a"), lexx("a")); 
         assertEquals(newToken("b"), lexx("b")); 
         assertEquals(newToken("c"), lexx("c")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f"), lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("k")); 
         assertEquals(newToken("l"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m")); 
         assertEquals(newToken("n"), lexx("n")); 
         assertEquals(newToken("o"), lexx("o")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f", lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m"));
@Test 
     public void testFormat11848() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 0); 
  
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final String formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 

@Test 
     public void testLexx_String11849() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx_String11850() { 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three"), new Token("four") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("x"), new Token("y"), new Token("z") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
     } 
  

@Test 
     public void testLexx_String11851() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx_String11852() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testLexx_String11853() { 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("d") }, lexx("a b c")), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("a"), new Token("b"), new Token("c"), new Token("
@Test 
     public void testFormat11854() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testLexx_String11855() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     } 
      

@Test 
     public void testLexx11856() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormatPeriodISO11857() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testFormat11858() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final String formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(d, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); 
  
         formattedDate = DateFormatUtils.format(cal, new SimpleDateFormat("yyyyMMddHHmmssSSS")); 
         assertEquals("2004-02-23T09:00:00", formattedDate); [EOL
@Test 
     public void testLexx11859() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
         assertEquals(newToken("a"), lexx("a")); 
         assertEquals(newToken("b"), lexx("b")); 
         assertEquals(newToken("c"), lexx("c")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f"), lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("k")); 
         assertEquals(newToken("l"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m")); 
         assertEquals(newToken("n"), lexx("n")); 
         assertEquals(newToken("o"), lexx("o")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f", lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m"));
@Test 
     public void testLexx11860() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:12.14")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.15")); 
         assertEquals("0:0", DurationFormatUtils.formatDuration(time, "0:14.16")); 
         assertEquals("0", DurationFormatUtils.formatDuration(time,
@Test 
     public void testFormat11861() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

@Test 
     public void testFormatPeriodISO11862() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testFormatPeriodISO11863() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testLexx11864() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.
@Test 
     public void testFormatPeriodISO11865() { 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final long millis = System.currentTimeMillis(); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.set(2010, 0, 1, 12, 0, 0); 
         cal2.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone); 
  
         assertEquals("2/3/04", fdf.format(d)); 
  
         fdf = getInstance("Z"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(d)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03:00", fdf.format(cal2)); 
  
         fdf = getInstance("-03:00"); 
         assertEquals("-03
@Test 
     public void testFormatDurationISO11866() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.1", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDurationISO(time)); 
  
         try { 
             DurationFormatUtils.formatDurationISO(time); 
             fail("Expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
         try { 
             DurationFormatUtils.formatDurationISO(time); 
             fail("Expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } [
@Test 
     public void testLexx11867() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
         assertEquals(newToken("a"), lexx("a")); 
         assertEquals(newToken("b"), lexx("b")); 
         assertEquals(newToken("c"), lexx("c")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f"), lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("k")); 
         assertEquals(newToken("l"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m")); 
         assertEquals(newToken("n"), lexx("n")); 
         assertEquals(newToken("o"), lexx("o")); 
         assertEquals(newToken("d"), lexx("d")); 
         assertEquals(newToken("e"), lexx("e")); 
         assertEquals(newToken("f", lexx("f")); 
         assertEquals(newToken("g"), lexx("g")); 
         assertEquals(newToken("h"), lexx("h")); 
         assertEquals(newToken("i"), lexx("i")); 
         assertEquals(newToken("j"), lexx("j")); 
         assertEquals(newToken("k"), lexx("l")); 
         assertEquals(newToken("m"), lexx("m"));
@Test 
     public void testFormat11868() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     } 
  

