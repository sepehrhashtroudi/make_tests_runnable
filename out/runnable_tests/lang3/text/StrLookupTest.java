@Test 
 public void testNoneLookup4734() { 
     assertEquals(null, StrLookup.noneLookup().lookup(null)); 
     assertEquals(null, StrLookup.noneLookup().lookup("")); 
     assertEquals(null, StrLookup.noneLookup().lookup("any")); 
 } 
@Test 
 public void testNoneLookup6972() { 
     assertEquals(null, StrLookup.noneLookup().lookup(null)); 
     assertEquals(null, StrLookup.noneLookup().lookup("")); 
     assertEquals(null, StrLookup.noneLookup().lookup("any")); 
 } 
@Test 
 public void testSystemProperiesLookup7120() { 
     assertEquals(System.getProperty("os.name"), StrLookup.systemPropertiesLookup().lookup("os.name")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("other")); 
     try { 
         StrLookup.systemPropertiesLookup().lookup(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
@Test 
 public void testNoneLookup8053() { 
     assertEquals(null, StrLookup.noneLookup().lookup(null)); 
     assertEquals(null, StrLookup.noneLookup().lookup("")); 
     assertEquals(null, StrLookup.noneLookup().lookup("any")); 
 } 
@Test 
 public void testSystemProperiesLookup8342() { 
     assertEquals(System.getProperty("os.name"), StrLookup.systemPropertiesLookup().lookup("os.name")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("other")); 
     try { 
         StrLookup.systemPropertiesLookup().lookup(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 } 
