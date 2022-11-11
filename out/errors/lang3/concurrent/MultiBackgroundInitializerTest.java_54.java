@Test
public void testInitializeEx11207() throws ConcurrentException { 
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
         assertTrue("Wrong success flag", res.isSuccessful()); 
         assertEquals("Wrong number of child initializers", 1, res.getChildInitializers().size()); 
         assertSame("Wrong child initializers", child1, res.getChildInitializers().iterator().next()); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */