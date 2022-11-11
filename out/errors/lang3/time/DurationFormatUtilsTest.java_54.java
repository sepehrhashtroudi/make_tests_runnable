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