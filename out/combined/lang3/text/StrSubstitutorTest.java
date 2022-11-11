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

package org.apache.commons.lang3.text;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.mutable.MutableObject;

/**
 * Test class for StrSubstitutor.
 *
 * @version $Id$
 */
public class StrSubstitutorTest {

    private Map<String, String> values;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("animal", "quick brown fox");
        values.put("target", "lazy dog");
    }

    @After
    public void tearDown() throws Exception {
        values = null;
    }

    //-----------------------------------------------------------------------
    /**
     * Tests simple key replace.
     */
@Test
public void testReplaceEmptyKeys19() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys128() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys155() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys167() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceComplexEscaping187() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys227() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys313() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys371() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testStaticReplaceSystemProperties434() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 }
@Test
public void testReplaceEmptyKeys462() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys528() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys535() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys625() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetSuffix629() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testReplaceNull709() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceNull788() { 
     doTestNoReplace(null); 
 }
@Test
public void testGetSetPrefix912() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 }
@Test
public void testGetSetSuffix1100() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testCyclicReplacement1164() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 }
@Test
public void testGetSetSuffix1187() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testReplaceNull1226() { 
     doTestNoReplace(null); 
 }
@Test
public void testCyclicReplacement1324() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 }
@Test
public void testReplaceEmpty1458() { 
     doTestNoReplace(""); 
 }
@Test
public void testReplaceEmptyKeys1487() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetSuffix1530() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testReplaceEmptyKeys1552() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys1600() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys1761() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys1767() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys1816() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetPrefix1868() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 }
@Test
public void testReplaceEmptyKeys2096() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2213() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2215() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2315() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2334() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testConstructorMapFull2352() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     final StrSubstitutor sub = new StrSubstitutor(map, "<", ">", '!'); 
     assertEquals("Hi < commons", sub.replace("Hi !< <name>")); 
 }
@Test
public void testCyclicReplacement2393() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 }
@Test
public void testConstructorMapFull2492() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     final StrSubstitutor sub = new StrSubstitutor(map, "<", ">", '!'); 
     assertEquals("Hi < commons", sub.replace("Hi !< <name>")); 
 }
@Test
public void testStaticReplace2582() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi ${name}!", map)); 
 }
@Test
public void testReplaceEmptyKeys2683() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2701() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSubstituteDefaultProperties2758() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testReplaceEmptyKeys2761() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2802() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2816() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testCyclicReplacement2907() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 }
@Test
public void testReplaceEmptyKeys2929() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys2973() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetPrefix3100() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 }
@Test
public void testReplaceEmptyKeys3114() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceNull3161() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceEmptyKeys3178() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSubstituteDefaultProperties3231() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testReplaceNull3249() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceEmptyKeys3258() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceNull3276() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceEmptyKeys3347() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testCyclicReplacement3385() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 }
@Test
public void testReplaceNull3400() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceComplexEscaping3578() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetSuffix3638() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testSubstituteDefaultProperties3705() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testReplaceEmptyKeys3733() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys3934() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetPrefix3953() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 }
@Test
public void testGetSetSuffix3967() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testGetSetPrefix4095() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 }
@Test
public void testSubstituteDefaultProperties4096() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testReplacePartialString_noReplace4105() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertEquals("${animal} jumps", sub.replace("The ${animal} jumps over the ${target}.", 4, 15)); 
 }
@Test
public void testReplaceEmptyKeys4122() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testStaticReplace4225() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi ${name}!", map)); 
 }
@Test
public void testReplaceEmptyKeys4230() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSubstituteDefaultProperties4268() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testReplaceEmptyKeys4331() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4359() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4544() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4629() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4701() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4717() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4726() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceNull4791() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceEmptyKeys4816() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4870() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4887() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4912() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4914() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys4949() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSubstituteDefaultProperties5140() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testSamePrefixAndSuffix5190() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testReplaceEmptyKeys5333() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSamePrefixAndSuffix5503() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testReplaceEmptyKeys5547() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceComplexEscaping5570() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 }
@Test
public void testSamePrefixAndSuffix5632() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testReplaceEmptyKeys5689() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys5803() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys5810() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys6051() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys6067() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys6069() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSubstituteDefaultProperties6103() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testReplaceEmptyKeys6232() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSamePrefixAndSuffix6242() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testSamePrefixAndSuffix6272() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testGetSetPrefix6301() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 }
@Test
public void testReplaceEmptyKeys6302() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys6330() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys6349() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSamePrefixAndSuffix6437() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testReplaceEmptyKeys6472() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys6586() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceComplexEscaping6615() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys6764() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSamePrefixAndSuffix6957() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testReplaceEmptyKeys6968() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetSuffix7001() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testSubstituteDefaultProperties7066() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testGetSetSuffix7191() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testReplaceEmptyKeys7445() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSamePrefixAndSuffix7859() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testReplaceEmptyKeys7921() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys7930() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceNull8077() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceNull8163() { 
     doTestNoReplace(null); 
 }
@Test
public void testGetSetSuffix8180() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 }
@Test
public void testReplaceEmptyKeys8190() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSamePrefixAndSuffix8198() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 }
@Test
public void testCyclicReplacement8284() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 }
@Test
public void testGetSetPrefix8382() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 }
@Test
public void testReplaceEmptyKeys8463() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys8469() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceComplexEscaping8470() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 }
@Test
public void testReplacePartialString_noReplace8615() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertEquals("${animal} jumps", sub.replace("The ${animal} jumps over the ${target}.", 4, 15)); 
 }
@Test
public void testReplaceEmptyKeys8616() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys8653() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys8710() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys8837() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testSubstituteDefaultProperties8878() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 }
@Test
public void testReplaceEmptyKeys8951() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys9025() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceNull9094() { 
     doTestNoReplace(null); 
 }
@Test
public void testStaticReplaceSystemProperties9150() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 }
@Test
public void testStaticReplaceSystemProperties9159() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 }
@Test
public void testStaticReplaceSystemProperties9197() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 }
@Test
public void testReplaceNull9244() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceNull9321() { 
     doTestNoReplace(null); 
 }
@Test
public void testReplaceEmptyKeys9365() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testReplaceEmptyKeys9382() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 }
@Test
public void testGetSetSuffix9570() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping9662() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9843() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9844() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9845() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9846() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9847() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9848() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9849() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping9850() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetSuffix9851() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         sub.setSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testSamePrefixAndSuffix12028() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testReplaceComplexEscaping12029() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testSamePrefixAndSuffix12030() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testReplaceComplexEscaping12031() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testCyclicReplacement12032() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("animal", "${critter}"); 
         map.put("target", "${pet}"); 
         map.put("pet", "${petCharacteristic} dog"); 
         map.put("petCharacteristic", "lazy"); 
         map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
         map.put("critterSpeed", "quick"); 
         map.put("critterColor", "brown"); 
         map.put("critterType", "${animal}"); 
         final StrSubstitutor sub = new StrSubstitutor(map); 
         try { 
             sub.replace("The ${animal} jumps over the ${target}."); 
             fail("Cyclic replacement was not detected!"); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
     } 
  
     /** 
      * Tests interpolation with weird boundary patterns. 
      */
@Test
public void testGetSetPrefix12033() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariablePrefix('<'); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariablePrefix("<<"); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariablePrefix((String) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariablePrefixMatcher(matcher); 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
         try { 
             sub.setVariablePrefixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12034() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12035() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12036() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetSuffix12037() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12038() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12039() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12040() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetPrefix12041() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariablePrefix('<'); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariablePrefix("<<"); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariablePrefix((String) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariablePrefixMatcher(matcher); 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
         try { 
             sub.setVariablePrefixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12042() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12043() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceEmptyKeys12044() { 
         doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests replace creates output same as input. 
      */
@Test
public void testSamePrefixAndSuffix12045() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testReplaceComplexEscaping12046() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12047() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12048() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12049() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetPrefix12050() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariablePrefix('<'); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariablePrefix("<<"); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariablePrefix((String) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariablePrefixMatcher(matcher); 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
         try { 
             sub.setVariablePrefixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12051() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12054() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12055() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12056() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12058() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12059() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testSamePrefixAndSuffix12060() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testReplaceComplexEscaping12061() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12063() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSet12064() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableResolver() instanceof StrLookup<?>); 
         sub.setVariableResolver(StrLookup.create("<null>")); 
         assertTrue(sub.getVariableResolver() instanceof StrLookup<?>); 
         sub.setVariableResolver(StrLookup.create((String) null)); 
         assertTrue(sub.getVariableResolver() instanceof StrLookup<?>); 
         try { 
             sub.setVariableResolver(StrLookup.create((String) null)); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableResolver() instanceof StrLookup<?>); 
  
         final StrLookup<String> var = StrLookup.create("<null>"); 
         sub.setVariableResolver(var); 
         assertSame(var, sub.getVariableResolver()); 
         try { 
             sub.setVariableResolver(null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(var, sub.getVariableResolver()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceEmptyKeys12065() { 
         doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests replace creates output same as input. 
      */
@Test
public void testGetSetSuffix12066() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testGetSetSuffix12067() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12069() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceEmptyKeys12070() { 
         doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests replace creates output same as input. 
      */
@Test
public void testGetSetSuffix12071() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12072() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testCyclicReplacement12073() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("animal", "${critter}"); 
         map.put("target", "${pet}"); 
         map.put("pet", "${petCharacteristic} dog"); 
         map.put("petCharacteristic", "lazy"); 
         map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
         map.put("critterSpeed", "quick"); 
         map.put("critterColor", "brown"); 
         map.put("critterType", "${animal}"); 
         final StrSubstitutor sub = new StrSubstitutor(map); 
         try { 
             sub.replace("The ${animal} jumps over the ${target}."); 
             fail("Cyclic replacement was not detected!"); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
     } 
  
     /** 
      * Tests interpolation with weird boundary patterns. 
      */
@Test
public void testCyclicReplacement12074() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("animal", "${critter}"); 
         map.put("target", "${pet}"); 
         map.put("pet", "${petCharacteristic} dog"); 
         map.put("petCharacteristic", "lazy"); 
         map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
         map.put("critterSpeed", "quick"); 
         map.put("critterColor", "brown"); 
         map.put("critterType", "${animal}"); 
         final StrSubstitutor sub = new StrSubstitutor(map); 
         try { 
             sub.replace("The ${animal} jumps over the ${target}."); 
             fail("Cyclic replacement was not detected!"); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
     } 
  
     /** 
      * Tests interpolation with weird boundary patterns. 
      */
@Test
public void testReplaceEmptyKeys12075() { 
         doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests replace creates output same as input. 
      */
@Test
public void testSamePrefixAndSuffix12076() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testReplaceComplexEscaping12077() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12078() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12079() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12080() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12081() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12082() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testSamePrefixAndSuffix12083() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testReplaceComplexEscaping12084() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testSamePrefixAndSuffix12085() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("greeting", "Hello"); 
         map.put(" there ", "XXX"); 
         map.put("name", "commons"); 
         assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
         assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
     } 
  
     //-----------------------------------------------------------------------
@Test
public void testReplaceComplexEscaping12087() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetSuffix12088() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12089() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12090() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12091() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12092() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12093() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceEmptyKeys12094() { 
         doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests replace creates output same as input. 
      */
@Test
public void testReplaceComplexEscaping12095() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetPrefix12096() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariablePrefix('<'); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariablePrefix("<<"); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariablePrefix((String) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariablePrefixMatcher(matcher); 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
         try { 
             sub.setVariablePrefixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final NullPointerException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12097() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12098() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetPrefix12099() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariablePrefix('<'); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariablePrefix("<<"); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariablePrefix((String) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariablePrefixMatcher(matcher); 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
         try { 
             sub.setVariablePrefixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12100() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetPrefix12101() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariablePrefix('<'); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariablePrefix("<<"); 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariablePrefix((String) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariablePrefixMatcher(matcher); 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
         try { 
             sub.setVariablePrefixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariablePrefixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12102() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12103() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetSuffix12104() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12105() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testGetSetSuffix12106() { 
         final StrSubstitutor sub = new StrSubstitutor(); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         sub.setVariableSuffix('<'); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
  
         sub.setVariableSuffix("<<"); 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
         try { 
             sub.setVariableSuffix((String) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
  
         final StrMatcher matcher = StrMatcher.commaMatcher(); 
         sub.setVariableSuffixMatcher(matcher); 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
         try { 
             sub.setVariableSuffixMatcher((StrMatcher) null); 
             fail(); 
         } catch (final IllegalArgumentException ex) { 
             // expected 
         } 
         assertSame(matcher, sub.getVariableSuffixMatcher()); 
     } 
  
     /** 
      * Tests get set. 
      */
@Test
public void testReplaceComplexEscaping12107() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12108() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12109() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12110() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
@Test
public void testReplaceComplexEscaping12111() { 
         doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
     } 
  
     /** 
      * Tests when no prefix or suffix. 
      */
    

    /**
     * Tests simple key replace.
     */
    

    /**
     * Tests replace with no variables.
     */
    

    /**
     * Tests replace with null.
     */
    

    /**
     * Tests replace with null.
     */
    

    /**
     * Tests key replace changing map after initialization (not recommended).
     */
    

    /**
     * Tests unknown key replace.
     */
    

    /**
     * Tests adjacent keys.
     */
    

    /**
     * Tests adjacent keys.
     */
    

    /**
     * Tests simple recursive replace.
     */
    

    /**
     * Tests escaping.
     */
    

    /**
     * Tests escaping.
     */
    

    /**
     * Tests complex escaping.
     */
    

    /**
     * Tests when no prefix or suffix.
     */
    

    /**
     * Tests when no incomplete prefix.
     */
    

    /**
     * Tests when prefix but no suffix.
     */
    

    /**
     * Tests when suffix but no prefix.
     */
    

    /**
     * Tests when no variable name.
     */
    

    /**
     * Tests replace creates output same as input.
     */
    

    /**
     * Tests a cyclic replace operation.
     * The cycle should be detected and cause an exception to be thrown.
     */
    

    /**
     * Tests interpolation with weird boundary patterns.
     */
    

    /**
     * Tests simple key replace.
     */
    

    /**
     * Tests whether a variable can be replaced in a variable name.
     */
    

    /**
     * Tests whether substitution in variable names is disabled per default.
     */
    

    /**
     * Tests complex and recursive substitution in variable names.
     */
    

    //-----------------------------------------------------------------------
    /**
     * Tests protected.
     */
    

    //-----------------------------------------------------------------------
    /**
     * Tests constructor.
     */
    

    /**
     * Tests constructor.
     */
    

    /**
     * Tests constructor.
     */
    

    //-----------------------------------------------------------------------
    /**
     * Tests get set.
     */
    

    /**
     * Tests get set.
     */
    

    /**
     * Tests get set.
     */
    

    //-----------------------------------------------------------------------
    /**
     * Tests static.
     */
    

    /**
     * Tests static.
     */
    

    /**
     * Tests interpolation with system properties.
     */
    

    /**
     * Test the replace of a properties object
     */
    
    
    

    //-----------------------------------------------------------------------
    private void doTestReplace(final String expectedResult, final String replaceTemplate, final boolean substring) {
        final String expectedShortResult = expectedResult.substring(1, expectedResult.length() - 1);
        final StrSubstitutor sub = new StrSubstitutor(values);

        // replace using String
        assertEquals(expectedResult, sub.replace(replaceTemplate));
        if (substring) {
            assertEquals(expectedShortResult, sub.replace(replaceTemplate, 1, replaceTemplate.length() - 2));
        }

        // replace using char[]
        final char[] chars = replaceTemplate.toCharArray();
        assertEquals(expectedResult, sub.replace(chars));
        if (substring) {
            assertEquals(expectedShortResult, sub.replace(chars, 1, chars.length - 2));
        }

        // replace using StringBuffer
        StringBuffer buf = new StringBuffer(replaceTemplate);
        assertEquals(expectedResult, sub.replace(buf));
        if (substring) {
            assertEquals(expectedShortResult, sub.replace(buf, 1, buf.length() - 2));
        }

        // replace using StringBuilder
        StringBuilder builder = new StringBuilder(replaceTemplate);
        assertEquals(expectedResult, sub.replace(builder));
        if (substring) {
            assertEquals(expectedShortResult, sub.replace(builder, 1, builder.length() - 2));
        }
        
        // replace using StrBuilder
        StrBuilder bld = new StrBuilder(replaceTemplate);
        assertEquals(expectedResult, sub.replace(bld));
        if (substring) {
            assertEquals(expectedShortResult, sub.replace(bld, 1, bld.length() - 2));
        }

        // replace using object
        final MutableObject<String> obj = new MutableObject<String>(replaceTemplate);  // toString returns template
        assertEquals(expectedResult, sub.replace(obj));

        // replace in StringBuffer
        buf = new StringBuffer(replaceTemplate);
        assertTrue(sub.replaceIn(buf));
        assertEquals(expectedResult, buf.toString());
        if (substring) {
            buf = new StringBuffer(replaceTemplate);
            assertTrue(sub.replaceIn(buf, 1, buf.length() - 2));
            assertEquals(expectedResult, buf.toString());  // expect full result as remainder is untouched
        }

        // replace in StringBuilder
        builder = new StringBuilder(replaceTemplate);
        assertTrue(sub.replaceIn(builder));
        assertEquals(expectedResult, builder.toString());
        if (substring) {
        	builder = new StringBuilder(replaceTemplate);
            assertTrue(sub.replaceIn(builder, 1, builder.length() - 2));
            assertEquals(expectedResult, builder.toString());  // expect full result as remainder is untouched
        }
        
        // replace in StrBuilder
        bld = new StrBuilder(replaceTemplate);
        assertTrue(sub.replaceIn(bld));
        assertEquals(expectedResult, bld.toString());
        if (substring) {
            bld = new StrBuilder(replaceTemplate);
            assertTrue(sub.replaceIn(bld, 1, bld.length() - 2));
            assertEquals(expectedResult, bld.toString());  // expect full result as remainder is untouched
        }
    }

    private void doTestNoReplace(final String replaceTemplate) {
        final StrSubstitutor sub = new StrSubstitutor(values);

        if (replaceTemplate == null) {
            assertEquals(null, sub.replace((String) null));
            assertEquals(null, sub.replace((String) null, 0, 100));
            assertEquals(null, sub.replace((char[]) null));
            assertEquals(null, sub.replace((char[]) null, 0, 100));
            assertEquals(null, sub.replace((StringBuffer) null));
            assertEquals(null, sub.replace((StringBuffer) null, 0, 100));
            assertEquals(null, sub.replace((StrBuilder) null));
            assertEquals(null, sub.replace((StrBuilder) null, 0, 100));
            assertEquals(null, sub.replace((Object) null));
            assertFalse(sub.replaceIn((StringBuffer) null));
            assertFalse(sub.replaceIn((StringBuffer) null, 0, 100));
            assertFalse(sub.replaceIn((StrBuilder) null));
            assertFalse(sub.replaceIn((StrBuilder) null, 0, 100));
        } else {
            assertEquals(replaceTemplate, sub.replace(replaceTemplate));
            final StrBuilder bld = new StrBuilder(replaceTemplate);
            assertFalse(sub.replaceIn(bld));
            assertEquals(replaceTemplate, bld.toString());
        }
    }

}
