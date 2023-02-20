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

public void testParseParam18301() throws Exception { 
     JSDocInfo info = parse("@param {...string} [index] */"); 
     assertEquals(1, info.getParameterCount()); 
     assertTypeEquals(registry.createOptionalType(STRING_TYPE), info.getParameterType("index")); 
 }
public void testRegression1485() throws Exception { 
     String comment = " * @param {number} index the index of blah\n" + " * @return {boolean} whatever\n" + " * @private\n" + " */"; 
     JSDocInfo info = parse(comment); 
     assertEquals(1, info.getParameterCount()); 
     assertTypeEquals(NUMBER_TYPE, info.getParameterType("index")); 
     assertTypeEquals(BOOLEAN_TYPE, info.getReturnType()); 
     assertEquals(Visibility.PRIVATE, info.getVisibility()); 
 }
public void testParseWithMarkers1486() throws Exception { 
     JSDocInfo jsdoc = parse("@author abc@google.com */", true); 
     assertDocumentationInMarker(assertAnnotationMarker(jsdoc, "author", 0, 0), "abc@google.com", 7, 0, 21); 
 }
public void testTypeTagConflict2487() throws Exception { 
     parse("@interface \n * @interface */", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testTypeTagConflict22488() throws Exception { 
     parse("/**\n" + " * @protected {string}\n" + " * @param {string} x\n" + " */\n" + "function DictDict(x) {}", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testParseExterns2489() throws Exception { 
     parseFileOverview("@externs\n@externs*/", "extra @externs tag"); 
 }
public void testSourceName490() throws Exception { 
     JSDocInfo jsdoc = parse("@deprecated */", true); 
     assertEquals("testcode", jsdoc.getAssociatedNode().getSourceFileName()); 
 }
public void testParseLends3491() throws Exception { 
     parse("@lends {name */", "Bad type annotation. expected closing }"); 
 }
public void testPreserveAnnotatedName492() { 
     assertNull(parse("@preserve Foo", "Unexpected end of file")); 
 }
public void testRegression4493() throws Exception { 
     String comment = " * @const\n" + " * @hidden\n" + " * @preserveTry\n" + " * @constructor\n" + " */"; 
     JSDocInfo info = parse(comment); 
     assertTrue(info.isConstant()); 
     assertFalse(info.isDefine()); 
     assertTrue(info.isConstructor()); 
     assertTrue(info.isHidden()); 
     assertTrue(info.shouldPreserveTry()); 
 }
public void testBug909468494() throws Exception { 
     parse("@extends {(x)}*/", "Bad type annotation. expecting a type name"); 
 }
public void testTypeTagConflict10495() throws Exception { 
     parse("@this {Object} \n * @enum {boolean} */", "Bad type annotation. " + "type annotation incompatible with other annotations"); 
 }
public void testParseDefine4496() throws Exception { 
     assertTypeEquals(NUMBER_TYPE, parse("@define {number}*/").getType()); 
 }
public void testBadClassMultiExtends497() throws Exception { 
     parse(" * @extends {Extended1} \n" + " * @constructor \n" + " * @extends {Extended2} */", "Bad type annotation. type annotation incompatible with other " + "annotations"); 
 }
public void testParseNoAlias2498() throws Exception { 
     parse("@noalias\n@noalias*/", "extra @noalias tag"); 
 }
public void testParseNoCompiler2499() throws Exception { 
     parse("@notypecheck\n@notypecheck*/", "extra @notypecheck tag"); 
 }
public void testParseNoCompile2500() throws Exception { 
     parseFileOverview("@nocompile\n@nocompile*/", "extra @nocompile tag"); 
 }
public void testParseNoCheck2502() throws Exception { 
     parse("@notypecheck\n@notypecheck*/", "extra @notypecheck tag"); 
 }
public void testParseExtendsGenerics503() throws Exception { 
     JSDocInfo info = parse("@extends com.google.Foo.Bar.Hello.World.<Boolean,number>*/"); 
     assertTypeEquals(registry.createNamedType("com.google.Foo.Bar.Hello.World", null, -1, -1), info.getBaseType()); 
 }
public void testParseParam7504() throws Exception { 
     JSDocInfo info = parse("@param {number=} index */"); 
     assertTypeEquals(registry.createOptionalType(NUMBER_TYPE), info.getParameterType("index")); 
 }
public void testParseWithMarkers5505() throws Exception { 
     JSDocInfo jsdoc = parse("@return some long \n * multiline" + " \n * description */", true); 
     assertDocumentationInMarker(assertAnnotationMarker(jsdoc, "return", 0, 0), "some long multiline description", 8, 2, 15); 
 }
public void testParserWithTemplateDuplicated506() { 
     parse("@template T\n@template V */", "Bad type annotation. @template tag at most once"); 
 }
public void testBadSuppress1509() throws Exception { 
     parse("@suppress {} */", "malformed @suppress tag"); 
 }
public void testSuppress1510() throws Exception { 
     JSDocInfo info = parse("@suppress {x} */"); 
     assertEquals(Sets.newHashSet("x"), info.getSuppressions()); 
 }
public void testModifies6511() throws Exception { 
     JSDocInfo info = parse("@param {*} x\n" + " * @param {*} y\n" + " * @modifies {x|y} */"); 
     assertEquals(Sets.newHashSet("x", "y"), info.getModifies()); 
 }
public void testBadModifies3512() throws Exception { 
     parse("@modifies {|this} */", "malformed @modifies tag"); 
 }
public void testParseDesc9513() throws Exception { 
     String comment = "@desc\n.\n,\n{\n)\n}\n|\n.<\n>\n<\n?\n~\n+\n-\n;\n:\n*/"; 
     assertEquals(". , { ) } | .< > < ? ~ + - ; :", parse(comment).getDescription()); 
 }
public void testGetOriginalCommentString514() throws Exception { 
     String comment = "* @desc This is a comment */"; 
     JSDocInfo info = parse(comment); 
     assertNull(info.getOriginalCommentString()); 
     info = parse(comment, true); 
     assertEquals(comment, info.getOriginalCommentString()); 
 }
public void testParseDesc8515() throws Exception { 
     assertEquals("a b c d", parse("@desc a\n      *b\n  *c\nd*/").getDescription()); 
 }
public void testParseFunctionalType8517() throws Exception { 
     testParseType("function(this:Array,...[boolean])", "function (this:Array, ...[boolean]): ?"); 
 }
public void testParseUnionType13518() throws Exception { 
     testParseType("(function(this:Date),function(this:String):number)", "Function"); 
 }
public void testParseFunctionalType10519() throws Exception { 
     testParseType("function(...[Object?]):boolean?", "function (...[(Object|null)]): (boolean|null)"); 
 }
public void testParseFunctionalType19520() throws Exception { 
     testParseType("function(...[?]): void", "function (...[?]): undefined"); 
 }
public void testParseArrayTypeError3521() throws Exception { 
     parse("@type {[(number,boolean,Object?])]}*/", "Bad type annotation. missing closing ]"); 
 }
public void testParseArrayTypeError7522() throws Exception { 
     parse("@type {[(number,boolean,Object?])]}*/", "Bad type annotation. missing closing ]"); 
 }
public void testParseArrayType523() throws Exception { 
     JSDocInfo info = parse("@type {[number}*/"); 
     assertTypeEquals(registry.createOptionalType(NUMBER_TYPE), info.getType()); 
 }
public void testParseRecordType7524() throws Exception { 
     parseFull("/** @param {{'x' : !hello}} n\n*/"); 
 }
public void testParseSuppressions819() throws Exception { 
     JSDocInfo info = parse("@param {SomeType} name somedescription \n" + "* @param {AnotherType} anothername des */", true); 
     assertTypeInMarker(assertNameInMarker(assertAnnotationMarker(info, "param", 0, 0, 0), "name", 0, 18), "SomeType", 0, 7, 0, 16, true); 
     assertTypeInMarker(assertNameInMarker(assertAnnotationMarker(info, "param", 1, 2, 1), "anothername", 1, 23), "AnotherType", 1, 9, 1, 21, true); 
 }
public void testParseJavaDispatch3823() throws Exception { 
     assertNull(parseFileOverview("@javadispatch*/")); 
 }
public void testParseUnionType9825() throws Exception { 
     JSDocInfo info = parse("@type {Array.<boolean>||null}*/"); 
     assertTypeEquals(createUnionType(parameterize(ARRAY_TYPE, BOOLEAN_TYPE), NULL_TYPE), info.getType()); 
 }
public void testParseNoSideEffects826() throws Exception { 
     parse("@noSideEffects\n@noSideEffects*/", "extra @noSideEffects tag"); 
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