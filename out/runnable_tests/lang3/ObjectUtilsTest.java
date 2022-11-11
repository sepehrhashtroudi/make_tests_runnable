@Test 
 public void testMedian316() { 
     assertEquals("foo", ObjectUtils.median("foo")); 
     assertEquals("bar", ObjectUtils.median("foo", "bar")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz", "blah")); 
     assertEquals("blah", ObjectUtils.median("foo", "bar", "baz", "blah", "wah")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.median(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8))); 
 } 
@Test 
 public void testIdentityToStringAppendable450() { 
     final Integer i = Integer.valueOf(121); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     try { 
         final Appendable appendable = new StringBuilder(); 
         ObjectUtils.identityToString(appendable, i); 
         assertEquals(expected, appendable.toString()); 
     } catch (IOException ex) { 
         fail("IOException unexpected"); 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) (new StringBuilder()), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
 } 
@Test 
 public void testIdentityToStringStringBuffer486() { 
     final Integer i = Integer.valueOf(45); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StringBuffer buffer = new StringBuffer(); 
     ObjectUtils.identityToString(buffer, i); 
     assertEquals(expected, buffer.toString()); 
     try { 
         ObjectUtils.identityToString((StringBuffer) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StringBuffer(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test(expected = NullPointerException.class) 
 public void testComparatorMedian_nullItems616() { 
     ObjectUtils.median(new CharSequenceComparator(), (CharSequence[]) null); 
 } 
@Test 
 public void testMax715() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testIdentityToStringAppendable812() { 
     final Integer i = Integer.valueOf(121); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     try { 
         final Appendable appendable = new StringBuilder(); 
         ObjectUtils.identityToString(appendable, i); 
         assertEquals(expected, appendable.toString()); 
     } catch (IOException ex) { 
         fail("IOException unexpected"); 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) (new StringBuilder()), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
 } 
@Test 
 public void testMax865() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testHashCode936() { 
     assertEquals(0, ObjectUtils.hashCode(null)); 
     assertEquals("a".hashCode(), ObjectUtils.hashCode("a")); 
 } 
@Test 
 public void testMax942() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testHashCodeMulti_multiple_emptyArray972() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 } 
@Test 
 public void testConstMethods1020() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testIdentityToStringStringBuffer1112() { 
     final Integer i = Integer.valueOf(45); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StringBuffer buffer = new StringBuffer(); 
     ObjectUtils.identityToString(buffer, i); 
     assertEquals(expected, buffer.toString()); 
     try { 
         ObjectUtils.identityToString((StringBuffer) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StringBuffer(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testIdentityToStringStrBuilder1242() { 
     final Integer i = Integer.valueOf(102); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StrBuilder builder = new StrBuilder(); 
     ObjectUtils.identityToString(builder, i); 
     assertEquals(expected, builder.toString()); 
     try { 
         ObjectUtils.identityToString((StrBuilder) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StrBuilder(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testNotEqual1256() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testMin1265() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 } 
@Test 
 public void testHashCodeMulti_multiple_emptyArray1365() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 } 
@Test 
 public void testMax1481() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testIdentityToStringStringBuffer1593() { 
     final Integer i = Integer.valueOf(45); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StringBuffer buffer = new StringBuffer(); 
     ObjectUtils.identityToString(buffer, i); 
     assertEquals(expected, buffer.toString()); 
     try { 
         ObjectUtils.identityToString((StringBuffer) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StringBuffer(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testCloneOfStringArray1701() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testNull1892() { 
     assertNotNull(ObjectUtils.NULL); 
     assertTrue(ObjectUtils.NULL instanceof ObjectUtils.Null); 
     assertSame(ObjectUtils.NULL, SerializationUtils.clone(ObjectUtils.NULL)); 
 } 
@Test 
 public void testMax1974() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testCloneOfPrimitiveArray2032() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 } 
@Test 
 public void testMin2194() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 } 
@Test(expected = NullPointerException.class) 
 public void testMedian_nullItems2295() { 
     ObjectUtils.median((String[]) null); 
 } 
@Test 
 public void testMedian2398() { 
     assertEquals("foo", ObjectUtils.median("foo")); 
     assertEquals("bar", ObjectUtils.median("foo", "bar")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz", "blah")); 
     assertEquals("blah", ObjectUtils.median("foo", "bar", "baz", "blah", "wah")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.median(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8))); 
 } 
@Test 
 public void testHashCodeMulti_multiple_emptyArray2444() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 } 
@Test 
 public void testCompare2482() { 
     final Integer one = Integer.valueOf(1); 
     final Integer two = Integer.valueOf(2); 
     final Integer nullValue = null; 
     assertEquals("Null Null false", 0, ObjectUtils.compare(nullValue, nullValue)); 
     assertEquals("Null Null true", 0, ObjectUtils.compare(nullValue, nullValue, true)); 
     assertEquals("Null one false", -1, ObjectUtils.compare(nullValue, one)); 
     assertEquals("Null one true", 1, ObjectUtils.compare(nullValue, one, true)); 
     assertEquals("one Null false", 1, ObjectUtils.compare(one, nullValue)); 
     assertEquals("one Null true", -1, ObjectUtils.compare(one, nullValue, true)); 
     assertEquals("one two false", -1, ObjectUtils.compare(one, two)); 
     assertEquals("one two true", -1, ObjectUtils.compare(one, two, true)); 
 } 
@Test 
 public void testIdentityToStringAppendable2571() { 
     final Integer i = Integer.valueOf(121); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     try { 
         final Appendable appendable = new StringBuilder(); 
         ObjectUtils.identityToString(appendable, i); 
         assertEquals(expected, appendable.toString()); 
     } catch (IOException ex) { 
         fail("IOException unexpected"); 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) (new StringBuilder()), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
 } 
@Test 
 public void testMax2745() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testMax2759() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testMedian2885() { 
     assertEquals("foo", ObjectUtils.median("foo")); 
     assertEquals("bar", ObjectUtils.median("foo", "bar")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz", "blah")); 
     assertEquals("blah", ObjectUtils.median("foo", "bar", "baz", "blah", "wah")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.median(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8))); 
 } 
@Test 
 public void testCloneOfStringArray2897() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 } 
@Test 
 public void testNotEqual3086() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testMin3221() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 } 
@Test 
 public void testNotEqual3228() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testMax3245() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testCloneOfStringArray3331() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 } 
@Test 
 public void testConstructor3406() { 
     assertNotNull(new ObjectUtils()); 
     final Constructor<?>[] cons = ObjectUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ObjectUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ObjectUtils.class.getModifiers())); 
 } 
@Test 
 public void testHashCode3537() { 
     assertEquals(0, ObjectUtils.hashCode(null)); 
     assertEquals("a".hashCode(), ObjectUtils.hashCode("a")); 
 } 
@Test 
 public void testMin3622() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 } 
@Test 
 public void testToString_Object3651() { 
     assertEquals("", ObjectUtils.toString((Object) null)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE)); 
 } 
@Test 
 public void testIdentityToStringStrBuilder3687() { 
     final Integer i = Integer.valueOf(102); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StrBuilder builder = new StrBuilder(); 
     ObjectUtils.identityToString(builder, i); 
     assertEquals(expected, builder.toString()); 
     try { 
         ObjectUtils.identityToString((StrBuilder) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StrBuilder(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test(expected = NullPointerException.class) 
 public void testComparatorMedian_nullItems3757() { 
     ObjectUtils.median(new CharSequenceComparator(), (CharSequence[]) null); 
 } 
@Test 
 public void testNotEqual3908() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testConstructor4016() { 
     assertNotNull(new ObjectUtils()); 
     final Constructor<?>[] cons = ObjectUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(ObjectUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(ObjectUtils.class.getModifiers())); 
 } 
@Test 
 public void testMin4047() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 } 
@Test 
 public void testComparatorMedian4107() { 
     final CharSequenceComparator cmp = new CharSequenceComparator(); 
     final NonComparableCharSequence foo = new NonComparableCharSequence("foo"); 
     final NonComparableCharSequence bar = new NonComparableCharSequence("bar"); 
     final NonComparableCharSequence baz = new NonComparableCharSequence("baz"); 
     final NonComparableCharSequence blah = new NonComparableCharSequence("blah"); 
     final NonComparableCharSequence wah = new NonComparableCharSequence("wah"); 
     assertSame(foo, ObjectUtils.median(cmp, foo)); 
     assertSame(bar, ObjectUtils.median(cmp, foo, bar)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz, blah)); 
     assertSame(blah, ObjectUtils.median(cmp, foo, bar, baz, blah, wah)); 
 } 
@Test 
 public void testHashCodeMulti_multiple_emptyArray4110() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 } 
@Test 
 public void testConstMethods4118() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testIsNull4187() { 
     final Object o = FOO; 
     final Object dflt = BAR; 
     assertSame("dflt was not returned when o was null", dflt, ObjectUtils.defaultIfNull(null, dflt)); 
     assertSame("dflt was returned when o was not null", o, ObjectUtils.defaultIfNull(o, dflt)); 
 } 
@Test 
 public void testPossibleCloneOfNotCloneable4215() { 
     final String string = new String("apache"); 
     assertSame(string, ObjectUtils.cloneIfPossible(string)); 
 } 
@Test 
 public void testFirstNonNull4310() { 
     assertEquals(null, ObjectUtils.firstNonNull(null, null)); 
     assertEquals("", ObjectUtils.firstNonNull(null, "")); 
     final String firstNonNullGenerics = ObjectUtils.firstNonNull(null, null, "123", "456"); 
     assertEquals("123", firstNonNullGenerics); 
     assertEquals("123", ObjectUtils.firstNonNull("123", null, "456", null)); 
     assertEquals(null, ObjectUtils.firstNonNull()); 
     assertSame(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE)); 
     assertNull(ObjectUtils.firstNonNull()); 
     assertNull(ObjectUtils.firstNonNull(null, null)); 
     assertNull(ObjectUtils.firstNonNull((Object) null)); 
     assertNull(ObjectUtils.firstNonNull((Object[]) null)); 
 } 
@Test 
 public void testNotEqual4400() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testConstMethods4416() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testConstMethods4428() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testIdentityToStringStrBuilder4504() { 
     final Integer i = Integer.valueOf(102); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StrBuilder builder = new StrBuilder(); 
     ObjectUtils.identityToString(builder, i); 
     assertEquals(expected, builder.toString()); 
     try { 
         ObjectUtils.identityToString((StrBuilder) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StrBuilder(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testMax4532() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testIdentityToStringStringBuffer4543() { 
     final Integer i = Integer.valueOf(45); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StringBuffer buffer = new StringBuffer(); 
     ObjectUtils.identityToString(buffer, i); 
     assertEquals(expected, buffer.toString()); 
     try { 
         ObjectUtils.identityToString((StringBuffer) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StringBuffer(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testMin4812() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 } 
@Test 
 public void testConstMethods5025() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testFirstNonNull5040() { 
     assertEquals(null, ObjectUtils.firstNonNull(null, null)); 
     assertEquals("", ObjectUtils.firstNonNull(null, "")); 
     final String firstNonNullGenerics = ObjectUtils.firstNonNull(null, null, "123", "456"); 
     assertEquals("123", firstNonNullGenerics); 
     assertEquals("123", ObjectUtils.firstNonNull("123", null, "456", null)); 
     assertEquals(null, ObjectUtils.firstNonNull()); 
     assertSame(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE)); 
     assertNull(ObjectUtils.firstNonNull()); 
     assertNull(ObjectUtils.firstNonNull(null, null)); 
     assertNull(ObjectUtils.firstNonNull((Object) null)); 
     assertNull(ObjectUtils.firstNonNull((Object[]) null)); 
 } 
@Test 
 public void testComparatorMedian5137() { 
     final CharSequenceComparator cmp = new CharSequenceComparator(); 
     final NonComparableCharSequence foo = new NonComparableCharSequence("foo"); 
     final NonComparableCharSequence bar = new NonComparableCharSequence("bar"); 
     final NonComparableCharSequence baz = new NonComparableCharSequence("baz"); 
     final NonComparableCharSequence blah = new NonComparableCharSequence("blah"); 
     final NonComparableCharSequence wah = new NonComparableCharSequence("wah"); 
     assertSame(foo, ObjectUtils.median(cmp, foo)); 
     assertSame(bar, ObjectUtils.median(cmp, foo, bar)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz, blah)); 
     assertSame(blah, ObjectUtils.median(cmp, foo, bar, baz, blah, wah)); 
 } 
@Test 
 public void testFirstNonNull5163() { 
     assertEquals(null, ObjectUtils.firstNonNull(null, null)); 
     assertEquals("", ObjectUtils.firstNonNull(null, "")); 
     final String firstNonNullGenerics = ObjectUtils.firstNonNull(null, null, "123", "456"); 
     assertEquals("123", firstNonNullGenerics); 
     assertEquals("123", ObjectUtils.firstNonNull("123", null, "456", null)); 
     assertEquals(null, ObjectUtils.firstNonNull()); 
     assertSame(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE)); 
     assertNull(ObjectUtils.firstNonNull()); 
     assertNull(ObjectUtils.firstNonNull(null, null)); 
     assertNull(ObjectUtils.firstNonNull((Object) null)); 
     assertNull(ObjectUtils.firstNonNull((Object[]) null)); 
 } 
@Test 
 public void testMax5246() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testFirstNonNull5447() { 
     assertEquals(null, ObjectUtils.firstNonNull(null, null)); 
     assertEquals("", ObjectUtils.firstNonNull(null, "")); 
     final String firstNonNullGenerics = ObjectUtils.firstNonNull(null, null, "123", "456"); 
     assertEquals("123", firstNonNullGenerics); 
     assertEquals("123", ObjectUtils.firstNonNull("123", null, "456", null)); 
     assertEquals(null, ObjectUtils.firstNonNull()); 
     assertSame(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE)); 
     assertNull(ObjectUtils.firstNonNull()); 
     assertNull(ObjectUtils.firstNonNull(null, null)); 
     assertNull(ObjectUtils.firstNonNull((Object) null)); 
     assertNull(ObjectUtils.firstNonNull((Object[]) null)); 
 } 
@Test 
 public void testConstMethods5530() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testCloneOfPrimitiveArray5595() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 } 
@Test 
 public void testConstMethods5717() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testMax5819() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testHashCodeMulti_multiple_emptyArray5890() { 
     final Object[] array = new Object[0]; 
     assertEquals(1, ObjectUtils.hashCodeMulti(array)); 
 } 
@Test 
 public void testConstMethods5927() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testPossibleCloneOfCloneable5930() { 
     final CloneableString string = new CloneableString("apache"); 
     final CloneableString stringClone = ObjectUtils.cloneIfPossible(string); 
     assertEquals("apache", stringClone.getValue()); 
 } 
@Test 
 public void testCompare6009() { 
     final Integer one = Integer.valueOf(1); 
     final Integer two = Integer.valueOf(2); 
     final Integer nullValue = null; 
     assertEquals("Null Null false", 0, ObjectUtils.compare(nullValue, nullValue)); 
     assertEquals("Null Null true", 0, ObjectUtils.compare(nullValue, nullValue, true)); 
     assertEquals("Null one false", -1, ObjectUtils.compare(nullValue, one)); 
     assertEquals("Null one true", 1, ObjectUtils.compare(nullValue, one, true)); 
     assertEquals("one Null false", 1, ObjectUtils.compare(one, nullValue)); 
     assertEquals("one Null true", -1, ObjectUtils.compare(one, nullValue, true)); 
     assertEquals("one two false", -1, ObjectUtils.compare(one, two)); 
     assertEquals("one two true", -1, ObjectUtils.compare(one, two, true)); 
 } 
@Test 
 public void testCloneOfPrimitiveArray6239() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 } 
@Test 
 public void testConstMethods6247() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testConstMethods6334() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testNotEqual6351() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testHashCodeMulti_multiple_likeList6411() { 
     final List<Object> list0 = new ArrayList<Object>(Arrays.asList()); 
     assertEquals(list0.hashCode(), ObjectUtils.hashCodeMulti()); 
     final List<Object> list1 = new ArrayList<Object>(Arrays.asList("a")); 
     assertEquals(list1.hashCode(), ObjectUtils.hashCodeMulti("a")); 
     final List<Object> list2 = new ArrayList<Object>(Arrays.asList("a", "b")); 
     assertEquals(list2.hashCode(), ObjectUtils.hashCodeMulti("a", "b")); 
     final List<Object> list3 = new ArrayList<Object>(Arrays.asList("a", "b", "c")); 
     assertEquals(list3.hashCode(), ObjectUtils.hashCodeMulti("a", "b", "c")); 
 } 
@Test 
 public void testMax6477() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testComparatorMedian6524() { 
     final CharSequenceComparator cmp = new CharSequenceComparator(); 
     final NonComparableCharSequence foo = new NonComparableCharSequence("foo"); 
     final NonComparableCharSequence bar = new NonComparableCharSequence("bar"); 
     final NonComparableCharSequence baz = new NonComparableCharSequence("baz"); 
     final NonComparableCharSequence blah = new NonComparableCharSequence("blah"); 
     final NonComparableCharSequence wah = new NonComparableCharSequence("wah"); 
     assertSame(foo, ObjectUtils.median(cmp, foo)); 
     assertSame(bar, ObjectUtils.median(cmp, foo, bar)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz, blah)); 
     assertSame(blah, ObjectUtils.median(cmp, foo, bar, baz, blah, wah)); 
 } 
@Test 
 public void testNotEqual6554() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testCloneOfPrimitiveArray6574() { 
     assertTrue(Arrays.equals(new int[] { 1 }, ObjectUtils.clone(new int[] { 1 }))); 
 } 
@Test 
 public void testComparatorMedian6708() { 
     final CharSequenceComparator cmp = new CharSequenceComparator(); 
     final NonComparableCharSequence foo = new NonComparableCharSequence("foo"); 
     final NonComparableCharSequence bar = new NonComparableCharSequence("bar"); 
     final NonComparableCharSequence baz = new NonComparableCharSequence("baz"); 
     final NonComparableCharSequence blah = new NonComparableCharSequence("blah"); 
     final NonComparableCharSequence wah = new NonComparableCharSequence("wah"); 
     assertSame(foo, ObjectUtils.median(cmp, foo)); 
     assertSame(bar, ObjectUtils.median(cmp, foo, bar)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz, blah)); 
     assertSame(blah, ObjectUtils.median(cmp, foo, bar, baz, blah, wah)); 
 } 
@Test 
 public void testToString_ObjectString6729() { 
     assertEquals(BAR, ObjectUtils.toString((Object) null, BAR)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE, BAR)); 
 } 
@Test 
 public void testConstMethods6771() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testIdentityToStringStrBuilder6791() { 
     final Integer i = Integer.valueOf(102); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     final StrBuilder builder = new StrBuilder(); 
     ObjectUtils.identityToString(builder, i); 
     assertEquals(expected, builder.toString()); 
     try { 
         ObjectUtils.identityToString((StrBuilder) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
     try { 
         ObjectUtils.identityToString(new StrBuilder(), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testNotEqual7024() { 
     assertFalse("ObjectUtils.notEqual(null, null) returned false", ObjectUtils.notEqual(null, null)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", null) returned true", ObjectUtils.notEqual(FOO, null)); 
     assertTrue("ObjectUtils.notEqual(null, \"bar\") returned true", ObjectUtils.notEqual(null, BAR)); 
     assertTrue("ObjectUtils.notEqual(\"foo\", \"bar\") returned true", ObjectUtils.notEqual(FOO, BAR)); 
     assertFalse("ObjectUtils.notEqual(\"foo\", \"foo\") returned false", ObjectUtils.notEqual(FOO, FOO)); 
 } 
@Test 
 public void testComparatorMedian7234() { 
     final CharSequenceComparator cmp = new CharSequenceComparator(); 
     final NonComparableCharSequence foo = new NonComparableCharSequence("foo"); 
     final NonComparableCharSequence bar = new NonComparableCharSequence("bar"); 
     final NonComparableCharSequence baz = new NonComparableCharSequence("baz"); 
     final NonComparableCharSequence blah = new NonComparableCharSequence("blah"); 
     final NonComparableCharSequence wah = new NonComparableCharSequence("wah"); 
     assertSame(foo, ObjectUtils.median(cmp, foo)); 
     assertSame(bar, ObjectUtils.median(cmp, foo, bar)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz, blah)); 
     assertSame(blah, ObjectUtils.median(cmp, foo, bar, baz, blah, wah)); 
 } 
@Test 
 public void testMax7289() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testConstMethods7449() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testFirstNonNull7491() { 
     assertEquals(null, ObjectUtils.firstNonNull(null, null)); 
     assertEquals("", ObjectUtils.firstNonNull(null, "")); 
     final String firstNonNullGenerics = ObjectUtils.firstNonNull(null, null, "123", "456"); 
     assertEquals("123", firstNonNullGenerics); 
     assertEquals("123", ObjectUtils.firstNonNull("123", null, "456", null)); 
     assertEquals(null, ObjectUtils.firstNonNull()); 
     assertSame(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE)); 
     assertNull(ObjectUtils.firstNonNull()); 
     assertNull(ObjectUtils.firstNonNull(null, null)); 
     assertNull(ObjectUtils.firstNonNull((Object) null)); 
     assertNull(ObjectUtils.firstNonNull((Object[]) null)); 
 } 
@Test 
 public void testMax7662() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testConstMethods7717() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testPossibleCloneOfCloneable7719() { 
     final CloneableString string = new CloneableString("apache"); 
     final CloneableString stringClone = ObjectUtils.cloneIfPossible(string); 
     assertEquals("apache", stringClone.getValue()); 
 } 
@Test 
 public void testCloneOfStringArray7773() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 } 
@Test 
 public void testCloneOfStringArray7839() { 
     assertTrue(Arrays.deepEquals(new String[] { "string" }, ObjectUtils.clone(new String[] { "string" }))); 
 } 
@Test 
 public void testIdentityToStringAppendable7943() { 
     final Integer i = Integer.valueOf(121); 
     final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
     try { 
         final Appendable appendable = new StringBuilder(); 
         ObjectUtils.identityToString(appendable, i); 
         assertEquals(expected, appendable.toString()); 
     } catch (IOException ex) { 
         fail("IOException unexpected"); 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) null, "tmp"); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
     try { 
         ObjectUtils.identityToString((Appendable) (new StringBuilder()), null); 
         fail("NullPointerException expected"); 
     } catch (final NullPointerException npe) { 
     } catch (IOException ex) { 
     } 
 } 
@Test 
 public void testConstMethods8093() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testComparatorMedian8204() { 
     final CharSequenceComparator cmp = new CharSequenceComparator(); 
     final NonComparableCharSequence foo = new NonComparableCharSequence("foo"); 
     final NonComparableCharSequence bar = new NonComparableCharSequence("bar"); 
     final NonComparableCharSequence baz = new NonComparableCharSequence("baz"); 
     final NonComparableCharSequence blah = new NonComparableCharSequence("blah"); 
     final NonComparableCharSequence wah = new NonComparableCharSequence("wah"); 
     assertSame(foo, ObjectUtils.median(cmp, foo)); 
     assertSame(bar, ObjectUtils.median(cmp, foo, bar)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz)); 
     assertSame(baz, ObjectUtils.median(cmp, foo, bar, baz, blah)); 
     assertSame(blah, ObjectUtils.median(cmp, foo, bar, baz, blah, wah)); 
 } 
@Test 
 public void testConstMethods8325() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testToString_Object8540() { 
     assertEquals("", ObjectUtils.toString((Object) null)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE)); 
 } 
@Test 
 public void testMax8635() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.max((String) null)); 
     assertNull(ObjectUtils.max(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.max(nonNullComparable2, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(nonNullComparable1, minComparable)); 
     assertSame(nonNullComparable1, ObjectUtils.max(minComparable, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.max(null, minComparable, null, nonNullComparable1)); 
     assertNull(ObjectUtils.max((String) null, (String) null)); 
 } 
@Test 
 public void testMin8638() { 
     final Calendar calendar = Calendar.getInstance(); 
     final Date nonNullComparable1 = calendar.getTime(); 
     final Date nonNullComparable2 = calendar.getTime(); 
     final String[] nullAray = null; 
     calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1); 
     final Date minComparable = calendar.getTime(); 
     assertNotSame(nonNullComparable1, nonNullComparable2); 
     assertNull(ObjectUtils.min((String) null)); 
     assertNull(ObjectUtils.min(nullAray)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(null, nonNullComparable1, null)); 
     assertSame(nonNullComparable1, ObjectUtils.min(nonNullComparable1, nonNullComparable2)); 
     assertSame(nonNullComparable2, ObjectUtils.min(nonNullComparable2, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(nonNullComparable1, minComparable)); 
     assertSame(minComparable, ObjectUtils.min(minComparable, nonNullComparable1)); 
     assertSame(minComparable, ObjectUtils.min(null, nonNullComparable1, null, minComparable)); 
     assertNull(ObjectUtils.min((String) null, (String) null)); 
 } 
@Test 
 public void testConstMethods8656() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test(expected = NullPointerException.class) 
 public void testMedian_nullItems8697() { 
     ObjectUtils.median((String[]) null); 
 } 
@Test 
 public void testIsNull8884() { 
     final Object o = FOO; 
     final Object dflt = BAR; 
     assertSame("dflt was not returned when o was null", dflt, ObjectUtils.defaultIfNull(null, dflt)); 
     assertSame("dflt was returned when o was not null", o, ObjectUtils.defaultIfNull(o, dflt)); 
 } 
@SuppressWarnings("cast") 
 @Test 
 public void testNull9066() { 
     assertNotNull(ObjectUtils.NULL); 
     assertTrue(ObjectUtils.NULL instanceof ObjectUtils.Null); 
     assertSame(ObjectUtils.NULL, SerializationUtils.clone(ObjectUtils.NULL)); 
 } 
@Test 
 public void testMedian9188() { 
     assertEquals("foo", ObjectUtils.median("foo")); 
     assertEquals("bar", ObjectUtils.median("foo", "bar")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz", "blah")); 
     assertEquals("blah", ObjectUtils.median("foo", "bar", "baz", "blah", "wah")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.median(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8))); 
 } 
@Test 
 public void testMedian9260() { 
     assertEquals("foo", ObjectUtils.median("foo")); 
     assertEquals("bar", ObjectUtils.median("foo", "bar")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz")); 
     assertEquals("baz", ObjectUtils.median("foo", "bar", "baz", "blah")); 
     assertEquals("blah", ObjectUtils.median("foo", "bar", "baz", "blah", "wah")); 
     assertEquals(Integer.valueOf(5), ObjectUtils.median(Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(10))); 
     assertEquals(Integer.valueOf(7), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9))); 
     assertEquals(Integer.valueOf(6), ObjectUtils.median(Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8))); 
 } 
@Test 
 public void testToString_ObjectString9381() { 
     assertEquals(BAR, ObjectUtils.toString((Object) null, BAR)); 
     assertEquals(Boolean.TRUE.toString(), ObjectUtils.toString(Boolean.TRUE, BAR)); 
 } 
@Test 
 public void testConstMethods9504() { 
     assertTrue("CONST(boolean)", ObjectUtils.CONST(true)); 
     assertEquals("CONST(byte)", (byte) 3, ObjectUtils.CONST((byte) 3)); 
     assertEquals("CONST(char)", (char) 3, ObjectUtils.CONST((char) 3)); 
     assertEquals("CONST(short)", (short) 3, ObjectUtils.CONST((short) 3)); 
     assertEquals("CONST(int)", 3, ObjectUtils.CONST(3)); 
     assertEquals("CONST(long)", 3l, ObjectUtils.CONST(3l)); 
     assertEquals("CONST(float)", 3f, ObjectUtils.CONST(3f), 0); 
     assertEquals("CONST(double)", 3.0, ObjectUtils.CONST(3.0), 0); 
     assertEquals("CONST(Object)", "abc", ObjectUtils.CONST("abc")); 
     final boolean MAGIC_FLAG = ObjectUtils.CONST(true); 
     final byte MAGIC_BYTE1 = ObjectUtils.CONST((byte) 127); 
     final byte MAGIC_BYTE2 = ObjectUtils.CONST_BYTE(127); 
     final char MAGIC_CHAR = ObjectUtils.CONST('a'); 
     final short MAGIC_SHORT1 = ObjectUtils.CONST((short) 123); 
     final short MAGIC_SHORT2 = ObjectUtils.CONST_SHORT(127); 
     final int MAGIC_INT = ObjectUtils.CONST(123); 
     final long MAGIC_LONG1 = ObjectUtils.CONST(123L); 
     final long MAGIC_LONG2 = ObjectUtils.CONST(3); 
     final float MAGIC_FLOAT = ObjectUtils.CONST(1.0f); 
     final double MAGIC_DOUBLE = ObjectUtils.CONST(1.0); 
     final String MAGIC_STRING = ObjectUtils.CONST("abc"); 
     assertTrue(MAGIC_FLAG); 
     assertEquals(127, MAGIC_BYTE1); 
     assertEquals(127, MAGIC_BYTE2); 
     assertEquals('a', MAGIC_CHAR); 
     assertEquals(123, MAGIC_SHORT1); 
     assertEquals(127, MAGIC_SHORT2); 
     assertEquals(123, MAGIC_INT); 
     assertEquals(123, MAGIC_LONG1); 
     assertEquals(3, MAGIC_LONG2); 
     assertEquals(1.0f, MAGIC_FLOAT, 0.0f); 
     assertEquals(1.0, MAGIC_DOUBLE, 0.0); 
     assertEquals("abc", MAGIC_STRING); 
     try { 
         ObjectUtils.CONST_BYTE(-129); 
         fail("CONST_BYTE(-129): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(128); 
         fail("CONST_BYTE(128): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_SHORT(-32769); 
         fail("CONST_SHORT(-32769): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         ObjectUtils.CONST_BYTE(32768); 
         fail("CONST_SHORT(32768): IllegalArgumentException should have been thrown."); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testFirstNonNull9535() { 
     assertEquals(null, ObjectUtils.firstNonNull(null, null)); 
     assertEquals("", ObjectUtils.firstNonNull(null, "")); 
     final String firstNonNullGenerics = ObjectUtils.firstNonNull(null, null, "123", "456"); 
     assertEquals("123", firstNonNullGenerics); 
     assertEquals("123", ObjectUtils.firstNonNull("123", null, "456", null)); 
     assertEquals(null, ObjectUtils.firstNonNull()); 
     assertSame(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE)); 
     assertNull(ObjectUtils.firstNonNull()); 
     assertNull(ObjectUtils.firstNonNull(null, null)); 
     assertNull(ObjectUtils.firstNonNull((Object) null)); 
     assertNull(ObjectUtils.firstNonNull((Object[]) null)); 
 } 
@Test 
     public void testMode9569() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testClone9621() { 
         final CloneFailedException ex = new CloneFailedException("Test"); 
         assertEquals("Test", ex.getMessage()); 
         assertNull(ex.getCause()); 
          
         final CloneFailedException ex2 = new CloneFailedException("Test"); 
         assertEquals("Test", ex2.getMessage()); 
         assertNull(ex2.getCause()); 
          
         ex = new CloneFailedException(null); 
         assertEquals("Test", ex.getMessage()); 
         assertNull(ex.getCause()); 
          
         ex = new CloneFailedException("Test", null); 
         assertEquals("Test", ex.getMessage()); 
          
         ex = new CloneFailedException("Test", ex); 
         assertEquals("Test", ex.getMessage()); 
          
         ex = new CloneFailedException("Test", ex2); 
         assertEquals("Test", ex.getMessage()); 
          
         ex = new CloneFailedException("Test", ex); 
         assertEquals("Test", ex.getMessage()); 
          
         ex = new CloneFailedException("Test", ex); 
         assertEquals("Test", ex.getMessage()); 
     } 
  

@Test 
     public void testMode9670() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testIdentityToStringStringBuilder9673() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     } 
      

@Test 
     public void testMode9826() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, 0)); 
         assertEquals(null, ObjectUtils.mode(null, 1)); 
         assertEquals(null, ObjectUtils.mode(null, 2)); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("baz", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals(null, ObjectUtils.mode(null, null, "bar", "baz", "wah")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz", "wah", "wah")); 
     } 
  

@Test 
     public void testMode9827() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9828() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9829() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9830() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     } 
  

@Test 
     public void testMode9831() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9832() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9833() { 
         assertEquals(null, ObjectUtils.mode(null, null)); 
         assertEquals(null, ObjectUtils.mode(null, "any")); 
         assertEquals(null, ObjectUtils.mode(null, "any", null)); 
         assertEquals(null, ObjectUtils.mode(null, null, "any")); 
         assertEquals(null, ObjectUtils.mode(null, "any", "other")); 
         assertEquals("", ObjectUtils.mode("", "any", null)); 
         assertEquals("", ObjectUtils.mode("", "any", "other")); 
         assertEquals("", ObjectUtils.mode("", "any", "other")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah")); 
     } 
  

@Test 
     public void testMode9834() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9835() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9836() { 
         assertEquals(null, ObjectUtils.mode(null, null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "foo", -1)); 
         assertEquals(null, ObjectUtils.mode(null, "foo", 0)); 
         assertEquals(null, ObjectUtils.mode(null, "foo", 1)); 
         assertEquals(null, ObjectUtils.mode(null, "foo", 2)); 
          
         assertEquals("foo", ObjectUtils.mode("foo", null, -1)); 
         assertEquals("foo", ObjectUtils.mode("foo", null, 2)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 0)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", -1)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 2)); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", -1)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", -2)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 1)); 
         assertEquals("foo", ObjectUtils.mode("foo", "bar", 2, -1)); 
     } 
  

@Test 
     public void testMode9837() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9838() { 
         assertEquals(null, ObjectUtils.mode(null)); 
         assertEquals(null, ObjectUtils.mode(null, "foo")); 
         assertEquals(null, ObjectUtils.mode(null, "bar")); 
         assertEquals(null, ObjectUtils.mode(null, "bar", null)); 
         assertEquals(null, ObjectUtils.mode(null, "bar", "baz")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz")); 
         assertEquals("bar", ObjectUtils.mode("foo", "bar", "baz", "blah")); 
         assertEquals("blah", ObjectUtils.mode("foo", "bar", "baz", "blah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
          
         assertEquals("foo", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah")); 
         assertEquals("wah", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah")); 
          
         assertEquals("f", ObjectUtils.mode("foo", "bar", "baz", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah", "wah
@Test 
     public void testMode9839() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     } 
  

@Test 
     public void testMode9840() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     } 
  

@Test 
     public void testMode9841() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     } 
  

@Test 
     public void testMode9842() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.mode( (String) null ) ); 
         assertNull(ObjectUtils.mode( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, nonNullComparable2 ) ); 
         assertSame( nonNullComparable2, ObjectUtils.mode( nonNullComparable2, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( minComparable, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.mode( null, minComparable, null, nonNullComparable1 ) ); 
  
         assertNull( ObjectUtils.mode((String)null, (String)null) ); 
     } 
  

@Test 
     public void testCloneOfStringArray11372() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */ 

@Test 
     public void testCloneOfStringArray11373() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */ 

@Test 
     public void testCloneIfPossible11374() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.cloneIfPossible( (String) null ) ); 
         assertNull(ObjectUtils.cloneIfPossible( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, maxComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, maxComparable ) ); 
  
         assertNull( ObjectUtils.cloneIfPossible((String)null, (String)null) ); 
     } 
  

@Test 
     public void testCloneOfStringArray11375() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */ 

@Test 
     public void testCloneIfPossible11376() { 
         final Calendar calendar = Calendar.getInstance(); 
         final Date nonNullComparable1 = calendar.getTime(); 
         final Date nonNullComparable2 = calendar.getTime(); 
         final String[] nullAray = null; 
          
         calendar.set( Calendar.YEAR, calendar.get( Calendar.YEAR ) -1 ); 
         final Date minComparable = calendar.getTime(); 
          
         assertNotSame( nonNullComparable1, nonNullComparable2 ); 
          
         assertNull(ObjectUtils.cloneIfPossible( (String) null ) ); 
         assertNull(ObjectUtils.cloneIfPossible( nullAray ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null, nonNullComparable1 ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, null ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( nonNullComparable1, minComparable ) ); 
         assertSame( nonNullComparable1, ObjectUtils.cloneIfPossible( null, minComparable ) ); 
  
         assertNull( ObjectUtils.cloneIfPossible((String)null, (String)null) ); 
     } 
  

@Test 
     public void testCloneOfStringArray11377() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */ 

@Test 
     public void testCloneOfStringArray11378() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */ 

@Test 
     public void testClone11379() { 
         final CloneFailedException ex = new CloneFailedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
         assertEquals(TEST_MESSAGE_2, ex.getMessage()); 
         assertSame(TEST_MESSAGE_2, ex.getCause()); 
     } 
  

@Test 
     public void testCloneOfStringArray11380() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */ 

@Test 
     public void testCloneOfStringArray11381() { 
         assertTrue(Arrays.deepEquals( 
             new String[]{"string"}, ObjectUtils.clone(new String[]{"string"}))); 
     } 
  
     /** 
      * Tests {@link ObjectUtils#clone(Object)} with an array of primitives. 
      */ 

@Test 
     public void testIdentityToStringStringBuilder12407() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     } 
      

@Test 
     public void testIdentityToStringStringBuilder12408() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     } 
      

@Test 
     public void testIdentityToString_Object12409() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("foo", ObjectUtils.identityToString("foo")); 
         assertEquals("foo", ObjectUtils.identityToString("foo")); 
     } 
  

@Test 
     public void testIdentityToString_Object12410() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     } 
  

@Test 
     public void testIdentityToString_Object12411() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     } 
  

@Test 
     public void testIdentityToString_Object12412() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     } 
  

@Test 
     public void testIdentityToStringStringBuilder12413() { 
         final Integer i = Integer.valueOf(45); 
         final String expected = "java.lang.Integer@" + Integer.toHexString(System.identityHashCode(i)); 
  
         final StringBuilder builder = new StringBuilder(); 
         ObjectUtils.identityToString(builder, i); 
         assertEquals(expected, builder.toString()); 
  
         try { 
             ObjectUtils.identityToString((StringBuilder)null, "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), null); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
          
         try { 
             ObjectUtils.identityToString(new StringBuilder(), "tmp"); 
             fail("NullPointerException expected"); 
         } catch(final NullPointerException npe) { 
         } 
     } 
      

@Test 
     public void testIdentityToString_Object12414() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     } 
  

@Test 
     public void testIdentityToString_Object12415() { 
         assertEquals(null, ObjectUtils.identityToString(null)); 
         assertEquals("", ObjectUtils.identityToString("")); 
         assertEquals("abc", ObjectUtils.identityToString("abc")); 
         assertEquals("xyz", ObjectUtils.identityToString("xyz")); 
         assertEquals("i am a robot", ObjectUtils.identityToString("I Am a robot")); 
         assertEquals("i am a machine", ObjectUtils.identityToString("i am a robot")); 
     } 
  

