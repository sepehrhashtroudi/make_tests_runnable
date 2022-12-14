/*
 * Copyright 2012 The Closure Compiler Authors.
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

import com.google.javascript.jscomp.JsMessage.Style;

/**
 * Test which checks that replacer works correctly.
 *
 */
public class ReplaceMessagesForChromeTest extends CompilerTestCase {

  private Style style = RELAX;

  @Override
  protected CompilerPass getProcessor(Compiler compiler) {
    return new ReplaceMessagesForChrome(compiler,
        new GoogleJsMessageIdGenerator(null), false, style);
  }

  @Override
  protected int getNumRepetitions() {
    // No longer valid on the second run.
    return 1;
  }

  @Override
  protected void setUp()  {
    style = RELAX;
  }

  

  

  

  

  

  
}
