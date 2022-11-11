@Test 
 public void testFormat14() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat203() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat273() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales388() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang303424() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat447() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang303487() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat560() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat666() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat716() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat721() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang645779() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang645828() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat832() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang303875() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat907() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales974() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6451043() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat1123() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6451172() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat1255() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat1259() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat1300() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat1303() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3031442() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testShortDateStyleWithLocales1537() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testShortDateStyleWithLocales1553() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6451619() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat1672() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat1758() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3031788() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat1839() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3031861() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang6452026() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testEquals2157() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testShortDateStyleWithLocales2166() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6452283() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat2400() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat2463() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6452524() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testShortDateStyleWithLocales2565() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang3032634() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang6452639() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat2681() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3032729() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat2798() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat2853() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat2863() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testEquals2938() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testShortDateStyleWithLocales3009() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6453108() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat3236() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3033248() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang6453349() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLocaleMatches3361() { 
     final DatePrinter printer = getInstance(YYYY_MM_DD, SWEDEN); 
     assertEquals(SWEDEN, printer.getLocale()); 
 } 
@Test 
 public void testFormat3368() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales3390() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang3033403() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang6453411() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang6453432() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat3474() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat3488() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLocaleMatches3516() { 
     final DatePrinter printer = getInstance(YYYY_MM_DD, SWEDEN); 
     assertEquals(SWEDEN, printer.getLocale()); 
 } 
@Test 
 public void testFormat3589() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat3645() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testPatternMatches3679() { 
     final DatePrinter printer = getInstance(YYYY_MM_DD); 
     assertEquals(YYYY_MM_DD, printer.getPattern()); 
 } 
@Test 
 public void testFormat3765() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6453801() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat3862() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3034030() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang3034077() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang3034124() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat4160() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat4168() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales4176() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6454338() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang6454344() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang3034368() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testShortDateStyleWithLocales4371() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testEquals4420() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testShortDateStyleWithLocales4451() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testShortDateStyleWithLocales4475() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testEquals4512() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testFormat4523() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6454556() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testToStringContainsName4570() { 
     final DatePrinter printer = getInstance(YYYY_MM_DD); 
     assertTrue(printer.toString().startsWith("FastDate")); 
 } 
@Test 
 public void testLang3034584() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testEquals4710() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testFormat4753() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6454778() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testToStringContainsName4822() { 
     final DatePrinter printer = getInstance(YYYY_MM_DD); 
     assertTrue(printer.toString().startsWith("FastDate")); 
 } 
@Test 
 public void testFormat4941() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6455002() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang6455076() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat5126() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5169() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5200() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6455393() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat5396() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5400() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5442() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5449() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3035457() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat5497() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5521() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5562() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3035639() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat5676() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6455746() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang6455778() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang3035854() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat5861() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat5971() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3035972() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang3036037() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang6456078() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat6087() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat6190() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat6200() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales6277() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testFormat6295() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat6315() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat6380() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang5386564() { 
     final GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT-8")); 
     cal.clear(); 
     cal.set(2009, 9, 16, 8, 42, 16); 
     final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("GMT")); 
     assertEquals("dateTime", "2009-10-16T16:42:16.000Z", format.format(cal.getTime())); 
     assertEquals("dateTime", "2009-10-16T08:42:16.000Z", format.format(cal)); 
 } 
@Test 
 public void testFormat6671() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6456672() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat6692() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales6703() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6456735() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testShortDateStyleWithLocales6798() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6456813() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat6833() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales6868() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6456951() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang6457042() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat7058() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7097() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7128() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7190() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7225() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3037238() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat7252() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7306() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7343() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7361() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testShortDateStyleWithLocales7421() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testFormat7439() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7447() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7477() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6457541() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat7601() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7707() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang5387709() { 
     final GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT-8")); 
     cal.clear(); 
     cal.set(2009, 9, 16, 8, 42, 16); 
     final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("GMT")); 
     assertEquals("dateTime", "2009-10-16T16:42:16.000Z", format.format(cal.getTime())); 
     assertEquals("dateTime", "2009-10-16T08:42:16.000Z", format.format(cal)); 
 } 
@Test 
 public void testFormat7772() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6457800() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testFormat7807() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7841() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7845() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3037852() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat7867() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat7908() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6457988() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testPatternMatches8024() { 
     final DatePrinter printer = getInstance(YYYY_MM_DD); 
     assertEquals(YYYY_MM_DD, printer.getPattern()); 
 } 
@Test 
 public void testLang3038121() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang3038153() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat8172() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8176() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8201() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6458369() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang3038387() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testEquals8420() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testFormat8447() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3038541() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testLang3038560() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testFormat8576() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8595() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8610() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8696() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8777() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8790() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8854() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat8906() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat9053() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat9062() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testFormat9097() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang3039123() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testEquals9160() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testFormat9209() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testLang6459237() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang3039240() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
 public void testShortDateStyleWithLocales9268() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 } 
@Test 
 public void testLang6459360() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 } 
@Test 
 public void testLang5389369() { 
     final GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT-8")); 
     cal.clear(); 
     cal.set(2009, 9, 16, 8, 42, 16); 
     final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("GMT")); 
     assertEquals("dateTime", "2009-10-16T16:42:16.000Z", format.format(cal.getTime())); 
     assertEquals("dateTime", "2009-10-16T08:42:16.000Z", format.format(cal)); 
 } 
@Test 
 public void testFormat9424() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     final TimeZone realDefaultZone = TimeZone.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         TimeZone.setDefault(NEW_YORK); 
         final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
         final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
         final Date date1 = cal1.getTime(); 
         final Date date2 = cal2.getTime(); 
         final long millis1 = date1.getTime(); 
         final long millis2 = date2.getTime(); 
         DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
         assertEquals(sdf.format(date1), fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
         assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
         assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
         fdf = getInstance("Z"); 
         assertEquals("-0500", fdf.format(date1)); 
         assertEquals("-0500", fdf.format(cal1)); 
         assertEquals("-0500", fdf.format(millis1)); 
         assertEquals("-0400", fdf.format(date2)); 
         assertEquals("-0400", fdf.format(cal2)); 
         assertEquals("-0400", fdf.format(millis2)); 
         fdf = getInstance("ZZ"); 
         assertEquals("-05:00", fdf.format(date1)); 
         assertEquals("-05:00", fdf.format(cal1)); 
         assertEquals("-05:00", fdf.format(millis1)); 
         assertEquals("-04:00", fdf.format(date2)); 
         assertEquals("-04:00", fdf.format(cal2)); 
         assertEquals("-04:00", fdf.format(millis2)); 
         final String pattern = "GGGG GGG GG G yyyy yyy yy y MMMM MMM MM M" + " dddd ddd dd d DDDD DDD DD D EEEE EEE EE E aaaa aaa aa a zzzz zzz zz z"; 
         fdf = getInstance(pattern); 
         sdf = new SimpleDateFormat(pattern); 
         assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1)); 
         assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2)); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
         TimeZone.setDefault(realDefaultZone); 
     } 
 } 
@Test 
 public void testEquals9444() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 } 
@Test 
 public void testLang3039486() { 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     DatePrinter format = getInstance(YYYY_MM_DD); 
     final String output = format.format(cal); 
     format = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) format)); 
     assertEquals(output, format.format(cal)); 
 } 
@Test 
     public void testParseDate9643() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testParseDate11620() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11621() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11622() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11623() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11624() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11625() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11626() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testLang64511627() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     } 
      

@Test 
     public void testFormat11628() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11629() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11630() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11631() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11632() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11633() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11634() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11635() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testParseDate11636() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11637() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11638() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11639() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testLang64511640() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     } 
      

@Test 
     public void testParseDate11641() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testParseDate11642() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11643() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testLang64511644() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     } 
      

@Test 
     public void testParseDate11645() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11646() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11647() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testParseDate11648() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testLang64511649() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     } 
      

@Test 
     public void testFormat11650() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11651() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11652() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11653() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11654() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11655() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11656() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11657() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11658() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11659() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11660() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11661() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11662() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11663() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11664() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11665() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11666() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11667() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11668() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11669() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11670() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11671() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11672() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11673() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11674() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testLang64511675() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     } 
      

@Test 
     public void testFormat11676() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11677() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11678() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11679() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11680() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11681() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11682() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11683() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11684() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11685() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testParseDate11686() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11687() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11688() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11689() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11690() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11691() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11692() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11693() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11694() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11695() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11696() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11697() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testParseDate11698() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11699() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11700() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11701() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11702() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11703() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11704() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11705() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testLang64511706() { 
         final Locale locale = new Locale("sv", "SE"); 
  
         final Calendar cal = Calendar.getInstance(); 
         cal.set(2010, 0, 1, 12, 0, 0); 
         final Date d = cal.getTime(); 
  
         final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
  
         assertEquals("fredag, week 53", fdf.format(d)); 
     } 
      

@Test 
     public void testParseDate11707() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11708() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11709() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11710() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11711() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11712() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testParseDate11713() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testParseDate11714() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-
@Test 
     public void testFormat11715() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
@Test 
     public void testFormat11716() { 
         final Locale realDefaultLocale = Locale.getDefault(); 
         final TimeZone realDefaultZone = TimeZone.getDefault(); 
         try { 
             Locale.setDefault(Locale.US); 
             TimeZone.setDefault(NEW_YORK); 
  
             final GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20); 
             final GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00); 
             final Date date1 = cal1.getTime(); 
             final Date date2 = cal2.getTime(); 
             final long millis1 = date1.getTime(); 
             final long millis2 = date2.getTime(); 
  
             DatePrinter fdf = getInstance("yyyy-MM-dd'T'HH:mm:ss"); 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
             assertEquals(sdf.format(date1), fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(date1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(cal1)); 
             assertEquals("2003-01-10T15:33:20", fdf.format(millis1)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(date2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(cal2)); 
             assertEquals("2003-07-10T09:00:00", fdf.format(millis2)); 
  
             fdf = getInstance("Z"); 
             assertEquals("-0500", fdf.format(date1)); 
             assertEquals("-0500", fdf.format(cal1)); 
             assertEquals("-05
