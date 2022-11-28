@Test 
 public void testFormat61() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     c.setTimeZone(TimeZone.getDefault()); 
     final StringBuilder buffer = new StringBuilder(); 
     final int year = c.get(Calendar.YEAR); 
     final int month = c.get(Calendar.MONTH) + 1; 
     final int day = c.get(Calendar.DAY_OF_MONTH); 
     final int hour = c.get(Calendar.HOUR_OF_DAY); 
     buffer.append(year); 
     buffer.append(month); 
     buffer.append(day); 
     buffer.append(hour); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH", Locale.US)); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH", Locale.US)); 
 } 
@Test 
 public void testConstructor265() { 
     assertNotNull(new DateFormatUtils()); 
     final Constructor<?>[] cons = DateFormatUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DateFormatUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DateFormatUtils.class.getModifiers())); 
 } 
@Test 
 public void testDateTimeISO817() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.ISO_DATETIME_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
 } 
@Test 
 public void testSMTP923() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2003, 5, 8, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.SMTP_DATETIME_FORMAT.format(cal); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.formatUTC(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 13:11:12 +0000", text); 
 } 
@Test 
 public void testFormat1258() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     c.setTimeZone(TimeZone.getDefault()); 
     final StringBuilder buffer = new StringBuilder(); 
     final int year = c.get(Calendar.YEAR); 
     final int month = c.get(Calendar.MONTH) + 1; 
     final int day = c.get(Calendar.DAY_OF_MONTH); 
     final int hour = c.get(Calendar.HOUR_OF_DAY); 
     buffer.append(year); 
     buffer.append(month); 
     buffer.append(day); 
     buffer.append(hour); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH", Locale.US)); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH", Locale.US)); 
 } 
@Test 
 public void testFormatUTC2896() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
 } 
@Test 
 public void testDateTimeISO3284() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.ISO_DATETIME_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
 } 
@Test 
 public void testFormat3373() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     c.setTimeZone(TimeZone.getDefault()); 
     final StringBuilder buffer = new StringBuilder(); 
     final int year = c.get(Calendar.YEAR); 
     final int month = c.get(Calendar.MONTH) + 1; 
     final int day = c.get(Calendar.DAY_OF_MONTH); 
     final int hour = c.get(Calendar.HOUR_OF_DAY); 
     buffer.append(year); 
     buffer.append(month); 
     buffer.append(day); 
     buffer.append(hour); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH", Locale.US)); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH", Locale.US)); 
 } 
@Test 
 public void testDateTimeISO4244() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.ISO_DATETIME_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
 } 
@Test 
 public void testFormatUTC4633() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
 } 
@Test 
 public void testDateTimeISO4642() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.ISO_DATETIME_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
 } 
@Test 
 public void testFormatUTC5375() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
 } 
@Test 
 public void testDateTimeISO5696() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.ISO_DATETIME_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
 } 
@Test 
 public void testDateTimeISO5862() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.ISO_DATETIME_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
 } 
@Test 
 public void testDateTimeISO6849() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 9, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.ISO_DATETIME_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
     text = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("2002-02-23T09:11:12-03:00", text); 
 } 
@Test 
 public void testFormat7726() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     c.setTimeZone(TimeZone.getDefault()); 
     final StringBuilder buffer = new StringBuilder(); 
     final int year = c.get(Calendar.YEAR); 
     final int month = c.get(Calendar.MONTH) + 1; 
     final int day = c.get(Calendar.DAY_OF_MONTH); 
     final int hour = c.get(Calendar.HOUR_OF_DAY); 
     buffer.append(year); 
     buffer.append(month); 
     buffer.append(day); 
     buffer.append(hour); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH")); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime(), "yyyyMdH", Locale.US)); 
     assertEquals(buffer.toString(), DateFormatUtils.format(c.getTime().getTime(), "yyyyMdH", Locale.US)); 
 } 
@Test 
 public void testConstructor7727() { 
     assertNotNull(new DateFormatUtils()); 
     final Constructor<?>[] cons = DateFormatUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DateFormatUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DateFormatUtils.class.getModifiers())); 
 } 
@Test 
 public void testSMTP7895() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2003, 5, 8, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.SMTP_DATETIME_FORMAT.format(cal); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.formatUTC(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 13:11:12 +0000", text); 
 } 
@Test 
 public void testSMTP7940() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2003, 5, 8, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.SMTP_DATETIME_FORMAT.format(cal); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.formatUTC(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 13:11:12 +0000", text); 
 } 
@Test 
 public void testFormatUTC8013() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
 } 
@Test 
 public void testSMTP8322() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2003, 5, 8, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.SMTP_DATETIME_FORMAT.format(cal); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.formatUTC(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 13:11:12 +0000", text); 
 } 
@Test 
 public void testFormatUTC8464() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
 } 
@Test 
 public void testFormatUTC8507() { 
     final Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC")); 
     c.set(2005, 0, 1, 12, 0, 0); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern())); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
     assertEquals("2005-01-01T12:00:00", DateFormatUtils.formatUTC(c.getTime().getTime(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), Locale.US)); 
 } 
@Test 
 public void testSMTP9257() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2003, 5, 8, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.SMTP_DATETIME_FORMAT.format(cal); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.formatUTC(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 13:11:12 +0000", text); 
 } 
