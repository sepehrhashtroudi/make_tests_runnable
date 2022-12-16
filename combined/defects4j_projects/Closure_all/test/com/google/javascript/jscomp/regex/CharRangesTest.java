/*
 * Copyright 2011 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.javascript.jscomp.regex;

import java.util.BitSet;
import java.util.Random;

import com.google.javascript.jscomp.regex.CharRanges;

import junit.framework.TestCase;

public class CharRangesTest extends TestCase {

  static final long SEED = Long.parseLong(System.getProperty(
      "junit.random.seed", "" + System.currentTimeMillis()));


public final void testUnion25() { 
     CharRanges a = CharRanges.withRanges(new int[] { 0x03, 0x0C, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1C, 0x1D, 0x1E, 0x21, 0x24, 0x27, 0x28, 0x29, 0x2A, 0x2B }); 
     CharRanges b = CharRanges.withRanges(new int[] { 0x01, 0x04, 0x06, 0x09, 0x0B, 0x0E, 0x0F, 0x12, 0x1A, 0x1B, 0x1C, 0x1D, 0x21, 0x24 }); 
     CharRanges empty = CharRanges.withMembers(new int[0]); 
     assertEquals(empty, empty.union(empty)); 
     assertEquals(a, a.union(empty)); 
     assertEquals(b, empty.union(b)); 
     CharRanges aSb = a.union(b); 
     assertEquals("[0x4-0x5 0x9-0xa 0x12 0x14 0x16 0x18 0x1e-0x20 0x24-0x26 0x28 0x2a]", aSb.toString()); 
     assertTrue(a.containsAll(aSb)); 
     assertFalse(aSb.containsAll(a)); 
     assertFalse(aSb.containsAll(b)); 
     CharRanges bSa = b.union(a); 
     assertEquals("[0x1-0x2 0xc-0xd 0xf-0x11 0x1a 0x21-0x23]", bSa.toString()); 
     assertTrue(b.containsAll(bSa)); 
     assertFalse(bSa.containsAll(a)); 
     assertFalse(bSa.containsAll(b)); 
     assertEquals("[0x3


public final void testDupeMembers199() { 
     CharRanges sbs1 = CharRanges.withMembers(new int[] { 0, 1, 4, 9 }); 
     assertEquals(sbs1.toString(), "[0x0-0x1 0x4 0x9]", sbs1.toString()); 
     CharRanges sbs2 = CharRanges.withMembers(new int[] { 9, 1, 4, 1, 0 }); 
     assertEquals(sbs2.toString(), "[0x0-0x1 0x4 0x9]", sbs2.toString()); 
     assertEquals(sbs1, sbs2); 
     assertEquals(sbs1.hashCode(), sbs2.hashCode()); 
     for (int i = -10; i < 20; ++i) { 
         assertEquals("" + i, sbs1.contains(i), sbs2.contains(i)); 
     } 
 }

  

  

  

  

  

  

  
}
