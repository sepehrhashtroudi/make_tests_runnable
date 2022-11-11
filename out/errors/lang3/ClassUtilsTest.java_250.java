@Test
public void test_isAssignable_ClassArray_ClassArray_Autoboxing10829() throws Exception { 
         final Class<?>[] array2 = new Class[] {Object.class, Object.class}; 
         final Class<?>[] array1 = new Class[] {Object.class}; 
         final Class<?>[] array1s = new Class[] {String.class}; 
         final Class<?>[] array0 = new Class[] {}; 
         final Class<?>[] arrayPrimitives = { Integer.TYPE, Boolean.TYPE }; 
         final Class<?>[] arrayWrappers = { Integer.class, Boolean.class }; 
  
         assertTrue(ClassUtils.isAssignable((Class[]) null, (Class[]) null, true)); 
         assertTrue(ClassUtils.isAssignable((Class[]) null, (Class<?>) null, true)); 
         assertTrue(ClassUtils.isAssignable(null, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array0, array1, true)); 
         assertTrue(ClassUtils.isAssignable(array1, array0, true)); 
         assertTrue(ClassUtils.isAssignable(array1, array1, true)); 
         assertTrue(ClassUtils.isAssignable(array1, array1, true)); 
  
         assertTrue(ClassUtils.isAssignable(arrayPrimitives, arrayWrappers, true)); 
         assertTrue(ClassUtils.isAssignable(arrayWrappers, arrayPrimitives, true)); 
         assertTrue(ClassUtils.isAssignable(arrayWrappers, array1, true)); 
         assertTrue(ClassUtils.isAssignable(arrayPrimitives, array1, true)); 
         assertTrue(ClassUtils.isAssignable(arrayWrappers, array2, true)); 
         assertTrue(ClassUtils.