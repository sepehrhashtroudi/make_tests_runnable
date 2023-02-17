/*
 * Copyright 2007 The Closure Compiler Authors.
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

package com.google.javascript.jscomp.parsing;

import com.google.common.collect.Sets;
import com.google.javascript.jscomp.parsing.Config.LanguageMode;
import com.google.javascript.jscomp.testing.TestErrorReporter;
import com.google.javascript.rhino.InputId;
import com.google.javascript.rhino.JSDocInfo;
import com.google.javascript.rhino.JSDocInfo.Visibility;
import com.google.javascript.rhino.JSTypeExpression;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.Token;
import com.google.javascript.rhino.head.CompilerEnvirons;
import com.google.javascript.rhino.head.Parser;
import com.google.javascript.rhino.head.Token.CommentType;
import com.google.javascript.rhino.head.ast.AstRoot;
import com.google.javascript.rhino.head.ast.Comment;
import com.google.javascript.rhino.jstype.JSType;
import com.google.javascript.rhino.jstype.ObjectType;
import com.google.javascript.rhino.jstype.SimpleSourceFile;
import com.google.javascript.rhino.jstype.StaticSourceFile;
import com.google.javascript.rhino.testing.BaseJSTypeTestCase;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class JsDocInfoParserTest extends BaseJSTypeTestCase {

  private Set<String> extraAnnotations;
  private Set<String> extraSuppressions;
  private Node.FileLevelJsDocBuilder fileLevelJsDocBuilder = null;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    extraAnnotations =
        Sets.newHashSet(
            ParserRunner.createConfig(true, LanguageMode.ECMASCRIPT3, false)
                .annotationNames.keySet());
    extraSuppressions =
        Sets.newHashSet(
            ParserRunner.createConfig(true, LanguageMode.ECMASCRIPT3, false)
                .suppressionNames);

    extraSuppressions.add("x");
    extraSuppressions.add("y");
    extraSuppressions.add("z");
  }

public void testParseNewline3483() throws Exception { 
     JSDocInfo info = parse("@type !Array.<(number,\n* null)>*/"); 
     assertTypeEquals(parameterize(ARRAY_TYPE, createUnionType(NUMBER_TYPE, NULL_TYPE)), info.getType()); 
 }
public void testBadModifies4484() throws Exception { 
     parse("@modifies {this|arguments */", "malformed @modifies tag"); 
 }
public void testTypeTagConflict22485() throws Exception { 
     parse("/**\n" + " * @protected {string}\n" + " * @param {string} x\n" + " */\n" + "function DictDict(x) {}", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testTypeTagConflict17486() throws Exception { 
     parse("/**\n" + " * @interface\n" + " * @struct\n" + " */\n" + "function StrIntf() {}", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testRegression4487() throws Exception { 
     String comment = " * @const\n" + " * @hidden\n" + " * @preserveTry\n" + " * @constructor\n" + " */"; 
     JSDocInfo info = parse(comment); 
     assertTrue(info.isConstant()); 
     assertFalse(info.isDefine()); 
     assertTrue(info.isConstructor()); 
     assertTrue(info.isHidden()); 
     assertTrue(info.shouldPreserveTry()); 
 }
public void testParseDeprecated2488() throws Exception { 
     parse("@deprecated\n@deprecated*/", "extra @deprecated tag"); 
 }
public void testParseWithMarkerNames2489() throws Exception { 
     JSDocInfo jsdoc = parse("@param {SomeType} name somedescription \n" + "* @param {AnotherType} anothername des */", true); 
     assertTypeInMarker(assertNameInMarker(assertAnnotationMarker(jsdoc, "param", 0, 0, 0), "name", 0, 18), "SomeType", 0, 7, 0, 16, true); 
     assertTypeInMarker(assertNameInMarker(assertAnnotationMarker(jsdoc, "param", 1, 2, 1), "anothername", 1, 23), "AnotherType", 1, 9, 1, 21, true); 
 }
public void testParseWithMarkers5490() throws Exception { 
     JSDocInfo jsdoc = parse("@return some long \n * multiline" + " \n * description */", true); 
     assertDocumentationInMarker(assertAnnotationMarker(jsdoc, "return", 0, 0), "some long multiline description", 8, 2, 15); 
 }
public void testParseWithMarkers5491() throws Exception { 
     JSDocInfo jsdoc = parse("@author abc@google.com */", true); 
     assertDocumentationInMarker(assertAnnotationMarker(jsdoc, "author", 0, 0), "abc@google.com", 7, 0, 21); 
 }
public void testBadTypeDefInterfaceAndConstructor1492() throws Exception { 
     JSDocInfo jsdoc = parse("@interface\n@constructor*/", "Bad type annotation. cannot be both an interface and a constructor"); 
     assertTrue(jsdoc.isInterface()); 
 }
public void testWhitelistedAnnotations493() { 
     parse("* @addon \n" + "* @augments \n" + "* @base \n" + "* @borrows \n" + "* @bug \n" + "* @class \n" + "* @config \n" + "* @constructs \n" + "* @default \n" + "* @description \n" + "* @event \n" + "* @example \n" + "* @exception \n" + "* @exec \n" + "* @externs \n" + "* @field \n" + "* @function \n" + "* @id \n" + "* @ignore \n" + "* @inner \n" + "* @lends {string} \n" + "* @link \n" + "* @member \n" + "* @memberOf \n" + "* @modName \n" + "* @mods \n" + "* @name \n" + "* @namespace \n" + "* @nocompile \n" + "* @property \n" + "* @requires \n" + "* @since \n" + "* @static \n" + "* @supported */"); 
 }
public void testParseParamError2494() throws Exception { 
     parseFull("/** @param {Number}*/", "Bad type annotation. expecting a variable name in a @param tag"); 
 }
public void testSeeMissing495() throws Exception { 
     parse("* @see */", true, "@see tag missing description"); 
 }
public void testBadImplementsWithNullable496() throws Exception { 
     JSDocInfo jsdoc = parse("@implements {Disposable?}\n * @constructor */", "Bad type annotation. expected closing }"); 
     assertTrue(jsdoc.isConstructor()); 
     assertTypeEquals(registry.createNamedType("Disposable", null, -1, -1), jsdoc.getImplementedInterfaces().get(0)); 
 }
public void testBadSuppress1497() throws Exception { 
     parse("@suppress {} */", "malformed @suppress tag"); 
 }
public void testParseDefineErrors5498() throws Exception { 
     parse("@return {string}\n @define {string} */", "conflicting @define tag"); 
 }
public void testSuppress2499() throws Exception { 
     JSDocInfo info = parse("@suppress {x|y|x|z} */"); 
     assertEquals(Sets.newHashSet("x", "y", "z"), info.getSuppressions()); 
 }
public void testParseSuppress2500() throws Exception { 
     JSDocInfo info = parse("@suppress {x|y|x|z} */"); 
     assertEquals(Sets.newHashSet("x", "y", "z"), info.getSuppressions()); 
 }
public void testParseParam7501() throws Exception { 
     JSDocInfo info = parse("@param {number=} index */"); 
     assertTypeEquals(registry.createOptionalType(NUMBER_TYPE), info.getParameterType("index")); 
 }
public void testParseFunctionalType8503() throws Exception { 
     testParseType("function(this:Array,...[boolean])", "function (this:Array, ...[boolean]): ?"); 
 }
public void testParseFunctionalTypeError7504() throws Exception { 
     parse("@type {function(...[number)}*/", "Bad type annotation. missing closing )"); 
 }
public void testParseOptionalModifier505() throws Exception { 
     JSDocInfo info = parse("@type {function(number=)}*/"); 
     assertTypeEquals(registry.createFunctionType(UNKNOWN_TYPE, registry.createOptionalParameters(NUMBER_TYPE)), info.getType()); 
 }
public void testParseFunctionalType10506() throws Exception { 
     testParseType("function(...[Object?]):boolean?", "function (...[(Object|null)]): (boolean|null)"); 
 }
public void testParseFunctionalType13507() throws Exception { 
     testParseType("function(...): void", "function (...[?]): undefined"); 
 }
public void testMalformedThisAnnotation508() throws Exception { 
     parse("@this */", "Bad type annotation. type not recognized due to syntax error"); 
 }
public void testParseRecordType7509() throws Exception { 
     parseFull("/** @param {{'x' : !hello}} n\n*/"); 
 }
public void testSingleTagsReordered753() throws Exception { 
     JSDocInfo jsdoc = parse("@deprecated In favor of the new one!" + "\n * @return {SomeType} The most important object :-)" + "\n * @version Some old version*/", true); 
     assertTrue(jsdoc.isDeprecated()); 
     assertEquals("In favor of the new one!", jsdoc.getDeprecationReason()); 
     assertEquals("Some old version", jsdoc.getVersion()); 
     assertEquals("The most important object :-)", jsdoc.getReturnDescription()); 
 }
public void testParseNoTypeCheck2813() throws Exception { 
     parse("@noCheck\n@noCheck*/", "extra @noCheck tag"); 
 }
public void testGetAndSetJSDocInfoWithNoType816() throws Exception { 
     JSDocInfo deprecated = new JSDocInfo(); 
     deprecated.setDeprecated(true); 
     NO_TYPE.setPropertyJSDocInfo("X", deprecated); 
     assertNull(NO_TYPE.getOwnPropertyJSDocInfo("X")); 
 }
  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  private JSType testParseType(String type) throws Exception {
    return testParseType(type, type);
  }

  private JSType testParseType(
      String type, String typeExpected) throws Exception {
    JSDocInfo info = parse("@type {" + type + "}*/");

    assertNotNull(info);
    assertTrue(info.hasType());

    JSType actual = resolve(info.getType());
    assertEquals(typeExpected, actual.toString());
    return actual;
  }

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  


  

  

  

  

  

  

  

  

  

  //public void testNoParseFileOverview() throws Exception {
  //  JSDocInfo jsdoc = parseFileOverviewWithoutDoc("@fileoverview Hi mom! */");
  //  assertNull(jsdoc.getFileOverview());
  //  assertTrue(jsdoc.hasFileOverview());
  //}

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  /**
   * Asserts that a documentation field exists on the given marker.
   *
   * @param description The text of the documentation field expected.
   * @param startCharno The starting character of the text.
   * @param endLineno The ending line of the text.
   * @param endCharno The ending character of the text.
   * @return The marker, for chaining purposes.
   */
  private JSDocInfo.Marker assertDocumentationInMarker(JSDocInfo.Marker marker,
                                                       String description,
                                                       int startCharno,
                                                       int endLineno,
                                                       int endCharno) {
    assertTrue(marker.getDescription() != null);
    assertEquals(description, marker.getDescription().getItem());

    // Match positional information.
    assertEquals(marker.getAnnotation().getStartLine(),
                 marker.getDescription().getStartLine());
    assertEquals(startCharno, marker.getDescription().getPositionOnStartLine());
    assertEquals(endLineno, marker.getDescription().getEndLine());
    assertEquals(endCharno, marker.getDescription().getPositionOnEndLine());

    return marker;
  }

  /**
   * Asserts that a type field exists on the given marker.
   *
   * @param typeName The name of the type expected in the type field.
   * @param startCharno The starting character of the type declaration.
   * @param hasBrackets Whether the type in the type field is expected
   *     to have brackets.
   * @return The marker, for chaining purposes.
   */
  private JSDocInfo.Marker assertTypeInMarker(
      JSDocInfo.Marker marker, String typeName,
      int startLineno, int startCharno, int endLineno, int endCharno,
      boolean hasBrackets) {

    assertTrue(marker.getType() != null);
    assertTrue(marker.getType().getItem().isString());

    // Match the name and brackets information.
    String foundName = marker.getType().getItem().getString();

    assertEquals(typeName, foundName);
    assertEquals(hasBrackets, marker.getType().hasBrackets());

    // Match position information.
    assertEquals(startCharno, marker.getType().getPositionOnStartLine());
    assertEquals(endCharno, marker.getType().getPositionOnEndLine());
    assertEquals(startLineno, marker.getType().getStartLine());
    assertEquals(endLineno, marker.getType().getEndLine());

    return marker;
  }

  /**
   * Asserts that a name field exists on the given marker.
   *
   * @param name The name expected in the name field.
   * @param startCharno The starting character of the text.
   * @return The marker, for chaining purposes.
   */
  @SuppressWarnings("deprecation")
  private JSDocInfo.Marker assertNameInMarker(JSDocInfo.Marker marker,
      String name, int startLine, int startCharno) {
    assertTrue(marker.getName() != null);
    assertEquals(name, marker.getName().getItem());

    assertEquals(startCharno, marker.getName().getPositionOnStartLine());
    assertEquals(startCharno + name.length(),
                 marker.getName().getPositionOnEndLine());

    assertEquals(startLine, marker.getName().getStartLine());
    assertEquals(startLine, marker.getName().getEndLine());

    return marker;
  }

  /**
   * Asserts that an annotation marker of a given annotation name
   * is found in the given JSDocInfo.
   *
   * @param jsdoc The JSDocInfo in which to search for the annotation marker.
   * @param annotationName The name/type of the annotation for which to
   *   search. Example: "author" for an "@author" annotation.
   * @param startLineno The expected starting line number of the marker.
   * @param startCharno The expected character on the starting line.
   * @return The marker found, for further testing.
   */
  private JSDocInfo.Marker assertAnnotationMarker(JSDocInfo jsdoc,
                                                  String annotationName,
                                                  int startLineno,
                                                  int startCharno) {
    return assertAnnotationMarker(jsdoc, annotationName, startLineno,
                                  startCharno, 0);
  }

  /**
   * Asserts that the index-th annotation marker of a given annotation name
   * is found in the given JSDocInfo.
   *
   * @param jsdoc The JSDocInfo in which to search for the annotation marker.
   * @param annotationName The name/type of the annotation for which to
   *   search. Example: "author" for an "@author" annotation.
   * @param startLineno The expected starting line number of the marker.
   * @param startCharno The expected character on the starting line.
   * @param index The index of the marker.
   * @return The marker found, for further testing.
   */
  private JSDocInfo.Marker assertAnnotationMarker(JSDocInfo jsdoc,
                                                  String annotationName,
                                                  int startLineno,
                                                  int startCharno,
                                                  int index) {

    Collection<JSDocInfo.Marker> markers = jsdoc.getMarkers();

    assertTrue(markers.size() > 0);

    int counter = 0;

    for (JSDocInfo.Marker marker : markers) {
      if (marker.getAnnotation() != null) {
        if (annotationName.equals(marker.getAnnotation().getItem())) {

          if (counter == index) {
            assertEquals(startLineno, marker.getAnnotation().getStartLine());
            assertEquals(startCharno,
                         marker.getAnnotation().getPositionOnStartLine());
            assertEquals(startLineno, marker.getAnnotation().getEndLine());
            assertEquals(startCharno + annotationName.length(),
                         marker.getAnnotation().getPositionOnEndLine());

            return marker;
          }

          counter++;
        }
      }
    }

    fail("No marker found");
    return null;
  }

  private <T> void assertContains(Collection<T> collection, T item) {
    assertTrue(collection.contains(item));
  }

  private void parseFull(String code, String... warnings) {
    CompilerEnvirons environment = new CompilerEnvirons();

    TestErrorReporter testErrorReporter = new TestErrorReporter(null, warnings);
    environment.setErrorReporter(testErrorReporter);

    environment.setRecordingComments(true);
    environment.setRecordingLocalJsDocComments(true);

    Parser p = new Parser(environment, testErrorReporter);
    AstRoot script = p.parse(code, null, 0);

    Config config =
        new Config(extraAnnotations, extraSuppressions,
            true, LanguageMode.ECMASCRIPT3, false);
    StaticSourceFile file = new SimpleSourceFile(script.getSourceName(), false);
    for (Comment comment : script.getComments()) {
      JsDocInfoParser jsdocParser =
        new JsDocInfoParser(
            new JsDocTokenStream(comment.getValue().substring(3),
                comment.getLineno()),
            comment,
            null,
            config,
            testErrorReporter);
      jsdocParser.parse();
      jsdocParser.retrieveAndResetParsedJSDocInfo();
    }

    assertTrue("some expected warnings were not reported",
        testErrorReporter.hasEncounteredAllWarnings());
  }

  @SuppressWarnings("unused")
  private JSDocInfo parseFileOverviewWithoutDoc(String comment,
                                                String... warnings) {
    return parse(comment, false, true, warnings);
  }

  private JSDocInfo parseFileOverview(String comment, String... warnings) {
    return parse(comment, true, true, warnings);
  }

  private JSDocInfo parse(String comment, String... warnings) {
    return parse(comment, false, warnings);
  }

  private JSDocInfo parse(String comment, boolean parseDocumentation,
                          String... warnings) {
    return parse(comment, parseDocumentation, false, warnings);
  }

  private JSDocInfo parse(String comment, boolean parseDocumentation,
      boolean parseFileOverview, String... warnings) {
    TestErrorReporter errorReporter = new TestErrorReporter(null, warnings);

    Config config = new Config(extraAnnotations, extraSuppressions,
        parseDocumentation, LanguageMode.ECMASCRIPT3, false);
    StaticSourceFile file = new SimpleSourceFile("testcode", false);
    Node associatedNode = new Node(Token.SCRIPT);
    associatedNode.setInputId(new InputId(file.getName()));
    associatedNode.setStaticSourceFile(file);
    JsDocInfoParser jsdocParser = new JsDocInfoParser(
        stream(comment),
        new Comment(0, 0, CommentType.JSDOC, comment),
        associatedNode,
        config, errorReporter);

    if (fileLevelJsDocBuilder != null) {
      jsdocParser.setFileLevelJsDocBuilder(fileLevelJsDocBuilder);
    }

    jsdocParser.parse();

    assertTrue("expected warnings were not reported",
        errorReporter.hasEncounteredAllWarnings());

    if (parseFileOverview) {
      return jsdocParser.getFileOverviewJSDocInfo();
    } else {
      return jsdocParser.retrieveAndResetParsedJSDocInfo();
    }
  }

  private Node parseType(String typeComment) {
    return JsDocInfoParser.parseTypeString(typeComment);
  }

  private JsDocTokenStream stream(String source) {
    return new JsDocTokenStream(source, 0);
  }

  private void assertParameterTypeEquals(JSType expected, JSTypeExpression te) {
    assertEquals(expected, ((ObjectType) resolve(te)).getParameterType());
  }

  private void assertIndexTypeEquals(JSType expected, JSTypeExpression te) {
    assertEquals(expected, ((ObjectType) resolve(te)).getIndexType());
  }
}
