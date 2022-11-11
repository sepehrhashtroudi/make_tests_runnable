@Test
public void testGetException11214() { 
         exception = null; 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         try { 
             initializer.getException(CHILD_INIT); 
             fail("ConcurrentException not thrown!"); 
         } catch (final ConcurrentException cex) { 
             assertEquals("Wrong cause", exception, cex.getCause()); 
         } 
     } 
  
     /** 
      * Tests get an exception. In this case 
      * the method should do nothing. We can only test that no exception is 
      * thrown. 
      */