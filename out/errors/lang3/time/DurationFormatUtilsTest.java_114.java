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