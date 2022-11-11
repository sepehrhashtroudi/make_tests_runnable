@Test
public void testReadFieldForceAccess11819() throws Exception { 
         Field field = FieldUtils.getField(FieldUtilsTest.class, "s"); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(FieldUtilsTest.class, "b"); 
         assertEquals(Baz.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(FieldUtilsTest.class, "i"); 
         assertEquals(I0, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(FieldUtilsTest.class, "d"); 
         assertEquals(D0, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(FieldUtilsTest.class, "s", true); 
         assertEquals(S1.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(FieldUtilsTest.class, "b", true); 
         assertEquals(Baz.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(FieldUtilsTest.class, "i", true); 
         assertEquals(I0, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(FieldUtilsTest.class, "d", true); 
         assertEquals(D0, FieldUtils.readField(field, publicChild, false)); 
         try { 
             FieldUtils.readField(field, publicChild, false); 
             fail("a null field should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
         try { 
             FieldUtils.readField((Field) null, publicChild, true); 
             fail("a null target should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { [