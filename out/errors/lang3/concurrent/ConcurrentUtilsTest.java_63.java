@Test
public void testExtractCauseChecked11084() { 
         final Exception ex = new Exception("Test"); 
         try { 
             ConcurrentUtils.extractCauseChecked(new ExecutionException(ex)); 
             fail("ConcurrentRuntimeException not thrown!"); 
         } catch (final ConcurrentRuntimeException cex) { 
             assertEquals("Wrong cause", ex, cex.getCause()); 
         } 
     } 
  
     /** 
      * Tests extractCauseChecked() for a null parameter or a null cause. In this case 
      * the method should do nothing. We can only test that no exception is 
      * thrown. 
      */