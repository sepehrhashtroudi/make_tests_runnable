@Test
public void testEnforceExceptions10407() { 
         try { 
             IEEE754rUtils.min( (float[]) null, (float[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.min( (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.min( (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max( (float[]) null, (float[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.min( (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max( (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max( (double[]) null, (double[]) null); 
             fail("IllegalArgumentException expected for null input"); 
         } catch(final IllegalArgumentException iae) { /* expected */ } 
  
         try { 
             IEEE754rUtils.max( (double[]) null, (double[]) null);