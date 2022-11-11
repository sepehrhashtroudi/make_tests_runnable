@Test 
 public void testHoursOfYearWithDate383() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate720() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfMonthWithDate816() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 } 
@Test 
 public void testMillisecondsOfDayWithDate1480() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 } 
@Test 
 public void testMinutesOfDayWithDate1620() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testHoursOfYearWithDate1681() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate1762() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMillisecondsOfDayWithDate1779() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 } 
@Test 
 public void testMinutesOfMonthWithDate1781() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate1968() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfHourWithCalendar2370() { 
     final long testResult = DateUtils.getFragmentInMinutes(aCalendar, Calendar.HOUR_OF_DAY); 
     assertEquals(minutes, testResult); 
 } 
@Test 
 public void testNullCalendar2392() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testMinutesOfDayWithDate2493() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate2642() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testHoursOfYearWithDate2910() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 } 
@Test 
 public void testMinutesOfHourWithCalendar2970() { 
     final long testResult = DateUtils.getFragmentInMinutes(aCalendar, Calendar.HOUR_OF_DAY); 
     assertEquals(minutes, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate3297() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testHoursOfYearWithDate3305() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 } 
@Test 
 public void testMillisecondsOfDayWithDate3356() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 } 
@Test 
 public void testMinutesOfMonthWithDate3360() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate3401() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate3502() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testSecondsofMinuteWithDate3544() { 
     final long testResult = DateUtils.getFragmentInSeconds(aDate, Calendar.MINUTE); 
     assertEquals(seconds, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate3568() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate3737() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate4292() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfMonthWithDate4370() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 } 
@Test 
 public void testHoursOfYearWithDate4528() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 } 
@Test 
 public void testSecondFragmentInLargerUnitWithCalendar4678() { 
     assertEquals(0, DateUtils.getFragmentInSeconds(aCalendar, Calendar.SECOND)); 
     assertEquals(0, DateUtils.getFragmentInMinutes(aCalendar, Calendar.SECOND)); 
     assertEquals(0, DateUtils.getFragmentInHours(aCalendar, Calendar.SECOND)); 
     assertEquals(0, DateUtils.getFragmentInDays(aCalendar, Calendar.SECOND)); 
 } 
@Test 
 public void testNullDate4910() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testMinutesOfDayWithDate5293() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate5327() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate5421() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfHourWithCalendar5684() { 
     final long testResult = DateUtils.getFragmentInMinutes(aCalendar, Calendar.HOUR_OF_DAY); 
     assertEquals(minutes, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate5728() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate5737() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testNullDate5758() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testMinutesOfDayWithDate5977() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate6256() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate6288() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMillisecondsOfDayWithDate7047() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 } 
@Test 
 public void testMinutesOfDayWithDate7198() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testHoursOfYearWithDate7641() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate7792() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testNullDate7846() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testMinutesOfDayWithDate7935() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate7945() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate8015() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testNullDate8132() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testNullDate8316() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 } 
@Test 
 public void testMinutesOfDayWithDate8634() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMinutesOfDayWithDate8799() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
 public void testMillisecondsOfDayWithDate8916() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 } 
@Test 
 public void testMillisecondFragmentInLargerUnitWithCalendar9122() { 
     assertEquals(0, DateUtils.getFragmentInMilliseconds(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInSeconds(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInMinutes(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInHours(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInDays(aCalendar, Calendar.MILLISECOND)); 
 } 
@Test 
 public void testMinutesOfDayWithDate9437() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 } 
@Test 
     public void testMinutesOfDayWithDate9572() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9863() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9864() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9865() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9866() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testNullCalendar9867() { 
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMinutes((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
     } 
      

@Test 
     public void testMinutesOfDayWithDate9868() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9869() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9870() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9871() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9872() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9873() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9874() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testNullCalendar9875() { 
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
     } 
  

@Test 
     public void testNullCalendar9876() { 
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
  
         try { 
             DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
             fail(); 
         } catch(final IllegalArgumentException iae) {} 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9877() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9878() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

@Test 
     public void testMinutesOfDayWithDate9879() { 
         long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
         final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR))/ DateUtils.MILLIS_PER_MINUTE;  
         assertEquals(expectedValue,testResult); 
         testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
         assertEquals(expectedValue,testResult); 
     } 
  

