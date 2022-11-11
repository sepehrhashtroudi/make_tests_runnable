@Test 
 public void testIsSameDay_Date34() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator334() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testSetMinutes389() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setMinutes(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 0, 2, 1); 
     result = DateUtils.setMinutes(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 59, 2, 1); 
     try { 
         result = DateUtils.setMinutes(base, 60); 
         fail("DateUtils.setMinutes did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testCeil533() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator573() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testSetMonths670() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setMonths(base, 5); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 5, 5, 4, 3, 2, 1); 
     result = DateUtils.setMonths(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 1, 5, 4, 3, 2, 1); 
     try { 
         result = DateUtils.setMonths(base, 12); 
         fail("DateUtils.setMonths did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testRound839() throws Exception { 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round(date2, Calendar.MONTH)); 
     assertEquals("round semimonth-0 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round(date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round(date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round(date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round(date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round(date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round(date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round(date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round(date2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round((Object) date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round((Object) date2, Calendar.MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round((Object) date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round((Object) date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round((Object) date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round((Object) date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round((Object) date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round((Object) date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) date2, Calendar.SECOND)); 
     assertEquals("round calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) cal1, Calendar.SECOND)); 
     assertEquals("round calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) cal2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.round((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.round(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm4, Calendar.AM_PM)); 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date rounding tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
 } 
@Test 
 public void testToCalendar885() { 
     assertEquals("Failed to convert to a Calendar and back", date1, DateUtils.toCalendar(date1).getTime()); 
     try { 
         DateUtils.toCalendar(null); 
         fail("Expected NullPointerException to be thrown"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testCeil933() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator938() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testParseDateWithLeniency976() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1998, 6, 30); 
     final String dateStr = "02 942, 1996"; 
     final String[] parsers = new String[] { "MM DDD, yyyy" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         date = DateUtils.parseDateStrictly(dateStr, parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator1039() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testAddMinutes1046() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addMinutes(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addMinutes(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 4, 2, 1); 
     result = DateUtils.addMinutes(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 2, 2, 1); 
 } 
@Test 
 public void testParseDateWithLeniency1060() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1998, 6, 30); 
     final String dateStr = "02 942, 1996"; 
     final String[] parsers = new String[] { "MM DDD, yyyy" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         date = DateUtils.parseDateStrictly(dateStr, parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testIteratorEx1128() throws Exception { 
     try { 
         DateUtils.iterator(Calendar.getInstance(), -9999); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Date) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Calendar) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Object) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator("", DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
 } 
@Test 
 public void testIsSameInstant_Date1135() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     try { 
         DateUtils.isSameInstant((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator1141() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator1197() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testAddWeeks1293() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addWeeks(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addWeeks(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 12, 4, 3, 2, 1); 
     result = DateUtils.addWeeks(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 5, 28, 4, 3, 2, 1); 
 } 
@Test 
 public void testAddYears1326() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addYears(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addYears(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2001, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addYears(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 1999, 6, 5, 4, 3, 2, 1); 
 } 
@Test 
 public void testLang5301334() throws ParseException { 
     final Date d = new Date(); 
     final String isoDateStr = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(d); 
     final Date d2 = DateUtils.parseDate(isoDateStr, new String[] { DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern() }); 
     assertEquals("Date not equal to itself ISO formatted and parsed", d.getTime(), d2.getTime() + d.getTime() % 1000); 
 } 
@Test 
 public void testIsSameInstant_Cal1384() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertFalse(DateUtils.isSameInstant(cal1, cal2)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertTrue(DateUtils.isSameInstant(cal1, cal2)); 
     try { 
         DateUtils.isSameInstant((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator1397() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testCeil1400() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testCeil1631() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testRound1812() throws Exception { 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round(date2, Calendar.MONTH)); 
     assertEquals("round semimonth-0 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round(date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round(date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round(date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round(date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round(date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round(date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round(date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round(date2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round((Object) date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round((Object) date2, Calendar.MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round((Object) date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round((Object) date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round((Object) date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round((Object) date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round((Object) date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round((Object) date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) date2, Calendar.SECOND)); 
     assertEquals("round calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) cal1, Calendar.SECOND)); 
     assertEquals("round calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) cal2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.round((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.round(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm4, Calendar.AM_PM)); 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date rounding tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
 } 
@Test 
 public void testAddMinutes1863() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addMinutes(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addMinutes(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 4, 2, 1); 
     result = DateUtils.addMinutes(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 2, 2, 1); 
 } 
@Test 
 public void testSetSeconds1874() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testIsSameLocalTime_Cal1905() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertTrue(DateUtils.isSameLocalTime(cal1, cal2)); 
     final Calendar cal3 = Calendar.getInstance(); 
     final Calendar cal4 = Calendar.getInstance(); 
     cal3.set(2004, 6, 9, 4, 0, 0); 
     cal4.set(2004, 6, 9, 16, 0, 0); 
     cal3.set(Calendar.MILLISECOND, 0); 
     cal4.set(Calendar.MILLISECOND, 0); 
     assertFalse("LANG-677", DateUtils.isSameLocalTime(cal3, cal4)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertFalse(DateUtils.isSameLocalTime(cal1, cal2)); 
     try { 
         DateUtils.isSameLocalTime((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testParseDate2006() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testParseDate2046() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testCeil2063() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testIteratorEx2075() throws Exception { 
     try { 
         DateUtils.iterator(Calendar.getInstance(), -9999); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Date) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Calendar) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Object) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator("", DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
 } 
@Test 
 public void testCeil2128() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testParseDate2202() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testCeil2205() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testToCalendar2325() { 
     assertEquals("Failed to convert to a Calendar and back", date1, DateUtils.toCalendar(date1).getTime()); 
     try { 
         DateUtils.toCalendar(null); 
         fail("Expected NullPointerException to be thrown"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testWeekIterator2339() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator2385() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator2609() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameInstant_Date2771() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     try { 
         DateUtils.isSameInstant((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testParseDate3024() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testCeil3038() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testCeil3064() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator3070() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameInstant_Date3080() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     try { 
         DateUtils.isSameInstant((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testCeil3088() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testIsSameInstant_Cal3239() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertFalse(DateUtils.isSameInstant(cal1, cal2)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertTrue(DateUtils.isSameInstant(cal1, cal2)); 
     try { 
         DateUtils.isSameInstant((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator3581() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameDay_Date3585() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator3630() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameDay_Date3636() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testIsSameInstant_Date3681() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     try { 
         DateUtils.isSameInstant((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testCeil3712() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testIsSameDay_Date3714() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testSetHours3747() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setHours(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 0, 3, 2, 1); 
     result = DateUtils.setHours(base, 23); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 23, 3, 2, 1); 
     try { 
         result = DateUtils.setHours(base, 24); 
         fail("DateUtils.setHours did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testAddDays3833() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addDays(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addDays(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 6, 4, 3, 2, 1); 
     result = DateUtils.addDays(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 4, 4, 3, 2, 1); 
 } 
@Test 
 public void testAddDays3884() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addDays(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addDays(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 6, 4, 3, 2, 1); 
     result = DateUtils.addDays(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 4, 4, 3, 2, 1); 
 } 
@Test 
 public void testIsSameDay_Cal3936() { 
     final GregorianCalendar cal1 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     final GregorianCalendar cal2 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.DAY_OF_YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     cal1.add(Calendar.DAY_OF_YEAR, 1); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     try { 
         DateUtils.isSameDay((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testSetYears4014() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setYears(base, 2000); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.setYears(base, 2008); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2008, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.setYears(base, 2005); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2005, 6, 5, 4, 3, 2, 1); 
 } 
@Test 
 public void testParseDate4018() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testConstructor4067() { 
     assertNotNull(new DateUtils()); 
     final Constructor<?>[] cons = DateUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DateUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DateUtils.class.getModifiers())); 
 } 
@Test 
 public void testAddMonths4127() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addMonths(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addMonths(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 7, 5, 4, 3, 2, 1); 
     result = DateUtils.addMonths(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 5, 5, 4, 3, 2, 1); 
 } 
@Test 
 public void testSetSeconds4151() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testIteratorEx4316() throws Exception { 
     try { 
         DateUtils.iterator(Calendar.getInstance(), -9999); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Date) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Calendar) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Object) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator("", DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
 } 
@Test 
 public void testSetSeconds4430() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testToCalendar4458() { 
     assertEquals("Failed to convert to a Calendar and back", date1, DateUtils.toCalendar(date1).getTime()); 
     try { 
         DateUtils.toCalendar(null); 
         fail("Expected NullPointerException to be thrown"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testCeil4568() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator4585() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator4679() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testParseDate4685() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testSetMonths4736() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setMonths(base, 5); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 5, 5, 4, 3, 2, 1); 
     result = DateUtils.setMonths(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 1, 5, 4, 3, 2, 1); 
     try { 
         result = DateUtils.setMonths(base, 12); 
         fail("DateUtils.setMonths did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testWeekIterator4772() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameInstant_Cal4781() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertFalse(DateUtils.isSameInstant(cal1, cal2)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertTrue(DateUtils.isSameInstant(cal1, cal2)); 
     try { 
         DateUtils.isSameInstant((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testCeil4820() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testRoundLang3464862() throws Exception { 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Calendar testCalendar = Calendar.getInstance(); 
     testCalendar.set(2007, 6, 2, 8, 8, 50); 
     Date date = testCalendar.getTime(); 
     assertEquals("Minute Round Up Failed", dateTimeParser.parse("July 2, 2007 08:09:00.000"), DateUtils.round(date, Calendar.MINUTE)); 
     testCalendar.set(2007, 6, 2, 8, 8, 20); 
     date = testCalendar.getTime(); 
     assertEquals("Minute No Round Failed", dateTimeParser.parse("July 2, 2007 08:08:00.000"), DateUtils.round(date, Calendar.MINUTE)); 
     testCalendar.set(2007, 6, 2, 8, 8, 50); 
     testCalendar.set(Calendar.MILLISECOND, 600); 
     date = testCalendar.getTime(); 
     assertEquals("Second Round Up with 600 Milli Seconds Failed", dateTimeParser.parse("July 2, 2007 08:08:51.000"), DateUtils.round(date, Calendar.SECOND)); 
     testCalendar.set(2007, 6, 2, 8, 8, 50); 
     testCalendar.set(Calendar.MILLISECOND, 200); 
     date = testCalendar.getTime(); 
     assertEquals("Second Round Down with 200 Milli Seconds Failed", dateTimeParser.parse("July 2, 2007 08:08:50.000"), DateUtils.round(date, Calendar.SECOND)); 
     testCalendar.set(2007, 6, 2, 8, 8, 20); 
     testCalendar.set(Calendar.MILLISECOND, 600); 
     date = testCalendar.getTime(); 
     assertEquals("Second Round Up with 200 Milli Seconds Failed", dateTimeParser.parse("July 2, 2007 08:08:21.000"), DateUtils.round(date, Calendar.SECOND)); 
     testCalendar.set(2007, 6, 2, 8, 8, 20); 
     testCalendar.set(Calendar.MILLISECOND, 200); 
     date = testCalendar.getTime(); 
     assertEquals("Second Round Down with 200 Milli Seconds Failed", dateTimeParser.parse("July 2, 2007 08:08:20.000"), DateUtils.round(date, Calendar.SECOND)); 
     testCalendar.set(2007, 6, 2, 8, 8, 50); 
     date = testCalendar.getTime(); 
     assertEquals("Hour Round Down Failed", dateTimeParser.parse("July 2, 2007 08:00:00.000"), DateUtils.round(date, Calendar.HOUR)); 
     testCalendar.set(2007, 6, 2, 8, 31, 50); 
     date = testCalendar.getTime(); 
     assertEquals("Hour Round Up Failed", dateTimeParser.parse("July 2, 2007 09:00:00.000"), DateUtils.round(date, Calendar.HOUR)); 
 } 
@Test 
 public void testAddSeconds4866() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addSeconds(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 3, 1); 
     result = DateUtils.addSeconds(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 1, 1); 
 } 
@Test 
 public void testAddSeconds4996() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addSeconds(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 3, 1); 
     result = DateUtils.addSeconds(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 1, 1); 
 } 
@Test 
 public void testParseDate5026() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testSetYears5069() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setYears(base, 2000); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.setYears(base, 2008); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2008, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.setYears(base, 2005); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2005, 6, 5, 4, 3, 2, 1); 
 } 
@Test 
 public void testParseDate5201() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testIsSameLocalTime_Cal5295() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertTrue(DateUtils.isSameLocalTime(cal1, cal2)); 
     final Calendar cal3 = Calendar.getInstance(); 
     final Calendar cal4 = Calendar.getInstance(); 
     cal3.set(2004, 6, 9, 4, 0, 0); 
     cal4.set(2004, 6, 9, 16, 0, 0); 
     cal3.set(Calendar.MILLISECOND, 0); 
     cal4.set(Calendar.MILLISECOND, 0); 
     assertFalse("LANG-677", DateUtils.isSameLocalTime(cal3, cal4)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertFalse(DateUtils.isSameLocalTime(cal1, cal2)); 
     try { 
         DateUtils.isSameLocalTime((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testSetHours5341() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setHours(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 0, 3, 2, 1); 
     result = DateUtils.setHours(base, 23); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 23, 3, 2, 1); 
     try { 
         result = DateUtils.setHours(base, 24); 
         fail("DateUtils.setHours did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testWeekIterator5384() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator5403() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameLocalTime_Cal5417() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertTrue(DateUtils.isSameLocalTime(cal1, cal2)); 
     final Calendar cal3 = Calendar.getInstance(); 
     final Calendar cal4 = Calendar.getInstance(); 
     cal3.set(2004, 6, 9, 4, 0, 0); 
     cal4.set(2004, 6, 9, 16, 0, 0); 
     cal3.set(Calendar.MILLISECOND, 0); 
     cal4.set(Calendar.MILLISECOND, 0); 
     assertFalse("LANG-677", DateUtils.isSameLocalTime(cal3, cal4)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertFalse(DateUtils.isSameLocalTime(cal1, cal2)); 
     try { 
         DateUtils.isSameLocalTime((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testParseDate5468() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testParseDate5512() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testIsSameLocalTime_Cal5525() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertTrue(DateUtils.isSameLocalTime(cal1, cal2)); 
     final Calendar cal3 = Calendar.getInstance(); 
     final Calendar cal4 = Calendar.getInstance(); 
     cal3.set(2004, 6, 9, 4, 0, 0); 
     cal4.set(2004, 6, 9, 16, 0, 0); 
     cal3.set(Calendar.MILLISECOND, 0); 
     cal4.set(Calendar.MILLISECOND, 0); 
     assertFalse("LANG-677", DateUtils.isSameLocalTime(cal3, cal4)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertFalse(DateUtils.isSameLocalTime(cal1, cal2)); 
     try { 
         DateUtils.isSameLocalTime((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testCeil5600() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testSetDays5617() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setDays(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 1, 4, 3, 2, 1); 
     result = DateUtils.setDays(base, 29); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 29, 4, 3, 2, 1); 
     try { 
         result = DateUtils.setDays(base, 32); 
         fail("DateUtils.setDays did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testWeekIterator5687() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testParseDate5807() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testParseDate5880() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator5886() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameDay_Date5895() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testParseDate5910() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testCeil5922() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator6048() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator6088() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testSetSeconds6123() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testWeekIterator6161() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testAddHours6217() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addHours(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addHours(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 5, 3, 2, 1); 
     result = DateUtils.addHours(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 3, 3, 2, 1); 
 } 
@Test 
 public void testIsSameInstant_Cal6258() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertFalse(DateUtils.isSameInstant(cal1, cal2)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertTrue(DateUtils.isSameInstant(cal1, cal2)); 
     try { 
         DateUtils.isSameInstant((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testSetSeconds6324() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testCeil6352() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testCeil6385() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator6510() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testAddMonths6655() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addMonths(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addMonths(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 7, 5, 4, 3, 2, 1); 
     result = DateUtils.addMonths(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 5, 5, 4, 3, 2, 1); 
 } 
@Test 
 public void testToCalendar6712() { 
     assertEquals("Failed to convert to a Calendar and back", date1, DateUtils.toCalendar(date1).getTime()); 
     try { 
         DateUtils.toCalendar(null); 
         fail("Expected NullPointerException to be thrown"); 
     } catch (final NullPointerException npe) { 
     } 
 } 
@Test 
 public void testCeil6727() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testSetMilliseconds6807() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setMilliseconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 0); 
     result = DateUtils.setMilliseconds(base, 999); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 999); 
     try { 
         result = DateUtils.setMilliseconds(base, 1000); 
         fail("DateUtils.setMilliseconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testParseDateWithLeniency6953() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1998, 6, 30); 
     final String dateStr = "02 942, 1996"; 
     final String[] parsers = new String[] { "MM DDD, yyyy" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         date = DateUtils.parseDateStrictly(dateStr, parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator6970() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testCeil7035() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testIsSameDay_Date7036() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testCeil7046() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator7057() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testParseDate7080() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator7221() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testParseDate7262() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testAddHours7322() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addHours(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addHours(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 5, 3, 2, 1); 
     result = DateUtils.addHours(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 3, 3, 2, 1); 
 } 
@Test 
 public void testRound7358() throws Exception { 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round(date2, Calendar.MONTH)); 
     assertEquals("round semimonth-0 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round(date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round(date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round(date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round(date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round(date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round(date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round(date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round(date2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round((Object) date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round((Object) date2, Calendar.MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round((Object) date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round((Object) date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round((Object) date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round((Object) date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round((Object) date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round((Object) date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) date2, Calendar.SECOND)); 
     assertEquals("round calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) cal1, Calendar.SECOND)); 
     assertEquals("round calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) cal2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.round((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.round(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm4, Calendar.AM_PM)); 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date rounding tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
 } 
@Test 
 public void testCeil7467() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testSetSeconds7485() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testParseDate7522() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testIsSameDay_Cal7581() { 
     final GregorianCalendar cal1 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     final GregorianCalendar cal2 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.DAY_OF_YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     cal1.add(Calendar.DAY_OF_YEAR, 1); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     try { 
         DateUtils.isSameDay((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testParseDateWithLeniency7588() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1998, 6, 30); 
     final String dateStr = "02 942, 1996"; 
     final String[] parsers = new String[] { "MM DDD, yyyy" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         date = DateUtils.parseDateStrictly(dateStr, parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testSetSeconds7605() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testIteratorEx7718() throws Exception { 
     try { 
         DateUtils.iterator(Calendar.getInstance(), -9999); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Date) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Calendar) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Object) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator("", DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator7806() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator7855() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator7873() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testParseDate7960() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testSetSeconds7979() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testParseDate8005() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testParseDate8019() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testIsSameDay_Date8026() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testConstructor8062() { 
     assertNotNull(new DateUtils()); 
     final Constructor<?>[] cons = DateUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(DateUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(DateUtils.class.getModifiers())); 
 } 
@Test 
 public void testWeekIterator8141() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testWeekIterator8245() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameDay_Cal8270() { 
     final GregorianCalendar cal1 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     final GregorianCalendar cal2 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.DAY_OF_YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     cal1.add(Calendar.DAY_OF_YEAR, 1); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     try { 
         DateUtils.isSameDay((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testParseDate8279() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testCeil8294() throws Exception { 
     assertEquals("ceiling javadoc-1 failed", dateTimeParser.parse("March 28, 2002 14:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.HOUR)); 
     assertEquals("ceiling javadoc-2 failed", dateTimeParser.parse("April 1, 2002 00:00:00.000"), DateUtils.ceiling(dateTimeParser.parse("March 28, 2002 13:45:01.231"), Calendar.MONTH)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling(date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling(date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling(date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling(date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling(date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling(date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling(date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling(date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling(date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling(date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling(date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling year-1 failed", dateParser.parse("January 1, 2003"), DateUtils.ceiling((Object) date1, Calendar.YEAR)); 
     assertEquals("ceiling year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.ceiling((Object) date2, Calendar.YEAR)); 
     assertEquals("ceiling month-1 failed", dateParser.parse("March 1, 2002"), DateUtils.ceiling((Object) date1, Calendar.MONTH)); 
     assertEquals("ceiling month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, Calendar.MONTH)); 
     assertEquals("ceiling semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.ceiling((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling semimonth-2 failed", dateParser.parse("December 1, 2001"), DateUtils.ceiling((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("ceiling date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.ceiling((Object) date1, Calendar.DATE)); 
     assertEquals("ceiling date-2 failed", dateParser.parse("November 19, 2001"), DateUtils.ceiling((Object) date2, Calendar.DATE)); 
     assertEquals("ceiling hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.ceiling((Object) date1, Calendar.HOUR)); 
     assertEquals("ceiling hour-2 failed", dateTimeParser.parse("November 18, 2001 2:00:00.000"), DateUtils.ceiling((Object) date2, Calendar.HOUR)); 
     assertEquals("ceiling minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.ceiling((Object) date1, Calendar.MINUTE)); 
     assertEquals("ceiling minute-2 failed", dateTimeParser.parse("November 18, 2001 1:24:00.000"), DateUtils.ceiling((Object) date2, Calendar.MINUTE)); 
     assertEquals("ceiling second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) date1, Calendar.SECOND)); 
     assertEquals("ceiling second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) date2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) dateAmPm4, Calendar.AM_PM)); 
     assertEquals("ceiling calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.ceiling((Object) cal1, Calendar.SECOND)); 
     assertEquals("ceiling calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:12.000"), DateUtils.ceiling((Object) cal2, Calendar.SECOND)); 
     assertEquals("ceiling ampm-1 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.ceiling((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-3 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("ceiling ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.ceiling((Object) calAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.ceiling((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.ceiling("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.ceiling(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling(date7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 31, 2003 00:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.DATE)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.ceiling((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("ceiling MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.ceiling((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date ceiling tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
     final Date endOfTime = new Date(Long.MAX_VALUE); 
     final GregorianCalendar endCal = new GregorianCalendar(); 
     endCal.setTime(endOfTime); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000001); 
     try { 
         DateUtils.ceiling(endCal, Calendar.DATE); 
         fail(); 
     } catch (final ArithmeticException ex) { 
     } 
     endCal.set(Calendar.YEAR, 280000000); 
     final Calendar cal = DateUtils.ceiling(endCal, Calendar.DATE); 
     assertEquals(0, cal.get(Calendar.HOUR)); 
 } 
@Test 
 public void testWeekIterator8295() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testSetDays8296() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setDays(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 1, 4, 3, 2, 1); 
     result = DateUtils.setDays(base, 29); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 29, 4, 3, 2, 1); 
     try { 
         result = DateUtils.setDays(base, 32); 
         fail("DateUtils.setDays did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testParseDate8535() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testAddWeeks8607() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addWeeks(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addWeeks(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 12, 4, 3, 2, 1); 
     result = DateUtils.addWeeks(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 5, 28, 4, 3, 2, 1); 
 } 
@Test 
 public void testLang5308699() throws ParseException { 
     final Date d = new Date(); 
     final String isoDateStr = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(d); 
     final Date d2 = DateUtils.parseDate(isoDateStr, new String[] { DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern() }); 
     assertEquals("Date not equal to itself ISO formatted and parsed", d.getTime(), d2.getTime() + d.getTime() % 1000); 
 } 
@Test 
 public void testParseDate8712() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testIteratorEx8751() throws Exception { 
     try { 
         DateUtils.iterator(Calendar.getInstance(), -9999); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Date) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Calendar) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Object) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator("", DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
 } 
@Test 
 public void testLANG799_EN_WITH_DE_LOCALE8782() throws ParseException { 
     final Locale dflt = Locale.getDefault(); 
     Locale.setDefault(Locale.ENGLISH); 
     try { 
         DateUtils.parseDate("Mi, 09 Apr 2008 23:55:38 GMT", Locale.GERMAN, "EEE, dd MMM yyyy HH:mm:ss zzz"); 
     } finally { 
         Locale.setDefault(dflt); 
     } 
 } 
@Test 
 public void testSetMinutes8895() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setMinutes(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 0, 2, 1); 
     result = DateUtils.setMinutes(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 59, 2, 1); 
     try { 
         result = DateUtils.setMinutes(base, 60); 
         fail("DateUtils.setMinutes did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testAddYears8899() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.addYears(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addYears(base, 1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2001, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.addYears(base, -1); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 1999, 6, 5, 4, 3, 2, 1); 
 } 
@Test 
 public void testRound9013() throws Exception { 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round(date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round(date2, Calendar.MONTH)); 
     assertEquals("round semimonth-0 failed", dateParser.parse("February 1, 2002"), DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round(date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round(date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round(date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round(date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round(date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round(date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round(date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round(date2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round(dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round(dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round(dateAmPm4, Calendar.AM_PM)); 
     assertEquals("round year-1 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date1, Calendar.YEAR)); 
     assertEquals("round year-2 failed", dateParser.parse("January 1, 2002"), DateUtils.round((Object) date2, Calendar.YEAR)); 
     assertEquals("round month-1 failed", dateParser.parse("February 1, 2002"), DateUtils.round((Object) date1, Calendar.MONTH)); 
     assertEquals("round month-2 failed", dateParser.parse("December 1, 2001"), DateUtils.round((Object) date2, Calendar.MONTH)); 
     assertEquals("round semimonth-1 failed", dateParser.parse("February 16, 2002"), DateUtils.round((Object) date1, DateUtils.SEMI_MONTH)); 
     assertEquals("round semimonth-2 failed", dateParser.parse("November 16, 2001"), DateUtils.round((Object) date2, DateUtils.SEMI_MONTH)); 
     assertEquals("round date-1 failed", dateParser.parse("February 13, 2002"), DateUtils.round((Object) date1, Calendar.DATE)); 
     assertEquals("round date-2 failed", dateParser.parse("November 18, 2001"), DateUtils.round((Object) date2, Calendar.DATE)); 
     assertEquals("round hour-1 failed", dateTimeParser.parse("February 12, 2002 13:00:00.000"), DateUtils.round((Object) date1, Calendar.HOUR)); 
     assertEquals("round hour-2 failed", dateTimeParser.parse("November 18, 2001 1:00:00.000"), DateUtils.round((Object) date2, Calendar.HOUR)); 
     assertEquals("round minute-1 failed", dateTimeParser.parse("February 12, 2002 12:35:00.000"), DateUtils.round((Object) date1, Calendar.MINUTE)); 
     assertEquals("round minute-2 failed", dateTimeParser.parse("November 18, 2001 1:23:00.000"), DateUtils.round((Object) date2, Calendar.MINUTE)); 
     assertEquals("round second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) date1, Calendar.SECOND)); 
     assertEquals("round second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) date2, Calendar.SECOND)); 
     assertEquals("round calendar second-1 failed", dateTimeParser.parse("February 12, 2002 12:34:57.000"), DateUtils.round((Object) cal1, Calendar.SECOND)); 
     assertEquals("round calendar second-2 failed", dateTimeParser.parse("November 18, 2001 1:23:11.000"), DateUtils.round((Object) cal2, Calendar.SECOND)); 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) dateAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) dateAmPm4, Calendar.AM_PM)); 
     try { 
         DateUtils.round((Date) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Calendar) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round((Object) null, Calendar.SECOND); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.round("", Calendar.SECOND); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
     try { 
         DateUtils.round(date1, -9999); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEquals("round ampm-1 failed", dateTimeParser.parse("February 3, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm1, Calendar.AM_PM)); 
     assertEquals("round ampm-2 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm2, Calendar.AM_PM)); 
     assertEquals("round ampm-3 failed", dateTimeParser.parse("February 3, 2002 12:00:00.000"), DateUtils.round((Object) calAmPm3, Calendar.AM_PM)); 
     assertEquals("round ampm-4 failed", dateTimeParser.parse("February 4, 2002 00:00:00.000"), DateUtils.round((Object) calAmPm4, Calendar.AM_PM)); 
     TimeZone.setDefault(zone); 
     dateTimeParser.setTimeZone(zone); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal4, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal5, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal6, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round(date7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 00:00:00.000"), DateUtils.round((Object) cal7, Calendar.DATE)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round(date4, Calendar.HOUR_OF_DAY)); 
     assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 01:00:00.000"), DateUtils.round((Object) cal4, Calendar.HOUR_OF_DAY)); 
     if (SystemUtils.isJavaVersionAtLeast(JAVA_1_4)) { 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal5, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round(date6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 03:00:00.000"), DateUtils.round((Object) cal6, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round(date7, Calendar.HOUR_OF_DAY)); 
         assertEquals("round MET date across DST change-over", dateTimeParser.parse("March 30, 2003 04:00:00.000"), DateUtils.round((Object) cal7, Calendar.HOUR_OF_DAY)); 
     } else { 
         this.warn("WARNING: Some date rounding tests not run since the current version is " + SystemUtils.JAVA_SPECIFICATION_VERSION); 
     } 
     TimeZone.setDefault(defaultZone); 
     dateTimeParser.setTimeZone(defaultZone); 
 } 
@Test 
 public void testIteratorEx9141() throws Exception { 
     try { 
         DateUtils.iterator(Calendar.getInstance(), -9999); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Date) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Calendar) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator((Object) null, DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.iterator("", DateUtils.RANGE_WEEK_CENTER); 
         fail(); 
     } catch (final ClassCastException ex) { 
     } 
 } 
@Test 
 public void testParseDate9313() throws Exception { 
     final GregorianCalendar cal = new GregorianCalendar(1972, 11, 3); 
     String dateStr = "1972-12-03"; 
     final String[] parsers = new String[] { "yyyy'-'DDD", "yyyy'-'MM'-'dd", "yyyyMMdd" }; 
     Date date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "1972-338"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     dateStr = "19721203"; 
     date = DateUtils.parseDate(dateStr, parsers); 
     assertEquals(cal.getTime(), date); 
     try { 
         DateUtils.parseDate("PURPLE", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate("197212AB", parsers); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
     try { 
         DateUtils.parseDate(null, parsers); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, (String[]) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.parseDate(dateStr, new String[0]); 
         fail(); 
     } catch (final ParseException ex) { 
     } 
 } 
@Test 
 public void testSetSeconds9368() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setSeconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 0, 1); 
     result = DateUtils.setSeconds(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 59, 1); 
     try { 
         result = DateUtils.setSeconds(base, 60); 
         fail("DateUtils.setSeconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
 public void testIsSameDay_Cal9421() { 
     final GregorianCalendar cal1 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     final GregorianCalendar cal2 = new GregorianCalendar(2004, 6, 9, 13, 45); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.DAY_OF_YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     cal1.add(Calendar.DAY_OF_YEAR, 1); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     cal2.add(Calendar.YEAR, 1); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     try { 
         DateUtils.isSameDay((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testWeekIterator9473() throws Exception { 
     final Calendar now = Calendar.getInstance(); 
     for (int i = 0; i < 7; i++) { 
         final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
         final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
         sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
         final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
         if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
             monday.add(Calendar.DATE, -6); 
         } else { 
             monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
         } 
         final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
         centered.add(Calendar.DATE, -3); 
         Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
         assertWeekIterator(it, sunday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
         assertWeekIterator(it, monday); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
         assertWeekIterator(it, today); 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
         assertWeekIterator(it, centered); 
         try { 
             it.next(); 
             fail(); 
         } catch (final NoSuchElementException ex) { 
         } 
         it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
         it.next(); 
         try { 
             it.remove(); 
         } catch (final UnsupportedOperationException ex) { 
         } 
         now.add(Calendar.DATE, 1); 
     } 
 } 
@Test 
 public void testIsSameDay_Date9506() { 
     Date date1 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     Date date2 = new GregorianCalendar(2004, 6, 9, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     date1 = new GregorianCalendar(2004, 6, 10, 13, 45).getTime(); 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     date2 = new GregorianCalendar(2005, 6, 10, 13, 45).getTime(); 
     assertFalse(DateUtils.isSameDay(date1, date2)); 
     try { 
         DateUtils.isSameDay((Date) null, (Date) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 } 
@Test 
 public void testSetMilliseconds9524() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setMilliseconds(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 0); 
     result = DateUtils.setMilliseconds(base, 999); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 999); 
     try { 
         result = DateUtils.setMilliseconds(base, 1000); 
         fail("DateUtils.setMilliseconds did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 } 
@Test 
     public void testWeekIterator9600() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSecond9646() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testTruncateSemiMonth10833() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10834() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10835() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10836() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testRoundSemiMonth10837() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testWeekIterator10838() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testRoundSemiMonth10839() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSemiMonth10840() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10841() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testRoundSemiMonth10842() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth10843() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth10844() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testWeekIterator10845() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10846() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10847() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10848() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testWeekIterator10849() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10850() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10851() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10852() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10853() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10854() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10855() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10856() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10857() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10858() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testWeekIterator10859() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10860() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSecond10861() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testWeekIterator10862() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10863() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10864() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10865() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10866() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSecond10867() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testRoundSemiMonth10868() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth10869() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSecond10870() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testWeekIterator10871() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10872() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10873() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10874() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10875() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10876() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10877() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testRoundSemiMonth10878() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSemiMonth10879() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10880() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10881() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10882() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testRoundSemiMonth10883() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSemiMonth10884() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth10885() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10886() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10887() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10888() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10889() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10890() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10891() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10892() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10893() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10894() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10895() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10896() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSecond10897() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testTruncateSemiMonth10898() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10899() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testRoundSemiMonth10900() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSecond10901() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testWeekIterator10902() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10903() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10904() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSemiMonth10905() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth10906() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testRoundSemiMonth10907() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth10908() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testWeekIterator10909() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testWeekIterator10910() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testRoundSemiMonth10911() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testWeekIterator10912() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try { 

@Test 
     public void testTruncateSemiMonth10913() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testRoundSemiMonth10914() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSemiMonth11735() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSecond11736() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testTruncateSecond11737() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testRoundSemiMonth11738() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth11739() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth11740() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSecond11741() throws Exception { 
         final int calendarField = Calendar.SECOND; 
         final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
         baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
     } 
      
     /** 
      * Test DateUtils.truncate()-method with Calendar.SECOND 
      *  
      * @throws Exception 
      * @since 3.0 
      */ 

@Test 
     public void testRoundSemiMonth11742() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSemiMonth11743() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth11744() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("Febr
@Test 
     public void testTruncateSemiMonth11745() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (3) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (4) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
@Test 
     public void testTruncateSemiMonth11746() throws Exception { 
         final int calendarField = DateUtils.SEMI_MONTH; 
         Date truncatedDate, lastTruncateDate; 
          
         //month with 28 days (1) 
         truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
         lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 28 days (2) 
         truncatedDate = dateTimeParser.parse("February 16, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         lastTruncateDate = dateTimeParser.parse("February 29, 2007 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 29 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (1) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
  
         //month with 30 days (2) 
         truncatedDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
         baseTruncateTest(truncatedDate, lastTruncateDate
