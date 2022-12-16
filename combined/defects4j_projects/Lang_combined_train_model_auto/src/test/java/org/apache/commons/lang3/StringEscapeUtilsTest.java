/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.junit.Test;

/**
 * Unit tests for {@link StringEscapeUtils}.
 *
 * @version $Id$
 */
public class StringEscapeUtilsTest {
    private final static String FOO = "foo";

@Test
public void testUnescapeHtml433() { 
     for (int i = 0; i < HTML_ESCAPES.length; ++i) { 
         final String message = HTML_ESCAPES[i][0]; 
         final String expected = HTML_ESCAPES[i][2]; 
         final String original = HTML_ESCAPES[i][1]; 
         assertEquals(message, expected, StringEscapeUtils.unescapeHtml4(original)); 
         final StringWriter sw = new StringWriter(); 
         try { 
             StringEscapeUtils.UNESCAPE_HTML4.translate(original, sw); 
         } catch (final IOException e) { 
         } 
         final String actual = original == null ? null : sw.toString(); 
         assertEquals(message, expected, actual); 
     } 
     assertEquals("funny chars pass through OK", "Fran\u00E7ais", StringEscapeUtils.unescapeHtml4("Fran\u00E7ais")); 
     assertEquals("Hello&;World", StringEscapeUtils.unescapeHtml4("Hello&;World")); 
     assertEquals("Hello&#;World", StringEscapeUtils.unescapeHtml4("Hello&#;World")); 
     assertEquals("Hello&# ;World", StringEscapeUtils.unescapeHtml4("Hello&# ;World")); 
     assertEquals("Hello&##;World", StringEscapeUtils.unescapeHtml4("Hello&##;World")); 
 }
@Test
public void testEscapeXmlAllCharacters112() { 
     final CharSequenceTranslator escapeXml = StringEscapeUtils.ESCAPE_XML.with(NumericEntityEscaper.below(9), NumericEntityEscaper.between(0xB, 0xC), NumericEntityEscaper.between(0xE, 0x19), NumericEntityEscaper.between(0xD800, 0xDFFF), NumericEntityEscaper.between(0xFFFE, 0xFFFF), NumericEntityEscaper.above(0x110000)); 
     assertEquals("&#0;&#1;&#2;&#3;&#4;&#5;&#6;&#7;&#8;", escapeXml.translate("\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\u0008")); 
     assertEquals("\t", escapeXml.translate("\t")); 
     assertEquals("\n", escapeXml.translate("\n")); 
     assertEquals("&#11;&#12;", escapeXml.translate("\u000B\u000C")); 
     assertEquals("\r", escapeXml.translate("\r")); 
     assertEquals("Hello World! Ain&apos;t this great?", escapeXml.translate("Hello World! Ain't this great?")); 
     assertEquals("&#14;&#15;&#24;&#25;", escapeXml.translate("\u000E\u000F\u0018\u0019")); 
 }
@Test
public void testUnescapeCsvWriter246() throws Exception { 
     checkCsvUnescapeWriter("foo.bar", "foo.bar"); 
     checkCsvUnescapeWriter("foo,bar", "\"foo,bar\""); 
     checkCsvUnescapeWriter("foo\nbar", "\"foo\nbar\""); 
     checkCsvUnescapeWriter("foo\rbar", "\"foo\rbar\""); 
     checkCsvUnescapeWriter("foo\"bar", "\"foo\"\"bar\""); 
     checkCsvUnescapeWriter("", null); 
     checkCsvUnescapeWriter("", ""); 
     checkCsvUnescapeWriter("\"foo.bar\"", "\"foo.bar\""); 
 }
@Test
public void testEscapeCsvWriter500() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 }
@Test
public void testConstructor595() { 
     assertNotNull(new StringEscapeUtils()); 
     final Constructor<?>[] cons = StringEscapeUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(StringEscapeUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(StringEscapeUtils.class.getModifiers())); 
 }
@Test
public void testEscapeEcmaScript661() { 
     assertEquals(null, StringEscapeUtils.escapeEcmaScript(null)); 
     try { 
         StringEscapeUtils.ESCAPE_ECMASCRIPT.translate(null, null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         StringEscapeUtils.ESCAPE_ECMASCRIPT.translate("", null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEquals("He didn\\'t say, \\\"stop!\\\"", StringEscapeUtils.escapeEcmaScript("He didn't say, \"stop!\"")); 
     assertEquals("document.getElementById(\\\"test\\\").value = \\'<script>alert(\\'aaa\\');<\\/script>\\';", StringEscapeUtils.escapeEcmaScript("document.getElementById(\"test\").value = '<script>alert('aaa');</script>';")); 
 }
@Test
public void testUnescapeXmlSupplementaryCharacters699() { 
     assertEquals("Supplementary character must be represented using a single escape", "\uD84C\uDFB4", StringEscapeUtils.unescapeXml("&#144308;")); 
 }
@Test
public void testEscapeJavaWithSlash839() { 
     final String input = "String with a slash (/) in it"; 
     final String expected = input; 
     final String actual = StringEscapeUtils.escapeJava(input); 
     assertEquals(expected, actual); 
 }
@Test
public void testEscapeCsvString935() throws Exception { 
     assertEquals("foo.bar", StringEscapeUtils.escapeCsv("foo.bar")); 
     assertEquals("\"foo,bar\"", StringEscapeUtils.escapeCsv("foo,bar")); 
     assertEquals("\"foo\nbar\"", StringEscapeUtils.escapeCsv("foo\nbar")); 
     assertEquals("\"foo\rbar\"", StringEscapeUtils.escapeCsv("foo\rbar")); 
     assertEquals("\"foo\"\"bar\"", StringEscapeUtils.escapeCsv("foo\"bar")); 
     assertEquals("", StringEscapeUtils.escapeCsv("")); 
     assertEquals(null, StringEscapeUtils.escapeCsv(null)); 
 }
@Test
public void testUnescapeJava986() throws IOException { 
     assertEquals(null, StringEscapeUtils.unescapeJava(null)); 
     try { 
         StringEscapeUtils.UNESCAPE_JAVA.translate(null, null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         StringEscapeUtils.UNESCAPE_JAVA.translate("", null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         StringEscapeUtils.unescapeJava("\\u02-3"); 
         fail(); 
     } catch (final RuntimeException ex) { 
     } 
     assertUnescapeJava("", ""); 
     assertUnescapeJava("test", "test"); 
     assertUnescapeJava("\ntest\b", "\\ntest\\b"); 
     assertUnescapeJava("\u123425foo\ntest\b", "\\u123425foo\\ntest\\b"); 
     assertUnescapeJava("'\foo\teste\r", "\\'\\foo\\teste\\r"); 
     assertUnescapeJava("", "\\"); 
     assertUnescapeJava("lowercase Unicode", "\uABCDx", "\\uabcdx"); 
     assertUnescapeJava("uppercase Unicode", "\uABCDx", "\\uABCDx"); 
     assertUnescapeJava("Unicode as final character", "\uABCD", "\\uabcd"); 
 }
@Test
public void testEscapeJson1033() { 
     assertEquals(null, StringEscapeUtils.escapeJson(null)); 
     try { 
         StringEscapeUtils.ESCAPE_JSON.translate(null, null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         StringEscapeUtils.ESCAPE_JSON.translate("", null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEquals("He didn't say, \\\"stop!\\\"", StringEscapeUtils.escapeJson("He didn't say, \"stop!\"")); 
     String expected = "\\\"foo\\\" isn't \\\"bar\\\". specials: \\b\\r\\n\\f\\t\\\\\\/"; 
     String input = "\"foo\" isn't \"bar\". specials: \b\r\n\f\t\\/"; 
     assertEquals(expected, StringEscapeUtils.escapeJson(input)); 
 }
@Test
public void testLang7201090() { 
     final String input = new StringBuilder("\ud842\udfb7").append("A").toString(); 
     final String escaped = StringEscapeUtils.escapeXml(input); 
     assertEquals(input, escaped); 
 }
@Test
public void testEscapeHtmlVersions1161() throws Exception { 
     assertEquals("&Beta;", StringEscapeUtils.escapeHtml4("\u0392")); 
     assertEquals("\u0392", StringEscapeUtils.unescapeHtml4("&Beta;")); 
 }
@Test
public void testUnescapeCsvString1184() throws Exception { 
     assertEquals("foo.bar", StringEscapeUtils.unescapeCsv("foo.bar")); 
     assertEquals("foo,bar", StringEscapeUtils.unescapeCsv("\"foo,bar\"")); 
     assertEquals("foo\nbar", StringEscapeUtils.unescapeCsv("\"foo\nbar\"")); 
     assertEquals("foo\rbar", StringEscapeUtils.unescapeCsv("\"foo\rbar\"")); 
     assertEquals("foo\"bar", StringEscapeUtils.unescapeCsv("\"foo\"\"bar\"")); 
     assertEquals("", StringEscapeUtils.unescapeCsv("")); 
     assertEquals(null, StringEscapeUtils.unescapeCsv(null)); 
     assertEquals("\"foo.bar\"", StringEscapeUtils.unescapeCsv("\"foo.bar\"")); 
 }
@Test
public void testEscapeJava1268() throws IOException { 
     assertEquals(null, StringEscapeUtils.escapeJava(null)); 
     try { 
         StringEscapeUtils.ESCAPE_JAVA.translate(null, null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         StringEscapeUtils.ESCAPE_JAVA.translate("", null); 
         fail(); 
     } catch (final IOException ex) { 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEscapeJava("empty string", "", ""); 
     assertEscapeJava(FOO, FOO); 
     assertEscapeJava("tab", "\\t", "\t"); 
     assertEscapeJava("backslash", "\\\\", "\\"); 
     assertEscapeJava("single quote should not be escaped", "'", "'"); 
     assertEscapeJava("\\\\\\b\\t\\r", "\\\b\t\r"); 
     assertEscapeJava("\\u1234", "\u1234"); 
     assertEscapeJava("\\u0234", "\u0234"); 
     assertEscapeJava("\\u00EF", "\u00ef"); 
     assertEscapeJava("\\u0001", "\u0001"); 
     assertEscapeJava("Should use capitalized Unicode hex", "\\uABCD", "\uabcd"); 
     assertEscapeJava("He didn't say, \\\"stop!\\\"", "He didn't say, \"stop!\""); 
     assertEscapeJava("non-breaking space", "This space is non-breaking:" + "\\u00A0", "This space is non-breaking:\u00a0"); 
     assertEscapeJava("\\uABCD\\u1234\\u012C", "\uABCD\u1234\u012C"); 
 }
    
    
    

    /**
     * Tests https://issues.apache.org/jira/browse/LANG-421
     */
    
    
    private void assertEscapeJava(final String escaped, final String original) throws IOException {
        assertEscapeJava(null, escaped, original);
    }

    private void assertEscapeJava(String message, final String expected, final String original) throws IOException {
        final String converted = StringEscapeUtils.escapeJava(original);
        message = "escapeJava(String) failed" + (message == null ? "" : (": " + message));
        assertEquals(message, expected, converted);

        final StringWriter writer = new StringWriter();
        StringEscapeUtils.ESCAPE_JAVA.translate(original, writer);
        assertEquals(expected, writer.toString());
    }

    

    private void assertUnescapeJava(final String unescaped, final String original) throws IOException {
        assertUnescapeJava(null, unescaped, original);
    }

    private void assertUnescapeJava(final String message, final String unescaped, final String original) throws IOException {
        final String expected = unescaped;
        final String actual = StringEscapeUtils.unescapeJava(original);

        assertEquals("unescape(String) failed" +
                (message == null ? "" : (": " + message)) +
                ": expected '" + StringEscapeUtils.escapeJava(expected) +
                // we escape this so we can see it in the error message
                "' actual '" + StringEscapeUtils.escapeJava(actual) + "'",
                expected, actual);

        final StringWriter writer = new StringWriter();
        StringEscapeUtils.UNESCAPE_JAVA.translate(original, writer);
        assertEquals(unescaped, writer.toString());

    }

    


    // HTML and XML
    //--------------------------------------------------------------

    private static final String[][] HTML_ESCAPES = {
        {"no escaping", "plain text", "plain text"},
        {"no escaping", "plain text", "plain text"},
        {"empty string", "", ""},
        {"null", null, null},
        {"ampersand", "bread &amp; butter", "bread & butter"},
        {"quotes", "&quot;bread&quot; &amp; butter", "\"bread\" & butter"},
        {"final character only", "greater than &gt;", "greater than >"},
        {"first character only", "&lt; less than", "< less than"},
        {"apostrophe", "Huntington's chorea", "Huntington's chorea"},
        {"languages", "English,Fran&ccedil;ais,\u65E5\u672C\u8A9E (nihongo)", "English,Fran\u00E7ais,\u65E5\u672C\u8A9E (nihongo)"},
        {"8-bit ascii shouldn't number-escape", "\u0080\u009F", "\u0080\u009F"},
    };

    

    

    

    

    

    

    /**
     * Tests Supplementary characters. 
     * <p>
     * From http://www.w3.org/International/questions/qa-escapes
     * </p>
     * <blockquote>
     * Supplementary characters are those Unicode characters that have code points higher than the characters in
     * the Basic Multilingual Plane (BMP). In UTF-16 a supplementary character is encoded using two 16-bit surrogate code points from the
     * BMP. Because of this, some people think that supplementary characters need to be represented using two escapes, but this is incorrect
     * - you must use the single, code point value for that character. For example, use &#x233B4; rather than &#xD84C;&#xDFB4;.
     * </blockquote>
     * @see <a href="http://www.w3.org/International/questions/qa-escapes">Using character escapes in markup and CSS</a>
     * @see <a href="https://issues.apache.org/jira/browse/LANG-728">LANG-728</a>
     */
    
    
    
    
    /**
     * Reverse of the above.
     *
     * @see <a href="https://issues.apache.org/jira/browse/LANG-729">LANG-729</a>
     */
    
        
    // Tests issue #38569
    // http://issues.apache.org/bugzilla/show_bug.cgi?id=38569
    

    

    

    

    private void checkCsvEscapeWriter(final String expected, final String value) {
        try {
            final StringWriter writer = new StringWriter();
            StringEscapeUtils.ESCAPE_CSV.translate(value, writer);
            assertEquals(expected, writer.toString());
        } catch (final IOException e) {
            fail("Threw: " + e);
        }
    }

    

    

    private void checkCsvUnescapeWriter(final String expected, final String value) {
        try {
            final StringWriter writer = new StringWriter();
            StringEscapeUtils.UNESCAPE_CSV.translate(value, writer);
            assertEquals(expected, writer.toString());
        } catch (final IOException e) {
            fail("Threw: " + e);
        }
    }

    /**
     * Tests // https://issues.apache.org/jira/browse/LANG-480
     * 
     * @throws java.io.UnsupportedEncodingException
     */
    

    /**
     * Tests https://issues.apache.org/jira/browse/LANG-339
     */
    

    /**
     * Tests https://issues.apache.org/jira/browse/LANG-708
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    

    /**
     * Tests https://issues.apache.org/jira/browse/LANG-720
     */
    

    

}
