@Test
public void testLexx9770() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:14:15.6")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:14:15.21")); 
         assertEquals("0:0:0", DurationFormatUtils.formatDuration(time, "0:14:15.32")); 
         assertEquals("0