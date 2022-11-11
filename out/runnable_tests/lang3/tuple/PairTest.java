@Test 
 public void testToStringCustom913() throws Exception { 
     final Calendar date = Calendar.getInstance(); 
     date.set(2011, Calendar.APRIL, 25); 
     final Pair<String, Calendar> pair = Pair.of("DOB", date); 
     assertEquals("Test created on " + "04-25-2011", pair.toString("Test created on %2$tm-%2$td-%2$tY")); 
 } 
@Test 
 public void testPairOf2959() throws Exception { 
     final Pair<Integer, String> pair = Pair.of(0, "foo"); 
     assertTrue(pair instanceof ImmutablePair<?, ?>); 
     assertEquals(0, ((ImmutablePair<Integer, String>) pair).left.intValue()); 
     assertEquals("foo", ((ImmutablePair<Integer, String>) pair).right); 
     final Pair<Object, String> pair2 = Pair.of(null, "bar"); 
     assertTrue(pair2 instanceof ImmutablePair<?, ?>); 
     assertNull(((ImmutablePair<Object, String>) pair2).left); 
     assertEquals("bar", ((ImmutablePair<Object, String>) pair2).right); 
 } 
@Test 
 public void testCompatibilityBetweenPairs3336() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testPairOf3644() throws Exception { 
     final Pair<Integer, String> pair = Pair.of(0, "foo"); 
     assertTrue(pair instanceof ImmutablePair<?, ?>); 
     assertEquals(0, ((ImmutablePair<Integer, String>) pair).left.intValue()); 
     assertEquals("foo", ((ImmutablePair<Integer, String>) pair).right); 
     final Pair<Object, String> pair2 = Pair.of(null, "bar"); 
     assertTrue(pair2 instanceof ImmutablePair<?, ?>); 
     assertNull(((ImmutablePair<Object, String>) pair2).left); 
     assertEquals("bar", ((ImmutablePair<Object, String>) pair2).right); 
 } 
@Test 
 public void testCompatibilityBetweenPairs4263() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testCompatibilityBetweenPairs5226() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testCompatibilityBetweenPairs5538() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testCompatibilityBetweenPairs6399() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testCompatibilityBetweenPairs6448() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testComparable17809() throws Exception { 
     final Pair<String, String> pair1 = Pair.of("A", "D"); 
     final Pair<String, String> pair2 = Pair.of("B", "C"); 
     assertTrue(pair1.compareTo(pair1) == 0); 
     assertTrue(pair1.compareTo(pair2) < 0); 
     assertTrue(pair2.compareTo(pair2) == 0); 
     assertTrue(pair2.compareTo(pair1) > 0); 
 } 
@Test 
 public void testCompatibilityBetweenPairs7931() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testCompatibilityBetweenPairs8287() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testCompatibilityBetweenPairs8522() throws Exception { 
     final Pair<Integer, String> pair = ImmutablePair.of(0, "foo"); 
     final Pair<Integer, String> pair2 = MutablePair.of(0, "foo"); 
     assertEquals(pair, pair2); 
     assertEquals(pair.hashCode(), pair2.hashCode()); 
     final HashSet<Pair<Integer, String>> set = new HashSet<Pair<Integer, String>>(); 
     set.add(pair); 
     assertTrue(set.contains(pair2)); 
     pair2.setValue("bar"); 
     assertFalse(pair.equals(pair2)); 
     assertFalse(pair.hashCode() == pair2.hashCode()); 
 } 
@Test 
 public void testComparable18727() throws Exception { 
     final Pair<String, String> pair1 = Pair.of("A", "D"); 
     final Pair<String, String> pair2 = Pair.of("B", "C"); 
     assertTrue(pair1.compareTo(pair1) == 0); 
     assertTrue(pair1.compareTo(pair2) < 0); 
     assertTrue(pair2.compareTo(pair2) == 0); 
     assertTrue(pair2.compareTo(pair1) > 0); 
 } 
@Test 
 public void testToStringCustom8915() throws Exception { 
     final Calendar date = Calendar.getInstance(); 
     date.set(2011, Calendar.APRIL, 25); 
     final Pair<String, Calendar> pair = Pair.of("DOB", date); 
     assertEquals("Test created on " + "04-25-2011", pair.toString("Test created on %2$tm-%2$td-%2$tY")); 
 } 
