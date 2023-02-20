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

import static com.google.javascript.jscomp.JsMessage.Style.RELAX;
import static com.google.javascript.jscomp.JsMessageVisitor.MESSAGE_TREE_MALFORMED;

import com.google.common.collect.Maps;
import com.google.javascript.jscomp.JsMessage.Style;

import java.util.Map;

/**
 * Test which checks that replacer works correctly.
 *
 */
public class ReplaceMessagesTest extends CompilerTestCase {

  private Map<String, JsMessage> messages;
  private Style style = RELAX;
  private boolean strictReplacement;

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new ReplaceMessages(compiler,
        new SimpleMessageBundle(), false, style, strictReplacement);
  }

  @Override
  protected int getNumRepetitions() {
    // No longer valid on the second run.
    return 1;
  }

  @Override
  protected void setUp()  {
    messages = Maps.newHashMap();
    strictReplacement = false;
    style = RELAX;
  }

public void testNoUseFallback2454() { 
     registerMessage(new JsMessage.Builder("MSG_C").appendStringPart("translated").build()); 
     test("/** @desc d */\n" + "var MSG_A = goog.getMsg('msg A');" + "/** @desc d */\n" + "var MSG_B = goog.getMsg('msg B');" + "var x = goog.getMsgWithFallback(MSG_A, MSG_B);", "var MSG_A = 'msg A';" + "var MSG_B = 'msg B';" + "var x = MSG_A;"); 
 }
public void testStrictModeAndMessageReplacementAbsentInNonEmptyBundle455() { 
     registerMessage(new JsMessage.Builder("MSG_J").appendStringPart("One ").appendPlaceholderReference("measly").appendStringPart(" ph").build()); 
     strictReplacement = true; 
     test("var MSG_E = 'Hello';", "var MSG_E = 'Hello';", ReplaceMessages.BUNDLE_DOES_NOT_HAVE_THE_MESSAGE); 
 }
public void testHookReplacement456() { 
     registerMessage(new JsMessage.Builder("MSG_F").appendStringPart("#").appendPlaceholderReference("amount").appendStringPart(".").build()); 
     test("/** @desc d */\n" + "var MSG_F = goog.getMsg('${$amount}', {amount: (a ? b : c)});", "var MSG_F=\"#\"+((a?b:c)+\".\")"); 
 }
  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private void registerMessage(JsMessage message) {
    messages.put(message.getKey(), message);
  }

  private class SimpleMessageBundle implements MessageBundle {

    @Override
    public JsMessage getMessage(String id) {
      return messages.get(id);
    }

    @Override
    public Iterable<JsMessage> getAllMessages() {
      return messages.values();
    }

    @Override
    public JsMessage.IdGenerator idGenerator() {
      return null;
    }
  }
}
