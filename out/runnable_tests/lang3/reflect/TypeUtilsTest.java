@Test 
 public void testGetRawType10() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance220() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance249() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testIsArrayGenericTypes337() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertFalse(TypeUtils.isArrayType(types[0])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[1])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[2])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[3])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[4])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[5])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[6])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[7])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[8])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[9])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[10])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[11])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[12])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[13])); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance524() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testGetRawType562() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testGetRawType647() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance733() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testGetRawType903() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance947() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testGetRawType999() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance1717() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance1817() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments1964() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testIsArrayGenericTypes2045() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertFalse(TypeUtils.isArrayType(types[0])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[1])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[2])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[3])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[4])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[5])); 
     Assert.assertFalse(TypeUtils.isArrayType(types[6])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[7])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[8])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[9])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[10])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[11])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[12])); 
     Assert.assertTrue(TypeUtils.isArrayType(types[13])); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance2074() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance2079() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testGetArrayComponentType2115() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance2153() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments2259() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetRawType2453() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments2525() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments2567() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments2577() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testLang8202586() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@Test 
 public void testGetRawType3057() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments3111() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments3214() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments3263() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments3399() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance3999() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance4021() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance4041() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testGetRawType4114() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments4123() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance4235() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments4273() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance4313() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance4402() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testLang8204631() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@Test 
 public void testGetRawType4839() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testGetArrayComponentType4857() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@Test 
 public void testGetRawType4877() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance5030() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance5105() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance5117() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testGetRawType5406() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments5454() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetRawType5559() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance5593() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments5851() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testLang8205935() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments6096() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testLang8206245() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance6438() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testGetRawType6487() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testLang8206492() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@Test 
 public void testGetRawType6513() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments6618() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetRawType6637() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testGetArrayComponentType6899() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@Test 
 public void testGetArrayComponentType6986() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance7055() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments7064() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetRawType7202() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments7222() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetArrayComponentType7307() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@Test 
 public void testGetRawType7520() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testGetArrayComponentType7595() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@Test 
 public void testLang8207847() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments7879() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetRawType7938() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance7973() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments8271() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetArrayComponentType8303() throws Exception { 
     final Method method = getClass().getMethod("dummyMethod", List.class, List.class, List.class, List.class, List.class, List.class, List.class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class, List[].class); 
     final Type[] types = method.getGenericParameterTypes(); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[0])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[1])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[2])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[3])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[4])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[5])); 
     Assert.assertNull(TypeUtils.getArrayComponentType(types[6])); 
     Assert.assertEquals(types[0], TypeUtils.getArrayComponentType(types[7])); 
     Assert.assertEquals(types[1], TypeUtils.getArrayComponentType(types[8])); 
     Assert.assertEquals(types[2], TypeUtils.getArrayComponentType(types[9])); 
     Assert.assertEquals(types[3], TypeUtils.getArrayComponentType(types[10])); 
     Assert.assertEquals(types[4], TypeUtils.getArrayComponentType(types[11])); 
     Assert.assertEquals(types[5], TypeUtils.getArrayComponentType(types[12])); 
     Assert.assertEquals(types[6], TypeUtils.getArrayComponentType(types[13])); 
 } 
@Test 
 public void testLang8208414() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance8449() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments8494() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments8497() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments8521() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance8592() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance8679() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testLang8208735() throws Exception { 
     final Type[] typeArray = { String.class, String.class }; 
     final Type[] expectedArray = { String.class }; 
     Assert.assertArrayEquals(expectedArray, TypeUtils.normalizeUpperBounds(typeArray)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments8807() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@SuppressWarnings("boxing") 
 @Test 
 public void testIsInstance8891() throws SecurityException, NoSuchFieldException { 
     final Type intComparableType = getClass().getField("intComparable").getGenericType(); 
     final Type uriComparableType = getClass().getField("uriComparable").getGenericType(); 
     intComparable = 1; 
     Assert.assertTrue(TypeUtils.isInstance(1, intComparableType)); 
     Assert.assertFalse(TypeUtils.isInstance(1, uriComparableType)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments9030() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
@Test 
 public void testGetRawType9090() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testGetRawType9408() throws SecurityException, NoSuchFieldException { 
     final Type stringParentFieldType = GenericTypeHolder.class.getDeclaredField("stringParent").getGenericType(); 
     final Type integerParentFieldType = GenericTypeHolder.class.getDeclaredField("integerParent").getGenericType(); 
     final Type foosFieldType = GenericTypeHolder.class.getDeclaredField("foos").getGenericType(); 
     final Type genericParentT = GenericParent.class.getTypeParameters()[0]; 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(stringParentFieldType, null)); 
     Assert.assertEquals(GenericParent.class, TypeUtils.getRawType(integerParentFieldType, null)); 
     Assert.assertEquals(List.class, TypeUtils.getRawType(foosFieldType, null)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, StringParameterizedChild.class)); 
     Assert.assertEquals(String.class, TypeUtils.getRawType(genericParentT, stringParentFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(Iterable.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertEquals(Foo.class, TypeUtils.getRawType(List.class.getTypeParameters()[0], foosFieldType)); 
     Assert.assertNull(TypeUtils.getRawType(genericParentT, GenericParent.class)); 
     Assert.assertEquals(GenericParent[].class, TypeUtils.getRawType(GenericTypeHolder.class.getDeclaredField("barParents").getGenericType(), null)); 
 } 
@Test 
 public void testDetermineTypeVariableAssignments9426() throws SecurityException, NoSuchFieldException, NoSuchMethodException { 
     final ParameterizedType iterableType = (ParameterizedType) getClass().getField("iterable").getGenericType(); 
     final Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(TreeSet.class, iterableType); 
     final TypeVariable<?> treeSetTypeVar = TreeSet.class.getTypeParameters()[0]; 
     Assert.assertTrue(typeVarAssigns.containsKey(treeSetTypeVar)); 
     Assert.assertEquals(iterableType.getActualTypeArguments()[0], typeVarAssigns.get(treeSetTypeVar)); 
 } 
