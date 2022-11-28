@Test 
 public void testGetMatchingAccessibleMethod70() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeExactConstructor124() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactConstructor285() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeConstructor712() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod837() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeExactConstructor929() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactConstructor1182() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeConstructor1244() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testInvokeConstructor1926() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod1932() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod1994() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeConstructor2103() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testInvokeConstructor2405() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testInvokeConstructor2426() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testInvokeExactConstructor2549() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactConstructor2718() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetMatchingAccessibleMethod3021() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testGetAccessibleConstructor3115() throws Exception { 
     assertNotNull(ConstructorUtils.getAccessibleConstructor(Object.class.getConstructor(ArrayUtils.EMPTY_CLASS_ARRAY))); 
     assertNull(ConstructorUtils.getAccessibleConstructor(PrivateClass.class.getConstructor(ArrayUtils.EMPTY_CLASS_ARRAY))); 
 } 
@Test 
 public void testGetAccessibleConstructor3571() throws Exception { 
     assertNotNull(ConstructorUtils.getAccessibleConstructor(Object.class.getConstructor(ArrayUtils.EMPTY_CLASS_ARRAY))); 
     assertNull(ConstructorUtils.getAccessibleConstructor(PrivateClass.class.getConstructor(ArrayUtils.EMPTY_CLASS_ARRAY))); 
 } 
@Test 
 public void testInvokeExactConstructor4202() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetMatchingAccessibleMethod4297() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeConstructor4444() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testInvokeConstructor4548() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod4639() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeConstructor4969() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod5257() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeExactConstructor5683() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactConstructor5749() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testInvokeExactConstructor6101() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetMatchingAccessibleMethod6414() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeExactConstructor6464() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetMatchingAccessibleMethod7033() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod7147() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeConstructor7210() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("()", ConstructorUtils.invokeConstructor(TestBean.class).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeConstructor(TestBean.class, Boolean.TRUE).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(int)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.BYTE_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.LONG_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeConstructor(TestBean.class, NumberUtils.DOUBLE_ONE).toString()); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod7723() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod7872() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod8131() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testInvokeExactConstructor8352() throws Exception { 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY).toString()); 
     assertEquals("()", ConstructorUtils.invokeExactConstructor(TestBean.class, (Object[]) null).toString()); 
     assertEquals("(String)", ConstructorUtils.invokeExactConstructor(TestBean.class, "").toString()); 
     assertEquals("(Object)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object()).toString()); 
     assertEquals("(Integer)", ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.INTEGER_ONE).toString()); 
     assertEquals("(double)", ConstructorUtils.invokeExactConstructor(TestBean.class, new Object[] { NumberUtils.DOUBLE_ONE }, new Class[] { Double.TYPE }).toString()); 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.BYTE_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, NumberUtils.LONG_ONE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
     try { 
         ConstructorUtils.invokeExactConstructor(TestBean.class, Boolean.TRUE); 
         fail("should throw NoSuchMethodException"); 
     } catch (final NoSuchMethodException e) { 
     } 
 } 
@Test 
 public void testGetMatchingAccessibleMethod8702() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
@Test 
 public void testGetMatchingAccessibleMethod9130() throws Exception { 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, ArrayUtils.EMPTY_CLASS_ARRAY); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(String.class), singletonArray(String.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Object.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Boolean.class), singletonArray(Object.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.class), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Character.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.class), singletonArray(Integer.class)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Long.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Float.TYPE), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.class), singletonArray(Double.TYPE)); 
     expectMatchingAccessibleConstructorParameterTypes(TestBean.class, singletonArray(Double.TYPE), singletonArray(Double.TYPE)); 
 } 
