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

public void testLegacyFormatParametizedFunction210() { 
     extractMessagesSafely("var MSG_SILLY = function(one, two) {" + "  return one + ', ' + two + ', buckle my shoe';" + "};"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_SILLY", msg.getKey()); 
     assertEquals(null, msg.getDesc()); 
     assertEquals("{$one}, {$two}, buckle my shoe", msg.toString()); 
 }
public void testJsMessageOnProperty211() { 
     extractMessagesSafely("/** @desc a */ " + "pint.sub.MSG_MENU_MARK_AS_UNREAD = goog.getMsg('a')"); 
     assertEquals(0, compiler.getWarningCount()); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_MENU_MARK_AS_UNREAD", msg.getKey()); 
     assertEquals("a", msg.getDesc()); 
 }
public void testLegacyFormatDescription212() { 
     extractMessagesSafely("var MSG_SILLY = 'silly test message';\n" + "var MSG_SILLY_HELP = 'help text';"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_SILLY", msg.getKey()); 
     assertEquals("help text", msg.getDesc()); 
     assertEquals("silly test message", msg.toString()); 
 }
public void testIsEmpty407() { 
     assertTrue(new JsMessage.Builder().build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendStringPart("").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendStringPart("s").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("3").build().isEmpty()); 
 }
public void testMessageWithOnePlaceholder408() { 
     extractMessagesSafely("var MSG_SILLY = function(one, two) {" + "  return one + ', ' + two + ', buckle my shoe';" + "};"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_SILLY", msg.getKey()); 
     assertEquals(null, msg.getDesc()); 
     assertEquals("{$one}, {$two}, buckle my shoe", msg.toString()); 
 }
public void testPlaceholderNamesAreOk411() { 
     extractMessagesSafely("var MSG_SILLY = function(one, two) {" + "  return one + ', ' + two + ', buckle my shoe';" + "};"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_SILLY", msg.getKey()); 
     assertEquals(null, msg.getDesc()); 
     assertEquals("{$one}, {$two}, buckle my shoe", msg.toString()); 
 }
public void testIsEmpty412() { 
     assertTrue(new JsMessage.Builder().build().isEmpty()); 
     assertTrue(new JsMessage.Builder().appendStringPart("").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendStringPart("s").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("p").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("s2").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("s3").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("p3").build().isEmpty()); 
     assertTrue(new JsMessage.Builder().appendStringPart("s1").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("s2").build().isEmpty()); 
     assertFalse(new JsMessage.Builder().appendPlaceholderReference("s3").build().isEmpty()); 
 }
public void testBasicJsMessage413() { 
     extractMessagesSafely("/** @desc d */\n" + "var MSG_SILLY = function(one, two) {" + "  return one + ', ' + two + ', buckle my shoe';" + "};"); 
     assertEquals(1, messages.size()); 
     JsMessage msg = messages.get(0); 
     assertEquals("MSG_SILLY", msg.getKey()); 
     assertEquals(null, msg.getDesc()); 
     assertEquals("{$one}, {$two}, buckle my shoe", msg.toString()); 
 }
public void testIsHidden415() { 
     assertFalse(new JsMessage.Builder().setIsHidden(true).build().isHidden()); 
     assertTrue(new JsMessage.Builder().setIsHidden(false).build().isHidden()); 
     assertFalse(new JsMessage.Builder().setIsHidden(true).build().isHidden()); 
     assertFalse(new JsMessage.Builder().setIsHidden(false).build().isHidden()); 
 }
public void testIsHidden416() { 
     assertFalse(new JsMessage.Builder().setIsHidden(true).build().isHidden()); 
     assertTrue(new JsMessage.Builder().setIsHidden(false).build().isHidden()); 
     assertFalse(new JsMessage.Builder().setIsHidden(true).build().isHidden()); 
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
