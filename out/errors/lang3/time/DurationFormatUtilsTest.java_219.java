@Test
public void testLexx11354() { 
         final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal5 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal5.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal5.set(Calendar.MILLISECOND, 989); 
  
         cal6 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(NEW_YORK, Locale.US); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal7.set(Calendar.MILLISECOND, 989);