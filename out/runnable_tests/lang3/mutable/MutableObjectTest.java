@Test 
 public void testHashCode37() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumD.hashCode()); 
     assertTrue(mutNumA.hashCode() == "ALPHA".hashCode()); 
     assertEquals(0, mutNumD.hashCode()); 
 } 
@Test 
 public void testEquals352() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testEquals501() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testEquals975() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testGetSet1000() { 
     final MutableObject<String> mutNum = new MutableObject<String>(); 
     assertEquals(null, new MutableObject<Object>().getValue()); 
     mutNum.setValue("HELLO"); 
     assertSame("HELLO", mutNum.getValue()); 
     mutNum.setValue(null); 
     assertSame(null, mutNum.getValue()); 
 } 
@Test 
 public void testEquals1218() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testHashCode1250() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumD.hashCode()); 
     assertTrue(mutNumA.hashCode() == "ALPHA".hashCode()); 
     assertEquals(0, mutNumD.hashCode()); 
 } 
@Test 
 public void testEquals2055() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testToString2254() { 
     assertEquals("HI", new MutableObject<String>("HI").toString()); 
     assertEquals("10.0", new MutableObject<Double>(Double.valueOf(10)).toString()); 
     assertEquals("null", new MutableObject<Object>(null).toString()); 
 } 
@Test 
 public void testHashCode2730() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumD.hashCode()); 
     assertTrue(mutNumA.hashCode() == "ALPHA".hashCode()); 
     assertEquals(0, mutNumD.hashCode()); 
 } 
@Test 
 public void testEquals3333() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testGetSet3440() { 
     final MutableObject<String> mutNum = new MutableObject<String>(); 
     assertEquals(null, new MutableObject<Object>().getValue()); 
     mutNum.setValue("HELLO"); 
     assertSame("HELLO", mutNum.getValue()); 
     mutNum.setValue(null); 
     assertSame(null, mutNum.getValue()); 
 } 
@Test 
 public void testGetSet3604() { 
     final MutableObject<String> mutNum = new MutableObject<String>(); 
     assertEquals(null, new MutableObject<Object>().getValue()); 
     mutNum.setValue("HELLO"); 
     assertSame("HELLO", mutNum.getValue()); 
     mutNum.setValue(null); 
     assertSame(null, mutNum.getValue()); 
 } 
@Test 
 public void testEquals3836() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testHashCode4094() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumD.hashCode()); 
     assertTrue(mutNumA.hashCode() == "ALPHA".hashCode()); 
     assertEquals(0, mutNumD.hashCode()); 
 } 
@Test 
 public void testToString5084() { 
     assertEquals("HI", new MutableObject<String>("HI").toString()); 
     assertEquals("10.0", new MutableObject<Double>(Double.valueOf(10)).toString()); 
     assertEquals("null", new MutableObject<Object>(null).toString()); 
 } 
@Test 
 public void testGetSet5310() { 
     final MutableObject<String> mutNum = new MutableObject<String>(); 
     assertEquals(null, new MutableObject<Object>().getValue()); 
     mutNum.setValue("HELLO"); 
     assertSame("HELLO", mutNum.getValue()); 
     mutNum.setValue(null); 
     assertSame(null, mutNum.getValue()); 
 } 
@Test 
 public void testGetSet6587() { 
     final MutableObject<String> mutNum = new MutableObject<String>(); 
     assertEquals(null, new MutableObject<Object>().getValue()); 
     mutNum.setValue("HELLO"); 
     assertSame("HELLO", mutNum.getValue()); 
     mutNum.setValue(null); 
     assertSame(null, mutNum.getValue()); 
 } 
@Test 
 public void testGetSet6705() { 
     final MutableObject<String> mutNum = new MutableObject<String>(); 
     assertEquals(null, new MutableObject<Object>().getValue()); 
     mutNum.setValue("HELLO"); 
     assertSame("HELLO", mutNum.getValue()); 
     mutNum.setValue(null); 
     assertSame(null, mutNum.getValue()); 
 } 
@Test 
 public void testEquals7488() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testEquals7574() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.equals(mutNumA)); 
     assertTrue(mutNumA.equals(mutNumB)); 
     assertTrue(mutNumB.equals(mutNumA)); 
     assertTrue(mutNumB.equals(mutNumB)); 
     assertFalse(mutNumA.equals(mutNumC)); 
     assertFalse(mutNumB.equals(mutNumC)); 
     assertTrue(mutNumC.equals(mutNumC)); 
     assertFalse(mutNumA.equals(mutNumD)); 
     assertTrue(mutNumD.equals(mutNumD)); 
     assertFalse(mutNumA.equals(null)); 
     assertFalse(mutNumA.equals(new Object())); 
     assertFalse(mutNumA.equals("0")); 
 } 
@Test 
 public void testHashCode8234() { 
     final MutableObject<String> mutNumA = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumB = new MutableObject<String>("ALPHA"); 
     final MutableObject<String> mutNumC = new MutableObject<String>("BETA"); 
     final MutableObject<String> mutNumD = new MutableObject<String>(null); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumD.hashCode()); 
     assertTrue(mutNumA.hashCode() == "ALPHA".hashCode()); 
     assertEquals(0, mutNumD.hashCode()); 
 } 
