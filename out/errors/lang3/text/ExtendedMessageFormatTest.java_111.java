@Test
public void testEqualsHashcode10193() { 
         final Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory()); 
         final Map<String, ? extends FormatFactory> otherRegitry = Collections.singletonMap("testfmt", new UpperCaseFormatFactory()); 
  
         final String pattern = "Pattern: {0,testfmt}"; 
         final ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry); 
  
         ExtendedMessageFormat other = null; 
  
         // Same object 
         assertTrue("same, equals()",   emf.equals(emf)); 
         assertTrue("same, hashcode()", emf.hashCode() == emf.hashCode()); 
  
         // Equal Object 
         other = new ExtendedMessageFormat(pattern, Locale.US, registry); 
         assertTrue("equal, equals()",   emf.equals(other)); 
         assertTrue("equal, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different Class 
         other = new OtherExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("class, equals()",   emf.equals(other)); 
         assertTrue("class, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different pattern 
         other = new ExtendedMessageFormat("X" + pattern, Locale.US, otherRegitry); 
         assertFalse("pattern, equals()",   emf.equals(other)); 
         assertFalse("pattern, hashcode()", emf.hashCode() == other.hashCode()); 
  
         // Different registry 
         other = new ExtendedMessageFormat(pattern, Locale.US, otherRegitry); 
         assertFalse("registry, equals()",   emf.equals(other)); 
         assertFalse("registry, hashcode()", emf.