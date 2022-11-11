@Test 
 public void test_toStringExcludeCollectionWithNulls2248() { 
     final List<String> excludeList = new ArrayList<String>(); 
     excludeList.add(null); 
     excludeList.add(null); 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
     this.validateSecretFieldPresent(toString); 
 } 
@Test 
 public void test_toStringExcludeCollectionWithNulls4740() { 
     final List<String> excludeList = new ArrayList<String>(); 
     excludeList.add(null); 
     excludeList.add(null); 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
     this.validateSecretFieldPresent(toString); 
 } 
@Test 
 public void test_toStringExcludeCollectionWithNulls6290() { 
     final List<String> excludeList = new ArrayList<String>(); 
     excludeList.add(null); 
     excludeList.add(null); 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
     this.validateSecretFieldPresent(toString); 
 } 
@Test 
 public void test_toStringExcludeNullCollection7316() { 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), (Collection<String>) null); 
     this.validateSecretFieldPresent(toString); 
 } 
@Test 
 public void test_toStringExcludeCollectionWithNulls7583() { 
     final List<String> excludeList = new ArrayList<String>(); 
     excludeList.add(null); 
     excludeList.add(null); 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
     this.validateSecretFieldPresent(toString); 
 } 
@Test 
 public void test_toStringExcludeNullArray8069() { 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), (String[]) null); 
     this.validateSecretFieldPresent(toString); 
 } 
@Test 
 public void test_toStringExcludeCollectionWithNulls8519() { 
     final List<String> excludeList = new ArrayList<String>(); 
     excludeList.add(null); 
     excludeList.add(null); 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
     this.validateSecretFieldPresent(toString); 
 } 
@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid9596() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10700() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10701() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void test_toStringExcludeCollectionWithNulls10702() { 
         final List<String> excludeList = new ArrayList<String>(); 
         excludeList.add(null); 
         excludeList.add(null); 
         excludeList.add(null); 
         final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
         this.validateSecretFieldPresent(toString); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10703() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10704() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10705() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10706() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10707() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10708() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10709() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10710() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10711() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10712() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10713() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void testReflectionStatics10714() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10715() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10716() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10717() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10718() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10719() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10720() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10721() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void testReflectionStatics10722() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 

@Test 
     public void test_toStringExcludeCollectionWithNulls10723() { 
         final List<String> excludeList = new ArrayList<String>(); 
         excludeList.add(null); 
         excludeList.add(null); 
         excludeList.add(null); 
         final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
         this.validateSecretFieldPresent(toString); 
     } 
  

@Test 
     public void testReflectionStatics10724() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10725() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void test_toStringExcludeCollectionWithNulls10726() { 
         final List<String> excludeList = new ArrayList<String>(); 
         excludeList.add(null); 
         excludeList.add(null); 
         excludeList.add(null); 
         final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
         this.validateSecretFieldPresent(toString); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10727() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void testReflectionStatics10728() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10729() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void testReflectionStatics10730() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  

@Test 
     public void test_toStringExcludeCollectionWithNulls10731() { 
         final List<String> excludeList = new ArrayList<String>(); 
         excludeList.add(null); 
         excludeList.add(null); 
         excludeList.add(null); 
         final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
         this.validateSecretFieldPresent(toString); 
     } 
  

@Test 
     public void test_toStringExcludeCollectionWithNulls10732() { 
         final List<String> excludeList = new ArrayList<String>(); 
         excludeList.add(null); 
         excludeList.add(null); 
         excludeList.add(null); 
         final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
         this.validateSecretFieldPresent(toString); 
     } 
  

@Test 
     public void test_toStringExcludeCollectionWithNulls10733() { 
         final List<String> excludeList = new ArrayList<String>(); 
         excludeList.add(null); 
         excludeList.add(null); 
         excludeList.add(null); 
         final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
         this.validateSecretFieldPresent(toString); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10734() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10735() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void testReflectionStatics10736() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10737() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10738() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10739() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10740() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void testReflectionStatics10741() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  

@Test(expected=IllegalArgumentException.class) 
     public void test_setUpToClass_invalid10742() { 
         final Integer val = Integer.valueOf(5); 
         final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
         try { 
             test.setUpToClass(String.class); 
         } finally { 
             test.toString(); 
         } 
     } 
  
     /** 
      * Tests ReflectionToStringBuilder.toString() for statics. 
      */ 
     class ReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
         static final transient String staticTransientString = "staticTransientString"; 
         static final transient int staticTransientInt = 54321; 
         String instanceString = "instanceString"; 
         int instanceInt = 67890; 
         transient String transientString = "transientString"; 
         transient int transientInt = 98765; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class SimpleReflectionStaticFieldsFixture { 
         static final String staticString = "staticString"; 
         static final int staticInt = 12345; 
     } 
  
     /** 
      * Test fixture for ReflectionToStringBuilder.toString() for statics. 
      */ 
     class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture { 
         static final String staticString2 = "staticString2"; 
         static final int staticInt2 = 67890; 
     } 
  

@Test 
     public void testReflectionStatics10743() { 
         final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", 
             ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
         assertEquals( 
             this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", 
             this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     } 
  

