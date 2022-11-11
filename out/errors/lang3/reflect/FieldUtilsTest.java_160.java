@Test
public void testReadStaticFieldForceAccess11833() throws Exception { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(FieldUtils.class, "VALUE"), true)); 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.class, "VALUE", true), true); 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.class, "VALUE", false)); 
         try { 
             FieldUtils.readStaticField(FieldUtils.class, "none", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(FieldUtils.class, "none", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(FieldUtils.class, "none", false); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(FieldUtils.class, "none", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(FieldUtils.class, "none", false); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(FieldUtils.class, "none", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(FieldUtils.class, "none", false);