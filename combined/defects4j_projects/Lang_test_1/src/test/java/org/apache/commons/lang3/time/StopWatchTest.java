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
public void testStopWatchSplit431() { 
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
public void testLang315432() { 
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
