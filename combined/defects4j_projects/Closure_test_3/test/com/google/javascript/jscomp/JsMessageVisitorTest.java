/*
 * Copyright 2008 The Closure Compiler Authors.
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

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import static com.google.javascript.jscomp.JsMessage.Style;
import static com.google.javascript.jscomp.JsMessage.Style.CLOSURE;
import static com.google.javascript.jscomp.JsMessage.Style.LEGACY;
import static com.google.javascript.jscomp.JsMessage.Style.RELAX;
import static com.google.javascript.jscomp.JsMessageVisitor.isLowerCamelCaseWithNumericSuffixes;
import static com.google.javascript.jscomp.JsMessageVisitor.toLowerCamelCaseWithNumericSuffixes;
import com.google.javascript.rhino.Node;

import junit.framework.TestCase;

import java.util.List;

/**
 * Test for {@link JsMessageVisitor}.
 *
 * @author anatol@google.com (Anatol Pomazau)
 */
public class JsMessageVisitorTest extends TestCase {

  private Compiler compiler;
  private List<JsMessage> messages;
  private boolean allowLegacyMessages;

  @Override
  protected void setUp() throws Exception {
    messages = Lists.newLinkedList();
    allowLegacyMessages = true;
  }

public void testLegacyFormatParametizedFunction337() { 
     extractMessagesSafely("var MSG_SILLY = function(one, two) {" + "  return one + ', ' + two + ', buckle my shoe';" + "};"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_SILLY", msg.getKey()); 
     assertEquals(null, msg.getDesc()); 
     assertEquals("{$one}, {$two}, buckle my shoe", msg.toString()); 
 }
public void testExternalMessage338() { 
     extractMessagesSafely("var MSG_EXTERNAL_111 = goog.getMsg('Hello World');"); 
     assertEquals(0, compiler.getWarningCount()); 
     assertEquals(1, messages.size()); 
     assertTrue(messages.get(0).isExternal()); 
     assertEquals("111", messages.get(0).getId()); 
 }
public void testHugeMessage339() { 
     extractMessagesSafely("/**" + " * @desc A message with lots of stuff.\n" + " * @hidden\n" + " */" + "var MSG_HUGE = goog.getMsg(" + "    '{$startLink_1}Google{$endLink}' +" + "    '{$startLink_2}blah{$endLink}{$boo}{$foo_001}{$boo}' +" + "    '{$foo_002}{$xxx_001}{$image}{$image_001}{$xxx_002}'," + "    {'startLink_1': '<a href=http://www.google.com/>'," + "     'endLink': '</a>'," + "     'startLink_2': '<a href=\"' + opt_data.url + '\">'," + "     'boo': opt_data.boo," + "     'foo_001': opt_data.foo," + "     'foo_002': opt_data.boo.foo," + "     'xxx_001': opt_data.boo + opt_data.foo," + "     'image': htmlTag7," + "     'image_001': opt_data.image," + "     'xxx_002': foo.callWithOnlyTopLevelKeys(" + "         bogusFn, opt_data, null, 'bogusKey1'," + "         opt_data.moo, 'bogusKey2', param10)});"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_HUGE", msg.getKey()); 
     assertEquals("A message with lots of stuff.", msg.getDesc()); 
     assertTrue(msg.isHidden()); 
     assertEquals("{$startLink_1}Google{$endLink}{$startLink_2}blah{$endLink}" + "{$boo}{$foo_001}{$boo}{$foo_002}{$xxx_001}{$image}" + "{$image_001}{$xxx_002}", msg.toString()); 
 }
public void testUnusedReferenesAreNotOK340() { 
     extractMessages("/** @desc AA */ " + "var MSG_FOO = goog.getMsg('lalala:', {foo:1});"); 
     assertEquals(0, messages.size()); 
     JSError[] errors = compiler.getErrors(); 
     assertEquals(1, errors.length); 
     JSError error = errors[0]; 
     assertEquals(JsMessageVisitor.MESSAGE_TREE_MALFORMED, error.getType()); 
     assertEquals("Message parse tree malformed. Unused message placeholder: " + "foo", error.description); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void theseAreLegacyMessageNames(JsMessageVisitor visitor) {
    assertTrue(visitor.isMessageName("MSG_HELLO", false));
    assertTrue(visitor.isMessageName("MSG_", false));

    assertFalse(visitor.isMessageName("MSG_HELP", false));
    assertFalse(visitor.isMessageName("MSG_FOO_HELP", false));
    assertFalse(visitor.isMessageName("_FOO_HELP", false));
    assertFalse(visitor.isMessageName("MSGFOOP", false));
  }

  

  

  

  

  

  

  

  

  

  

  

  

  private void assertOneError(DiagnosticType type) {
    String errors = Joiner.on("\n").join(compiler.getErrors());
    assertEquals("There should be one error. " + errors,
        1, compiler.getErrorCount());
    JSError error = compiler.getErrors()[0];
    assertEquals(type, error.getType());
  }

  private void extractMessagesSafely(String input) {
    extractMessages(input);
    JSError[] errors = compiler.getErrors();
    assertEquals(
        "Unexpected error(s): " + Joiner.on("\n").join(compiler.getErrors()),
        0, compiler.getErrorCount());
  }

  private void extractMessages(String input) {
    compiler = new Compiler();
    Node root = compiler.parseTestCode(input);
    JsMessageVisitor visitor = new CollectMessages(compiler);
    visitor.process(null, root);
  }

  private class CollectMessages extends JsMessageVisitor {

    private CollectMessages(Compiler compiler) {
      super(compiler, true, Style.getFromParams(true, allowLegacyMessages),
            null);
    }

    @Override
    protected void processJsMessage(JsMessage message,
        JsMessageDefinition definition) {
      messages.add(message);
    }
  }

  private class DummyJsVisitor extends JsMessageVisitor {

    private DummyJsVisitor(Style style) {
      super(null, true, style, null);
    }

    @Override
    protected void processJsMessage(JsMessage message,
        JsMessageDefinition definition) {
      // no-op
    }
  }
}
