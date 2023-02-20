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

import static com.google.javascript.jscomp.CheckAccessControls.BAD_PRIVATE_GLOBAL_ACCESS;
import static com.google.javascript.jscomp.CheckAccessControls.BAD_PRIVATE_PROPERTY_ACCESS;
import static com.google.javascript.jscomp.CheckAccessControls.BAD_PROTECTED_PROPERTY_ACCESS;
import static com.google.javascript.jscomp.CheckAccessControls.CONST_PROPERTY_DELETED;
import static com.google.javascript.jscomp.CheckAccessControls.CONST_PROPERTY_REASSIGNED_VALUE;
import static com.google.javascript.jscomp.CheckAccessControls.DEPRECATED_CLASS;
import static com.google.javascript.jscomp.CheckAccessControls.DEPRECATED_CLASS_REASON;
import static com.google.javascript.jscomp.CheckAccessControls.DEPRECATED_NAME;
import static com.google.javascript.jscomp.CheckAccessControls.DEPRECATED_NAME_REASON;
import static com.google.javascript.jscomp.CheckAccessControls.DEPRECATED_PROP;
import static com.google.javascript.jscomp.CheckAccessControls.DEPRECATED_PROP_REASON;
import static com.google.javascript.jscomp.CheckAccessControls.EXTEND_FINAL_CLASS;
import static com.google.javascript.jscomp.CheckAccessControls.PRIVATE_OVERRIDE;
import static com.google.javascript.jscomp.CheckAccessControls.VISIBILITY_MISMATCH;

/**
 * Tests for {@link CheckAccessControls}.
 *
 * @author nicksantos@google.com (Nick Santos)
 */
public class CheckAccessControlsTest extends CompilerTestCase {

  public CheckAccessControlsTest() {
    super(CompilerTypeTestCase.DEFAULT_EXTERNS);
    parseTypeInfo = true;
    enableTypeCheck(CheckLevel.WARNING);
  }

  @Override
  protected CompilerPass getProcessor(final Compiler compiler) {
    return new CheckAccessControls(compiler);
  }

  @Override
  protected CompilerOptions getOptions() {
    CompilerOptions options = super.getOptions();
    options.setWarningLevel(DiagnosticGroups.ACCESS_CONTROLS, CheckLevel.ERROR);
    options.setWarningLevel(DiagnosticGroups.CONSTANT_PROPERTY,
        CheckLevel.ERROR);
    return options;
  }

  /**
   * Tests that the given JavaScript code has a @deprecated marker
   * somewhere in it which raises an error. Also tests that the
   * deprecated marker works with a message. The JavaScript should
   * have a JsDoc of the form "@deprecated %s\n".
   *
   * @param js The JavaScript code to parse and test.
   * @param reason A simple deprecation reason string, used for testing
   *    the addition of a deprecation reason to the @deprecated tag.
   * @param error The deprecation error expected when no reason is given.
   * @param errorWithMessage The deprecation error expected when a reason
   *    message is given.
   */
  private void testDep(String js, String reason,
                       DiagnosticType error,
                       DiagnosticType errorWithMessage) {

    // Test without a reason.
    test(String.format(js, ""), null, error);

    // Test with a reason.
    test(String.format(js, reason), null, errorWithMessage, null, reason);
  }

public void testWarningOnDeprecatedConstVariable96() { 
     testDep("/** @deprecated %s */ var f = 4; function g() { alert(f); }", "Another reason", DEPRECATED_NAME, DEPRECATED_NAME_REASON); 
 }
public void testFinalClassCannotBeSubclassed97() { 
     test("/**\n" + " * @constructor\n" + " * @const\n" + " */ Foo = function() {};\n" + "/**\n" + " * @constructor\n" + " * @extends {Foo}\n*" + " */ Bar = function() {};", null, EXTEND_FINAL_CLASS); 
     test("/**\n" + " * @constructor\n" + " * @const\n" + " */ function Foo() {};\n" + "/**\n" + " * @constructor\n" + " * @extends {Foo}\n*" + " */ function Bar() {};", null, EXTEND_FINAL_CLASS); 
 }
public void testWarningForDeprecatedSuperClass298() { 
     testDep("/** @constructor \n * @deprecated %s */ function Foo() {} " + "var namespace = {}; " + "/** @constructor \n * @extends {Foo} */ " + "namespace.SubFoo = function() {}; " + "function f() { new namespace.SubFoo(); }", "Its only weakness is Kryptoclass", DEPRECATED_CLASS, DEPRECATED_CLASS_REASON); 
 }
public void testPrivateAccessForNames99() { 
     testSame("/** @private */ function foo_() {}; foo_();"); 
     test(new String[] { "/** @private */ function foo_() {};", "foo_();" }, null, BAD_PRIVATE_GLOBAL_ACCESS); 
 }
public void testConstantProperty14100() { 
     test("/** @constructor */ function Foo() {" + "/** @const */ this.bar = 3; delete this.bar; }", null, CONST_PROPERTY_DELETED); 
 }
public void testGoodOverrideOfProtectedProperty101() { 
     testSame(new String[] { "/** @constructor */ function Foo() { } " + "/** @protected */ Foo.prototype.bar = function() {};", "/** @constructor \n * @extends {Foo} */ " + "function SubFoo() {}" + "/** @inheritDoc */ SubFoo.prototype.bar = function() {};" }); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  
}
