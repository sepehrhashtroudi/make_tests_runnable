@Test 
 public void testAcquireLimit592() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testStartTimer1134() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testAcquireLimit1385() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testStartTimer1723() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testInit2541() { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     EasyMock.replay(service); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, LIMIT); 
     EasyMock.verify(service); 
     assertEquals("Wrong service", service, semaphore.getExecutorService()); 
     assertEquals("Wrong period", PERIOD, semaphore.getPeriod()); 
     assertEquals("Wrong unit", UNIT, semaphore.getUnit()); 
     assertEquals("Statistic available", 0, semaphore.getLastAcquiresPerPeriod()); 
     assertEquals("Average available", 0.0, semaphore.getAverageCallsPerPeriod(), .05); 
     assertFalse("Already shutdown", semaphore.isShutdown()); 
     assertEquals("Wrong limit", LIMIT, semaphore.getLimit()); 
 } 
@Test 
 public void testStartTimer2682() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testAcquireLimit2934() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testGetAvailablePermits2987() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, LIMIT); 
     for (int i = 0; i < LIMIT; i++) { 
         assertEquals("Wrong available count at " + i, LIMIT - i, semaphore.getAvailablePermits()); 
         semaphore.acquire(); 
     } 
     semaphore.endOfPeriod(); 
     assertEquals("Wrong available count in new period", LIMIT, semaphore.getAvailablePermits()); 
     EasyMock.verify(service, future); 
 } 
@Test(expected = IllegalStateException.class) 
 public void testPassAfterShutdown2990() throws InterruptedException { 
     final TimedSemaphore semaphore = new TimedSemaphore(PERIOD, UNIT, LIMIT); 
     semaphore.shutdown(); 
     semaphore.acquire(); 
 } 
@Test 
 public void testStartTimer2997() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testAcquireLimit3727() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testStartTimer3926() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testAcquireLimit4029() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testAcquireLimit4247() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testAcquireLimit4707() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testStartTimer4961() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testAcquireLimit5304() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testStartTimer6031() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testGetAvailablePermits6058() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, LIMIT); 
     for (int i = 0; i < LIMIT; i++) { 
         assertEquals("Wrong available count at " + i, LIMIT - i, semaphore.getAvailablePermits()); 
         semaphore.acquire(); 
     } 
     semaphore.endOfPeriod(); 
     assertEquals("Wrong available count in new period", LIMIT, semaphore.getAvailablePermits()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testAcquireLimit6115() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testAcquireLimit6274() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
 public void testStartTimer6278() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitInvalidPeriod6538() { 
     new TimedSemaphore(0L, UNIT, LIMIT); 
 } 
@Test 
 public void testAcquireLimit7165() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitInvalidPeriod7344() { 
     new TimedSemaphore(0L, UNIT, LIMIT); 
 } 
@Test 
 public void testStartTimer7414() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test 
 public void testInit7575() { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     EasyMock.replay(service); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, LIMIT); 
     EasyMock.verify(service); 
     assertEquals("Wrong service", service, semaphore.getExecutorService()); 
     assertEquals("Wrong period", PERIOD, semaphore.getPeriod()); 
     assertEquals("Wrong unit", UNIT, semaphore.getUnit()); 
     assertEquals("Statistic available", 0, semaphore.getLastAcquiresPerPeriod()); 
     assertEquals("Average available", 0.0, semaphore.getAverageCallsPerPeriod(), .05); 
     assertFalse("Already shutdown", semaphore.isShutdown()); 
     assertEquals("Wrong limit", LIMIT, semaphore.getLimit()); 
 } 
@Test 
 public void testStartTimer8023() throws InterruptedException { 
     final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, UNIT, LIMIT); 
     final ScheduledFuture<?> future = semaphore.startTimer(); 
     assertNotNull("No future returned", future); 
     Thread.sleep(PERIOD); 
     final int trials = 10; 
     int count = 0; 
     do { 
         Thread.sleep(PERIOD); 
         if (count++ > trials) { 
             fail("endOfPeriod() not called!"); 
         } 
     } while (semaphore.getPeriodEnds() <= 0); 
     semaphore.shutdown(); 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testInitInvalidPeriod8642() { 
     new TimedSemaphore(0L, UNIT, LIMIT); 
 } 
@Test 
 public void testAcquireLimit9554() throws InterruptedException { 
     final ScheduledExecutorService service = EasyMock.createMock(ScheduledExecutorService.class); 
     final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
     prepareStartTimer(service, future); 
     EasyMock.replay(service, future); 
     final int count = 10; 
     final CountDownLatch latch = new CountDownLatch(count - 1); 
     final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
     final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, count - 1); 
     semaphore.setLimit(count - 1); 
     t.start(); 
     latch.await(); 
     assertEquals("Wrong semaphore count", count - 1, semaphore.getAcquireCount()); 
     semaphore.endOfPeriod(); 
     t.join(); 
     assertEquals("Wrong semaphore count (2)", 1, semaphore.getAcquireCount()); 
     assertEquals("Wrong acquire() count", count - 1, semaphore.getLastAcquiresPerPeriod()); 
     EasyMock.verify(service, future); 
 } 
@Test 
     public void testAcquireLimit9687() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.shutdown(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12547() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12548() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12549() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, 
                 LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12550() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12551() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testGetSetUnit12552() { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setUnit(TimeUnit.SECONDS); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12553() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12554() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12555() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12556() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, 
                 LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12557() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12558() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testStartTimer12559() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testStartTimer12560() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12561() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12562() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12563() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12564() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.shutdown(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12565() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testGetSetUnit12566() { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setUnit(TimeUnit.SECONDS); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12567() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12568() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12569() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12570() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12571() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12572() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12573() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12574() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12575() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12576() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12577() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testStartTimer12578() throws InterruptedException { 
         final TimedSemaphoreTestImpl semaphore = new TimedSemaphoreTestImpl(PERIOD, 
                 UNIT, LIMIT); 
         final ScheduledFuture<?> future = semaphore.startTimer(); 
         assertNotNull("No future returned", future); 
         Thread.sleep(PERIOD); 
         final int trials = 10; 
         int count = 0; 
         do { 
             Thread.sleep(PERIOD); 
             if (count++ > trials) { 
                 fail("endOfPeriod() not called!"); 
             } 
         } while (semaphore.getPeriodEnds() <= 0); 
         semaphore.shutdown(); 
     } 
  
     /** 
      * Tests the shutdown() method if the executor belongs to the semaphore. In 
      * this case it has to be shut down. 
      */ 

@Test 
     public void testAcquireLimit12579() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

@Test 
     public void testAcquireLimit12580() throws InterruptedException { 
         final ScheduledExecutorService service = EasyMock 
                 .createMock(ScheduledExecutorService.class); 
         final ScheduledFuture<?> future = EasyMock.createMock(ScheduledFuture.class); 
         prepareStartTimer(service, future); 
         EasyMock.replay(service, future); 
         final int count = 10; 
         final CountDownLatch latch = new CountDownLatch(count - 1); 
         final TimedSemaphore semaphore = new TimedSemaphore(service, PERIOD, UNIT, 1); 
         final SemaphoreThread t = new SemaphoreThread(semaphore, latch, count, 
                 count - 1); 
         semaphore.setLimit(count - 1); 
  
         // start a thread that calls the semaphore count times 
         t.start(); 
         latch.await(); 
         // now the semaphore's limit should be reached and the thread blocked 
         assertEquals("Wrong semaphore count", count - 1, semaphore 
                 .getAcquireCount()); 
  
         // this wakes up the thread, it should call the semaphore once more 
         semaphore.endOfPeriod(); 
         t.join(); 
         assertEquals("Wrong semaphore count (2)", 1, semaphore 
                 .getAcquireCount()); 
         assertEquals("Wrong acquire() count", count - 1, semaphore 
                 .getLastAcquiresPerPeriod()); 
         EasyMock.verify(service, future); 
     } 
  
     /** 
      * Tests the acquire() method if more threads are involved than the limit. 
      * This method starts a number of threads that all invoke the semaphore. The 
      * semaphore's limit is set to 1, so in each period only a single thread can 
      * acquire the semaphore. 
      */ 

