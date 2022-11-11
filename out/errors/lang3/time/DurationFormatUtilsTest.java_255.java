@Test
public void testFormatDurationISO11866() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.1", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDurationISO(time)); 
  
         time = 1L; 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDurationISO(time)); 
  
         try { 
             DurationFormatUtils.formatDurationISO(time); 
             fail("Expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
         try { 
             DurationFormatUtils.formatDurationISO(time); 
             fail("Expected IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } [