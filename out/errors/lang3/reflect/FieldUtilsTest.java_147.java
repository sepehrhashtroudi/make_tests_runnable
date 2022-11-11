@Test
public void testReadDeclaredField11820() throws Exception { 
         FieldUtils.readDeclaredField(publicChild, null); 
         assertEquals(null, FieldUtils.readDeclaredField(publicChild, "s")); 
         FieldUtils.readDeclaredField(publicChild, "b"); 
         FieldUtils.readDeclaredField(publicChild, "i"); 
         FieldUtils.readDeclaredField(publicChild, "d"); 
         FieldUtils.readDeclaredField(publicChild, "d"); 
         FieldUtils.readDeclaredField(publicChild, "e"); 
         FieldUtils.readDeclaredField(publicChild, "f"); 
         FieldUtils.readDeclaredField(publicChild, "g"); 
         FieldUtils.readDeclaredField(publicChild, "h"); 
         FieldUtils.readDeclaredField(publicChild, "i"); 
         try { 
             FieldUtils.readDeclaredField(publicChild, null); 
             fail("a null field name should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
         try { 
             FieldUtils.readDeclaredField(publicChild, "j"); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readDeclaredField(publicChild, "k"); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readDeclaredField(publicChild, "k"); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readDeclaredField(publicChild, "l"); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try {