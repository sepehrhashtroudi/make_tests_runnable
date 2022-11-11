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