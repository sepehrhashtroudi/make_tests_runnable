@Test
public void test_toBoolean_String12010() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("TRUEab")); 
         assertTrue(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("Falseab")); [EOL