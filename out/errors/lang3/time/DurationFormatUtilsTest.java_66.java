@Test
public void testLexx9719() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(0, "00:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(0, "00:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(0, "00:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(0, "00:00:00.3", true)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(0, "00:00:00.4", false)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(0, "00:00:00.5", true)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(0, "00:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(0, "00:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(8, "00:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(8, "00:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(10, "00:00:00.5", false)); 
         assertEquals("0:00:00.11", DurationFormatUtils.formatDuration(11, "00:00:12", false)); 
         assertEquals("12:00:13", DurationFormatUtils.formatDuration(12, "00:13", false)); 
         assertEquals("14:00:14.15", DurationFormatUtils.formatDuration(14, "00:15", false)); 
         assertEquals("