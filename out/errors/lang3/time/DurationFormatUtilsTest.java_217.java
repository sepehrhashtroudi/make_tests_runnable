@Test
public void testLexx11352() { 
         final Calendar calendar = Calendar.getInstance(NEW_YORK, Locale.US); 
         calendar.clear(); 
         calendar.set(2003, 1, 10, 15, 33, 20); 
         calendar.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 9, 00, 00); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final long startMillis = calendar.getTimeInMillis(); 
         final long endMillis = calendar.getTimeInMillis(); 
  
         assertEquals("2/10/15", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_YORK)); 
  
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_YORK)); 
  
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_YORK)); 
          
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, startMillis, "yyyyMdH", false, NEW_YORK)); 
         assertEquals("2003/02/10T15:33:20", DurationFormatUtils.formatPeriod(startMillis, endMillis, "yyyyMdH", false, NEW_