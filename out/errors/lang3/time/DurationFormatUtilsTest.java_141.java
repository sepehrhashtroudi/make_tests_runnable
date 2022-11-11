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