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