@Test 
 public void testBasic291() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic856() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 @SuppressWarnings("unchecked") 
 public void testSerialization951() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> origTriple = ImmutableTriple.of(0, "foo", Boolean.TRUE); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origTriple); 
     final ImmutableTriple<Integer, String, Boolean> deserializedTriple = (ImmutableTriple<Integer, String, Boolean>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origTriple, deserializedTriple); 
     assertEquals(origTriple.hashCode(), deserializedTriple.hashCode()); 
 } 
@Test 
 public void testBasic1422() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic2189() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic2552() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic3443() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic3621() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic4664() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic5987() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 @SuppressWarnings("unchecked") 
 public void testSerialization6600() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> origTriple = ImmutableTriple.of(0, "foo", Boolean.TRUE); 
     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     final ObjectOutputStream out = new ObjectOutputStream(baos); 
     out.writeObject(origTriple); 
     final ImmutableTriple<Integer, String, Boolean> deserializedTriple = (ImmutableTriple<Integer, String, Boolean>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); 
     assertEquals(origTriple, deserializedTriple); 
     assertEquals(origTriple.hashCode(), deserializedTriple.hashCode()); 
 } 
@Test 
 public void testBasic7674() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
@Test 
 public void testBasic8650() throws Exception { 
     final ImmutableTriple<Integer, String, Boolean> triple = new ImmutableTriple<Integer, String, Boolean>(0, "foo", Boolean.TRUE); 
     assertEquals(0, triple.left.intValue()); 
     assertEquals(0, triple.getLeft().intValue()); 
     assertEquals("foo", triple.middle); 
     assertEquals("foo", triple.getMiddle()); 
     assertEquals(Boolean.TRUE, triple.right); 
     assertEquals(Boolean.TRUE, triple.getRight()); 
     final ImmutableTriple<Object, String, Integer> triple2 = new ImmutableTriple<Object, String, Integer>(null, "bar", 42); 
     assertNull(triple2.left); 
     assertNull(triple2.getLeft()); 
     assertEquals("bar", triple2.middle); 
     assertEquals("bar", triple2.getMiddle()); 
     assertEquals(new Integer(42), triple2.right); 
     assertEquals(new Integer(42), triple2.getRight()); 
 } 
