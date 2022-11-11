@Test 
 public void testConversions29() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testFactory_String_proper35() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testToProperString186() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testReduce233() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce(); 
     assertEquals(Integer.MIN_VALUE / 2, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
 } 
@Test 
 public void testPow264() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow402() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract508() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract522() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow579() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString713() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testCompareTo722() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testSubtract738() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract740() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int789() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract822() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString882() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testSubtract911() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString954() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testDivide1209() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.divideBy(f2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.ZERO; 
     try { 
         f = f1.divideBy(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.divideBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.divideBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f2 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.divideBy(null); 
         fail("IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow1212() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToString1299() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("7/5", f.toString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("4/2", f.toString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0/2", f.toString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("2/2", f.toString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648/1", f.toString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-2147483648/2147483647", f.toString()); 
 } 
@Test 
 public void testAbs1302() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testGets1322() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5, 6); 
     assertEquals(23, f.getNumerator()); 
     assertEquals(3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(-3, 5, 6); 
     assertEquals(-23, f.getNumerator()); 
     assertEquals(-3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(Integer.MIN_VALUE, f.getProperWhole()); 
     assertEquals(0, f.getProperNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testToProperString1415() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testHashCode1433() { 
     final Fraction f1 = Fraction.getFraction(3, 5); 
     Fraction f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
 } 
@Test 
 public void testFactory_String_proper1539() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int1575() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow1626() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow1655() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo1656() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testToProperString1662() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testToProperString1679() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testInvert1725() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testGets1740() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5, 6); 
     assertEquals(23, f.getNumerator()); 
     assertEquals(3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(-3, 5, 6); 
     assertEquals(-23, f.getNumerator()); 
     assertEquals(-3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(Integer.MIN_VALUE, f.getProperWhole()); 
     assertEquals(0, f.getProperNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testSubtract1746() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAdd1765() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract1773() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testGets1802() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5, 6); 
     assertEquals(23, f.getNumerator()); 
     assertEquals(3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(-3, 5, 6); 
     assertEquals(-23, f.getNumerator()); 
     assertEquals(-3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(Integer.MIN_VALUE, f.getProperWhole()); 
     assertEquals(0, f.getProperNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testDivide2001() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.divideBy(f2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.ZERO; 
     try { 
         f = f1.divideBy(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.divideBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.divideBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f2 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.divideBy(null); 
         fail("IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow2051() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert2077() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testFactory_String_improper2080() { 
     Fraction f = null; 
     f = Fraction.getFraction("0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1/5"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("1/2"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("2/3"); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction("7/3"); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction("2/4"); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2/d"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2e/3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2/"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("/"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testMultiply2081() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.multiplyBy(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f1 = Fraction.getFraction(6, 10); 
     f2 = Fraction.getFraction(6, 10); 
     f = f1.multiplyBy(f2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = f.multiplyBy(f2); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-2, 5); 
     f = f1.multiplyBy(f2); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f1 = Fraction.getFraction(-3, 5); 
     f2 = Fraction.getFraction(-2, 5); 
     f = f1.multiplyBy(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.multiplyBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.multiplyBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f = f1.multiplyBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.multiplyBy(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.multiplyBy(f1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.multiplyBy(f1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString2084() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testGets2135() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5, 6); 
     assertEquals(23, f.getNumerator()); 
     assertEquals(3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(-3, 5, 6); 
     assertEquals(-23, f.getNumerator()); 
     assertEquals(-3, f.getProperWhole()); 
     assertEquals(5, f.getProperNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(Integer.MIN_VALUE, f.getProperWhole()); 
     assertEquals(0, f.getProperNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testConversions2137() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testPow2216() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testConversions2245() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testSubtract2291() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert2303() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testFactory_String_improper2317() { 
     Fraction f = null; 
     f = Fraction.getFraction("0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1/5"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("1/2"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("2/3"); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction("7/3"); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction("2/4"); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2/d"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2e/3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2/"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("/"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testInvert2343() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract2371() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test(expected = IllegalArgumentException.class) 
 public void testFactory_String2447() { 
     Fraction.getFraction(null); 
 } 
@Test 
 public void testCompareTo2460() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testPow2513() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAdd2523() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testDivide2574() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.divideBy(f2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.ZERO; 
     try { 
         f = f1.divideBy(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.divideBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.divideBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f2 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.divideBy(null); 
         fail("IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testEquals2640() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertFalse(f1.equals(null)); 
     assertFalse(f1.equals(new Object())); 
     assertFalse(f1.equals(Integer.valueOf(6))); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     assertFalse(f1.equals(f2)); 
     assertTrue(f1.equals(f1)); 
     assertTrue(f2.equals(f2)); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.equals(f2)); 
     f2 = Fraction.getFraction(6, 10); 
     assertFalse(f1.equals(f2)); 
 } 
@Test 
 public void testPow2647() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo2693() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testReducedFactory_int_int2721() { 
     Fraction f = null; 
     f = Fraction.getReducedFraction(0, 1); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(1, 1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 1); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(22, 7); 
     assertEquals(22, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, 10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(6, -10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, -10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(-3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 4); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(15, 10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(121, 22); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(-2, Integer.MIN_VALUE); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(-(Integer.MIN_VALUE / 2), f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(-7, Integer.MIN_VALUE); 
         fail("Expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2); 
     assertEquals(Integer.MIN_VALUE / 2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testConversions2856() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testFactory_String_proper2899() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testPow2988() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAbs3066() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract3190() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow3300() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_String_proper3324() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testSubtract3339() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int3379() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int3420() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAbs3452() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow3655() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow3665() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_String_proper3720() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testAbs3795() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert3810() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract3863() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert4048() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testCompareTo4139() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testPow4255() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert4296() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testFactory_int_int_int4299() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract4351() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow4393() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int4414() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testHashCode4438() { 
     final Fraction f1 = Fraction.getFraction(3, 5); 
     Fraction f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
 } 
@Test 
 public void testPow4461() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int4463() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo4516() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testConversions4536() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testToString4558() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("7/5", f.toString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("4/2", f.toString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0/2", f.toString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("2/2", f.toString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648/1", f.toString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-2147483648/2147483647", f.toString()); 
 } 
@Test 
 public void testFactory_int_int_int4600() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int4607() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int4625() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAbs4683() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testConversions4702() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testReducedFactory_int_int4818() { 
     Fraction f = null; 
     f = Fraction.getReducedFraction(0, 1); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(1, 1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 1); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(22, 7); 
     assertEquals(22, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, 10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(6, -10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, -10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(-3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 4); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(15, 10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(121, 22); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(-2, Integer.MIN_VALUE); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(-(Integer.MIN_VALUE / 2), f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(-7, Integer.MIN_VALUE); 
         fail("Expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2); 
     assertEquals(Integer.MIN_VALUE / 2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testSubtract4828() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAdd4836() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo4897() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testDivide4915() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.divideBy(f2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.ZERO; 
     try { 
         f = f1.divideBy(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.divideBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.divideBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f2 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.divideBy(null); 
         fail("IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString4964() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testReduce5011() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce(); 
     assertEquals(Integer.MIN_VALUE / 2, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
 } 
@Test 
 public void testFactory_int_int_int5043() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow5083() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testHashCode5130() { 
     final Fraction f1 = Fraction.getFraction(3, 5); 
     Fraction f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
 } 
@Test 
 public void testFactory_double5136() { 
     Fraction f = null; 
     try { 
         f = Fraction.getFraction(Double.NaN); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Double.POSITIVE_INFINITY); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction((double) Integer.MAX_VALUE + 1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(0.0d); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(1.0d); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(0.5d); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(-0.875d); 
     assertEquals(-7, f.getNumerator()); 
     assertEquals(8, f.getDenominator()); 
     f = Fraction.getFraction(1.25d); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(0.66666d); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(1.0d / 10001d); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     Fraction f2 = null; 
     for (int i = 1; i <= 100; i++) { 
         for (int j = 1; j <= i; j++) { 
             try { 
                 f = Fraction.getFraction((double) j / (double) i); 
             } catch (final ArithmeticException ex) { 
                 System.err.println(j + " " + i); 
                 throw ex; 
             } 
             f2 = Fraction.getReducedFraction(j, i); 
             assertEquals(f2.getNumerator(), f.getNumerator()); 
             assertEquals(f2.getDenominator(), f.getDenominator()); 
         } 
     } 
     for (int i = 1001; i <= 10000; i += SKIP) { 
         for (int j = 1; j <= i; j++) { 
             try { 
                 f = Fraction.getFraction((double) j / (double) i); 
             } catch (final ArithmeticException ex) { 
                 System.err.println(j + " " + i); 
                 throw ex; 
             } 
             f2 = Fraction.getReducedFraction(j, i); 
             assertEquals(f2.getNumerator(), f.getNumerator()); 
             assertEquals(f2.getDenominator(), f.getDenominator()); 
         } 
     } 
 } 
@Test 
 public void testInvert5220() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testFactory_int_int_int5224() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAdd5284() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testReducedFactory_int_int5309() { 
     Fraction f = null; 
     f = Fraction.getReducedFraction(0, 1); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(1, 1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 1); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(22, 7); 
     assertEquals(22, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, 10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(6, -10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, -10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(-3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 4); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(15, 10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(121, 22); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(-2, Integer.MIN_VALUE); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(-(Integer.MIN_VALUE / 2), f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(-7, Integer.MIN_VALUE); 
         fail("Expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2); 
     assertEquals(Integer.MIN_VALUE / 2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testInvert5492() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract5544() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract5629() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAdd5653() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract5663() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testReducedFactory_int_int5730() { 
     Fraction f = null; 
     f = Fraction.getReducedFraction(0, 1); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(1, 1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 1); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(22, 7); 
     assertEquals(22, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, 10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(6, -10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, -10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(-3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 4); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(15, 10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(121, 22); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(-2, Integer.MIN_VALUE); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(-(Integer.MIN_VALUE / 2), f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(-7, Integer.MIN_VALUE); 
         fail("Expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2); 
     assertEquals(Integer.MIN_VALUE / 2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testPow5756() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testReduce5805() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce(); 
     assertEquals(Integer.MIN_VALUE / 2, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
 } 
@Test 
 public void testSubtract5833() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert5857() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract5968() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_String_proper6077() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testReduce6134() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce(); 
     assertEquals(Integer.MIN_VALUE / 2, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
 } 
@Test 
 public void testAbs6178() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString6225() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testReducedFactory_int_int6249() { 
     Fraction f = null; 
     f = Fraction.getReducedFraction(0, 1); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(1, 1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 1); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(22, 7); 
     assertEquals(22, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, 10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(6, -10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, -10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(-3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 4); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(15, 10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(121, 22); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(-2, Integer.MIN_VALUE); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(-(Integer.MIN_VALUE / 2), f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(-7, Integer.MIN_VALUE); 
         fail("Expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2); 
     assertEquals(Integer.MIN_VALUE / 2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testToProperString6255() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testInvert6383() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testToProperString6419() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testSubtract6436() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_String_improper6459() { 
     Fraction f = null; 
     f = Fraction.getFraction("0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1/5"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("1/2"); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("2/3"); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction("7/3"); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction("2/4"); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2/d"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2e/3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2/"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("/"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testToString6522() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("7/5", f.toString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("4/2", f.toString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0/2", f.toString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("2/2", f.toString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648/1", f.toString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-2147483648/2147483647", f.toString()); 
 } 
@Test 
 public void testSubtract6584() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow6613() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow6758() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract6802() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract6861() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract6938() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert6941() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testReducedFactory_int_int6943() { 
     Fraction f = null; 
     f = Fraction.getReducedFraction(0, 1); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(1, 1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 1); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(22, 7); 
     assertEquals(22, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, 10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(6, -10); 
     assertEquals(-3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getReducedFraction(-6, -10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getReducedFraction(-3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getReducedFraction(2, 4); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(15, 10); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(121, 22); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getReducedFraction(-2, Integer.MIN_VALUE); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(-(Integer.MIN_VALUE / 2), f.getDenominator()); 
     try { 
         f = Fraction.getReducedFraction(-7, Integer.MIN_VALUE); 
         fail("Expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2); 
     assertEquals(Integer.MIN_VALUE / 2, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
 } 
@Test 
 public void testToProperString7027() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testPow7050() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow7136() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo7152() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testSubtract7185() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert7278() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testAdd7295() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_int_int_int7418() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract7604() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testPow7619() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testConversions7728() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testFactory_String_proper7732() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testPow7757() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert7814() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testAdd7864() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.add(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.add(f2); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.add(f2); 
     assertEquals(-1, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.add(f2); 
     assertEquals(11, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 8); 
     f2 = Fraction.getFraction(1, 6); 
     f = f1.add(f2); 
     assertEquals(13, f.getNumerator()); 
     assertEquals(24, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.add(f2); 
     assertSame(f2, f); 
     f = f2.add(f1); 
     assertSame(f2, f); 
     f1 = Fraction.getFraction(-1, 13 * 13 * 2 * 2); 
     f2 = Fraction.getFraction(-2, 13 * 17 * 2); 
     f = f1.add(f2); 
     assertEquals(13 * 13 * 17 * 2 * 2, f.getDenominator()); 
     assertEquals(-17 - 2 * 13 * 2, f.getNumerator()); 
     try { 
         f.add(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.add(f2); 
     assertEquals(52451, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD; 
     f = f1.add(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE - 1, 1); 
     f2 = Fraction.ONE; 
     f = f1.add(f2); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.add(Fraction.ONE); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(-1, 5); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1); 
         f = f.add(f); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.add(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testHashCode7892() { 
     final Fraction f1 = Fraction.getFraction(3, 5); 
     Fraction f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.hashCode() == f2.hashCode()); 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.hashCode() != f2.hashCode()); 
 } 
@Test 
 public void testReduce7907() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce(); 
     assertEquals(Integer.MIN_VALUE / 2, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
 } 
@Test 
 public void testSubtract7925() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert7976() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract7998() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract8021() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo8034() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testSubtract8071() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo8081() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testInvert8109() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract8118() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo8228() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testConversions8263() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 7, 8); 
     assertEquals(3, f.intValue()); 
     assertEquals(3L, f.longValue()); 
     assertEquals(3.875f, f.floatValue(), 0.00001f); 
     assertEquals(3.875d, f.doubleValue(), 0.00001d); 
 } 
@Test 
 public void testToString8350() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("7/5", f.toString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("4/2", f.toString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0/2", f.toString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("2/2", f.toString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648/1", f.toString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-2147483648/2147483647", f.toString()); 
 } 
@Test 
 public void testPow8418() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract8421() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString8511() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testInvert8698() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract8747() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert8826() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testReduce8841() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce(); 
     assertEquals(Integer.MIN_VALUE / 2, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
 } 
@Test 
 public void testDivide8881() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.divideBy(f2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.ZERO; 
     try { 
         f = f1.divideBy(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.divideBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.divideBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f2 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.divideBy(null); 
         fail("IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract8894() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert8896() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testSubtract8902() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract8957() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAbs8976() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testCompareTo9049() { 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f1) == 0); 
     try { 
         f1.compareTo(null); 
         fail("expecting NullPointerException"); 
     } catch (final NullPointerException ex) { 
     } 
     f2 = Fraction.getFraction(2, 5); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(4, 5); 
     assertTrue(f1.compareTo(f2) < 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(3, 5); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(6, 10); 
     assertTrue(f1.compareTo(f2) == 0); 
     assertTrue(f2.compareTo(f2) == 0); 
     f2 = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertTrue(f1.compareTo(f2) > 0); 
     assertTrue(f2.compareTo(f2) == 0); 
 } 
@Test 
 public void testFactory_int_int_int9144() { 
     Fraction f = null; 
     f = Fraction.getFraction(0, 0, 2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(2, 0, 2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(0, 1, 2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction(1, 1, 2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 6, 10); 
     assertEquals(-16, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(-1, -6, 10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -6, -10); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(0, 1, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 2, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, -3, 0); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-Integer.MAX_VALUE, 1, 2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(-1, 0, Integer.MAX_VALUE); 
     assertEquals(-Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     try { 
         f = Fraction.getFraction(0, 4, Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(1, 1, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(-1, 2, Integer.MAX_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testFactory_String_proper9156() { 
     Fraction f = null; 
     f = Fraction.getFraction("0 0/1"); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction("1 1/5"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f = Fraction.getFraction("7 1/2"); 
     assertEquals(15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("1 2/4"); 
     assertEquals(6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction("-7 1/2"); 
     assertEquals(-15, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f = Fraction.getFraction("-1 2/4"); 
     assertEquals(-6, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     try { 
         f = Fraction.getFraction("2 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("a 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 b/4"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction("2 "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" 3"); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
     try { 
         f = Fraction.getFraction(" "); 
         fail("expecting NumberFormatException"); 
     } catch (final NumberFormatException ex) { 
     } 
 } 
@Test 
 public void testSubtract9180() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testToProperString9210() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     final String str = f.toProperString(); 
     assertEquals("3/5", str); 
     assertSame(str, f.toProperString()); 
     f = Fraction.getFraction(7, 5); 
     assertEquals("1 2/5", f.toProperString()); 
     f = Fraction.getFraction(14, 10); 
     assertEquals("1 4/10", f.toProperString()); 
     f = Fraction.getFraction(4, 2); 
     assertEquals("2", f.toProperString()); 
     f = Fraction.getFraction(0, 2); 
     assertEquals("0", f.toProperString()); 
     f = Fraction.getFraction(2, 2); 
     assertEquals("1", f.toProperString()); 
     f = Fraction.getFraction(-7, 5); 
     assertEquals("-1 2/5", f.toProperString()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 0, 1); 
     assertEquals("-2147483648", f.toProperString()); 
     f = Fraction.getFraction(-1, 1, Integer.MAX_VALUE); 
     assertEquals("-1 1/2147483647", f.toProperString()); 
     assertEquals("-1", Fraction.getFraction(-1).toProperString()); 
 } 
@Test 
 public void testPow9211() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract9213() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testSubtract9301() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f1.subtract(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(7, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(3, 5); 
     f = f1.subtract(f2); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(7, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(4, 5); 
     f = f1.subtract(f2); 
     assertEquals(-4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(-4, 5); 
     f = f1.subtract(f2); 
     assertEquals(4, f.getNumerator()); 
     assertEquals(5, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(1, 2); 
     f = f1.subtract(f2); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(10, f.getDenominator()); 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(1, 5); 
     f = f2.subtract(f1); 
     assertSame(f2, f); 
     try { 
         f.subtract(null); 
         fail("expecting IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     f1 = Fraction.getFraction(1, 32768 * 3); 
     f2 = Fraction.getFraction(1, 59049); 
     f = f1.subtract(f2); 
     assertEquals(-13085, f.getNumerator()); 
     assertEquals(1934917632, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 3); 
     f2 = Fraction.ONE_THIRD.negate(); 
     f = f1.subtract(f2); 
     assertEquals(Integer.MIN_VALUE + 1, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f2 = Fraction.ONE; 
     f = f1.subtract(f2); 
     assertEquals(Integer.MAX_VALUE - 1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f2 = Fraction.getFraction(1, Integer.MAX_VALUE - 1); 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, 5); 
     f2 = Fraction.getFraction(1, 5); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         f = f.subtract(Fraction.ONE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.subtract(Fraction.ONE.negate()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(3, 327680); 
     f2 = Fraction.getFraction(2, 59049); 
     try { 
         f = f1.subtract(f2); 
         fail("expecting ArithmeticException but got: " + f.toString()); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testInvert9315() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.invert(); 
     assertEquals(75, f.getNumerator()); 
     assertEquals(50, f.getDenominator()); 
     f = Fraction.getFraction(4, 3); 
     f = f.invert(); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(4, f.getDenominator()); 
     f = Fraction.getFraction(-15, 47); 
     f = f.invert(); 
     assertEquals(-47, f.getNumerator()); 
     assertEquals(15, f.getDenominator()); 
     f = Fraction.getFraction(0, 3); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.invert(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.invert(); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
 } 
@Test 
 public void testPow9459() { 
     Fraction f = null; 
     f = Fraction.getFraction(3, 5); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(3, 5); 
     assertSame(f, f.pow(1)); 
     assertEquals(f, f.pow(1)); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-1); 
     assertEquals(5, f.getNumerator()); 
     assertEquals(3, f.getDenominator()); 
     f = Fraction.getFraction(3, 5); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(Fraction.ONE, f.pow(0)); 
     f = Fraction.getFraction(6, 10); 
     assertEquals(f, f.pow(1)); 
     assertFalse(f.pow(1).equals(Fraction.getFraction(3, 5))); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(2); 
     assertEquals(9, f.getNumerator()); 
     assertEquals(25, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(3); 
     assertEquals(27, f.getNumerator()); 
     assertEquals(125, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-1); 
     assertEquals(10, f.getNumerator()); 
     assertEquals(6, f.getDenominator()); 
     f = Fraction.getFraction(6, 10); 
     f = f.pow(-2); 
     assertEquals(25, f.getNumerator()); 
     assertEquals(9, f.getDenominator()); 
     f = Fraction.getFraction(0, 1231); 
     f = f.pow(1); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1231, f.getDenominator()); 
     f = f.pow(2); 
     assertTrue(0 == f.compareTo(Fraction.ZERO)); 
     assertEquals(0, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f = f.pow(-1); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f = f.pow(Integer.MIN_VALUE); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(1, 1); 
     f = f.pow(0); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(-1); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MAX_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = f.pow(Integer.MIN_VALUE); 
     assertEquals(f, Fraction.ONE); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.pow(3); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f = Fraction.getFraction(65536, 1); 
     try { 
         f = f.pow(2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testReduce9465() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     Fraction result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, -3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(2, -3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     f = Fraction.getFraction(-2, 3); 
     result = f.reduce(); 
     assertEquals(-2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(2, 3); 
     result = f.reduce(); 
     assertEquals(2, result.getNumerator()); 
     assertEquals(3, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 1); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(f, result); 
     f = Fraction.getFraction(0, 100); 
     result = f.reduce(); 
     assertEquals(0, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
     assertSame(result, Fraction.ZERO); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 2); 
     result = f.reduce(); 
     assertEquals(Integer.MIN_VALUE / 2, result.getNumerator()); 
     assertEquals(1, result.getDenominator()); 
 } 
@Test 
 public void testDivide9525() { 
     Fraction f = null; 
     Fraction f1 = null; 
     Fraction f2 = null; 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.getFraction(2, 5); 
     f = f1.divideBy(f2); 
     assertEquals(3, f.getNumerator()); 
     assertEquals(2, f.getDenominator()); 
     f1 = Fraction.getFraction(3, 5); 
     f2 = Fraction.ZERO; 
     try { 
         f = f1.divideBy(f2); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     f1 = Fraction.getFraction(0, 5); 
     f2 = Fraction.getFraction(2, 7); 
     f = f1.divideBy(f2); 
     assertSame(Fraction.ZERO, f); 
     f1 = Fraction.getFraction(2, 7); 
     f2 = Fraction.ONE; 
     f = f1.divideBy(f2); 
     assertEquals(2, f.getNumerator()); 
     assertEquals(7, f.getDenominator()); 
     f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f1); 
     assertEquals(1, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f1 = Fraction.getFraction(Integer.MIN_VALUE, Integer.MAX_VALUE); 
     f2 = Fraction.getFraction(1, Integer.MAX_VALUE); 
     f = f1.divideBy(f2); 
     assertEquals(Integer.MIN_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     try { 
         f.divideBy(null); 
         fail("IllegalArgumentException"); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
     try { 
         f1 = Fraction.getFraction(1, -Integer.MAX_VALUE); 
         f = f1.divideBy(f1.invert()); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
 public void testAbs9553() { 
     Fraction f = null; 
     f = Fraction.getFraction(50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(-50, 75); 
     f = f.abs(); 
     assertEquals(50, f.getNumerator()); 
     assertEquals(75, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MAX_VALUE, -1); 
     f = f.abs(); 
     assertEquals(Integer.MAX_VALUE, f.getNumerator()); 
     assertEquals(1, f.getDenominator()); 
     f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
     try { 
         f = f.abs(); 
         fail("expecting ArithmeticException"); 
     } catch (final ArithmeticException ex) { 
     } 
 } 
@Test 
     public void testReducedFactory_int_int9590() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         f = Fraction.getReducedFraction(-6, 10); 
         assertEquals(-3, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testInvert9641() { 
         Fraction f = null; 
          
         f = Fraction.getFraction(50, 75); 
         f = f.invert(); 
         assertEquals(75, f.getNumerator()); 
         assertEquals(50, f.getDenominator()); 
          
         f = Fraction.getFraction(4, 3); 
         f = f.invert(); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction(-15, 47); 
         f = f.invert(); 
         assertEquals(-47, f.getNumerator()); 
         assertEquals(15, f.getDenominator()); 
          
         f = Fraction.getFraction(0, 3); 
         try { 
             f = f.invert(); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         // large values 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         try { 
             f = f.invert(); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.invert(); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     } 
      

@Test 
     public void testFactory_double10474() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10475() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testSubtract10476() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10477() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10478() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0.0); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1.0); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2.0); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1.0); 
         assertEquals(-16.0, f.getNumerator()); 
         assertEquals(1, f.get
@Test 
     public void testFactory_double10479() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10480() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10481() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testSubtract10482() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_String_proper10483() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/2"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testReducedFactory_int_int10484() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getReducedFraction(-6, -10); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MAX_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testReducedFactory_int_int10485() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         f = Fraction.getReducedFraction(-6, 10); 
         assertEquals(-3, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testSubtract10486() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testReducedFactory_int_int10487() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getReducedFraction(-6, 5); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MAX_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testFactory_double10488() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double_int10489() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex)
@Test 
     public void testReducedFactory_int_int10490() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getReducedFraction(-6, 5); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MAX_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testReducedFactory_int_int10491() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         f = Fraction.getReducedFraction(-6, 10); 
         assertEquals(-3, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testFactory_double10492() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10493() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10494() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(3, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10495() { 
         Fraction f = null; 
          
         f = Fraction.getFraction(Double.NaN); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.POSITIVE_INFINITY); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         assertEquals(-1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
         assertEquals(-1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         try { 
             f = Fraction.getFraction(Double.POSITIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         try { 
             f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         try { 
             f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 

@Test 
     public void testFactory_double10496() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10497() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0.0); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1.0); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2.0); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  [
@Test 
     public void testFactory_double10498() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0.0); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1.0); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2.0); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  [
@Test 
     public void testFactory_double_int10499() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex)
@Test 
     public void testFactory_double_int10500() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex)
@Test 
     public void testFactory_double10501() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10502() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_String_proper10503() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testFactory_double10504() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testReducedFactory_int_int10505() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         f = Fraction.getReducedFraction(-6, 10); 
         assertEquals(-3, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testFactory_double10506() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testReducedFactory_int_int10507() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getReducedFraction(-6, 5); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testSubtract10508() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10509() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(3, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testSubtract10510() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testSubtract10511() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10512() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_double10513() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0.0); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1.0); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2.0); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1.0); 
         assertEquals(-16.0, f.getNumerator()); 
         assertEquals(1, f.get
@Test 
     public void testFactory_double10514() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0.0); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1.0); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2.0); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  [
@Test 
     public void testFactory_String_proper10515() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testFactory_String_proper10516() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testFactory_double10517() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testSubtract10518() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10519() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testSubtract10520() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testSubtract10521() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testReducedFactory_int_int10522() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         f = Fraction.getReducedFraction(-6, 10); 
         assertEquals(-3, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         try { 
             f = Fraction.getReducedFraction(1, -6); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testFactory_double10523() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0.0); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1.0); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2.0); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4.0); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1.0); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  [
@Test 
     public void testFactory_String_proper10524() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testSubtract10525() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testSubtract10526() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10527() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          [EOL
@Test 
     public void testFactory_double_int10528() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex)
@Test 
     public void testSubtract10529() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10530() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_String_proper10531() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testReducedFactory_int_int10532() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getReducedFraction(0, 1); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(1, 1); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getReducedFraction(2, 1); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getReducedFraction(3, 1); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getReducedFraction(-6, -10); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MIN_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getReducedFraction(Integer.MAX_VALUE, 1); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.
@Test 
     public void testSubtract10533() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10534() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_String_proper10535() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testFactory_String_proper10536() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testFactory_double10537() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testFactory_String_proper10538() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testSubtract10539() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10540() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 

@Test 
     public void testFactory_double10541() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testSubtract10542() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double10543() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          [EOL
@Test 
     public void testSubtract10544() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testSubtract10545() { 
         Fraction f = null; 
         Fraction f1 = null; 
         Fraction f2 = null; 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(1, 5); 
         f = f1.subtract(f2); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(2, 5); 
         f = f1.subtract(f2); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(3, 5); 
         f = f1.subtract(f2); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); 
         f = f1.subtract(f2); 
         assertEquals(-6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f1 = Fraction.getFraction(3, 5); 
         f2 = Fraction.getFraction(-4, 5); [
@Test 
     public void testFactory_double_int10546() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex)
@Test 
     public void testFactory_double_int10547() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex)
@Test 
     public void testFactory_String_proper10548() { 
         Fraction f = null; 
          
         f = Fraction.getFraction("0 0/1"); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction("1 1/5"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(5, f.getDenominator()); 
          
         f = Fraction.getFraction("7 1/2"); 
         assertEquals(15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         f = Fraction.getFraction("1 2/4"); 
         assertEquals(6, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction("-7 1/2"); 
         assertEquals(-15, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction("2 3/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("a 3"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction("2 b/4"); 
             fail("expecting NumberFormatException"); 
         } catch (final NumberFormatException ex) {} 
          
         try { 
             f = Fraction.getFraction
@Test 
     public void testFactory_double10549() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(4d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.NaN); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.NEGATIVE_INFINITY); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negative 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 

@Test 
     public void testFactory_double10550() { 
         Fraction f = null; 
          
         // zero 
         f = Fraction.getFraction(0d); 
         assertEquals(0, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(1d); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         f = Fraction.getFraction(2d); 
         assertEquals(2, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         // normal 
         f = Fraction.getFraction(3d); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(2, f.getDenominator()); 
          
         // negatives 
         try { 
             f = Fraction.getFraction(Double.MIN_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(Double.MAX_VALUE); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
          
         // negatives 
         f = Fraction.getFraction(-1d); 
         assertEquals(-16, f.getNumerator()); 
         assertEquals(1, f.getDenominator()); 
          
         try { 
             f = Fraction.getFraction(1d); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} [
@Test 
     public void testInvert11605() { 
         Fraction f = null; 
          
         f = Fraction.getFraction(50, 75); 
         f = f.invert(); 
         assertEquals(75, f.getNumerator()); 
         assertEquals(50, f.getDenominator()); 
          
         f = Fraction.getFraction(4, 3); 
         f = f.invert(); 
         assertEquals(3, f.getNumerator()); 
         assertEquals(4, f.getDenominator()); 
          
         f = Fraction.getFraction(-15, 47); 
         f = f.invert(); 
         assertEquals(-47, f.getNumerator()); 
         assertEquals(15, f.getDenominator()); 
          
         f = Fraction.getFraction(0, 3); 
         try { 
             f = f.invert(); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         // large values 
         f = Fraction.getFraction(Integer.MIN_VALUE, 1); 
         try { 
             f = f.invert(); 
             fail("expecting ArithmeticException"); 
         } catch (final ArithmeticException ex) {} 
  
         f = Fraction.getFraction(Integer.MAX_VALUE, 1); 
         f = f.invert(); 
         assertEquals(1, f.getNumerator()); 
         assertEquals(Integer.MAX_VALUE, f.getDenominator()); 
     } 
      

