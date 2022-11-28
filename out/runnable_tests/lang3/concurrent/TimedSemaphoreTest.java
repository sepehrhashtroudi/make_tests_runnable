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
