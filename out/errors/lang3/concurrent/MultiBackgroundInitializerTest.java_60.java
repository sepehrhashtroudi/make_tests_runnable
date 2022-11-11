@Test
public void testInitializeEx11213() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(child, res.getInitializer(CHILD_INIT)); 
         assertSame(child, res.getResultObject(CHILD_INIT)); 
         assertTrue(res.getException(CHILD_INIT) instanceof Exception); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */