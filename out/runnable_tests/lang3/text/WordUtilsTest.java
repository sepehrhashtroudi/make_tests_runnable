@Test 
 public void testCapitalize_String60() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testWrap_StringInt130() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testSwapCase_String330() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringInt423() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testCapitalizeFully_String621() { 
     assertEquals(null, WordUtils.capitalizeFully(null)); 
     assertEquals("", WordUtils.capitalizeFully("")); 
     assertEquals("  ", WordUtils.capitalizeFully("  ")); 
     assertEquals("I", WordUtils.capitalizeFully("I")); 
     assertEquals("I", WordUtils.capitalizeFully("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I Am Here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am HERE 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I AM HERE 123")); 
 } 
@Test 
 public void testCapitalize_String635() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testWrap_StringInt654() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt663() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testSwapCase_String778() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringIntStringBoolean819() { 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", false)); 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, false)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, true)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", true)); 
     assertEquals("", WordUtils.wrap("", 20, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, null, true)); 
     assertEquals("", WordUtils.wrap("", -1, null, false)); 
     assertEquals("", WordUtils.wrap("", -1, null, true)); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of<br />text that is going<br />to be wrapped after<br />20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", true)); 
     input = "Here is one line"; 
     expected = "Here\nis one\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 6, "\n", false)); 
     expected = "Here\nis\none\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 2, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, -1, "\n", false)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, null, false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, null, true)); 
     input = " Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns."; 
     expected = "Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is\tone line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of\ttext that is going to be wrapped after 20 columns."; 
     expected = "Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apach\ne.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here,\nhttp://jakarta.apache.org,\nto jump to the\njakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here,\nhttp://jakarta.apach\ne.org, to jump to\nthe jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String889() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testInitials_String_charArray1004() { 
     char[] array = null; 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJ", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJ.L", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KO", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = new char[0]; 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("", WordUtils.initials("I", array)); 
     assertEquals("", WordUtils.initials("i", array)); 
     assertEquals("", WordUtils.initials("SJC", array)); 
     assertEquals("", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("", WordUtils.initials("i am here 123", array)); 
     array = " ".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJ", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJ.L", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KO", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = " .".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJL", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJL", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KO", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = " .'".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals("", WordUtils.initials("  ", array)); 
     assertEquals("I", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("S", WordUtils.initials("SJC", array)); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("BJL", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals("BJL", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("KOM", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("iah1", WordUtils.initials("i am here 123", array)); 
     array = "SIJo1".toCharArray(); 
     assertEquals(null, WordUtils.initials(null, array)); 
     assertEquals("", WordUtils.initials("", array)); 
     assertEquals(" ", WordUtils.initials("  ", array)); 
     assertEquals("", WordUtils.initials("I", array)); 
     assertEquals("i", WordUtils.initials("i", array)); 
     assertEquals("C", WordUtils.initials("SJC", array)); 
     assertEquals("Bh", WordUtils.initials("Ben John Lee", array)); 
     assertEquals("B.", WordUtils.initials("Ben J.Lee", array)); 
     assertEquals(" h", WordUtils.initials(" Ben   John  . Lee", array)); 
     assertEquals("K", WordUtils.initials("Kay O'Murphy", array)); 
     assertEquals("i2", WordUtils.initials("i am here 123", array)); 
 } 
@Test 
 public void testCapitalize_String1073() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String1233() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testCapitalize_String1430() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testSwapCase_String1728() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testCapitalizeFullyWithDelimiters_String1753() { 
     assertEquals(null, WordUtils.capitalizeFully(null, null)); 
     assertEquals("", WordUtils.capitalizeFully("", new char[0])); 
     assertEquals("  ", WordUtils.capitalizeFully("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("I", WordUtils.capitalizeFully("I", chars)); 
     assertEquals("I", WordUtils.capitalizeFully("i", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("i-am here+123", chars)); 
     assertEquals("I Am+Here-123", WordUtils.capitalizeFully("I Am+Here-123", chars)); 
     assertEquals("I+Am-Here 123", WordUtils.capitalizeFully("i+am-HERE 123", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("I-AM HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("I am.Fine", WordUtils.capitalizeFully("i aM.fine", chars)); 
     assertEquals("I Am.fine", WordUtils.capitalizeFully("i am.fine", null)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String2029() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testCapitalize_String2296() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testCapitalizeFullyWithDelimiters_String2786() { 
     assertEquals(null, WordUtils.capitalizeFully(null, null)); 
     assertEquals("", WordUtils.capitalizeFully("", new char[0])); 
     assertEquals("  ", WordUtils.capitalizeFully("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("I", WordUtils.capitalizeFully("I", chars)); 
     assertEquals("I", WordUtils.capitalizeFully("i", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("i-am here+123", chars)); 
     assertEquals("I Am+Here-123", WordUtils.capitalizeFully("I Am+Here-123", chars)); 
     assertEquals("I+Am-Here 123", WordUtils.capitalizeFully("i+am-HERE 123", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("I-AM HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("I am.Fine", WordUtils.capitalizeFully("i aM.fine", chars)); 
     assertEquals("I Am.fine", WordUtils.capitalizeFully("i am.fine", null)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String2814() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testCapitalize_String2923() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testWrap_StringInt2931() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testSwapCase_String2992() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testCapitalizeFully_String3019() { 
     assertEquals(null, WordUtils.capitalizeFully(null)); 
     assertEquals("", WordUtils.capitalizeFully("")); 
     assertEquals("  ", WordUtils.capitalizeFully("  ")); 
     assertEquals("I", WordUtils.capitalizeFully("I")); 
     assertEquals("I", WordUtils.capitalizeFully("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I Am Here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am HERE 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I AM HERE 123")); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String3302() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testSwapCase_String3393() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testCapitalize_String3413() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testWrap_StringInt3455() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String3528() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testCapitalize_String3656() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testWrap_StringInt3692() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testSwapCase_String3755() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testSwapCase_String3768() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testSwapCase_String3845() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testSwapCase_String3968() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String3970() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testSwapCase_String4006() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringInt4188() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt4203() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt4219() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt4248() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String4352() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testSwapCase_String4494() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testSwapCase_String4573() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringInt4649() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testCapitalize_String4687() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testConstructor4699() { 
     assertNotNull(new WordUtils()); 
     final Constructor<?>[] cons = WordUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(WordUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(WordUtils.class.getModifiers())); 
 } 
@Test 
 public void testWrap_StringInt4837() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringIntStringBoolean4898() { 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", false)); 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, false)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, true)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", true)); 
     assertEquals("", WordUtils.wrap("", 20, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, null, true)); 
     assertEquals("", WordUtils.wrap("", -1, null, false)); 
     assertEquals("", WordUtils.wrap("", -1, null, true)); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of<br />text that is going<br />to be wrapped after<br />20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", true)); 
     input = "Here is one line"; 
     expected = "Here\nis one\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 6, "\n", false)); 
     expected = "Here\nis\none\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 2, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, -1, "\n", false)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, null, false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, null, true)); 
     input = " Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns."; 
     expected = "Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is\tone line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of\ttext that is going to be wrapped after 20 columns."; 
     expected = "Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apach\ne.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here,\nhttp://jakarta.apache.org,\nto jump to the\njakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here,\nhttp://jakarta.apach\ne.org, to jump to\nthe jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
 } 
@Test 
 public void testSwapCase_String4940() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringInt4981() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String5022() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testCapitalizeFullyWithDelimiters_String5027() { 
     assertEquals(null, WordUtils.capitalizeFully(null, null)); 
     assertEquals("", WordUtils.capitalizeFully("", new char[0])); 
     assertEquals("  ", WordUtils.capitalizeFully("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("I", WordUtils.capitalizeFully("I", chars)); 
     assertEquals("I", WordUtils.capitalizeFully("i", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("i-am here+123", chars)); 
     assertEquals("I Am+Here-123", WordUtils.capitalizeFully("I Am+Here-123", chars)); 
     assertEquals("I+Am-Here 123", WordUtils.capitalizeFully("i+am-HERE 123", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("I-AM HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("I am.Fine", WordUtils.capitalizeFully("i aM.fine", chars)); 
     assertEquals("I Am.fine", WordUtils.capitalizeFully("i am.fine", null)); 
 } 
@Test 
 public void testSwapCase_String5056() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringInt5216() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String5237() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testCapitalize_String5428() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testWrap_StringInt5659() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testUncapitalize_String5682() { 
     assertEquals(null, WordUtils.uncapitalize(null)); 
     assertEquals("", WordUtils.uncapitalize("")); 
     assertEquals("  ", WordUtils.uncapitalize("  ")); 
     assertEquals("i", WordUtils.uncapitalize("I")); 
     assertEquals("i", WordUtils.uncapitalize("i")); 
     assertEquals("i am here 123", WordUtils.uncapitalize("i am here 123")); 
     assertEquals("i am here 123", WordUtils.uncapitalize("I Am Here 123")); 
     assertEquals("i am hERE 123", WordUtils.uncapitalize("i am HERE 123")); 
     assertEquals("i aM hERE 123", WordUtils.uncapitalize("I AM HERE 123")); 
 } 
@Test 
 public void testSwapCase_String5734() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String5769() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testWrap_StringInt5958() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt6003() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt6055() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt6080() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testCapitalize_String6130() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testWrap_StringInt6163() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testUncapitalize_String6216() { 
     assertEquals(null, WordUtils.uncapitalize(null)); 
     assertEquals("", WordUtils.uncapitalize("")); 
     assertEquals("  ", WordUtils.uncapitalize("  ")); 
     assertEquals("i", WordUtils.uncapitalize("I")); 
     assertEquals("i", WordUtils.uncapitalize("i")); 
     assertEquals("i am here 123", WordUtils.uncapitalize("i am here 123")); 
     assertEquals("i am here 123", WordUtils.uncapitalize("I Am Here 123")); 
     assertEquals("i am hERE 123", WordUtils.uncapitalize("i am HERE 123")); 
     assertEquals("i aM hERE 123", WordUtils.uncapitalize("I AM HERE 123")); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String6276() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testSwapCase_String6374() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringIntStringBoolean6467() { 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", false)); 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, false)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, true)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", true)); 
     assertEquals("", WordUtils.wrap("", 20, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, null, true)); 
     assertEquals("", WordUtils.wrap("", -1, null, false)); 
     assertEquals("", WordUtils.wrap("", -1, null, true)); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of<br />text that is going<br />to be wrapped after<br />20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", true)); 
     input = "Here is one line"; 
     expected = "Here\nis one\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 6, "\n", false)); 
     expected = "Here\nis\none\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 2, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, -1, "\n", false)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, null, false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, null, true)); 
     input = " Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns."; 
     expected = "Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is\tone line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of\ttext that is going to be wrapped after 20 columns."; 
     expected = "Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apach\ne.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here,\nhttp://jakarta.apache.org,\nto jump to the\njakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here,\nhttp://jakarta.apach\ne.org, to jump to\nthe jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String6596() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String6640() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testCapitalize_String6663() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testCapitalize_String6719() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testCapitalize_String6763() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testCapitalize_String6795() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String6848() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testWrap_StringIntStringBoolean6997() { 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", false)); 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, false)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, true)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", true)); 
     assertEquals("", WordUtils.wrap("", 20, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, null, true)); 
     assertEquals("", WordUtils.wrap("", -1, null, false)); 
     assertEquals("", WordUtils.wrap("", -1, null, true)); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of<br />text that is going<br />to be wrapped after<br />20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", true)); 
     input = "Here is one line"; 
     expected = "Here\nis one\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 6, "\n", false)); 
     expected = "Here\nis\none\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 2, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, -1, "\n", false)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, null, false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, null, true)); 
     input = " Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns."; 
     expected = "Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is\tone line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of\ttext that is going to be wrapped after 20 columns."; 
     expected = "Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apach\ne.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here,\nhttp://jakarta.apache.org,\nto jump to the\njakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here,\nhttp://jakarta.apach\ne.org, to jump to\nthe jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
 } 
@Test 
 public void testWrap_StringInt7021() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testConstructor7154() { 
     assertNotNull(new WordUtils()); 
     final Constructor<?>[] cons = WordUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(WordUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(WordUtils.class.getModifiers())); 
 } 
@Test 
 public void testSwapCase_String7155() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String7220() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testSwapCase_String7349() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testWrap_StringInt7353() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt7424() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testCapitalizeFullyWithDelimiters_String7528() { 
     assertEquals(null, WordUtils.capitalizeFully(null, null)); 
     assertEquals("", WordUtils.capitalizeFully("", new char[0])); 
     assertEquals("  ", WordUtils.capitalizeFully("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("I", WordUtils.capitalizeFully("I", chars)); 
     assertEquals("I", WordUtils.capitalizeFully("i", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("i-am here+123", chars)); 
     assertEquals("I Am+Here-123", WordUtils.capitalizeFully("I Am+Here-123", chars)); 
     assertEquals("I+Am-Here 123", WordUtils.capitalizeFully("i+am-HERE 123", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("I-AM HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("I am.Fine", WordUtils.capitalizeFully("i aM.fine", chars)); 
     assertEquals("I Am.fine", WordUtils.capitalizeFully("i am.fine", null)); 
 } 
@Test 
 public void testSwapCase_String7820() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
@Test 
 public void testCapitalize_String7842() { 
     assertEquals(null, WordUtils.capitalize(null)); 
     assertEquals("", WordUtils.capitalize("")); 
     assertEquals("  ", WordUtils.capitalize("  ")); 
     assertEquals("I", WordUtils.capitalize("I")); 
     assertEquals("I", WordUtils.capitalize("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalize("I Am Here 123")); 
     assertEquals("I Am HERE 123", WordUtils.capitalize("i am HERE 123")); 
     assertEquals("I AM HERE 123", WordUtils.capitalize("I AM HERE 123")); 
 } 
@Test 
 public void testCapitalizeFullyWithDelimiters_String7991() { 
     assertEquals(null, WordUtils.capitalizeFully(null, null)); 
     assertEquals("", WordUtils.capitalizeFully("", new char[0])); 
     assertEquals("  ", WordUtils.capitalizeFully("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("I", WordUtils.capitalizeFully("I", chars)); 
     assertEquals("I", WordUtils.capitalizeFully("i", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("i-am here+123", chars)); 
     assertEquals("I Am+Here-123", WordUtils.capitalizeFully("I Am+Here-123", chars)); 
     assertEquals("I+Am-Here 123", WordUtils.capitalizeFully("i+am-HERE 123", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("I-AM HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("I am.Fine", WordUtils.capitalizeFully("i aM.fine", chars)); 
     assertEquals("I Am.fine", WordUtils.capitalizeFully("i am.fine", null)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String8060() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testWrap_StringInt8376() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testCapitalizeFullyWithDelimiters_String8617() { 
     assertEquals(null, WordUtils.capitalizeFully(null, null)); 
     assertEquals("", WordUtils.capitalizeFully("", new char[0])); 
     assertEquals("  ", WordUtils.capitalizeFully("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("I", WordUtils.capitalizeFully("I", chars)); 
     assertEquals("I", WordUtils.capitalizeFully("i", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("i-am here+123", chars)); 
     assertEquals("I Am+Here-123", WordUtils.capitalizeFully("I Am+Here-123", chars)); 
     assertEquals("I+Am-Here 123", WordUtils.capitalizeFully("i+am-HERE 123", chars)); 
     assertEquals("I-Am Here+123", WordUtils.capitalizeFully("I-AM HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("I am.Fine", WordUtils.capitalizeFully("i aM.fine", chars)); 
     assertEquals("I Am.fine", WordUtils.capitalizeFully("i am.fine", null)); 
 } 
@Test 
 public void testWrap_StringInt8773() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt8794() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringInt9029() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testUncapitalizeWithDelimiters_String9040() { 
     assertEquals(null, WordUtils.uncapitalize(null, null)); 
     assertEquals("", WordUtils.uncapitalize("", new char[0])); 
     assertEquals("  ", WordUtils.uncapitalize("  ", new char[0])); 
     char[] chars = new char[] { '-', '+', ' ', '@' }; 
     assertEquals("i", WordUtils.uncapitalize("I", chars)); 
     assertEquals("i", WordUtils.uncapitalize("i", chars)); 
     assertEquals("i am-here+123", WordUtils.uncapitalize("i am-here+123", chars)); 
     assertEquals("i+am here-123", WordUtils.uncapitalize("I+Am Here-123", chars)); 
     assertEquals("i-am+hERE 123", WordUtils.uncapitalize("i-am+HERE 123", chars)); 
     assertEquals("i aM-hERE+123", WordUtils.uncapitalize("I AM-HERE+123", chars)); 
     chars = new char[] { '.' }; 
     assertEquals("i AM.fINE", WordUtils.uncapitalize("I AM.FINE", chars)); 
     assertEquals("i aM.FINE", WordUtils.uncapitalize("I AM.FINE", null)); 
 } 
@Test 
 public void testWrap_StringInt9059() { 
     assertEquals(null, WordUtils.wrap(null, 20)); 
     assertEquals(null, WordUtils.wrap(null, -1)); 
     assertEquals("", WordUtils.wrap("", 20)); 
     assertEquals("", WordUtils.wrap("", -1)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump" + systemNewLine + "to the jakarta" + systemNewLine + "website -" + systemNewLine + "http://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here," + systemNewLine + "http://jakarta.apache.org," + systemNewLine + "to jump to the" + systemNewLine + "jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20)); 
 } 
@Test 
 public void testWrap_StringIntStringBoolean9236() { 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", false)); 
     assertEquals(null, WordUtils.wrap(null, 20, "\n", true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, true)); 
     assertEquals(null, WordUtils.wrap(null, 20, null, false)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, true)); 
     assertEquals(null, WordUtils.wrap(null, -1, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", false)); 
     assertEquals("", WordUtils.wrap("", 20, "\n", true)); 
     assertEquals("", WordUtils.wrap("", 20, null, false)); 
     assertEquals("", WordUtils.wrap("", 20, null, true)); 
     assertEquals("", WordUtils.wrap("", -1, null, false)); 
     assertEquals("", WordUtils.wrap("", -1, null, true)); 
     String input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of<br />text that is going<br />to be wrapped after<br />20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "<br />", true)); 
     input = "Here is one line"; 
     expected = "Here\nis one\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 6, "\n", false)); 
     expected = "Here\nis\none\nline"; 
     assertEquals(expected, WordUtils.wrap(input, 2, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, -1, "\n", false)); 
     final String systemNewLine = System.getProperty("line.separator"); 
     input = "Here is one line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is one line of" + systemNewLine + "text that is going" + systemNewLine + "to be wrapped after" + systemNewLine + "20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, null, false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, null, true)); 
     input = " Here:  is  one  line  of  text  that  is  going  to  be  wrapped  after  20  columns."; 
     expected = "Here:  is  one  line\nof  text  that  is \ngoing  to  be \nwrapped  after  20 \ncolumns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is\tone line of text that is going to be wrapped after 20 columns."; 
     expected = "Here is\tone line of\ntext that is going\nto be wrapped after\n20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Here is one line of\ttext that is going to be wrapped after 20 columns."; 
     expected = "Here is one line\nof\ttext that is\ngoing to be wrapped\nafter 20 columns."; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here to jump to the jakarta website - http://jakarta.apache.org"; 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apache.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here to jump\nto the jakarta\nwebsite -\nhttp://jakarta.apach\ne.org"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
     input = "Click here, http://jakarta.apache.org, to jump to the jakarta website"; 
     expected = "Click here,\nhttp://jakarta.apache.org,\nto jump to the\njakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", false)); 
     expected = "Click here,\nhttp://jakarta.apach\ne.org, to jump to\nthe jakarta website"; 
     assertEquals(expected, WordUtils.wrap(input, 20, "\n", true)); 
 } 
@Test 
 public void testSwapCase_String9290() { 
     assertEquals(null, WordUtils.swapCase(null)); 
     assertEquals("", WordUtils.swapCase("")); 
     assertEquals("  ", WordUtils.swapCase("  ")); 
     assertEquals("i", WordUtils.swapCase("I")); 
     assertEquals("I", WordUtils.swapCase("i")); 
     assertEquals("I AM HERE 123", WordUtils.swapCase("i am here 123")); 
     assertEquals("i aM hERE 123", WordUtils.swapCase("I Am Here 123")); 
     assertEquals("I AM here 123", WordUtils.swapCase("i am HERE 123")); 
     assertEquals("i am here 123", WordUtils.swapCase("I AM HERE 123")); 
     final String test = "This String contains a TitleCase character: \u01C8"; 
     final String expect = "tHIS sTRING CONTAINS A tITLEcASE CHARACTER: \u01C9"; 
     assertEquals(expect, WordUtils.swapCase(test)); 
 } 
