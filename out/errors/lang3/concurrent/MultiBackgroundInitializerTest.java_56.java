@Test
public void testInitialize11209() throws ConcurrentException { 
         initializer.addInitializer(CHILD_INIT, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 1, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 2, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 3, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 4, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 5, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 6, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 7, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 8, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 9, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 10, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 11, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 12, new ChildBackgroundInitializer()); 
         initializer.addInitializer(CHILD_INIT + 13, new ChildBackgroundInitializer()); 
     } 
  
     /** 
      * Tests whether MultiBackgroundInitializers can be combined in multiple child initializers. 
      */