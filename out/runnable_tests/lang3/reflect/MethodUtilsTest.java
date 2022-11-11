@Test 
 public void testInvokeMethod25() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription67() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod143() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod295() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeStaticMethod348() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeStaticMethod425() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod436() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod532() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod541() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod604() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod612() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription665() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod682() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactStaticMethod688() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod859() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod1058() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription1241() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod1284() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod1314() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod1370() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription1406() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod1561() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod1585() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription1618() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod1635() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod1707() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodInaccessible1796() throws Exception { 
     final Method expected = TestBean.class.getDeclaredMethod("privateStuff"); 
     final Method actual = MethodUtils.getAccessibleMethod(expected); 
     assertNull(actual); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription1815() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod1951() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod1957() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactStaticMethod2142() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod2230() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface2236() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeMethod2361() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription2465() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription2467() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod2518() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod2531() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod2679() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription2699() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod2760() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod2785() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod2865() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeStaticMethod2878() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod2908() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod2980() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface3002() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeMethod3048() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod3155() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeStaticMethod3179() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetMatchingAccessibleMethod3210() throws Exception { 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testOne", singletonArray(ParentObject.class), singletonArray(ParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testOne", singletonArray(ChildObject.class), singletonArray(ParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testTwo", singletonArray(ParentObject.class), singletonArray(GrandParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testTwo", singletonArray(ChildObject.class), singletonArray(ChildInterface.class)); 
 } 
@Test 
 public void testInvokeMethod3315() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod3458() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod3484() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod3631() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactStaticMethod3691() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod3749() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface3831() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeExactStaticMethod3896() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription3911() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription4010() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeStaticMethod4058() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod4081() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription4158() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription4169() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeStaticMethod4214() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetMatchingAccessibleMethod4412() throws Exception { 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testOne", singletonArray(ParentObject.class), singletonArray(ParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testOne", singletonArray(ChildObject.class), singletonArray(ParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testTwo", singletonArray(ParentObject.class), singletonArray(GrandParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testTwo", singletonArray(ChildObject.class), singletonArray(ChildInterface.class)); 
 } 
@Test 
 public void testInvokeMethod4415() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface4513() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeMethod4659() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod4682() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod4840() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription4944() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeExactMethod4945() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface4968() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeStaticMethod4975() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod4999() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription5103() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod5332() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod5524() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod5565() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface5647() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeMethod5662() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod5763() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeStaticMethod5764() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod5767() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription5792() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod5808() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeStaticMethod5845() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod5848() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod6021() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription6060() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeStaticMethod6086() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeStaticMethod6218() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactMethod6227() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription6403() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod6427() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod6461() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod6503() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription6582() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod6658() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactStaticMethod6686() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription6769() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeExactMethod6778() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod6805() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod6816() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface6926() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription6992() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod7018() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod7161() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod7204() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod7223() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactMethod7227() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactStaticMethod7309() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod7475() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod7539() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod7579() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeStaticMethod7638() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod7776() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactMethod7786() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod7939() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod7977() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod8061() throws Exception { 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(TestBean.class, "foo", singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testOne", singletonArray(ParentObject.class), singletonArray(ParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testOne", singletonArray(ChildObject.class), singletonArray(ParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testTwo", singletonArray(ParentObject.class), singletonArray(GrandParentObject.class)); 
     expectMatchingAccessibleMethodParameterTypes(InheritanceBean.class, "testTwo", singletonArray(ChildObject.class), singletonArray(ChildInterface.class)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface8150() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeMethod8178() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod8358() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription8364() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testGetAccessibleInterfaceMethodFromDescription8379() throws Exception { 
     final Class<?>[][] p = { ArrayUtils.EMPTY_CLASS_ARRAY, null }; 
     for (final Class<?>[] element : p) { 
         final Method accessibleMethod = MethodUtils.getAccessibleMethod(TestMutable.class, "getValue", element); 
         assertSame(Mutable.class, accessibleMethod.getDeclaringClass()); 
     } 
 } 
@Test 
 public void testInvokeMethod8441() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeExactStaticMethod8487() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactMethod8558() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeExactMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeExactMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeExactMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Integer)", MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeExactMethod(testBean, "foo", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactMethod(testBean, "foo", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeMethod8567() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod8574() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeStaticMethod8720() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testConstructor8731() throws Exception { 
     assertNotNull(MethodUtils.class.newInstance()); 
 } 
@Test 
 public void testInvokeMethod8755() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod9002() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testGetAccessibleMethodPrivateInterface9017() throws Exception { 
     final Method expected = TestBeanWithInterfaces.class.getMethod("foo"); 
     assertNotNull(expected); 
     final Method actual = MethodUtils.getAccessibleMethod(TestBeanWithInterfaces.class, "foo"); 
     assertNull(actual); 
 } 
@Test 
 public void testInvokeExactStaticMethod9023() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Integer)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE })); 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         MethodUtils.invokeExactStaticMethod(TestBean.class, "bar", Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeStaticMethod9042() throws Exception { 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null)); 
     assertEquals("bar()", MethodUtils.invokeStaticMethod(TestBean.class, "bar", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("bar(String)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", "")); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", new Object())); 
     assertEquals("bar(Object)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", Boolean.TRUE)); 
     assertEquals("bar(Integer)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.INTEGER_ONE)); 
     assertEquals("bar(int)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.BYTE_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.LONG_ONE)); 
     assertEquals("bar(double)", MethodUtils.invokeStaticMethod(TestBean.class, "bar", NumberUtils.DOUBLE_ONE)); 
     try { 
         MethodUtils.invokeStaticMethod(TestBean.class, "does_not_exist"); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testConstructor9327() throws Exception { 
     assertNotNull(MethodUtils.class.newInstance()); 
 } 
@Test 
 public void testInvokeMethod9372() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod9433() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
@Test 
 public void testInvokeMethod9540() throws Exception { 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null)); 
     assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", (Object[]) null, (Class<?>[]) null)); 
     assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", "")); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", new Object())); 
     assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", Boolean.TRUE)); 
     assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.INTEGER_ONE)); 
     assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.BYTE_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.LONG_ONE)); 
     assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", NumberUtils.DOUBLE_ONE)); 
 } 
