/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.jxpath.ri.compiler;

import java.text.DecimalFormatSymbols;

import org.apache.commons.jxpath.IdentityManager;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathTestCase;
import org.apache.commons.jxpath.KeyManager;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.TestMixedModelBean;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.model.NodePointer;

/**
 * Test basic functionality of JXPath - core functions.
 *
 * @author Dmitri Plotnikov
 * @version $Revision$ $Date$
 */

public class CoreFunctionTest extends JXPathTestCase {
    private JXPathContext context;

    /**
     * Construct a new instance of this test case.
     *
     * @param name Name of the test case
     */
    public CoreFunctionTest(String name) {
        super(name);
    }

    public void setUp() {
        if (context == null) {
            context = JXPathContext.newContext(new TestMixedModelBean());
            Variables vars = context.getVariables();
            vars.declareVariable("nan", new Double(Double.NaN));
            vars.declareVariable("bool_true", new Boolean("true"));
            vars.declareVariable("bool_false", new Boolean("false"));
        }
    }

public void testDot2() { final String TEST_NAME = "testDot"; final String TEST_NAME_2 = "testDot2"; final String TEST_NAME_3 = "testDot3"; final String TEST_NAME_4 = "testDot4"; final String TEST_NAME_5 = "testDot5"; final String TEST_NAME_6 = "testDot6"; final String TEST_NAME_7 = "testDot7"; final String TEST_NAME_8 = "testDot8"; final String TEST_NAME_9 = "testDot9"; final String TEST_NAME_10 = "testDot10"; final String TEST_NAME_11 = "testDot11";
}

public void testFunctionKey3() { }
public void CoreFunctionName() throws Exception { }
public void testCoreFunctionName79() throws Exception { }
public void testGetKeyManager535() { KeyManager keyManager = JXPathContext.newContext(null, null).getKeyManager(); assertNotNull(keyManager); }
public void testGetKeyManager536() throws Exception { KeyManager keyManager = JXPathContext.newContext(null, null).getKeyManager(); assertNotNull(keyManager); assertSame(keyManager, JXPathContext.newContext(null, null).getKeyManager()); keyManager = JXPathContext.newContext(null, null).getKeyManager(); assertNotNull(keyManager); assertSame(keyManager, JXPathContext.newContext(null, null).getKeyManager()); keyManager = JXPathContext.newContext(null, null).getKeyManager(); assertNotNull(keyManager); assertSame(keyManager, JXPathContext.newContext(null, null).getKeyManager()); }
    

    

    
    
    
}
