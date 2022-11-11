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
@Test 
     public void testInitializeEx9613() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testInitializeEx9626() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11206() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testInitializeEx11207() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
         assertEquals("Wrong number of child initializers", 1, res.getChildInitializers().size()); 
         assertSame("Wrong child initializers", child1, res.getChildInitializers().iterator().next()); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testInitialize11208() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_13, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_15, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_16, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_17, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testInitialize11209() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeEx11210() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.getResultObject(CHILD_INIT)); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testGetResultObject11211() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
          
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res 
         assertEquals(6, res.getResultObjects().size()); 
         assertTrue(res.getResultObjects().contains(CHILD_INIT)); 
         assertTrue(res.getResultObjects().contains(CHILD_INIT)); 
         assertTrue(res.getResultObjects().contains(CHILD_INIT)); 
     } 
  

@Test 
     public void testInitializeEx11212() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testInitializeEx11213() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(child, res.getInitializer(CHILD_INIT)); 
         assertSame(child, res.getResultObject(CHILD_INIT)); 
         assertTrue(res.getException(CHILD_INIT) instanceof Exception); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

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

@Test 
     public void testInitialize11215() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeUnsuccessful11216() { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
  
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertFalse("Wrong success flag", res.isSuccessful()); 
     } 
  

@Test 
     public void testIsException11217() { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializer.isException() is false. 
      */ 

@Test 
     public void testInitializeEx11218() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
         assertEquals("Wrong number of child initializers", 1, res.getChildInitializers().size()); 
         assertSame("Wrong child initializers", child1, res.getChildInitializers().iterator().next()); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11219() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testInitialize11220() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeEx11221() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
         assertEquals("Wrong number of child initializers", 1, res.getChildInitializers().size()); 
         assertSame("Wrong child initializers", child, res.getChildInitializers().iterator().next()); 
     } 
  
     /** 
      * Tests the child initializers() method. 
      */ 

@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11222() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testInitializeUnsuccessful11223() { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_13, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_14, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT_15, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testGetTaskCount11224() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
  
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         assertEquals(5, res.getTaskCount()); 
     } 
  

@Test 
     public void testInitializeResults11225() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11226() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testInitializeResults11227() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
          
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res 
         assertEquals(5, res.getResultCount()); 
         assertEquals(6, res2.getResultCount()); 
     } 
  

@Test 
     public void testInitializeEx11228() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testInitializeResults11229() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
          
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res2 = (MultiBackgroundInitializer.MultiBackgroundInitializerResults) res 
         assertEquals(5, res.getResultCount()); 
         assertEquals(6, res2.getResultCount()); 
     } 
  

@Test 
     public void testGetException11230() { 
         final String ex = "Test Exception"; 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
  
         final ConcurrentException cex = initializer.getException(CHILD_INIT); 
         assertTrue("Wrong cause", cex instanceof ConcurrentException); 
         assertEquals("Wrong cause", ex, cex.getCause()); 
     } 
  

@Test 
     public void testInitialize11231() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeResults11232() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeResults11233() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeEx11234() throws ConcurrentException { 
         final ChildBackgroundInitializer child = new ChildBackgroundInitializer(); 
         child.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue("Wrong success flag", res.isSuccessful()); 
         assertEquals("Wrong number of initializers", 1, res.getInitializers().size()); 
         assertSame("Wrong child", child, res.getInitializers().iterator().next()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers fail. 
      */ 

@Test 
     public void testInitialize11235() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testInitializeResults11236() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeResults11237() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitialize11238() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testInitializeResults11239() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testInitializeEx11240() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertFalse(res.isSuccessful()); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testInitialize11241() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */ 

@Test 
     public void testGetTaskCount11242() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
  
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer.get(); 
         assertEquals(5, res.getTaskCount()); 
     } 
  

@Test 
     public void testInitializeEx11243() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.getResultObject(CHILD_INIT)); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11244() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testIsException11245() { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializer.isException() is false. 
      */ 

@Test 
     public void testInitializeEx11246() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testInitialize11247() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_13, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_15, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_16, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_17, new ChildBackgroundInitializer()); 
         initializer.addInitializer(INIT_14, new ChildBackgroundInitializer()); 
     } 
  

@Test(expected = IllegalArgumentException.class) 
     public void testAddInitializerNullName11248() { 
         initializer.addInitializer(null, new ChildBackgroundInitializer()); 
     } 
  

@Test 
     public void testGetException11249() { 
         exception = null; 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.getException(CHILD_INIT); 
         assertTrue("Wrong success flag", initializer.isException(CHILD_INIT)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 1)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 2)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 3)); 
         exception = null; 
         initializer.addInitializer(INIT_2, new ChildBackgroundInitializer()); 
         initializer.getException(CHILD_INIT); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 1)); 
         assertTrue("Wrong exception flag", initializer.isException(CHILD_INIT + 2)); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializer.getException() invocations always return true. 
      */ 

@Test 
     public void testInitializeEx11250() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertTrue(res.isException(CHILD_INIT)); 
         assertFalse(res.isException(null)); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

@Test 
     public void testInitializeEx11251() throws ConcurrentException { 
         final ChildBackgroundInitializer child1 = new ChildBackgroundInitializer(); 
         child1.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child1); 
         initializer.start(); 
         final ChildBackgroundInitializer child2 = new ChildBackgroundInitializer(); 
         child2.ex = new Exception(); 
         initializer.addInitializer(CHILD_INIT, child2); 
         initializer.start(); 
         final MultiBackgroundInitializer.MultiBackgroundInitializerResults res = initializer 
                 .get(); 
         assertTrue(res.isSuccessful()); 
         assertSame(res.getResultObject(CHILD_INIT), child1.ex); 
         assertFalse(res.isSuccessful()); 
     } 
  
     /** 
      * Tests the behavior of the initializer if one of the child initializers 
      * throws a runtime exception. 
      */ 

