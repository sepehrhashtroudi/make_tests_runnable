@Test
public void testLexx11313() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2003, 1, 10, 15, 33, 20); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal2 = Calendar.getInstance(); 
         cal2.clear(); 
         cal2.set(2003, 1, 10, 9, 00, 00); 
         cal2.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal3 = Calendar.getInstance(); 
         cal3.clear(); 
         cal3.set(2003, 1, 10, 9, 00, 00); 
         cal3.set(Calendar.MILLISECOND, 989); 
  
         final Calendar cal4 = Calendar.getInstance(); 
         cal4.clear(); 
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal4.set(2003, 1, 10, 9, 00, 00); 
         cal4.set(Calendar.MILLISECOND, 989); 
  
         cal5 = Calendar.getInstance(); 
         cal5.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal6.set(2003, 1, 10, 9, 00, 00); 
         cal7 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8 = Calendar.getInstance(); 
         cal8.set(2003, 1, 10, 9, 00, 00); 
         cal6 = Calendar.getInstance(); 
         cal7.set(2003, 1, 10, 9, 00, 00); 
         cal8.set(-1, -