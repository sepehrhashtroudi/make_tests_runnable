@Test(expected = IllegalArgumentException.class) 
     public void testConcurrentRuntimeExceptionCauseUnchecked11086() { 
         new ConcurrentRuntimeException(new RuntimeException()); 
     } 
  
     /** 
      * Tries to create a ConcurrentRuntimeException with an error as cause. 
      */