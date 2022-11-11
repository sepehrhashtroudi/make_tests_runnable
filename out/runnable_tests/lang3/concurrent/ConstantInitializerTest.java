@Test 
 public void testGet69() throws ConcurrentException { 
     assertEquals("Wrong object", VALUE, init.get()); 
 } 
@Test 
 public void testGet196() throws ConcurrentException { 
     assertEquals("Wrong object", VALUE, init.get()); 
 } 
@Test 
 public void testEqualsTrue792() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testEqualsTrue1140() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testToStringNull1649() { 
     final String s = new ConstantInitializer<Object>(null).toString(); 
     assertTrue("Object not found: " + s, s.indexOf("object = null") > 0); 
 } 
@Test 
 public void testEqualsTrue2145() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testToStringNull2351() { 
     final String s = new ConstantInitializer<Object>(null).toString(); 
     assertTrue("Object not found: " + s, s.indexOf("object = null") > 0); 
 } 
@Test 
 public void testEqualsWithOtherObjects3148() { 
     checkEquals(null, false); 
     checkEquals(this, false); 
     checkEquals(new ConstantInitializer<String>("Test"), false); 
 } 
@Test 
 public void testEqualsTrue3480() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testEqualsTrue3520() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testEqualsTrue4389() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testGet4669() throws ConcurrentException { 
     assertEquals("Wrong object", VALUE, init.get()); 
 } 
@Test 
 public void testGet6573() throws ConcurrentException { 
     assertEquals("Wrong object", VALUE, init.get()); 
 } 
@Test 
 public void testEqualsTrue7597() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testEqualsTrue7737() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testEqualsTrue8473() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
@Test 
 public void testEqualsTrue9015() { 
     checkEquals(init, true); 
     ConstantInitializer<Integer> init2 = new ConstantInitializer<Integer>(Integer.valueOf(VALUE.intValue())); 
     checkEquals(init2, true); 
     init = new ConstantInitializer<Integer>(null); 
     init2 = new ConstantInitializer<Integer>(null); 
     checkEquals(init2, true); 
 } 
