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
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Random;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.RandomStringUtils}.
 *
 * @version $Id$
 */
public class RandomStringUtilsTest {

    //-----------------------------------------------------------------------
@Test
public void testLang100139() throws Exception { 
     final int size = 5000; 
     final String encoding = "UTF-8"; 
     final String orig = RandomStringUtils.randomAscii(size); 
     final byte[] bytes = orig.getBytes(encoding); 
     final String copy = new String(bytes, encoding); 
     for (int i = 0; i < orig.length() && i < copy.length(); i++) { 
         final char o = orig.charAt(i); 
         final char c = copy.charAt(i); 
         assertEquals("differs at " + i + "(" + Integer.toHexString(new Character(o).hashCode()) + "," + Integer.toHexString(new Character(c).hashCode()) + ")", o, c); 
     } 
     assertEquals(orig.length(), copy.length()); 
     assertEquals(orig, copy); 
 }
@Test
public void testLang100140() throws Exception { 
     final int size = 5000; 
     final String encoding = "UTF-8"; 
     final String orig = RandomStringUtils.randomAlphabetic(size); 
     final byte[] bytes = orig.getBytes(encoding); 
     final String copy = new String(bytes, encoding); 
     for (int i = 0; i < orig.length() && i < copy.length(); i++) { 
         final char o = orig.charAt(i); 
         final char c = copy.charAt(i); 
         assertEquals("differs at " + i + "(" + Integer.toHexString(new Character(o).hashCode()) + "," + Integer.toHexString(new Character(c).hashCode()) + ")", o, c); 
     } 
     assertEquals(orig.length(), copy.length()); 
     assertEquals(orig, copy); 
 }
@Test
public void testLang100141() throws Exception { 
     final int size = 5000; 
     final String encoding = "UTF-8"; 
     final String orig = RandomStringUtils.randomAlphanumeric(size); 
     final byte[] bytes = orig.getBytes(encoding); 
     final String copy = new String(bytes, encoding); 
     for (int i = 0; i < orig.length() && i < copy.length(); i++) { 
         final char o = orig.charAt(i); 
         final char c = copy.charAt(i); 
         assertEquals("differs at " + i + "(" + Integer.toHexString(new Character(o).hashCode()) + "," + Integer.toHexString(new Character(c).hashCode()) + ")", o, c); 
     } 
     assertEquals(orig.length(), copy.length()); 
     assertEquals(orig, copy); 
 }
@Test
public void testLang100142() throws Exception { 
     final int size = 5000; 
     final String encoding = "UTF-8"; 
     final String orig = RandomStringUtils.randomNumeric(size); 
     final byte[] bytes = orig.getBytes(encoding); 
     final String copy = new String(bytes, encoding); 
     for (int i = 0; i < orig.length() && i < copy.length(); i++) { 
         final char o = orig.charAt(i); 
         final char c = copy.charAt(i); 
         assertEquals("differs at " + i + "(" + Integer.toHexString(new Character(o).hashCode()) + "," + Integer.toHexString(new Character(c).hashCode()) + ")", o, c); 
     } 
     assertEquals(orig.length(), copy.length()); 
     assertEquals(orig, copy); 
 }
@Test
public void testLang100143() throws Exception { 
     final int size = 5000; 
     final String encoding = "UTF-8"; 
     final String orig = RandomStringUtils.random(size); 
     final byte[] bytes = orig.getBytes(encoding); 
     final String copy = new String(bytes, encoding); 
     for (int i = 0; i < orig.length() && i < copy.length(); i++) { 
         final char o = orig.charAt(i); 
         final char c = copy.charAt(i); 
         assertEquals("differs at " + i + "(" + Integer.toHexString(new Character(o).hashCode()) + "," + Integer.toHexString(new Character(c).hashCode()) + ")", o, c); 
     } 
     assertEquals(orig.length(), copy.length()); 
     assertEquals(orig, copy); 
 }
@Test
public void testExceptions144() { 
     final char[] DUMMY = new char[] { 'a' }; 
     try { 
         RandomStringUtils.random(-1); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, true, true); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(1, new char[0]); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, ""); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, (String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         RandomStringUtils.random(-1, 'a', 'z', false, false, DUMMY); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
    
    
    //-----------------------------------------------------------------------
    /**
     * Test the implementation
     */
    

    

    

    
    
    /**
     * Make sure boundary alphanumeric characters are generated by randomAlphaNumeric
     * This test will fail randomly with probability = 6 * (61/62)**1000 ~ 5.2E-7
     */  
    
// Defects4J: flaky method
//     @Test
//     public void testRandomAlphaNumeric() {
//         final char[] testChars = {'a', 'z', 'A', 'Z', '0', '9'};
//         final boolean[] found = {false, false, false, false, false, false};
//         for (int i = 0; i < 100; i++) {
//             final String randString = RandomStringUtils.randomAlphanumeric(10);
//             for (int j = 0; j < testChars.length; j++) {
//                 if (randString.indexOf(testChars[j]) > 0) {
//                     found[j] = true;
//                 }
//             }
//         }
//         for (int i = 0; i < testChars.length; i++) {
//             if (!found[i]) {
//                 fail("alphanumeric character not generated in 1000 attempts: " 
//                    + testChars[i] +" -- repeated failures indicate a problem ");
//             }
//         }
//     }
    
    /**
     * Make sure '0' and '9' are generated by randomNumeric
     * This test will fail randomly with probability = 2 * (9/10)**1000 ~ 3.5E-46
     */  
    
// Defects4J: flaky method
//     @Test
//     public void testRandomNumeric() {
//         final char[] testChars = {'0','9'};
//         final boolean[] found = {false, false};
//         for (int i = 0; i < 100; i++) {
//             final String randString = RandomStringUtils.randomNumeric(10);
//             for (int j = 0; j < testChars.length; j++) {
//                 if (randString.indexOf(testChars[j]) > 0) {
//                     found[j] = true;
//                 }
//             }
//         }
//         for (int i = 0; i < testChars.length; i++) {
//             if (!found[i]) {
//                 fail("digit not generated in 1000 attempts: " 
//                    + testChars[i] +" -- repeated failures indicate a problem ");
//             }
//         }  
//     }
    
    /**
     * Make sure boundary alpha characters are generated by randomAlphabetic
     * This test will fail randomly with probability = 4 * (51/52)**1000 ~ 1.58E-8
     */  
    
// Defects4J: flaky method
//     @Test
//     public void testRandomAlphabetic() {
//         final char[] testChars = {'a', 'z', 'A', 'Z'};
//         final boolean[] found = {false, false, false, false};
//         for (int i = 0; i < 100; i++) {
//             final String randString = RandomStringUtils.randomAlphabetic(10);
//             for (int j = 0; j < testChars.length; j++) {
//                 if (randString.indexOf(testChars[j]) > 0) {
//                     found[j] = true;
//                 }
//             }
//         }
//         for (int i = 0; i < testChars.length; i++) {
//             if (!found[i]) {
//                 fail("alphanumeric character not generated in 1000 attempts: " 
//                    + testChars[i] +" -- repeated failures indicate a problem ");
//             }
//         }
//     }
    
    /**
     * Make sure 32 and 127 are generated by randomNumeric
     * This test will fail randomly with probability = 2*(95/96)**1000 ~ 5.7E-5
     */  
    
// Defects4J: flaky method
//     @Test
//     public void testRandomAscii() {
//         final char[] testChars = {(char) 32, (char) 126};
//         final boolean[] found = {false, false};
//         for (int i = 0; i < 100; i++) {
//             final String randString = RandomStringUtils.randomAscii(10);
//             for (int j = 0; j < testChars.length; j++) {
//                 if (randString.indexOf(testChars[j]) > 0) {
//                     found[j] = true;
//                 }
//             }
//         }
//         for (int i = 0; i < testChars.length; i++) {
//             if (!found[i]) {
//                 fail("ascii character not generated in 1000 attempts: " 
//                 + (int) testChars[i] + 
//                  " -- repeated failures indicate a problem");
//             }
//         }  
//     }
    
    /** 
     * Test homogeneity of random strings generated --
     * i.e., test that characters show up with expected frequencies
     * in generated strings.  Will fail randomly about 1 in 1000 times.
     * Repeated failures indicate a problem.
     */
    
// Defects4J: flaky method
//     @Test
//     public void testRandomStringUtilsHomog() {
//         final String set = "abc";
//         final char[] chars = set.toCharArray();
//         String gen = "";
//         final int[] counts = {0,0,0};
//         final int[] expected = {200,200,200};
//         for (int i = 0; i< 100; i++) {
//            gen = RandomStringUtils.random(6,chars);
//            for (int j = 0; j < 6; j++) {
//                switch (gen.charAt(j)) {
//                    case 'a': {counts[0]++; break;}
//                    case 'b': {counts[1]++; break;}
//                    case 'c': {counts[2]++; break;}
//                    default: {fail("generated character not in set");}
//                }
//            }
//         } 
//         // Perform chi-square test with df = 3-1 = 2, testing at .001 level
//         assertTrue("test homogeneity -- will fail about 1 in 1000 times",
//             chiSquare(expected,counts) < 13.82);  
//     }
    
    /**
     * Computes Chi-Square statistic given observed and expected counts
     * @param observed array of observed frequency counts
     * @param expected array of expected frequency counts
     */
    private double chiSquare(final int[] expected, final int[] observed) {
        double sumSq = 0.0d;
        double dev = 0.0d;
        for (int i = 0; i < observed.length; i++) {
            dev = observed[i] - expected[i];
            sumSq += dev * dev / expected[i];
        }
        return sumSq;
    }           

    /**
     * Checks if the string got by {@link RandomStringUtils#random(int)}
     * can be converted to UTF-8 and back without loss.
     *
     * @see <a href="http://issues.apache.org/jira/browse/LANG-100">LANG-100</a>
     *
     * @throws Exception
     */
    
}

