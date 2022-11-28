@Test 
 public void testReplaceEmptyKeys19() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys128() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys155() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys167() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceComplexEscaping187() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys227() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys313() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys371() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testStaticReplaceSystemProperties434() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 } 
@Test 
 public void testReplaceEmptyKeys462() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys528() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys535() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys625() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testGetSetSuffix629() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testReplaceNull709() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceNull788() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testGetSetPrefix912() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 } 
@Test 
 public void testGetSetSuffix1100() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testCyclicReplacement1164() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 } 
@Test 
 public void testGetSetSuffix1187() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testReplaceNull1226() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testCyclicReplacement1324() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 } 
@Test 
 public void testReplaceEmpty1458() { 
     doTestNoReplace(""); 
 } 
@Test 
 public void testReplaceEmptyKeys1487() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testGetSetSuffix1530() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testReplaceEmptyKeys1552() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys1600() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys1761() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys1767() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys1816() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testGetSetPrefix1868() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 } 
@Test 
 public void testReplaceEmptyKeys2096() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2213() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2215() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2315() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2334() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testConstructorMapFull2352() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     final StrSubstitutor sub = new StrSubstitutor(map, "<", ">", '!'); 
     assertEquals("Hi < commons", sub.replace("Hi !< <name>")); 
 } 
@Test 
 public void testCyclicReplacement2393() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 } 
@Test 
 public void testConstructorMapFull2492() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     final StrSubstitutor sub = new StrSubstitutor(map, "<", ">", '!'); 
     assertEquals("Hi < commons", sub.replace("Hi !< <name>")); 
 } 
@Test 
 public void testStaticReplace2582() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi ${name}!", map)); 
 } 
@Test 
 public void testReplaceEmptyKeys2683() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2701() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSubstituteDefaultProperties2758() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testReplaceEmptyKeys2761() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2802() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2816() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testCyclicReplacement2907() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 } 
@Test 
 public void testReplaceEmptyKeys2929() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys2973() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testGetSetPrefix3100() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 } 
@Test 
 public void testReplaceEmptyKeys3114() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceNull3161() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceEmptyKeys3178() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSubstituteDefaultProperties3231() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testReplaceNull3249() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceEmptyKeys3258() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceNull3276() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceEmptyKeys3347() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testCyclicReplacement3385() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 } 
@Test 
 public void testReplaceNull3400() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceComplexEscaping3578() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 } 
@Test 
 public void testGetSetSuffix3638() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testSubstituteDefaultProperties3705() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testReplaceEmptyKeys3733() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys3934() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testGetSetPrefix3953() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 } 
@Test 
 public void testGetSetSuffix3967() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testGetSetPrefix4095() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 } 
@Test 
 public void testSubstituteDefaultProperties4096() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testReplacePartialString_noReplace4105() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertEquals("${animal} jumps", sub.replace("The ${animal} jumps over the ${target}.", 4, 15)); 
 } 
@Test 
 public void testReplaceEmptyKeys4122() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testStaticReplace4225() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi ${name}!", map)); 
 } 
@Test 
 public void testReplaceEmptyKeys4230() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSubstituteDefaultProperties4268() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testReplaceEmptyKeys4331() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4359() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4544() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4629() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4701() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4717() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4726() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceNull4791() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceEmptyKeys4816() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4870() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4887() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4912() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4914() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys4949() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSubstituteDefaultProperties5140() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testSamePrefixAndSuffix5190() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testReplaceEmptyKeys5333() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSamePrefixAndSuffix5503() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testReplaceEmptyKeys5547() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceComplexEscaping5570() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSamePrefixAndSuffix5632() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testReplaceEmptyKeys5689() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys5803() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys5810() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys6051() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys6067() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys6069() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSubstituteDefaultProperties6103() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testReplaceEmptyKeys6232() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSamePrefixAndSuffix6242() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testSamePrefixAndSuffix6272() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testGetSetPrefix6301() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 } 
@Test 
 public void testReplaceEmptyKeys6302() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys6330() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys6349() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSamePrefixAndSuffix6437() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testReplaceEmptyKeys6472() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys6586() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceComplexEscaping6615() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys6764() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSamePrefixAndSuffix6957() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testReplaceEmptyKeys6968() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testGetSetSuffix7001() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testSubstituteDefaultProperties7066() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testGetSetSuffix7191() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testReplaceEmptyKeys7445() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSamePrefixAndSuffix7859() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testReplaceEmptyKeys7921() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys7930() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceNull8077() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceNull8163() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testGetSetSuffix8180() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariableSuffix('<'); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariableSuffix("<<"); 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariableSuffix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariableSuffixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariableSuffixMatcher(matcher); 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
     try { 
         sub.setVariableSuffixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariableSuffixMatcher()); 
 } 
@Test 
 public void testReplaceEmptyKeys8190() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSamePrefixAndSuffix8198() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("greeting", "Hello"); 
     map.put(" there ", "XXX"); 
     map.put("name", "commons"); 
     assertEquals("Hi commons!", StrSubstitutor.replace("Hi @name@!", map, "@", "@")); 
     assertEquals("Hello there commons!", StrSubstitutor.replace("@greeting@ there @name@!", map, "@", "@")); 
 } 
@Test 
 public void testCyclicReplacement8284() { 
     final Map<String, String> map = new HashMap<String, String>(); 
     map.put("animal", "${critter}"); 
     map.put("target", "${pet}"); 
     map.put("pet", "${petCharacteristic} dog"); 
     map.put("petCharacteristic", "lazy"); 
     map.put("critter", "${critterSpeed} ${critterColor} ${critterType}"); 
     map.put("critterSpeed", "quick"); 
     map.put("critterColor", "brown"); 
     map.put("critterType", "${animal}"); 
     final StrSubstitutor sub = new StrSubstitutor(map); 
     try { 
         sub.replace("The ${animal} jumps over the ${target}."); 
         fail("Cyclic replacement was not detected!"); 
     } catch (final IllegalStateException ex) { 
     } 
 } 
@Test 
 public void testGetSetPrefix8382() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     sub.setVariablePrefix('<'); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.CharMatcher); 
     sub.setVariablePrefix("<<"); 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     try { 
         sub.setVariablePrefix((String) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertTrue(sub.getVariablePrefixMatcher() instanceof StrMatcher.StringMatcher); 
     final StrMatcher matcher = StrMatcher.commaMatcher(); 
     sub.setVariablePrefixMatcher(matcher); 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
     try { 
         sub.setVariablePrefixMatcher((StrMatcher) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertSame(matcher, sub.getVariablePrefixMatcher()); 
 } 
@Test 
 public void testReplaceEmptyKeys8463() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys8469() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceComplexEscaping8470() { 
     doTestReplace("The ${quick brown fox} jumps over the lazy dog.", "The $${${animal}} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplacePartialString_noReplace8615() { 
     final StrSubstitutor sub = new StrSubstitutor(); 
     assertEquals("${animal} jumps", sub.replace("The ${animal} jumps over the ${target}.", 4, 15)); 
 } 
@Test 
 public void testReplaceEmptyKeys8616() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys8653() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys8710() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys8837() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testSubstituteDefaultProperties8878() { 
     final String org = "${doesnotwork}"; 
     System.setProperty("doesnotwork", "It works!"); 
     final Properties props = new Properties(System.getProperties()); 
     assertEquals("It works!", StrSubstitutor.replace(org, props)); 
 } 
@Test 
 public void testReplaceEmptyKeys8951() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys9025() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceNull9094() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testStaticReplaceSystemProperties9150() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 } 
@Test 
 public void testStaticReplaceSystemProperties9159() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 } 
@Test 
 public void testStaticReplaceSystemProperties9197() { 
     final StrBuilder buf = new StrBuilder(); 
     buf.append("Hi ").append(System.getProperty("user.name")); 
     buf.append(", you are working with "); 
     buf.append(System.getProperty("os.name")); 
     buf.append(", your home directory is "); 
     buf.append(System.getProperty("user.home")).append('.'); 
     assertEquals(buf.toString(), StrSubstitutor.replaceSystemProperties("Hi ${user.name}, you are " + "working with ${os.name}, your home " + "directory is ${user.home}.")); 
 } 
@Test 
 public void testReplaceNull9244() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceNull9321() { 
     doTestNoReplace(null); 
 } 
@Test 
 public void testReplaceEmptyKeys9365() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
@Test 
 public void testReplaceEmptyKeys9382() { 
     doTestReplace("The ${} jumps over the lazy dog.", "The ${} jumps over the ${target}.", true); 
 } 
