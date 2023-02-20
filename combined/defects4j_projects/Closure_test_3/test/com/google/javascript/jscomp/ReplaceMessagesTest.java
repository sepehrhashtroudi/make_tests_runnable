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

public void testLegacyStylePlaceholderNameInLowerUnderscoreCase390() { 
     registerMessage(new JsMessage.Builder("MSG_F").appendStringPart("Sum: $").appendPlaceholderReference("amt_earned").build()); 
     style = Style.LEGACY; 
     test("var MSG_F = function(amt_earned) {return amt_earned + 'x'};", "var MSG_F=function(amt_earned){return\"Sum: $\"+amt_earned}"); 
 }
public void testBadPlaceholderReferenceInReplacement391() { 
     registerMessage(new JsMessage.Builder("MSG_K").appendPlaceholderReference("amount").build()); 
     test("var MSG_K = goog.getMsg('Hi {$jane}', {jane: x});", "var MSG_K = goog.getMsg('Hi {$jane}', {jane: x});", MESSAGE_TREE_MALFORMED); 
 }
public void testHookReplacement392() { 
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
