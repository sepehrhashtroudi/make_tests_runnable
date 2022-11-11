@Test
public void testLexx9755() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000", false)); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001", true)); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2", false)); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3", false)); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4", true)); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5", false)); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6", false)); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7", true)); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:00.8", false)); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatDuration(time, "0:00:00.9", false)); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:00:10", false)); 
         assertEquals("0:00:11", DurationFormatUtils.formatDuration(time, "0:11", false)); 
         assertEquals("0:12", DurationFormatUtils.formatDuration(time, "0:12", true)); 
         assertEquals("0:13", DurationFormatUtils.formatDuration(time, "0:13", false)); 
         assertEquals("0:14