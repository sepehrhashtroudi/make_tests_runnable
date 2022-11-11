@Test 
 public void testEquals267() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 @SuppressWarnings("unchecked") 
 public void testSerialization293() throws Exception { 
     final MutableTriple<Integer, String, Boolean> origTriple = MutableTriple.of(0, "foo", Boolean.TRUE); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origTriple); 
     final MutableTriple<Integer, String, Boolean> deserializedTriple = (MutableTriple<Integer, String, Boolean>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origTriple, deserializedTriple); 
     assertEquals(origTriple.hashCode(), deserializedTriple.hashCode()); 
 } 
@Test 
 public void testMutate1704() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     triple.setLeft(42); 
     triple.setMiddle("bar"); 
     triple.setRight(Boolean.FALSE); 
     assertEquals(42, triple.getLeft().intValue()); 
     assertEquals("bar", triple.getMiddle()); 
     assertEquals(Boolean.FALSE, triple.getRight()); 
 } 
@Test 
 public void testEquals1792() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testDefault2210() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
@Test 
 public void testDefault2532() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
@Test 
 public void testDefault2829() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
@Test 
 public void testEquals2866() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testDefault3026() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
@Test 
 public void testMutate3044() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     triple.setLeft(42); 
     triple.setMiddle("bar"); 
     triple.setRight(Boolean.FALSE); 
     assertEquals(42, triple.getLeft().intValue()); 
     assertEquals("bar", triple.getMiddle()); 
     assertEquals(Boolean.FALSE, triple.getRight()); 
 } 
@Test 
 public void testEquals3261() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testEquals3769() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testEquals5445() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testEquals5869() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testMutate5911() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     triple.setLeft(42); 
     triple.setMiddle("bar"); 
     triple.setRight(Boolean.FALSE); 
     assertEquals(42, triple.getLeft().intValue()); 
     assertEquals("bar", triple.getMiddle()); 
     assertEquals(Boolean.FALSE, triple.getRight()); 
 } 
@Test 
 public void testEquals6117() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testEquals6121() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testDefault6235() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
@Test 
 public void testMutate6533() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     triple.setLeft(42); 
     triple.setMiddle("bar"); 
     triple.setRight(Boolean.FALSE); 
     assertEquals(42, triple.getLeft().intValue()); 
     assertEquals("bar", triple.getMiddle()); 
     assertEquals(Boolean.FALSE, triple.getRight()); 
 } 
@Test 
 public void testEquals6896() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testDefault7237() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
@Test 
 public void testEquals7381() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testMutate7494() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     triple.setLeft(42); 
     triple.setMiddle("bar"); 
     triple.setRight(Boolean.FALSE); 
     assertEquals(42, triple.getLeft().intValue()); 
     assertEquals("bar", triple.getMiddle()); 
     assertEquals(Boolean.FALSE, triple.getRight()); 
 } 
@Test 
 @SuppressWarnings("unchecked") 
 public void testSerialization8144() throws Exception { 
     final MutableTriple<Integer, String, Boolean> origTriple = MutableTriple.of(0, "foo", Boolean.TRUE); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origTriple); 
     final MutableTriple<Integer, String, Boolean> deserializedTriple = (MutableTriple<Integer, String, Boolean>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origTriple, deserializedTriple); 
     assertEquals(origTriple.hashCode(), deserializedTriple.hashCode()); 
 } 
@Test 
 public void testEquals8246() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testDefault8649() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
@Test 
 public void testEquals8918() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testEquals8945() throws Exception { 
     assertEquals(MutableTriple.of(null, "foo", "baz"), MutableTriple.of(null, "foo", "baz")); 
     assertFalse(MutableTriple.of("foo", 0, Boolean.TRUE).equals(MutableTriple.of("foo", null, Boolean.TRUE))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("xyz", "bar", "baz"))); 
     assertFalse(MutableTriple.of("foo", "bar", "baz").equals(MutableTriple.of("foo", "bar", "blo"))); 
     final MutableTriple<String, String, String> p = MutableTriple.of("foo", "bar", "baz"); 
     assertTrue(p.equals(p)); 
     assertFalse(p.equals(new Object())); 
 } 
@Test 
 public void testMutate9028() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     triple.setLeft(42); 
     triple.setMiddle("bar"); 
     triple.setRight(Boolean.FALSE); 
     assertEquals(42, triple.getLeft().intValue()); 
     assertEquals("bar", triple.getMiddle()); 
     assertEquals(Boolean.FALSE, triple.getRight()); 
 } 
@Test 
 public void testDefault9081() throws Exception { 
     final MutableTriple<Integer, String, Boolean> triple = new MutableTriple<Integer, String, Boolean>(); 
     assertNull(triple.getLeft()); 
     assertNull(triple.getMiddle()); 
     assertNull(triple.getRight()); 
 } 
