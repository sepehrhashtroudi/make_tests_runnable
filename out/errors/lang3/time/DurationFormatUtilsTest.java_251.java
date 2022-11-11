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