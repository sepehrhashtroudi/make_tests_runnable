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