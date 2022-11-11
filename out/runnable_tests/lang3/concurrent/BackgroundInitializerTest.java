@Test 
 public void testSetExternalExecutorAfterStart809() throws ConcurrentException { 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(); 
     init.start(); 
     try { 
         init.setExternalExecutor(Executors.newSingleThreadExecutor()); 
         fail("Could set executor after start()!"); 
     } catch (final IllegalStateException istex) { 
         init.get(); 
     } 
 } 
@Test 
 public void testGetCheckedException1115() throws Exception { 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(); 
     final Exception ex = new Exception(); 
     init.ex = ex; 
     init.start(); 
     try { 
         init.get(); 
         fail("Exception not thrown!"); 
     } catch (final ConcurrentException cex) { 
         assertEquals("Exception not thrown", ex, cex.getCause()); 
     } 
 } 
@Test 
 public void testGetInterruptedException3584() throws Exception { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(exec); 
     final CountDownLatch latch1 = new CountDownLatch(1); 
     init.shouldSleep = true; 
     init.start(); 
     final AtomicReference<InterruptedException> iex = new AtomicReference<InterruptedException>(); 
     final Thread getThread = new Thread() { 
  
         @Override 
         public void run() { 
             try { 
                 init.get(); 
             } catch (final ConcurrentException cex) { 
                 if (cex.getCause() instanceof InterruptedException) { 
                     iex.set((InterruptedException) cex.getCause()); 
                 } 
             } finally { 
                 assertTrue("Thread not interrupted", isInterrupted()); 
                 latch1.countDown(); 
             } 
         } 
     }; 
     getThread.start(); 
     getThread.interrupt(); 
     latch1.await(); 
     exec.shutdownNow(); 
     exec.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS); 
     assertNotNull("No interrupted exception", iex.get()); 
 } 
@Test 
 public void testGetInterruptedException4363() throws Exception { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(exec); 
     final CountDownLatch latch1 = new CountDownLatch(1); 
     init.shouldSleep = true; 
     init.start(); 
     final AtomicReference<InterruptedException> iex = new AtomicReference<InterruptedException>(); 
     final Thread getThread = new Thread() { 
  
         @Override 
         public void run() { 
             try { 
                 init.get(); 
             } catch (final ConcurrentException cex) { 
                 if (cex.getCause() instanceof InterruptedException) { 
                     iex.set((InterruptedException) cex.getCause()); 
                 } 
             } finally { 
                 assertTrue("Thread not interrupted", isInterrupted()); 
                 latch1.countDown(); 
             } 
         } 
     }; 
     getThread.start(); 
     getThread.interrupt(); 
     latch1.await(); 
     exec.shutdownNow(); 
     exec.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS); 
     assertNotNull("No interrupted exception", iex.get()); 
 } 
@Test 
 public void testGetInterruptedException5589() throws Exception { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(exec); 
     final CountDownLatch latch1 = new CountDownLatch(1); 
     init.shouldSleep = true; 
     init.start(); 
     final AtomicReference<InterruptedException> iex = new AtomicReference<InterruptedException>(); 
     final Thread getThread = new Thread() { 
  
         @Override 
         public void run() { 
             try { 
                 init.get(); 
             } catch (final ConcurrentException cex) { 
                 if (cex.getCause() instanceof InterruptedException) { 
                     iex.set((InterruptedException) cex.getCause()); 
                 } 
             } finally { 
                 assertTrue("Thread not interrupted", isInterrupted()); 
                 latch1.countDown(); 
             } 
         } 
     }; 
     getThread.start(); 
     getThread.interrupt(); 
     latch1.await(); 
     exec.shutdownNow(); 
     exec.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS); 
     assertNotNull("No interrupted exception", iex.get()); 
 } 
@Test(expected = IllegalStateException.class) 
 public void testGetBeforeStart6039() throws ConcurrentException { 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(); 
     init.get(); 
 } 
@Test 
 public void testStartMultipleTimes6491() { 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(); 
     assertTrue("Wrong result for start()", init.start()); 
     for (int i = 0; i < 10; i++) { 
         assertFalse("Could start again", init.start()); 
     } 
     checkInitialize(init); 
 } 
@Test 
 public void testGetInterruptedException7401() throws Exception { 
     final ExecutorService exec = Executors.newSingleThreadExecutor(); 
     final BackgroundInitializerTestImpl init = new BackgroundInitializerTestImpl(exec); 
     final CountDownLatch latch1 = new CountDownLatch(1); 
     init.shouldSleep = true; 
     init.start(); 
     final AtomicReference<InterruptedException> iex = new AtomicReference<InterruptedException>(); 
     final Thread getThread = new Thread() { 
  
         @Override 
         public void run() { 
             try { 
                 init.get(); 
             } catch (final ConcurrentException cex) { 
                 if (cex.getCause() instanceof InterruptedException) { 
                     iex.set((InterruptedException) cex.getCause()); 
                 } 
             } finally { 
                 assertTrue("Thread not interrupted", isInterrupted()); 
                 latch1.countDown(); 
             } 
         } 
     }; 
     getThread.start(); 
     getThread.interrupt(); 
     latch1.await(); 
     exec.shutdownNow(); 
     exec.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS); 
     assertNotNull("No interrupted exception", iex.get()); 
 } 
