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
public void testAppendln_StringBuilder250() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StringBuilder_int_int251() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StringBuilder str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StringBuilder("foo"), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_Object253() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final Object obj) { 
             count[0]++; 
             return super.append(obj); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo"); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_StrBuilder254() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final StrBuilder str) { 
             count[0]++; 
             return super.append(str); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln(new StrBuilder("foo")); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_CharArray_int_int255() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final char[] str, final int startIndex, final int length) { 
             count[0]++; 
             return super.append(str, startIndex, length); 
         } 
  
         @Override 
         public StrBuilder appendNewLine() { 
             count[1]++; 
             return super.appendNewLine(); 
         } 
     }; 
     sb.appendln("foo".toCharArray(), 0, 3); 
     assertEquals("foo" + SEP, sb.toString()); 
     assertEquals(1, count[0]); 
     assertEquals(1, count[1]); 
 }
@Test
public void testAppendln_PrimitiveNumber256() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendln(0); 
     assertEquals("0", sb.toString()); 
     sb.appendln(1L); 
     assertEquals("01", sb.toString()); 
     sb.appendln(2.3f); 
     assertEquals("012.3", sb.toString()); 
     sb.appendln(4.5d); 
     assertEquals("012.34.5", sb.toString()); 
 }
@Test
public void testAppendSeparator_char_int261() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(' ', 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(' ', 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(' ', -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testAppendSeparator_char_int262() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendSeparator(',', 0); 
     assertEquals("", sb.toString()); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.appendSeparator(',', 1); 
     assertEquals("foo,", sb.toString()); 
     sb.appendSeparator(',', -1); 
     assertEquals("foo,", sb.toString()); 
 }
@Test
public void testLang299263() { 
     final StrBuilder sb = new StrBuilder(1); 
     sb.appendFixedWidthPadLeft("foo", 1, '-'); 
     assertEquals("f", sb.toString()); 
 }
@Test
public void testLang412Left264() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadLeft(null, 10, '*'); 
     assertEquals("Failed to invoke appendFixedWidthPadLeft correctly", "**********", sb.toString()); 
 }
@Test
public void testAppendFixedWidthPadLeft_int265() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendFixedWidthPadLeft(123, -1, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 0, '-'); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 1, '-'); 
     assertEquals("1", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 2, '-'); 
     assertEquals("12", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 3, '-'); 
     assertEquals("123", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 4, '-'); 
     assertEquals("123-", sb.toString()); 
     sb.clear(); 
     sb.appendFixedWidthPadLeft(123, 10, '-'); 
     assertEquals(10, sb.length()); 
     assertEquals("123-------", sb.toString()); 
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
