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


public void testHugeMessage42() { 
     extractMessagesSafely("/**" + " * @desc A message with lots of stuff.\n" + " * @hidden\n" + " */" + "var MSG_HUGE = goog.getMsg(" + "    '{$startLink_1}Google{$endLink}' +" + "    '{$startLink_2}blah{$endLink}{$boo}{$foo_001}{$boo}' +" + "    '{$foo_002}{$xxx_001}{$image}{$image_001}{$xxx_002}'," + "    {'startLink_1': '<a href=http://www.google.com/>'," + "     'endLink': '</a>'," + "     'startLink_2': '<a href=\"' + opt_data.url + '\">'," + "     'boo': opt_data.boo," + "     'foo_001': opt_data.foo," + "     'foo_002': opt_data.boo.foo," + "     'xxx_001': opt_data.boo + opt_data.foo," + "     'image': htmlTag7," + "     'image_001': opt_data.image," + "     'xxx_002': foo.callWithOnlyTopLevelKeys(" + "         bogusFn, opt_data, null, 'bogusKey1'," + "         opt_data.moo, 'bogusKey2', param10)});"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_HUGE", msg.getKey()); 
     assertEquals("A message with lots of stuff.", msg.getDesc()); 
     assertTrue(msg.isHidden()); 
     assertEquals("{$startLink_1}Google{$endLink}{$startLink_2}blah{$endLink}" + "{$boo}{$foo_001}{$boo}{$foo_002}{$xxx_001}{$image}" + "{$image_001}{$xxx_002}", msg.toString()); 
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
