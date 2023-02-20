/*
 * Copyright 2009 The Closure Compiler Authors.
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

import com.google.common.base.Preconditions;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;


/**
 * Tests for PrepareAst.
 * @author nicksantos@google.com (Nick Santos)
 */
public class PrepareAstTest extends CompilerTestCase {

  public PrepareAstTest() {
    super.enableLineNumberCheck(true);
  }

  @Override
  public CompilerPass getProcessor(Compiler compiler) {
    return null; // unused
  }

public void testFreeCall2827() throws Exception { 
     Node root = parseExpectedJs("x.foo();"); 
     Node script = root.getFirstChild(); 
     Preconditions.checkState(script.isScript()); 
     Node firstExpr = script.getFirstChild(); 
     Node call = firstExpr.getFirstChild(); 
     Preconditions.checkState(call.isCall()); 
     assertFalse(call.getBooleanProp(Node.FREE_CALL)); 
 }
  

  

  
}
