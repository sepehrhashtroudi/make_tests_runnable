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

package org.apache.commons.lang3.text.translate;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for {@link org.apache.commons.lang3.text.translate.OctalUnescaper}.
 * @version $Id: OctalUnescaperTest.java 979392 2010-07-26 18:09:52Z mbenson $
 */
public class OctalUnescaperTest {

@Test
public void testEscapeSurrogatePairsLang8589674() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812416() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812417() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812418() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812419() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812420() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812421() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812422() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812423() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812424() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812425() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
@Test
public void testEscapeSurrogatePairsLang85812426() throws Exception { 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeJava("\uDBFF\uDFFD"));       //fail LANG-858 
         assertEquals("\\uDBFF\\uDFFD", StringEscapeUtils.escapeEcmaScript("\uDBFF\uDFFD")); //fail LANG-858 
     }
    

}
