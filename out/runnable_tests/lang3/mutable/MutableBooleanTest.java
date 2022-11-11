@Test 
 public void testGetSet157() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull2179() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     mutBool.compareTo(null); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull2367() { 
     new MutableBoolean(null); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull2736() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     mutBool.compareTo(null); 
 } 
@Test 
 public void testGetSet2833() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testEquals3224() { 
     final MutableBoolean mutBoolA = new MutableBoolean(false); 
     final MutableBoolean mutBoolB = new MutableBoolean(false); 
     final MutableBoolean mutBoolC = new MutableBoolean(true); 
     assertTrue(mutBoolA.equals(mutBoolA)); 
     assertTrue(mutBoolA.equals(mutBoolB)); 
     assertTrue(mutBoolB.equals(mutBoolA)); 
     assertTrue(mutBoolB.equals(mutBoolB)); 
     assertFalse(mutBoolA.equals(mutBoolC)); 
     assertFalse(mutBoolB.equals(mutBoolC)); 
     assertTrue(mutBoolC.equals(mutBoolC)); 
     assertFalse(mutBoolA.equals(null)); 
     assertFalse(mutBoolA.equals(Boolean.FALSE)); 
     assertFalse(mutBoolA.equals("false")); 
 } 
@Test 
 public void testGetSet3243() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testGetSet3354() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testToString3365() { 
     assertEquals(Boolean.FALSE.toString(), new MutableBoolean(false).toString()); 
     assertEquals(Boolean.TRUE.toString(), new MutableBoolean(true).toString()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull3509() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     mutBool.compareTo(null); 
 } 
@Test 
 public void testCompareTo3553() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(0, mutBool.compareTo(new MutableBoolean(false))); 
     assertEquals(-1, mutBool.compareTo(new MutableBoolean(true))); 
     mutBool.setValue(true); 
     assertEquals(+1, mutBool.compareTo(new MutableBoolean(false))); 
     assertEquals(0, mutBool.compareTo(new MutableBoolean(true))); 
 } 
@Test 
 public void testGetSet4192() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull4264() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     mutBool.compareTo(null); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull4270() { 
     new MutableBoolean(null); 
 } 
@Test 
 public void testEquals4342() { 
     final MutableBoolean mutBoolA = new MutableBoolean(false); 
     final MutableBoolean mutBoolB = new MutableBoolean(false); 
     final MutableBoolean mutBoolC = new MutableBoolean(true); 
     assertTrue(mutBoolA.equals(mutBoolA)); 
     assertTrue(mutBoolA.equals(mutBoolB)); 
     assertTrue(mutBoolB.equals(mutBoolA)); 
     assertTrue(mutBoolB.equals(mutBoolB)); 
     assertFalse(mutBoolA.equals(mutBoolC)); 
     assertFalse(mutBoolB.equals(mutBoolC)); 
     assertTrue(mutBoolC.equals(mutBoolC)); 
     assertFalse(mutBoolA.equals(null)); 
     assertFalse(mutBoolA.equals(Boolean.FALSE)); 
     assertFalse(mutBoolA.equals("false")); 
 } 
@Test 
 public void testGetSet4922() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testGetSet5052() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testCompareTo5104() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(0, mutBool.compareTo(new MutableBoolean(false))); 
     assertEquals(-1, mutBool.compareTo(new MutableBoolean(true))); 
     mutBool.setValue(true); 
     assertEquals(+1, mutBool.compareTo(new MutableBoolean(false))); 
     assertEquals(0, mutBool.compareTo(new MutableBoolean(true))); 
 } 
@Test(expected = NullPointerException.class) 
 public void testConstructorNull5267() { 
     new MutableBoolean(null); 
 } 
@Test 
 public void testEquals5536() { 
     final MutableBoolean mutBoolA = new MutableBoolean(false); 
     final MutableBoolean mutBoolB = new MutableBoolean(false); 
     final MutableBoolean mutBoolC = new MutableBoolean(true); 
     assertTrue(mutBoolA.equals(mutBoolA)); 
     assertTrue(mutBoolA.equals(mutBoolB)); 
     assertTrue(mutBoolB.equals(mutBoolA)); 
     assertTrue(mutBoolB.equals(mutBoolB)); 
     assertFalse(mutBoolA.equals(mutBoolC)); 
     assertFalse(mutBoolB.equals(mutBoolC)); 
     assertTrue(mutBoolC.equals(mutBoolC)); 
     assertFalse(mutBoolA.equals(null)); 
     assertFalse(mutBoolA.equals(Boolean.FALSE)); 
     assertFalse(mutBoolA.equals("false")); 
 } 
@Test 
 public void testGetSet6174() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testEquals6490() { 
     final MutableBoolean mutBoolA = new MutableBoolean(false); 
     final MutableBoolean mutBoolB = new MutableBoolean(false); 
     final MutableBoolean mutBoolC = new MutableBoolean(true); 
     assertTrue(mutBoolA.equals(mutBoolA)); 
     assertTrue(mutBoolA.equals(mutBoolB)); 
     assertTrue(mutBoolB.equals(mutBoolA)); 
     assertTrue(mutBoolB.equals(mutBoolB)); 
     assertFalse(mutBoolA.equals(mutBoolC)); 
     assertFalse(mutBoolB.equals(mutBoolC)); 
     assertTrue(mutBoolC.equals(mutBoolC)); 
     assertFalse(mutBoolA.equals(null)); 
     assertFalse(mutBoolA.equals(Boolean.FALSE)); 
     assertFalse(mutBoolA.equals("false")); 
 } 
@Test 
 public void testGetSet6636() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testGetSet6870() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testHashCode6956() { 
     final MutableBoolean mutBoolA = new MutableBoolean(false); 
     final MutableBoolean mutBoolB = new MutableBoolean(false); 
     final MutableBoolean mutBoolC = new MutableBoolean(true); 
     assertEquals(mutBoolA.hashCode(), mutBoolA.hashCode()); 
     assertEquals(mutBoolA.hashCode(), mutBoolB.hashCode()); 
     assertFalse(mutBoolA.hashCode() == mutBoolC.hashCode()); 
     assertEquals(mutBoolA.hashCode(), Boolean.FALSE.hashCode()); 
     assertEquals(mutBoolC.hashCode(), Boolean.TRUE.hashCode()); 
 } 
@Test 
 public void testGetSet7365() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testGetSet7435() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testGetSet7714() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
@Test 
 public void testToString8090() { 
     assertEquals(Boolean.FALSE.toString(), new MutableBoolean(false).toString()); 
     assertEquals(Boolean.TRUE.toString(), new MutableBoolean(true).toString()); 
 } 
@Test 
 public void testHashCode8513() { 
     final MutableBoolean mutBoolA = new MutableBoolean(false); 
     final MutableBoolean mutBoolB = new MutableBoolean(false); 
     final MutableBoolean mutBoolC = new MutableBoolean(true); 
     assertEquals(mutBoolA.hashCode(), mutBoolA.hashCode()); 
     assertEquals(mutBoolA.hashCode(), mutBoolB.hashCode()); 
     assertFalse(mutBoolA.hashCode() == mutBoolC.hashCode()); 
     assertEquals(mutBoolA.hashCode(), Boolean.FALSE.hashCode()); 
     assertEquals(mutBoolC.hashCode(), Boolean.TRUE.hashCode()); 
 } 
@Test(expected = NullPointerException.class) 
 public void testCompareToNull9009() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     mutBool.compareTo(null); 
 } 
@Test 
 public void testCompareTo9039() { 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(0, mutBool.compareTo(new MutableBoolean(false))); 
     assertEquals(-1, mutBool.compareTo(new MutableBoolean(true))); 
     mutBool.setValue(true); 
     assertEquals(+1, mutBool.compareTo(new MutableBoolean(false))); 
     assertEquals(0, mutBool.compareTo(new MutableBoolean(true))); 
 } 
@Test 
 public void testGetSet9046() { 
     assertFalse(new MutableBoolean().booleanValue()); 
     assertEquals(Boolean.FALSE, new MutableBoolean().getValue()); 
     final MutableBoolean mutBool = new MutableBoolean(false); 
     assertEquals(Boolean.FALSE, mutBool.toBoolean()); 
     assertFalse(mutBool.booleanValue()); 
     assertTrue(mutBool.isFalse()); 
     assertFalse(mutBool.isTrue()); 
     mutBool.setValue(Boolean.TRUE); 
     assertEquals(Boolean.TRUE, mutBool.toBoolean()); 
     assertTrue(mutBool.booleanValue()); 
     assertFalse(mutBool.isFalse()); 
     assertTrue(mutBool.isTrue()); 
     mutBool.setValue(false); 
     assertFalse(mutBool.booleanValue()); 
     mutBool.setValue(true); 
     assertTrue(mutBool.booleanValue()); 
 } 
