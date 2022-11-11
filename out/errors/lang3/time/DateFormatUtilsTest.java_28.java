@Test
public void testDateTimeISO11943(){ 
         final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
         final Calendar cal = Calendar.getInstance(timeZone); 
         cal.set(2002,1,23,9,11,12); 
         String text = DateFormatUtils.format(cal.getTime(),  
                         DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
         assertEquals("2002-02-23T09:11:12", text); 
         text = DateFormatUtils.format(cal.getTime().getTime(),  
                       DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
         assertEquals("2002-02-23T09:11:12", text); 
          
         text = DateFormatUtils.format(cal.getTime(),  
                       DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
         assertEquals("2002-02-23T09:11:12", text); 
          
         text = DateFormatUtils.format(cal.getTime(),  
                       DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
         assertEquals("2002-02-23T09:11:12", text); 
          
         text = DateFormatUtils.format(cal.getTime().getTime(),  
                       DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
         assertEquals("2002-02-23T09:11:12", text); 
          
         text = DateFormatUtils.format(cal.getTime().getTime(),  
                       DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
         assertEquals("2002-02-23T09:11:12-03:00", text); 
         text = DateFormatUtils.format(cal.getTime().getTime(),  
                       DateFormatUtils.ISO_DATETIME_FORMAT.getPattern(), timeZone); 
         assertEquals("2002-02-23T09:11:12-03