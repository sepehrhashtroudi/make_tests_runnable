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
