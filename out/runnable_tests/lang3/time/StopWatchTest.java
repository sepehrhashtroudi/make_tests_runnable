@Test 
 public void testBadStates379() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates608() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSimple707() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long time = watch.getTime(); 
     assertEquals(time, watch.getTime()); 
     assertTrue(time >= 500); 
     assertTrue(time < 700); 
     watch.reset(); 
     assertEquals(0, watch.getTime()); 
 } 
@Test 
 public void testBadStates781() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testGetStartTime1189() { 
     final long beforeStopWatch = System.currentTimeMillis(); 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on an unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
     watch.start(); 
     try { 
         watch.getStartTime(); 
         Assert.assertTrue(watch.getStartTime() >= beforeStopWatch); 
     } catch (final IllegalStateException ex) { 
         fail("Start time should be available: " + ex.getMessage()); 
     } 
     watch.reset(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on a reset, but unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
 } 
@Test 
 public void testStopWatchSplit1221() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.split(); 
     final long splitTime = watch.getSplitTime(); 
     final String splitStr = watch.toSplitString(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.unsplit(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertEquals("Formatted split string not the correct length", splitStr.length(), 11); 
     assertTrue(splitTime >= 500); 
     assertTrue(splitTime < 700); 
     assertTrue(totalTime >= 1500); 
     assertTrue(totalTime < 1900); 
 } 
@Test 
 public void testStopWatchSimple1281() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long time = watch.getTime(); 
     assertEquals(time, watch.getTime()); 
     assertTrue(time >= 500); 
     assertTrue(time < 700); 
     watch.reset(); 
     assertEquals(0, watch.getTime()); 
 } 
@Test 
 public void testBadStates1294() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testLang3151392() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime == totalTime); 
 } 
@Test 
 public void testLang3151532() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime == totalTime); 
 } 
@Test 
 public void testStopWatchSimpleGet1609() { 
     final StopWatch watch = new StopWatch(); 
     assertEquals(0, watch.getTime()); 
     assertEquals("0:00:00.000", watch.toString()); 
     watch.start(); 
     try { 
         Thread.sleep(500); 
     } catch (final InterruptedException ex) { 
     } 
     assertTrue(watch.getTime() < 2000); 
 } 
@Test 
 public void testBadStates2197() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSplit2569() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.split(); 
     final long splitTime = watch.getSplitTime(); 
     final String splitStr = watch.toSplitString(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.unsplit(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertEquals("Formatted split string not the correct length", splitStr.length(), 11); 
     assertTrue(splitTime >= 500); 
     assertTrue(splitTime < 700); 
     assertTrue(totalTime >= 1500); 
     assertTrue(totalTime < 1900); 
 } 
@Test 
 public void testGetStartTime2720() { 
     final long beforeStopWatch = System.currentTimeMillis(); 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on an unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
     watch.start(); 
     try { 
         watch.getStartTime(); 
         Assert.assertTrue(watch.getStartTime() >= beforeStopWatch); 
     } catch (final IllegalStateException ex) { 
         fail("Start time should be available: " + ex.getMessage()); 
     } 
     watch.reset(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on a reset, but unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
 } 
@Test 
 public void testBadStates2928() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSplit3040() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.split(); 
     final long splitTime = watch.getSplitTime(); 
     final String splitStr = watch.toSplitString(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.unsplit(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertEquals("Formatted split string not the correct length", splitStr.length(), 11); 
     assertTrue(splitTime >= 500); 
     assertTrue(splitTime < 700); 
     assertTrue(totalTime >= 1500); 
     assertTrue(totalTime < 1900); 
 } 
@Test 
 public void testBadStates3395() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates3429() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSplit3529() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.split(); 
     final long splitTime = watch.getSplitTime(); 
     final String splitStr = watch.toSplitString(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.unsplit(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertEquals("Formatted split string not the correct length", splitStr.length(), 11); 
     assertTrue(splitTime >= 500); 
     assertTrue(splitTime < 700); 
     assertTrue(totalTime >= 1500); 
     assertTrue(totalTime < 1900); 
 } 
@Test 
 public void testBadStates3843() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates3888() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testLang3153914() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime == totalTime); 
 } 
@Test 
 public void testGetStartTime3977() { 
     final long beforeStopWatch = System.currentTimeMillis(); 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on an unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
     watch.start(); 
     try { 
         watch.getStartTime(); 
         Assert.assertTrue(watch.getStartTime() >= beforeStopWatch); 
     } catch (final IllegalStateException ex) { 
         fail("Start time should be available: " + ex.getMessage()); 
     } 
     watch.reset(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on a reset, but unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
 } 
@Test 
 public void testBadStates4089() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates4318() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates4844() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testLang3154872() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime == totalTime); 
 } 
@Test 
 public void testBadStates5108() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates5222() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates5313() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testLang3155462() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime == totalTime); 
 } 
@Test 
 public void testBadStates5630() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSimpleGet5700() { 
     final StopWatch watch = new StopWatch(); 
     assertEquals(0, watch.getTime()); 
     assertEquals("0:00:00.000", watch.toString()); 
     watch.start(); 
     try { 
         Thread.sleep(500); 
     } catch (final InterruptedException ex) { 
     } 
     assertTrue(watch.getTime() < 2000); 
 } 
@Test 
 public void testBadStates5725() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates5735() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSimple6344() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long time = watch.getTime(); 
     assertEquals(time, watch.getTime()); 
     assertTrue(time >= 500); 
     assertTrue(time < 700); 
     watch.reset(); 
     assertEquals(0, watch.getTime()); 
 } 
@Test 
 public void testBadStates6376() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSplit6465() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.split(); 
     final long splitTime = watch.getSplitTime(); 
     final String splitStr = watch.toSplitString(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.unsplit(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertEquals("Formatted split string not the correct length", splitStr.length(), 11); 
     assertTrue(splitTime >= 500); 
     assertTrue(splitTime < 700); 
     assertTrue(totalTime >= 1500); 
     assertTrue(totalTime < 1900); 
 } 
@Test 
 public void testLang3156480() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime == totalTime); 
 } 
@Test 
 public void testBadStates6641() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testLang3156723() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(200); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime == totalTime); 
 } 
@Test 
 public void testStopWatchSplit6859() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.split(); 
     final long splitTime = watch.getSplitTime(); 
     final String splitStr = watch.toSplitString(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.unsplit(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertEquals("Formatted split string not the correct length", splitStr.length(), 11); 
     assertTrue(splitTime >= 500); 
     assertTrue(splitTime < 700); 
     assertTrue(totalTime >= 1500); 
     assertTrue(totalTime < 1900); 
 } 
@Test 
 public void testStopWatchSimple7006() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long time = watch.getTime(); 
     assertEquals(time, watch.getTime()); 
     assertTrue(time >= 500); 
     assertTrue(time < 700); 
     watch.reset(); 
     assertEquals(0, watch.getTime()); 
 } 
@Test 
 public void testBadStates7263() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSimple7371() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long time = watch.getTime(); 
     assertEquals(time, watch.getTime()); 
     assertTrue(time >= 500); 
     assertTrue(time < 700); 
     watch.reset(); 
     assertEquals(0, watch.getTime()); 
 } 
@Test 
 public void testBadStates7378() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSimpleGet7557() { 
     final StopWatch watch = new StopWatch(); 
     assertEquals(0, watch.getTime()); 
     assertEquals("0:00:00.000", watch.toString()); 
     watch.start(); 
     try { 
         Thread.sleep(500); 
     } catch (final InterruptedException ex) { 
     } 
     assertTrue(watch.getTime() < 2000); 
 } 
@Test 
 public void testBadStates7621() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSuspend7739() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.resume(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime >= 500); 
     assertTrue(suspendTime < 700); 
     assertTrue(totalTime >= 1000); 
     assertTrue(totalTime < 1300); 
 } 
@Test 
 public void testGetStartTime7834() { 
     final long beforeStopWatch = System.currentTimeMillis(); 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on an unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
     watch.start(); 
     try { 
         watch.getStartTime(); 
         Assert.assertTrue(watch.getStartTime() >= beforeStopWatch); 
     } catch (final IllegalStateException ex) { 
         fail("Start time should be available: " + ex.getMessage()); 
     } 
     watch.reset(); 
     try { 
         watch.getStartTime(); 
         fail("Calling getStartTime on a reset, but unstarted StopWatch should throw an exception"); 
     } catch (final IllegalStateException expected) { 
     } 
 } 
@Test 
 public void testBadStates7955() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates8080() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates8215() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSuspend8581() { 
     final StopWatch watch = new StopWatch(); 
     watch.start(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.suspend(); 
     final long suspendTime = watch.getTime(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.resume(); 
     try { 
         Thread.sleep(550); 
     } catch (final InterruptedException ex) { 
     } 
     watch.stop(); 
     final long totalTime = watch.getTime(); 
     assertTrue(suspendTime >= 500); 
     assertTrue(suspendTime < 700); 
     assertTrue(totalTime >= 1000); 
     assertTrue(totalTime < 1300); 
 } 
@Test 
 public void testBadStates8855() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates8856() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates8979() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates9280() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testBadStates9371() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
@Test 
 public void testStopWatchSimpleGet9401() { 
     final StopWatch watch = new StopWatch(); 
     assertEquals(0, watch.getTime()); 
     assertEquals("0:00:00.000", watch.toString()); 
     watch.start(); 
     try { 
         Thread.sleep(500); 
     } catch (final InterruptedException ex) { 
     } 
     assertTrue(watch.getTime() < 2000); 
 } 
@Test 
 public void testBadStates9417() { 
     final StopWatch watch = new StopWatch(); 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.stop(); 
         fail("Calling stop on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.suspend(); 
         fail("Calling suspend on an unstarted StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.split(); 
         fail("Calling split on a non-running StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.start(); 
     try { 
         watch.start(); 
         fail("Calling start on a started StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.unsplit(); 
         fail("Calling unsplit on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.getSplitTime(); 
         fail("Calling getSplitTime on an unsplit StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     try { 
         watch.resume(); 
         fail("Calling resume on an unsuspended StopWatch should throw an exception. "); 
     } catch (final IllegalStateException ise) { 
     } 
     watch.stop(); 
     try { 
         watch.start(); 
         fail("Calling start on a stopped StopWatch should throw an exception as it needs to be reset. "); 
     } catch (final IllegalStateException ise) { 
     } 
 } 
