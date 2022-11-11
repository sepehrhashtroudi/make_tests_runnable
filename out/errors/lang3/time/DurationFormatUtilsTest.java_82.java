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