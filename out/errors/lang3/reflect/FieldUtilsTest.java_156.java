@Test
public void testReadStaticField11829() throws Exception { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
         try { 
             FieldUtils.readStaticField(null); 
             fail("a null field name should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
  
         try { 
             FieldUtils.readStaticField(FieldUtils.getField(null, "none")); 
             fail("a null target should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
  
         try { 
             FieldUtils.readStaticField(FieldUtils.getField(FieldUtils.class, "none")); 
             fail("a null target should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(FieldUtils.class, "VALUE"))); 
         try { 
             FieldUtils.readStaticField(FieldUtils.getField(FieldUtils.class, "I")); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(FieldUtils.class, "VALUE"))); 
         try { 
             FieldUtils.readStaticField(FieldUtils.getField(FieldUtils.class, "I")); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         assertEquals(Foo.VALUE, FieldUtils