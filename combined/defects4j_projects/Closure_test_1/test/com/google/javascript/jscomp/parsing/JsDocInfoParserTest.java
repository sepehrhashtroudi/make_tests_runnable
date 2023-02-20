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

public void testParseParam14348() throws Exception { 
     JSDocInfo info = parse("@param {string} [index] */"); 
     assertEquals(1, info.getParameterCount()); 
     assertTypeEquals(registry.createOptionalType(STRING_TYPE), info.getParameterType("index")); 
 }
public void testMalformedThisAnnotation507() throws Exception { 
     parse("@this */", "Bad type annotation. type not recognized due to syntax error"); 
 }
public void testTypeTagConflict18509() throws Exception { 
     parse("/**\n" + " * @dict\n" + " * @dict\n" + " */\n" + "function DictDict() {}", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testRegression5510() throws Exception { 
     String comment = "@const\n@enum {string}\n@public*/"; 
     JSDocInfo info = parse(comment); 
     assertTrue(info.isConstant()); 
     assertFalse(info.isDefine()); 
     assertTypeEquals(STRING_TYPE, info.getEnumParameterType()); 
     assertEquals(Visibility.PUBLIC, info.getVisibility()); 
 }
public void testRegression1511() throws Exception { 
     String comment = " * @param {number} index the index of blah\n" + " * @return {boolean} whatever\n" + " * @private\n" + " */"; 
     JSDocInfo info = parse(comment); 
     assertEquals(1, info.getParameterCount()); 
     assertTypeEquals(NUMBER_TYPE, info.getParameterType("index")); 
     assertTypeEquals(BOOLEAN_TYPE, info.getReturnType()); 
     assertEquals(Visibility.PRIVATE, info.getVisibility()); 
 }
public void testParseWithMarkers5512() throws Exception { 
     JSDocInfo jsdoc = parse("@return some long \n * multiline" + " \n * description */", true); 
     assertDocumentationInMarker(assertAnnotationMarker(jsdoc, "return", 0, 0), "some long multiline description", 8, 2, 15); 
 }
public void testParseThrows2513() throws Exception { 
     JSDocInfo info = parse("@throws {number} Some number\n " + "*@throws {String} A string */"); 
     assertEquals(2, info.getThrownTypes().size()); 
     assertTypeEquals(NUMBER_TYPE, info.getThrownTypes().get(0)); 
 }
public void testTypeTagConflict2514() throws Exception { 
     parse("@interface \n * @interface */", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testTypeTagConflict8515() throws Exception { 
     parse("@typedef {string} \n * @return {boolean} */", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testParseLends3516() throws Exception { 
     parse("@lends {name */", "Bad type annotation. expected closing }"); 
 }
public void testUnsupportedJsDocSyntax1517() { 
     JSDocInfo info = parse("@param {string} [accessLevel=\"author\"] The user level */", true); 
     assertEquals(1, info.getParameterCount()); 
     assertTypeEquals(registry.createOptionalType(STRING_TYPE), info.getParameterType("accessLevel")); 
     assertEquals("The user level", info.getDescriptionForParameter("accessLevel")); 
 }
public void testTypeTagConflict10518() throws Exception { 
     parse("@this {Object} \n * @enum {boolean} */", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testBadImplementsWithNullable519() throws Exception { 
     JSDocInfo jsdoc = parse("@implements {Disposable?}\n * @constructor */", "Bad type annotation. expected closing }"); 
     assertTrue(jsdoc.isConstructor()); 
     assertTypeEquals(registry.createNamedType("Disposable", null, -1, -1), jsdoc.getImplementedInterfaces().get(0)); 
 }
public void testParseWithMarkerNames2520() throws Exception { 
     JSDocInfo jsdoc = parse("@param {SomeType} name somedescription \n" + "* @param {AnotherType} anothername des */", true); 
     assertTypeInMarker(assertNameInMarker(assertAnnotationMarker(jsdoc, "param", 0, 0, 0), "name", 0, 18), "SomeType", 0, 7, 0, 16, true); 
     assertTypeInMarker(assertNameInMarker(assertAnnotationMarker(jsdoc, "param", 1, 2, 1), "anothername", 1, 23), "AnotherType", 1, 9, 1, 21, true); 
 }
public void testParseParamError5521() throws Exception { 
     parse("@param {number} x \n * @param {string} x */", "Bad type annotation. missing variable name in @param tag"); 
 }
public void testTypeTagConflict1522() throws Exception { 
     parse("@constructor \n * @constructor */", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testParseDefineErrors5524() throws Exception { 
     parse("@define {string}\n @define {number} */", "conflicting @define tag"); 
 }
public void testRegression4525() throws Exception { 
     String comment = " * @const\n" + " * @hidden\n" + " * @preserveTry\n" + " * @constructor\n" + " */"; 
     JSDocInfo info = parse(comment); 
     assertTrue(info.isConstant()); 
     assertFalse(info.isDefine()); 
     assertTrue(info.isConstructor()); 
     assertTrue(info.isHidden()); 
     assertTrue(info.shouldPreserveTry()); 
 }
public void testBadClassMultiExtends526() throws Exception { 
     parse(" * @extends {Extended1} \n" + " * @constructor \n" + " * @extends {Extended2} */", "Bad type annotation. type annotation incompatible with other " + "annotations"); 
 }
public void testInterfaceExtends527() throws Exception { 
     JSDocInfo jsdoc = parse(" * @interface \n" + " * @extends {Extended} */"); 
     assertTrue(jsdoc.isInterface()); 
     assertEquals(1, jsdoc.getExtendedInterfacesCount()); 
     List<JSTypeExpression> types = jsdoc.getExtendedInterfaces(); 
     assertTypeEquals(registry.createNamedType("Extended", null, -1, -1), types.get(0)); 
 }
public void testBadSuppress4528() throws Exception { 
     parse("@suppress {x|y */", "malformed @suppress tag"); 
 }
public void testSuppress1529() throws Exception { 
     JSDocInfo info = parse("@suppress {x} */"); 
     assertEquals(Sets.newHashSet("x"), info.getSuppressions()); 
 }
public void testBadModifies4530() throws Exception { 
     parse("@modifies {this|arguments */", "malformed @modifies tag"); 
 }
public void testParseDesc12531() throws Exception { 
     String comment = "@desc\n:\n[\n]\n...*/"; 
     assertEquals(": [ ] ...", parse(comment).getDescription()); 
 }
public void testParseLicenseWithAnnotation532() throws Exception { 
     Node node = new Node(1); 
     this.fileLevelJsDocBuilder = node.getJsDocBuilderForNode(); 
     String comment = "@license Foo \n * @author Charlie Brown */"; 
     parse(comment); 
     assertEquals(" Foo \n @author Charlie Brown ", node.getJSDocInfo().getLicense()); 
 }
public void testDocumentationMultipleParameter2533() throws Exception { 
     JSDocInfo jsdoc = parse("@param {number} delta = 0 results in a redraw\n" + "  != 0 ..... */", true); 
     assertTrue(jsdoc.hasDescriptionForParameter("delta")); 
     assertEquals("= 0 results in a redraw != 0 .....", jsdoc.getDescriptionForParameter("delta")); 
 }
public void testParseParam11534() throws Exception { 
     parse("@param {number= index */", "Bad type annotation. expected closing }"); 
 }
public void testParseNullableModifiers4535() throws Exception { 
     JSDocInfo info = parse("@type {(string,boolean)?}*/"); 
     assertTypeEquals(createNullableType(createUnionType(STRING_TYPE, BOOLEAN_TYPE)), info.getType()); 
 }
public void testParseFunctionalTypeError1536() throws Exception { 
     parse("@type {function number):string}*/", "Bad type annotation. missing opening ("); 
 }
public void testParseOptionalModifier537() throws Exception { 
     JSDocInfo info = parse("@type {function(number=)}*/"); 
     assertTypeEquals(registry.createFunctionType(UNKNOWN_TYPE, registry.createOptionalParameters(NUMBER_TYPE)), info.getType()); 
 }
public void testParseFunctionalType13538() throws Exception { 
     testParseType("function(...): void", "function (...[?]): undefined"); 
 }
public void testParseDefine4859() throws Exception { 
     assertTypeEquals(NUMBER_TYPE, parse("@define {number}*/").getType()); 
 }
public void testParseJavaDispatch2861() throws Exception { 
     parse("@javadispatch\n@javadispatch*/", "extra @javadispatch tag"); 
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
