@Test 
 public void testEscapeEcmaScript91() { 
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
 public void testEscapeCsvWriter591() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testEscapeXmlAllCharacters646() { 
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
 public void testEscapeJson727() { 
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
 public void testEscapeCsvString897() throws Exception { 
     assertEquals("foo.bar", StringEscapeUtils.escapeCsv("foo.bar")); 
     assertEquals("\"foo,bar\"", StringEscapeUtils.escapeCsv("foo,bar")); 
     assertEquals("\"foo\nbar\"", StringEscapeUtils.escapeCsv("foo\nbar")); 
     assertEquals("\"foo\rbar\"", StringEscapeUtils.escapeCsv("foo\rbar")); 
     assertEquals("\"foo\"\"bar\"", StringEscapeUtils.escapeCsv("foo\"bar")); 
     assertEquals("", StringEscapeUtils.escapeCsv("")); 
     assertEquals(null, StringEscapeUtils.escapeCsv(null)); 
 } 
@Test 
 public void testEscapeXml953() throws Exception { 
     assertEquals("&lt;abc&gt;", StringEscapeUtils.escapeXml("<abc>")); 
     assertEquals("<abc>", StringEscapeUtils.unescapeXml("&lt;abc&gt;")); 
     assertEquals("XML should not escape >0x7f values", "\u00A1", StringEscapeUtils.escapeXml("\u00A1")); 
     assertEquals("XML should be able to unescape >0x7f values", "\u00A0", StringEscapeUtils.unescapeXml("&#160;")); 
     assertEquals("XML should be able to unescape >0x7f values with one leading 0", "\u00A0", StringEscapeUtils.unescapeXml("&#0160;")); 
     assertEquals("XML should be able to unescape >0x7f values with two leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#00160;")); 
     assertEquals("XML should be able to unescape >0x7f values with three leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#000160;")); 
     assertEquals("ain't", StringEscapeUtils.unescapeXml("ain&apos;t")); 
     assertEquals("ain&apos;t", StringEscapeUtils.escapeXml("ain't")); 
     assertEquals("", StringEscapeUtils.escapeXml("")); 
     assertEquals(null, StringEscapeUtils.escapeXml(null)); 
     assertEquals(null, StringEscapeUtils.unescapeXml(null)); 
     StringWriter sw = new StringWriter(); 
     try { 
         StringEscapeUtils.ESCAPE_XML.translate("<abc>", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was escaped incorrectly", "&lt;abc&gt;", sw.toString()); 
     sw = new StringWriter(); 
     try { 
         StringEscapeUtils.UNESCAPE_XML.translate("&lt;abc&gt;", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was unescaped incorrectly", "<abc>", sw.toString()); 
 } 
@Test 
 public void testEscapeCsvWriter997() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testUnescapeCsvString1056() throws Exception { 
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
 public void testEscapeHiragana1062() { 
     final String original = "\u304B\u304C\u3068"; 
     final String escaped = StringEscapeUtils.escapeHtml4(original); 
     assertEquals("Hiragana character Unicode behaviour should not be being escaped by escapeHtml4", original, escaped); 
     final String unescaped = StringEscapeUtils.unescapeHtml4(escaped); 
     assertEquals("Hiragana character Unicode behaviour has changed - expected no unescaping", escaped, unescaped); 
 } 
@Test 
 public void testStandaloneAmphersand1101() { 
     assertEquals("<P&O>", StringEscapeUtils.unescapeHtml4("&lt;P&O&gt;")); 
     assertEquals("test & <", StringEscapeUtils.unescapeHtml4("test & &lt;")); 
     assertEquals("<P&O>", StringEscapeUtils.unescapeXml("&lt;P&O&gt;")); 
     assertEquals("test & <", StringEscapeUtils.unescapeXml("test & &lt;")); 
 } 
@Test 
 public void testUnescapeCsvString1266() throws Exception { 
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
 public void testUnescapeCsvString1528() throws Exception { 
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
 public void testEscapeJava1982() throws IOException { 
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
@Test 
 public void testUnescapeCsvString2122() throws Exception { 
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
 public void testEscapeCsvWriter2192() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testEscapeJson2583() { 
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
 public void testEscapeXmlAllCharacters2641() { 
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
 public void testEscapeJson2662() { 
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
 public void testEscapeXml2665() throws Exception { 
     assertEquals("&lt;abc&gt;", StringEscapeUtils.escapeXml("<abc>")); 
     assertEquals("<abc>", StringEscapeUtils.unescapeXml("&lt;abc&gt;")); 
     assertEquals("XML should not escape >0x7f values", "\u00A1", StringEscapeUtils.escapeXml("\u00A1")); 
     assertEquals("XML should be able to unescape >0x7f values", "\u00A0", StringEscapeUtils.unescapeXml("&#160;")); 
     assertEquals("XML should be able to unescape >0x7f values with one leading 0", "\u00A0", StringEscapeUtils.unescapeXml("&#0160;")); 
     assertEquals("XML should be able to unescape >0x7f values with two leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#00160;")); 
     assertEquals("XML should be able to unescape >0x7f values with three leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#000160;")); 
     assertEquals("ain't", StringEscapeUtils.unescapeXml("ain&apos;t")); 
     assertEquals("ain&apos;t", StringEscapeUtils.escapeXml("ain't")); 
     assertEquals("", StringEscapeUtils.escapeXml("")); 
     assertEquals(null, StringEscapeUtils.escapeXml(null)); 
     assertEquals(null, StringEscapeUtils.unescapeXml(null)); 
     StringWriter sw = new StringWriter(); 
     try { 
         StringEscapeUtils.ESCAPE_XML.translate("<abc>", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was escaped incorrectly", "&lt;abc&gt;", sw.toString()); 
     sw = new StringWriter(); 
     try { 
         StringEscapeUtils.UNESCAPE_XML.translate("&lt;abc&gt;", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was unescaped incorrectly", "<abc>", sw.toString()); 
 } 
@Test 
 public void testUnescapeCsvString2912() throws Exception { 
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
 public void testUnescapeCsvString3203() throws Exception { 
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
 public void testEscapeJson3262() { 
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
 public void testUnescapeCsvString3363() throws Exception { 
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
 public void testEscapeJson3814() { 
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
 public void testEscapeXmlAllCharacters3956() { 
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
 public void testEscapeJava4171() throws IOException { 
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
@Test 
 public void testUnescapeHtml44173() { 
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
 public void testEscapeJava4763() throws IOException { 
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
@Test 
 public void testUnescapeCsvString4817() throws Exception { 
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
 public void testEscapeXmlAllCharacters5370() { 
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
 public void testEscapeXml5681() throws Exception { 
     assertEquals("&lt;abc&gt;", StringEscapeUtils.escapeXml("<abc>")); 
     assertEquals("<abc>", StringEscapeUtils.unescapeXml("&lt;abc&gt;")); 
     assertEquals("XML should not escape >0x7f values", "\u00A1", StringEscapeUtils.escapeXml("\u00A1")); 
     assertEquals("XML should be able to unescape >0x7f values", "\u00A0", StringEscapeUtils.unescapeXml("&#160;")); 
     assertEquals("XML should be able to unescape >0x7f values with one leading 0", "\u00A0", StringEscapeUtils.unescapeXml("&#0160;")); 
     assertEquals("XML should be able to unescape >0x7f values with two leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#00160;")); 
     assertEquals("XML should be able to unescape >0x7f values with three leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#000160;")); 
     assertEquals("ain't", StringEscapeUtils.unescapeXml("ain&apos;t")); 
     assertEquals("ain&apos;t", StringEscapeUtils.escapeXml("ain't")); 
     assertEquals("", StringEscapeUtils.escapeXml("")); 
     assertEquals(null, StringEscapeUtils.escapeXml(null)); 
     assertEquals(null, StringEscapeUtils.unescapeXml(null)); 
     StringWriter sw = new StringWriter(); 
     try { 
         StringEscapeUtils.ESCAPE_XML.translate("<abc>", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was escaped incorrectly", "&lt;abc&gt;", sw.toString()); 
     sw = new StringWriter(); 
     try { 
         StringEscapeUtils.UNESCAPE_XML.translate("&lt;abc&gt;", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was unescaped incorrectly", "<abc>", sw.toString()); 
 } 
@Test 
 public void testEscapeJava5975() throws IOException { 
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
@Test 
 public void testEscapeCsvWriter6041() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testEscapeJson6085() { 
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
 public void testUnescapeJava6354() throws IOException { 
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
 public void testEscapeJava6362() throws IOException { 
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
@Test 
 public void testEscapeCsvString6429() throws Exception { 
     assertEquals("foo.bar", StringEscapeUtils.escapeCsv("foo.bar")); 
     assertEquals("\"foo,bar\"", StringEscapeUtils.escapeCsv("foo,bar")); 
     assertEquals("\"foo\nbar\"", StringEscapeUtils.escapeCsv("foo\nbar")); 
     assertEquals("\"foo\rbar\"", StringEscapeUtils.escapeCsv("foo\rbar")); 
     assertEquals("\"foo\"\"bar\"", StringEscapeUtils.escapeCsv("foo\"bar")); 
     assertEquals("", StringEscapeUtils.escapeCsv("")); 
     assertEquals(null, StringEscapeUtils.escapeCsv(null)); 
 } 
@Test 
 public void testEscapeJson6450() { 
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
 public void testEscapeCsvWriter6643() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testUnescapeCsvString6740() throws Exception { 
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
 public void testEscapeXml6788() throws Exception { 
     assertEquals("&lt;abc&gt;", StringEscapeUtils.escapeXml("<abc>")); 
     assertEquals("<abc>", StringEscapeUtils.unescapeXml("&lt;abc&gt;")); 
     assertEquals("XML should not escape >0x7f values", "\u00A1", StringEscapeUtils.escapeXml("\u00A1")); 
     assertEquals("XML should be able to unescape >0x7f values", "\u00A0", StringEscapeUtils.unescapeXml("&#160;")); 
     assertEquals("XML should be able to unescape >0x7f values with one leading 0", "\u00A0", StringEscapeUtils.unescapeXml("&#0160;")); 
     assertEquals("XML should be able to unescape >0x7f values with two leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#00160;")); 
     assertEquals("XML should be able to unescape >0x7f values with three leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#000160;")); 
     assertEquals("ain't", StringEscapeUtils.unescapeXml("ain&apos;t")); 
     assertEquals("ain&apos;t", StringEscapeUtils.escapeXml("ain't")); 
     assertEquals("", StringEscapeUtils.escapeXml("")); 
     assertEquals(null, StringEscapeUtils.escapeXml(null)); 
     assertEquals(null, StringEscapeUtils.unescapeXml(null)); 
     StringWriter sw = new StringWriter(); 
     try { 
         StringEscapeUtils.ESCAPE_XML.translate("<abc>", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was escaped incorrectly", "&lt;abc&gt;", sw.toString()); 
     sw = new StringWriter(); 
     try { 
         StringEscapeUtils.UNESCAPE_XML.translate("&lt;abc&gt;", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was unescaped incorrectly", "<abc>", sw.toString()); 
 } 
@Test 
 public void testEscapeXmlAllCharacters6799() { 
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
 public void testEscapeXml6808() throws Exception { 
     assertEquals("&lt;abc&gt;", StringEscapeUtils.escapeXml("<abc>")); 
     assertEquals("<abc>", StringEscapeUtils.unescapeXml("&lt;abc&gt;")); 
     assertEquals("XML should not escape >0x7f values", "\u00A1", StringEscapeUtils.escapeXml("\u00A1")); 
     assertEquals("XML should be able to unescape >0x7f values", "\u00A0", StringEscapeUtils.unescapeXml("&#160;")); 
     assertEquals("XML should be able to unescape >0x7f values with one leading 0", "\u00A0", StringEscapeUtils.unescapeXml("&#0160;")); 
     assertEquals("XML should be able to unescape >0x7f values with two leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#00160;")); 
     assertEquals("XML should be able to unescape >0x7f values with three leading 0s", "\u00A0", StringEscapeUtils.unescapeXml("&#000160;")); 
     assertEquals("ain't", StringEscapeUtils.unescapeXml("ain&apos;t")); 
     assertEquals("ain&apos;t", StringEscapeUtils.escapeXml("ain't")); 
     assertEquals("", StringEscapeUtils.escapeXml("")); 
     assertEquals(null, StringEscapeUtils.escapeXml(null)); 
     assertEquals(null, StringEscapeUtils.unescapeXml(null)); 
     StringWriter sw = new StringWriter(); 
     try { 
         StringEscapeUtils.ESCAPE_XML.translate("<abc>", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was escaped incorrectly", "&lt;abc&gt;", sw.toString()); 
     sw = new StringWriter(); 
     try { 
         StringEscapeUtils.UNESCAPE_XML.translate("&lt;abc&gt;", sw); 
     } catch (final IOException e) { 
     } 
     assertEquals("XML was unescaped incorrectly", "<abc>", sw.toString()); 
 } 
@Test 
 public void testUnescapeCsvString6869() throws Exception { 
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
 public void testUnescapeCsvString7342() throws Exception { 
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
 public void testEscapeJson7398() { 
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
 public void testEscapeHtml7523() { 
     for (int i = 0; i < HTML_ESCAPES.length; ++i) { 
         final String message = HTML_ESCAPES[i][0]; 
         final String expected = HTML_ESCAPES[i][1]; 
         final String original = HTML_ESCAPES[i][2]; 
         assertEquals(message, expected, StringEscapeUtils.escapeHtml4(original)); 
         final StringWriter sw = new StringWriter(); 
         try { 
             StringEscapeUtils.ESCAPE_HTML4.translate(original, sw); 
         } catch (final IOException e) { 
         } 
         final String actual = original == null ? null : sw.toString(); 
         assertEquals(message, expected, actual); 
     } 
 } 
@Test 
 public void testUnescapeCsvString7659() throws Exception { 
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
 public void testEscapeHiragana7785() { 
     final String original = "\u304B\u304C\u3068"; 
     final String escaped = StringEscapeUtils.escapeHtml4(original); 
     assertEquals("Hiragana character Unicode behaviour should not be being escaped by escapeHtml4", original, escaped); 
     final String unescaped = StringEscapeUtils.unescapeHtml4(escaped); 
     assertEquals("Hiragana character Unicode behaviour has changed - expected no unescaping", escaped, unescaped); 
 } 
@Test 
 public void testEscapeCsvWriter7946() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testEscapeEcmaScript8186() { 
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
 public void testUnescapeJava9145() throws IOException { 
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
 public void testConstructor9176() { 
     assertNotNull(new StringEscapeUtils()); 
     final Constructor<?>[] cons = StringEscapeUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(StringEscapeUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(StringEscapeUtils.class.getModifiers())); 
 } 
@Test 
 public void testEscapeXmlAllCharacters9181() { 
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
 public void testEscapeCsvWriter9192() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testUnescapeJava9261() throws IOException { 
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
 public void testStandaloneAmphersand9306() { 
     assertEquals("<P&O>", StringEscapeUtils.unescapeHtml4("&lt;P&O&gt;")); 
     assertEquals("test & <", StringEscapeUtils.unescapeHtml4("test & &lt;")); 
     assertEquals("<P&O>", StringEscapeUtils.unescapeXml("&lt;P&O&gt;")); 
     assertEquals("test & <", StringEscapeUtils.unescapeXml("test & &lt;")); 
 } 
@Test 
 public void testEscapeXmlAllCharacters9362() { 
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
 public void testEscapeCsvWriter9432() throws Exception { 
     checkCsvEscapeWriter("foo.bar", "foo.bar"); 
     checkCsvEscapeWriter("\"foo,bar\"", "foo,bar"); 
     checkCsvEscapeWriter("\"foo\nbar\"", "foo\nbar"); 
     checkCsvEscapeWriter("\"foo\rbar\"", "foo\rbar"); 
     checkCsvEscapeWriter("\"foo\"\"bar\"", "foo\"bar"); 
     checkCsvEscapeWriter("", null); 
     checkCsvEscapeWriter("", ""); 
 } 
@Test 
 public void testConstructor9448() { 
     assertNotNull(new StringEscapeUtils()); 
     final Constructor<?>[] cons = StringEscapeUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(StringEscapeUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(StringEscapeUtils.class.getModifiers())); 
 } 
@Test 
 public void testEscapeJson9555() { 
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
