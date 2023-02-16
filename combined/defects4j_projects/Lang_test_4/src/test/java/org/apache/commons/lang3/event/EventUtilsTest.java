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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.event.ObjectChangeListener;

import org.junit.Test;

/**
 * @since 3.0
 * @version $Id$
 */
public class EventUtilsTest 
{

@Test
public void testAddEventListenerThrowsException31() { 
     final ExceptionEventSource src = new ExceptionEventSource(); 
     try { 
         EventUtils.addEventListener(src, PropertyChangeListener.class, new PropertyChangeListener() { 
  
             @Override 
             public void propertyChange(final PropertyChangeEvent e) { 
             } 
             }); 
         fail("Add method should have thrown an exception, so method should fail."); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBindEventsToMethod32() { 
     final PropertyChangeSource src = new PropertyChangeSource(); 
     final EventCounter counter = new EventCounter(); 
     EventUtils.bindEventsToMethod(counter, "eventOccurred", src, PropertyChangeListener.class); 
     assertEquals(0, counter.getCount()); 
     src.setProperty("newValue"); 
     assertEquals(1, counter.getCount()); 
 }
    
    
    

    

    

    

    


    


    

    public static interface MultipleEventListener
    {
        public void event1(PropertyChangeEvent e);

        public void event2(PropertyChangeEvent e);
    }

    public static class EventCounter
    {
        private int count;

        public void eventOccurred()
        {
            count++;
        }

        public int getCount()
        {
            return count;
        }
    }

    public static class EventCounterWithEvent
    {
        private int count;

        public void eventOccurred(final PropertyChangeEvent e)
        {
            count++;
        }

        public int getCount()
        {
            return count;
        }
    }


    private static class EventCountingInvociationHandler implements InvocationHandler
    {
        private final Map<String, Integer> eventCounts = new TreeMap<String, Integer>();

        public <L> L createListener(final Class<L> listenerType)
        {
            return listenerType.cast(Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    new Class[]{listenerType},
                    this));
        }

        public int getEventCount(final String eventName)
        {
            final Integer count = eventCounts.get(eventName);
            return count == null ? 0 : count.intValue();
        }

        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable
        {
            final Integer count = eventCounts.get(method.getName());
            if (count == null)
            {
                eventCounts.put(method.getName(), Integer.valueOf(1));
            }
            else
            {
                eventCounts.put(method.getName(), Integer.valueOf(count.intValue() + 1));
            }
            return null;
        }
    }

    public static class MultipleEventSource
    {
        private final EventListenerSupport<MultipleEventListener> listeners = EventListenerSupport.create(MultipleEventListener.class);

        public void addMultipleEventListener(final MultipleEventListener listener)
        {
            listeners.addListener(listener);
        }
    }

    public static class ExceptionEventSource
    {
        public void addPropertyChangeListener(final PropertyChangeListener listener)
        {
            throw new RuntimeException();
        }
    }

    public static class PropertyChangeSource
    {
        private final EventListenerSupport<PropertyChangeListener> listeners = EventListenerSupport.create(PropertyChangeListener.class);

        private String property;

        public void setProperty(final String property)
        {
            final String oldValue = this.property;
            this.property = property;
            listeners.fire().propertyChange(new PropertyChangeEvent(this, "property", oldValue, property));
        }

        protected void addVetoableChangeListener(final VetoableChangeListener listener)
        {
            // Do nothing!
        }

        public void addPropertyChangeListener(final PropertyChangeListener listener)
        {
            listeners.addListener(listener);
        }

        public void removePropertyChangeListener(final PropertyChangeListener listener)
        {
            listeners.removeListener(listener);
        }
    }
}
