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
package org.apache.commons.lang3.reflect;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.testbed.Ambig;
import org.apache.commons.lang3.reflect.testbed.Foo;
import org.apache.commons.lang3.reflect.testbed.PrivatelyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.PublicChild;
import org.apache.commons.lang3.reflect.testbed.PubliclyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.StaticContainer;
import org.apache.commons.lang3.reflect.testbed.StaticContainerChild;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests FieldUtils
 * 
 * @version $Id$
 */
public class FieldUtilsTest {

    static final String S = "s";
    static final String SS = "ss";
    static final Integer I0 = Integer.valueOf(0);
    static final Integer I1 = Integer.valueOf(1);
    static final Double D0 = Double.valueOf(0.0);
    static final Double D1 = Double.valueOf(1.0);

    private PublicChild publicChild;
    private PubliclyShadowedChild publiclyShadowedChild;
    private PrivatelyShadowedChild privatelyShadowedChild;
    private final Class<?> parentClass = PublicChild.class.getSuperclass();

    @Before
    public void setUp() {
        StaticContainer.reset();
        publicChild = new PublicChild();
        publiclyShadowedChild = new PubliclyShadowedChild();
        privatelyShadowedChild = new PrivatelyShadowedChild();
    }

@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldForceAccessIllegalArgumentException2300() throws Exception { 
     final Field nonStaticField = FieldUtils.getField(PublicChild.class, "s", true); 
     assumeNotNull(nonStaticField); 
     FieldUtils.readStaticField(nonStaticField); 
 }
@Test
public void testWriteDeclaredNamedStaticField302() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED_PUBLIC", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
    

    

    

    

    

    

    

    

    private <T> List<T> asArrayList(T... values) {
        final ArrayList<T> arrayList = new ArrayList<T>();
        for (T t : values) {
            arrayList.add(t);
        }
        return arrayList;
    }

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
