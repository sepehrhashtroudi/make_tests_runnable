@Test
public void testEnforceExceptions9587() { 
         try { 
             IEEE754rUtils.min( (float[]) null, (float[]) null, (float[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { 
             // expected 
         } 
  
         try { 
             IEEE754rUtils.min(new float[0], (float[]) null, (float[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { 
             // expected 
         } 
  
         try { 
             IEEE754rUtils.min( (float[]) null, (float[]) null, (float[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { 
             // expected 
         } 
  
         try { 
             IEEE754rUtils.max( (double[]) null, (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { 
             // expected 
         } 
  
         try { 
             IEEE754rUtils.max(new double[0], (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for empty input"); 
         } catch(final IllegalArgumentException iae) { 
             // expected 
         } 
  
         try { 
             IEEE754rUtils.max(new double[0], (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for empty input"); 
         } catch(final IllegalArgumentException iae) { 
             // expected 
         } 
  
         try { 
             IEEE754rUtils.max(new double[0],