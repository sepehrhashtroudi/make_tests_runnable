@Test
public void testInitializeEx9626() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */