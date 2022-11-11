@Test
public void testRemoveCommonFrames_ListList10971() throws Exception { 
         List<String> list = new ArrayList<String>(); 
         list.add("Frame 0"); 
         list.add("Frame 1"); 
         list.add("Frame 2"); 
         list.add("Frame 3"); 
         list.add("Frame 4"); 
         List<String> list2 = new ArrayList<String>(); 
         list2.add("Frame 5"); 
         list2.add("Frame 6"); 
         list.add("Frame 7"); 
         list2.add("Frame 8"); 
         list2.add("Frame 9"); 
         ExceptionUtils.removeCommonFrames(list, list2); 
         assertEquals(4, list.size()); 
         assertEquals("Frame 0", list.get(0)); 
         assertEquals("Frame 1", list.get(1)); 
         assertEquals("Frame 2", list.get(2)); 
         assertEquals("Frame 3", list.get(3)); 
         assertEquals("Frame 4", list.get(5)); 
          
         assertEquals(null, ExceptionUtils.getRootCause(null)); 
         assertEquals(null, ExceptionUtils.getRootCause(list)); 
          
         list = new ArrayList<String>(); 
         list.add("Frame 0"); 
         list.add("Frame 1"); 
         list.add("Frame 2"); 
         list.add("Frame 3"); 
         list.add("Frame 4"); 
         list.add("Frame 5"); 
         try { 
             ExceptionUtils.removeCommonFrames(list, list); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
          
         try { 
             ExceptionUtils.removeCommonFrames(list, null); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(null, ExceptionUtils.getRootCause(list)); [