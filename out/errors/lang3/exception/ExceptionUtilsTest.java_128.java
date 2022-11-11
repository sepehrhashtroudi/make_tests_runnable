@Test
public void testRemoveCommonFrames_ListList10997() throws Exception { 
         List<String> list = new ArrayList<String>(); 
         list.add("Frame 0"); 
         list.add("Frame 1"); 
         list.add("Frame 2"); 
         list.add("Frame 3"); 
         list.add("Frame 4"); 
         ExceptionUtils.removeCommonFrames(list, null); 
         assertEquals(0, list.size()); 
         list = null; 
         try { 
             ExceptionUtils.removeCommonFrames(list, list); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(1, list.size()); 
         assertEquals("Frame 0", ExceptionUtils.getRootCause(list).getMessage()); 
          
         list = new ArrayList<String>(); 
         list.add("Frame 1"); 
         list.add("Frame 2"); 
         list.add("Frame 3"); 
         list.add("Frame 4"); 
         try { 
             ExceptionUtils.removeCommonFrames(list, list); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(1, list.size()); 
         assertEquals("Frame 2", ExceptionUtils.getRootCause(list).getMessage()); 
          
         try { 
             ExceptionUtils.removeCommonFrames(list, null); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(1, list.size()); 
         assertEquals("Frame 3", ExceptionUtils.getRootCause(list).getMessage()); 
         } catch (final IllegalStateException ex) {} 
          
         try { 
             ExceptionUtils.removeCommonFrames(null, list); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(1, list.size()); 
         assertEquals("Frame 4", ExceptionUtils.getRootCause(list).getMessage());