/*
 * Copyright 2004 The Closure Compiler Authors.
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

package com.google.javascript.jscomp;

import static com.google.javascript.jscomp.JsMessage.Style.RELAX;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Unit test for {@link JsMessageExtractor}.
 *
 */
public class JsMessageExtractorTest extends TestCase {

  private Collection<JsMessage> extractMessages(String... js) {
    try {
      String sourceCode = Joiner.on("\n").join(js);
      return new JsMessageExtractor(null, RELAX)
          .extractMessages(SourceFile.fromCode("testcode", sourceCode));
    } catch (IOException e) {
      fail(e.getMessage());
      return null;
    }
  }

  private JsMessage extractMessage(String... js) {
    Collection<JsMessage> messages = extractMessages(js);
    assertEquals(1, messages.size());
    return messages.iterator().next();
  }

public void testIsEmpty409() { 
     assertTrue(new JsMessage.Builder().build().isEmpty()); 
     assertTrue(new JsMessage.Builder().appendStringPart("").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendStringPart("s").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("3").build().isEmpty()); 
 }
public void testHashValues417() { 
     final String EMPTY = ""; 
     final String VAL = "Hello, world"; 
     final long ANSWER_STRING_64 = 0x43ec5d9731515874L; 
     final long ANSWER_EMPTY_64 = 0x468d9ea2c42361aaL; 
     assertEquals(ANSWER_STRING_64, JsMessage.Hash.hash64(VAL)); 
     assertEquals(ANSWER_EMPTY_64, JsMessage.Hash.hash64(EMPTY)); 
 }
  

  

  

  

  

  

  

  

  

  

  private void assertEquals(JsMessage expected, JsMessage actual) {
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getKey(), actual.getKey());
    assertEquals(expected.parts(), actual.parts());
    assertEquals(expected.placeholders(), actual.placeholders());
    assertEquals(expected.getDesc(), actual.getDesc());
    assertEquals(expected.isHidden(), actual.isHidden());
    assertEquals(expected.getMeaning(), actual.getMeaning());
  }
}
