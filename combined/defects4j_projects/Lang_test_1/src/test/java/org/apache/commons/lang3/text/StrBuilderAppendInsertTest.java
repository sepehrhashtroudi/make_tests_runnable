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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.lang3.SystemUtils;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.StrBuilder}.
 *
 * @version $Id$
 */
public class StrBuilderAppendInsertTest {

    /** The system line separator. */
    private static final String SEP = SystemUtils.LINE_SEPARATOR;

    /** Test subclass of Object, with a toString method. */
    private static final Object FOO = new Object() {
        @Override
        public String toString() {
            return "foo";
        }
    };

    //-----------------------------------------------------------------------
@Test
public void testGetSetNullText259() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(null, sb.getNullText()); 
     sb.setNullText("null"); 
     assertEquals("null", sb.getNullText()); 
     sb.setNullText(""); 
     assertEquals(null, sb.getNullText()); 
     sb.setNullText("NULL"); 
     assertEquals("NULL", sb.getNullText()); 
     sb.setNullText((String) null); 
     assertEquals(null, sb.getNullText()); 
 }
@Test
public void testAppendWithSeparators_Iterator263() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST.iterator(), ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }).iterator(), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }).iterator(), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppend_Object264() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendNull(); 
     assertEquals("", sb.toString()); 
     sb.append((Object) null); 
     assertEquals("", sb.toString()); 
     sb.append(FOO); 
     assertEquals("foo", sb.toString()); 
     sb.append((StringBuffer) null); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("baz")); 
     assertEquals("foobaz", sb.toString()); 
     sb.append(new StrBuilder("yes")); 
     assertEquals("foobazyes", sb.toString()); 
     sb.append((CharSequence) "Seq"); 
     assertEquals("foobazyesSeq", sb.toString()); 
     sb.append(new StringBuilder("bld")); 
     assertEquals("foobazyesSeqbld", sb.toString()); 
 }
@Test
public void testCapacity265() { 
     final StrBuilder sb = new StrBuilder(); 
     assertEquals(sb.buffer.length, sb.capacity()); 
     sb.append("HelloWorldHelloWorldHelloWorldHelloWorld"); 
     assertEquals(sb.buffer.length, sb.capacity()); 
 }
@Test
public void testAppendln_String_int_int266() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo", 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppend_StringBuffer268() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((StringBuffer) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append(new StringBuffer("foo")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StrBuilder("")); 
     assertEquals("foo", sb.toString()); 
     sb.append(new StringBuffer("baz")); 
     assertEquals("foobaz", sb.toString()); 
     sb.append(new StrBuilder("yes")); 
     assertEquals("foobazyes", sb.toString()); 
     sb.append((CharSequence) "Seq"); 
     assertEquals("foobazyesSeq", sb.toString()); 
     sb.append(new StringBuilder("bld")); 
     assertEquals("foobazyesSeqbld", sb.toString()); 
 }
@Test
public void testAppend_PrimitiveNumber269() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.append(0); 
     assertEquals("0" + SEP, sb.toString()); 
     sb.clear(); 
     sb.append(1L); 
     assertEquals("1" + SEP, sb.toString()); 
     sb.clear(); 
     sb.append(2.3f); 
     assertEquals("2.3" + SEP, sb.toString()); 
     sb.clear(); 
     sb.append(4.5d); 
     assertEquals("4.5" + SEP, sb.toString()); 
 }
@Test
public void testAppendln_StringBuffer270() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuffer str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuffer("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StrBuilder_int_int271() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendSeparator_String274() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(","); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(","); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator((String) null); 
     assertEquals("", sb.toString()); 
 }
@Test
public void testAppendSeparator_char275() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator('.'); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator('.'); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testLang299276() { 
     final StrBuilder sb = new StrBuilder(1); 
     sb.appendFixedWidthPadRight("foo", 1, '-'); 
     assertEquals("f", sb.toString()); 
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
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    // See: http://issues.apache.org/jira/browse/LANG-299
    

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
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    
}
