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
public void testAppend_String278() { 
     StrBuilder sb = new StrBuilder(); 
     sb.setNullText("NULL").append((String) null); 
     assertEquals("NULL", sb.toString()); 
     sb = new StrBuilder(); 
     sb.append("foo"); 
     assertEquals("foo", sb.toString()); 
     sb.append(""); 
     assertEquals("foo", sb.toString()); 
     sb.append("bar"); 
     assertEquals("foobar", sb.toString()); 
 }
@Test
public void testAppendln_String281() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str) { 
             count[0]++; 
             return super.append(str); 
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
public void testAppendln_StrBuilder282() { 
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
public void testAppendln_String287() { 
     final int[] count = new int[2]; 
     final StrBuilder sb = new StrBuilder() { 
  
         @Override 
         public StrBuilder append(final String str) { 
             count[0]++; 
             return super.append(str); 
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
public void testAppendAll_Collection288() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendAll((Collection<?>) null); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Collections.EMPTY_LIST); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendAll(Arrays.asList(new Object[] { "foo", "bar", "baz" })); 
     assertEquals("foobarbaz", sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Iterator289() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Iterator<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendWithSeparators_Collection290() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendWithSeparators((Collection<?>) null, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Collections.EMPTY_LIST, ","); 
     assertEquals("", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }), ","); 
     assertEquals("foo,bar,baz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", "bar", "baz" }), null); 
     assertEquals("foobarbaz", sb.toString()); 
     sb.clear(); 
     sb.appendWithSeparators(Arrays.asList(new Object[] { "foo", null, "baz" }), ","); 
     assertEquals("foo,,baz", sb.toString()); 
 }
@Test
public void testAppendSeparator_String_String291() { 
     final StrBuilder sb = new StrBuilder(); 
     final String startSeparator = ":"; 
     final String standardSeparator = ","; 
     final String foo = "foo"; 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator), sb.toString()); 
     sb.append(foo); 
     assertEquals(String.valueOf(startSeparator) + foo, sb.toString()); 
     sb.appendSeparator(standardSeparator, startSeparator); 
     assertEquals(String.valueOf(startSeparator) + foo + standardSeparator, sb.toString()); 
 }
@Test
public void testAppendPadding_int_char292() { 
     final StrBuilder sb = new StrBuilder(); 
     sb.appendPadding(1, '-'); 
     assertEquals("", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("", sb.toString()); 
     sb.appendPadding(0, '-'); 
     assertEquals("", sb.toString()); 
     sb.appendPadding(1, '-'); 
     assertEquals("", sb.toString()); 
     sb.appendPadding(2, '-'); 
     assertEquals("", sb.toString()); 
     sb.appendPadding(3, '-'); 
     assertEquals("foo", sb.toString()); 
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
