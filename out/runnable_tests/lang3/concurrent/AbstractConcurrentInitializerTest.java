@Test 
 public void testGet622() throws ConcurrentException { 
     assertNotNull("No managed object", createInitializer().get()); 
 } 
@Test 
 public void testGetConcurrent1083() throws ConcurrentException, InterruptedException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final int threadCount = 20; 
     final CountDownLatch startLatch = new CountDownLatch(1); 
     class GetThread extends Thread { 
  
         Object object; 
  
         @Override 
         public void run() { 
             try { 
                 startLatch.await(); 
                 object = initializer.get(); 
             } catch (final InterruptedException iex) { 
             } catch (final ConcurrentException cex) { 
                 object = cex; 
             } 
         } 
     } 
     final GetThread[] threads = new GetThread[threadCount]; 
     for (int i = 0; i < threadCount; i++) { 
         threads[i] = new GetThread(); 
         threads[i].start(); 
     } 
     startLatch.countDown(); 
     for (final Thread t : threads) { 
         t.join(); 
     } 
     final Object managedObject = initializer.get(); 
     for (final GetThread t : threads) { 
         assertEquals("Wrong object", managedObject, t.object); 
     } 
 } 
@Test 
 public void testGetMultipleTimes1318() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
@Test 
 public void testGetMultipleTimes1586() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
@Test 
 public void testGet1747() throws ConcurrentException { 
     assertNotNull("No managed object", createInitializer().get()); 
 } 
@Test 
 public void testGet3303() throws ConcurrentException { 
     assertNotNull("No managed object", createInitializer().get()); 
 } 
@Test 
 public void testGetConcurrent3988() throws ConcurrentException, InterruptedException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final int threadCount = 20; 
     final CountDownLatch startLatch = new CountDownLatch(1); 
     class GetThread extends Thread { 
  
         Object object; 
  
         @Override 
         public void run() { 
             try { 
                 startLatch.await(); 
                 object = initializer.get(); 
             } catch (final InterruptedException iex) { 
             } catch (final ConcurrentException cex) { 
                 object = cex; 
             } 
         } 
     } 
     final GetThread[] threads = new GetThread[threadCount]; 
     for (int i = 0; i < threadCount; i++) { 
         threads[i] = new GetThread(); 
         threads[i].start(); 
     } 
     startLatch.countDown(); 
     for (final Thread t : threads) { 
         t.join(); 
     } 
     final Object managedObject = initializer.get(); 
     for (final GetThread t : threads) { 
         assertEquals("Wrong object", managedObject, t.object); 
     } 
 } 
@Test 
 public void testGet4136() throws ConcurrentException { 
     assertNotNull("No managed object", createInitializer().get()); 
 } 
@Test 
 public void testGetConcurrent4627() throws ConcurrentException, InterruptedException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final int threadCount = 20; 
     final CountDownLatch startLatch = new CountDownLatch(1); 
     class GetThread extends Thread { 
  
         Object object; 
  
         @Override 
         public void run() { 
             try { 
                 startLatch.await(); 
                 object = initializer.get(); 
             } catch (final InterruptedException iex) { 
             } catch (final ConcurrentException cex) { 
                 object = cex; 
             } 
         } 
     } 
     final GetThread[] threads = new GetThread[threadCount]; 
     for (int i = 0; i < threadCount; i++) { 
         threads[i] = new GetThread(); 
         threads[i].start(); 
     } 
     startLatch.countDown(); 
     for (final Thread t : threads) { 
         t.join(); 
     } 
     final Object managedObject = initializer.get(); 
     for (final GetThread t : threads) { 
         assertEquals("Wrong object", managedObject, t.object); 
     } 
 } 
@Test 
 public void testGet5045() throws ConcurrentException { 
     assertNotNull("No managed object", createInitializer().get()); 
 } 
@Test 
 public void testGetConcurrent5459() throws ConcurrentException, InterruptedException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final int threadCount = 20; 
     final CountDownLatch startLatch = new CountDownLatch(1); 
     class GetThread extends Thread { 
  
         Object object; 
  
         @Override 
         public void run() { 
             try { 
                 startLatch.await(); 
                 object = initializer.get(); 
             } catch (final InterruptedException iex) { 
             } catch (final ConcurrentException cex) { 
                 object = cex; 
             } 
         } 
     } 
     final GetThread[] threads = new GetThread[threadCount]; 
     for (int i = 0; i < threadCount; i++) { 
         threads[i] = new GetThread(); 
         threads[i].start(); 
     } 
     startLatch.countDown(); 
     for (final Thread t : threads) { 
         t.join(); 
     } 
     final Object managedObject = initializer.get(); 
     for (final GetThread t : threads) { 
         assertEquals("Wrong object", managedObject, t.object); 
     } 
 } 
@Test 
 public void testGetConcurrent6071() throws ConcurrentException, InterruptedException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final int threadCount = 20; 
     final CountDownLatch startLatch = new CountDownLatch(1); 
     class GetThread extends Thread { 
  
         Object object; 
  
         @Override 
         public void run() { 
             try { 
                 startLatch.await(); 
                 object = initializer.get(); 
             } catch (final InterruptedException iex) { 
             } catch (final ConcurrentException cex) { 
                 object = cex; 
             } 
         } 
     } 
     final GetThread[] threads = new GetThread[threadCount]; 
     for (int i = 0; i < threadCount; i++) { 
         threads[i] = new GetThread(); 
         threads[i].start(); 
     } 
     startLatch.countDown(); 
     for (final Thread t : threads) { 
         t.join(); 
     } 
     final Object managedObject = initializer.get(); 
     for (final GetThread t : threads) { 
         assertEquals("Wrong object", managedObject, t.object); 
     } 
 } 
@Test 
 public void testGetMultipleTimes6355() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
@Test 
 public void testGet6627() throws ConcurrentException { 
     assertNotNull("No managed object", createInitializer().get()); 
 } 
@Test 
 public void testGetMultipleTimes7130() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
@Test 
 public void testGetMultipleTimes7402() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
@Test 
 public void testGetMultipleTimes8124() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
@Test 
 public void testGetMultipleTimes8767() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
@Test 
 public void testGetConcurrent9011() throws ConcurrentException, InterruptedException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final int threadCount = 20; 
     final CountDownLatch startLatch = new CountDownLatch(1); 
     class GetThread extends Thread { 
  
         Object object; 
  
         @Override 
         public void run() { 
             try { 
                 startLatch.await(); 
                 object = initializer.get(); 
             } catch (final InterruptedException iex) { 
             } catch (final ConcurrentException cex) { 
                 object = cex; 
             } 
         } 
     } 
     final GetThread[] threads = new GetThread[threadCount]; 
     for (int i = 0; i < threadCount; i++) { 
         threads[i] = new GetThread(); 
         threads[i].start(); 
     } 
     startLatch.countDown(); 
     for (final Thread t : threads) { 
         t.join(); 
     } 
     final Object managedObject = initializer.get(); 
     for (final GetThread t : threads) { 
         assertEquals("Wrong object", managedObject, t.object); 
     } 
 } 
@Test 
 public void testGetMultipleTimes9218() throws ConcurrentException { 
     final ConcurrentInitializer<Object> initializer = createInitializer(); 
     final Object obj = initializer.get(); 
     for (int i = 0; i < 10; i++) { 
         assertEquals("Got different object at " + i, obj, initializer.get()); 
     } 
 } 
