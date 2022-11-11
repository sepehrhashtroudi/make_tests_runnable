@Test
public void testHandleCauseCheckedChecked11085() { 
         final Exception ex = new Exception("Test"); 
         try { 
             ConcurrentUtils.handleCauseUnchecked(new ExecutionException(ex)); 
             fail("ConcurrentRuntimeException not thrown!"); 
         } catch (final ConcurrentRuntimeException crex) { 
             assertEquals("Wrong cause", ex, crex.getCause()); 
         } 
     } 
  
     /** 
      * Tests handleCauseUnchecked() for a null parameter or a null cause. In this case 
      * the method should do nothing. We can only test that no exception is 
      * thrown. 
      */