@Test 
 public void testBindFilteredEventsToMethod102() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindEventsToMethodWithEvent512() { 
     final PropertyChangeSource src = new PropertyChangeSource(); 
     final EventCounterWithEvent counter = new EventCounterWithEvent(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, PropertyChangeListener.class); 
     assertEquals(0, counter.getCount()); 
     src.setProperty("newValue"); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindFilteredEventsToMethod868() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testAddEventListenerWithNoAddMethod1348() { 
     final PropertyChangeSource src = new PropertyChangeSource(); 
     final EventCountingInvociationHandler handler = new EventCountingInvociationHandler(); 
     final ObjectChangeListener listener = handler.createListener(ObjectChangeListener.class); 
     try { 
         EventUtils.addEventListener(src, ObjectChangeListener.class, listener); 
         fail("Should not be allowed to add a listener to an object that doesn't support it."); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Class " + src.getClass().getName() + " does not have a public add" + ObjectChangeListener.class.getSimpleName() + " method which takes a parameter of type " + ObjectChangeListener.class.getName() + ".", e.getMessage()); 
     } 
 } 
@Test 
 public void testBindFilteredEventsToMethod1405() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindFilteredEventsToMethod1562() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testAddEventListenerThrowsException1627() { 
     final ExceptionEventSource src = new ExceptionEventSource(); 
     try { 
         EventUtils.addEventListener(src, PropertyChangeListener.class, new PropertyChangeListener() { 
  
             @Override 
             public void propertyChange(final PropertyChangeEvent e) { 
             } 
         }); 
         fail("Add method should have thrown an exception, so method should fail."); 
     } catch (final RuntimeException e) { 
     } 
 } 
@Test 
 public void testAddEventListenerThrowsException1952() { 
     final ExceptionEventSource src = new ExceptionEventSource(); 
     try { 
         EventUtils.addEventListener(src, PropertyChangeListener.class, new PropertyChangeListener() { 
  
             @Override 
             public void propertyChange(final PropertyChangeEvent e) { 
             } 
         }); 
         fail("Add method should have thrown an exception, so method should fail."); 
     } catch (final RuntimeException e) { 
     } 
 } 
@Test 
 public void testBindFilteredEventsToMethod2090() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindFilteredEventsToMethod2333() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindFilteredEventsToMethod2610() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testAddEventListenerThrowsException3308() { 
     final ExceptionEventSource src = new ExceptionEventSource(); 
     try { 
         EventUtils.addEventListener(src, PropertyChangeListener.class, new PropertyChangeListener() { 
  
             @Override 
             public void propertyChange(final PropertyChangeEvent e) { 
             } 
         }); 
         fail("Add method should have thrown an exception, so method should fail."); 
     } catch (final RuntimeException e) { 
     } 
 } 
@Test 
 public void testAddEventListenerThrowsException3398() { 
     final ExceptionEventSource src = new ExceptionEventSource(); 
     try { 
         EventUtils.addEventListener(src, PropertyChangeListener.class, new PropertyChangeListener() { 
  
             @Override 
             public void propertyChange(final PropertyChangeEvent e) { 
             } 
         }); 
         fail("Add method should have thrown an exception, so method should fail."); 
     } catch (final RuntimeException e) { 
     } 
 } 
@Test 
 public void testAddEventListenerThrowsException4060() { 
     final ExceptionEventSource src = new ExceptionEventSource(); 
     try { 
         EventUtils.addEventListener(src, PropertyChangeListener.class, new PropertyChangeListener() { 
  
             @Override 
             public void propertyChange(final PropertyChangeEvent e) { 
             } 
         }); 
         fail("Add method should have thrown an exception, so method should fail."); 
     } catch (final RuntimeException e) { 
     } 
 } 
@Test 
 public void testBindFilteredEventsToMethod4603() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testAddEventListenerThrowsException5657() { 
     final ExceptionEventSource src = new ExceptionEventSource(); 
     try { 
         EventUtils.addEventListener(src, PropertyChangeListener.class, new PropertyChangeListener() { 
  
             @Override 
             public void propertyChange(final PropertyChangeEvent e) { 
             } 
         }); 
         fail("Add method should have thrown an exception, so method should fail."); 
     } catch (final RuntimeException e) { 
     } 
 } 
@Test 
 public void testAddEventListenerWithNoAddMethod6073() { 
     final PropertyChangeSource src = new PropertyChangeSource(); 
     final EventCountingInvociationHandler handler = new EventCountingInvociationHandler(); 
     final ObjectChangeListener listener = handler.createListener(ObjectChangeListener.class); 
     try { 
         EventUtils.addEventListener(src, ObjectChangeListener.class, listener); 
         fail("Should not be allowed to add a listener to an object that doesn't support it."); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Class " + src.getClass().getName() + " does not have a public add" + ObjectChangeListener.class.getSimpleName() + " method which takes a parameter of type " + ObjectChangeListener.class.getName() + ".", e.getMessage()); 
     } 
 } 
@Test 
 public void testBindFilteredEventsToMethod6854() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindFilteredEventsToMethod7525() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindFilteredEventsToMethod7578() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testBindFilteredEventsToMethod7765() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testAddEventListenerWithNoAddMethod7915() { 
     final PropertyChangeSource src = new PropertyChangeSource(); 
     final EventCountingInvociationHandler handler = new EventCountingInvociationHandler(); 
     final ObjectChangeListener listener = handler.createListener(ObjectChangeListener.class); 
     try { 
         EventUtils.addEventListener(src, ObjectChangeListener.class, listener); 
         fail("Should not be allowed to add a listener to an object that doesn't support it."); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Class " + src.getClass().getName() + " does not have a public add" + ObjectChangeListener.class.getSimpleName() + " method which takes a parameter of type " + ObjectChangeListener.class.getName() + ".", e.getMessage()); 
     } 
 } 
@Test 
 public void testAddEventListenerWithNoAddMethod8191() { 
     final PropertyChangeSource src = new PropertyChangeSource(); 
     final EventCountingInvociationHandler handler = new EventCountingInvociationHandler(); 
     final ObjectChangeListener listener = handler.createListener(ObjectChangeListener.class); 
     try { 
         EventUtils.addEventListener(src, ObjectChangeListener.class, listener); 
         fail("Should not be allowed to add a listener to an object that doesn't support it."); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Class " + src.getClass().getName() + " does not have a public add" + ObjectChangeListener.class.getSimpleName() + " method which takes a parameter of type " + ObjectChangeListener.class.getName() + ".", e.getMessage()); 
     } 
 } 
@Test 
 public void testBindFilteredEventsToMethod8300() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
@Test 
 public void testAddEventListenerWithNoAddMethod8396() { 
     final PropertyChangeSource src = new PropertyChangeSource(); 
     final EventCountingInvociationHandler handler = new EventCountingInvociationHandler(); 
     final ObjectChangeListener listener = handler.createListener(ObjectChangeListener.class); 
     try { 
         EventUtils.addEventListener(src, ObjectChangeListener.class, listener); 
         fail("Should not be allowed to add a listener to an object that doesn't support it."); 
     } catch (final IllegalArgumentException e) { 
         assertEquals("Class " + src.getClass().getName() + " does not have a public add" + ObjectChangeListener.class.getSimpleName() + " method which takes a parameter of type " + ObjectChangeListener.class.getName() + ".", e.getMessage()); 
     } 
 } 
@Test 
 public void testBindFilteredEventsToMethod9423() { 
     final MultipleEventSource src = new MultipleEventSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, MultipleEventListener.class, "event1"); 
     assertEquals(0, counter.getCount()); 
     src.listeners.fire().event1(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(0), Integer.valueOf(1))); 
     assertEquals(1, counter.getCount()); 
     src.listeners.fire().event2(new PropertyChangeEvent(new Date(), "Day", Integer.valueOf(1), Integer.valueOf(2))); 
     assertEquals(1, counter.getCount()); 
 } 
