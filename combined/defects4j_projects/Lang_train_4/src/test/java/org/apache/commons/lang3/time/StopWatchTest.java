/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Assert;

import org.junit.Test;

/**
 * TestCase for StopWatch.
 *
 * @version $Id$
 */
public class StopWatchTest  {

    //-----------------------------------------------------------------------
@Test
public void testLang315964() { 
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
public void testBadStates965() { 
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
public void testGetStartTime966() { 
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
public void testStopWatchSuspend967() { 
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
public void testStopWatchSimple968() { 
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
public void testStopWatchSimpleGet969() { 
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
    
    
    
    
    
    
    

    

    // test bad states
    

    

}
