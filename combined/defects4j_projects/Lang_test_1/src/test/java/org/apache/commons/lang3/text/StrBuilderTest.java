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

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.StrBuilder}.
 * 
 * @version $Id$
 */
public class StrBuilderTest {

    //-----------------------------------------------------------------------
@Test
public void testCharAt260() { 
     final StrBuilder sb = new StrBuilder(); 
     try { 
         sb.charAt(0); 
         fail("charAt(0) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(-1); 
         fail("charAt(-1) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.charAt(15); 
         fail("charAt(15) expected IndexOutOfBoundsException"); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testAsWriter261() throws Exception { 
     final StrBuilder sb = new StrBuilder("base"); 
     final Writer writer = sb.asWriter(); 
     writer.write('l'); 
     assertEquals("basel", sb.toString()); 
     writer.write(new char[] { 'i', 'n' }); 
     assertEquals("baselin", sb.toString()); 
     writer.write(new char[] { 'n', 'e', 'r' }, 1, 2); 
     assertEquals("baseliner", sb.toString()); 
     writer.write(" rout"); 
     assertEquals("baseliner rout", sb.toString()); 
     writer.write("ping that server", 1, 3); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.flush(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.close(); 
     assertEquals("baseliner routing", sb.toString()); 
     writer.write(" hi"); 
     assertEquals("baseliner routing hi", sb.toString()); 
     sb.setLength(4); 
     writer.write('d'); 
     assertEquals("based", sb.toString()); 
 }
@Test
public void testAppendAll_object272() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Object[]) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(new Object[0]); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(new Object[] { "foo", "bar", "baz" }); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendAll(new Object[] { "foo", "bar", "baz" }); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendAll_Object273() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Object[]) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(new Object[0]); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(new Object[] { "foo", "bar", "baz" }); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendAll(new Object[] { "foo", "bar", "baz" }); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testDeleteFirst_StrMatcher278() { 
     StrBuilder sb = new StrBuilder("A0xA1A2yA3"); 
     sb.deleteFirst((StrMatcher) null); 
     assertEquals("A0xA1A2yA3", sb.toString()); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("xy", sb.toString()); 
     sb = new StrBuilder("Ax1"); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("Ax1", sb.toString()); 
     sb = new StrBuilder(""); 
     sb.deleteFirst(A_NUMBER_MATCHER); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testSubstringIntInt279() { 
     final StrBuilder sb = new StrBuilder("hello goodbye"); 
     assertEquals("goodbye", sb.substring(6, 7)); 
     assertEquals("hello goodbye".substring(6, 7), sb.substring(6, 7)); 
     assertEquals("hello goodbye".substring(0, 5), sb.substring(0, 5)); 
     assertEquals("hello goodbye".substring(0, 6), sb.substring(0, 6)); 
     try { 
         sb.substring(-1, 5); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
     try { 
         sb.substring(15, 2); 
         fail(); 
     } catch (final IndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testReplaceFirst_char_char281() { 
     final StrBuilder sb = new StrBuilder("abcbccba"); 
     sb.replaceFirst('x', 'y'); 
     assertEquals("abcbccba", sb.toString()); 
     sb.replaceFirst('a', 'd'); 
     assertEquals("dbcbccba", sb.toString()); 
     sb.replaceFirst('b', 'e'); 
     assertEquals("decbccba", sb.toString()); 
     sb.replaceFirst('c', 'f'); 
     assertEquals("defbccba", sb.toString()); 
     sb.replaceFirst('d', 'd'); 
     assertEquals("defbccba", sb.toString()); 
 }
@Test
public void testAsTokenizer284() throws Exception { 
     final StrBuilder b = new StrBuilder(); 
     b.append("a b "); 
     final StrTokenizer t = b.asTokenizer(); 
     final String[] tokens1 = t.getTokenArray(); 
     assertEquals(2, tokens1.length); 
     assertEquals("a", tokens1[0]); 
     assertEquals("b", tokens1[1]); 
     assertEquals(2, t.size()); 
     b.append("c d "); 
     final String[] tokens2 = t.getTokenArray(); 
     assertEquals(2, tokens2.length); 
     assertEquals("a", tokens2[0]); 
     assertEquals("b", tokens2[1]); 
     assertEquals(2, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     t.reset(); 
     final String[] tokens3 = t.getTokenArray(); 
     assertEquals(4, tokens3.length); 
     assertEquals("a", tokens3[0]); 
     assertEquals("b", tokens3[1]); 
     assertEquals("c", tokens3[2]); 
     assertEquals("d", tokens3[3]); 
     assertEquals(4, t.size()); 
     assertEquals("a", t.next()); 
     assertEquals("b", t.next()); 
     assertEquals("c", t.next()); 
     assertEquals("d", t.next()); 
     assertEquals("a b c d ", t.getContent()); 
 }
@Test
public void testTrim290() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals("", sb.reverse().toString()); 
     sb.clear().append(" \u0000 "); 
     assertEquals("", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append(" \u0000 a b c \u0000 "); 
     assertEquals("a b c", sb.trim().toString()); 
     sb.clear().append("a b c"); 
     assertEquals("a b c", sb.trim().toString()); 
 }
@Test
public void testCapacityAndLength291() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(32, sb.capacity()); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.minimizeCapacity(); 
     assertEquals(0, sb.capacity()); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.ensureCapacity(32); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.append("foo"); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(3, sb.length()); 
     assertEquals(3, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.clear(); 
     assertTrue(sb.capacity() >= 32); 
     assertEquals(0, sb.length()); 
     assertEquals(0, sb.size()); 
     assertTrue(sb.isEmpty()); 
     sb.append("123456789012345678901234567890123"); 
     assertTrue(sb.capacity() > 32); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.ensureCapacity(16); 
     assertTrue(sb.capacity() > 16); 
     assertEquals(33, sb.length()); 
     assertEquals(33, sb.size()); 
     assertTrue(sb.isEmpty() == false); 
     sb.minimizeCapacity(); 
     assertEquals(33, sb.capacity()); 
     assertEquals(33, sb.length());
}

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    // -----------------------------------------------------------------------
    

    

    // -----------------------------------------------------------------------
    

    

    // -----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    
    
    

    // -----------------------------------------------------------------------
    

    

    

    // -----------------------------------------------------------------------
    

    

    

    // -----------------------------------------------------------------------
    

    

    

    

    // -----------------------------------------------------------------------
    

    

    

    

    // -----------------------------------------------------------------------
    

    

    

    

    static final StrMatcher A_NUMBER_MATCHER = new StrMatcher() {
        @Override
        public int isMatch(final char[] buffer, int pos, final int bufferStart, final int bufferEnd) {
            if (buffer[pos] == 'A') {
                pos++;
                if (pos < bufferEnd && buffer[pos] >= '0' && buffer[pos] <= '9') {
                    return 2;
                }
            }
            return 0;
        }
    };

    //-----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

}
