@Test 
 public void testContextedException106() { 
     exceptionContext = new ContextedException(); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(StringUtils.isEmpty(message)); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext414() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testContextedExceptionStringThrowable1376() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testNullExceptionPassing1518() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext1925() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testNullExceptionPassing2106() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 } 
@Test 
 public void testContextedException2591() { 
     exceptionContext = new ContextedException(); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(StringUtils.isEmpty(message)); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext2792() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testContextedExceptionThrowable3882() { 
     exceptionContext = new ContextedException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 } 
@Test 
 public void testContextedExceptionStringThrowable3925() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testContextedException4003() { 
     exceptionContext = new ContextedException(); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(StringUtils.isEmpty(message)); 
 } 
@Test 
 public void testContextedExceptionString4083() { 
     exceptionContext = new ContextedException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 } 
@Test 
 public void testContextedExceptionString4099() { 
     exceptionContext = new ContextedException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 } 
@Test 
 public void testRawMessage4385() { 
     assertEquals(Exception.class.getName() + ": " + TEST_MESSAGE, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertEquals(TEST_MESSAGE_2, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedException(null, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertNull(exceptionContext.getRawMessage()); 
 } 
@Test 
 public void testContextedExceptionThrowable5068() { 
     exceptionContext = new ContextedException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 } 
@Test 
 public void testRawMessage5480() { 
     assertEquals(Exception.class.getName() + ": " + TEST_MESSAGE, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertEquals(TEST_MESSAGE_2, exceptionContext.getRawMessage()); 
     exceptionContext = new ContextedException(null, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     assertNull(exceptionContext.getRawMessage()); 
 } 
@Test 
 public void testNullExceptionPassing5713() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext7359() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext7385() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testContextedExceptionThrowable7386() { 
     exceptionContext = new ContextedException(new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext7803() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext8003() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testNullExceptionPassing8030() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), null).addContextValue("test1", null).addContextValue("test2", "some value").addContextValue("test Date", new Date()).addContextValue("test Nbr", Integer.valueOf(5)).addContextValue("test Poorly written obj", new ObjectWithFaultyToString()); 
     final String message = exceptionContext.getMessage(); 
     assertTrue(message != null); 
 } 
@Test 
 public void testContextedExceptionStringThrowable8742() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE)); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
@Test 
 public void testContextedExceptionString8956() { 
     exceptionContext = new ContextedException(TEST_MESSAGE); 
     assertEquals(TEST_MESSAGE, exceptionContext.getMessage()); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
 } 
@Test 
 public void testContextedExceptionStringThrowableContext9352() { 
     exceptionContext = new ContextedException(TEST_MESSAGE_2, new Exception(TEST_MESSAGE), new DefaultExceptionContext()); 
     final String message = exceptionContext.getMessage(); 
     final String trace = ExceptionUtils.getStackTrace(exceptionContext); 
     assertTrue(trace.indexOf("ContextedException") >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(trace.indexOf(TEST_MESSAGE_2) >= 0); 
     assertTrue(message.indexOf(TEST_MESSAGE_2) >= 0); 
 } 
