@Test
public void test_toBoolean_String12020() { 
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
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("abxyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); 
         assertFalse(BooleanUtils.toBoolean("xyz")); [EOL