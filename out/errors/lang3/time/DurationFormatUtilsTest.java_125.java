@Test
public void testLexx9778() { 
         // tests each constant 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.M, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.d, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 1)}, DurationFormatUtils.lexx("yMdHmsS")); 
  
         // tests the ISO8601-like 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(DurationFormatUtils.H, 1), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.m, 2), 
             new DurationFormatUtils.Token(new StringBuilder(":"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.s, 2), 
             new DurationFormatUtils.Token(new StringBuilder("."), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.S, 3)}, DurationFormatUtils.lexx("H:mm:ss.SSS")); 
  
         // test the iso extended format 
         assertArrayEquals(new DurationFormatUtils.Token[]{ 
             new DurationFormatUtils.Token(new StringBuilder("P"), 1), 
             new DurationFormatUtils.Token(DurationFormatUtils.y, 4), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("M"), 1), 
             new DurationFormatUtils.Token(new StringBuilder("Y"), 1), 
             new DurationFormatUtils.