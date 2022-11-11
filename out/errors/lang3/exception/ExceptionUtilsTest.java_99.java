@Test
public void testGetStackFrameList_Throwable10968() { 
         Throwable t = null; 
         List<String> list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(0, list.size()); 
          
         t = new IllegalArgumentException("Message"); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(1, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(3, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(2, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Wrapper", list.get(1)); 
         assertEquals("Message", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(3, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(2)); 
          
         t = new ExceptionWithCause("Wrapper", t); 
         list = ExceptionUtils.getStackFrameList(t); 
         assertEquals(3, list.size()); 
         assertEquals("IllegalArgumentException: Message", list.get(0)); 
         assertEquals("Message", list.get(1)); 
         assertEquals("Wrapper", list.get(