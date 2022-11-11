@Test
public void testGetException11249() { 
         exception = null; 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.getException(CHILD_INIT); 
         assertTrue("Wrong success flag", initializer.isException(CHILD_INIT)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 1)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 2)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 3)); 
         exception = null; 
         initializer.addInitializer(INIT_2, new ChildBackgroundInitializer()); 
         initializer.getException(CHILD_INIT); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 1)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 2)); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializer.getException() invocations always return true. 
      */