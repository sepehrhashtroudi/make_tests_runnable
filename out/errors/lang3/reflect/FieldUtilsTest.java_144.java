@Test
public void testGetFieldForceAccess11817() { 
         assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
         assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
         assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
         assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
         assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
         assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
         assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
         assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
         assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
         assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
         assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
         assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
         assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
         assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true