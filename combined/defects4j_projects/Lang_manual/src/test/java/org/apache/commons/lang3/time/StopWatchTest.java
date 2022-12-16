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
public void testStopWatchSimpleGet60() { 
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
public void testBadStates93() { 
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
     }
@Test
public void testLang315348() { 
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
    
    
    
    
    
    
    

    

    // test bad states
    

    

}
