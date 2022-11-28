@Test 
 public void testSpecialCharacters22() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testToStringContainsName42() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 } 
@Test 
 public void testTimeZoneMatches135() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals294() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals300() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testTimeZoneMatches398() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals503() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals615() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLang303650() throws ParseException { 
     DateParser parser = getInstance(YMD_SLASH); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     final Date date = parser.parse("2004/11/31"); 
     parser = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) parser)); 
     assertEquals(date, parser.parse("2004/11/31")); 
 } 
@Test 
 public void testEquals693() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals761() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals797() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLocales_Long_AD824() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 } 
@Test 
 public void testEquals849() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals1035() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testDayOf1121() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testEquals1133() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals1147() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLang5381222() throws ParseException { 
     final DateParser parser = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", GMT); 
     final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8")); 
     cal.clear(); 
     cal.set(2009, 9, 16, 8, 42, 16); 
     assertEquals(cal.getTime(), parser.parse("2009-10-16T16:42:16.000Z")); 
 } 
@Test 
 public void testTimeZoneMatches1261() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testParseNumerics1283() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 } 
@Test 
 public void testEquals1291() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals1340() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLang3031345() throws ParseException { 
     DateParser parser = getInstance(YMD_SLASH); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     final Date date = parser.parse("2004/11/31"); 
     parser = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) parser)); 
     assertEquals(date, parser.parse("2004/11/31")); 
 } 
@Test 
 public void testDayOf1420() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testEquals1472() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters1510() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testSpecialCharacters1598() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testParseNumerics1599() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 } 
@Test 
 public void testSpecialCharacters1933() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testLANG_8321942() throws Exception { 
     testSdfAndFdp("'d'd", "d3", false); 
     testSdfAndFdp("'d'd'", "d3", true); 
 } 
@Test 
 public void testEquals1958() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals1972() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLANG_8311987() throws Exception { 
     testSdfAndFdp("M E", "3  Tue", true); 
 } 
@Test 
 public void testParseNumerics2009() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 } 
@Test 
 public void testLang3032011() throws ParseException { 
     DateParser parser = getInstance(YMD_SLASH); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 11, 31); 
     final Date date = parser.parse("2004/11/31"); 
     parser = SerializationUtils.deserialize(SerializationUtils.serialize((Serializable) parser)); 
     assertEquals(date, parser.parse("2004/11/31")); 
 } 
@Test 
 public void testEquals2022() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals2072() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals2111() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals2113() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLocales_Long_BC2320() throws Exception { 
     testLocales(LONG_FORMAT, true); 
 } 
@Test 
 public void testEquals2356() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLocales_Long_AD2434() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 } 
@Test 
 public void testEquals2446() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals2505() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals2512() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals2515() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLocales_Long_BC2562() throws Exception { 
     testLocales(LONG_FORMAT, true); 
 } 
@Test 
 public void testDayOf2566() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testToStringContainsName2654() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 } 
@Test 
 public void testEquals2836() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testDayOf2840() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testEquals2855() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals3122() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testParseLongShort3200() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     cal.setTimeZone(NEW_YORK); 
     DateParser fdf = getInstance("yyyy GGGG MMMM dddd aaaa EEEE HHHH mmmm ssss SSSS ZZZZ", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("2003 AD February 0010 PM Monday 0015 0033 0020 0989 GMT-05:00")); 
     cal.set(Calendar.ERA, GregorianCalendar.BC); 
     final Date parse = fdf.parse("2003 BC February 0010 PM Saturday 0015 0033 0020 0989 GMT-05:00"); 
     assertEquals(cal.getTime(), parse); 
     fdf = getInstance("y G M d a E H m s S Z", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("03 BC 2 10 PM Sat 15 33 20 989 -0500")); 
     cal.set(Calendar.ERA, GregorianCalendar.AD); 
     assertEquals(cal.getTime(), fdf.parse("03 AD 2 10 PM Saturday 15 33 20 989 -0500")); 
 } 
@Test 
 public void testTimeZoneMatches3250() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals3281() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals3437() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters3448() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testPatternMatches3574() { 
     final DateParser parser = getInstance(yMdHmsSZ); 
     assertEquals(yMdHmsSZ, parser.getPattern()); 
 } 
@Test 
 public void testParseNumerics3576() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 } 
@Test 
 public void testSpecialCharacters3610() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testDayOf3673() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testEquals3682() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testTimeZoneMatches3858() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals4157() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testTimeZoneMatches4189() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testParseNumerics4190() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     final DateParser fdf = getInstance("yyyyMMddHHmmssSSS", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("20030210153320989")); 
 } 
@Test 
 public void testEquals4302() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals4340() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals4345() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters4436() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testEquals4484() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testDayOf4514() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testToStringContainsName4537() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 } 
@Test 
 public void testTimeZoneMatches4538() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals4587() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLocales_Long_AD4645() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 } 
@Test 
 public void testSpecialCharacters4657() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testEquals4807() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters4901() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testEquals4983() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters4995() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testEquals5051() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5093() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void test_Equality_Hash5196() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 } 
@Test 
 public void testEquals5202() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5247() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5283() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5323() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5494() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5509() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5613() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5709() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testTimeZoneMatches5718() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals5719() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testTimeZoneMatches5834() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals5915() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals5937() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testTimeZoneMatches5981() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testSpecialCharacters6360() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testLang5386409() throws ParseException { 
     final DateParser parser = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", GMT); 
     final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8")); 
     cal.clear(); 
     cal.set(2009, 9, 16, 8, 42, 16); 
     assertEquals(cal.getTime(), parser.parse("2009-10-16T16:42:16.000Z")); 
 } 
@Test 
 public void testToStringContainsName6431() { 
     final DateParser parser = getInstance(YMD_SLASH); 
     assertTrue(parser.toString().startsWith("FastDate")); 
 } 
@Test 
 public void testLANG_8316591() throws Exception { 
     testSdfAndFdp("M E", "3  Tue", true); 
 } 
@Test 
 public void testEquals6611() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters6781() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testDayOf6839() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testDayOf6944() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testSpecialCharacters7017() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testEquals7274() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters7321() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testEquals7431() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals7456() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals7505() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals7513() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void test_Equality_Hash7552() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 } 
@Test 
 public void testEquals7676() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals7762() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals7774() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals7889() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testDayOf7913() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testLocales_Long_AD7937() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 } 
@Test 
 public void testTimeZoneMatches7954() { 
     final DateParser parser = getInstance(yMdHmsSZ, REYKJAVIK); 
     assertEquals(REYKJAVIK, parser.getTimeZone()); 
 } 
@Test 
 public void testEquals7959() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testDayOf8063() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testEquals8206() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testDayOf8221() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testEquals8286() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals8327() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLocales_Long_AD8349() throws Exception { 
     testLocales(LONG_FORMAT, false); 
 } 
@Test 
 public void testDayOf8401() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 } 
@Test 
 public void testSpecialCharacters8530() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testEquals8764() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals8797() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testLANG_8318813() throws Exception { 
     testSdfAndFdp("M E", "3  Tue", true); 
 } 
@Test 
 public void testEquals8818() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testSpecialCharacters8933() throws Exception { 
     testSdfAndFdp("q", "", true); 
     testSdfAndFdp("Q", "", true); 
     testSdfAndFdp("$", "$", false); 
     testSdfAndFdp("?.d", "?.12", false); 
     testSdfAndFdp("''yyyyMMdd'A''B'HHmmssSSS''", "'20030210A'B153320989'", false); 
     testSdfAndFdp("''''yyyyMMdd'A''B'HHmmssSSS''", "''20030210A'B153320989'", false); 
     testSdfAndFdp("'$\\Ed'", "$\\Ed", false); 
 } 
@Test 
 public void testPatternMatches9179() { 
     final DateParser parser = getInstance(yMdHmsSZ); 
     assertEquals(yMdHmsSZ, parser.getPattern()); 
 } 
@Test 
 public void test_Equality_Hash9292() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 } 
@Test 
 public void test_Equality_Hash9303() { 
     final DateParser[] parsers = { getInstance(yMdHmsSZ, NEW_YORK, Locale.US), getInstance(DMY_DOT, NEW_YORK, Locale.US), getInstance(YMD_SLASH, NEW_YORK, Locale.US), getInstance(MDY_DASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, NEW_YORK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, Locale.US), getInstance(MDY_SLASH, REYKJAVIK, SWEDEN) }; 
     final Map<DateParser, Integer> map = new HashMap<DateParser, Integer>(); 
     int i = 0; 
     for (final DateParser parser : parsers) { 
         map.put(parser, Integer.valueOf(i++)); 
     } 
     i = 0; 
     for (final DateParser parser : parsers) { 
         assertEquals(i++, map.get(parser).intValue()); 
     } 
 } 
@Test 
 public void testEquals9356() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testEquals9471() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 } 
@Test 
 public void testParseLongShort9556() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10, 15, 33, 20); 
     cal.set(Calendar.MILLISECOND, 989); 
     cal.setTimeZone(NEW_YORK); 
     DateParser fdf = getInstance("yyyy GGGG MMMM dddd aaaa EEEE HHHH mmmm ssss SSSS ZZZZ", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("2003 AD February 0010 PM Monday 0015 0033 0020 0989 GMT-05:00")); 
     cal.set(Calendar.ERA, GregorianCalendar.BC); 
     final Date parse = fdf.parse("2003 BC February 0010 PM Saturday 0015 0033 0020 0989 GMT-05:00"); 
     assertEquals(cal.getTime(), parse); 
     fdf = getInstance("y G M d a E H m s S Z", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("03 BC 2 10 PM Sat 15 33 20 989 -0500")); 
     cal.set(Calendar.ERA, GregorianCalendar.AD); 
     assertEquals(cal.getTime(), fdf.parse("03 AD 2 10 PM Saturday 15 33 20 989 -0500")); 
 } 
