@Test
public void testReadStaticFieldForceAccess11814() throws Exception { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(Foo.class, "VALUE", true)); 
         assertEquals("child", FieldUtils.readStaticField(PublicChild.class, "VALUE", true)); 
         try { 
             FieldUtils.readStaticField(PublicChild.class, "VALUE", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(PublicChild.class, "VALUE", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass 
         } 
         try { 
             FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE", true); 
             fail("expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // pass [EOL