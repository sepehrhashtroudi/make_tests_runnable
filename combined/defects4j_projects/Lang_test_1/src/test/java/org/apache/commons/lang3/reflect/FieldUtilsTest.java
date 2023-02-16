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

@Test
public void testReadDeclaredNamedStaticFieldForceAccess256() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testConstructor307() { 
     assertNotNull(new FieldUtils()); 
     final Constructor<?>[] cons = FieldUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(FieldUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(FieldUtils.class.getModifiers())); 
 }
@Test
public void testWriteNamedStaticField308() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadField309() throws Exception { 
     final Field parentS = FieldUtils.getDeclaredField(parentClass, "s"); 
     assertEquals("s", FieldUtils.readField(parentS, publicChild)); 
     assertEquals("s", FieldUtils.readField(parentS, publiclyShadowedChild)); 
     assertEquals("s", FieldUtils.readField(parentS, privatelyShadowedChild)); 
     final Field parentB = FieldUtils.getDeclaredField(parentClass, "b", true); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publicChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publiclyShadowedChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, privatelyShadowedChild)); 
     final Field parentI = FieldUtils.getDeclaredField(parentClass, "i", true); 
     assertEquals(I0, FieldUtils.readField(parentI, publicChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, publiclyShadowedChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, privatelyShadowedChild)); 
     final Field parentD = FieldUtils.getDeclaredField(parentClass, "d", true); 
     assertEquals(D0, FieldUtils.readField(parentD, publicChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, publiclyShadowedChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, privatelyShadowedChild)); 
     try { 
         FieldUtils.readField((Field) null, publicChild); 
         fail("a null field should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAmbig310() { 
     FieldUtils.getField(Ambig.class, "VALUE"); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testGetFieldForceAccessIllegalArgumentException2311() { 
     FieldUtils.getField(Ambig.class, "VALUE", true); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testGetDeclaredFieldAccessIllegalArgumentException1312() { 
     FieldUtils.getDeclaredField(null, "none"); 
 }
@Test
public void testWriteDeclaredNamedStaticFieldForceAccess313() throws Exception { 
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
@Test
public void testReadStaticFieldForceAccess314() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadNamedStaticFieldForceAccess315() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldIllegalArgumentException1316() throws Exception { 
     FieldUtils.readStaticField(null); 
 }
@Test
public void testReadNamedStaticField317() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(Foo.class, "VALUE")); 
     assertEquals("child", FieldUtils.readStaticField(PublicChild.class, "VALUE")); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(PubliclyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedField318() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredField(Foo.class, "VALUE")); 
     assertEquals("child", FieldUtils.readDeclaredField(PublicChild.class, "VALUE")); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredField(PubliclyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredField(PrivatelyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess320() throws Exception { 
     assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("s", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField(publicChild, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess322() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readDeclaredField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
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
