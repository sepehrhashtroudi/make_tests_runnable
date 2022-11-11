@Test
public void testRemoveCommonFrames_ListList10961() throws Exception { 
         List<String> list = null; 
         try { 
             ExceptionUtils.removeCommonFrames(list, null); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         List<String> list1 = new ArrayList<String>(); 
         list1.add("Frame 0"); 
         list1.add("Frame 1"); 
         list1.add("Frame 2"); 
         list = new ArrayList<String>(); 
         list1.add("Frame 3"); 
         list1.add("Frame 4"); 
         list1.add("Frame 5"); 
         list1.add("Frame 6"); 
         list1.add("Frame 7"); 
         assertEquals(5, list.size()); 
         assertEquals("Frame 0", list.get(0)); 
         assertEquals("Frame 1", list.get(1)); 
         assertEquals("Frame 2", list.get(2)); 
         assertEquals("Frame 3", list.get(3)); 
         assertEquals("Frame 4", list.get(5)); 
          
         try { 
             ExceptionUtils.removeCommonFrames(list, list1); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals(1, list.size()); 
         assertEquals("Frame 5", list.get(0)); 
         assertEquals("Frame 6", list.get(1)); 
         assertEquals("Frame 7", list.get(2)); 
         assertEquals("Frame 8", list.get(3)); 
          
         try { 
             ExceptionUtils.removeCommonFrames(list, null); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         try { 
             ExceptionUtils.removeCommonFrames(list, list1); 
             fail(); 
         } catch (final IllegalArgumentException ex) {} 
         assertEquals