@Test
public void testInitializeEx11234() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
         assertEquals("Wrong number of initializers", 1, res.getInitializers().size()); 
         assertSame("Wrong child", child, res.getInitializers().iterator().next()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers fail. 
      */