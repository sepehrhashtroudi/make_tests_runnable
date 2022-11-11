@Test
public void testHandleCauseChecked9607() { 
         final Exception ex = new Exception("Test"); 
         try { 
             ConcurrentUtils.handleCause(new ExecutionException(ex)); 
             fail("ConcurrentException not thrown!"); 
         } catch (final ConcurrentException cex) { 
             assertEquals("Wrong cause", ex, cex.getCause()); 
         } 
     } 
  
     /** 
      * Tests handleCause() for a null parameter or a null cause. In this case 
      * the method should do nothing. We can only test that no exception is 
      * thrown. 
      */