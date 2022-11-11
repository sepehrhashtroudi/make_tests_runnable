@Test 
 public void testSupplementary171() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testBelow248() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the below method", "&#65;&#68;FGZ", result); 
 } 
@Test 
 public void testBetween356() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the between method", "AD&#70;&#71;Z", result); 
 } 
@Test 
 public void testSupplementary1444() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementary1589() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementary1763() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testBelow2592() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the below method", "&#65;&#68;FGZ", result); 
 } 
@Test 
 public void testBetween2762() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the between method", "AD&#70;&#71;Z", result); 
 } 
@Test 
 public void testSupplementary3065() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementary3491() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testBelow4279() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the below method", "&#65;&#68;FGZ", result); 
 } 
@Test 
 public void testSupplementary4477() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testAbove5245() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the above method", "ADF&#71;&#90;", result); 
 } 
@Test 
 public void testAbove5371() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.above('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the above method", "ADF&#71;&#90;", result); 
 } 
@Test 
 public void testSupplementary6011() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementary6851() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementary7167() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testBelow7490() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the below method", "&#65;&#68;FGZ", result); 
 } 
@Test 
 public void testSupplementary7969() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementary8162() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testBelow8440() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the below method", "&#65;&#68;FGZ", result); 
 } 
@Test 
 public void testBetween8960() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.between('F', 'L'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the between method", "AD&#70;&#71;Z", result); 
 } 
@Test 
 public void testSupplementary9132() { 
     final NumericEntityEscaper nee = new NumericEntityEscaper(); 
     final String input = "\uD803\uDC22"; 
     final String expected = "&#68642;"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testBelow9460() { 
     final NumericEntityEscaper nee = NumericEntityEscaper.below('F'); 
     final String input = "ADFGZ"; 
     final String result = nee.translate(input); 
     assertEquals("Failed to escape numeric entities via the below method", "&#65;&#68;FGZ", result); 
 } 
