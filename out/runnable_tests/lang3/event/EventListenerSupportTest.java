@Test 
 public void testSerialization137() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization145() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization479() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization966() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization1352() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization1421() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization1469() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization1483() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization1842() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization1943() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization1995() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization2050() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization2451() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization2497() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testRemoveListenerDuringEvent2920() throws PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     for (int i = 0; i < 10; ++i) { 
         addDeregisterListener(listenerSupport); 
     } 
     assertEquals(listenerSupport.getListenerCount(), 10); 
     listenerSupport.fire().vetoableChange(new PropertyChangeEvent(new Date(), "Day", 4, 5)); 
     assertEquals(listenerSupport.getListenerCount(), 0); 
 } 
@Test 
 public void testSerialization3084() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization3131() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization3306() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testRemoveListenerDuringEvent3326() throws PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     for (int i = 0; i < 10; ++i) { 
         addDeregisterListener(listenerSupport); 
     } 
     assertEquals(listenerSupport.getListenerCount(), 10); 
     listenerSupport.fire().vetoableChange(new PropertyChangeEvent(new Date(), "Day", 4, 5)); 
     assertEquals(listenerSupport.getListenerCount(), 0); 
 } 
@Test 
 public void testSerialization3613() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization3620() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization4366() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization4899() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization5087() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization5112() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization5508() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization5864() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization6156() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization6259() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization6275() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization6377() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization6560() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization6742() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization7107() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization7780() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization7808() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization7894() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization7911() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization7964() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization7982() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization8164() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization8348() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization8394() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization8629() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization8835() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization8978() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization9163() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization9208() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
@Test 
 public void testSerialization9323() throws IOException, ClassNotFoundException, PropertyVetoException { 
     final EventListenerSupport<VetoableChangeListener> listenerSupport = EventListenerSupport.create(VetoableChangeListener.class); 
     listenerSupport.addListener(new VetoableChangeListener() { 
  
         @Override 
         public void vetoableChange(final PropertyChangeEvent e) { 
         } 
     }); 
     listenerSupport.addListener(EasyMock.createNiceMock(VetoableChangeListener.class)); 
     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
     final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); 
     objectOutputStream.writeObject(listenerSupport); 
     objectOutputStream.close(); 
     @SuppressWarnings("unchecked") 
     final EventListenerSupport<VetoableChangeListener> deserializedListenerSupport = (EventListenerSupport<VetoableChangeListener>) new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject(); 
     final VetoableChangeListener[] listeners = deserializedListenerSupport.getListeners(); 
     assertEquals(VetoableChangeListener.class, listeners.getClass().getComponentType()); 
     assertEquals(1, listeners.length); 
     final VetoableChangeListener listener = listeners[0]; 
     final PropertyChangeEvent evt = new PropertyChangeEvent(new Date(), "Day", 7, 9); 
     listener.vetoableChange(evt); 
     EasyMock.replay(listener); 
     deserializedListenerSupport.fire().vetoableChange(evt); 
     EasyMock.verify(listener); 
     deserializedListenerSupport.removeListener(listener); 
     assertEquals(0, deserializedListenerSupport.getListeners().length); 
 } 
