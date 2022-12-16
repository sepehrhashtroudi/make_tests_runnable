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
