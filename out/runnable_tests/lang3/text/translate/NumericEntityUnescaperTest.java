@Test 
 public void testOutOfBounds120() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testSupplementaryUnescaping574() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementaryUnescaping606() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementaryUnescaping1257() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementaryUnescaping1496() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testUnfinishedEntity1546() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testOutOfBounds1772() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testOutOfBounds1864() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testSupplementaryUnescaping2021() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testOutOfBounds2717() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testOutOfBounds2808() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testOutOfBounds3256() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testSupplementaryUnescaping3439() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testOutOfBounds3466() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testSupplementaryUnescaping3482() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testUnfinishedEntity3946() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testUnfinishedEntity4025() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testSupplementaryUnescaping4380() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testUnfinishedEntity4868() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testOutOfBounds4946() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testOutOfBounds4962() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testSupplementaryUnescaping5114() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementaryUnescaping5187() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementaryUnescaping5598() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testSupplementaryUnescaping5905() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testOutOfBounds6046() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testOutOfBounds6234() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testOutOfBounds6608() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testUnfinishedEntity6874() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testOutOfBounds7083() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testUnfinishedEntity7139() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testSupplementaryUnescaping7228() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testOutOfBounds7253() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testOutOfBounds7502() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     assertEquals("Failed to ignore when last character is &", "Test &", neu.translate("Test &")); 
     assertEquals("Failed to ignore when last character is &", "Test &#", neu.translate("Test &#")); 
     assertEquals("Failed to ignore when last character is &", "Test &#x", neu.translate("Test &#x")); 
     assertEquals("Failed to ignore when last character is &", "Test &#X", neu.translate("Test &#X")); 
 } 
@Test 
 public void testUnfinishedEntity7781() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testUnfinishedEntity7928() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testSupplementaryUnescaping8380() { 
     final NumericEntityUnescaper neu = new NumericEntityUnescaper(); 
     final String input = "&#68642;"; 
     final String expected = "\uD803\uDC22"; 
     final String result = neu.translate(input); 
     assertEquals("Failed to unescape numeric entities supplementary characters", expected, result); 
 } 
@Test 
 public void testUnfinishedEntity8930() { 
     NumericEntityUnescaper neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional); 
     String input = "Test &#x30 not test"; 
     String expected = "Test \u0030 not test"; 
     String result = neu.translate(input); 
     assertEquals("Failed to support unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(); 
     input = "Test &#x30 not test"; 
     expected = input; 
     result = neu.translate(input); 
     assertEquals("Failed to ignore unfinished entities (i.e. missing semi-colon)", expected, result); 
     neu = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon); 
     input = "Test &#x30 not test"; 
     try { 
         result = neu.translate(input); 
         fail("IllegalArgumentException expected"); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
