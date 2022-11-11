@Test 
 public void testComparable1395() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 } 
@Test 
 public void testComparable1866() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 } 
@Test 
 public void testComparable1876() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 } 
@Test 
 public void testToStringCustom1991() throws Exception { 
     final Calendar date = Calendar.getInstance(); 
     date.set(2011, Calendar.APRIL, 25); 
     final Triple<String, String, Calendar> triple = Triple.of("DOB", "string", date); 
     assertEquals("Test created on " + "04-25-2011", triple.toString("Test created on %3$tm-%3$td-%3$tY")); 
 } 
@Test 
 public void testFormattable_padded5859() throws Exception { 
     final Triple<String, String, String> triple = Triple.of("Key", "Something", "Value"); 
     assertEquals("         (Key,Something,Value)", String.format("%1$30s", triple)); 
 } 
@Test 
 public void testComparable16935() throws Exception { 
     final Triple<String, String, String> triple1 = Triple.of("A", "D", "A"); 
     final Triple<String, String, String> triple2 = Triple.of("B", "C", "A"); 
     assertTrue(triple1.compareTo(triple1) == 0); 
     assertTrue(triple1.compareTo(triple2) < 0); 
     assertTrue(triple2.compareTo(triple2) == 0); 
     assertTrue(triple2.compareTo(triple1) > 0); 
 } 
@Test 
 public void testFormattable_padded7668() throws Exception { 
     final Triple<String, String, String> triple = Triple.of("Key", "Something", "Value"); 
     assertEquals("         (Key,Something,Value)", String.format("%1$30s", triple)); 
 } 
@Test 
 public void testToStringCustom8892() throws Exception { 
     final Calendar date = Calendar.getInstance(); 
     date.set(2011, Calendar.APRIL, 25); 
     final Triple<String, String, Calendar> triple = Triple.of("DOB", "string", date); 
     assertEquals("Test created on " + "04-25-2011", triple.toString("Test created on %3$tm-%3$td-%3$tY")); 
 } 
