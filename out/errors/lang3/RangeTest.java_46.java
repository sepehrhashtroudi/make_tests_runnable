@Test
public void testIsAfterRange5609() { 
     assertFalse(intRange.isAfterRange(null)); 
     assertTrue(intRange.isAfterRange(Range.between(5, 9))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 10))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 20))); 
     assertFalse(intRange.isAfterRange(Range.between(5, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(15, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(21, 25))); 
     assertFalse(intRange.isAfterRange(Range.between(10, 20))); 
 } 
@SuppressWarnings({ "rawtypes", "unchecked" })