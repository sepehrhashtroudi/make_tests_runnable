@Test 
 public void testGetFirstContextValue173() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testGetFirstContextValue584() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testGetFirstContextValue1079() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testGetFirstContextValue1220() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testGetFirstContextValue1478() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testSetContextValue1752() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetContextLabels2095() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final Set<String> labels = exceptionContext.getContextLabels(); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(5, labels.size()); 
     assertTrue(labels.contains("test1")); 
     assertTrue(labels.contains("test2")); 
     assertTrue(labels.contains("test Date")); 
     assertTrue(labels.contains("test Nbr")); 
 } 
@Test 
 public void testSetContextValue2281() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetFirstContextValue2503() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testGetFirstContextValue2707() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testGetFirstContextValue3126() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testGetContextEntries3706() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final List<Pair<String, Object>> entries = exceptionContext.getContextEntries(); 
     assertEquals(6, entries.size()); 
     assertEquals("test1", entries.get(0).getKey()); 
     assertEquals("test2", entries.get(1).getKey()); 
     assertEquals("test Date", entries.get(2).getKey()); 
     assertEquals("test Nbr", entries.get(3).getKey()); 
     assertEquals("test Poorly written obj", entries.get(4).getKey()); 
     assertEquals("test2", entries.get(5).getKey()); 
 } 
@Test 
 public void testJavaSerialization3723() { 
     exceptionContext.setContextValue("test Poorly written obj", "serializable replacement"); 
     final T clone = SerializationUtils.deserialize(SerializationUtils.serialize(exceptionContext)); 
     assertEquals(exceptionContext.getFormattedExceptionMessage(null), clone.getFormattedExceptionMessage(null)); 
 } 
@Test 
 public void testSetContextValue3780() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetFirstContextValue3821() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testJavaSerialization5234() { 
     exceptionContext.setContextValue("test Poorly written obj", "serializable replacement"); 
     final T clone = SerializationUtils.deserialize(SerializationUtils.serialize(exceptionContext)); 
     assertEquals(exceptionContext.getFormattedExceptionMessage(null), clone.getFormattedExceptionMessage(null)); 
 } 
@Test 
 public void testGetContextEntries5251() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final List<Pair<String, Object>> entries = exceptionContext.getContextEntries(); 
     assertEquals(6, entries.size()); 
     assertEquals("test1", entries.get(0).getKey()); 
     assertEquals("test2", entries.get(1).getKey()); 
     assertEquals("test Date", entries.get(2).getKey()); 
     assertEquals("test Nbr", entries.get(3).getKey()); 
     assertEquals("test Poorly written obj", entries.get(4).getKey()); 
     assertEquals("test2", entries.get(5).getKey()); 
 } 
@Test 
 public void testGetContextLabels5336() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final Set<String> labels = exceptionContext.getContextLabels(); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(5, labels.size()); 
     assertTrue(labels.contains("test1")); 
     assertTrue(labels.contains("test2")); 
     assertTrue(labels.contains("test Date")); 
     assertTrue(labels.contains("test Nbr")); 
 } 
@Test 
 public void testSetContextValue6008() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetContextEntries6188() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final List<Pair<String, Object>> entries = exceptionContext.getContextEntries(); 
     assertEquals(6, entries.size()); 
     assertEquals("test1", entries.get(0).getKey()); 
     assertEquals("test2", entries.get(1).getKey()); 
     assertEquals("test Date", entries.get(2).getKey()); 
     assertEquals("test Nbr", entries.get(3).getKey()); 
     assertEquals("test Poorly written obj", entries.get(4).getKey()); 
     assertEquals("test2", entries.get(5).getKey()); 
 } 
@Test 
 public void testGetFirstContextValue6561() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testSetContextValue6603() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetContextLabels6691() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final Set<String> labels = exceptionContext.getContextLabels(); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(5, labels.size()); 
     assertTrue(labels.contains("test1")); 
     assertTrue(labels.contains("test2")); 
     assertTrue(labels.contains("test Date")); 
     assertTrue(labels.contains("test Nbr")); 
 } 
@Test 
 public void testSetContextValue6726() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetFirstContextValue6794() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testSetContextValue6882() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetContextEntries7230() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final List<Pair<String, Object>> entries = exceptionContext.getContextEntries(); 
     assertEquals(6, entries.size()); 
     assertEquals("test1", entries.get(0).getKey()); 
     assertEquals("test2", entries.get(1).getKey()); 
     assertEquals("test Date", entries.get(2).getKey()); 
     assertEquals("test Nbr", entries.get(3).getKey()); 
     assertEquals("test Poorly written obj", entries.get(4).getKey()); 
     assertEquals("test2", entries.get(5).getKey()); 
 } 
@Test 
 public void testJavaSerialization7506() { 
     exceptionContext.setContextValue("test Poorly written obj", "serializable replacement"); 
     final T clone = SerializationUtils.deserialize(SerializationUtils.serialize(exceptionContext)); 
     assertEquals(exceptionContext.getFormattedExceptionMessage(null), clone.getFormattedExceptionMessage(null)); 
 } 
@Test 
 public void testGetContextEntries8142() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final List<Pair<String, Object>> entries = exceptionContext.getContextEntries(); 
     assertEquals(6, entries.size()); 
     assertEquals("test1", entries.get(0).getKey()); 
     assertEquals("test2", entries.get(1).getKey()); 
     assertEquals("test Date", entries.get(2).getKey()); 
     assertEquals("test Nbr", entries.get(3).getKey()); 
     assertEquals("test Poorly written obj", entries.get(4).getKey()); 
     assertEquals("test2", entries.get(5).getKey()); 
 } 
@Test 
 public void testGetContextLabels8229() { 
     assertEquals(5, exceptionContext.getContextEntries().size()); 
     exceptionContext.addContextValue("test2", "different value"); 
     final Set<String> labels = exceptionContext.getContextLabels(); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(5, labels.size()); 
     assertTrue(labels.contains("test1")); 
     assertTrue(labels.contains("test2")); 
     assertTrue(labels.contains("test Date")); 
     assertTrue(labels.contains("test Nbr")); 
 } 
@Test 
 public void testGetFirstContextValue8459() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testSetContextValue8531() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetFirstContextValue9076() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
@Test 
 public void testSetContextValue9317() { 
     exceptionContext.addContextValue("test2", "different value"); 
     exceptionContext.setContextValue("test3", "3"); 
     final String message = exceptionContext.getFormattedExceptionMessage(TEST_MESSAGE); 
     assertTrue(message.indexOf(TEST_MESSAGE) >= 0); 
     assertTrue(message.indexOf("test Poorly written obj") >= 0); 
     assertTrue(message.indexOf("Crap") >= 0); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test Poorly written obj") instanceof ObjectWithFaultyToString); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     assertTrue(exceptionContext.getContextLabels().contains("test Poorly written obj")); 
     assertTrue(!exceptionContext.getContextLabels().contains("crap")); 
     exceptionContext.setContextValue("test Poorly written obj", "replacement"); 
     assertEquals(7, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     exceptionContext.setContextValue("test2", "another"); 
     assertEquals(6, exceptionContext.getContextEntries().size()); 
     assertEquals(6, exceptionContext.getContextLabels().size()); 
     final String contextMessage = exceptionContext.getFormattedExceptionMessage(null); 
     assertTrue(contextMessage.indexOf(TEST_MESSAGE) == -1); 
 } 
@Test 
 public void testGetFirstContextValue9367() { 
     exceptionContext.addContextValue("test2", "different value"); 
     assertTrue(exceptionContext.getFirstContextValue("test1") == null); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value")); 
     assertTrue(exceptionContext.getFirstContextValue("crap") == null); 
     exceptionContext.setContextValue("test2", "another"); 
     assertTrue(exceptionContext.getFirstContextValue("test2").equals("another")); 
 } 
