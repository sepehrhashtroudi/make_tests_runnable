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
 public void testAmbig380() { 
     FieldUtils.getField(Ambig.class, "VALUE"); 
 }
@Test
public void testReadNamedStaticField381() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(Foo.class, "VALUE")); 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(PubliclyShadowedChild.class, "VALUE")); 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE")); 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(PublicChild.class, "VALUE")); 
     try { 
         FieldUtils.readStaticField(null, "none"); 
         fail("null class should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readStaticField(Foo.class, null); 
         fail("null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readStaticField(Foo.class, "does_not_exist"); 
         fail("a field that doesn't exist should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readStaticField(PublicChild.class, "s"); 
         fail("non-static field should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedStaticFieldForceAccess382() throws Exception { 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePublic", "new", true); 
     assertEquals("new", StaticContainer.mutablePublic); 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new", true); 
     assertEquals("new", StaticContainer.getMutableProtected()); 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new", true); 
     assertEquals("new", StaticContainer.getMutablePackage()); 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new", true); 
     assertEquals("new", StaticContainer.getMutablePrivate()); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldForceAccessIllegalArgumentException2385() throws Exception { 
     final Field nonStaticField = FieldUtils.getField(PublicChild.class, "s", true); 
     assumeNotNull(nonStaticField); 
     FieldUtils.readStaticField(nonStaticField); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldIllegalArgumentException2386() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
     final Field nonStaticField = FieldUtils.getField(PublicChild.class, "s"); 
     assumeNotNull(nonStaticField); 
     FieldUtils.readStaticField(nonStaticField); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testWriteStaticFieldForceAccessIllegalArgumentException2387() throws Exception { 
     final Field nonStaticField = FieldUtils.getField(PublicChild.class, "s", true); 
     assumeNotNull(nonStaticField); 
     FieldUtils.writeStaticField(nonStaticField, "b", true); 
 }
@Test
public void testWriteNamedStaticField388() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
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
