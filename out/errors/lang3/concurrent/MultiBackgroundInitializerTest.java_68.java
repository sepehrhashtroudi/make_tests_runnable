@Test
public void testInitializeEx11221() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
         assertEquals("Wrong number of child initializers", 1, res.getChildInitializers().size()); 
         assertSame("Wrong child initializers", child, res.getChildInitializers().iterator().next()); 
     } 
  
     /** 
      * Tests the child initializers() method. 
      */