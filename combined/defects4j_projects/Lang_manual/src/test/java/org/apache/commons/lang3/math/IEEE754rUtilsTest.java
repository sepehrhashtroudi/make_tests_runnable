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
package org.apache.commons.lang3.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.math.IEEE754rUtils}.
 *
 * @version $Id$
 */
public class IEEE754rUtilsTest  {

@Test
public void testEnforceExceptions35() { 
     try { 
         IEEE754rUtils.min((float[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min(new float[0]); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max((float[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max(new float[0]); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min((double[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min(new double[0]); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max((double[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max(new double[0]); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinimumFloat233() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(low, min(low, mid, high), 0.0001f); 
     assertEquals(low, min(mid, low, high), 0.0001f); 
     assertEquals(low, min(mid, high, low), 0.0001f); 
     assertEquals(low, min(low, mid, low), 0.0001f); 
     assertEquals(mid, min(high, mid, high), 0.0001f); 
 }
@Test
public void testEnforceExceptions234() { 
     try { 
         IEEE754rUtils.min((float[]) null, null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min(new float[0], null); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max((float[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max(new float[0]); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min((double[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min(new double[0], new double[0]); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max((double[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max(new double[0], new double[0]); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinimumFloat235() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(low, Math.min(low, mid, high), 0.0001f); 
     assertEquals(low, Math.min(mid, low, high), 0.0001f); 
     assertEquals(low, Math.min(mid, high, low), 0.0001f); 
     assertEquals(low, Math.min(low, mid, low), 0.0001f); 
     assertEquals(mid, Math.min(high, mid, high), 0.0001f); 
 }
@Test
public void testMinimumDouble236() { 
     final double low = 12.3; 
     final double mid = 12.3 + 1; 
     final double high = 12.3 + 2; 
     assertEquals(low, Math.min(low, mid, high), 0.0001); 
     assertEquals(low, Math.min(mid, low, high), 0.0001); 
     assertEquals(low, Math.min(mid, high, low), 0.0001); 
     assertEquals(low, Math.min(low, mid, low), 0.0001); 
     assertEquals(mid, Math.min(high, mid, high), 0.0001); 
 }
@Test
public void testEnforceExceptions237() { 
     try { 
         IEEE754rUtils.min((float[]) null, (float[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min(new float[0], (float[]) null); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max((float[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max(new float[0], (float[]) null); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min((double[]) null, (double[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.min(new double[0], (double[]) null); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max((double[]) null); 
         fail("IllegalArgumentException expected for null input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         IEEE754rUtils.max(new double[0], (double) 1); 
         fail("IllegalArgumentException expected for empty input"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinimumFloat238() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(low, IEEE754f.min(low, mid, high), 0.0001f); 
     assertEquals(low, IEEE754f.min(mid, low, high), 0.0001f); 
     assertEquals(low, IEEE754f.min(mid, high, low), 0.0001f); 
     assertEquals(low, IEEE754f.min(low, mid, low), 0.0001f); 
     assertEquals(mid, IEEE754f.min(high, mid, high), 0.0001f); 
 }
@Test
public void testMaximumDouble239() { 
     final double low = 12.3; 
     final double mid = 12.3 + 1; 
     final double high = 12.3 + 2; 
     assertEquals(high, IEEE754.max(low, mid), 0.0001); 
     assertEquals(high, IEEE754.max(mid, low, high), 0.0001); 
     assertEquals(high, IEEE754.max(mid, high, low), 0.0001); 
     assertEquals(mid, IEEE754.max(low, mid, low), 0.0001); 
     assertEquals(high, IEEE754.max(high, mid, high), 0.0001); 
 }
@Test
public void testMaximumDouble240() { 
     final double low = 12.3; 
     final double mid = 12.3 + 1; 
     final double high = 12.3 + 2; 
     assertEquals(high, IEEE754.max(low, mid, high), 0.0001); 
     assertEquals(high, IEEE754.max(mid, low, high), 0.0001); 
     assertEquals(high, IEEE754.max(mid, high, low), 0.0001); 
     assertEquals(mid, IEEE754.max(low, mid, low), 0.0001); 
     assertEquals(high, IEEE754.max(high, mid, high), 0.0001); 
 }
@Test
public void testMaximumFloat241() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(high, StringUtils.max(low, mid), 0.0001f); 
     assertEquals(high, StringUtils.max(mid, low, high), 0.0001f); 
     assertEquals(high, StringUtils.max(mid, high, low), 0.0001f); 
     assertEquals(mid, StringUtils.max(low, mid, low), 0.0001f); 
     assertEquals(high, StringUtils.max(high, mid, high), 0.0001f); 
 }
@Test
public void testMaximumFloat242() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(high, StringUtils.max(low, mid, high), 0.0001f); 
     assertEquals(high, StringUtils.max(mid, low, high), 0.0001f); 
     assertEquals(high, StringUtils.max(mid, high, low), 0.0001f); 
     assertEquals(mid, StringUtils.max(low, mid, low), 0.0001f); 
     assertEquals(high, StringUtils.max(high, mid, high), 0.0001f); 
 }
@Test
public void testMaximumFloat243() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(high, IEEE754f, StringUtils.max(low, mid, high), 0.0001f); 
     assertEquals(high, IEEE754f, StringUtils.max(mid, low, high), 0.0001f); 
     assertEquals(high, IEEE754f, StringUtils.max(mid, high, low), 0.0001f); 
     assertEquals(mid, IEEE754f, StringUtils.max(low, mid, low), 0.0001f); 
     assertEquals(high, IEEE754f, StringUtils.max(high, mid, high), 0.0001f); 
 }
    

    

    
    
}
