@Test
public void testFormat9660() { 
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