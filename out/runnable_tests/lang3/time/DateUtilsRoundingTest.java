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
