@Test 
 public void test_negate_Boolean12() { 
     assertSame(null, BooleanUtils.negate(null)); 
     assertSame(Boolean.TRUE, BooleanUtils.negate(Boolean.FALSE)); 
     assertSame(Boolean.FALSE, BooleanUtils.negate(Boolean.TRUE)); 
 } 
@Test 
 public void test_toBooleanObject_Integer18() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(1))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(-1))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
     assertEquals(null, BooleanUtils.toBooleanObject((Integer) null)); 
 } 
@Test 
 public void test_toString_Boolean_String_String_String26() { 
     assertEquals("U", BooleanUtils.toString((Boolean) null, "Y", "N", "U")); 
     assertEquals("Y", BooleanUtils.toString(Boolean.TRUE, "Y", "N", "U")); 
     assertEquals("N", BooleanUtils.toString(Boolean.FALSE, "Y", "N", "U")); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_nullValue116() { 
     BooleanUtils.toBooleanObject(null, Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test 
 public void test_toBoolean_Integer_Integer_Integer219() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 } 
@Test 
 public void test_negate_Boolean318() { 
     assertSame(null, BooleanUtils.negate(null)); 
     assertSame(Boolean.TRUE, BooleanUtils.negate(Boolean.FALSE)); 
     assertSame(Boolean.FALSE, BooleanUtils.negate(Boolean.TRUE)); 
 } 
@Test 
 public void test_toBoolean_String362() { 
     assertFalse(BooleanUtils.toBoolean((String) null)); 
     assertFalse(BooleanUtils.toBoolean("")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("oof")); 
     assertFalse(BooleanUtils.toBoolean("yep")); 
     assertFalse(BooleanUtils.toBoolean("trux")); 
     assertFalse(BooleanUtils.toBoolean("false")); 
     assertFalse(BooleanUtils.toBoolean("a")); 
     assertTrue(BooleanUtils.toBoolean("true")); 
     assertTrue(BooleanUtils.toBoolean(new StringBuffer("tr").append("ue").toString())); 
     assertTrue(BooleanUtils.toBoolean("truE")); 
     assertTrue(BooleanUtils.toBoolean("trUe")); 
     assertTrue(BooleanUtils.toBoolean("trUE")); 
     assertTrue(BooleanUtils.toBoolean("tRue")); 
     assertTrue(BooleanUtils.toBoolean("tRuE")); 
     assertTrue(BooleanUtils.toBoolean("tRUe")); 
     assertTrue(BooleanUtils.toBoolean("tRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUe")); 
     assertTrue(BooleanUtils.toBoolean("TRuE")); 
     assertTrue(BooleanUtils.toBoolean("TRue")); 
     assertTrue(BooleanUtils.toBoolean("TrUE")); 
     assertTrue(BooleanUtils.toBoolean("TrUe")); 
     assertTrue(BooleanUtils.toBoolean("TruE")); 
     assertTrue(BooleanUtils.toBoolean("True")); 
     assertTrue(BooleanUtils.toBoolean("on")); 
     assertTrue(BooleanUtils.toBoolean("oN")); 
     assertTrue(BooleanUtils.toBoolean("On")); 
     assertTrue(BooleanUtils.toBoolean("ON")); 
     assertTrue(BooleanUtils.toBoolean("yes")); 
     assertTrue(BooleanUtils.toBoolean("yeS")); 
     assertTrue(BooleanUtils.toBoolean("yEs")); 
     assertTrue(BooleanUtils.toBoolean("yES")); 
     assertTrue(BooleanUtils.toBoolean("Yes")); 
     assertTrue(BooleanUtils.toBoolean("YeS")); 
     assertTrue(BooleanUtils.toBoolean("YEs")); 
     assertTrue(BooleanUtils.toBoolean("YES")); 
     assertFalse(BooleanUtils.toBoolean("yes?")); 
     assertFalse(BooleanUtils.toBoolean("tru")); 
     assertFalse(BooleanUtils.toBoolean("no")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("yoo")); 
 } 
@Test 
 public void test_toBoolean_int397() { 
     assertTrue(BooleanUtils.toBoolean(1)); 
     assertTrue(BooleanUtils.toBoolean(-1)); 
     assertFalse(BooleanUtils.toBoolean(0)); 
 } 
@Test 
 public void testAnd_object_validInput_3items413() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_emptyInput422() { 
     BooleanUtils.xor(new Boolean[] {}); 
 } 
@Test 
 public void test_isTrue_Boolean558() { 
     assertTrue(BooleanUtils.isTrue(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isTrue(Boolean.FALSE)); 
     assertFalse(BooleanUtils.isTrue((Boolean) null)); 
 } 
@Test 
 public void test_toBooleanDefaultIfNull_Boolean_boolean752() { 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, false)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, false)); 
 } 
@Test 
 public void test_isNotFalse_Boolean873() { 
     assertTrue(BooleanUtils.isNotFalse(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isNotFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotFalse((Boolean) null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_nullValue926() { 
     BooleanUtils.toBooleanObject(null, Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test 
 public void test_toBoolean_int_int_int977() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
 } 
@Test 
 public void test_toBoolean_String1012() { 
     assertFalse(BooleanUtils.toBoolean((String) null)); 
     assertFalse(BooleanUtils.toBoolean("")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("oof")); 
     assertFalse(BooleanUtils.toBoolean("yep")); 
     assertFalse(BooleanUtils.toBoolean("trux")); 
     assertFalse(BooleanUtils.toBoolean("false")); 
     assertFalse(BooleanUtils.toBoolean("a")); 
     assertTrue(BooleanUtils.toBoolean("true")); 
     assertTrue(BooleanUtils.toBoolean(new StringBuffer("tr").append("ue").toString())); 
     assertTrue(BooleanUtils.toBoolean("truE")); 
     assertTrue(BooleanUtils.toBoolean("trUe")); 
     assertTrue(BooleanUtils.toBoolean("trUE")); 
     assertTrue(BooleanUtils.toBoolean("tRue")); 
     assertTrue(BooleanUtils.toBoolean("tRuE")); 
     assertTrue(BooleanUtils.toBoolean("tRUe")); 
     assertTrue(BooleanUtils.toBoolean("tRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUe")); 
     assertTrue(BooleanUtils.toBoolean("TRuE")); 
     assertTrue(BooleanUtils.toBoolean("TRue")); 
     assertTrue(BooleanUtils.toBoolean("TrUE")); 
     assertTrue(BooleanUtils.toBoolean("TrUe")); 
     assertTrue(BooleanUtils.toBoolean("TruE")); 
     assertTrue(BooleanUtils.toBoolean("True")); 
     assertTrue(BooleanUtils.toBoolean("on")); 
     assertTrue(BooleanUtils.toBoolean("oN")); 
     assertTrue(BooleanUtils.toBoolean("On")); 
     assertTrue(BooleanUtils.toBoolean("ON")); 
     assertTrue(BooleanUtils.toBoolean("yes")); 
     assertTrue(BooleanUtils.toBoolean("yeS")); 
     assertTrue(BooleanUtils.toBoolean("yEs")); 
     assertTrue(BooleanUtils.toBoolean("yES")); 
     assertTrue(BooleanUtils.toBoolean("Yes")); 
     assertTrue(BooleanUtils.toBoolean("YeS")); 
     assertTrue(BooleanUtils.toBoolean("YEs")); 
     assertTrue(BooleanUtils.toBoolean("YES")); 
     assertFalse(BooleanUtils.toBoolean("yes?")); 
     assertFalse(BooleanUtils.toBoolean("tru")); 
     assertFalse(BooleanUtils.toBoolean("no")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("yoo")); 
 } 
@Test 
 public void test_isNotTrue_Boolean1219() { 
     assertFalse(BooleanUtils.isNotTrue(Boolean.TRUE)); 
     assertTrue(BooleanUtils.isNotTrue(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotTrue((Boolean) null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_int_int_int_noMatch1335() { 
     BooleanUtils.toBooleanObject(9, 6, 7, 8); 
 } 
@Test 
 public void test_toStringTrueFalse_boolean1342() { 
     assertEquals("true", BooleanUtils.toStringTrueFalse(true)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(false)); 
 } 
@Test 
 public void testXor_object_validInput_2items1351() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toInteger_Boolean_int_int_int1366() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(null, 6, 7, 8)); 
 } 
@Test 
 public void test_toBooleanObject_int1418() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(1)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(-1)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(0)); 
 } 
@Test 
 public void test_toBoolean_Boolean1497() { 
     assertTrue(BooleanUtils.toBoolean(Boolean.TRUE)); 
     assertFalse(BooleanUtils.toBoolean(Boolean.FALSE)); 
     assertFalse(BooleanUtils.toBoolean((Boolean) null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_emptyInput1511() { 
     BooleanUtils.xor(new Boolean[] {}); 
 } 
@Test 
 public void testAnd_primitive_validInput_3items1613() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new boolean[] { false, false, true })); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new boolean[] { false, true, false })); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new boolean[] { true, false, false })); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new boolean[] { true, true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false, false })); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new boolean[] { true, true, false })); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new boolean[] { true, false, true })); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new boolean[] { false, true, true })); 
 } 
@Test 
 public void test_toBoolean_String_String_String1641() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toBoolean_int_int_int1660() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_String_String_String_nullValue1706() { 
     BooleanUtils.toBoolean(null, "Y", "N"); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String1738() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test 
 public void test_toBooleanDefaultIfNull_Boolean_boolean1797() { 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, false)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, false)); 
 } 
@Test 
 public void testAnd_object_validInput_3items1801() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_primitive_emptyInput1807() { 
     BooleanUtils.xor(new boolean[] {}); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_int_int_int_noMatch1927() { 
     BooleanUtils.toBoolean(8, 6, 7); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_Integer_Integer_Integer_noMatch1947() { 
     BooleanUtils.toBoolean(Integer.valueOf(8), Integer.valueOf(6), Integer.valueOf(7)); 
 } 
@Test 
 public void testAnd_object_validInput_3items1970() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void testConstructor2048() { 
     assertNotNull(new BooleanUtils()); 
     final Constructor<?>[] cons = BooleanUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(BooleanUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(BooleanUtils.class.getModifiers())); 
 } 
@Test 
 public void test_toBoolean_String_String_String2088() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String2099() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test 
 public void testXor_object_validInput_2items2144() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_primitive_emptyInput2225() { 
     BooleanUtils.xor(new boolean[] {}); 
 } 
@Test 
 public void test_toIntegerObject_Boolean2244() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(Boolean.TRUE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(Boolean.FALSE)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null)); 
 } 
@Test 
 public void testAnd_primitive_validInput_3items2269() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new boolean[] { false, false, true })); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new boolean[] { false, true, false })); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new boolean[] { true, false, false })); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new boolean[] { true, true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false, false })); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new boolean[] { true, true, false })); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new boolean[] { true, false, true })); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new boolean[] { false, true, true })); 
 } 
@Test 
 public void test_toBoolean_String_String_String2301() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toBooleanObject_Integer2305() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(1))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(-1))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
     assertEquals(null, BooleanUtils.toBooleanObject((Integer) null)); 
 } 
@Test 
 public void test_negate_Boolean2489() { 
     assertSame(null, BooleanUtils.negate(null)); 
     assertSame(Boolean.TRUE, BooleanUtils.negate(Boolean.FALSE)); 
     assertSame(Boolean.FALSE, BooleanUtils.negate(Boolean.TRUE)); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String2491() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test 
 public void test_toBoolean_String2680() { 
     assertFalse(BooleanUtils.toBoolean((String) null)); 
     assertFalse(BooleanUtils.toBoolean("")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("oof")); 
     assertFalse(BooleanUtils.toBoolean("yep")); 
     assertFalse(BooleanUtils.toBoolean("trux")); 
     assertFalse(BooleanUtils.toBoolean("false")); 
     assertFalse(BooleanUtils.toBoolean("a")); 
     assertTrue(BooleanUtils.toBoolean("true")); 
     assertTrue(BooleanUtils.toBoolean(new StringBuffer("tr").append("ue").toString())); 
     assertTrue(BooleanUtils.toBoolean("truE")); 
     assertTrue(BooleanUtils.toBoolean("trUe")); 
     assertTrue(BooleanUtils.toBoolean("trUE")); 
     assertTrue(BooleanUtils.toBoolean("tRue")); 
     assertTrue(BooleanUtils.toBoolean("tRuE")); 
     assertTrue(BooleanUtils.toBoolean("tRUe")); 
     assertTrue(BooleanUtils.toBoolean("tRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUE")); 
     assertTrue(BooleanUtils.toBoolean("TRUe")); 
     assertTrue(BooleanUtils.toBoolean("TRuE")); 
     assertTrue(BooleanUtils.toBoolean("TRue")); 
     assertTrue(BooleanUtils.toBoolean("TrUE")); 
     assertTrue(BooleanUtils.toBoolean("TrUe")); 
     assertTrue(BooleanUtils.toBoolean("TruE")); 
     assertTrue(BooleanUtils.toBoolean("True")); 
     assertTrue(BooleanUtils.toBoolean("on")); 
     assertTrue(BooleanUtils.toBoolean("oN")); 
     assertTrue(BooleanUtils.toBoolean("On")); 
     assertTrue(BooleanUtils.toBoolean("ON")); 
     assertTrue(BooleanUtils.toBoolean("yes")); 
     assertTrue(BooleanUtils.toBoolean("yeS")); 
     assertTrue(BooleanUtils.toBoolean("yEs")); 
     assertTrue(BooleanUtils.toBoolean("yES")); 
     assertTrue(BooleanUtils.toBoolean("Yes")); 
     assertTrue(BooleanUtils.toBoolean("YeS")); 
     assertTrue(BooleanUtils.toBoolean("YEs")); 
     assertTrue(BooleanUtils.toBoolean("YES")); 
     assertFalse(BooleanUtils.toBoolean("yes?")); 
     assertFalse(BooleanUtils.toBoolean("tru")); 
     assertFalse(BooleanUtils.toBoolean("no")); 
     assertFalse(BooleanUtils.toBoolean("off")); 
     assertFalse(BooleanUtils.toBoolean("yoo")); 
 } 
@Test 
 public void test_negate_Boolean2697() { 
     assertSame(null, BooleanUtils.negate(null)); 
     assertSame(Boolean.TRUE, BooleanUtils.negate(Boolean.FALSE)); 
     assertSame(Boolean.FALSE, BooleanUtils.negate(Boolean.TRUE)); 
 } 
@Test 
 public void test_toIntegerObject_boolean2751() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(true)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(false)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_noMatch2822() { 
     BooleanUtils.toBooleanObject(Integer.valueOf(9), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test 
 public void test_toIntegerObject_Boolean2858() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(Boolean.TRUE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(Boolean.FALSE)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_nullValue3007() { 
     BooleanUtils.toBooleanObject(null, Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_Integer_Integer_Integer_noMatch3032() { 
     BooleanUtils.toBoolean(Integer.valueOf(8), Integer.valueOf(6), Integer.valueOf(7)); 
 } 
@Test 
 public void testXor_object_validInput_2items3218() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toBooleanDefaultIfNull_Boolean_boolean3382() { 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, false)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, false)); 
 } 
@Test 
 public void test_toString_Boolean_String_String_String3391() { 
     assertEquals("U", BooleanUtils.toString((Boolean) null, "Y", "N", "U")); 
     assertEquals("Y", BooleanUtils.toString(Boolean.TRUE, "Y", "N", "U")); 
     assertEquals("N", BooleanUtils.toString(Boolean.FALSE, "Y", "N", "U")); 
 } 
@Test 
 public void test_toStringYesNo_Boolean3392() { 
     assertEquals(null, BooleanUtils.toStringYesNo((Boolean) null)); 
     assertEquals("yes", BooleanUtils.toStringYesNo(Boolean.TRUE)); 
     assertEquals("no", BooleanUtils.toStringYesNo(Boolean.FALSE)); 
 } 
@Test 
 public void test_toStringOnOff_boolean3500() { 
     assertEquals("on", BooleanUtils.toStringOnOff(true)); 
     assertEquals("off", BooleanUtils.toStringOnOff(false)); 
 } 
@Test 
 public void test_toBoolean_String_String_String3595() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer3666() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((Integer) null, null, seven, eight)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((Integer) null, six, null, eight)); 
     assertSame(null, BooleanUtils.toBooleanObject((Integer) null, six, seven, null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, eight)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, eight)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(8), six, seven, eight)); 
 } 
@Test 
 public void testConstructor3715() { 
     assertNotNull(new BooleanUtils()); 
     final Constructor<?>[] cons = BooleanUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(BooleanUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(BooleanUtils.class.getModifiers())); 
 } 
@Test 
 public void test_toIntegerObject_Boolean3797() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(Boolean.TRUE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(Boolean.FALSE)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_int_int_int_noMatch3804() { 
     BooleanUtils.toBooleanObject(9, 6, 7, 8); 
 } 
@Test 
 public void test_toStringYesNo_boolean3819() { 
     assertEquals("yes", BooleanUtils.toStringYesNo(true)); 
     assertEquals("no", BooleanUtils.toStringYesNo(false)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_nullElementInput3899() { 
     BooleanUtils.xor(new Boolean[] { null }); 
 } 
@Test 
 public void test_toBooleanObject_int_int_int3939() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(6, 6, 7, 8)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(7, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toBooleanObject(8, 6, 7, 8)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_nullInput3950() { 
     BooleanUtils.xor((Boolean[]) null); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_Integer_Integer_Integer_noMatch3952() { 
     BooleanUtils.toBoolean(Integer.valueOf(8), Integer.valueOf(6), Integer.valueOf(7)); 
 } 
@Test 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer3961() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((Integer) null, null, seven, eight)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((Integer) null, six, null, eight)); 
     assertSame(null, BooleanUtils.toBooleanObject((Integer) null, six, seven, null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, eight)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, eight)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(8), six, seven, eight)); 
 } 
@Test 
 public void testAnd_primitive_validInput_3items4033() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new boolean[] { false, false, true })); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new boolean[] { false, true, false })); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new boolean[] { true, false, false })); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new boolean[] { true, true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false, false })); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new boolean[] { true, true, false })); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new boolean[] { true, false, true })); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new boolean[] { false, true, true })); 
 } 
@Test 
 public void test_toIntegerObject_boolean4039() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(true)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(false)); 
 } 
@Test 
 public void test_toInteger_boolean4065() { 
     assertEquals(1, BooleanUtils.toInteger(true)); 
     assertEquals(0, BooleanUtils.toInteger(false)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_primitive_nullInput4073() { 
     BooleanUtils.xor((boolean[]) null); 
 } 
@Test 
 public void test_toBooleanObject_Integer4079() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(1))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(-1))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
     assertEquals(null, BooleanUtils.toBooleanObject((Integer) null)); 
 } 
@Test 
 public void test_toIntegerObject_Boolean_Integer_Integer_Integer4175() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertEquals(six, BooleanUtils.toIntegerObject(Boolean.TRUE, six, seven, eight)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(Boolean.FALSE, six, seven, eight)); 
     assertEquals(eight, BooleanUtils.toIntegerObject((Boolean) null, six, seven, eight)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null, six, seven, null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue4180() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
 } 
@Test 
 public void test_toString_boolean_String_String_String4256() { 
     assertEquals("Y", BooleanUtils.toString(true, "Y", "N")); 
     assertEquals("N", BooleanUtils.toString(false, "Y", "N")); 
 } 
@Test 
 public void test_toStringYesNo_boolean4323() { 
     assertEquals("yes", BooleanUtils.toStringYesNo(true)); 
     assertEquals("no", BooleanUtils.toStringYesNo(false)); 
 } 
@Test 
 public void test_toBoolean_Integer_Integer_Integer4369() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 } 
@Test 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer4391() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((Integer) null, null, seven, eight)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((Integer) null, six, null, eight)); 
     assertSame(null, BooleanUtils.toBooleanObject((Integer) null, six, seven, null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, eight)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, eight)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(8), six, seven, eight)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_emptyInput4421() { 
     BooleanUtils.and(new boolean[] {}); 
 } 
@Test 
 public void testAnd_primitive_validInput_3items4534() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new boolean[] { false, false, true })); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new boolean[] { false, true, false })); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new boolean[] { true, false, false })); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new boolean[] { true, true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false, false })); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new boolean[] { true, true, false })); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new boolean[] { true, false, true })); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new boolean[] { false, true, true })); 
 } 
@Test 
 public void test_toBoolean_String_String_String4566() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toInteger_Boolean_int_int_int4609() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(null, 6, 7, 8)); 
 } 
@Test 
 public void test_toString_Boolean_String_String_String4653() { 
     assertEquals("U", BooleanUtils.toString((Boolean) null, "Y", "N", "U")); 
     assertEquals("Y", BooleanUtils.toString(Boolean.TRUE, "Y", "N", "U")); 
     assertEquals("N", BooleanUtils.toString(Boolean.FALSE, "Y", "N", "U")); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_emptyInput4696() { 
     BooleanUtils.xor(new Boolean[] {}); 
 } 
@Test 
 public void test_toBoolean_String_String_String4803() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String4808() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer4825() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((Integer) null, null, seven, eight)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((Integer) null, six, null, eight)); 
     assertSame(null, BooleanUtils.toBooleanObject((Integer) null, six, seven, null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, eight)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, eight)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(8), six, seven, eight)); 
 } 
@Test 
 public void test_toIntegerObject_Boolean_Integer_Integer_Integer4865() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertEquals(six, BooleanUtils.toIntegerObject(Boolean.TRUE, six, seven, eight)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(Boolean.FALSE, six, seven, eight)); 
     assertEquals(eight, BooleanUtils.toIntegerObject((Boolean) null, six, seven, eight)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null, six, seven, null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_Integer_Integer_Integer_noMatch4903() { 
     BooleanUtils.toBoolean(Integer.valueOf(8), Integer.valueOf(6), Integer.valueOf(7)); 
 } 
@Test 
 public void testXor_object_validInput_2items4966() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toStringOnOff_boolean4979() { 
     assertEquals("on", BooleanUtils.toStringOnOff(true)); 
     assertEquals("off", BooleanUtils.toStringOnOff(false)); 
 } 
@Test 
 public void test_toString_boolean_String_String_String5008() { 
     assertEquals("Y", BooleanUtils.toString(true, "Y", "N")); 
     assertEquals("N", BooleanUtils.toString(false, "Y", "N")); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String5013() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_int_int_int_noMatch5166() { 
     BooleanUtils.toBooleanObject(9, 6, 7, 8); 
 } 
@Test 
 public void test_isNotTrue_Boolean5241() { 
     assertFalse(BooleanUtils.isNotTrue(Boolean.TRUE)); 
     assertTrue(BooleanUtils.isNotTrue(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotTrue((Boolean) null)); 
 } 
@Test 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer5352() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((Integer) null, null, seven, eight)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((Integer) null, six, null, eight)); 
     assertSame(null, BooleanUtils.toBooleanObject((Integer) null, six, seven, null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, eight)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, eight)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(8), six, seven, eight)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testOr_primitive_nullInput5359() { 
     BooleanUtils.or((boolean[]) null); 
 } 
@Test 
 public void testXor_object_validInput_2items5474() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer5484() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((Integer) null, null, seven, eight)); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((Integer) null, six, null, eight)); 
     assertSame(null, BooleanUtils.toBooleanObject((Integer) null, six, seven, null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(6), six, seven, eight)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(7), six, seven, eight)); 
     assertEquals(null, BooleanUtils.toBooleanObject(Integer.valueOf(8), six, seven, eight)); 
 } 
@Test 
 public void testXor_object_validInput_2items5489() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toBoolean_int_int_int5571() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
 } 
@Test 
 public void test_toString_Boolean_String_String_String5646() { 
     assertEquals("U", BooleanUtils.toString((Boolean) null, "Y", "N", "U")); 
     assertEquals("Y", BooleanUtils.toString(Boolean.TRUE, "Y", "N", "U")); 
     assertEquals("N", BooleanUtils.toString(Boolean.FALSE, "Y", "N", "U")); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue5648() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String5675() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test 
 public void test_isTrue_Boolean5708() { 
     assertTrue(BooleanUtils.isTrue(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isTrue(Boolean.FALSE)); 
     assertFalse(BooleanUtils.isTrue((Boolean) null)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testOr_primitive_emptyInput5784() { 
     BooleanUtils.or(new boolean[] {}); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue5822() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
 } 
@Test 
 public void test_toIntegerObject_Boolean_Integer_Integer_Integer5829() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertEquals(six, BooleanUtils.toIntegerObject(Boolean.TRUE, six, seven, eight)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(Boolean.FALSE, six, seven, eight)); 
     assertEquals(eight, BooleanUtils.toIntegerObject((Boolean) null, six, seven, eight)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null, six, seven, null)); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String5832() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test 
 public void test_toBoolean_String_String_String5846() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullInput5871() { 
     BooleanUtils.or((Boolean[]) null); 
 } 
@Test 
 public void testXor_object_validInput_2items5909() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_isNotFalse_Boolean6131() { 
     assertTrue(BooleanUtils.isNotFalse(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isNotFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotFalse((Boolean) null)); 
 } 
@Test 
 public void test_toBoolean_int_int_int6133() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
 } 
@Test 
 public void test_toBoolean_Integer_Integer_Integer6145() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 } 
@Test 
 public void test_toBoolean_Integer_Integer_Integer6148() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 } 
@Test 
 public void testXor_object_validInput_2items6158() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_int_int_int_noMatch6169() { 
     BooleanUtils.toBooleanObject(9, 6, 7, 8); 
 } 
@Test 
 public void test_isNotFalse_Boolean6209() { 
     assertTrue(BooleanUtils.isNotFalse(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isNotFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotFalse((Boolean) null)); 
 } 
@Test 
 public void test_toInteger_boolean_int_int6284() { 
     assertEquals(6, BooleanUtils.toInteger(true, 6, 7)); 
     assertEquals(7, BooleanUtils.toInteger(false, 6, 7)); 
 } 
@Test 
 public void test_toBoolean_String_String_String6304() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void testAnd_object_validInput_3items6308() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toBoolean_Integer_Integer_Integer6506() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 } 
@Test 
 public void test_toBooleanObject_Integer6532() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(1))); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(Integer.valueOf(-1))); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(Integer.valueOf(0))); 
     assertEquals(null, BooleanUtils.toBooleanObject((Integer) null)); 
 } 
@Test 
 public void test_toInteger_Boolean_int_int_int6619() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(null, 6, 7, 8)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_noMatch6629() { 
     BooleanUtils.toBooleanObject(Integer.valueOf(9), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_nullInput6630() { 
     BooleanUtils.and((Boolean[]) null); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_emptyInput6681() { 
     BooleanUtils.or(new Boolean[] {}); 
 } 
@Test 
 public void testAnd_primitive_validInput_3items6688() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new boolean[] { false, false, true })); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new boolean[] { false, true, false })); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new boolean[] { true, false, false })); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new boolean[] { true, true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false, false })); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new boolean[] { true, true, false })); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new boolean[] { true, false, true })); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new boolean[] { false, true, true })); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_primitive_emptyInput6704() { 
     BooleanUtils.xor(new boolean[] {}); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue6996() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_nullValue7005() { 
     BooleanUtils.toBooleanObject(null, Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test 
 public void test_toBooleanObject_int7014() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(1)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(-1)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(0)); 
 } 
@Test 
 public void test_toStringTrueFalse_Boolean7031() { 
     assertEquals(null, BooleanUtils.toStringTrueFalse((Boolean) null)); 
     assertEquals("true", BooleanUtils.toStringTrueFalse(Boolean.TRUE)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(Boolean.FALSE)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_nullValue7093() { 
     BooleanUtils.toBooleanObject(null, Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test 
 public void testXor_object_validInput_2items7153() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBoolean_Integer_Integer_Integer_noMatch7383() { 
     BooleanUtils.toBoolean(Integer.valueOf(8), Integer.valueOf(6), Integer.valueOf(7)); 
 } 
@Test 
 public void test_toStringOnOff_Boolean7459() { 
     assertEquals(null, BooleanUtils.toStringOnOff((Boolean) null)); 
     assertEquals("on", BooleanUtils.toStringOnOff(Boolean.TRUE)); 
     assertEquals("off", BooleanUtils.toStringOnOff(Boolean.FALSE)); 
 } 
@Test 
 public void testAnd_primitive_validInput_3items7492() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new boolean[] { false, false, true })); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new boolean[] { false, true, false })); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new boolean[] { true, false, false })); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new boolean[] { true, true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false, false })); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new boolean[] { true, true, false })); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new boolean[] { true, false, true })); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new boolean[] { false, true, true })); 
 } 
@Test 
 public void testAnd_object_validInput_3items7639() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toStringTrueFalse_Boolean7763() { 
     assertEquals(null, BooleanUtils.toStringTrueFalse((Boolean) null)); 
     assertEquals("true", BooleanUtils.toStringTrueFalse(Boolean.TRUE)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(Boolean.FALSE)); 
 } 
@Test 
 public void test_toBoolean_String_String_String7830() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toBooleanDefaultIfNull_Boolean_boolean7944() { 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, true)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, false)); 
     assertTrue(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, true)); 
     assertFalse(BooleanUtils.toBooleanDefaultIfNull((Boolean) null, false)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_nullElementInput8000() { 
     BooleanUtils.and(new Boolean[] { null }); 
 } 
@Test 
 public void test_toBoolean_Boolean8092() { 
     assertTrue(BooleanUtils.toBoolean(Boolean.TRUE)); 
     assertFalse(BooleanUtils.toBoolean(Boolean.FALSE)); 
     assertFalse(BooleanUtils.toBoolean((Boolean) null)); 
 } 
@Test 
 public void test_toIntegerObject_Boolean8146() { 
     assertEquals(Integer.valueOf(1), BooleanUtils.toIntegerObject(Boolean.TRUE)); 
     assertEquals(Integer.valueOf(0), BooleanUtils.toIntegerObject(Boolean.FALSE)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null)); 
 } 
@Test 
 public void test_toIntegerObject_Boolean_Integer_Integer_Integer8187() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     final Integer eight = Integer.valueOf(8); 
     assertEquals(six, BooleanUtils.toIntegerObject(Boolean.TRUE, six, seven, eight)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(Boolean.FALSE, six, seven, eight)); 
     assertEquals(eight, BooleanUtils.toIntegerObject((Boolean) null, six, seven, eight)); 
     assertEquals(null, BooleanUtils.toIntegerObject((Boolean) null, six, seven, null)); 
 } 
@Test 
 public void test_toBoolean_int8188() { 
     assertTrue(BooleanUtils.toBoolean(1)); 
     assertTrue(BooleanUtils.toBoolean(-1)); 
     assertFalse(BooleanUtils.toBoolean(0)); 
 } 
@Test 
 public void testAnd_object_validInput_3items8260() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new Boolean[] { Boolean.TRUE, Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new Boolean[] { Boolean.FALSE, Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testOr_object_nullElementInput8269() { 
     BooleanUtils.or(new Boolean[] { null }); 
 } 
@Test 
 public void test_toBoolean_Integer_Integer_Integer8290() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertTrue(BooleanUtils.toBoolean((Integer) null, null, seven)); 
     assertFalse(BooleanUtils.toBoolean((Integer) null, six, null)); 
     assertTrue(BooleanUtils.toBoolean(Integer.valueOf(6), six, seven)); 
     assertFalse(BooleanUtils.toBoolean(Integer.valueOf(7), six, seven)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_primitive_nullInput8371() { 
     BooleanUtils.and((boolean[]) null); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue8392() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_nullValue8448() { 
     BooleanUtils.toBooleanObject(null, Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test 
 public void test_toBoolean_int_int_int8460() { 
     assertTrue(BooleanUtils.toBoolean(6, 6, 7)); 
     assertFalse(BooleanUtils.toBoolean(7, 6, 7)); 
 } 
@Test 
 public void test_toStringYesNo_Boolean8475() { 
     assertEquals(null, BooleanUtils.toStringYesNo((Boolean) null)); 
     assertEquals("yes", BooleanUtils.toStringYesNo(Boolean.TRUE)); 
     assertEquals("no", BooleanUtils.toStringYesNo(Boolean.FALSE)); 
 } 
@Test 
 public void test_toIntegerObject_boolean_Integer_Integer8520() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertEquals(six, BooleanUtils.toIntegerObject(true, six, seven)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(false, six, seven)); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String8523() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test 
 public void test_toBooleanObject_String_String_String_String8580() { 
     assertSame(Boolean.TRUE, BooleanUtils.toBooleanObject((String) null, null, "N", "U")); 
     assertSame(Boolean.FALSE, BooleanUtils.toBooleanObject((String) null, "Y", null, "U")); 
     assertSame(null, BooleanUtils.toBooleanObject((String) null, "Y", "N", null)); 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject("Y", "Y", "N", "U")); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject("N", "Y", "N", "U")); 
     assertEquals(null, BooleanUtils.toBooleanObject("U", "Y", "N", "U")); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_String_String_String_String_nullValue8748() { 
     BooleanUtils.toBooleanObject((String) null, "Y", "N", "U"); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testAnd_object_emptyInput8760() { 
     BooleanUtils.and(new Boolean[] {}); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_object_emptyInput8770() { 
     BooleanUtils.xor(new Boolean[] {}); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_int_int_int_noMatch8836() { 
     BooleanUtils.toBooleanObject(9, 6, 7, 8); 
 } 
@Test 
 public void test_toInteger_boolean8874() { 
     assertEquals(1, BooleanUtils.toInteger(true)); 
     assertEquals(0, BooleanUtils.toInteger(false)); 
 } 
@Test 
 public void test_toStringOnOff_Boolean8890() { 
     assertEquals(null, BooleanUtils.toStringOnOff((Boolean) null)); 
     assertEquals("on", BooleanUtils.toStringOnOff(Boolean.TRUE)); 
     assertEquals("off", BooleanUtils.toStringOnOff(Boolean.FALSE)); 
 } 
@Test 
 public void test_toIntegerObject_boolean_Integer_Integer8925() { 
     final Integer six = Integer.valueOf(6); 
     final Integer seven = Integer.valueOf(7); 
     assertEquals(six, BooleanUtils.toIntegerObject(true, six, seven)); 
     assertEquals(seven, BooleanUtils.toIntegerObject(false, six, seven)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void test_toBooleanObject_Integer_Integer_Integer_Integer_noMatch8942() { 
     BooleanUtils.toBooleanObject(Integer.valueOf(9), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8)); 
 } 
@Test 
 public void test_toInteger_Boolean_int_int_int8998() { 
     assertEquals(6, BooleanUtils.toInteger(Boolean.TRUE, 6, 7, 8)); 
     assertEquals(7, BooleanUtils.toInteger(Boolean.FALSE, 6, 7, 8)); 
     assertEquals(8, BooleanUtils.toInteger(null, 6, 7, 8)); 
 } 
@Test 
 public void test_toStringTrueFalse_boolean9020() { 
     assertEquals("true", BooleanUtils.toStringTrueFalse(true)); 
     assertEquals("false", BooleanUtils.toStringTrueFalse(false)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testXor_primitive_emptyInput9031() { 
     BooleanUtils.xor(new boolean[] {}); 
 } 
@Test 
 public void testXor_object_validInput_2items9055() { 
     assertTrue("True result for (true, true)", !BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.TRUE }).booleanValue()); 
     assertTrue("True result for (false, false)", !BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (true, false)", BooleanUtils.xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }).booleanValue()); 
     assertTrue("False result for (false, true)", BooleanUtils.xor(new Boolean[] { Boolean.FALSE, Boolean.TRUE }).booleanValue()); 
 } 
@Test 
 public void test_toInteger_boolean_int_int9084() { 
     assertEquals(6, BooleanUtils.toInteger(true, 6, 7)); 
     assertEquals(7, BooleanUtils.toInteger(false, 6, 7)); 
 } 
@Test 
 public void test_isNotFalse_Boolean9129() { 
     assertTrue(BooleanUtils.isNotFalse(Boolean.TRUE)); 
     assertFalse(BooleanUtils.isNotFalse(Boolean.FALSE)); 
     assertTrue(BooleanUtils.isNotFalse((Boolean) null)); 
 } 
@Test 
 public void test_toBoolean_String_String_String9177() { 
     assertTrue(BooleanUtils.toBoolean((String) null, null, "N")); 
     assertFalse(BooleanUtils.toBoolean((String) null, "Y", null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "N")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("N"))); 
     assertFalse(BooleanUtils.toBoolean("N", "Y", "N")); 
     assertFalse(BooleanUtils.toBoolean("N", new String("Y"), new String("N"))); 
     assertTrue(BooleanUtils.toBoolean((String) null, null, null)); 
     assertTrue(BooleanUtils.toBoolean("Y", "Y", "Y")); 
     assertTrue(BooleanUtils.toBoolean("Y", new String("Y"), new String("Y"))); 
 } 
@Test 
 public void test_toBooleanObject_int_int_int9212() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(6, 6, 7, 8)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(7, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toBooleanObject(8, 6, 7, 8)); 
 } 
@Test 
 public void test_toBooleanObject_int_int_int9232() { 
     assertEquals(Boolean.TRUE, BooleanUtils.toBooleanObject(6, 6, 7, 8)); 
     assertEquals(Boolean.FALSE, BooleanUtils.toBooleanObject(7, 6, 7, 8)); 
     assertEquals(null, BooleanUtils.toBooleanObject(8, 6, 7, 8)); 
 } 
@Test 
 public void testAnd_primitive_validInput_3items9375() { 
     assertTrue("True result for (false, false, true)", !BooleanUtils.and(new boolean[] { false, false, true })); 
     assertTrue("True result for (false, true, false)", !BooleanUtils.and(new boolean[] { false, true, false })); 
     assertTrue("True result for (true, false, false)", !BooleanUtils.and(new boolean[] { true, false, false })); 
     assertTrue("False result for (true, true, true)", BooleanUtils.and(new boolean[] { true, true, true })); 
     assertTrue("True result for (false, false)", !BooleanUtils.and(new boolean[] { false, false, false })); 
     assertTrue("True result for (true, true, false)", !BooleanUtils.and(new boolean[] { true, true, false })); 
     assertTrue("True result for (true, false, true)", !BooleanUtils.and(new boolean[] { true, false, true })); 
     assertTrue("True result for (false, true, true)", !BooleanUtils.and(new boolean[] { false, true, true })); 
 } 
@Test 
     public void testOr_object_validInput_2items9625() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void test_toBoolean_String9661() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void testOr_object_validInput_2items11426() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11427() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11428() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11429() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11430() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11431() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11432() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11433() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11434() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11435() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11436() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void testOr_object_validInput_2items11437() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     } 
  

@Test 
     public void test_toBoolean_String11983() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False
@Test 
     public void test_toBoolean_String11984() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     } 
  

@Test 
     public void test_toBoolean_String11985() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String11986() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")
@Test 
     public void test_toBoolean_String11987() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 

@Test 
     public void test_toBoolean_String11988() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     } 
  

@Test 
     public void test_toBoolean_String11989() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String11990() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")
@Test 
     public void test_toBoolean_String11991() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     } 
  

@Test 
     public void test_toBoolean_String11992() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     } 
  

@Test 
     public void test_toBoolean_String11993() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String11994() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     } 
  

@Test 
     public void test_toBoolean_String11995() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String11996() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")
@Test 
     public void test_toBoolean_String11997() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String11998() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String11999() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     } 
  

@Test 
     public void test_toBoolean_String12000() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12001() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")
@Test 
     public void test_toBoolean_String12002() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12003() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String12004() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     } 
  

@Test 
     public void test_toBoolean_String12005() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12006() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     } 
  

@Test 
     public void test_toBoolean_String12007() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12008() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String12009() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("False
@Test 
     public void test_toBoolean_String12010() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12011() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String12012() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12013() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("falseab")); 
         assertTrue(BooleanUtils.toBoolean("falseab")); 
         assertTrue(BooleanUtils.toBoolean("trueabc")); 
         assertTrue(BooleanUtils.toBoolean("trueabc")); 
         assertTrue(BooleanUtils.toBoolean("falseabc")); 
         assertTrue(BooleanUtils.toBoolean("trueabc
@Test 
     public void test_toBoolean_String12014() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     } 
  

@Test 
     public void test_toBoolean_String12015() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     } 
  

@Test 
     public void test_toBoolean_String12016() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String12017() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12018() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String12019() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12020() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String12021() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("Falsef")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("
@Test 
     public void test_toBoolean_String12022() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSEe")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEe")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("Falsee")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.to
@Test 
     public void test_toBoolean_String12023() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL
@Test 
     public void test_toBoolean_String12024() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12025() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL
@Test 
     public void test_toBoolean_String12026() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")
@Test 
     public void test_toBoolean_String12027() { 
         assertFalse(BooleanUtils.toBoolean((String) null)); 
         assertFalse(BooleanUtils.toBoolean("")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertFalse(BooleanUtils.toBoolean("off")); 
         assertFalse(BooleanUtils.toBoolean("oof")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertFalse(BooleanUtils.toBoolean("false")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEf")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")
