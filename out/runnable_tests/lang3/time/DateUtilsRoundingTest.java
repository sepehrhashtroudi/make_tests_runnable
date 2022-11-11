@Test 
 public void testTruncateSemiMonth109() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundSemiMonth282() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 24, 2007 00:00:00.000"); 
     maxDate = dateTimeParser.parse("January 8, 2008 23:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond390() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSemiMonth880() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundAmPm1021() throws Exception { 
     final int calendarField = Calendar.AM_PM; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 12:00:00.000"); 
     roundedDownDate = targetAmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 5:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetPmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 17:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 18:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 5:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateSemiMonth1137() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond2071() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond2653() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSemiMonth3006() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundDayOfMonth3063() throws Exception { 
     final int calendarField = Calendar.DAY_OF_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetDayOfMonthDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 11:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 12:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 11:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond3117() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond3311() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSemiMonth3601() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundAmPm3730() throws Exception { 
     final int calendarField = Calendar.AM_PM; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 12:00:00.000"); 
     roundedDownDate = targetAmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 5:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetPmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 17:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 18:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 5:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testRoundDayOfMonth3861() throws Exception { 
     final int calendarField = Calendar.DAY_OF_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetDayOfMonthDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 11:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 12:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 11:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond3883() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSemiMonth3975() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundMinute4482() throws Exception { 
     final int calendarField = Calendar.MINUTE; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 8:16:00.000"); 
     roundedDownDate = targetMinuteDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 8:15:29.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 23:59:30.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 0:00:29.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateMilliSecond4804() throws Exception { 
     final int calendarField = Calendar.MILLISECOND; 
     baseTruncateTest(targetMilliSecondDate, targetMilliSecondDate, calendarField); 
 } 
@Test 
 public void testTruncateSemiMonth4875() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond5276() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond5481() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundSemiMonth5619() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 24, 2007 00:00:00.000"); 
     maxDate = dateTimeParser.parse("January 8, 2008 23:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testRoundSemiMonth5760() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 24, 2007 00:00:00.000"); 
     maxDate = dateTimeParser.parse("January 8, 2008 23:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond6534() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond6860() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundAmPm7070() throws Exception { 
     final int calendarField = Calendar.AM_PM; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 12:00:00.000"); 
     roundedDownDate = targetAmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 5:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetPmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 17:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 18:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 5:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond7271() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testTruncateSemiMonth7599() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date truncatedDate, lastTruncateDate; 
     truncatedDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 28, 2007 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("February 29, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("April 30, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 15, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
     truncatedDate = dateTimeParser.parse("March 16, 2008 0:00:00.000"); 
     lastTruncateDate = dateTimeParser.parse("March 31, 2008 23:59:59.999"); 
     baseTruncateTest(truncatedDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundAmPm7885() throws Exception { 
     final int calendarField = Calendar.AM_PM; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 12:00:00.000"); 
     roundedDownDate = targetAmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 5:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetPmDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 17:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 18:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 5:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testRoundDayOfMonth8099() throws Exception { 
     final int calendarField = Calendar.DAY_OF_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetDayOfMonthDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 11:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 12:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 11:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testTruncateSecond8988() throws Exception { 
     final int calendarField = Calendar.SECOND; 
     final Date lastTruncateDate = dateTimeParser.parse("June 1, 2008 8:15:14.999"); 
     baseTruncateTest(targetSecondDate, lastTruncateDate, calendarField); 
 } 
@Test 
 public void testRoundSemiMonth9182() throws Exception { 
     final int calendarField = DateUtils.SEMI_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2007 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2007 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2007 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("March 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("February 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("February 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("April 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("April 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 1, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 8, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     roundedUpDate = dateTimeParser.parse("June 1, 2008 0:00:00.000"); 
     roundedDownDate = dateTimeParser.parse("May 16, 2008 0:00:00.000"); 
     lastRoundedDownDate = dateTimeParser.parse("May 23, 2008 23:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 24, 2007 00:00:00.000"); 
     maxDate = dateTimeParser.parse("January 8, 2008 23:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
 public void testRoundDayOfMonth9463() throws Exception { 
     final int calendarField = Calendar.DAY_OF_MONTH; 
     Date roundedUpDate, roundedDownDate, lastRoundedDownDate; 
     Date minDate, maxDate; 
     roundedUpDate = dateTimeParser.parse("June 2, 2008 0:00:00.000"); 
     roundedDownDate = targetDayOfMonthDate; 
     lastRoundedDownDate = dateTimeParser.parse("June 1, 2008 11:59:59.999"); 
     baseRoundTest(roundedUpDate, roundedDownDate, lastRoundedDownDate, calendarField); 
     minDate = dateTimeParser.parse("December 31, 2007 12:00:00.000"); 
     maxDate = dateTimeParser.parse("January 1, 2008 11:59:59.999"); 
     roundToJanuaryFirst(minDate, maxDate, calendarField); 
 } 
@Test 
     public void testRound9629() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 00:00:00.000"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13, 45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-3 failed", 
                 dateParser.parse("November 13, 45:01.231"), 
                 DateUtils.round(date3, DateUtils.SEMI_MONTH)); 
          
         assert
@Test 
     public void testAddMilliseconds9663() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addMilliseconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addMilliseconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addMilliseconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testRoundSemiMonth11438() throws Exception { 
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
     public void testRound11439() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 00:00:00.000"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13, 45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-3 failed", 
                 dateParser.parse("November 13, 45:01.231"), 
                 DateUtils.round(date3, DateUtils.SEMI_MONTH)); 
          
         assert
@Test 
     public void testRound11440() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 0, 2002"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 1, 2001"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 16, 2002"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 18, 2001"), 
                 DateUtils.round(date2, Calendar.DATE)); 
          
         assertEquals("round date-3 failed", 

@Test 
     public void testRound11441() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 0, 2002"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 1, 2001"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 16, 2002"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 18, 2001"), 
                 DateUtils.round(date2, Calendar.DATE)); 
          
         assertEquals("round date-3 failed", 

@Test 
     public void testRound11442() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", [
@Test 
     public void testRound11443() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", [
@Test 
     public void testRound11444() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", [
@Test 
     public void testAddSeconds11445() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addSeconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testAddSeconds11446() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addSeconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testRound11447() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", [
@Test 
     public void testRound11448() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 00:00:00.000"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13, 45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-3 failed", 
                 dateParser.parse("November 13, 45:01.231"), 
                 DateUtils.round(date3, DateUtils.SEMI_MONTH)); 
          
         assert
@Test 
     public void testAddSeconds11449() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addSeconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testRound11450() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 0, 2002"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 1, 2001"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 16, 2002"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 18, 2001"), 
                 DateUtils.round(date2, Calendar.DATE)); 
          
         assertEquals("round date-3 failed", 

@Test 
     public void testAddSeconds11451() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addSeconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testRound11452() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("February 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 0, 2002"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 1, 2002"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 16, 2002"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 18, 2002"), 
                 DateUtils.
@Test 
     public void testRound11453() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 00:00:00.000"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13, 45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-3 failed", 
                 dateParser.parse("November 13, 45:01.231"), 
                 DateUtils.round(date3, DateUtils.SEMI_MONTH)); 
          
         assert
@Test 
     public void testAddMilliseconds11454() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addMilliseconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addMilliseconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addMilliseconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testRound11455() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 0, 2002"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 1, 2001"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 16, 2002"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 18, 2001"), 
                 DateUtils.round(date2, Calendar.DATE)); 
          
         assertEquals("round date-3 failed", 

@Test 
     public void testRound11456() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 00:00:00.000"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13, 45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-3 failed", 
                 dateParser.parse("November 13, 45:01.231"), 
                 DateUtils.round(date3, DateUtils.SEMI_MONTH)); 
          
         assert
@Test 
     public void testRound11457() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 00:00:00.000"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13, 45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-3 failed", 
                 dateParser.parse("November 13, 45:01.231"), 
                 DateUtils.round(date3, DateUtils.SEMI_MONTH)); 
          
         assert
@Test 
     public void testTruncateSemiMonth11458() throws Exception { 
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
     public void testTruncateSemiMonth11459() throws Exception { 
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
     public void testAddSeconds11460() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addSeconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

@Test 
     public void testRound11461() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 0, 2002"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 1, 2001"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 16, 2002"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", 
                 dateParser.parse("November 18, 2001"), 
                 DateUtils.round(date2, Calendar.DATE)); 
          
         assertEquals("round date-3 failed", 

@Test 
     public void testRound11462() throws Exception { 
         // tests for public static Date round(Date date, int field) 
         assertEquals("round year-1 failed", 
                 dateParser.parse("January 1, 2002 14:00:00.000"), 
                 DateUtils.round(date1, Calendar.YEAR)); 
         assertEquals("round year-2 failed", 
                 dateParser.parse("January 1, 2002 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.YEAR)); 
         assertEquals("round month-1 failed", 
                 dateParser.parse("February 1, 2002 00:00:00.000"), 
                 DateUtils.round(date1, Calendar.MONTH)); 
         assertEquals("round month-2 failed", 
                 dateParser.parse("December 1, 2001 13:45:01.231"), 
                 DateUtils.round(date2, Calendar.MONTH)); 
         assertEquals("round semimonth-0 failed", 
                 dateParser.parse("February 16, 2002 00:00:00.000"), 
                 DateUtils.round(date0, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, DateUtils.SEMI_MONTH)); 
         assertEquals("round semimonth-2 failed", 
                 dateParser.parse("November 16, 2002 13:45:01.231"), 
                 DateUtils.round(date2, DateUtils.SEMI_MONTH)); 
          
         assertEquals("round date-1 failed", 
                 dateParser.parse("February 13:45:01.231"), 
                 DateUtils.round(date1, Calendar.DATE)); 
         assertEquals("round date-2 failed", [
@Test 
     public void testAddSeconds11463() throws Exception { 
         final Date base = new Date(MILLIS_TEST); 
         Date result = DateUtils.addSeconds(base, 0); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, 1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
          
         result = DateUtils.addSeconds(base, -1); 
         assertNotSame(base, result); 
         assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
         assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     } 
  
     //----------------------------------------------------------------------- 

