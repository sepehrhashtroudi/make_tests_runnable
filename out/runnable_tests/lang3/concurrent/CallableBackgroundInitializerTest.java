@Test 
 public void testInitialize122() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable373() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable2374() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 } 
@Test 
 public void testInitialize4546() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 } 
@Test 
 public void testInitialize4575() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable5918() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 } 
@Test 
 public void testInitialize6814() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 } 
@Test 
 public void testInitExecutor6888() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(new TestCallable(), exec); 
     assertEquals("Executor not set", exec, init.getExternalExecutor()); 
 } 
@Test 
 public void testInitialize7517() throws Exception { 
     final TestCallable call = new TestCallable(); 
     final CallableBackgroundInitializer<Integer> init = new CallableBackgroundInitializer<Integer>(call); 
     assertEquals("Wrong result", RESULT, init.initialize()); 
     assertEquals("Wrong number of invocations", 1, call.callCount); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable7733() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable8148() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitExecutorNullCallable8398() { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     new CallableBackgroundInitializer<Integer>(null, exec); 
 } 
