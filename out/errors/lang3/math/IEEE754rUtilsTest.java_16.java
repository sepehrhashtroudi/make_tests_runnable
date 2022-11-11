@Test
public void testEnforceExceptions10382() { 
         try { 
             IEEE754rUtils.min( (float[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.min(new float[0]); 
             fail("IllegalArgumentException expected for empty input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.min( (float[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max( (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.min( (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max( (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max(new double[0]); 
             fail("IllegalArgumentException expected for empty input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max(new double[0]); 
             fail("IllegalArgumentException expected for empty input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max(new double[