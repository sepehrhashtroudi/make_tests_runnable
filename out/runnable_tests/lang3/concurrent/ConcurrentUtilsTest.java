@Test 
 public void testInitializeUncheckedNull110() { 
     assertNull("Got a result", ConcurrentUtils.initializeUnchecked(null)); 
 } 
@Test 
 public void testCreateIfAbsentUncheckedException290() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception ex = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(ex)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.createIfAbsentUnchecked(new ConcurrentHashMap<String, Integer>(), "test", init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertEquals("Wrong cause", ex, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test 
 public void testCreateIfAbsentUncheckedException460() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception ex = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(ex)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.createIfAbsentUnchecked(new ConcurrentHashMap<String, Integer>(), "test", init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertEquals("Wrong cause", ex, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test 
 public void testCreateIfAbsentKeyPresent1095() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.createIfAbsent(map, key, init)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
     EasyMock.verify(init); 
 } 
@Test 
 public void testInitializeUncheckedEx1450() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Object> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception cause = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(cause)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.initializeUnchecked(init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertSame("Wrong cause", cause, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test 
 public void testPutIfAbsentKeyPresent1476() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 } 
@Test 
 public void testCreateIfAbsentUncheckedException1534() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception ex = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(ex)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.createIfAbsentUnchecked(new ConcurrentHashMap<String, Integer>(), "test", init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertEquals("Wrong cause", ex, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test 
 public void testInitializeNull1584() throws ConcurrentException { 
     assertNull("Got a result", ConcurrentUtils.initialize(null)); 
 } 
@Test 
 public void testCreateIfAbsentKeyPresent1642() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.createIfAbsent(map, key, init)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
     EasyMock.verify(init); 
 } 
@Test 
 public void testConstantFuture_Integer1675() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testPutIfAbsentKeyPresent1768() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 } 
@Test 
 public void testExtractCauseUncheckedChecked1795() { 
     final Exception ex = new Exception("Test"); 
     final ConcurrentRuntimeException cex = ConcurrentUtils.extractCauseUnchecked(new ExecutionException(ex)); 
     assertSame("Wrong cause", ex, cex.getCause()); 
 } 
@Test 
 public void testCreateIfAbsentUncheckedException2047() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception ex = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(ex)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.createIfAbsentUnchecked(new ConcurrentHashMap<String, Integer>(), "test", init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertEquals("Wrong cause", ex, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test 
 public void testHandleCauseUncheckedUncheckedException2439() { 
     final RuntimeException rex = new RuntimeException("Test"); 
     try { 
         ConcurrentUtils.handleCauseUnchecked(new ExecutionException(rex)); 
         fail("Runtime exception not thrown!"); 
     } catch (final RuntimeException r) { 
         assertEquals("Wrong exception", rex, r); 
     } 
 } 
@Test 
 public void testConstantFuture_Integer2546() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testPutIfAbsentKeyPresent2852() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 } 
@Test 
 public void testInitializeUncheckedEx2927() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Object> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception cause = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(cause)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.initializeUnchecked(init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertSame("Wrong cause", cause, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test 
 public void testPutIfAbsentKeyPresent2969() { 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.putIfAbsent(map, key, 0)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
 } 
@Test 
 public void testExtractCauseUncheckedChecked3169() { 
     final Exception ex = new Exception("Test"); 
     final ConcurrentRuntimeException cex = ConcurrentUtils.extractCauseUnchecked(new ExecutionException(ex)); 
     assertSame("Wrong cause", ex, cex.getCause()); 
 } 
@Test 
 public void testConstantFuture_Integer3435() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testHandleCauseChecked3492() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testConstantFuture_Integer3493() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testConcurrentRuntimeExceptionCauseUnchecked3669() { 
     new ConcurrentRuntimeException(new RuntimeException()); 
 } 
@Test 
 public void testConstantFuture_Integer3832() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testExtractCauseError3868() { 
     final Error err = new AssertionError("Test"); 
     try { 
         ConcurrentUtils.extractCause(new ExecutionException(err)); 
         fail("Error not thrown!"); 
     } catch (final Error e) { 
         assertEquals("Wrong error", err, e); 
     } 
 } 
@Test 
 public void testHandleCauseChecked3870() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testCreateIfAbsentUncheckedException4148() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception ex = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(ex)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.createIfAbsentUnchecked(new ConcurrentHashMap<String, Integer>(), "test", init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertEquals("Wrong cause", ex, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testConcurrentRuntimeExceptionCauseUnchecked4259() { 
     new ConcurrentRuntimeException(new RuntimeException()); 
 } 
@Test 
 public void testHandleCauseChecked4437() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testConstantFuture_Integer4466() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testCreateIfAbsentNullMap4617() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     assertNull("Wrong result", ConcurrentUtils.createIfAbsent(null, "test", init)); 
     EasyMock.verify(init); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testConcurrentRuntimeExceptionCauseUnchecked4692() { 
     new ConcurrentRuntimeException(new RuntimeException()); 
 } 
@Test 
 public void testExtractCauseNullCause4709() { 
     assertNull("Non null result", ConcurrentUtils.extractCause(new ExecutionException("Test", null))); 
 } 
@Test 
 public void testCreateIfAbsentKeyPresent4711() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     final String key = "testKey"; 
     final Integer value = 42; 
     final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
     map.put(key, value); 
     assertEquals("Wrong result", value, ConcurrentUtils.createIfAbsent(map, key, init)); 
     assertEquals("Wrong value in map", value, map.get(key)); 
     EasyMock.verify(init); 
 } 
@Test 
 public void testConstantFuture_Integer5229() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testHandleCauseChecked5290() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testConstantFuture_Integer5677() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testHandleCauseChecked5837() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testCreateIfAbsentNullMap6138() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     assertNull("Wrong result", ConcurrentUtils.createIfAbsent(null, "test", init)); 
     EasyMock.verify(init); 
 } 
@Test 
 public void testInitializeUncheckedEx6309() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Object> init = EasyMock.createMock(ConcurrentInitializer.class); 
     final Exception cause = new Exception(); 
     EasyMock.expect(init.get()).andThrow(new ConcurrentException(cause)); 
     EasyMock.replay(init); 
     try { 
         ConcurrentUtils.initializeUnchecked(init); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentRuntimeException crex) { 
         assertSame("Wrong cause", cause, crex.getCause()); 
     } 
     EasyMock.verify(init); 
 } 
@Test 
 public void testCreateIfAbsentNullMap6387() throws ConcurrentException { 
     @SuppressWarnings("unchecked") 
     final ConcurrentInitializer<Integer> init = EasyMock.createMock(ConcurrentInitializer.class); 
     EasyMock.replay(init); 
     assertNull("Wrong result", ConcurrentUtils.createIfAbsent(null, "test", init)); 
     EasyMock.verify(init); 
 } 
@Test 
 public void testHandleCauseChecked6508() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testInitializeUncheckedNull6512() { 
     assertNull("Got a result", ConcurrentUtils.initializeUnchecked(null)); 
 } 
@Test 
 public void testHandleCauseChecked6754() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testHandleCauseChecked6858() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testExtractCauseUncheckedNull7818() { 
     assertNull("Non null result", ConcurrentUtils.extractCauseUnchecked(null)); 
 } 
@Test 
 public void testHandleCauseChecked7826() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testConstantFuture_Integer7898() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testConstantFuture_Integer8089() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testConstantFuture_Integer8203() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testConstantFuture_Integer8208() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testConstantFuture_Integer8236() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testPutIfAbsentNullMap8544() { 
     assertNull("Wrong result", ConcurrentUtils.putIfAbsent(null, "test", 100)); 
 } 
@Test 
 public void testInitializeNull8893() throws ConcurrentException { 
     assertNull("Got a result", ConcurrentUtils.initialize(null)); 
 } 
@Test 
 public void testConstantFuture_Integer8965() throws Exception { 
     final Integer value = Integer.valueOf(5); 
     final Future<Integer> test = ConcurrentUtils.constantFuture(value); 
     assertTrue(test.isDone()); 
     assertSame(value, test.get()); 
     assertSame(value, test.get(1000, TimeUnit.SECONDS)); 
     assertSame(value, test.get(1000, null)); 
     assertFalse(test.isCancelled()); 
     assertFalse(test.cancel(true)); 
     assertFalse(test.cancel(false)); 
 } 
@Test 
 public void testHandleCauseChecked9246() { 
     final Exception ex = new Exception("Test"); 
     try { 
         ConcurrentUtils.handleCause(new ExecutionException(ex)); 
         fail("ConcurrentException not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testInitializeUncheckedNull9305() { 
     assertNull("Got a result", ConcurrentUtils.initializeUnchecked(null)); 
 } 
