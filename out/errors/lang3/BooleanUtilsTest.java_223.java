@Test
public void test_toBoolean_String12013() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("falseab")); 
         assertFalse(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("falseab")); 
         assertTrue(BooleanUtils.toBoolean("falseab")); 
         assertTrue(BooleanUtils.toBoolean("trueabc")); 
         assertTrue(BooleanUtils.toBoolean("trueabc")); 
         assertTrue(BooleanUtils.toBoolean("falseabc")); 
         assertTrue(BooleanUtils.toBoolean("trueabc