@Test
public void testFormatPeriod11310() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(0, 1, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(0, 2, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(0, 3, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(0, 4, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(0, 5, "0:00:00.5", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(0, 6, "0:00:00.6", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(0, 7, "0:00:00.7", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.8", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.9", false, TimeZone.getDefault())); 
          
         assertEquals("0:00:00.999", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.999", false, TimeZone.getDefault())); 
         assertEquals("0