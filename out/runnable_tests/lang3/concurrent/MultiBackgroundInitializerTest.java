@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify103() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify314() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify419() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify451() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify546() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify583() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify909() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1018() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1055() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1160() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1161() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test 
 public void testInitializeNested1371() throws ConcurrentException { 
     final String nameMulti = "multiChildInitializer"; 
     initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
     final MultiBackgroundInitializer mi2 = new MultiBackgroundInitializer(); 
     final int count = 3; 
     for (int i = 0; i < count; i++) { 
         mi2.addInitializer(CHILD_INIT + i, new ChildBackgroundInitializer()); 
     } 
     initializer.addInitializer(nameMulti, mi2); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final ExecutorService exec = initializer.getActiveExecutor(); 
     checkChild(res.getInitializer(CHILD_INIT), exec); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res.getResultObject(nameMulti); 
     assertEquals("Wrong number of initializers", count, res2.initializerNames().size()); 
     for (int i = 0; i < count; i++) { 
         checkChild(res2.getInitializer(CHILD_INIT + i), exec); 
     } 
     assertTrue("Executor not shutdown", exec.isShutdown()); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1623() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test 
 public void testInitializeExternalExec1710() throws ConcurrentException { 
     final ExecutorService exec = Executors.newCachedThreadPool(); 
     try { 
         initializer = new MultiBackgroundInitializer(exec); 
         checkInitialize(); 
         assertEquals("Wrong executor", exec, initializer.getActiveExecutor()); 
         assertFalse("Executor was shutdown", exec.isShutdown()); 
     } finally { 
         exec.shutdown(); 
     } 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify1810() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify2560() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify2996() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testAddInitializerNullInit3116() { 
     initializer.addInitializer(CHILD_INIT, null); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify3301() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test 
 public void testAddInitializerAfterStart3857() throws ConcurrentException { 
     initializer.start(); 
     try { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         fail("Could add initializer after start()!"); 
     } catch (final IllegalStateException istex) { 
         initializer.get(); 
     } 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify3921() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4057() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4285() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4336() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4550() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4644() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4720() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify4974() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5044() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test 
 public void testInitializeResultsIsSuccessfulFalse5111() throws ConcurrentException { 
     final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
     child.ex = new Exception(); 
     initializer.addInitializer(CHILD_INIT, child); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     assertFalse("Wrong success flag", res.isSuccessful()); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5286() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5362() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5744() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify5772() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test 
 public void testInitializeEx5983() throws ConcurrentException { 
     final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
     child.ex = new Exception(); 
     initializer.addInitializer(CHILD_INIT, child); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     assertTrue("No exception flag", res.isException(CHILD_INIT)); 
     assertNull("Got a results object", res.getResultObject(CHILD_INIT)); 
     final ConcurrentException cex = res.getException(CHILD_INIT); 
     assertEquals("Wrong cause", child.ex, cex.getCause()); 
 } 
@Test 
 public void testInitializeNested6747() throws ConcurrentException { 
     final String nameMulti = "multiChildInitializer"; 
     initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
     final MultiBackgroundInitializer mi2 = new MultiBackgroundInitializer(); 
     final int count = 3; 
     for (int i = 0; i < count; i++) { 
         mi2.addInitializer(CHILD_INIT + i, new ChildBackgroundInitializer()); 
     } 
     initializer.addInitializer(nameMulti, mi2); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final ExecutorService exec = initializer.getActiveExecutor(); 
     checkChild(res.getInitializer(CHILD_INIT), exec); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res.getResultObject(nameMulti); 
     assertEquals("Wrong number of initializers", count, res2.initializerNames().size()); 
     for (int i = 0; i < count; i++) { 
         checkChild(res2.getInitializer(CHILD_INIT + i), exec); 
     } 
     assertTrue("Executor not shutdown", exec.isShutdown()); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify6919() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify6931() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7301() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7474() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testAddInitializerNullName7498() { 
     initializer.addInitializer(null, new ChildBackgroundInitializer()); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7512() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7725() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify7936() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify8255() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify8355() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify8389() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test 
 public void testInitializeResultsIsSuccessfulFalse8991() throws ConcurrentException { 
     final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
     child.ex = new Exception(); 
     initializer.addInitializer(CHILD_INIT, child); 
     initializer.start(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     assertFalse("Wrong success flag", res.isSuccessful()); 
 } 
@Test 
 public void testInitializeExternalExec9273() throws ConcurrentException { 
     final ExecutorService exec = Executors.newCachedThreadPool(); 
     try { 
         initializer = new MultiBackgroundInitializer(exec); 
         checkInitialize(); 
         assertEquals("Wrong executor", exec, initializer.getActiveExecutor()); 
         assertFalse("Executor was shutdown", exec.isShutdown()); 
     } finally { 
         exec.shutdown(); 
     } 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify9297() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
@Test(expected = UnsupportedOperationException.class) 
 public void testResultInitializerNamesModify9477() throws ConcurrentException { 
     checkInitialize(); 
     final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
     final Iterator<String> it = res.initializerNames().iterator(); 
     it.next(); 
     it.remove(); 
 } 
