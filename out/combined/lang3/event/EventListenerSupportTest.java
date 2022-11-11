/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

/**
 * @since 3.0
 * @version $Id$
 */
public class EventListenerSupportTest 
{
    

    

    

    

    

    

    

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
    

    

    private void addDeregisterListener(final EventListenerSupport<VetoableChangeListener> listenerSupport)
    {
        listenerSupport.addListener(new VetoableChangeListener()
        {
            @Override
            public void vetoableChange(final PropertyChangeEvent e)
            {
                listenerSupport.removeListener(this);
            }
        });
    }

    private VetoableChangeListener createListener(final List<VetoableChangeListener> calledListeners)
    {
        return new VetoableChangeListener()
        {
            @Override
            public void vetoableChange(final PropertyChangeEvent e)
            {
                calledListeners.add(this);
            }
        };
    }
}
