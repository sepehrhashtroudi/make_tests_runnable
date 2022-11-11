@Test
public void testInitializeEx9613() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */