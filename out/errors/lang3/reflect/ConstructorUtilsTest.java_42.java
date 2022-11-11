@Test
public void testGetAccessibleMethod11603() throws Exception { 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 ArrayUtils.EMPTY_CLASS_ARRAY, ArrayUtils.EMPTY_CLASS_ARRAY); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, null, 
                 ArrayUtils.EMPTY_CLASS_ARRAY); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(String.class), singletonArray(String.class)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Object.class), singletonArray(Object.class)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Boolean.class), singletonArray(Object.class)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Byte.class), singletonArray(Integer.TYPE)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Byte.TYPE), singletonArray(Integer.TYPE)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Short.class), singletonArray(Integer.TYPE)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Short.TYPE), singletonArray(Integer.TYPE)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Character.class), singletonArray(Integer.TYPE)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Integer.class), singletonArray(Integer.class)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Integer.TYPE), singletonArray(Integer.TYPE)); 
         expectMatchingAccessibleConstructorParameterTypes(TestBean.class, 
                 singletonArray(Integer.class), singletonArray(Integer.class)); 
         expectMatchingAccessibleConstructor