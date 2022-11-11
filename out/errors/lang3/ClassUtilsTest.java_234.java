@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing10813() throws Exception { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {Object.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertTrue(ClassUtils.isAssignable(array1, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array2, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertTrue(ClassUtils.isAssignable(array1, array1s, true)); 
         assertTrue(ClassUtils.isAssignable(array1s, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
         assertTrue(ClassUtils.isAssignable(array1s, array1, true)); 
  
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertFalse(ClassUtils.isAssignable(arrayPr