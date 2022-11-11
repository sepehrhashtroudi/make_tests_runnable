@Test
public void testToMap_object11009() { 
         final Object[] obj = new Object[] { "0", "1", "2", "3", null, "0" }; 
         final Map<Object, Object> map = ArrayUtils.toMap(obj); 
         assertEquals(3, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
         assertEquals(null, map.get("3")); 
          
         map = ArrayUtils.toMap(obj); 
         assertEquals(3, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
          
         map = ArrayUtils.toMap(obj); 
         assertEquals(3, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
          
         map = ArrayUtils.toMap(new Object[] { "0", "1", "2", "3", null, "0" }); 
         assertEquals(6, map.size()); 
         assertEquals("0", map.get("1")); 
         assertEquals("1", map.get("2")); 
         assertEquals("2", map.get("3")); 
          
         map = ArrayUtils.toMap(new Object[] { "0", "1", "2", "3", "4" }); 
         assertEquals(6, map.size()); 
         assertEquals("0", map.get("0")); 
         assertEquals("1", map.get("1")); 
         assertEquals("2", map.get("2")); 
         assert