@Test
public void testAppend_StringInt12366() { 
         assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("+foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("+foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("+foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("+foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
          
         assertEquals("foo", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, '-').toString()); 
         assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, -1).toString()); 
          
         assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, -1).toString()); 
         assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, -1).toString()); 
         assertEquals("f*", FormattableUtils.append("foo", new Formatter(), 0, -1, -1, -1).toString()); 
         assertEquals("f*", Formattable